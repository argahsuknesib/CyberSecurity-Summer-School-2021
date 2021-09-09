package _m_j;

public final class jnv {

    /* renamed from: O000000o  reason: collision with root package name */
    private volatile boolean f1982O000000o;

    public final synchronized void O000000o(boolean z) {
        if (z) {
            O000000o();
        } else {
            O00000Oo();
        }
    }

    public final synchronized void O000000o() {
        boolean z = this.f1982O000000o;
        this.f1982O000000o = true;
        if (!z) {
            notify();
        }
    }

    public final synchronized void O00000Oo() {
        this.f1982O000000o = false;
    }

    public final synchronized void O00000o0() throws InterruptedException {
        while (!this.f1982O000000o) {
            wait();
        }
    }
}
