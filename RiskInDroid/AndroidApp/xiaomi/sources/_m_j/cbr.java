package _m_j;

import android.os.Handler;
import android.os.Looper;

public class cbr {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f13603O000000o = (!cbr.class.desiredAssertionStatus());
    private static final Object O00000Oo = new Object();
    private static Handler O00000o0 = null;

    private static Handler O000000o() {
        Handler handler;
        synchronized (O00000Oo) {
            if (O00000o0 == null) {
                O00000o0 = new Handler(Looper.getMainLooper());
            }
            handler = O00000o0;
        }
        return handler;
    }

    public static void O000000o(Runnable runnable) {
        O000000o().post(runnable);
    }
}
