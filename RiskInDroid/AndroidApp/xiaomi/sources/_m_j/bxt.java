package _m_j;

import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class bxt {

    /* renamed from: O000000o  reason: collision with root package name */
    protected AtomicBoolean f13389O000000o = new AtomicBoolean(false);
    protected long O00000Oo;
    public Runnable O00000o0 = new Runnable() {
        /* class _m_j.bxt.AnonymousClass1 */

        public final void run() {
            bxt.this.O00000o0();
            if (bxt.this.f13389O000000o.get()) {
                bxz.O000000o().postDelayed(bxt.this.O00000o0, bxt.this.O00000Oo);
            }
        }
    };

    /* access modifiers changed from: package-private */
    public abstract void O00000o0();

    public bxt(long j) {
        this.O00000Oo = 0 == j ? 300 : j;
    }

    public void O000000o() {
        if (!this.f13389O000000o.get()) {
            this.f13389O000000o.set(true);
            bxz.O000000o().removeCallbacks(this.O00000o0);
            Handler O000000o2 = bxz.O000000o();
            Runnable runnable = this.O00000o0;
            double d = (double) this.O00000Oo;
            Double.isNaN(d);
            O000000o2.postDelayed(runnable, (long) (d * 0.8d));
        }
    }

    public final void O00000Oo() {
        if (this.f13389O000000o.get()) {
            this.f13389O000000o.set(false);
            bxz.O000000o().removeCallbacks(this.O00000o0);
        }
    }
}
