package jadx.core.dex.visitors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jadx.core.Consts;
import jadx.core.deobf.NameMapper;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.ArithNode;
import jadx.core.dex.instructions.ArithOp;
import jadx.core.dex.instructions.ConstStringNode;
import jadx.core.dex.instructions.FilledNewArrayNode;
import jadx.core.dex.instructions.IfNode;
import jadx.core.dex.instructions.IndexInsnNode;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.InvokeNode;
import jadx.core.dex.instructions.InvokeType;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.InsnArg;
import jadx.core.dex.instructions.args.InsnWrapArg;
import jadx.core.dex.instructions.args.LiteralArg;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.instructions.mods.ConstructorInsn;
import jadx.core.dex.instructions.mods.TernaryInsn;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.nodes.RootNode;
import jadx.core.dex.regions.conditions.IfCondition;
import jadx.core.dex.visitors.shrink.CodeShrinkVisitor;
import jadx.core.utils.BlockUtils;
import jadx.core.utils.InsnList;
import jadx.core.utils.InsnRemover;
import jadx.core.utils.exceptions.JadxRuntimeException;

public class SimplifyVisitor extends AbstractVisitor {

	private static final Logger LOG = LoggerFactory.getLogger(SimplifyVisitor.class);

	private MethodInfo stringGetBytesMth;

	@Override
	public void init(RootNode root) {
		stringGetBytesMth = MethodInfo.fromDetails(
				root,
				ClassInfo.fromType(root, ArgType.STRING),
				"getBytes",
				Collections.emptyList(),
				ArgType.array(ArgType.BYTE));
	}

	@Override
	public void visit(MethodNode mth) {
		if (mth.isNoCode()) {
			return;
		}
		boolean changed = false;
		for (BlockNode block : mth.getBasicBlocks()) {
			if (simplifyBlock(mth, block)) {
				changed = true;
			}
		}
		if (changed) {
			CodeShrinkVisitor.shrinkMethod(mth);
		}
	}

	private boolean simplifyBlock(MethodNode mth, BlockNode block) {
		boolean changed = false;
		List<InsnNode> list = block.getInstructions();
		for (int i = 0; i < list.size(); i++) {
			InsnNode insn = list.get(i);
			int insnCount = list.size();
			InsnNode modInsn = simplifyInsn(mth, insn);
			if (modInsn != null) {
				modInsn.rebindArgs();
				if (i < list.size() && list.get(i) == insn) {
					list.set(i, modInsn);
				} else {
					int idx = InsnList.getIndex(list, insn);
					if (idx == -1) {
						throw new JadxRuntimeException("Failed to replace insn");
					}
					list.set(idx, modInsn);
				}
				if (list.size() < insnCount) {
					// some insns removed => restart block processing
					simplifyBlock(mth, block);
					return true;
				}
				changed = true;
			}
		}
		return changed;
	}

	private void simplifyArgs(MethodNode mth, InsnNode insn) {
		boolean changed = false;
		for (InsnArg arg : insn.getArguments()) {
			if (arg.isInsnWrap()) {
				InsnNode wrapInsn = ((InsnWrapArg) arg).getWrapInsn();
				InsnNode replaceInsn = simplifyInsn(mth, wrapInsn);
				if (replaceInsn != null) {
					arg.wrapInstruction(mth, replaceInsn);
					InsnRemover.unbindInsn(mth, wrapInsn);
					changed = true;
				}
			}
		}
		if (changed) {
			insn.rebindArgs();
		}
	}

