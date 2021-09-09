package _m_j;

import android.os.Handler;
import android.os.HandlerThread;

final class bxz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static O000000o f13397O000000o = new O000000o("loop");
    private static O000000o O00000Oo = new O000000o("writer");
    private static O000000o O00000o0 = new O000000o("upload");

    public static Handler O000000o() {
        return f13397O000000o.f13398O000000o;
    }

    public static Handler O00000Oo() {
        return O00000Oo.f13398O000000o;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Handler f13398O000000o = null;

        public O000000o(String str) {
            HandlerThread handlerThread = new HandlerThread("BlockCanary-".concat(String.valueOf(str)));
            handlerThread.start();
            this.f13398O000000o = new Handler(handlerThread.getLooper());
        }
    }
}
