package _m_j;

import java.util.concurrent.Semaphore;
import rx.subjects.ReplaySubject;

public abstract class crd<T> implements Comparable<crd>, Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ReplaySubject<T> f14271O000000o = ReplaySubject.create();
    protected Semaphore O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f14272O000000o = new O000000o(100);
        public static final O000000o O00000Oo = new O000000o(50);
        public static final O000000o O00000o0 = new O000000o(0);
        public final int O00000o;

        private O000000o(int i) {
            this.O00000o = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Throwable th) {
        this.O00000Oo.release();
        this.f14271O000000o.onError(th);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return O000000o.O00000Oo.O00000o - O000000o.O00000Oo.O00000o;
    }
}
