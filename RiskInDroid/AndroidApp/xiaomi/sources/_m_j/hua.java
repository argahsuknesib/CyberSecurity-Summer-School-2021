package _m_j;

import _m_j.hud;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class hua<R, E extends hud> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler f691O000000o;

    public abstract void O000000o(E e);

    public abstract void O000000o(R r);

    public hua() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            this.f691O000000o = new O000000o(this, Looper.getMainLooper());
        } else {
            this.f691O000000o = new O000000o(this, myLooper);
        }
    }

    public final void O00000Oo(R r) {
        Handler handler = this.f691O000000o;
        handler.sendMessage(handler.obtainMessage(1, r));
    }

    public final void O00000Oo(E e) {
        Handler handler = this.f691O000000o;
        handler.sendMessage(handler.obtainMessage(2, e));
    }

    static class O000000o<R, E extends hud> extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private hua<R, E> f692O000000o;

        O000000o(hua hua, Looper looper) {
            super(looper);
            this.f692O000000o = hua;
        }

        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 1) {
                    this.f692O000000o.O000000o(message.obj);
                } else if (i == 2) {
                    this.f692O000000o.O000000o((hud) message.obj);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
