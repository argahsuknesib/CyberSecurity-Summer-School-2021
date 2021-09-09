package _m_j;

import java.nio.ByteBuffer;

public final class jkt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jkt f1911O000000o = new jkt(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final jkt O00000Oo = new jkt(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final jkt O00000o = new jkt(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final jkt O00000o0 = new jkt(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    double O00000oO;
    double O00000oo;
    double O0000O0o;
    double O0000OOo;
    double O0000Oo;
    double O0000Oo0;
    double O0000OoO;
    double O0000Ooo;
    double O0000o00;

    private jkt(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.O00000oO = d5;
        this.O00000oo = d6;
        this.O0000O0o = d7;
        this.O0000OOo = d;
        this.O0000Oo0 = d2;
        this.O0000Oo = d3;
        this.O0000OoO = d4;
        this.O0000Ooo = d8;
        this.O0000o00 = d9;
    }

    public static jkt O000000o(ByteBuffer byteBuffer) {
        double O0000O0o2 = jky.O0000O0o(byteBuffer);
        double O0000O0o3 = jky.O0000O0o(byteBuffer);
        double O0000OOo2 = jky.O0000OOo(byteBuffer);
        return new jkt(O0000O0o2, O0000O0o3, jky.O0000O0o(byteBuffer), jky.O0000O0o(byteBuffer), O0000OOo2, jky.O0000OOo(byteBuffer), jky.O0000OOo(byteBuffer), jky.O0000O0o(byteBuffer), jky.O0000O0o(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        jkt jkt = (jkt) obj;
        return Double.compare(jkt.O0000OOo, this.O0000OOo) == 0 && Double.compare(jkt.O0000Oo0, this.O0000Oo0) == 0 && Double.compare(jkt.O0000Oo, this.O0000Oo) == 0 && Double.compare(jkt.O0000OoO, this.O0000OoO) == 0 && Double.compare(jkt.O0000Ooo, this.O0000Ooo) == 0 && Double.compare(jkt.O0000o00, this.O0000o00) == 0 && Double.compare(jkt.O00000oO, this.O00000oO) == 0 && Double.compare(jkt.O00000oo, this.O00000oo) == 0 && Double.compare(jkt.O0000O0o, this.O0000O0o) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.O00000oO);
        long doubleToLongBits2 = Double.doubleToLongBits(this.O00000oo);
        long doubleToLongBits3 = Double.doubleToLongBits(this.O0000O0o);
        long doubleToLongBits4 = Double.doubleToLongBits(this.O0000OOo);
        long doubleToLongBits5 = Double.doubleToLongBits(this.O0000Oo0);
        long doubleToLongBits6 = Double.doubleToLongBits(this.O0000Oo);
        long doubleToLongBits7 = Double.doubleToLongBits(this.O0000OoO);
        long doubleToLongBits8 = Double.doubleToLongBits(this.O0000Ooo);
        long doubleToLongBits9 = Double.doubleToLongBits(this.O0000o00);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(f1911O000000o)) {
            return "Rotate 0°";
        }
        if (equals(O00000Oo)) {
            return "Rotate 90°";
        }
        if (equals(O00000o0)) {
            return "Rotate 180°";
        }
        if (equals(O00000o)) {
            return "Rotate 270°";
        }
        return "Matrix{u=" + this.O00000oO + ", v=" + this.O00000oo + ", w=" + this.O0000O0o + ", a=" + this.O0000OOo + ", b=" + this.O0000Oo0 + ", c=" + this.O0000Oo + ", d=" + this.O0000OoO + ", tx=" + this.O0000Ooo + ", ty=" + this.O0000o00 + '}';
    }

    public final void O00000Oo(ByteBuffer byteBuffer) {
        jla.O000000o(byteBuffer, this.O0000OOo);
        jla.O000000o(byteBuffer, this.O0000Oo0);
        jla.O00000Oo(byteBuffer, this.O00000oO);
        jla.O000000o(byteBuffer, this.O0000Oo);
        jla.O000000o(byteBuffer, this.O0000OoO);
        jla.O00000Oo(byteBuffer, this.O00000oo);
        jla.O000000o(byteBuffer, this.O0000Ooo);
        jla.O000000o(byteBuffer, this.O0000o00);
        jla.O00000Oo(byteBuffer, this.O0000O0o);
    }
}
