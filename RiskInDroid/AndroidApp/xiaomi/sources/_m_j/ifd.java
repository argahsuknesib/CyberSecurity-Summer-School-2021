package _m_j;

public class ifd {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f1256O000000o;
    public final int O00000Oo;

    public ifd(int i, int i2) {
        this.f1256O000000o = i;
        this.O00000Oo = i2;
    }

    public final String toString() {
        return this.f1256O000000o + "(" + this.O00000Oo + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ifd)) {
            return false;
        }
        ifd ifd = (ifd) obj;
        if (this.f1256O000000o == ifd.f1256O000000o && this.O00000Oo == ifd.O00000Oo) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f1256O000000o ^ this.O00000Oo;
    }
}
