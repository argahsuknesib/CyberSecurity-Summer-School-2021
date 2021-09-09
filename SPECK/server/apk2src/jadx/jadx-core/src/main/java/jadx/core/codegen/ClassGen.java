package jadx.core.codegen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.android.dx.rop.code.AccessFlags;
import com.google.common.collect.Streams;

import jadx.api.ICodeInfo;
import jadx.api.JadxArgs;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.AttrNode;
import jadx.core.dex.attributes.nodes.EnumClassAttr;
import jadx.core.dex.attributes.nodes.EnumClassAttr.EnumField;
import jadx.core.dex.attributes.nodes.JadxError;
import jadx.core.dex.attributes.nodes.LineAttrNode;
import jadx.core.dex.info.AccessInfo;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.PrimitiveType;
import jadx.core.dex.instructions.mods.ConstructorInsn;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.FieldNode;
import jadx.core.dex.nodes.GenericTypeParameter;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.nodes.parser.FieldInitAttr;
import jadx.core.dex.nodes.parser.FieldInitAttr.InitType;
import jadx.core.utils.CodeGenUtils;
import jadx.core.utils.ErrorsCounter;
import jadx.core.utils.Utils;
import jadx.core.utils.exceptions.CodegenException;
import jadx.core.utils.exceptions.JadxRuntimeException;

public class ClassGen {

	private final ClassNode cls;
	private final ClassGen parentGen;
	private final AnnotationGen annotationGen;
	private final boolean fallback;
	private final boolean useImports;
	private final boolean showInconsistentCode;

	private final Set<ClassInfo> imports = new HashSet<>();
	private int clsDeclLine;

	private boolean bodyGenStarted;

	public ClassGen(ClassNode cls, JadxArgs jadxArgs) {
		this(cls, null, jadxArgs.isUseImports(), jadxArgs.isFallbackMode(), jadxArgs.isShowInconsistentCode());
	}

	public ClassGen(ClassNode cls, ClassGen parentClsGen) {
		this(cls, parentClsGen, parentClsGen.useImports, parentClsGen.fallback, parentClsGen.showInconsistentCode);
	}

	public ClassGen(ClassNode cls, ClassGen parentClsGen, boolean useImports, boolean fallback, boolean showBadCode) {
		this.cls = cls;
		this.parentGen = parentClsGen;
		this.fallback = fallback;
		this.useImports = useImports;
		this.showInconsistentCode = showBadCode;

		this.annotationGen = new AnnotationGen(cls, this);
	}

	public ClassNode getClassNode() {
		return cls;
	}

	public ICodeInfo makeClass() throws CodegenException {
		CodeWriter clsBody = new CodeWriter();
		addClassCode(clsBody);

		CodeWriter clsCode = new CodeWriter();
		if (!"".equals(cls.getPackage())) {
			clsCode.add("package ").add(cls.getPackage()).add(';');
			clsCode.newLine();
		}
		int importsCount = imports.size();
		if (importsCount != 0) {
			List<ClassInfo> sortedImports = new ArrayList<>(imports);
			sortedImports.sort(Comparator.comparing(ClassInfo::getAliasFullName));
			sortedImports.forEach(classInfo -> {
				clsCode.startLine("import ");
				ClassNode classNode = cls.root().resolveClass(classInfo);
				if (classNode != null) {
					clsCode.attachAnnotation(classNode);
				}
				clsCode.add(classInfo.getAliasFullName());
				clsCode.add(';');
			});
			clsCode.newLine();
			imports.clear();
		}
		clsCode.add(clsBody);
		return clsCode.finish();
	}

	public void addClassCode(CodeWriter code) throws CodegenException {
		if (cls.contains(AFlag.DONT_GENERATE)) {
			return;
		}
		CodeGenUtils.addComments(code, cls);
		insertDecompilationProblems(code, cls);
		addClassDeclaration(code);
		addClassBody(code);
	}

