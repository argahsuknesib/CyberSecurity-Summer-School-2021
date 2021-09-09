package jadx.core.dex.visitors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jetbrains.annotations.Nullable;

import com.android.dx.rop.code.AccessFlags;

import jadx.core.codegen.TypeGen;
import jadx.core.deobf.NameMapper;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.nodes.EnumClassAttr;
import jadx.core.dex.attributes.nodes.EnumClassAttr.EnumField;
import jadx.core.dex.info.AccessInfo;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.IndexInsnNode;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.InsnWrapArg;
import jadx.core.dex.instructions.args.LiteralArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.instructions.mods.ConstructorInsn;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.FieldNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.visitors.shrink.CodeShrinkVisitor;
import jadx.core.utils.BlockInsnPair;
import jadx.core.utils.InsnRemover;
import jadx.core.utils.InsnUtils;
import jadx.core.utils.exceptions.JadxException;

@JadxVisitor(
		name = "EnumVisitor",
		desc = "Restore enum classes",
		runAfter = { CodeShrinkVisitor.class, ModVisitor.class },
		runBefore = { ExtractFieldInit.class }
)
public class EnumVisitor extends AbstractVisitor {

	@Override
	public boolean visit(ClassNode cls) throws JadxException {
		if (!convertToEnum(cls)) {
			AccessInfo accessFlags = cls.getAccessFlags();
			if (accessFlags.isEnum()) {
				cls.setAccessFlags(accessFlags.remove(AccessFlags.ACC_ENUM));
				cls.addAttr(AType.COMMENTS, "JADX INFO: Failed to restore enum class, 'enum' modifier removed");
			}
		}
		return true;
	}

	private boolean convertToEnum(ClassNode cls) {
		if (!cls.isEnum()) {
			return false;
		}
		MethodNode classInitMth = cls.getClassInitMth();
		if (classInitMth == null) {
			cls.addAttr(AType.COMMENTS, "JADX INFO: Enum class init method not found");
			return false;
		}
		if (classInitMth.getBasicBlocks().isEmpty()) {
			return false;
		}
		ArgType clsType = cls.getClassInfo().getType();

		// search "$VALUES" field (holds all enum values)
		List<FieldNode> valuesCandidates = cls.getFields().stream()
				.filter(f -> f.getAccessFlags().isStatic())
				.filter(f -> f.getType().isArray())
				.filter(f -> Objects.equals(f.getType().getArrayRootElement(), clsType))
				.collect(Collectors.toList());

		if (valuesCandidates.isEmpty()) {
			return false;
		}
		if (valuesCandidates.size() > 1) {
			valuesCandidates.removeIf(f -> !f.getAccessFlags().isSynthetic());
		}
		if (valuesCandidates.size() > 1) {
			Optional<FieldNode> valuesOpt = valuesCandidates.stream().filter(f -> f.getName().equals("$VALUES")).findAny();
			if (valuesOpt.isPresent()) {
				valuesCandidates.clear();
				valuesCandidates.add(valuesOpt.get());
			}
		}
		if (valuesCandidates.size() != 1) {
			cls.addAttr(AType.COMMENTS, "JADX INFO: found several \"values\" enum fields: " + valuesCandidates);
			return false;
		}
		FieldNode valuesField = valuesCandidates.get(0);
		List<InsnNode> toRemove = new ArrayList<>();

		// search "$VALUES" array init and collect enum fields
		BlockInsnPair valuesInitPair = getValuesInitInsn(classInitMth, valuesField);
		if (valuesInitPair == null) {
			return false;
		}
		BlockNode staticBlock = valuesInitPair.getBlock();
		InsnNode valuesInitInsn = valuesInitPair.getInsn();

		List<EnumField> enumFields = null;
		InsnArg arrArg = valuesInitInsn.getArg(0);
		if (arrArg.isInsnWrap()) {
			InsnNode arrFillInsn = ((InsnWrapArg) arrArg).getWrapInsn();
			InsnType insnType = arrFillInsn.getType();
			if (insnType == InsnType.FILLED_NEW_ARRAY) {
				enumFields = extractEnumFields(cls, arrFillInsn, staticBlock, toRemove);
			} else if (insnType == InsnType.NEW_ARRAY) {
				// empty enum
				InsnArg arg = arrFillInsn.getArg(0);
				if (arg.isLiteral() && ((LiteralArg) arg).getLiteral() == 0) {
					enumFields = Collections.emptyList();
				}
			}
		}
		if (enumFields == null) {
			return false;
		}
		toRemove.add(valuesInitInsn);

		// all checks complete, perform transform
		EnumClassAttr attr = new EnumClassAttr(enumFields.size());
		attr.setStaticMethod(classInitMth);
		attr.getFields().addAll(enumFields);
		cls.addAttr(attr);

		for (EnumField field : attr.getFields()) {
			ConstructorInsn co = field.getConstrInsn();
			FieldNode fieldNode = field.getField();

			// use string arg from the constructor as enum field name
			String name = getConstString(cls.dex(), co.getArg(0));
			if (name != null
					&& !fieldNode.getAlias().equals(name)
					&& NameMapper.isValidAndPrintable(name)
					&& cls.root().getArgs().isRenameValid()) {
				fieldNode.getFieldInfo().setAlias(name);
			}
			if (!co.getClassType().equals(cls.getClassInfo())) {
				// enum contains additional methods
				for (ClassNode innerCls : cls.getInnerClasses()) {
					processEnumInnerCls(co, field, innerCls);
				}
			}
		}

		valuesField.add(AFlag.DONT_GENERATE);
		enumFields.forEach(f -> f.getField().add(AFlag.DONT_GENERATE));
		InsnRemover.removeAllAndUnbind(classInitMth, staticBlock, toRemove);
		if (classInitMth.countInsns() == 0) {
			classInitMth.add(AFlag.DONT_GENERATE);
		}
		removeEnumMethods(cls, clsType);
		return true;
	}

