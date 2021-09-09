package _m_j;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class jcs {

    /* renamed from: O000000o  reason: collision with root package name */
    static Class f1765O000000o;
    static Class O00000Oo;
    private static final Method O00000o = O000000o();
    private static final Log O00000o0;
    private static final Class O00000oO = O00000Oo();

    static {
        Class cls = f1765O000000o;
        if (cls == null) {
            cls = O000000o("_m_j.jcs");
            f1765O000000o = cls;
        }
        O00000o0 = LogFactory.getLog(cls);
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static Method O000000o() {
        Class cls;
        Class cls2;
        try {
            Class[] clsArr = new Class[1];
            if (O00000Oo == null) {
                cls = O000000o("java.lang.Throwable");
                O00000Oo = cls;
            } else {
                cls = O00000Oo;
            }
            clsArr[0] = cls;
            if (O00000Oo == null) {
                cls2 = O000000o("java.lang.Throwable");
                O00000Oo = cls2;
            } else {
                cls2 = O00000Oo;
            }
            return cls2.getMethod("initCause", clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Class O00000Oo() {
        try {
            return Class.forName("java.net.SocketTimeoutException");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static void O000000o(Throwable th, Throwable th2) {
        Method method = O00000o;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (Exception e) {
                O00000o0.warn("Exception invoking Throwable.initCause", e);
            }
        }
    }
}
