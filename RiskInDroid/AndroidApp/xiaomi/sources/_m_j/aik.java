package _m_j;

public abstract class aik {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f12390O000000o;
    protected int O00000Oo;

    protected aik() {
    }

    public final boolean O000000o() {
        return this.f12390O000000o == 1;
    }

    public final boolean O00000Oo() {
        return this.f12390O000000o == 0;
    }

    public final boolean O00000o0() {
        return this.f12390O000000o == 2;
    }

    public final String O00000o() {
        int i = this.f12390O000000o;
        if (i == 0) {
            return "ROOT";
        }
        if (i != 1) {
            return i != 2 ? "?" : "OBJECT";
        }
        return "ARRAY";
    }

    public final int O00000oO() {
        return this.O00000Oo + 1;
    }

    public final int O00000oo() {
        int i = this.O00000Oo;
        if (i < 0) {
            return 0;
        }
        return i;
    }
}
