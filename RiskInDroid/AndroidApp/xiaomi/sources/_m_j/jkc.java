package _m_j;

public final class jkc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static jkc f1895O000000o = new jkc(0, 0, 0);
    public static jkc O00000Oo = new jkc(1, 2, 2);
    public static jkc O00000o = new jkc(3, 1, 1);
    public static jkc O00000o0 = new jkc(2, 2, 1);
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;

    private jkc(int i, int i2, int i3) {
        this.O00000oO = i;
        this.O00000oo = i2;
        this.O0000O0o = i3;
    }

    public static jkc O000000o(int i) {
        jkc jkc = f1895O000000o;
        if (i == jkc.O00000oO) {
            return jkc;
        }
        jkc jkc2 = O00000Oo;
        if (i == jkc2.O00000oO) {
            return jkc2;
        }
        jkc jkc3 = O00000o0;
        if (i == jkc3.O00000oO) {
            return jkc3;
        }
        jkc jkc4 = O00000o;
        if (i == jkc4.O00000oO) {
            return jkc4;
        }
        return null;
    }

    public final String toString() {
        return "ChromaFormat{\nid=" + this.O00000oO + ",\n subWidth=" + this.O00000oo + ",\n subHeight=" + this.O0000O0o + '}';
    }
}
