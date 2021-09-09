package _m_j;

import android.os.HandlerThread;
import android.os.Looper;

public class gbe {
    public static volatile gbe O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public HandlerThread f17493O000000o;

    private gbe() {
    }

    public static gbe O000000o() {
        if (O00000Oo == null) {
            synchronized (gbe.class) {
                if (O00000Oo == null) {
                    O00000Oo = new gbe();
                }
            }
        }
        return O00000Oo;
    }

    public final void O00000Oo() {
        if (this.f17493O000000o == null) {
            this.f17493O000000o = new HandlerThread("rn_subscriber");
            this.f17493O000000o.start();
        }
    }

    public final Looper O00000o0() {
        O00000Oo();
        return this.f17493O000000o.getLooper();
    }
}
