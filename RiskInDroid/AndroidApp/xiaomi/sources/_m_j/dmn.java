package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.a.i;

final class dmn implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14789O000000o;
    final /* synthetic */ Throwable O00000Oo;

    dmn(Context context, Throwable th) {
        this.f14789O000000o = context;
        this.O00000Oo = th;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dke.O000000o(android.content.Context, boolean, _m_j.dkf):int
     arg types: [android.content.Context, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.dke.O000000o(android.content.Context, java.lang.String, _m_j.dkf):void
      _m_j.dke.O000000o(android.content.Context, java.lang.String, java.util.Properties):void
      _m_j.dke.O000000o(android.content.Context, java.lang.String, java.lang.String):boolean
      _m_j.dke.O000000o(android.content.Context, boolean, _m_j.dkf):int */
    public final void run() {
        try {
            if (dkd.O00000o0()) {
                new dkv(new dkj(this.f14789O000000o, dke.O000000o(this.f14789O000000o, false, (dkf) null), this.O00000Oo, i.f5886O000000o)).O000000o();
            }
        } catch (Throwable th) {
            dke.O0000o.O00000oO("reportSdkSelfException error: ".concat(String.valueOf(th)));
        }
    }
}
