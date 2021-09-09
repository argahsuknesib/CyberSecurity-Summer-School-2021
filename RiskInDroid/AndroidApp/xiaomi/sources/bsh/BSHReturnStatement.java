package bsh;

import _m_j.kv;
import _m_j.ld;
import _m_j.li;

class BSHReturnStatement extends SimpleNode implements ld {
    public int kind;

    BSHReturnStatement() {
        super(35);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        return new li(this.kind, O00000o0() > 0 ? ((SimpleNode) O000000o(0)).O000000o(kvVar, interpreter) : Primitive.O00000o0, this);
    }
}
