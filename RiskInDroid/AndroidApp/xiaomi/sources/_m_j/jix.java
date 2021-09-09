package _m_j;

public final class jix {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jix f1870O000000o = new jix(255);
    private int O00000Oo;

    private jix(int i) {
        this.O00000Oo = i;
    }

    public static jix O000000o(int i) {
        jix jix = f1870O000000o;
        if (i == jix.O00000Oo) {
            return jix;
        }
        return new jix(i);
    }

    public final String toString() {
        return "AspectRatio{" + "value=" + this.O00000Oo + '}';
    }
}
