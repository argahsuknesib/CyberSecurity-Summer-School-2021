package _m_j;

import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.mipush.sdk.e;

public final class dzm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile boolean f15100O000000o = false;
    private static long O00000Oo;

    public static void O000000o() {
    }

    public static void O000000o(Context context, String str) {
        ebb.O000000o(context, e.c, str);
    }

    public static synchronized void O000000o(boolean z) {
        synchronized (dzm.class) {
            f15100O000000o = z;
        }
    }

    public static boolean O000000o(Context context) {
        return ebb.O00000o0(context);
    }

    public static void O00000Oo(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f15100O000000o) {
            long j = O00000Oo;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                O00000Oo = elapsedRealtime;
                dzl O000000o2 = eay.O000000o(context).O000000o(e.c);
                if (O000000o2 != null) {
                    duv.O000000o("ASSEMBLE_PUSH :  register cos when network change!");
                    O000000o2.O000000o();
                }
            }
        }
    }
}
