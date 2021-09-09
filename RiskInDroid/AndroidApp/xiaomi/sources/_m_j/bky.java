package _m_j;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class bky {

    /* renamed from: O000000o  reason: collision with root package name */
    private static O000000o f13028O000000o = new O000000o() {
        /* class _m_j.bky.AnonymousClass1 */

        public final void O000000o(String str) {
            gsy.O000000o(6, "MICO.ble", str);
        }

        public final void O00000Oo(String str) {
            gsy.O000000o(2, "MICO.ble", str);
        }

        public final void O00000o0(String str) {
            gsy.O000000o(5, "MICO.ble", str);
        }
    };

    public interface O000000o {
        void O000000o(String str);

        void O00000Oo(String str);

        void O00000o0(String str);
    }

    public static void O000000o(String str) {
        f13028O000000o.O000000o(str);
    }

    public static void O00000Oo(String str) {
        f13028O000000o.O00000Oo(str);
    }

    public static void O00000o0(String str) {
        f13028O000000o.O00000o0(str);
    }

    public static void O000000o(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        while (th != null) {
            th.printStackTrace(printWriter);
            th = th.getCause();
        }
        String obj = stringWriter.toString();
        printWriter.close();
        O000000o(obj);
    }
}
