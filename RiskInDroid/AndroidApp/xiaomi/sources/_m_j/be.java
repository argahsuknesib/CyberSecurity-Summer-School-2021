package _m_j;

public class be<F, S> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final F f12896O000000o;
    public final S O00000Oo;

    public be(F f, S s) {
        this.f12896O000000o = f;
        this.O00000Oo = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof be)) {
            return false;
        }
        be beVar = (be) obj;
        if (!bd.O000000o(beVar.f12896O000000o, this.f12896O000000o) || !bd.O000000o(beVar.O00000Oo, this.O00000Oo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f = this.f12896O000000o;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.O00000Oo;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f12896O000000o) + " " + String.valueOf(this.O00000Oo) + "}";
    }

    public static <A, B> be<A, B> O000000o(A a2, B b) {
        return new be<>(a2, b);
    }
}
