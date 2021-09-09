package _m_j;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

final class job extends joc {
    job(jnw jnw) {
        super(jnw);
    }

    public final void O000000o() {
        long O000000o2 = this.O00000o0.O00000oo.O000000o(this.O00000o0.O00000oO);
        if (O000000o2 >= 0) {
            this.O00000o0.O00000o0 = SystemClock.uptimeMillis() + O000000o2;
            if (this.O00000o0.isVisible() && this.O00000o0.O00000Oo && !this.O00000o0.O0000OOo) {
                this.O00000o0.f1983O000000o.remove(this);
                this.O00000o0.O0000Oo = this.O00000o0.f1983O000000o.schedule(this, O000000o2, TimeUnit.MILLISECONDS);
            }
            if (!this.O00000o0.O0000O0o.isEmpty() && this.O00000o0.O00000oo.O0000Oo0() == this.O00000o0.O00000oo.O0000o0o() - 1) {
                this.O00000o0.O0000Oo0.sendEmptyMessageAtTime(this.O00000o0.O000000o(), this.O00000o0.O00000o0);
            }
        } else {
            this.O00000o0.O00000o0 = Long.MIN_VALUE;
            this.O00000o0.O00000Oo = false;
        }
        if (this.O00000o0.isVisible() && !this.O00000o0.O0000Oo0.hasMessages(-1)) {
            this.O00000o0.O0000Oo0.sendEmptyMessageAtTime(-1, 0);
        }
    }
}
