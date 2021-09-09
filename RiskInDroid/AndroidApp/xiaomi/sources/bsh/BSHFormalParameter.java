package bsh;

import _m_j.kv;

class BSHFormalParameter extends SimpleNode {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Class f3060O000000o = null;
    public String name;
    public Class type;

    BSHFormalParameter() {
        super(8);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        this.type = O00000o0() > 0 ? ((BSHType) O000000o(0)).O00000Oo(kvVar, interpreter) : f3060O000000o;
        return this.type;
    }
}
