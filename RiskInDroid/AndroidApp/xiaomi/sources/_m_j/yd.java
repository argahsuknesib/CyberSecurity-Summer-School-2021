package _m_j;

import java.io.IOException;

public final class yd implements wx {

    /* renamed from: O000000o  reason: collision with root package name */
    private final yc f2603O000000o = new yc();

    public yd(xu xuVar) {
        xuVar.O000000o(this.f2603O000000o);
    }

    public final boolean O000000o(String str) {
        return str.equals("AVI ");
    }

    public final boolean O00000Oo(String str) {
        return str.equals("strh") || str.equals("avih");
    }

    public final boolean O00000o0(String str) {
        return str.equals("hdrl") || str.equals("strl") || str.equals("AVI ");
    }

    public final void O000000o(String str, byte[] bArr) {
        try {
            if (str.equals("strh")) {
                xc xcVar = new xc(bArr);
                xcVar.f2594O000000o = false;
                String str2 = new String(xcVar.O00000o0(0, 4));
                String str3 = new String(xcVar.O00000o0(4, 4));
                float O0000Ooo = xcVar.O0000Ooo(20);
                float O0000Ooo2 = xcVar.O0000Ooo(24);
                int O0000Oo0 = xcVar.O0000Oo0(32);
                if (str2.equals("vids")) {
                    if (!this.f2603O000000o.O000000o(1)) {
                        float f = O0000Ooo2 / O0000Ooo;
                        this.f2603O000000o.O000000o(1, (double) f);
                        double d = (double) (((float) O0000Oo0) / f);
                        int i = (int) d;
                        Integer valueOf = Integer.valueOf(i / ((int) Math.pow(60.0d, 2.0d)));
                        Integer valueOf2 = Integer.valueOf((i / ((int) Math.pow(60.0d, 1.0d))) - (valueOf.intValue() * 60));
                        double pow = Math.pow(60.0d, 0.0d);
                        Double.isNaN(d);
                        double d2 = d / pow;
                        double intValue = (double) (valueOf2.intValue() * 60);
                        Double.isNaN(intValue);
                        this.f2603O000000o.O000000o(3, String.format("%1$02d:%2$02d:%3$02d", valueOf, valueOf2, Integer.valueOf((int) Math.round(d2 - intValue))));
                        this.f2603O000000o.O000000o(4, str3);
                    }
                } else if (str2.equals("auds") && !this.f2603O000000o.O000000o(2)) {
                    this.f2603O000000o.O000000o(2, (double) (O0000Ooo2 / O0000Ooo));
                }
            } else if (str.equals("avih")) {
                xc xcVar2 = new xc(bArr);
                xcVar2.f2594O000000o = false;
                int O0000Oo02 = xcVar2.O0000Oo0(24);
                int O0000Oo03 = xcVar2.O0000Oo0(32);
                int O0000Oo04 = xcVar2.O0000Oo0(36);
                this.f2603O000000o.O000000o(6, O0000Oo03);
                this.f2603O000000o.O000000o(7, O0000Oo04);
                this.f2603O000000o.O000000o(8, O0000Oo02);
            }
        } catch (IOException e) {
            this.f2603O000000o.O000000o(e.getMessage());
        }
    }
}