	private InsnNode simplifyInsn(MethodNode mth, InsnNode insn) {
		if (insn.contains(AFlag.DONT_GENERATE)) {
			return null;
		}
		simplifyArgs(mth, insn);
		switch (insn.getType()) {
			case ARITH:
				return simplifyArith((ArithNode) insn);

			case IF:
				simplifyIf((IfNode) insn);
				break;
			case TERNARY:
				simplifyTernary((TernaryInsn) insn);
				break;

			case INVOKE:
				return convertInvoke(mth, (InvokeNode) insn);

			case IPUT:
			case SPUT:
				return convertFieldArith(mth, insn);

			case CHECK_CAST:
				return processCast(mth, (IndexInsnNode) insn);

			case MOVE:
				InsnArg firstArg = insn.getArg(0);
				if (firstArg.isLiteral()) {
					InsnNode constInsn = new InsnNode(InsnType.CONST, 1);
					constInsn.setResult(insn.getResult());
					constInsn.addArg(firstArg);
					constInsn.copyAttributesFrom(insn);
					return constInsn;
				}
				break;

			case CONSTRUCTOR:
				return simplifyStringConstructor(mth, (ConstructorInsn) insn);

			default:
				break;
		}
		return null;
	}

	private InsnNode simplifyStringConstructor(MethodNode mth, ConstructorInsn insn) {
		if (insn.getCallMth().getDeclClass().getType().equals(ArgType.STRING)
				&& insn.getArgsCount() != 0
				&& insn.getArg(0).isInsnWrap()) {
			InsnNode arrInsn = ((InsnWrapArg) insn.getArg(0)).getWrapInsn();
			if (arrInsn.getType() == InsnType.FILLED_NEW_ARRAY
					&& arrInsn.getArgsCount() != 0) {
				ArgType elemType = ((FilledNewArrayNode) arrInsn).getElemType();
				if (elemType == ArgType.BYTE || elemType == ArgType.CHAR) {
					int printable = 0;
					byte[] arr = new byte[arrInsn.getArgsCount()];
					for (int i = 0; i < arr.length; i++) {
						InsnArg arrArg = arrInsn.getArg(i);
						if (!arrArg.isLiteral()) {
							return null;
						}
						arr[i] = (byte) ((LiteralArg) arrArg).getLiteral();
						if (NameMapper.isPrintableChar(arr[i])) {
							printable++;
						}
					}
					if (printable >= arr.length - printable) {
						InsnNode constStr = new ConstStringNode(new String(arr));
						if (insn.getArgsCount() == 1) {
							constStr.setResult(insn.getResult());
							constStr.copyAttributesFrom(insn);
							InsnRemover.unbindArgUsage(mth, insn.getArg(0));
							return constStr;
						} else {
							InvokeNode in = new InvokeNode(stringGetBytesMth, InvokeType.VIRTUAL, 1);
							in.addArg(InsnArg.wrapArg(constStr));
							InsnArg bytesArg = InsnArg.wrapArg(in);
							bytesArg.setType(stringGetBytesMth.getReturnType());
							insn.setArg(0, bytesArg);
							return null;
						}
					}
				}
			}
		}
		return null;
	}

	private static InsnNode processCast(MethodNode mth, IndexInsnNode castInsn) {
		if (castInsn.contains(AFlag.EXPLICIT_CAST)) {
			return null;
		}
		InsnArg castArg = castInsn.getArg(0);
		ArgType argType = castArg.getType();

		// Don't removes CHECK_CAST for wrapped INVOKE if invoked method returns different type
		if (castArg.isInsnWrap()) {
			InsnNode wrapInsn = ((InsnWrapArg) castArg).getWrapInsn();
			if (wrapInsn.getType() == InsnType.INVOKE) {
				argType = ((InvokeNode) wrapInsn).getCallMth().getReturnType();
			}
		}

		ArgType castToType = (ArgType) castInsn.getIndex();
		if (!ArgType.isCastNeeded(mth.root(), argType, castToType)
				|| isCastDuplicate(castInsn)) {
			InsnNode insnNode = new InsnNode(InsnType.MOVE, 1);
			insnNode.setOffset(castInsn.getOffset());
			insnNode.setResult(castInsn.getResult());
			insnNode.addArg(castArg);
			return insnNode;
		}
		return null;
	}