	public void addClassDeclaration(CodeWriter clsCode) {
		AccessInfo af = cls.getAccessFlags();
		if (af.isInterface()) {
			af = af.remove(AccessFlags.ACC_ABSTRACT)
					.remove(AccessFlags.ACC_STATIC);
		} else if (af.isEnum()) {
			af = af.remove(AccessFlags.ACC_FINAL)
					.remove(AccessFlags.ACC_ABSTRACT)
					.remove(AccessFlags.ACC_STATIC);
		}

		// 'static' and 'private' modifier not allowed for top classes (not inner)
		if (!cls.getClassInfo().isInner()) {
			af = af.remove(AccessFlags.ACC_STATIC).remove(AccessFlags.ACC_PRIVATE);
		}

		annotationGen.addForClass(clsCode);
		insertRenameInfo(clsCode, cls);
		CodeGenUtils.addSourceFileInfo(clsCode, cls);
		clsCode.startLineWithNum(cls.getSourceLine());
		clsCode.add(af.makeString());
		if (af.isInterface()) {
			if (af.isAnnotation()) {
				clsCode.add('@');
			}
			clsCode.add("interface ");
		} else if (af.isEnum()) {
			clsCode.add("enum ");
		} else {
			clsCode.add("class ");
		}
		clsCode.attachDefinition(cls);
		clsCode.add(cls.getClassInfo().getAliasShortName());

		addGenericTypeParameters(clsCode, cls.getGenericTypeParameters(), true);
		clsCode.add(' ');

		ArgType sup = cls.getSuperClass();
		if (sup != null
				&& !sup.equals(ArgType.OBJECT)
				&& !cls.isEnum()) {
			clsCode.add("extends ");
			useClass(clsCode, sup);
			clsCode.add(' ');
		}

		if (!cls.getInterfaces().isEmpty() && !af.isAnnotation()) {
			if (cls.getAccessFlags().isInterface()) {
				clsCode.add("extends ");
			} else {
				clsCode.add("implements ");
			}
			for (Iterator<ArgType> it = cls.getInterfaces().iterator(); it.hasNext();) {
				ArgType interf = it.next();
				useClass(clsCode, interf);
				if (it.hasNext()) {
					clsCode.add(", ");
				}
			}
			if (!cls.getInterfaces().isEmpty()) {
				clsCode.add(' ');
			}
		}
	}

	public boolean addGenericTypeParameters(CodeWriter code, List<GenericTypeParameter> generics, boolean classDeclaration) {
		if (generics == null || generics.isEmpty()) {
			return false;
		}
		code.add('<');
		int i = 0;
		for (GenericTypeParameter genericInfo : generics) {
			if (i != 0) {
				code.add(", ");
			}
			ArgType type = genericInfo.getTypeVariable();
			if (type.isGenericType()) {
				code.add(type.getObject());
			} else {
				useClass(code, type);
			}
			List<ArgType> list = genericInfo.getExtendsList();
			if (list != null && !list.isEmpty()) {
				code.add(" extends ");
				for (Iterator<ArgType> it = list.iterator(); it.hasNext();) {
					ArgType g = it.next();
					if (g.isGenericType()) {
						code.add(g.getObject());
					} else {
						useClass(code, g);
						if (classDeclaration
								&& !cls.getClassInfo().isInner()
								&& cls.root().getArgs().isUseImports()) {
							addImport(ClassInfo.fromType(cls.root(), g));
						}
					}
					if (it.hasNext()) {
						code.add(" & ");
					}
				}
			}
			i++;
		}
		code.add('>');
		return true;
	}

	public void addClassBody(CodeWriter clsCode) throws CodegenException {
		addClassBody(clsCode, false);
	}

	/**
	 *
	 * @param clsCode
	 * @param printClassName allows to print the original class name as comment (e.g. for inlined
	 *                       classes)
	 * @throws CodegenException
	 */
	public void addClassBody(CodeWriter clsCode, boolean printClassName) throws CodegenException {
		clsCode.add('{');
		setBodyGenStarted(true);
		clsDeclLine = clsCode.getLine();
		clsCode.incIndent();
		if (printClassName) {
			clsCode.startLine();
			clsCode.add("/* class " + cls.getFullName() + " */");
		}
		addFields(clsCode);
		addInnerClsAndMethods(clsCode);
		clsCode.decIndent();
		clsCode.startLine('}');
	}

	private void addInnerClsAndMethods(CodeWriter clsCode) {
		Streams.concat(cls.getInnerClasses().stream(), cls.getMethods().stream())
				.filter(node -> !node.contains(AFlag.DONT_GENERATE))
				.sorted(Comparator.comparingInt(LineAttrNode::getSourceLine))
				.forEach(node -> {
					if (node instanceof ClassNode) {
						addInnerClass(clsCode, (ClassNode) node);
					} else {
						addMethod(clsCode, (MethodNode) node);
					}
				});
	}

	private void addInnerClass(CodeWriter code, ClassNode innerCls) {
		try {
			ClassGen inClGen = new ClassGen(innerCls, getParentGen());
			code.newLine();
			inClGen.addClassCode(code);
			imports.addAll(inClGen.getImports());
		} catch (Exception e) {
			ErrorsCounter.classError(innerCls, "Inner class code generation error", e);
		}
	}

