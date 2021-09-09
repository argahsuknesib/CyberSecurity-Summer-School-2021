package jadx.core.dex.instructions.args;

import jadx.api.JadxArgs;
import jadx.core.codegen.TypeGen;
import jadx.core.utils.StringUtils;
import jadx.core.utils.exceptions.JadxRuntimeException;

public final class LiteralArg extends InsnArg {

	public static final LiteralArg TRUE = new LiteralArg(1, ArgType.BOOLEAN);
	public static final LiteralArg FALSE = new LiteralArg(0, ArgType.BOOLEAN);

	private final long literal;

	public LiteralArg(long value, ArgType type) {
		if (value != 0) {
			if (type.isObject()) {
				throw new JadxRuntimeException("Wrong literal type: " + type + " for value: " + value);
			} else if (!type.isTypeKnown()
					&& !type.contains(PrimitiveType.LONG)
					&& !type.contains(PrimitiveType.DOUBLE)) {
				if (value != 1) {
					type = ArgType.NARROW_NUMBERS_NO_BOOL;
				} else {
					type = ArgType.NARROW_NUMBERS;
				}
			}
		}
		this.literal = value;
		this.type = type;
	}

	public long getLiteral() {
		return literal;
	}

	@Override
	public boolean isLiteral() {
		return true;
	}

	public boolean isInteger() {
		PrimitiveType type = this.type.getPrimitiveType();
		return type == PrimitiveType.INT
				|| type == PrimitiveType.BYTE
				|| type == PrimitiveType.CHAR
				|| type == PrimitiveType.SHORT
				|| type == PrimitiveType.LONG;
	}

	@Override
	public InsnArg duplicate() {
		LiteralArg copy = new LiteralArg(literal, getType());
		copy.type = type;
		return copyCommonParams(copy);
	}

	@Override
	public int hashCode() {
		return (int) (literal ^ literal >>> 32) + 31 * getType().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LiteralArg that = (LiteralArg) o;
		return literal == that.literal && getType().equals(that.getType());
	}

	private static final StringUtils DEF_STRING_UTILS = new StringUtils(new JadxArgs());

	@Override
	public String toString() {
		try {
			String value = TypeGen.literalToString(literal, getType(), DEF_STRING_UTILS, true, false);
			if (getType().equals(ArgType.BOOLEAN) && (value.equals("true") || value.equals("false"))) {
				return value;
			}
			return '(' + value + ' ' + type + ')';
		} catch (JadxRuntimeException ex) {
			// can't convert literal to string
			return "(" + literal + ' ' + type + ')';
		}
	}
}
