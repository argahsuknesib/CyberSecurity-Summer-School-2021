package bsh;

import _m_j.kv;
import _m_j.ld;

class BSHUnaryExpression extends SimpleNode implements ld {
    public int kind;
    public boolean postfix = false;

    BSHUnaryExpression() {
        super(16);
    }

    private static Object O000000o(Object obj, int i) throws UtilEvalError {
        if ((obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Number)) {
            return O00000Oo(obj, i);
        }
        if (obj instanceof Primitive) {
            return Primitive.O000000o((Primitive) obj, i);
        }
        StringBuffer stringBuffer = new StringBuffer("Unary operation ");
        stringBuffer.append(ld.a_[i]);
        stringBuffer.append(" inappropriate for object");
        throw new UtilEvalError(stringBuffer.toString());
    }

    private static Object O00000Oo(Object obj, int i) throws UtilEvalError {
        Class<?> cls = obj.getClass();
        Object O000000o2 = Primitive.O000000o(obj);
        if (O000000o2 instanceof Boolean) {
            return new Boolean(Primitive.O000000o((Boolean) O000000o2, i));
        }
        if (O000000o2 instanceof Integer) {
            int O000000o3 = Primitive.O000000o((Integer) O000000o2, i);
            if (i == 100 || i == 101) {
                if (cls == Byte.TYPE) {
                    return new Byte((byte) O000000o3);
                }
                if (cls == Short.TYPE) {
                    return new Short((short) O000000o3);
                }
                if (cls == Character.TYPE) {
                    return new Character((char) O000000o3);
                }
            }
            return Integer.valueOf(O000000o3);
        } else if (O000000o2 instanceof Long) {
            return new Long(Primitive.O000000o((Long) O000000o2, i));
        } else {
            if (O000000o2 instanceof Float) {
                return new Float(Primitive.O000000o((Float) O000000o2, i));
            }
            if (O000000o2 instanceof Double) {
                return new Double(Primitive.O000000o((Double) O000000o2, i));
            }
            throw new InterpreterError("An error occurred.  Please call technical support.");
        }
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        SimpleNode simpleNode = (SimpleNode) O000000o(0);
        try {
            if (this.kind != 100) {
                if (this.kind != 101) {
                    return O000000o(simpleNode.O000000o(kvVar, interpreter), this.kind);
                }
            }
            LHS O00000Oo = ((BSHPrimaryExpression) simpleNode).O00000Oo(kvVar, interpreter);
            boolean z = interpreter.strictJava;
            if (Interpreter.f3062O000000o) {
                Interpreter.O00000Oo("lhsUnaryOperation");
            }
            Object O000000o2 = O00000Oo.O000000o();
            Object O000000o3 = O000000o(O000000o2, this.kind);
            if (!this.postfix) {
                O000000o2 = O000000o3;
            }
            O00000Oo.O000000o(O000000o3, z);
            return O000000o2;
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }
}
