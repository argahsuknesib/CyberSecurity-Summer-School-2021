package _m_j;

public final class dga {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f14594O000000o;
    public final boolean O00000Oo;
    public final boolean O00000o0;

    public dga(String str, boolean z, boolean z2) {
        this.f14594O000000o = str;
        this.O00000Oo = z;
        this.O00000o0 = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        dga dga = (dga) obj;
        if (this.O00000Oo == dga.O00000Oo && this.O00000o0 == dga.O00000o0) {
            return this.f14594O000000o.equals(dga.f14594O000000o);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f14594O000000o.hashCode() * 31) + (this.O00000Oo ? 1 : 0)) * 31) + (this.O00000o0 ? 1 : 0);
    }

    public final String toString() {
        return "Permission{name='" + this.f14594O000000o + '\'' + ", granted=" + this.O00000Oo + ", shouldShowRequestPermissionRationale=" + this.O00000o0 + '}';
    }
}
