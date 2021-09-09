package _m_j;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;

final class byb implements Printer {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f13401O000000o = null;
    private long O00000Oo = 3000;
    private long O00000o = 0;
    private long O00000o0 = 0;
    private boolean O00000oO = false;
    private final boolean O00000oo;

    public interface O000000o {
        void O000000o(long j, long j2, long j3, long j4);
    }

    public byb(O000000o o000000o, long j, boolean z) {
        this.f13401O000000o = o000000o;
        this.O00000Oo = j;
        this.O00000oo = z;
    }

    public final void println(String str) {
        if (this.O00000oo && Debug.isDebuggerConnected()) {
            return;
        }
        if (!this.O00000oO) {
            this.O00000o0 = System.currentTimeMillis();
            this.O00000o = SystemClock.currentThreadTimeMillis();
            this.O00000oO = true;
            if (bxw.O000000o().O00000Oo != null) {
                bxw.O000000o().O00000Oo.O000000o();
            }
            if (bxw.O000000o().O00000o0 != null) {
                bxw.O000000o().O00000o0.O000000o();
                return;
            }
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        this.O00000oO = false;
        if (currentTimeMillis - this.O00000o0 > this.O00000Oo) {
            z = true;
        }
        if (z) {
            final long j = this.O00000o0;
            final long j2 = this.O00000o;
            final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            bxz.O00000Oo().post(new Runnable() {
                /* class _m_j.byb.AnonymousClass1 */

                public final void run() {
                    byb.this.f13401O000000o.O000000o(j, currentTimeMillis, j2, currentThreadTimeMillis);
                }
            });
        }
        if (bxw.O000000o().O00000Oo != null) {
            bxw.O000000o().O00000Oo.O00000Oo();
        }
        if (bxw.O000000o().O00000o0 != null) {
            bxw.O000000o().O00000o0.O00000Oo();
        }
    }
}
