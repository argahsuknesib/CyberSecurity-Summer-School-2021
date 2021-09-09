package _m_j;

import android.content.Context;

final class dmp implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14790O000000o;
    final /* synthetic */ dkf O00000Oo = null;
    final /* synthetic */ dki O00000o0;

    dmp(Context context, dkf dkf, dki dki) {
        this.f14790O000000o = context;
        this.O00000o0 = dki;
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
            dkh dkh = new dkh(this.f14790O000000o, dke.O000000o(this.f14790O000000o, false, this.O00000Oo), this.O00000o0.f14742O000000o, this.O00000Oo);
            dkh.O000000o().O00000o0 = this.O00000o0.O00000o0;
            new dkv(dkh).O000000o();
        } catch (Throwable th) {
            dke.O0000o.O00000Oo(th);
            dke.O000000o(this.f14790O000000o, th);
        }
    }
}
