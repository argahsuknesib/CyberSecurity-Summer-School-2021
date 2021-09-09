package _m_j;

import _m_j.fso;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class fsm<R, E extends fso> {
    private Handler mDispatcher;

    public void onCache(R r) {
    }

    public abstract void onFailure(E e);

    public abstract void onSuccess(R r);

    public fsm() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mDispatcher = new O000000o(this, myLooper);
        } else if (!(this instanceof fsy)) {
            gsy.O000000o(6, "AsyncCallback", "async callback must have looper");
            this.mDispatcher = new O000000o(this, Looper.getMainLooper());
        }
    }

    public void sendCacheMessage(R r) {
        Handler handler = this.mDispatcher;
        handler.sendMessage(handler.obtainMessage(0, r));
    }

    public void sendSuccessMessage(R r) {
        Handler handler = this.mDispatcher;
        handler.sendMessage(handler.obtainMessage(1, r));
    }

    public void sendFailureMessage(E e) {
        Handler handler = this.mDispatcher;
        handler.sendMessage(handler.obtainMessage(2, e));
    }

    static class O000000o<R, E extends fso> extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private fsm<R, E> f17061O000000o;

        O000000o(fsm fsm, Looper looper) {
            super(looper);
            this.f17061O000000o = fsm;
        }

        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    this.f17061O000000o.onCache(message.obj);
                } else if (i == 1) {
                    this.f17061O000000o.onSuccess(message.obj);
                } else if (i == 2) {
                    this.f17061O000000o.onFailure((fso) message.obj);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
