package _m_j;

import java.util.concurrent.CountDownLatch;

public final class jrb {

    /* renamed from: O000000o  reason: collision with root package name */
    final CountDownLatch f2085O000000o = new CountDownLatch(1);
    long O00000Oo = -1;
    long O00000o0 = -1;

    jrb() {
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.O00000o0 == -1) {
            long j = this.O00000Oo;
            if (j != -1) {
                this.O00000o0 = j - 1;
                this.f2085O000000o.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
