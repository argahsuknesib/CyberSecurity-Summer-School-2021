package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;

public final class fvp extends fsz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f17282O000000o = new Object();
    private static volatile fvp O00000Oo;

    private fvp() {
    }

    public static fvp O00000o0() {
        if (O00000Oo == null) {
            synchronized (f17282O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new fvp();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o() {
        if (ftm.O000000o(CommonApplication.getAppContext())) {
            exx.O000000o(false);
        }
    }

    public final void O00000Oo() {
        if (ftm.O000000o(CommonApplication.getAppContext())) {
            exx.O000000o();
        }
    }
}
