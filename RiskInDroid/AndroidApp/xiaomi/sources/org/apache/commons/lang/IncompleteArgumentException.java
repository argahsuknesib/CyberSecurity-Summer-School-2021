package org.apache.commons.lang;

import java.util.Arrays;

public class IncompleteArgumentException extends IllegalArgumentException {
    private static final long serialVersionUID = 4954193403612068178L;

    /* JADX WARNING: Illegal instructions before constructor call */
    public IncompleteArgumentException(String str) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" is incomplete.");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public IncompleteArgumentException(String str, String[] strArr) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" is missing the following items: ");
        stringBuffer.append(safeArrayToString(strArr));
    }

    private static final String safeArrayToString(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        return Arrays.asList(objArr).toString();
    }
}
