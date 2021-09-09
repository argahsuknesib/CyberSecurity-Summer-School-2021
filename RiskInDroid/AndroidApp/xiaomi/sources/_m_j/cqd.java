package _m_j;

import java.util.concurrent.CountDownLatch;

public final class cqd<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    private CountDownLatch f14234O000000o;
    private T O00000Oo;
    private int O00000o0;

    private boolean O00000Oo() {
        return this.f14234O000000o != null;
    }

    public final void O000000o() {
        if (!O00000Oo()) {
            this.O00000o0++;
        }
    }

    public final void O000000o(T t) {
        int i = this.O00000o0;
        if (i > 0) {
            this.O00000o0 = i - 1;
        } else if (O00000Oo()) {
            this.O00000Oo = t;
            this.f14234O000000o.countDown();
        }
    }
}
