package _m_j;

import java.io.IOException;

public final class ahc implements wx {

    /* renamed from: O000000o  reason: collision with root package name */
    private final xu f12385O000000o;

    public final boolean O00000o0(String str) {
        return false;
    }

    public ahc(xu xuVar) {
        this.f12385O000000o = xuVar;
    }

    public final boolean O000000o(String str) {
        return str.equals("WEBP");
    }

    public final boolean O00000Oo(String str) {
        return str.equals("VP8X") || str.equals("VP8L") || str.equals("VP8 ") || str.equals("EXIF") || str.equals("ICCP") || str.equals("XMP ");
    }

    public final void O000000o(String str, byte[] bArr) {
        ahb ahb = new ahb();
        if (str.equals("EXIF")) {
            new yr();
            yr.O000000o(new xc(bArr), this.f12385O000000o, 0, null);
        } else if (str.equals("ICCP")) {
            new acd();
            acd.O000000o(new xc(bArr), this.f12385O000000o, (xr) null);
        } else if (str.equals("XMP ")) {
            new ahf();
            ahf.O000000o(bArr, this.f12385O000000o, (xr) null);
        } else if (str.equals("VP8X") && bArr.length == 10) {
            xc xcVar = new xc(bArr);
            xcVar.f2594O000000o = false;
            try {
                boolean O00000Oo = xcVar.O00000Oo(1);
                boolean O00000Oo2 = xcVar.O00000Oo(4);
                int O0000O0o = xcVar.O0000O0o(4);
                int O0000O0o2 = xcVar.O0000O0o(7);
                ahb.O000000o(2, O0000O0o + 1);
                ahb.O000000o(1, O0000O0o2 + 1);
                ahb.O000000o(3, O00000Oo2);
                ahb.O000000o(4, O00000Oo);
                this.f12385O000000o.O000000o(ahb);
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        } else if (str.equals("VP8L") && bArr.length > 4) {
            xc xcVar2 = new xc(bArr);
            xcVar2.f2594O000000o = false;
            try {
                if (xcVar2.O00000o(0) == 47) {
                    short O00000o0 = xcVar2.O00000o0(1);
                    short O00000o02 = xcVar2.O00000o0(2);
                    short O00000o03 = xcVar2.O00000o0(3);
                    ahb.O000000o(2, (O00000o0 | ((O00000o02 & 63) << 8)) + 1);
                    ahb.O000000o(1, (((xcVar2.O00000o0(4) & 15) << 10) | (O00000o03 << 2) | ((O00000o02 & 192) >> 6)) + 1);
                    this.f12385O000000o.O000000o(ahb);
                }
            } catch (IOException e2) {
                e2.printStackTrace(System.err);
            }
        } else if (str.equals("VP8 ") && bArr.length > 9) {
            xc xcVar3 = new xc(bArr);
            xcVar3.f2594O000000o = false;
            try {
                if (xcVar3.O00000o0(3) != 157 || xcVar3.O00000o0(4) != 1) {
                    return;
                }
                if (xcVar3.O00000o0(5) == 42) {
                    int O00000oO = xcVar3.O00000oO(6);
                    int O00000oO2 = xcVar3.O00000oO(8);
                    ahb.O000000o(2, O00000oO);
                    ahb.O000000o(1, O00000oO2);
                    this.f12385O000000o.O000000o(ahb);
                }
            } catch (IOException e3) {
                ahb.O000000o(e3.getMessage());
            }
        }
    }
}