	private static boolean isCastDuplicate(IndexInsnNode castInsn) {
		InsnArg arg = castInsn.getArg(0);
		if (arg.isRegister()) {
			SSAVar sVar = ((RegisterArg) arg).getSVar();
			if (sVar != null && sVar.getUseCount() == 1 && !sVar.isUsedInPhi()) {
				InsnNode assignInsn = sVar.getAssign().getParentInsn();
				if (assignInsn != null && assignInsn.getType() == InsnType.CHECK_CAST) {
					ArgType assignCastType = (ArgType) ((IndexInsnNode) assignInsn).getIndex();
					return assignCastType.equals(castInsn.getIndex());
				}
			}
		}
		return false;
	}

	/**
	 * Simplify 'cmp' instruction in if condition
	 */
	private static void simplifyIf(IfNode insn) {
		InsnArg f = insn.getArg(0);
		if (f.isInsnWrap()) {
			InsnNode wi = ((InsnWrapArg) f).getWrapInsn();
			if (wi.getType() == InsnType.CMP_L || wi.getType() == InsnType.CMP_G) {
				if (insn.getArg(1).isLiteral()
						&& ((LiteralArg) insn.getArg(1)).getLiteral() == 0) {
					insn.changeCondition(insn.getOp(), wi.getArg(0), wi.getArg(1));
				} else {
					LOG.warn("TODO: cmp {}", insn);
				}
			}
		}
	}

	/**
	 * Simplify condition in ternary operation
	 */
	private static void simplifyTernary(TernaryInsn insn) {
		IfCondition condition = insn.getCondition();
		if (condition.isCompare()) {
			simplifyIf(condition.getCompare().getInsn());
		} else {
			insn.simplifyCondition();
		}
	}

	/**
	 * Simplify chains of calls to StringBuilder#append() plus constructor of StringBuilder.
	 * Those chains are usually automatically generated by the Java compiler when you create String
	 * concatenations like <code>"text " + 1 + " text"</code>.
	 */
	private static InsnNode convertInvoke(MethodNode mth, InvokeNode insn) {
		MethodInfo callMth = insn.getCallMth();

		if (callMth.getDeclClass().getFullName().equals(Consts.CLASS_STRING_BUILDER)
				&& callMth.getShortId().equals(Consts.MTH_TOSTRING_SIGNATURE)) {
			InsnArg instanceArg = insn.getArg(0);
			if (instanceArg.isInsnWrap()) {
				// Convert 'new StringBuilder(xxx).append(yyy).append(zzz).toString() to STRING_CONCAT insn
				List<InsnNode> callChain = flattenInsnChainUntil(insn, InsnType.CONSTRUCTOR);
				return convertStringBuilderChain(mth, insn, callChain);
			}
			if (instanceArg.isRegister()) {
				// Convert 'StringBuilder sb = new StringBuilder(xxx); sb.append(yyy); String str = sb.toString();'
				List<InsnNode> useChain = collectUseChain(mth, insn, (RegisterArg) instanceArg);
				return convertStringBuilderChain(mth, insn, useChain);
			}
		}
		return null;
	}

	private static List<InsnNode> collectUseChain(MethodNode mth, InvokeNode insn, RegisterArg instanceArg) {
		SSAVar sVar = instanceArg.getSVar();
		if (sVar.isUsedInPhi() || sVar.getUseCount() == 0) {
			return Collections.emptyList();
		}
		List<InsnNode> useChain = new ArrayList<>(sVar.getUseCount() + 1);
		InsnNode assignInsn = sVar.getAssign().getParentInsn();
		if (assignInsn == null) {
			return Collections.emptyList();
		}
		useChain.add(assignInsn);
		for (RegisterArg reg : sVar.getUseList()) {
			InsnNode parentInsn = reg.getParentInsn();
			if (parentInsn == null) {
				return Collections.emptyList();
			}
			useChain.add(parentInsn);
		}
		int toStrIdx = InsnList.getIndex(useChain, insn);
		if (useChain.size() - 1 != toStrIdx) {
			return Collections.emptyList();
		}
		useChain.remove(toStrIdx);

		// all insns must be in one block and sequential
		BlockNode assignBlock = BlockUtils.getBlockByInsn(mth, assignInsn);
		if (assignBlock == null) {
			return Collections.emptyList();
		}
		List<InsnNode> blockInsns = assignBlock.getInstructions();
		int assignIdx = InsnList.getIndex(blockInsns, assignInsn);
		int chainSize = useChain.size();
		int lastInsn = blockInsns.size() - assignIdx;
		if (lastInsn < chainSize) {
			return Collections.emptyList();
		}
		for (int i = 1; i < chainSize; i++) {
			if (blockInsns.get(assignIdx + i) != useChain.get(i)) {
				return Collections.emptyList();
			}
		}
		return useChain;
	}

