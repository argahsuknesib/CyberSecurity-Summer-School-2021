package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class glc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Handler f17955O000000o;
    public static Context O0000O0o;
    public static boolean O0000OOo;

    public static void O000000o(Context context, boolean z) {
        O0000O0o = context.getApplicationContext();
        O0000OOo = z;
    }

    public static void O000000o(Runnable runnable, long j) {
        if (f17955O000000o == null) {
            f17955O000000o = new Handler(Looper.getMainLooper());
        }
        f17955O000000o.postDelayed(runnable, j);
    }

    public static String O0000Oo() {
        return Thread.currentThread().getStackTrace()[4].getMethodName();
    }
}
