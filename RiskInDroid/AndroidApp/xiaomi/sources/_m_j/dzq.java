package _m_j;

import android.content.Context;
import com.xiaomi.mipush.sdk.e;

public final class dzq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f15103O000000o = false;

    public static synchronized void O000000o(Context context) {
        synchronized (dzq.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static boolean O000000o() {
        return f15103O000000o;
    }

    public static synchronized boolean O00000Oo(Context context) {
        synchronized (dzq.class) {
            return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1)) > 5000;
        }
    }

    public static void O00000o0(Context context) {
        dzl O000000o2 = eay.O000000o(context).O000000o(e.f6055a);
        if (O000000o2 != null) {
            O000000o2.O000000o();
        }
    }
}
