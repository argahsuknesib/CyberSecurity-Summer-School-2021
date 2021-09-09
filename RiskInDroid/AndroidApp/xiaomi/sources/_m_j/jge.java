package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBusException;

final class jge extends Handler {

    /* renamed from: O000000o  reason: collision with root package name */
    private final jgh f1818O000000o = new jgh();
    private final int O00000Oo = 10;
    private boolean O00000o;
    private final jgc O00000o0;

    jge(jgc jgc, Looper looper) {
        super(looper);
        this.O00000o0 = jgc;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(jgm jgm, Object obj) {
        jgg O000000o2 = jgg.O000000o(jgm, obj);
        synchronized (this) {
            this.f1818O000000o.O000000o(O000000o2);
            if (!this.O00000o) {
                this.O00000o = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                jgg O000000o2 = this.f1818O000000o.O000000o();
                if (O000000o2 == null) {
                    synchronized (this) {
                        O000000o2 = this.f1818O000000o.O000000o();
                        if (O000000o2 == null) {
                            this.O00000o = false;
                            this.O00000o = false;
                            return;
                        }
                    }
                }
                this.O00000o0.O000000o(O000000o2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.O00000Oo));
            if (sendMessage(obtainMessage())) {
                this.O00000o = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.O00000o = false;
            throw th;
        }
    }
}
