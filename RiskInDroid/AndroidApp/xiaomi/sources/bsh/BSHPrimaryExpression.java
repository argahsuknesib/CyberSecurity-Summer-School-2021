package bsh;

import _m_j.kv;

class BSHPrimaryExpression extends SimpleNode {
    BSHPrimaryExpression() {
        super(18);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        return O000000o(false, kvVar, interpreter);
    }

    public final LHS O00000Oo(kv kvVar, Interpreter interpreter) throws EvalError {
        Object O000000o2 = O000000o(true, kvVar, interpreter);
        if (O000000o2 instanceof LHS) {
            return (LHS) O000000o2;
        }
        throw new EvalError("Can't assign to:", this, kvVar);
    }

    private Object O000000o(boolean z, kv kvVar, Interpreter interpreter) throws EvalError {
        Object O000000o2 = O000000o(0);
        int O00000o0 = O00000o0();
        for (int i = 1; i < O00000o0; i++) {
            O000000o2 = ((BSHPrimarySuffix) O000000o(i)).O000000o(O000000o2, z, kvVar, interpreter);
        }
        if (O000000o2 instanceof SimpleNode) {
            if (O000000o2 instanceof BSHAmbiguousName) {
                O000000o2 = z ? ((BSHAmbiguousName) O000000o2).O00000Oo(kvVar, interpreter) : ((BSHAmbiguousName) O000000o2).O000000o(kvVar, interpreter, false);
            } else if (!z) {
                O000000o2 = ((SimpleNode) O000000o2).O000000o(kvVar, interpreter);
            } else {
                throw new EvalError("Can't assign to prefix.", this, kvVar);
            }
        }
        if (!(O000000o2 instanceof LHS) || z) {
            return O000000o2;
        }
        try {
            return ((LHS) O000000o2).O000000o();
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }
}
