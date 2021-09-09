package _m_j;

import android.os.Handler;

public final class gbf {

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f17494O000000o = new Handler(gbe.O000000o().O00000o0());
    public boolean O00000Oo = false;
    public long O00000o = 0;
    public int O00000o0 = 0;
    public long O00000oO = 0;
    public long O00000oo = -1;
    public long O0000O0o = -1;
    public long O0000OOo = -1;
    public Runnable O0000Oo = new Runnable() {
        /* class _m_j.gbf.AnonymousClass1 */

        public final void run() {
            gbf.this.O000000o();
            if (gbf.this.O00000Oo) {
                gbf.this.f17494O000000o.postDelayed(gbf.this.O0000Oo, 1000);
            }
        }
    };
    public long O0000Oo0 = -1;

    public final void O000000o() {
        if (this.O00000o0 + 10 < Integer.MAX_VALUE && this.O00000oO + 1000 < Long.MAX_VALUE) {
            long j = Runtime.getRuntime().totalMemory();
            long freeMemory = j - Runtime.getRuntime().freeMemory();
            long j2 = this.O00000oo;
            if (j2 < 0 || j2 >= freeMemory) {
                j2 = freeMemory;
            }
            this.O00000oo = j2;
            long j3 = this.O0000O0o;
            if (j3 < 0 || j3 <= freeMemory) {
                j3 = freeMemory;
            }
            this.O0000O0o = j3;
            long j4 = this.O0000OOo;
            if (j4 < 0 || j4 >= j) {
                j4 = j;
            }
            this.O0000OOo = j4;
            long j5 = this.O0000Oo0;
            if (j5 < 0 || j5 <= j) {
                j5 = j;
            }
            this.O0000Oo0 = j5;
            this.O00000o0++;
            this.O00000o += freeMemory;
            this.O00000oO += j;
        }
    }
}
