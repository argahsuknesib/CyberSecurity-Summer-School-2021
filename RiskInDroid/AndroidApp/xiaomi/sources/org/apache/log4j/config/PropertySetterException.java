package org.apache.log4j.config;

public class PropertySetterException extends Exception {
    private static final long serialVersionUID = -1352613734254235861L;
    public Throwable rootCause;

    public PropertySetterException(String str) {
        super(str);
    }

    public PropertySetterException(Throwable th) {
        this.rootCause = th;
    }

    public String getMessage() {
        Throwable th;
        String message = super.getMessage();
        return (message != null || (th = this.rootCause) == null) ? message : th.getMessage();
    }
}
