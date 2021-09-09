package _m_j;

import android.os.Process;
import android.util.Log;
import java.io.PrintStream;

public final class imc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1459O000000o = false;

    public static void O000000o(Object obj) {
        if (f1459O000000o) {
            System.out.println(obj);
        } else if (iml.f1476O000000o) {
            Log.i("ting", String.valueOf(obj));
        }
    }

    public static void O000000o(String str, Object obj) {
        if (iml.f1476O000000o && obj != null && !str.equals("dl_mp3")) {
            Log.i(str, "JTid(" + Long.toString(Thread.currentThread().getId()) + ")STid(" + Process.myTid() + ")SPid(" + Process.myPid() + ")" + obj);
        }
    }

    public static void O000000o(String str, String str2) {
        if (f1459O000000o) {
            PrintStream printStream = System.out;
            printStream.println(str + "  " + str2);
        } else if (str2 != null && O000000o(3)) {
            Log.d(str, str2);
        }
    }

    public static void O00000Oo(String str, String str2) {
        if (str2 != null && O000000o(5)) {
            Log.w(str, str2);
        }
    }

    private static boolean O000000o(int i) {
        return iml.f1476O000000o && i >= 0;
    }
}
