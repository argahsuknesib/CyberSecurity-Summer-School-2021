package _m_j;

import java.lang.reflect.Type;

public final class bdt {

    /* renamed from: O000000o  reason: collision with root package name */
    public Object f12890O000000o;
    public final bdt O00000Oo;
    private final Object O00000o;
    public Type O00000o0;

    public bdt(bdt bdt, Object obj, Object obj2) {
        this.O00000Oo = bdt;
        this.f12890O000000o = obj;
        this.O00000o = obj2;
    }

    public final String O000000o() {
        if (this.O00000Oo == null) {
            return "$";
        }
        if (this.O00000o instanceof Integer) {
            return this.O00000Oo.O000000o() + "[" + this.O00000o + "]";
        }
        return this.O00000Oo.O000000o() + "." + this.O00000o;
    }

    public final String toString() {
        return O000000o();
    }
}