	private BlockInsnPair getValuesInitInsn(MethodNode classInitMth, FieldNode valuesField) {
		FieldInfo searchField = valuesField.getFieldInfo();
		for (BlockNode blockNode : classInitMth.getBasicBlocks()) {
			for (InsnNode insn : blockNode.getInstructions()) {
				if (insn.getType() == InsnType.SPUT) {
					IndexInsnNode indexInsnNode = (IndexInsnNode) insn;
					FieldInfo f = (FieldInfo) indexInsnNode.getIndex();
					if (f.equals(searchField)) {
						return new BlockInsnPair(blockNode, indexInsnNode);
					}
				}
			}
		}
		return null;
	}

	private List<EnumField> extractEnumFields(ClassNode cls, InsnNode arrFillInsn, BlockNode staticBlock, List<InsnNode> toRemove) {
		List<EnumField> enumFields = new ArrayList<>();
		for (InsnArg arg : arrFillInsn.getArguments()) {
			EnumField field = null;
			if (arg.isInsnWrap()) {
				InsnNode wrappedInsn = ((InsnWrapArg) arg).getWrapInsn();
				field = processEnumFieldByField(cls, wrappedInsn, staticBlock, toRemove);
			} else if (arg.isRegister()) {
				field = processEnumFiledByRegister(cls, ((RegisterArg) arg), toRemove);
			}
			if (field == null) {
				return null;
			}
			enumFields.add(field);
		}
		return enumFields;
	}

	@Nullable
	private EnumField processEnumFieldByField(ClassNode cls, InsnNode sgetInsn, BlockNode staticBlock, List<InsnNode> toRemove) {
		if (sgetInsn.getType() != InsnType.SGET) {
			return null;
		}
		FieldInfo fieldInfo = (FieldInfo) ((IndexInsnNode) sgetInsn).getIndex();
		FieldNode enumFieldNode = cls.searchField(fieldInfo);
		if (enumFieldNode == null) {
			return null;
		}
		InsnNode sputInsn = searchFieldPutInsn(cls, staticBlock, enumFieldNode);
		if (sputInsn == null) {
			return null;
		}

		ConstructorInsn co = getConstructorInsn(sputInsn);
		if (co == null) {
			return null;
		}
		toRemove.add(sgetInsn);
		toRemove.add(sputInsn);
		toRemove.add(co);
		return createEnumFieldByConstructor(cls, enumFieldNode, co);
	}

	@Nullable
	private EnumField processEnumFiledByRegister(ClassNode cls, RegisterArg arg, List<InsnNode> toRemove) {
		SSAVar ssaVar = arg.getSVar();
		if (ssaVar.getUseCount() == 1) {
			return null;
		}
		final InsnNode sputInsn = ssaVar.getUseList().get(0).getParentInsn();
		if (sputInsn == null || sputInsn.getType() != InsnType.SPUT) {
			return null;
		}
		FieldInfo fieldInfo = (FieldInfo) ((IndexInsnNode) sputInsn).getIndex();
		FieldNode enumFieldNode = cls.searchField(fieldInfo);
		if (enumFieldNode == null) {
			return null;
		}

		InsnNode constrInsn = ssaVar.getAssign().getParentInsn();
		if (constrInsn == null || constrInsn.getType() != InsnType.CONSTRUCTOR) {
			return null;
		}
		toRemove.add(sputInsn);
		toRemove.add(constrInsn);
		return createEnumFieldByConstructor(cls, enumFieldNode, (ConstructorInsn) constrInsn);
	}

