package bsh;

import _m_j.kv;

public class UtilEvalError extends Exception {
    protected UtilEvalError() {
    }

    public UtilEvalError(String str) {
        super(str);
    }

    public EvalError toEvalError(SimpleNode simpleNode, kv kvVar) {
        return toEvalError(null, simpleNode, kvVar);
    }

    public EvalError toEvalError(String str, SimpleNode simpleNode, kv kvVar) {
        String str2;
        if (Interpreter.f3062O000000o) {
            printStackTrace();
        }
        if (str == null) {
            str2 = "";
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(": ");
            str2 = stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str2);
        stringBuffer2.append(getMessage());
        return new EvalError(stringBuffer2.toString(), simpleNode, kvVar);
    }
}
