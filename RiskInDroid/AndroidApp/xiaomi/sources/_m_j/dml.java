package _m_j;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.StatReportStrategy;
import java.lang.Thread;

final class dml implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14787O000000o;

    dml(Context context) {
        this.f14787O000000o = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dlv.O000000o(android.content.Context, boolean):int
     arg types: [android.content.Context, int]
     candidates:
      _m_j.dlv.O000000o(android.content.Context, java.lang.String):java.lang.String
      _m_j.dlv.O000000o(android.content.Context, int):void
      _m_j.dlv.O000000o(android.content.Context, boolean):int */
    public final void run() {
        dkg O000000o2 = dkg.O000000o(dke.O0000oOO);
        O000000o2.O00000oo.getApplicationContext().registerReceiver(new dlf(O000000o2), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        dlv.O000000o(this.f14787O000000o, true);
        dkz.O000000o(this.f14787O000000o);
        dmi.O00000Oo(this.f14787O000000o);
        Thread.UncaughtExceptionHandler unused = dke.O0000oO0 = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new dku());
        if (dkd.O000000o() == StatReportStrategy.APP_LAUNCH) {
            dke.O00000o(this.f14787O000000o);
        }
        if (dkd.O00000Oo()) {
            dke.O0000o.O0000O0o("Init MTA StatService success.");
        }
    }
}
