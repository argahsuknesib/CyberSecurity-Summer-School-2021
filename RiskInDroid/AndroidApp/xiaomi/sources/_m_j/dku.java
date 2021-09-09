package _m_j;

import java.lang.Thread;

final class dku implements Thread.UncaughtExceptionHandler {
    dku() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void
     arg types: [_m_j.dkj, ?[OBJECT, ARRAY], int, int]
     candidates:
      _m_j.dkz.O000000o(_m_j.dkz, java.util.List, int, boolean):void
      _m_j.dkz.O000000o(_m_j.dkk, _m_j.dmh, boolean, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dke.O000000o(android.content.Context, boolean, _m_j.dkf):int
     arg types: [android.content.Context, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.dke.O000000o(android.content.Context, java.lang.String, _m_j.dkf):void
      _m_j.dke.O000000o(android.content.Context, java.lang.String, java.util.Properties):void
      _m_j.dke.O000000o(android.content.Context, java.lang.String, java.lang.String):boolean
      _m_j.dke.O000000o(android.content.Context, boolean, _m_j.dkf):int */
    public final void uncaughtException(Thread thread, Throwable th) {
        if (dkd.O00000o0() && dke.O0000oOO != null) {
            if (dkd.O0000o0O()) {
                dkz.O000000o(dke.O0000oOO).O000000o((dkk) new dkj(dke.O0000oOO, dke.O000000o(dke.O0000oOO, false, (dkf) null), th, thread), (dmh) null, false, true);
                dke.O0000o.O00000oo("MTA has caught the following uncaught exception:");
                dke.O0000o.O000000o(th);
            }
            dke.O00000oO(dke.O0000oOO);
            if (dke.O0000oO0 != null) {
                dke.O0000o.O0000O0o("Call the original uncaught exception handler.");
                if (!(dke.O0000oO0 instanceof dku)) {
                    dke.O0000oO0.uncaughtException(thread, th);
                }
            }
        }
    }
}
