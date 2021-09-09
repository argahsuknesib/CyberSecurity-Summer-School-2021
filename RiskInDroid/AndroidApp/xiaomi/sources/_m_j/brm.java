package _m_j;

import android.text.TextUtils;
import android.util.Log;

public final class brm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13220O000000o = "";
    public static boolean O00000Oo = true;
    public static boolean O00000o = true;
    public static boolean O00000o0 = true;
    public static boolean O00000oO = true;
    public static boolean O00000oo = true;
    public static boolean O0000O0o = true;
    public static O000000o O0000OOo;

    public interface O000000o {
    }

    private static String O000000o(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        String format = String.format("%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        if (TextUtils.isEmpty(f13220O000000o)) {
            return format;
        }
        return String.valueOf(f13220O000000o) + ":" + format;
    }

    public static void O000000o(String str) {
        if (O00000Oo) {
            String O000000o2 = O000000o(brn.O000000o());
            if (O0000OOo == null) {
                Log.d(O000000o2, str);
            }
        }
    }

    public static void O00000Oo(String str) {
        if (O00000o0) {
            String O000000o2 = O000000o(brn.O000000o());
            if (O0000OOo == null) {
                Log.e(O000000o2, str);
            }
        }
    }

    public static void O000000o(String str, Throwable th) {
        if (O00000o0) {
            String O000000o2 = O000000o(brn.O000000o());
            if (O0000OOo == null) {
                Log.e(O000000o2, str, th);
            }
        }
    }

    public static void O000000o(Throwable th) {
        if (O00000oo) {
            String O000000o2 = O000000o(brn.O000000o());
            if (O0000OOo == null) {
                Log.w(O000000o2, th);
            }
        }
    }
}
