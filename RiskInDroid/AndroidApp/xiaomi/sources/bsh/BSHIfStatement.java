package bsh;

import _m_j.kv;
import _m_j.li;

class BSHIfStatement extends SimpleNode {
    BSHIfStatement() {
        super(29);
    }

    public static boolean O000000o(SimpleNode simpleNode, kv kvVar, Interpreter interpreter) throws EvalError {
        Object O000000o2 = simpleNode.O000000o(kvVar, interpreter);
        if (O000000o2 instanceof Primitive) {
            if (O000000o2 != Primitive.O00000o0) {
                O000000o2 = ((Primitive) O000000o2).O000000o();
            } else {
                throw new EvalError("Condition evaluates to void type", simpleNode, kvVar);
            }
        }
        if (O000000o2 instanceof Boolean) {
            return ((Boolean) O000000o2).booleanValue();
        }
        throw new EvalError("Condition must evaluate to a Boolean or boolean.", simpleNode, kvVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        Object obj;
        Node O000000o2;
        if (O000000o((SimpleNode) O000000o(0), kvVar, interpreter)) {
            O000000o2 = O000000o(1);
        } else if (O00000o0() > 2) {
            O000000o2 = O000000o(2);
        } else {
            obj = null;
            return !(obj instanceof li) ? obj : Primitive.O00000o0;
        }
        obj = ((SimpleNode) O000000o2).O000000o(kvVar, interpreter);
        if (!(obj instanceof li)) {
        }
    }
}
