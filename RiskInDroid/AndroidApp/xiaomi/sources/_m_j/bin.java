package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;
import java.util.List;

public final class bin implements bim, bir, Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    List<bjl> f13003O000000o = new LinkedList();
    bjl O00000Oo;
    private String O00000o;
    bit O00000o0;
    private Handler O00000oO;

    bin(String str) {
        this.O00000o = str;
        this.O00000o0 = new biq(str, this);
        this.O00000oO = new Handler(Looper.myLooper(), this);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(bjl bjl) {
        O000000o();
        if (this.f13003O000000o.size() < 100) {
            bjl.O0000OOo = this;
            bjl.O000000o(this.O00000o);
            bjl.O000000o(this.O00000o0);
            this.f13003O000000o.add(bjl);
        } else {
            bjl.O00000Oo(-8);
        }
        O00000Oo();
    }

    public final void O00000Oo(bjl bjl) {
        O000000o();
        if (bjl == this.O00000Oo) {
            this.O00000Oo = null;
            O00000Oo();
            return;
        }
        throw new IllegalStateException("request not match");
    }

    private void O00000Oo() {
        this.O00000oO.sendEmptyMessageDelayed(18, 10);
    }

    public final void O000000o() {
        if (Thread.currentThread() != this.O00000oO.getLooper().getThread()) {
            throw new IllegalStateException("Thread Context Illegal");
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 18 || this.O00000Oo != null || blb.O000000o(this.f13003O000000o)) {
            return true;
        }
        this.O00000Oo = this.f13003O000000o.remove(0);
        this.O00000Oo.O000000o(this);
        return true;
    }
}
