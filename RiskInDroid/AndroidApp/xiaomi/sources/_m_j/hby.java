package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;

public abstract class hby<R> extends fsm<R, fso> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int f18766O000000o = (gfr.f17662O000000o ? 20000 : 5000);
    private boolean O00000Oo;

    public hby(int i) {
        CommonApplication.getGlobalWorkerHandler().postDelayed(new Runnable(i) {
            /* class _m_j.$$Lambda$hby$o3_nMkDpWpWBy9_I7unu2GBEgwo */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                hby.this.O000000o(this.f$1);
            }
        }, (long) i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(int i) {
        sendFailureMessage(new fso(-1, "AyncTimeoutCallback timeout ".concat(String.valueOf(i))));
    }

    public void sendSuccessMessage(R r) {
        if (!this.O00000Oo) {
            this.O00000Oo = true;
            super.sendSuccessMessage(r);
        }
    }

    public synchronized void sendFailureMessage(fso fso) {
        if (!this.O00000Oo) {
            this.O00000Oo = true;
            super.sendFailureMessage(fso);
        }
    }
}
