package _m_j;

import android.content.Context;

final class dko implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14747O000000o;
    final /* synthetic */ int O00000Oo = -1;

    dko(Context context, int i) {
        this.f14747O000000o = context;
    }

    public final void run() {
        try {
            dke.O00000oO(this.f14747O000000o);
            dkz.O000000o(this.f14747O000000o).O000000o(this.O00000Oo);
        } catch (Throwable th) {
            dke.O0000o.O00000Oo(th);
            dke.O000000o(this.f14747O000000o, th);
        }
    }
}
