package bsh;

import _m_j.kv;

class BSHTernaryExpression extends SimpleNode {
    BSHTernaryExpression() {
        super(14);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        return BSHIfStatement.O000000o((SimpleNode) O000000o(0), kvVar, interpreter) ? ((SimpleNode) O000000o(1)).O000000o(kvVar, interpreter) : ((SimpleNode) O000000o(2)).O000000o(kvVar, interpreter);
    }
}
