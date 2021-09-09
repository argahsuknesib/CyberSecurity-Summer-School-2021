package jadx.core.dex.instructions.mods;

import org.jetbrains.annotations.Nullable;

import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.BaseInvokeNode;
import jadx.core.dex.instructions.InsnType;
import jadx.core.dex.instructions.InvokeNode;
import jadx.core.dex.instructions.args.RegisterArg;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;

public final class ConstructorInsn extends BaseInvokeNode {

	private final MethodInfo callMth;
	private final CallType callType;

	public enum CallType {
		CONSTRUCTOR, // just new instance
		SUPER, // super call
		THIS, // call constructor from other constructor
		SELF // call itself
	}

	public ConstructorInsn(MethodNode mth, InvokeNode invoke) {
		super(InsnType.CONSTRUCTOR, invoke.getArgsCount() - 1);
		this.callMth = invoke.getCallMth();
		ClassInfo classType = callMth.getDeclClass();
		RegisterArg instanceArg = (RegisterArg) invoke.getArg(0);

		if (instanceArg.isThis()) {
			if (classType.equals(mth.getParentClass().getClassInfo())) {
				if (callMth.getShortId().equals(mth.getMethodInfo().getShortId())) {
					// self constructor
					callType = CallType.SELF;
				} else {
					callType = CallType.THIS;
				}
			} else {
				callType = CallType.SUPER;
			}
		} else {
			callType = CallType.CONSTRUCTOR;
			setResult(instanceArg);
			// convert from 'use' to 'assign'
			instanceArg.getSVar().setAssign(instanceArg);
		}
		instanceArg.getSVar().removeUse(instanceArg);
		int argsCount = invoke.getArgsCount();
		for (int i = 1; i < argsCount; i++) {
			addArg(invoke.getArg(i));
		}
	}

	public ConstructorInsn(MethodInfo callMth, CallType callType) {
		super(InsnType.CONSTRUCTOR, callMth.getArgsCount());
		this.callMth = callMth;
		this.callType = callType;
	}

	@Override
	public MethodInfo getCallMth() {
		return callMth;
	}

	@Override
	@Nullable
	public RegisterArg getInstanceArg() {
		return null;
	}

	public ClassInfo getClassType() {
		return callMth.getDeclClass();
	}

	public CallType getCallType() {
		return callType;
	}

	public boolean isNewInstance() {
		return callType == CallType.CONSTRUCTOR;
	}

	public boolean isSuper() {
		return callType == CallType.SUPER;
	}

	public boolean isThis() {
		return callType == CallType.THIS;
	}

	public boolean isSelf() {
		return callType == CallType.SELF;
	}

	@Override
	public boolean isStaticCall() {
		return false;
	}

	@Override
	public int getFirstArgOffset() {
		return 0;
	}

	@Override
	public boolean isSame(InsnNode obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ConstructorInsn) || !super.isSame(obj)) {
			return false;
		}
		ConstructorInsn other = (ConstructorInsn) obj;
		return callMth.equals(other.callMth)
				&& callType == other.callType;
	}

	@Override
	public InsnNode copy() {
		return copyCommonParams(new ConstructorInsn(callMth, callType));
	}

	@Override
	public String toString() {
		return super.toString() + " call: " + callMth + " type: " + callType;
	}
}
