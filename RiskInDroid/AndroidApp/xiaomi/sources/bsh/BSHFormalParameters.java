package bsh;

import _m_j.kv;

class BSHFormalParameters extends SimpleNode {
    int numArgs;
    private String[] paramNames;
    Class[] paramTypes;
    String[] typeDescriptors;

    BSHFormalParameters() {
        super(7);
    }

    private void O00000Oo() {
        if (this.paramNames == null) {
            this.numArgs = O00000o0();
            String[] strArr = new String[this.numArgs];
            for (int i = 0; i < this.numArgs; i++) {
                strArr[i] = ((BSHFormalParameter) O000000o(i)).name;
            }
            this.paramNames = strArr;
        }
    }

    public final Object O000000o(kv kvVar, Interpreter interpreter) throws EvalError {
        Class[] clsArr = this.paramTypes;
        if (clsArr != null) {
            return clsArr;
        }
        O00000Oo();
        Class[] clsArr2 = new Class[this.numArgs];
        for (int i = 0; i < this.numArgs; i++) {
            clsArr2[i] = (Class) ((BSHFormalParameter) O000000o(i)).O000000o(kvVar, interpreter);
        }
        this.paramTypes = clsArr2;
        return clsArr2;
    }

    public final String[] O000000o() {
        O00000Oo();
        return this.paramNames;
    }
}
