package bsh;

import _m_j.kv;

class BSHStatementExpressionList extends SimpleNode {
    BSHStatementExpressionList() {
        super(34);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        int O00000o0 = O00000o0();
        for (int i = 0; i < O00000o0; i++) {
            ((SimpleNode) O000000o(i)).O000000o(kvVar, interpreter);
        }
        return Primitive.O00000o0;
    }
}
