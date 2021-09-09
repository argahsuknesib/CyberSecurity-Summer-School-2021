package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class bkg implements Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler f13016O000000o;
    private Handler O00000Oo;

    public abstract void O000000o();

    public abstract void O00000o0(Object... objArr);

    public bkg() {
        if (Looper.myLooper() != null) {
            this.f13016O000000o = new Handler(Looper.myLooper(), this);
            this.O00000Oo = new Handler(Looper.getMainLooper(), this);
            return;
        }
        throw new IllegalStateException();
    }

    public boolean handleMessage(Message message) {
        Object[] objArr = (Object[]) message.obj;
        int i = message.what;
        if (i == 1) {
            O00000o0(objArr);
        } else if (i == 2) {
            O000000o();
        }
        return true;
    }

    public final void O000000o(Object... objArr) {
        this.f13016O000000o.obtainMessage(1, objArr).sendToTarget();
    }

    public final void O00000Oo(Object... objArr) {
        this.O00000Oo.obtainMessage(2, objArr).sendToTarget();
    }
}
