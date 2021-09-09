package _m_j;

public final class aja implements ain {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f12398O000000o;
    protected char[] O00000Oo;

    public aja(String str) {
        this.f12398O000000o = str;
    }

    public final String O000000o() {
        return this.f12398O000000o;
    }

    public final char[] O00000Oo() {
        char[] cArr = this.O00000Oo;
        if (cArr != null) {
            return cArr;
        }
        char[] O000000o2 = aiv.O000000o().O000000o(this.f12398O000000o);
        this.O00000Oo = O000000o2;
        return O000000o2;
    }

    public final String toString() {
        return this.f12398O000000o;
    }

    public final int hashCode() {
        return this.f12398O000000o.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.f12398O000000o.equals(((aja) obj).f12398O000000o);
    }
}
