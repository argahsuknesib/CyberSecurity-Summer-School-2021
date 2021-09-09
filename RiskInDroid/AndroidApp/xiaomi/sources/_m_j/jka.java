package _m_j;

public final class jka {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jka f1893O000000o = new jka(255);
    private int O00000Oo;

    private jka(int i) {
        this.O00000Oo = i;
    }

    public static jka O000000o(int i) {
        jka jka = f1893O000000o;
        if (i == jka.O00000Oo) {
            return jka;
        }
        return new jka(i);
    }

    public final String toString() {
        return "AspectRatio{" + "value=" + this.O00000Oo + '}';
    }
}
