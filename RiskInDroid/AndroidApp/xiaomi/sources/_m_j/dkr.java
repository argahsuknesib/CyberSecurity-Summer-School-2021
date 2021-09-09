package _m_j;

import android.content.Context;

final class dkr implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14750O000000o;
    final /* synthetic */ String O00000Oo;
    final /* synthetic */ dkf O00000o0;

    dkr(Context context, String str, dkf dkf) {
        this.f14750O000000o = context;
        this.O00000Oo = str;
        this.O00000o0 = dkf;
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
        Long l;
        try {
            dke.O00000oO(this.f14750O000000o);
            synchronized (dke.O0000o0O) {
                l = (Long) dke.O0000o0O.remove(this.O00000Oo);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = 1L;
                }
                Long l2 = valueOf;
                String O0000Oo0 = dke.O0000o0;
                if (O0000Oo0 != null && O0000Oo0.equals(this.O00000Oo)) {
                    O0000Oo0 = "-";
                }
                dkm dkm = new dkm(this.f14750O000000o, O0000Oo0, this.O00000Oo, dke.O000000o(this.f14750O000000o, false, this.O00000o0), l2, this.O00000o0);
                if (!this.O00000Oo.equals(dke.O0000o00)) {
                    dke.O0000o.O00000Oo("Invalid invocation since previous onResume on diff page.");
                }
                new dkv(dkm).O000000o();
                String unused = dke.O0000o0 = this.O00000Oo;
                return;
            }
            dlm O00000oO = dke.O0000o;
            O00000oO.O00000oO("Starttime for PageID:" + this.O00000Oo + " not found, lost onResume()?");
        } catch (Throwable th) {
            dke.O0000o.O00000Oo(th);
            dke.O000000o(this.f14750O000000o, th);
        }
    }
}