	private static InsnNode convertStringBuilderChain(MethodNode mth, InvokeNode toStrInsn, List<InsnNode> chain) {
		try {
			int chainSize = chain.size();
			if (chainSize < 2) {
				return null;
			}
			List<InsnArg> args = new ArrayList<>(chainSize);
			InsnNode firstInsn = chain.get(0);
			if (firstInsn.getType() != InsnType.CONSTRUCTOR) {
				return null;
			}
			ConstructorInsn constrInsn = (ConstructorInsn) firstInsn;
			if (constrInsn.getArgsCount() == 1) {
				ArgType argType = constrInsn.getCallMth().getArgumentsTypes().get(0);
				if (!argType.isObject()) {
					return null;
				}
				args.add(constrInsn.getArg(0));
			}
			for (int i = 1; i < chainSize; i++) {
				InsnNode chainInsn = chain.get(i);
				InsnArg arg = getArgFromAppend(chainInsn);
				if (arg == null) {
					return null;
				}
				args.add(arg);
			}

			boolean stringArgFound = false;
			for (InsnArg arg : args) {
				if (arg.getType().equals(ArgType.STRING)) {
					stringArgFound = true;
					break;
				}
			}
			if (!stringArgFound) {
				// TODO: convert one arg to string using `String.valueOf()`
				return null;
			}

			// all check passed
			removeStringBuilderInsns(mth, toStrInsn, chain);

			InsnNode concatInsn = new InsnNode(InsnType.STR_CONCAT, args);
			concatInsn.setResult(toStrInsn.getResult());
			concatInsn.add(AFlag.SYNTHETIC);
			concatInsn.copyAttributesFrom(toStrInsn);
			concatInsn.remove(AFlag.DONT_GENERATE);
			concatInsn.remove(AFlag.REMOVE);
			return concatInsn;
		} catch (Exception e) {
			LOG.warn("Can't convert string concatenation: {} insn: {}", mth, toStrInsn, e);
		}
		return null;
	}

	/**
	 * Remove and unbind all instructions with StringBuilder
	 */
	private static void removeStringBuilderInsns(MethodNode mth, InvokeNode toStrInsn, List<InsnNode> chain) {
		InsnRemover.unbindAllArgs(mth, toStrInsn);
		for (InsnNode insnNode : chain) {
			InsnRemover.unbindAllArgs(mth, insnNode);
		}
		InsnRemover insnRemover = new InsnRemover(mth);
		for (InsnNode insnNode : chain) {
			if (insnNode != toStrInsn) {
				insnRemover.addAndUnbind(insnNode);
			}
		}
		insnRemover.perform();
	}

	private static List<InsnNode> flattenInsnChainUntil(InsnNode insn, InsnType insnType) {
		List<InsnNode> chain = new ArrayList<>();
		InsnArg arg = insn.getArg(0);
		while (arg.isInsnWrap()) {
			InsnNode wrapInsn = ((InsnWrapArg) arg).getWrapInsn();
			chain.add(wrapInsn);
			if (wrapInsn.getType() == insnType
					|| wrapInsn.getArgsCount() == 0) {
				break;
			}
			arg = wrapInsn.getArg(0);
		}
		Collections.reverse(chain);
		return chain;
	}

