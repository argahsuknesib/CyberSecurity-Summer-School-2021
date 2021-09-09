package jadx.core.dex.nodes.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jadx.core.Consts;
import jadx.core.dex.attributes.IAttributeNode;
import jadx.core.dex.attributes.annotations.Annotation;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.GenericTypeParameter;
import jadx.core.utils.exceptions.JadxRuntimeException;

public class SignatureParser {

	private static final Logger LOG = LoggerFactory.getLogger(SignatureParser.class);
	private static final char STOP_CHAR = 0;

	private final String sign;
	private final int end;
	private int pos;
	private int mark;

	public SignatureParser(String signature) {
		sign = signature;
		end = sign.length();
		pos = -1;
		mark = 0;
	}

	@SuppressWarnings("unchecked")
	public static SignatureParser fromNode(IAttributeNode node) {
		Annotation a = node.getAnnotation(Consts.DALVIK_SIGNATURE);
		if (a == null) {
			return null;
		}
		String signature = mergeSignature((List<String>) a.getDefaultValue());
		return new SignatureParser(signature);
	}

	private char next() {
		pos++;
		if (pos >= end) {
			return STOP_CHAR;
		}
		return sign.charAt(pos);
	}

	private boolean lookAhead(char ch) {
		int next = pos + 1;
		return next < end && sign.charAt(next) == ch;
	}

	private void mark() {
		mark = pos;
	}

	/**
	 * Exclusive slice.
	 *
	 * @return string from 'mark' to current position (not including current character)
	 */
	private String slice() {
		int start = mark == -1 ? 0 : mark;
		if (start >= pos) {
			return "";
		}
		return sign.substring(start, pos);
	}

	/**
	 * Inclusive slice (includes current character)
	 */
	private String inclusiveSlice() {
		int start = mark;
		if (start == -1) {
			start = 0;
		}
		int last = pos + 1;
		if (start >= last) {
			return "";
		}
		return sign.substring(start, last);
	}

	private boolean skipUntil(char untilChar) {
		int startPos = pos;
		while (true) {
			if (lookAhead(untilChar)) {
				return true;
			}
			char ch = next();
			if (ch == STOP_CHAR) {
				pos = startPos;
				return false;
			}
		}
	}

	private void consume(char exp) {
		char c = next();
		if (exp != c) {
			throw new JadxRuntimeException("Consume wrong char: '" + c + "' != '" + exp
					+ "', sign: " + debugString());
		}
	}

	private boolean tryConsume(char exp) {
		if (lookAhead(exp)) {
			next();
			return true;
		}
		return false;
	}

	@Nullable
	public String consumeUntil(char lastChar) {
		mark();
		return skipUntil(lastChar) ? inclusiveSlice() : null;
	}

	public ArgType consumeType() {
		char ch = next();
		switch (ch) {
			case 'L':
				ArgType obj = consumeObjectType(false);
				if (obj != null) {
					return obj;
				}
				break;
			case 'T':
				next();
				mark();
				String typeVarName = consumeUntil(';');
				if (typeVarName != null) {
					consume(';');
					return ArgType.genericType(typeVarName);
				}
				break;

			case '[':
				return ArgType.array(consumeType());

			case STOP_CHAR:
				return null;

			default:
				// primitive type (one char)
				ArgType type = ArgType.parse(ch);
				if (type != null) {
					return type;
				}
				break;
		}
		throw new JadxRuntimeException("Can't parse type: " + debugString() + ", unexpected: " + ch);
	}

	private ArgType consumeObjectType(boolean incompleteType) {
		mark();
		int ch;
		do {
			ch = next();
			if (ch == STOP_CHAR) {
				return null;
			}
		} while (ch != '<' && ch != ';');

		if (ch == ';') {
			String obj;
			if (incompleteType) {
				obj = slice().replace('/', '.');
			} else {
				obj = inclusiveSlice();
			}
			return ArgType.object(obj);
		} else {
			// generic type start ('<')
			String obj = slice();
			if (!incompleteType) {
				obj += ';';
			}
			ArgType[] genArr = consumeGenericArgs();
			consume('>');

			ArgType genericType = ArgType.generic(obj, genArr);
			if (lookAhead('.')) {
				consume('.');
				next();
				// type parsing not completed, proceed to inner class
				ArgType inner = consumeObjectType(true);
				if (inner == null) {
					throw new JadxRuntimeException("No inner type found: " + debugString());
				}
				return ArgType.outerGeneric(genericType, inner);
			} else {
				consume(';');
				return genericType;
			}
		}
	}

	private ArgType[] consumeGenericArgs() {
		List<ArgType> list = new LinkedList<>();
		ArgType type;
		do {
			if (lookAhead('*')) {
				next();
				type = ArgType.wildcard();
			} else if (lookAhead('+')) {
				next();
				type = ArgType.wildcard(consumeType(), ArgType.WildcardBound.EXTENDS);
			} else if (lookAhead('-')) {
				next();
				type = ArgType.wildcard(consumeType(), ArgType.WildcardBound.SUPER);
			} else {
				type = consumeType();
			}
			if (type != null) {
				list.add(type);
			}
		} while (type != null && !lookAhead('>'));
		return list.toArray(new ArgType[0]);
	}

	/**
	 * Map of generic types names to extends classes.
	 * <p/>
	 * Example: "<T:Ljava/lang/Exception;:Ljava/lang/Object;>"
	 */
	public List<GenericTypeParameter> consumeGenericTypeParameters() {
		if (!lookAhead('<')) {
			return Collections.emptyList();
		}
		List<GenericTypeParameter> list = new ArrayList<>();
		consume('<');
		while (true) {
			if (lookAhead('>') || next() == STOP_CHAR) {
				break;
			}
			String id = consumeUntil(':');
			if (id == null) {
				LOG.error("Failed to parse generic types map: {}", sign);
				return Collections.emptyList();
			}
			consume(':');
			tryConsume(':');
			List<ArgType> types = consumeExtendsTypesList();
			list.add(new GenericTypeParameter(ArgType.genericType(id), types));
		}
		consume('>');
		return list;
	}

	/**
	 * List of types separated by ':' last type is 'java.lang.Object'.
	 * <p/>
	 * Example: "Ljava/lang/Exception;:Ljava/lang/Object;"
	 */
	private List<ArgType> consumeExtendsTypesList() {
		List<ArgType> types = Collections.emptyList();
		boolean next;
		do {
			ArgType argType = consumeType();
			if (!argType.equals(ArgType.OBJECT)) {
				if (types.isEmpty()) {
					types = new LinkedList<>();
				}
				types.add(argType);
			}
			next = lookAhead(':');
			if (next) {
				consume(':');
			}
		} while (next);
		return types;
	}

	public List<ArgType> consumeMethodArgs() {
		consume('(');
		if (lookAhead(')')) {
			consume(')');
			return Collections.emptyList();
		}
		List<ArgType> args = new LinkedList<>();
		do {
			args.add(consumeType());
		} while (!lookAhead(')'));
		consume(')');
		return args;
	}

	private static String mergeSignature(List<String> list) {
		if (list.size() == 1) {
			return list.get(0);
		}
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}

	public String getSignature() {
		return sign;
	}

	private String debugString() {
		if (pos >= sign.length()) {
			return sign;
		}
		return sign + " at position " + pos + " ('" + sign.charAt(pos) + "')";
	}

	@Override
	public String toString() {
		if (pos == -1) {
			return sign;
		}
		return sign.substring(0, mark) + '{' + sign.substring(mark, pos) + '}' + sign.substring(pos);
	}
}
