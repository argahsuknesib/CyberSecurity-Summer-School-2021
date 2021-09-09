package _m_j;

public final class bnw {

    /* renamed from: O000000o  reason: collision with root package name */
    volatile int f13150O000000o;
    volatile bny O00000Oo;
    private volatile bnv[] O00000o;
    private volatile bny O00000o0;

    public bnw(int i, int i2) {
        if (i2 > 0) {
            this.O00000o = new bnv[3];
            for (int i3 = 0; i3 < 3; i3++) {
                this.O00000o[i3] = new bnv(i2);
            }
            this.O00000Oo = new boc(3);
            this.O00000o0 = new boc(3);
            this.f13150O000000o = 2;
            return;
        }
        bnz.O000000o("BufferQueue", "BufferQueue param error, bufferCount:3" + "  bufferSize:" + i2);
    }

    public final void O000000o() {
        if (2 != this.f13150O000000o) {
            return;
        }
        if (this.O00000Oo == null || this.O00000o0 == null) {
            bnz.O000000o("BufferQueue", "set queue is null");
            return;
        }
        for (bnv bnv : this.O00000o) {
            bnv.O00000Oo = 0;
        }
        this.O00000Oo.O000000o(this.O00000o);
        this.O00000o0.O000000o((bnv[]) null);
        this.f13150O000000o = 1;
    }

    public final void O00000Oo() {
        if (1 != this.f13150O000000o) {
            return;
        }
        if (this.O00000Oo == null || this.O00000o0 == null) {
            bnz.O000000o("BufferQueue", "reset queue is null");
            return;
        }
        this.f13150O000000o = 2;
        this.O00000Oo.O000000o();
        this.O00000o0.O000000o();
    }

    public final boolean O000000o(bnv bnv) {
        if (1 != this.f13150O000000o) {
            return false;
        }
        if (this.O00000Oo != null) {
            return this.O00000Oo.O000000o(bnv);
        }
        bnz.O000000o("BufferQueue", "putEmpty queue is null");
        return false;
    }

    public final bnv O00000o0() {
        if (1 != this.f13150O000000o) {
            return null;
        }
        if (this.O00000o0 != null) {
            return this.O00000o0.O00000Oo();
        }
        bnz.O000000o("BufferQueue", "getFull queue is null");
        return null;
    }

    public final boolean O00000Oo(bnv bnv) {
        if (this.O00000o0 != null) {
            return this.O00000o0.O000000o(bnv);
        }
        bnz.O000000o("BufferQueue", "putFull queue is null");
        return false;
    }
}
