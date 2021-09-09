package _m_j;

import java.util.Iterator;

public class cuz extends cve {

    /* renamed from: O000000o  reason: collision with root package name */
    private final czd<cve> f14378O000000o = new czd<>((byte) 0);

    public cuz O000000o(cve cve, int i) {
        this.f14378O000000o.O000000o(cve, i);
        return this;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(cvg cvg) {
        return !this.f14378O000000o.isEmpty();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(cvg cvg, cvd cvd) {
        O000000o(this.f14378O000000o.iterator(), cvg, cvd);
    }

    public final void O000000o(final Iterator<cve> it, final cvg cvg, final cvd cvd) {
        if (it.hasNext()) {
            it.next().O00000Oo(cvg, new cvd() {
                /* class _m_j.cuz.AnonymousClass1 */

                public final void O000000o() {
                    cuz.this.O000000o(it, cvg, cvd);
                }

                public final void O000000o(int i) {
                    cvd.O000000o(i);
                }
            });
        } else {
            cvd.O000000o();
        }
    }
}
