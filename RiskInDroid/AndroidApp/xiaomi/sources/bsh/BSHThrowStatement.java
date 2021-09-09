package bsh;

import _m_j.kv;

class BSHThrowStatement extends SimpleNode {
    BSHThrowStatement() {
        super(36);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        Object O000000o2 = ((SimpleNode) O000000o(0)).O000000o(kvVar, interpreter);
        if (!(O000000o2 instanceof Exception)) {
            throw new EvalError("Expression in 'throw' must be Exception type", this, kvVar);
        }
        throw new TargetError((Exception) O000000o2, this, kvVar);
    }
}
