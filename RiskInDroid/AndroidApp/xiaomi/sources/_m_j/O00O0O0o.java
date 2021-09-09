package _m_j;

import _m_j.vp;
import android.view.View;

public final class O00O0O0o implements vp.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f6626O000000o = 0;
    public int O00000Oo;
    public O000000o O00000o0;

    public interface O000000o {
        void O000000o(View view, int i);
    }

    public O00O0O0o(O000000o o000000o) {
        this.O00000o0 = o000000o;
        this.O00000Oo = 500;
    }

    public final void O000000o(View view, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6626O000000o > ((long) this.O00000Oo)) {
            this.f6626O000000o = currentTimeMillis;
            O000000o o000000o = this.O00000o0;
            if (o000000o != null) {
                o000000o.O000000o(view, i);
            }
        }
    }
}
