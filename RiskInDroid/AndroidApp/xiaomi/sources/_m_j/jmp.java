package _m_j;

public final class jmp {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f1962O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;

    public jmp(int i, int i2) {
        this(i, i2, 0);
    }

    public jmp(int i, int i2, int i3) {
        this(i, i2, i3, -1);
    }

    public jmp(int i, int i2, int i3, int i4) {
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.f1962O000000o = i4;
        this.O00000o = i3;
    }

    private boolean O00000o0() {
        return this.O00000o % 180 == 90;
    }

    public final int O000000o() {
        if (O00000o0()) {
            return this.O00000o0;
        }
        return this.O00000Oo;
    }

    public final int O00000Oo() {
        if (O00000o0()) {
            return this.O00000Oo;
        }
        return this.O00000o0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jmp)) {
            return super.equals(obj);
        }
        jmp jmp = (jmp) obj;
        return jmp.O000000o() == O000000o() && jmp.O00000Oo() == O00000Oo() && jmp.f1962O000000o == this.f1962O000000o && jmp.O00000o == this.O00000o;
    }
}
