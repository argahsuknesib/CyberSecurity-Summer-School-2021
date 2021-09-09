package bsh;

import _m_j.kv;

class BSHSwitchLabel extends SimpleNode {
    boolean isDefault;

    public BSHSwitchLabel() {
        super(28);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        if (this.isDefault) {
            return null;
        }
        return ((SimpleNode) O000000o(0)).O000000o(kvVar, interpreter);
    }
}
