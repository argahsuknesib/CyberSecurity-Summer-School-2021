package _m_j;

public final class gya implements Comparable<gya> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Integer f18519O000000o = -1;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public Integer O00000oo = -1;
    public int O0000O0o = -1;
    public int O0000OOo = -1;
    public int O0000Oo0 = -1;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        gya gya = (gya) obj;
        int i = this.O0000O0o;
        int i2 = gya.O0000O0o;
        if (i == i2) {
            int i3 = this.O0000OOo;
            int i4 = gya.O0000OOo;
            if (i3 == i4) {
                return this.O0000Oo0 - gya.O0000Oo0;
            }
            if (i3 < 0) {
                return 1;
            }
            if (i4 < 0) {
                return -1;
            }
            return i3 - i4;
        } else if (i < 0) {
            return 1;
        } else {
            if (i2 < 0) {
                return -1;
            }
            return i - i2;
        }
    }
}
