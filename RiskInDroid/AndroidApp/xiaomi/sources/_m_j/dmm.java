package _m_j;

import android.content.Context;

final class dmm implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14788O000000o;
    final /* synthetic */ dkf O00000Oo = null;

    dmm(Context context, dkf dkf) {
        this.f14788O000000o = context;
    }

    public final void run() {
        Context context = this.f14788O000000o;
        if (context == null) {
            dke.O0000o.O00000o("The Context of StatService.onPause() can not be null!");
        } else {
            dke.O00000Oo(context, dlv.O0000OOo(context), this.O00000Oo);
        }
    }
}
