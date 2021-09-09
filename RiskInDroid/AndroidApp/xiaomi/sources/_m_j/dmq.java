package _m_j;

import android.content.Context;

final class dmq implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ String f14791O000000o;
    final /* synthetic */ Context O00000Oo;
    final /* synthetic */ dkf O00000o0;

    dmq(String str, Context context, dkf dkf) {
        this.f14791O000000o = str;
        this.O00000Oo = context;
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
        try {
            synchronized (dke.O0000o0O) {
                if (dke.O0000o0O.size() >= dkd.O0000o00()) {
                    dlm O00000oO = dke.O0000o;
                    O00000oO.O00000o("The number of page events exceeds the maximum value " + Integer.toString(dkd.O0000o00()));
                    return;
                }
                String unused = dke.O0000o00 = this.f14791O000000o;
                if (dke.O0000o0O.containsKey(dke.O0000o00)) {
                    dlm O00000oO2 = dke.O0000o;
                    O00000oO2.O00000oO("Duplicate PageID : " + dke.O0000o00 + ", onResume() repeated?");
                    return;
                }
                dke.O0000o0O.put(dke.O0000o00, Long.valueOf(System.currentTimeMillis()));
                dke.O000000o(this.O00000Oo, true, this.O00000o0);
            }
        } catch (Throwable th) {
            dke.O0000o.O00000Oo(th);
            dke.O000000o(this.O00000Oo, th);
        }
    }
}