	private EnumField createEnumFieldByConstructor(ClassNode cls, FieldNode enumFieldNode, ConstructorInsn co) {
		// usually constructor signature is '<init>(Ljava/lang/String;I)V'.
		// sometimes for one field enum second arg can be omitted
		if (co.getArgsCount() < 1) {
			return null;
		}
		ClassInfo clsInfo = co.getClassType();
		ClassNode constrCls = cls.dex().resolveClass(clsInfo);
		if (constrCls == null) {
			return null;
		}
		if (!clsInfo.equals(cls.getClassInfo()) && !constrCls.getAccessFlags().isEnum()) {
			return null;
		}
		int startArg = co.getArgsCount() == 1 ? 1 : 2;
		return new EnumField(enumFieldNode, co, startArg);
	}

	@Nullable
	private InsnNode searchFieldPutInsn(ClassNode cls, BlockNode staticBlock, FieldNode enumFieldNode) {
		for (InsnNode sputInsn : staticBlock.getInstructions()) {
			if (sputInsn != null && sputInsn.getType() == InsnType.SPUT) {
				FieldInfo f = (FieldInfo) ((IndexInsnNode) sputInsn).getIndex();
				FieldNode fieldNode = cls.searchField(f);
				if (Objects.equals(fieldNode, enumFieldNode)) {
					return sputInsn;
				}
			}
		}
		return null;
	}

	// TODO: detect these methods by analyzing method instructions
	private void removeEnumMethods(ClassNode cls, ArgType clsType) {
		String enumConstructor = "<init>(Ljava/lang/String;I)V";
		String enumConstructorAlt = "<init>(Ljava/lang/String;)V";
		String valuesOfMethod = "valueOf(Ljava/lang/String;)" + TypeGen.signature(clsType);
		String valuesMethod = "values()" + TypeGen.signature(ArgType.array(clsType));

		// remove synthetic methods
		for (MethodNode mth : cls.getMethods()) {
			MethodInfo mi = mth.getMethodInfo();
			if (mi.isClassInit()) {
				continue;
			}
			String shortId = mi.getShortId();
			boolean isSynthetic = mth.getAccessFlags().isSynthetic();
			if (mi.isConstructor() && !isSynthetic) {
				if (shortId.equals(enumConstructor)
						|| shortId.equals(enumConstructorAlt)) {
					mth.add(AFlag.DONT_GENERATE);
				}
			} else if (isSynthetic
					|| shortId.equals(valuesMethod)
					|| shortId.equals(valuesOfMethod)) {
				mth.add(AFlag.DONT_GENERATE);
			}
		}
	}

	private static void processEnumInnerCls(ConstructorInsn co, EnumField field, ClassNode innerCls) {
		if (!innerCls.getClassInfo().equals(co.getClassType())) {
			return;
		}
		// remove constructor, because it is anonymous class
		for (MethodNode innerMth : innerCls.getMethods()) {
			if (innerMth.getAccessFlags().isConstructor()) {
				innerMth.add(AFlag.DONT_GENERATE);
			}
		}
		field.setCls(innerCls);
		innerCls.add(AFlag.DONT_GENERATE);
	}

	private ConstructorInsn getConstructorInsn(InsnNode insn) {
		if (insn.getArgsCount() != 1) {
			return null;
		}
		InsnArg arg = insn.getArg(0);
		if (arg.isInsnWrap()) {
			return castConstructorInsn(((InsnWrapArg) arg).getWrapInsn());
		}
		if (arg.isRegister()) {
			return castConstructorInsn(((RegisterArg) arg).getAssignInsn());
		}
		return null;
	}

	@Nullable
	private ConstructorInsn castConstructorInsn(InsnNode coCandidate) {
		if (coCandidate != null && coCandidate.getType() == InsnType.CONSTRUCTOR) {
			return (ConstructorInsn) coCandidate;
		}
		return null;
	}

	private String getConstString(DexNode dex, InsnArg arg) {
		if (arg.isInsnWrap()) {
			InsnNode constInsn = ((InsnWrapArg) arg).getWrapInsn();
			Object constValue = InsnUtils.getConstValueByInsn(dex, constInsn);
			if (constValue instanceof String) {
				return (String) constValue;
			}
		}
		return null;
	}
}
