package _m_j;

import android.os.HandlerThread;

public class fxz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile HandlerThread f17398O000000o;

    public static HandlerThread O000000o() {
        if (f17398O000000o == null) {
            synchronized (fxz.class) {
                if (f17398O000000o == null) {
                    HandlerThread handlerThread = new HandlerThread("rn-module-worker");
                    handlerThread.start();
                    f17398O000000o = handlerThread;
                }
            }
        }
        return f17398O000000o;
    }
}
