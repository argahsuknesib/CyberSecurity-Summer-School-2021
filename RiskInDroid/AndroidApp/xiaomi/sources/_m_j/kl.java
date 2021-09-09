package _m_j;

import java.io.Closeable;

public final class kl implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f2140O000000o;
    private km O00000Oo;
    private boolean O00000o;
    private Runnable O00000o0;

    public final void close() {
        synchronized (this.f2140O000000o) {
            if (!this.O00000o) {
                this.O00000o = true;
                km kmVar = this.O00000Oo;
                synchronized (kmVar.f2141O000000o) {
                    kmVar.O00000Oo();
                    kmVar.O00000Oo.remove(this);
                }
                this.O00000Oo = null;
                this.O00000o0 = null;
            }
        }
    }
}
