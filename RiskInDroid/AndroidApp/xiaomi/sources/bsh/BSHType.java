package bsh;

import _m_j.kv;
import java.lang.reflect.Array;

class BSHType extends SimpleNode {
    int arrayDims;
    Class baseType;
    String descriptor;
    private Class type;

    BSHType() {
        super(9);
    }

    public final void O000000o() {
        this.arrayDims++;
    }

    public final Class O00000Oo(kv kvVar, Interpreter interpreter) throws EvalError {
        Class cls;
        Class cls2 = this.type;
        if (cls2 != null) {
            return cls2;
        }
        SimpleNode simpleNode = (SimpleNode) O000000o(0);
        if (simpleNode instanceof BSHPrimitiveType) {
            cls = ((BSHPrimitiveType) simpleNode).type;
        } else {
            cls = ((BSHAmbiguousName) simpleNode).O000000o(kvVar);
        }
        this.baseType = cls;
        int i = this.arrayDims;
        if (i > 0) {
            try {
                this.type = Array.newInstance(this.baseType, new int[i]).getClass();
            } catch (Exception unused) {
                throw new EvalError("Couldn't construct array type", this, kvVar);
            }
        } else {
            this.type = this.baseType;
        }
        interpreter.globalNameSpace.O00000o();
        return this.type;
    }
}
