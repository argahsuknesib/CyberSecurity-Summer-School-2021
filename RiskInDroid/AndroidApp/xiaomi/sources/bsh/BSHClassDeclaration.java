package bsh;

import _m_j.kv;
import _m_j.kw;

class BSHClassDeclaration extends SimpleNode {
    boolean extend;
    boolean isInterface;
    Modifiers modifiers;
    String name;
    int numInterfaces;

    BSHClassDeclaration() {
        super(1);
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        int i;
        int i2 = 0;
        if (this.extend) {
            ((BSHAmbiguousName) O000000o(0)).O000000o(kvVar);
            i = 1;
        } else {
            i = 0;
        }
        Class[] clsArr = new Class[this.numInterfaces];
        while (i2 < this.numInterfaces) {
            int i3 = i + 1;
            BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) O000000o(i);
            clsArr[i2] = bSHAmbiguousName.O000000o(kvVar);
            if (clsArr[i2].isInterface()) {
                i2++;
                i = i3;
            } else {
                StringBuffer stringBuffer = new StringBuffer("Type: ");
                stringBuffer.append(bSHAmbiguousName.text);
                stringBuffer.append(" is not an interface!");
                throw new EvalError(stringBuffer.toString(), this, kvVar);
            }
        }
        if (i >= O00000o0()) {
            new BSHBlock();
        }
        try {
            return kw.O000000o().O00000Oo();
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, kvVar);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ClassDeclaration: ");
        stringBuffer.append(this.name);
        return stringBuffer.toString();
    }
}
