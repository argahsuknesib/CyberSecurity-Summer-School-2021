package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.youpin.login.entity.Error;

public abstract class ibh<R, E extends Error> {
    private Handler mDispatcher;

    public abstract void onFailure(E e);

    public abstract void onSuccess(R r);

    public ibh() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mDispatcher = new O000000o(this, myLooper);
        } else if (!(this instanceof icg)) {
            gsy.O000000o(6, "AsyncCallback", "async callback must have looper");
            this.mDispatcher = new O000000o(this, Looper.getMainLooper());
        }
    }

    public void sendSuccessMessage(R r) {
        Handler handler = this.mDispatcher;
        handler.sendMessage(handler.obtainMessage(1, r));
    }

    public void sendFailureMessage(E e) {
        Handler handler = this.mDispatcher;
        handler.sendMessage(handler.obtainMessage(2, e));
    }

    static class O000000o<R, E extends Error> extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private ibh<R, E> f1151O000000o;

        O000000o(ibh ibh, Looper looper) {
            super(looper);
            this.f1151O000000o = ibh;
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.f1151O000000o.onSuccess(message.obj);
            } else if (i == 2) {
                this.f1151O000000o.onFailure((Error) message.obj);
            }
        }
    }
}
