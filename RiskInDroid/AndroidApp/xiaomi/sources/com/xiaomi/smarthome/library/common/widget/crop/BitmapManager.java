package com.xiaomi.smarthome.library.common.widget.crop;

import android.graphics.BitmapFactory;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class BitmapManager {
    private static BitmapManager O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private final WeakHashMap<Thread, O00000Oo> f9297O000000o = new WeakHashMap<>();

    enum State {
        CANCEL,
        ALLOW
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public State f9299O000000o;
        public BitmapFactory.Options O00000Oo;

        private O00000Oo() {
            this.f9299O000000o = State.ALLOW;
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final String toString() {
            String str;
            if (this.f9299O000000o == State.CANCEL) {
                str = "Cancel";
            } else {
                str = this.f9299O000000o == State.ALLOW ? "Allow" : "?";
            }
            return "thread state = " + str + ", options = " + this.O00000Oo;
        }
    }

    public static class O000000o implements Iterable<Thread> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakHashMap<Thread, Object> f9298O000000o = new WeakHashMap<>();

        public final Iterator<Thread> iterator() {
            return this.f9298O000000o.keySet().iterator();
        }
    }

    private BitmapManager() {
    }

    private synchronized O00000Oo O000000o(Thread thread) {
        O00000Oo o00000Oo;
        o00000Oo = this.f9297O000000o.get(thread);
        if (o00000Oo == null) {
            o00000Oo = new O00000Oo((byte) 0);
            this.f9297O000000o.put(thread, o00000Oo);
        }
        return o00000Oo;
    }

    public final synchronized void O000000o(O000000o o000000o) {
        Iterator<Thread> it = o000000o.iterator();
        while (it.hasNext()) {
            O00000Oo(it.next());
        }
    }

    private synchronized void O00000Oo(Thread thread) {
        O00000Oo O000000o2 = O000000o(thread);
        O000000o2.f9299O000000o = State.CANCEL;
        if (O000000o2.O00000Oo != null) {
            O000000o2.O00000Oo.requestCancelDecode();
        }
        notifyAll();
    }

    public static synchronized BitmapManager O000000o() {
        BitmapManager bitmapManager;
        synchronized (BitmapManager.class) {
            if (O00000Oo == null) {
                O00000Oo = new BitmapManager();
            }
            bitmapManager = O00000Oo;
        }
        return bitmapManager;
    }
}
