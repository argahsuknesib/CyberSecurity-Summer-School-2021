package _m_j;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class OO00o00 {

    /* renamed from: O000000o  reason: collision with root package name */
    final ArrayList<ce> f12288O000000o = new ArrayList<>();
    cf O00000Oo;
    private long O00000o = -1;
    boolean O00000o0;
    private Interpolator O00000oO;
    private final cg O00000oo = new cg() {
        /* class _m_j.OO00o00.AnonymousClass1 */
        private boolean O00000Oo = false;
        private int O00000o0 = 0;

        public final void O000000o(View view) {
            if (!this.O00000Oo) {
                this.O00000Oo = true;
                if (OO00o00.this.O00000Oo != null) {
                    OO00o00.this.O00000Oo.O000000o(null);
                }
            }
        }

        public final void O00000Oo(View view) {
            int i = this.O00000o0 + 1;
            this.O00000o0 = i;
            if (i == OO00o00.this.f12288O000000o.size()) {
                if (OO00o00.this.O00000Oo != null) {
                    OO00o00.this.O00000Oo.O00000Oo(null);
                }
                this.O00000o0 = 0;
                this.O00000Oo = false;
                OO00o00.this.O00000o0 = false;
            }
        }
    };

    public final OO00o00 O000000o(ce ceVar) {
        if (!this.O00000o0) {
            this.f12288O000000o.add(ceVar);
        }
        return this;
    }

    public final OO00o00 O000000o(ce ceVar, ce ceVar2) {
        this.f12288O000000o.add(ceVar);
        ceVar2.O00000Oo(ceVar.O000000o());
        this.f12288O000000o.add(ceVar2);
        return this;
    }

    public final void O000000o() {
        if (!this.O00000o0) {
            Iterator<ce> it = this.f12288O000000o.iterator();
            while (it.hasNext()) {
                ce next = it.next();
                long j = this.O00000o;
                if (j >= 0) {
                    next.O000000o(j);
                }
                Interpolator interpolator = this.O00000oO;
                if (interpolator != null) {
                    next.O000000o(interpolator);
                }
                if (this.O00000Oo != null) {
                    next.O000000o(this.O00000oo);
                }
                next.O00000o0();
            }
            this.O00000o0 = true;
        }
    }

    public final void O00000Oo() {
        if (this.O00000o0) {
            Iterator<ce> it = this.f12288O000000o.iterator();
            while (it.hasNext()) {
                it.next().O00000Oo();
            }
            this.O00000o0 = false;
        }
    }

    public final OO00o00 O00000o0() {
        if (!this.O00000o0) {
            this.O00000o = 250;
        }
        return this;
    }

    public final OO00o00 O000000o(Interpolator interpolator) {
        if (!this.O00000o0) {
            this.O00000oO = interpolator;
        }
        return this;
    }

    public final OO00o00 O000000o(cf cfVar) {
        if (!this.O00000o0) {
            this.O00000Oo = cfVar;
        }
        return this;
    }
}