	private boolean isInnerClassesPresents() {
		for (ClassNode innerCls : cls.getInnerClasses()) {
			if (!innerCls.contains(AFlag.ANONYMOUS_CLASS)) {
				return true;
			}
		}
		return false;
	}

	private void addMethod(CodeWriter code, MethodNode mth) {
		if (code.getLine() != clsDeclLine) {
			code.newLine();
		}
		int savedIndent = code.getIndent();
		try {
			addMethodCode(code, mth);
		} catch (Exception e) {
			if (mth.getParentClass().getTopParentClass().contains(AFlag.RESTART_CODEGEN)) {
				throw new JadxRuntimeException("Method generation error", e);
			}
			code.newLine().add("/*");
			code.newLine().addMultiLine(ErrorsCounter.methodError(mth, "Method generation error", e));
			Utils.appendStackTrace(code, e);
			code.newLine().add("*/");
			code.setIndent(savedIndent);
			mth.addError("Method generation error: " + e.getMessage(), e);
		}
	}

	private boolean isMethodsPresents() {
		for (MethodNode mth : cls.getMethods()) {
			if (!mth.contains(AFlag.DONT_GENERATE)) {
				return true;
			}
		}
		return false;
	}

	public void addMethodCode(CodeWriter code, MethodNode mth) throws CodegenException {
		CodeGenUtils.addComments(code, mth);
		if (mth.getAccessFlags().isAbstract() || mth.getAccessFlags().isNative()) {
			MethodGen mthGen = new MethodGen(this, mth);
			mthGen.addDefinition(code);
			code.add(';');
		} else {
			insertDecompilationProblems(code, mth);
			boolean badCode = mth.contains(AFlag.INCONSISTENT_CODE);
			if (badCode && showInconsistentCode) {
				mth.remove(AFlag.INCONSISTENT_CODE);
				badCode = false;
			}
			MethodGen mthGen;
			if (badCode || fallback || mth.contains(AType.JADX_ERROR) || mth.getRegion() == null) {
				mthGen = MethodGen.getFallbackMethodGen(mth);
			} else {
				mthGen = new MethodGen(this, mth);
			}
			if (mthGen.addDefinition(code)) {
				code.add(' ');
			}
			code.add('{');
			code.incIndent();
			mthGen.addInstructions(code);
			code.decIndent();
			code.startLine('}');
		}
	}

	public void insertDecompilationProblems(CodeWriter code, AttrNode node) {
		List<JadxError> errors = node.getAll(AType.JADX_ERROR);
		if (!errors.isEmpty()) {
			errors.stream().distinct().sorted().forEach(err -> {
				code.startLine("/*  JADX ERROR: ").add(err.getError());
				Throwable cause = err.getCause();
				if (cause != null) {
					code.incIndent();
					Utils.appendStackTrace(code, cause);
					code.decIndent();
				}
				code.add("*/");
			});
		}
		List<String> warns = node.getAll(AType.JADX_WARN);
		if (!warns.isEmpty()) {
			warns.stream().distinct().sorted()
					.forEach(warn -> code.startLine("/* JADX WARNING: ").addMultiLine(warn).add(" */"));
		}
	}

	private void addFields(CodeWriter code) throws CodegenException {
		addEnumFields(code);
		for (FieldNode f : cls.getFields()) {
			addField(code, f);
		}
	}

	public void addField(CodeWriter code, FieldNode f) {
		if (f.contains(AFlag.DONT_GENERATE)) {
			return;
		}
		CodeGenUtils.addComments(code, f);
		annotationGen.addForField(code, f);

		if (f.getFieldInfo().isRenamed()) {
			code.newLine();
			CodeGenUtils.addRenamedComment(code, f, f.getName());
		}
		code.startLine(f.getAccessFlags().makeString());
		useType(code, f.getType());
		code.add(' ');
		code.attachDefinition(f);
		code.add(f.getAlias());
		FieldInitAttr fv = f.get(AType.FIELD_INIT);
		if (fv != null) {
			code.add(" = ");
			if (fv.getValue() == null) {
				code.add(TypeGen.literalToString(0, f.getType(), cls, fallback));
			} else {
				if (fv.getValueType() == InitType.CONST) {
					annotationGen.encodeValue(code, fv.getValue());
				} else if (fv.getValueType() == InitType.INSN) {
					InsnGen insnGen = makeInsnGen(fv.getInsnMth());
					addInsnBody(insnGen, code, fv.getInsn());
				}
			}
		}
		code.add(';');
	}

