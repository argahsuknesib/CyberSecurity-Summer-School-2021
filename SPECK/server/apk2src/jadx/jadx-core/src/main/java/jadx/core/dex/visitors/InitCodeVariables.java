package jadx.core.dex.visitors;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.instructions.PhiInsn;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.instructions.args.CodeVar;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.instructions.args.SSAVar;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.visitors.ssa.SSATransform;
import jadx.core.utils.exceptions.JadxException;
import jadx.core.utils.exceptions.JadxRuntimeException;

@JadxVisitor(
		name = "InitCodeVariables",
		desc = "Initialize code variables",
		runAfter = SSATransform.class
)
public class InitCodeVariables extends AbstractVisitor {

	@Override
	public void visit(MethodNode mth) throws JadxException {
		if (mth.isNoCode()) {
			return;
		}
		initCodeVars(mth);
	}

	public static void rerun(MethodNode mth) {
		for (SSAVar sVar : mth.getSVars()) {
			sVar.resetTypeAndCodeVar();
		}
		initCodeVars(mth);
	}

	private static void initCodeVars(MethodNode mth) {
		RegisterArg thisArg = mth.getThisArg();
		if (thisArg != null) {
			initCodeVar(thisArg.getSVar());
		}
		for (RegisterArg mthArg : mth.getArgRegs()) {
			initCodeVar(mthArg.getSVar());
		}
		for (SSAVar ssaVar : mth.getSVars()) {
			initCodeVar(ssaVar);
		}
	}

	private static void initCodeVar(SSAVar ssaVar) {
		if (ssaVar.isCodeVarSet()) {
			return;
		}
		CodeVar codeVar = new CodeVar();
		RegisterArg assignArg = ssaVar.getAssign();
		if (assignArg.contains(AFlag.THIS)) {
			codeVar.setName(RegisterArg.THIS_ARG_NAME);
			codeVar.setThis(true);
		}
		if (assignArg.contains(AFlag.METHOD_ARGUMENT) || assignArg.contains(AFlag.CUSTOM_DECLARE)) {
			codeVar.setDeclared(true);
		}

		setCodeVar(ssaVar, codeVar);
	}

	private static void setCodeVar(SSAVar ssaVar, CodeVar codeVar) {
		List<PhiInsn> usedInPhiList = ssaVar.getUsedInPhi();
		if (!usedInPhiList.isEmpty()) {
			Set<SSAVar> vars = new LinkedHashSet<>();
			vars.add(ssaVar);
			collectConnectedVars(usedInPhiList, vars);
			setCodeVarType(codeVar, vars);
			vars.forEach(var -> {
				if (var.isCodeVarSet()) {
					codeVar.mergeFlagsFrom(var.getCodeVar());
				}
				var.setCodeVar(codeVar);
			});
		} else {
			ssaVar.setCodeVar(codeVar);
		}
	}

	private static void setCodeVarType(CodeVar codeVar, Set<SSAVar> vars) {
		if (vars.size() > 1) {
			List<ArgType> imTypes = vars.stream()
					.map(SSAVar::getImmutableType)
					.filter(Objects::nonNull)
					.filter(ArgType::isTypeKnown)
					.distinct()
					.collect(Collectors.toList());
			int imCount = imTypes.size();
			if (imCount == 1) {
				codeVar.setType(imTypes.get(0));
			} else if (imCount > 1) {
				throw new JadxRuntimeException("Several immutable types in one variable: " + imTypes + ", vars: " + vars);
			}
		}
	}

	private static void collectConnectedVars(List<PhiInsn> phiInsnList, Set<SSAVar> vars) {
		for (PhiInsn phiInsn : phiInsnList) {
			SSAVar resultVar = phiInsn.getResult().getSVar();
			if (vars.add(resultVar)) {
				collectConnectedVars(resultVar.getUsedInPhi(), vars);
			}
			phiInsn.getArguments().forEach(arg -> {
				SSAVar sVar = ((RegisterArg) arg).getSVar();
				if (vars.add(sVar)) {
					collectConnectedVars(sVar.getUsedInPhi(), vars);
				}
			});
		}
	}
}
