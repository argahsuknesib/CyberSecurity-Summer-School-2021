package org.apache.log4j.spi;

import _m_j.jep;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class LocationInfo implements Serializable {
    public static final LocationInfo O00000oO = new LocationInfo("?", "?", "?", "?");
    static boolean O00000oo = false;
    static Class O0000O0o = null;
    private static StringWriter O0000OOo = new StringWriter();
    private static Method O0000Oo = null;
    private static PrintWriter O0000Oo0 = new PrintWriter(O0000OOo);
    private static Method O0000OoO = null;
    private static Method O0000Ooo = null;
    private static Method O0000o0 = null;
    private static Method O0000o00 = null;
    static final long serialVersionUID = -1325822038990805636L;

    /* renamed from: O000000o  reason: collision with root package name */
    transient String f15436O000000o;
    transient String O00000Oo;
    transient String O00000o;
    transient String O00000o0;
    public String fullInfo;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b A[Catch:{ ClassNotFoundException -> 0x0071, NoSuchMethodException -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0032 A[Catch:{ ClassNotFoundException -> 0x0071, NoSuchMethodException -> 0x006d }] */
    static {
        Class cls;
        boolean z = false;
        O00000oo = false;
        if (Class.forName("com.ibm.uvm.tools.DebugSupport") != null) {
            z = true;
        }
        O00000oo = z;
        jep.O000000o("Detected IBM VisualAge environment.");
        try {
            if (O0000O0o != null) {
                cls = O000000o("java.lang.Throwable");
                O0000O0o = cls;
            } else {
                cls = O0000O0o;
            }
            O0000Oo = cls.getMethod("getStackTrace", null);
            Class<?> cls2 = Class.forName("java.lang.StackTraceElement");
            O0000OoO = cls2.getMethod("getClassName", null);
            O0000Ooo = cls2.getMethod("getMethodName", null);
            O0000o00 = cls2.getMethod("getFileName", null);
            O0000o0 = cls2.getMethod("getLineNumber", null);
        } catch (ClassNotFoundException unused) {
            jep.O000000o("LocationInfo will use pre-JDK 1.4 methods to determine location.");
        } catch (NoSuchMethodException unused2) {
            jep.O000000o("LocationInfo will use pre-JDK 1.4 methods to determine location.");
        }
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public LocationInfo() {
    }

    private static final void O000000o(StringBuffer stringBuffer, String str) {
        if (str == null) {
            stringBuffer.append("?");
        } else {
            stringBuffer.append(str);
        }
    }

    private LocationInfo(String str, String str2, String str3, String str4) {
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O00000o = str3;
        this.f15436O000000o = str4;
        StringBuffer stringBuffer = new StringBuffer();
        O000000o(stringBuffer, str2);
        stringBuffer.append(".");
        O000000o(stringBuffer, str3);
        stringBuffer.append("(");
        O000000o(stringBuffer, str);
        stringBuffer.append(":");
        O000000o(stringBuffer, str4);
        stringBuffer.append(")");
        this.fullInfo = stringBuffer.toString();
    }
}
