package _m_j;

import android.util.Log;

public final class cou {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile boolean f14174O000000o = false;
    private static volatile boolean O00000Oo = true;

    public static void O000000o(boolean z) {
        f14174O000000o = z;
    }

    public static void O000000o(String str, Object... objArr) {
        if (f14174O000000o) {
            O000000o(3, null, str, objArr);
        }
    }

    public static void O00000Oo(String str, Object... objArr) {
        O000000o(4, null, str, objArr);
    }

    public static void O00000o0(String str, Object... objArr) {
        O000000o(5, null, str, objArr);
    }

    public static void O000000o(Throwable th) {
        O000000o(6, th, null, new Object[0]);
    }

    public static void O00000o(String str, Object... objArr) {
        O000000o(6, null, str, objArr);
    }

    private static void O000000o(int i, Throwable th, String str, Object... objArr) {
        if (O00000Oo) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format("%1$s\n%2$s", str, Log.getStackTraceString(th));
            }
            Log.println(i, cnx.f14158O000000o, str);
        }
    }
}
