package _m_j;

public final class bmu {

    /* renamed from: O000000o  reason: collision with root package name */
    int f13117O000000o = 1;
    int O00000Oo = 60;
    int O00000o = 0;
    int O00000o0 = 60;
    String O00000oO = null;
    String[] O00000oo = null;
    byte[] O0000O0o = null;
    boolean O0000OOo = false;

    private bmu() {
    }

    private void O000000o() {
        this.O00000oo = bmb.O00000o;
        this.O00000Oo = 30;
        this.O00000o0 = 4;
        this.O00000o = 0;
        this.O0000O0o = bmb.O00000oO;
    }

    public static bmu O000000o(String str, byte[] bArr, boolean z) {
        bmu bmu = new bmu();
        bmu.O000000o();
        if (str.startsWith("https://")) {
            bmu.f13117O000000o = 0;
            if (bArr != null) {
                bmu.O0000O0o = bArr;
            }
        } else {
            bmu.f13117O000000o = 1;
        }
        bmu.O00000oO = str;
        bmu.O0000OOo = z;
        return bmu;
    }
}
