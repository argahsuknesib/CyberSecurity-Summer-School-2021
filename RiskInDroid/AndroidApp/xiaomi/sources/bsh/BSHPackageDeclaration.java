package bsh;

import _m_j.kv;

public class BSHPackageDeclaration extends SimpleNode {
    public BSHPackageDeclaration() {
        super(3);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) O000000o(0);
        NameSpace O000000o2 = kvVar.O000000o(0);
        O000000o2.packageName = bSHAmbiguousName.text;
        O000000o2.O00000Oo(bSHAmbiguousName.text);
        return Primitive.O00000o0;
    }
}
