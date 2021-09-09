package _m_j;

import _m_j.fes;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class feo<R, E extends fes> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler f16187O000000o;

    public abstract void O000000o(fes fes);

    public abstract void O000000o(Object obj);

    public feo() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            this.f16187O000000o = new O000000o(this, Looper.getMainLooper());
        } else {
            this.f16187O000000o = new O000000o(this, myLooper);
        }
    }

    public final void O00000Oo(R r) {
        Handler handler = this.f16187O000000o;
        handler.sendMessage(handler.obtainMessage(1, r));
    }

    public final void O00000Oo(E e) {
        Handler handler = this.f16187O000000o;
        handler.sendMessage(handler.obtainMessage(2, e));
    }

    static class O000000o<R, E extends fes> extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private feo<R, E> f16188O000000o;

        O000000o(feo feo, Looper looper) {
            super(looper);
            this.f16188O000000o = feo;
        }

        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 1) {
                    this.f16188O000000o.O000000o(message.obj);
                } else if (i == 2) {
                    this.f16188O000000o.O000000o((fes) message.obj);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
