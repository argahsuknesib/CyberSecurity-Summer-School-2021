package _m_j;

public final class xq {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f2596O000000o;
    private final int O00000Oo;
    private final int O00000o;
    private final int O00000o0;
    private final int O00000oO;
    private final int O00000oo;

    public static xq O000000o(String str) {
        if (str.length() == 19 && !str.startsWith("9999:99:99")) {
            try {
                return new xq(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(5, 7)), Integer.parseInt(str.substring(8, 10)), Integer.parseInt(str.substring(11, 13)), Integer.parseInt(str.substring(14, 16)), Integer.parseInt(str.substring(17, 19)));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private xq(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f2596O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
        this.O00000o = i4;
        this.O00000oO = i5;
        this.O00000oo = i6;
    }

    public final String toString() {
        return String.format("%04d:%02d:%02d %02d:%02d:%02d", Integer.valueOf(this.f2596O000000o), Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O00000oo));
    }

    public final String O000000o() {
        StringBuilder sb = new StringBuilder();
        O000000o(sb, this.f2596O000000o, "year");
        O000000o(sb, this.O00000Oo, "month");
        O000000o(sb, this.O00000o0, "day");
        O000000o(sb, this.O00000o, "hour");
        O000000o(sb, this.O00000oO, "minute");
        O000000o(sb, this.O00000oo, "second");
        return sb.toString();
    }

    private static void O000000o(StringBuilder sb, int i, String str) {
        if (i != 0) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(i);
            sb.append(' ');
            sb.append(str);
            if (i != 1) {
                sb.append('s');
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xq xqVar = (xq) obj;
        return this.O00000o0 == xqVar.O00000o0 && this.O00000o == xqVar.O00000o && this.O00000oO == xqVar.O00000oO && this.O00000Oo == xqVar.O00000Oo && this.O00000oo == xqVar.O00000oo && this.f2596O000000o == xqVar.f2596O000000o;
    }

    public final int hashCode() {
        return (((((((((this.f2596O000000o * 31) + this.O00000Oo) * 31) + this.O00000o0) * 31) + this.O00000o) * 31) + this.O00000oO) * 31) + this.O00000oo;
    }
}
