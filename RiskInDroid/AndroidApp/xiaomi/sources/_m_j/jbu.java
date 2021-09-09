package _m_j;

public final class jbu implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f1748O000000o = false;
    private boolean O00000Oo = false;
    private boolean O00000o = false;
    private boolean O00000o0 = false;

    public final int hashCode() {
        return (((((((this.O00000o0 ? 1 : 0) * true) + (this.O00000o ? 1 : 0)) * 13) + (this.f1748O000000o ? 1 : 0)) * 7) + (this.O00000Oo ? 1 : 0)) * 3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jbu)) {
            return false;
        }
        jbu jbu = (jbu) obj;
        if (jbu.O00000o0 == this.O00000o0 && jbu.O00000o == this.O00000o && jbu.f1748O000000o == this.f1748O000000o && jbu.O00000Oo == this.O00000Oo) {
            return true;
        }
        return false;
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("GeneralPurposeBit is not Cloneable?", e);
        }
    }
}
