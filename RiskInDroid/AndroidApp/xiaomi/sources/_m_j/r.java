package _m_j;

import android.graphics.Insets;

public final class r {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final r f2418O000000o = new r(0, 0, 0, 0);
    public final int O00000Oo;
    public final int O00000o;
    public final int O00000o0;
    public final int O00000oO;

    private r(int i, int i2, int i3, int i4) {
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = i3;
        this.O00000oO = i4;
    }

    public static r O000000o(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return f2418O000000o;
        }
        return new r(i, i2, i3, i4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.O00000oO == rVar.O00000oO && this.O00000Oo == rVar.O00000Oo && this.O00000o == rVar.O00000o && this.O00000o0 == rVar.O00000o0;
    }

    public final int hashCode() {
        return (((((this.O00000Oo * 31) + this.O00000o0) * 31) + this.O00000o) * 31) + this.O00000oO;
    }

    public final String toString() {
        return "Insets{left=" + this.O00000Oo + ", top=" + this.O00000o0 + ", right=" + this.O00000o + ", bottom=" + this.O00000oO + '}';
    }

    public static r O000000o(Insets insets) {
        return O000000o(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets O000000o() {
        return Insets.of(this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO);
    }
}
