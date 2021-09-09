package _m_j;

public final class bhs {

    /* renamed from: O000000o  reason: collision with root package name */
    final bhs f12978O000000o;
    final Object O00000Oo;
    private final Object O00000o0;

    public bhs(bhs bhs, Object obj, Object obj2) {
        this.f12978O000000o = bhs;
        this.O00000Oo = obj;
        this.O00000o0 = obj2;
    }

    public final String O000000o() {
        if (this.f12978O000000o == null) {
            return "$";
        }
        if (this.O00000o0 instanceof Integer) {
            return this.f12978O000000o.O000000o() + "[" + this.O00000o0 + "]";
        }
        return this.f12978O000000o.O000000o() + "." + this.O00000o0;
    }

    public final String toString() {
        return O000000o();
    }
}
