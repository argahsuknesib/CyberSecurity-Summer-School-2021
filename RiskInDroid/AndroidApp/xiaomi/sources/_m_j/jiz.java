package _m_j;

public final class jiz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static jiz f1871O000000o = new jiz(0, 0, 0);
    public static jiz O00000Oo = new jiz(1, 2, 2);
    public static jiz O00000o = new jiz(3, 1, 1);
    public static jiz O00000o0 = new jiz(2, 2, 1);
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;

    private jiz(int i, int i2, int i3) {
        this.O00000oO = i;
        this.O00000oo = i2;
        this.O0000O0o = i3;
    }

    public static jiz O000000o(int i) {
        jiz jiz = f1871O000000o;
        if (i == jiz.O00000oO) {
            return jiz;
        }
        jiz jiz2 = O00000Oo;
        if (i == jiz2.O00000oO) {
            return jiz2;
        }
        jiz jiz3 = O00000o0;
        if (i == jiz3.O00000oO) {
            return jiz3;
        }
        jiz jiz4 = O00000o;
        if (i == jiz4.O00000oO) {
            return jiz4;
        }
        return null;
    }

    public final String toString() {
        return "ChromaFormat{\nid=" + this.O00000oO + ",\n subWidth=" + this.O00000oo + ",\n subHeight=" + this.O0000O0o + '}';
    }
}
