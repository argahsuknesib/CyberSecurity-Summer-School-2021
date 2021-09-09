package _m_j;

import java.util.Objects;

public final class bcp {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f12866O000000o;
    public final int O00000Oo;

    public bcp(int i, int i2) {
        this.f12866O000000o = i;
        this.O00000Oo = i2;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.O00000Oo), Integer.valueOf(this.f12866O000000o));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bcp)) {
            return false;
        }
        bcp bcp = (bcp) obj;
        if (this.f12866O000000o == bcp.f12866O000000o && this.O00000Oo == bcp.O00000Oo) {
            return true;
        }
        return false;
    }
}