	private static InsnArg getArgFromAppend(InsnNode chainInsn) {
		if (chainInsn.getType() == InsnType.INVOKE && chainInsn.getArgsCount() == 2) {
			MethodInfo callMth = ((InvokeNode) chainInsn).getCallMth();
			if (callMth.getDeclClass().getFullName().equals(Consts.CLASS_STRING_BUILDER)
					&& callMth.getName().equals("append")) {
				return chainInsn.getArg(1);
			}
		}
		return null;
	}

	private static InsnNode simplifyArith(ArithNode arith) {
		if (arith.getArgsCount() != 2) {
			return null;
		}
		InsnArg litArg = null;
		InsnArg secondArg = arith.getArg(1);
		if (secondArg.isInsnWrap()) {
			InsnNode wr = ((InsnWrapArg) secondArg).getWrapInsn();
			if (wr.getType() == InsnType.CONST) {
				litArg = wr.getArg(0);
			}
		} else if (secondArg.isLiteral()) {
			litArg = secondArg;
		}
		if (litArg != null) {
			long lit = ((LiteralArg) litArg).getLiteral();
			// fix 'c + (-1)' => 'c - (1)'
			if (arith.getOp() == ArithOp.ADD && lit < 0) {
				return new ArithNode(ArithOp.SUB,
						arith.getResult(), arith.getArg(0),
						InsnArg.lit(-lit, litArg.getType()));
			}
			InsnArg firstArg = arith.getArg(0);
			if (arith.getOp() == ArithOp.XOR && firstArg.getType() == ArgType.BOOLEAN
					&& (lit == 0 || lit == 1)) {
				InsnNode node = new InsnNode(lit == 0 ? InsnType.MOVE : InsnType.NOT, 1);
				node.setResult(arith.getResult());
				node.addArg(firstArg);
				return node;
			}
		}
		return null;
	}

	/**
	 * Convert field arith operation to arith instruction
	 * (IPUT (ARITH (IGET, lit)) -> ARITH ((IGET)) <op>= lit))
	 */
	private static ArithNode convertFieldArith(MethodNode mth, InsnNode insn) {
		InsnArg arg = insn.getArg(0);
		if (!arg.isInsnWrap()) {
			return null;
		}
		InsnNode wrap = ((InsnWrapArg) arg).getWrapInsn();
		InsnType wrapType = wrap.getType();
		if (wrapType != InsnType.ARITH && wrapType != InsnType.STR_CONCAT
				|| !wrap.getArg(0).isInsnWrap()) {
			return null;
		}
		InsnNode get = ((InsnWrapArg) wrap.getArg(0)).getWrapInsn();
		InsnType getType = get.getType();
		if (getType != InsnType.IGET && getType != InsnType.SGET) {
			return null;
		}
		FieldInfo field = (FieldInfo) ((IndexInsnNode) insn).getIndex();
		FieldInfo innerField = (FieldInfo) ((IndexInsnNode) get).getIndex();
		if (!field.equals(innerField)) {
			return null;
		}
		try {
			if (getType == InsnType.IGET && insn.getType() == InsnType.IPUT) {
				InsnArg reg = get.getArg(0);
				InsnArg putReg = insn.getArg(1);
				if (!reg.equals(putReg)) {
					return null;
				}
			}
			InsnArg fArg = InsnArg.wrapArg(get);
			if (insn.getType() == InsnType.IPUT) {
				InsnRemover.unbindArgUsage(mth, insn.getArg(1));
			}
			if (wrapType == InsnType.ARITH) {
				ArithNode ar = (ArithNode) wrap;
				return ArithNode.oneArgOp(ar.getOp(), fArg, ar.getArg(1));
			}
			int argsCount = wrap.getArgsCount();
			InsnNode concat = new InsnNode(InsnType.STR_CONCAT, argsCount - 1);
			for (int i = 1; i < argsCount; i++) {
				concat.addArg(wrap.getArg(i));
			}
			return ArithNode.oneArgOp(ArithOp.ADD, fArg, InsnArg.wrapArg(concat));
		} catch (Exception e) {
			LOG.debug("Can't convert field arith insn: {}, mth: {}", insn, mth, e);
		}
		return null;
	}
}
