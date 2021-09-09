package _m_j;

public final class cod {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f14165O000000o;
    public final int O00000Oo;

    public cod(int i, int i2) {
        this.f14165O000000o = i;
        this.O00000Oo = i2;
    }

    public cod(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.f14165O000000o = i;
            this.O00000Oo = i2;
            return;
        }
        this.f14165O000000o = i2;
        this.O00000Oo = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.f14165O000000o);
        sb.append("x");
        sb.append(this.O00000Oo);
        return sb.toString();
    }
}
