package bsh;

import _m_j.kv;

public class UtilTargetError extends UtilEvalError {
    public Throwable t;

    public UtilTargetError(String str, Throwable th) {
        super(str);
        this.t = th;
    }

    public UtilTargetError(Throwable th) {
        this(null, th);
    }

    public EvalError toEvalError(String str, SimpleNode simpleNode, kv kvVar) {
        String str2;
        if (str == null) {
            str2 = getMessage();
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(": ");
            stringBuffer.append(getMessage());
            str2 = stringBuffer.toString();
        }
        return new TargetError(str2, this.t, simpleNode, kvVar, false);
    }
}
