package _m_j;

import android.text.TextUtils;

public class cuo extends cve {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f14369O000000o;
    final czb<cve> O00000Oo = new czb<>();
    cve O00000o0 = null;

    public boolean O000000o(cvg cvg) {
        return (this.O00000o0 == null && O00000Oo(cvg) == null) ? false : true;
    }

    public final void O000000o(final cvg cvg, final cvd cvd) {
        cve O00000Oo2 = O00000Oo(cvg);
        if (O00000Oo2 != null) {
            O00000Oo2.O00000Oo(cvg, new cvd() {
                /* class _m_j.cuo.AnonymousClass1 */

                public final void O000000o() {
                    cuo.this.O00000o0(cvg, cvd);
                }

                public final void O000000o(int i) {
                    cvd.O000000o(i);
                }
            });
        } else {
            O00000o0(cvg, cvd);
        }
    }

    public final void O00000o0(cvg cvg, cvd cvd) {
        cve cve = this.O00000o0;
        if (cve != null) {
            cve.O00000Oo(cvg, cvd);
        } else {
            cvd.O000000o();
        }
    }

    private cve O00000Oo(cvg cvg) {
        String path = cvg.O00000Oo.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String O00000o02 = czf.O00000o0(path);
        if (TextUtils.isEmpty(this.f14369O000000o)) {
            return this.O00000Oo.O000000o(O00000o02);
        }
        if (O00000o02.startsWith(this.f14369O000000o)) {
            return this.O00000Oo.O000000o(O00000o02.substring(this.f14369O000000o.length()));
        }
        return null;
    }
}
