package _m_j;

public class idg {

    /* renamed from: O000000o  reason: collision with root package name */
    public final float f1209O000000o;
    public final float O00000Oo;

    public idg(float f, float f2) {
        this.f1209O000000o = f;
        this.O00000Oo = f2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof idg) {
            idg idg = (idg) obj;
            if (this.f1209O000000o == idg.f1209O000000o && this.O00000Oo == idg.O00000Oo) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f1209O000000o) * 31) + Float.floatToIntBits(this.O00000Oo);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f1209O000000o);
        sb.append(',');
        sb.append(this.O00000Oo);
        sb.append(')');
        return sb.toString();
    }

    public static void O000000o(idg[] idgArr) {
        idg idg;
        idg idg2;
        idg idg3;
        float O000000o2 = O000000o(idgArr[0], idgArr[1]);
        float O000000o3 = O000000o(idgArr[1], idgArr[2]);
        float O000000o4 = O000000o(idgArr[0], idgArr[2]);
        if (O000000o3 >= O000000o2 && O000000o3 >= O000000o4) {
            idg3 = idgArr[0];
            idg2 = idgArr[1];
            idg = idgArr[2];
        } else if (O000000o4 < O000000o3 || O000000o4 < O000000o2) {
            idg3 = idgArr[2];
            idg2 = idgArr[0];
            idg = idgArr[1];
        } else {
            idg3 = idgArr[1];
            idg2 = idgArr[0];
            idg = idgArr[2];
        }
        float f = idg3.f1209O000000o;
        float f2 = idg3.O00000Oo;
        if (((idg.f1209O000000o - f) * (idg2.O00000Oo - f2)) - ((idg.O00000Oo - f2) * (idg2.f1209O000000o - f)) < 0.0f) {
            idg idg4 = idg;
            idg = idg2;
            idg2 = idg4;
        }
        idgArr[0] = idg2;
        idgArr[1] = idg3;
        idgArr[2] = idg;
    }

    public static float O000000o(idg idg, idg idg2) {
        return idw.O000000o(idg.f1209O000000o, idg.O00000Oo, idg2.f1209O000000o, idg2.O00000Oo);
    }
}
