package _m_j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeoutException;

public final class gll {

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler f17988O000000o = new Handler(Looper.getMainLooper());
    private O000000o O00000Oo;

    gll() {
    }

    public static abstract class O000000o implements Runnable {
        String O00000Oo;

        public abstract void O000000o() throws TimeoutException;

        public abstract void O00000Oo();

        public O000000o(String str) {
            this.O00000Oo = str;
        }

        public final void run() {
            gnk.O00000Oo(String.format("%s: Timer expired!!!", this.O00000Oo));
            try {
                O000000o();
            } catch (TimeoutException e) {
                gnk.O00000Oo(gnk.O00000Oo(e));
            }
            O00000Oo();
        }
    }

    public final synchronized void O000000o() {
        this.O00000Oo = null;
    }

    public final synchronized void O00000Oo() {
        this.f17988O000000o.removeCallbacksAndMessages(null);
        this.O00000Oo = null;
    }

    public final synchronized boolean O00000o0() {
        return this.O00000Oo != null;
    }

    public final synchronized String O00000o() {
        if (!O00000o0()) {
            return "";
        }
        return this.O00000Oo.O00000Oo;
    }

    public final synchronized void O000000o(O000000o o000000o, long j) {
        this.f17988O000000o.removeCallbacksAndMessages(null);
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        this.f17988O000000o = new Handler(myLooper);
        this.f17988O000000o.postDelayed(o000000o, j);
        this.O00000Oo = o000000o;
    }
}
