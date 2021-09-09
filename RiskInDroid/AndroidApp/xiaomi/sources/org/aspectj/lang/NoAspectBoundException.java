package org.aspectj.lang;

public class NoAspectBoundException extends RuntimeException {
    Throwable cause;

    /* JADX WARNING: Illegal instructions before constructor call */
    public NoAspectBoundException(String str, Throwable th) {
        super(str);
        if (th != null) {
            StringBuffer stringBuffer = new StringBuffer("Exception while initializing ");
            stringBuffer.append(str);
            stringBuffer.append(": ");
            stringBuffer.append(th);
            str = stringBuffer.toString();
        }
        this.cause = th;
    }

    public NoAspectBoundException() {
    }

    public Throwable getCause() {
        return this.cause;
    }
}
