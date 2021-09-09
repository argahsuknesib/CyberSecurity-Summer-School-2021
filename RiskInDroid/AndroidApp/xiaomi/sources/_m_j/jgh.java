package _m_j;

final class jgh {

    /* renamed from: O000000o  reason: collision with root package name */
    private jgg f1821O000000o;
    private jgg O00000Oo;

    jgh() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(jgg jgg) {
        if (jgg != null) {
            try {
                if (this.O00000Oo != null) {
                    this.O00000Oo.O00000o0 = jgg;
                    this.O00000Oo = jgg;
                } else if (this.f1821O000000o == null) {
                    this.O00000Oo = jgg;
                    this.f1821O000000o = jgg;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized jgg O000000o() {
        jgg jgg;
        jgg = this.f1821O000000o;
        if (this.f1821O000000o != null) {
            this.f1821O000000o = this.f1821O000000o.O00000o0;
            if (this.f1821O000000o == null) {
                this.O00000Oo = null;
            }
        }
        return jgg;
    }

    /* access modifiers changed from: package-private */
    public final synchronized jgg O00000Oo() throws InterruptedException {
        if (this.f1821O000000o == null) {
            wait(1000);
        }
        return O000000o();
    }
}
