package _m_j;

final class jga implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final jgh f1811O000000o = new jgh();
    private final jgc O00000Oo;

    jga(jgc jgc) {
        this.O00000Oo = jgc;
    }

    public final void O000000o(jgm jgm, Object obj) {
        this.f1811O000000o.O000000o(jgg.O000000o(jgm, obj));
        this.O00000Oo.O00000o0.execute(this);
    }

    public final void run() {
        jgg O000000o2 = this.f1811O000000o.O000000o();
        if (O000000o2 != null) {
            this.O00000Oo.O000000o(O000000o2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
