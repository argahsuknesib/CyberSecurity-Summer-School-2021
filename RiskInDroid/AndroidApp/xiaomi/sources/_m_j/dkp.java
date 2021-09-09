package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.ap;

final class dkp implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14748O000000o;

    dkp(Context context) {
        this.f14748O000000o = context;
    }

    public final void run() {
        try {
            new Thread(new ap(this.f14748O000000o), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            dke.O0000o.O00000Oo(th);
            dke.O000000o(this.f14748O000000o, th);
        }
    }
}
