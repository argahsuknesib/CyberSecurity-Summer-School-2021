package bsh;

import _m_j.kv;

class BSHArguments extends SimpleNode {
    BSHArguments() {
        super(22);
    }

    public final Object[] O00000Oo(kv kvVar, Interpreter interpreter) throws EvalError {
        Object[] objArr = new Object[O00000o0()];
        int i = 0;
        while (i < objArr.length) {
            objArr[i] = ((SimpleNode) O000000o(i)).O000000o(kvVar, interpreter);
            if (objArr[i] != Primitive.O00000o0) {
                i++;
            } else {
                StringBuffer stringBuffer = new StringBuffer("Undefined argument: ");
                stringBuffer.append(((SimpleNode) O000000o(i)).O00000oo());
                throw new EvalError(stringBuffer.toString(), this, kvVar);
            }
        }
        return objArr;
    }
}
