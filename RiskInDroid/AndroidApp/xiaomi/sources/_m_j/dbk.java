package _m_j;

public final class dbk {

    /* renamed from: O000000o  reason: collision with root package name */
    public final float f14452O000000o;
    public final float O00000Oo;

    public dbk(float f, float f2) {
        this.f14452O000000o = f;
        this.O00000Oo = f2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof dbk) {
            dbk dbk = (dbk) obj;
            return this.f14452O000000o == dbk.f14452O000000o && this.O00000Oo == dbk.O00000Oo;
        }
    }

    public final String toString() {
        return this.f14452O000000o + "x" + this.O00000Oo;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f14452O000000o) ^ Float.floatToIntBits(this.O00000Oo);
    }
}
