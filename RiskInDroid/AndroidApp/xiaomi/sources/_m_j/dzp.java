package _m_j;

import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.mipush.sdk.e;

public final class dzp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static long f15102O000000o = 0;
    private static volatile boolean O00000Oo = false;

    public static void O000000o(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (O00000Oo) {
            long j = f15102O000000o;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                f15102O000000o = elapsedRealtime;
                dzl O000000o2 = eay.O000000o(context).O000000o(e.d);
                if (O000000o2 != null) {
                    duv.O000000o("ASSEMBLE_PUSH :  register fun touch os when network change!");
                    O000000o2.O000000o();
                }
            }
        }
    }
}
