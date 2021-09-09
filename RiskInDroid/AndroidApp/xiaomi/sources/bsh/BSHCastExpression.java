package bsh;

import _m_j.kv;
import _m_j.lk;

class BSHCastExpression extends SimpleNode {
    public BSHCastExpression() {
        super(17);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        kvVar.O000000o(0);
        Class O00000Oo = ((BSHType) O000000o(0)).O00000Oo(kvVar, interpreter);
        Object O000000o2 = ((SimpleNode) O000000o(1)).O000000o(kvVar, interpreter);
        O000000o2.getClass();
        try {
            return lk.O000000o(O000000o2, O00000Oo, 0);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }
}
