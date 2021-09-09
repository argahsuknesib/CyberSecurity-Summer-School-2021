package _m_j;

import android.content.Context;

final class dkt implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14752O000000o;
    final /* synthetic */ dkf O00000Oo = null;

    dkt(Context context, dkf dkf) {
        this.f14752O000000o = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dke.O000000o(android.content.Context, boolean, _m_j.dkf):int
     arg types: [android.content.Context, int, _m_j.dkf]
     candidates:
      _m_j.dke.O000000o(android.content.Context, java.lang.String, _m_j.dkf):void
      _m_j.dke.O000000o(android.content.Context, java.lang.String, java.util.Properties):void
      _m_j.dke.O000000o(android.content.Context, java.lang.String, java.lang.String):boolean
      _m_j.dke.O000000o(android.content.Context, boolean, _m_j.dkf):int */
    public final void run() {
        try {
            dke.O000000o(this.f14752O000000o, false, this.O00000Oo);
        } catch (Throwable th) {
            dke.O0000o.O00000Oo(th);
        }
    }
}
