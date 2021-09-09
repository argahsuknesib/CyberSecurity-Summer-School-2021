package _m_j;

import java.lang.reflect.Method;
import java.util.Hashtable;

public final class jeg {

    /* renamed from: O000000o  reason: collision with root package name */
    static final jeg f1787O000000o = new jeg();
    static Class O00000o;
    boolean O00000Oo = jeo.O000000o();
    Object O00000o0;
    private Method O00000oO;

    private jeg() {
        Class cls;
        if (!this.O00000Oo) {
            this.O00000o0 = new jes();
        }
        try {
            if (O00000o == null) {
                cls = O000000o("java.lang.ThreadLocal");
                O00000o = cls;
            } else {
                cls = O00000o;
            }
            this.O00000oO = cls.getMethod("remove", null);
        } catch (NoSuchMethodException unused) {
        }
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static Hashtable O000000o() {
        Object obj;
        jeg jeg = f1787O000000o;
        if (jeg == null || jeg.O00000Oo || (obj = jeg.O00000o0) == null) {
            return null;
        }
        return (Hashtable) ((jes) obj).get();
    }
}
