package _m_j;

import android.content.Context;

final class dks implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f14751O000000o;
    final /* synthetic */ dkf O00000Oo = null;

    dks(Context context, dkf dkf) {
        this.f14751O000000o = context;
    }

    public final void run() {
        Context context = this.f14751O000000o;
        if (context == null) {
            dke.O0000o.O00000o("The Context of StatService.onResume() can not be null!");
        } else {
            dke.O000000o(context, dlv.O0000OOo(context), this.O00000Oo);
        }
    }
}
