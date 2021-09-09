package _m_j;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class gnk {
    public static void O000000o(String str) {
        if (O000000o()) {
            fec.O00000o0().O000000o("miio-bluetooth", str);
        }
    }

    public static void O00000Oo(String str) {
        if (O000000o()) {
            fec.O00000o0().O000000o("miio-bluetooth", str);
        }
    }

    public static void O00000o0(String str) {
        if (O000000o()) {
            fec.O00000o0().O000000o("miio-bluetooth", str);
        }
    }

    public static void O00000o(String str) {
        if (O000000o()) {
            fec.O00000o0().O000000o("miio-bluetooth", str);
        }
    }

    public static void O000000o(String str, Object... objArr) {
        if (O000000o()) {
            fec.O00000o0().O000000o("miio-bluetooth", String.format(str, objArr));
        }
    }

    public static void O00000oO(String str) {
        if (O000000o()) {
            fec.O00000o0().O000000o("miio-bluetooth", str);
        }
    }

    public static void O000000o(Throwable th) {
        O00000Oo(O00000Oo(th));
    }

    public static String O00000Oo(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        while (th != null) {
            th.printStackTrace(printWriter);
            th = th.getCause();
        }
        String obj = stringWriter.toString();
        printWriter.close();
        return gqb.O0000O0o(obj);
    }

    public static void O00000oo(String str) {
        O00000oO(Log.getStackTraceString(new Throwable(str)));
    }

    private static boolean O000000o() {
        return !glc.O0000OOo;
    }
}
