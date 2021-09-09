package _m_j;

import _m_j.dek;
import android.view.MotionEvent;

public class del extends dec<del> {

    /* renamed from: O000000o  reason: collision with root package name */
    public dek f14550O000000o;
    public double O00000Oo;
    public double O0000oOO;
    private dek.O000000o O0000oOo = new dek.O000000o() {
        /* class _m_j.del.AnonymousClass1 */

        public final boolean O000000o(dek dek) {
            double d = del.this.O00000Oo;
            del.this.O00000Oo += dek.O00000o;
            long j = dek.f14549O000000o - dek.O00000Oo;
            if (j > 0) {
                del del = del.this;
                double d2 = del.O00000Oo - d;
                double d3 = (double) j;
                Double.isNaN(d3);
                del.O0000oOO = d2 / d3;
            }
            if (Math.abs(del.this.O00000Oo) < 0.08726646259971647d || del.this.O0000O0o != 2) {
                return true;
            }
            del.this.O00000oO();
            return true;
        }

        public final void O000000o() {
            del.this.O0000O0o();
        }
    };

    public del() {
        this.O0000Ooo = false;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        this.f14550O000000o = null;
        this.O0000oOO = 0.0d;
        this.O00000Oo = 0.0d;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(MotionEvent motionEvent) {
        int pointerId;
        int i = this.O0000O0o;
        if (i == 0) {
            this.O0000oOO = 0.0d;
            this.O00000Oo = 0.0d;
            this.f14550O000000o = new dek(this.O0000oOo);
            O00000oo();
        }
        dek dek = this.f14550O000000o;
        if (dek != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                dek.O0000O0o = false;
                dek.O0000OOo[0] = motionEvent.getPointerId(motionEvent.getActionIndex());
                dek.O0000OOo[1] = -1;
            } else if (actionMasked == 1) {
                dek.O000000o();
            } else if (actionMasked != 2) {
                if (actionMasked != 5) {
                    if (actionMasked == 6 && dek.O0000O0o && ((pointerId = motionEvent.getPointerId(motionEvent.getActionIndex())) == dek.O0000OOo[0] || pointerId == dek.O0000OOo[1])) {
                        dek.O000000o();
                    }
                } else if (!dek.O0000O0o) {
                    dek.O0000OOo[1] = motionEvent.getPointerId(motionEvent.getActionIndex());
                    dek.O0000O0o = true;
                    dek.O00000Oo = motionEvent.getEventTime();
                    dek.O00000o0 = Double.NaN;
                    dek.O000000o(motionEvent);
                    dek.O000000o o000000o = dek.O0000Oo0;
                }
            } else if (dek.O0000O0o) {
                dek.O000000o(motionEvent);
                if (dek.O0000Oo0 != null) {
                    dek.O0000Oo0.O000000o(dek);
                }
            }
        }
        if (motionEvent.getActionMasked() != 1) {
            return;
        }
        if (i == 4) {
            O0000O0o();
        } else {
            O00000o();
        }
    }
}
