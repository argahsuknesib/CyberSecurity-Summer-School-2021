package jadx.core.clsp;

import java.util.List;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.GenericTypeParameter;
import jadx.core.dex.nodes.IMethodDetails;
import jadx.core.utils.Utils;

/**
 * Method node in classpath graph.
 */
public class ClspMethod implements IMethodDetails, Comparable<ClspMethod> {

	private final MethodInfo methodInfo;
	private final List<ArgType> argTypes;
	private final ArgType returnType;
	private final List<GenericTypeParameter> typeParameters;
	private final List<ArgType> throwList;
	private final boolean varArg;

	public ClspMethod(MethodInfo methodInfo,
			List<ArgType> argTypes, ArgType returnType,
			List<GenericTypeParameter> typeParameters,
			boolean varArgs, List<ArgType> throwList) {
		this.methodInfo = methodInfo;
		this.argTypes = argTypes;
		this.returnType = returnType;
		this.typeParameters = typeParameters;
		this.throwList = throwList;
		this.varArg = varArgs;
	}

	@Override
	public MethodInfo getMethodInfo() {
		return methodInfo;
	}

	@Override
	public ArgType getReturnType() {
		return returnType;
	}

	@Override
	public List<ArgType> getArgTypes() {
		return argTypes;
	}

	public boolean containsGenericArgs() {
		return !Objects.equals(argTypes, methodInfo.getArgumentsTypes());
	}

	public int getArgsCount() {
		return argTypes.size();
	}

	@Override
	public List<GenericTypeParameter> getTypeParameters() {
		return typeParameters;
	}

	@Override
	public List<ArgType> getThrows() {
		return throwList;
	}

	@Override
	public boolean isVarArg() {
		return varArg;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ClspMethod)) {
			return false;
		}
		ClspMethod other = (ClspMethod) o;
		return methodInfo.equals(other.methodInfo);
	}

	@Override
	public int hashCode() {
		return methodInfo.hashCode();
	}

	@Override
	public int compareTo(@NotNull ClspMethod other) {
		return this.methodInfo.compareTo(other.methodInfo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ClspMth{");
		if (Utils.notEmpty(getTypeParameters())) {
			sb.append('<');
			sb.append(Utils.listToString(getTypeParameters()));
			sb.append("> ");
		}
		sb.append(getMethodInfo().getFullName());
		sb.append('(');
		sb.append(Utils.listToString(getArgTypes()));
		sb.append("):");
		sb.append(getReturnType());
		if (isVarArg()) {
			sb.append(" VARARG");
		}
		List<ArgType> throwsList = getThrows();
		if (Utils.notEmpty(throwsList)) {
			sb.append(" throws ").append(Utils.listToString(throwsList));
		}
		sb.append('}');
		return sb.toString();
	}
}
