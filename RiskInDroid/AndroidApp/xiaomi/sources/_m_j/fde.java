package _m_j;

import _m_j.fdg;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class fde<R, E extends fdg> {
    private Handler mDispatcher;

    public abstract void onFailure(E e);

    public abstract void onSuccess(Object obj);

    public fde() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mDispatcher = new O000000o(this, myLooper);
            return;
        }
        throw new RuntimeException("Async Callback must have Looper");
    }

    public void sendSuccessMessage(R r) {
        Handler handler = this.mDispatcher;
        handler.sendMessage(handler.obtainMessage(0, r));
    }

    public void sendFailureMessage(E e) {
        Handler handler = this.mDispatcher;
        handler.sendMessage(handler.obtainMessage(1, e));
    }

    static class O000000o<R, E extends fdg> extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private fde<R, E> f16098O000000o;

        O000000o(fde fde, Looper looper) {
            super(looper);
            this.f16098O000000o = fde;
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f16098O000000o.onSuccess(message.obj);
            } else if (i == 1) {
                this.f16098O000000o.onFailure((fdg) message.obj);
            }
        }
    }
}