	private boolean isFieldsPresents() {
		for (FieldNode field : cls.getFields()) {
			if (!field.contains(AFlag.DONT_GENERATE)) {
				return true;
			}
		}
		return false;
	}

	private void addEnumFields(CodeWriter code) throws CodegenException {
		EnumClassAttr enumFields = cls.get(AType.ENUM_CLASS);
		if (enumFields == null) {
			return;
		}
		InsnGen igen = null;
		for (Iterator<EnumField> it = enumFields.getFields().iterator(); it.hasNext();) {
			EnumField f = it.next();
			code.startLine(f.getField().getAlias());
			ConstructorInsn constrInsn = f.getConstrInsn();
			if (constrInsn.getArgsCount() > f.getStartArg()) {
				if (igen == null) {
					igen = makeInsnGen(enumFields.getStaticMethod());
				}
				MethodNode callMth = cls.dex().resolveMethod(constrInsn.getCallMth());
				igen.generateMethodArguments(code, constrInsn, f.getStartArg(), callMth);
			}
			if (f.getCls() != null) {
				code.add(' ');
				new ClassGen(f.getCls(), this).addClassBody(code);
			}
			if (it.hasNext()) {
				code.add(',');
			}
		}
		if (isMethodsPresents() || isFieldsPresents() || isInnerClassesPresents()) {
			if (enumFields.getFields().isEmpty()) {
				code.startLine();
			}
			code.add(';');
			if (isFieldsPresents()) {
				code.startLine();
			}
		}
	}

	private InsnGen makeInsnGen(MethodNode mth) {
		MethodGen mthGen = new MethodGen(this, mth);
		return new InsnGen(mthGen, false);
	}

	private void addInsnBody(InsnGen insnGen, CodeWriter code, InsnNode insn) {
		try {
			insnGen.makeInsn(insn, code, InsnGen.Flags.BODY_ONLY_NOWRAP);
		} catch (Exception e) {
			ErrorsCounter.classError(cls, "Failed to generate init code", e);
		}
	}

	public void useType(CodeWriter code, ArgType type) {
		PrimitiveType stype = type.getPrimitiveType();
		if (stype == null) {
			code.add(type.toString());
		} else if (stype == PrimitiveType.OBJECT) {
			if (type.isGenericType()) {
				code.add(type.getObject());
			} else {
				useClass(code, type);
			}
		} else if (stype == PrimitiveType.ARRAY) {
			useType(code, type.getArrayElement());
			code.add("[]");
		} else {
			code.add(stype.getLongName());
		}
	}

	public void useClass(CodeWriter code, ArgType type) {
		ArgType outerType = type.getOuterType();
		if (outerType != null) {
			useClass(code, outerType);
			code.add('.');
			useClass(code, type.getInnerType());
			return;
		}

		useClass(code, ClassInfo.fromType(cls.root(), type));
		ArgType[] generics = type.getGenericTypes();
		if (generics != null) {
			code.add('<');
			int len = generics.length;
			for (int i = 0; i < len; i++) {
				if (i != 0) {
					code.add(", ");
				}
				ArgType gt = generics[i];
				ArgType wt = gt.getWildcardType();
				if (wt != null) {
					ArgType.WildcardBound bound = gt.getWildcardBound();
					code.add(bound.getStr());
					if (bound != ArgType.WildcardBound.UNBOUND) {
						useType(code, wt);
					}
				} else {
					useType(code, gt);
				}
			}
			code.add('>');
		}
	}

	public void useClass(CodeWriter code, ClassInfo classInfo) {
		ClassNode classNode = cls.dex().resolveClass(classInfo);
		if (classNode != null) {
			useClass(code, classNode);
		} else {
			addClsName(code, classInfo);
		}
	}

	public void useClass(CodeWriter code, ClassNode classNode) {
		code.attachAnnotation(classNode);
		addClsName(code, classNode.getClassInfo());
	}

	private void addClsName(CodeWriter code, ClassInfo classInfo) {
		String clsName = useClassInternal(cls.getClassInfo(), classInfo);
		code.add(clsName);
	}

