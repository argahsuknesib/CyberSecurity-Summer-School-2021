package _m_j;

import _m_j.elr;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class els extends Handler {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ elr f15614O000000o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    els(elr elr, Looper looper) {
        super(looper);
        this.f15614O000000o = elr;
    }

    public final void handleMessage(Message message) {
        elr.O00000Oo o00000Oo = (elr.O00000Oo) message.obj;
        if (message.what == 0) {
            o00000Oo.a();
        } else if (message.what == 1) {
            o00000Oo.c();
        }
        super.handleMessage(message);
    }
}
