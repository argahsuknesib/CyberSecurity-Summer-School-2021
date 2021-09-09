package _m_j;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public final class fvk extends Handler {

    /* renamed from: O000000o  reason: collision with root package name */
    WeakReference<O000000o> f17279O000000o;

    public interface O000000o {
        void handleMessage(Message message);
    }

    public fvk(O000000o o000000o) {
        this.f17279O000000o = new WeakReference<>(o000000o);
    }

    public final void handleMessage(Message message) {
        WeakReference<O000000o> weakReference = this.f17279O000000o;
        if (weakReference != null) {
            O000000o o000000o = weakReference.get();
            if ((o000000o instanceof Activity) && !((Activity) o000000o).isFinishing()) {
                o000000o.handleMessage(message);
            }
        }
    }
}
