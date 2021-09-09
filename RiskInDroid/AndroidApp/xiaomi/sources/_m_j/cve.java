package _m_j;

public abstract class cve {
    protected cva O00000o;

    /* access modifiers changed from: protected */
    public abstract void O000000o(cvg cvg, cvd cvd);

    /* access modifiers changed from: protected */
    public abstract boolean O000000o(cvg cvg);

    public final cve O000000o(cvf cvf) {
        if (cvf != null) {
            if (this.O00000o == null) {
                this.O00000o = new cva();
            }
            this.O00000o.O000000o(cvf);
        }
        return this;
    }

    public final cve O000000o(cvf... cvfArr) {
        if (cvfArr != null && cvfArr.length > 0) {
            if (this.O00000o == null) {
                this.O00000o = new cva();
            }
            for (cvf O000000o2 : cvfArr) {
                this.O00000o.O000000o(O000000o2);
            }
        }
        return this;
    }

    public void O00000Oo(final cvg cvg, final cvd cvd) {
        if (O000000o(cvg)) {
            Object[] objArr = {this, cvg};
            cvb.O00000o();
            if (this.O00000o == null || cvg.O00000o) {
                O000000o(cvg, cvd);
            } else {
                this.O00000o.O000000o(cvg, new cvd() {
                    /* class _m_j.cve.AnonymousClass1 */

                    public final void O000000o() {
                        cve.this.O000000o(cvg, cvd);
                    }

                    public final void O000000o(int i) {
                        cvd.O000000o(i);
                    }
                });
            }
        } else {
            Object[] objArr2 = {this, cvg};
            cvb.O00000o();
            cvd.O000000o();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
