package org.apache.commons.lang;

public class IllegalClassException extends IllegalArgumentException {
    private static final long serialVersionUID = 8063272569377254819L;

    /* JADX WARNING: Illegal instructions before constructor call */
    public IllegalClassException(Class cls, Object obj) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer("Expected: ");
        stringBuffer.append(safeGetClassName(cls));
        stringBuffer.append(", actual: ");
        stringBuffer.append(obj == null ? "null" : obj.getClass().getName());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public IllegalClassException(Class cls, Class cls2) {
        super(r0.toString());
        StringBuffer stringBuffer = new StringBuffer("Expected: ");
        stringBuffer.append(safeGetClassName(cls));
        stringBuffer.append(", actual: ");
        stringBuffer.append(safeGetClassName(cls2));
    }

    public IllegalClassException(String str) {
        super(str);
    }

    private static final String safeGetClassName(Class cls) {
        if (cls == null) {
            return null;
        }
        return cls.getName();
    }
}
