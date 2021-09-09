package org.apache.commons.lang;

public class NullArgumentException extends IllegalArgumentException {
    private static final long serialVersionUID = 1174360235354917591L;

    /* JADX WARNING: Illegal instructions before constructor call */
    public NullArgumentException(String str) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str == null ? "Argument" : str);
        stringBuffer.append(" must not be null.");
    }
}
