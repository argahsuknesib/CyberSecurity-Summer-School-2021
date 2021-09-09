package _m_j;

import java.util.Locale;

public final class oq {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2370O000000o = 0;
    public int O00000Oo = 0;
    public int O00000o = 0;
    public int O00000o0 = 0;
    public int O00000oO = 0;
    public int O00000oo = 0;
    public int O0000O0o = 0;
    public int O0000OOo = 0;
    public int O0000Oo;
    public int O0000Oo0 = 99;
    public int O0000OoO;
    @Deprecated
    public short O0000Ooo = 0;
    public short O0000o = Short.MAX_VALUE;
    public long O0000o0 = 0;
    @Deprecated
    public long O0000o00 = 0;
    public boolean O0000o0O;
    public boolean O0000o0o = true;

    public oq(int i, boolean z) {
        this.f2370O000000o = i;
        this.O0000o0O = z;
    }

    private oq(int i, boolean z, boolean z2) {
        this.f2370O000000o = i;
        this.O0000o0O = z;
        this.O0000o0o = z2;
    }

    /* renamed from: O000000o */
    public final oq clone() {
        oq oqVar = new oq(this.f2370O000000o, this.O0000o0O, this.O0000o0o);
        oqVar.O00000Oo = this.O00000Oo;
        oqVar.O00000o0 = this.O00000o0;
        oqVar.O00000o = this.O00000o;
        oqVar.O00000oO = this.O00000oO;
        oqVar.O00000oo = this.O00000oo;
        oqVar.O0000O0o = this.O0000O0o;
        oqVar.O0000OOo = this.O0000OOo;
        oqVar.O0000Oo0 = this.O0000Oo0;
        oqVar.O0000Oo = this.O0000Oo;
        oqVar.O0000OoO = this.O0000OoO;
        oqVar.O0000Ooo = this.O0000Ooo;
        oqVar.O0000o00 = this.O0000o00;
        oqVar.O0000o0 = this.O0000o0;
        oqVar.O0000o = this.O0000o;
        return oqVar;
    }

    public final String toString() {
        int i = this.f2370O000000o;
        if (i == 1) {
            return String.format(Locale.CHINA, "[type=GSM, mcc=%d, mnc=%d, lac=%d, cid=%d, sig=%d, age=%d, reg=%b, new=%b]", Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O0000Oo0), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0O), Boolean.valueOf(this.O0000o0o));
        } else if (i == 2) {
            return String.format(Locale.CHINA, "[type=CDMA, mcc=%d, mnc=%d, sid=%d, nid=%d, bid=%d, sig=%d, age=%d, reg=%b, new=%b]", Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000oo), Integer.valueOf(this.O0000O0o), Integer.valueOf(this.O0000OOo), Integer.valueOf(this.O0000Oo0), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0O), Boolean.valueOf(this.O0000o0o));
        } else if (i == 3) {
            return String.format(Locale.CHINA, "[type=LTE, mcc=%d, mnc=%d, lac=%d, cid=%d, sig=%d, age=%d, reg=%b, new=%b, pci=%d]", Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O0000Oo0), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0O), Boolean.valueOf(this.O0000o0o), Short.valueOf(this.O0000o));
        } else if (i != 4) {
            return "unknown";
        } else {
            return String.format(Locale.CHINA, "[type=WCDMA, mcc=%d, mnc=%d, lac=%d, cid=%d, sig=%d, age=%d, reg=%b, new=%b, psc=%d]", Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O0000Oo0), Short.valueOf(this.O0000Ooo), Boolean.valueOf(this.O0000o0O), Boolean.valueOf(this.O0000o0o), Short.valueOf(this.O0000o));
        }
    }
}
