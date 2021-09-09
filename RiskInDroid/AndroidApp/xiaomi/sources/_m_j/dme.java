package _m_j;

import java.util.TimerTask;

final class dme extends TimerTask {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ dmd f14782O000000o;

    dme(dmd dmd) {
        this.f14782O000000o = dmd;
    }

    public final void run() {
        if (dkd.O00000Oo()) {
            dlv.O00000o0().O000000o("TimerTask run");
        }
        dke.O00000oo(this.f14782O000000o.O00000o0);
        cancel();
        this.f14782O000000o.O000000o();
    }
}
