package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.StatReportStrategy;
import java.util.Timer;
import java.util.TimerTask;

public class dmd {
    private static volatile dmd O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private Timer f14781O000000o = null;
    /* access modifiers changed from: private */
    public Context O00000o0 = null;

    private dmd(Context context) {
        this.O00000o0 = context.getApplicationContext();
        this.f14781O000000o = new Timer(false);
    }

    public static dmd O000000o(Context context) {
        if (O00000Oo == null) {
            synchronized (dmd.class) {
                if (O00000Oo == null) {
                    O00000Oo = new dmd(context);
                }
            }
        }
        return O00000Oo;
    }

    private void O000000o(TimerTask timerTask, long j) {
        if (this.f14781O000000o != null) {
            if (dkd.O00000Oo()) {
                dlv.O00000o0().O000000o("setupPeriodTimer schedule delay:".concat(String.valueOf(j)));
            }
            this.f14781O000000o.schedule(timerTask, j);
        } else if (dkd.O00000Oo()) {
            dlv.O00000o0().O00000o0("setupPeriodTimer schedule timer == null");
        }
    }

    public final void O000000o() {
        if (dkd.O000000o() == StatReportStrategy.PERIOD) {
            long O0000Ooo = (long) (dkd.O0000Ooo() * 60 * 1000);
            if (dkd.O00000Oo()) {
                dlv.O00000o0().O000000o("setupPeriodTimer delay:".concat(String.valueOf(O0000Ooo)));
            }
            O000000o(new dme(this), O0000Ooo);
        }
    }
}
