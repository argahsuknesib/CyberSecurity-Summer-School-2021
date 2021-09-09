package _m_j;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class cva implements cvf {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<cvf> f14380O000000o = new LinkedList();

    public final void O000000o(cvf cvf) {
        if (cvf != null) {
            this.f14380O000000o.add(cvf);
        }
    }

    public final void O000000o(cvg cvg, cvd cvd) {
        O000000o(this.f14380O000000o.iterator(), cvg, cvd);
    }

    public final void O000000o(final Iterator<cvf> it, final cvg cvg, final cvd cvd) {
        if (it.hasNext()) {
            cvf next = it.next();
            if (cvb.O00000o0()) {
                Object[] objArr = {next.getClass().getSimpleName(), cvg};
                cvb.O00000o();
            }
            next.O000000o(cvg, new cvd() {
                /* class _m_j.cva.AnonymousClass1 */

                public final void O000000o() {
                    cva.this.O000000o(it, cvg, cvd);
                }

                public final void O000000o(int i) {
                    cvd.O000000o(i);
                }
            });
            return;
        }
        cvd.O000000o();
    }
}