	private String useClassInternal(ClassInfo useCls, ClassInfo extClsInfo) {
		String fullName = extClsInfo.getAliasFullName();
		if (fallback || !useImports) {
			return fullName;
		}
		String shortName = extClsInfo.getAliasShortName();
		if (extClsInfo.getPackage().equals("java.lang") && extClsInfo.getParentClass() == null) {
			return shortName;
		}
		if (isClassInnerFor(useCls, extClsInfo)) {
			return shortName;
		}
		if (extClsInfo.isInner()) {
			return expandInnerClassName(useCls, extClsInfo);
		}
		if (isBothClassesInOneTopClass(useCls, extClsInfo)) {
			return shortName;
		}
		// don't add import if this class from same package
		if (extClsInfo.getPackage().equals(useCls.getPackage()) && !extClsInfo.isInner()) {
			return shortName;
		}
		// don't add import if class not public (must be accessed using inheritance)
		ClassNode classNode = cls.dex().resolveClass(extClsInfo);
		if (classNode != null && !classNode.getAccessFlags().isPublic()) {
			return shortName;
		}
		if (searchCollision(cls.dex(), useCls, extClsInfo)) {
			return fullName;
		}
		// ignore classes from default package
		if (extClsInfo.isDefaultPackage()) {
			return shortName;
		}
		if (extClsInfo.getAliasPkg().equals(useCls.getAliasPkg())) {
			fullName = extClsInfo.getAliasNameWithoutPackage();
		}
		for (ClassInfo importCls : getImports()) {
			if (!importCls.equals(extClsInfo)
					&& importCls.getAliasShortName().equals(shortName)) {
				if (extClsInfo.isInner()) {
					String parent = useClassInternal(useCls, extClsInfo.getParentClass());
					return parent + '.' + shortName;
				} else {
					return fullName;
				}
			}
		}
		addImport(extClsInfo);
		return shortName;
	}

	private String expandInnerClassName(ClassInfo useCls, ClassInfo extClsInfo) {
		List<ClassInfo> clsList = new ArrayList<>();
		clsList.add(extClsInfo);
		ClassInfo parentCls = extClsInfo.getParentClass();
		boolean addImport = true;
		while (parentCls != null) {
			if (parentCls == useCls || isClassInnerFor(useCls, parentCls)) {
				addImport = false;
				break;
			}
			clsList.add(parentCls);
			parentCls = parentCls.getParentClass();
		}
		Collections.reverse(clsList);
		if (addImport) {
			addImport(clsList.get(0));
		}
		return Utils.listToString(clsList, ".", ClassInfo::getAliasShortName);
	}

	private void addImport(ClassInfo classInfo) {
		if (parentGen != null) {
			parentGen.addImport(classInfo);
		} else {
			imports.add(classInfo);
		}
	}

	public Set<ClassInfo> getImports() {
		if (parentGen != null) {
			return parentGen.getImports();
		} else {
			return imports;
		}
	}

	private static boolean isBothClassesInOneTopClass(ClassInfo useCls, ClassInfo extClsInfo) {
		ClassInfo a = useCls.getTopParentClass();
		ClassInfo b = extClsInfo.getTopParentClass();
		if (a != null) {
			return a.equals(b);
		}
		// useCls - is a top class
		return useCls.equals(b);
	}

	private static boolean isClassInnerFor(ClassInfo inner, ClassInfo parent) {
		if (inner.isInner()) {
			ClassInfo p = inner.getParentClass();
			return Objects.equals(p, parent) || isClassInnerFor(p, parent);
		}
		return false;
	}

	private static boolean searchCollision(DexNode dex, ClassInfo useCls, ClassInfo searchCls) {
		if (useCls == null) {
			return false;
		}
		String shortName = searchCls.getAliasShortName();
		if (useCls.getAliasShortName().equals(shortName)) {
			return true;
		}
		ClassNode classNode = dex.resolveClass(useCls);
		if (classNode != null) {
			for (ClassNode inner : classNode.getInnerClasses()) {
				if (inner.getShortName().equals(shortName)
						&& !inner.getFullName().equals(searchCls.getAliasFullName())) {
					return true;
				}
			}
		}
		return searchCollision(dex, useCls.getParentClass(), searchCls);
	}

	private void insertRenameInfo(CodeWriter code, ClassNode cls) {
		ClassInfo classInfo = cls.getClassInfo();
		if (classInfo.hasAlias()) {
			CodeGenUtils.addRenamedComment(code, cls, classInfo.getType().getObject());
		}
	}

	public ClassGen getParentGen() {
		return parentGen == null ? this : parentGen;
	}

	public AnnotationGen getAnnotationGen() {
		return annotationGen;
	}

	public boolean isFallbackMode() {
		return fallback;
	}

	public boolean isBodyGenStarted() {
		return bodyGenStarted;
	}

	public void setBodyGenStarted(boolean bodyGenStarted) {
		this.bodyGenStarted = bodyGenStarted;
	}
}
