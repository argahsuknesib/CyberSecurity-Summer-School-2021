package _m_j;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public final class ada extends wv<add> {
    private ade O00000o0 = new ade(this);

    public ada(xu xuVar) {
        super(xuVar);
    }

    public final add O000000o() {
        return new add();
    }

    public final boolean O000000o(adh adh) {
        return adh.O00000Oo.equals("ftyp") || adh.O00000Oo.equals("mvhd") || adh.O00000Oo.equals("hdlr") || adh.O00000Oo.equals("mdhd");
    }

    public final boolean O00000Oo(adh adh) {
        return adh.O00000Oo.equals("trak") || adh.O00000Oo.equals("udta") || adh.O00000Oo.equals("meta") || adh.O00000Oo.equals("moov") || adh.O00000Oo.equals("mdia");
    }

    public final wv O000000o(adh adh, byte[] bArr) throws IOException {
        if (bArr != null) {
            xl xlVar = new xl(bArr);
            if (adh.O00000Oo.equals("mvhd")) {
                adm adm = new adm(xlVar, adh);
                add add = this.O00000Oo;
                Calendar instance = Calendar.getInstance();
                instance.set(1904, 0, 1, 0, 0, 0);
                long time = instance.getTime().getTime();
                add.O000000o(256, new Date((adm.O00000oO * 1000) + time));
                add.O000000o(257, new Date((adm.O00000oo * 1000) + time));
                adm.O0000OOo /= adm.O0000O0o;
                add.O000000o(259, adm.O0000OOo);
                add.O000000o(258, adm.O0000O0o);
                double d = (double) ((adm.O0000Oo0 & -65536) >> 16);
                double d2 = (double) (adm.O0000Oo0 & 65535);
                double pow = Math.pow(2.0d, 4.0d);
                Double.isNaN(d2);
                Double.isNaN(d);
                add.O000000o(260, d + (d2 / pow));
                double d3 = (double) ((adm.O0000Oo & 65280) >> 8);
                double d4 = (double) (adm.O0000Oo & 255);
                double pow2 = Math.pow(2.0d, 2.0d);
                Double.isNaN(d4);
                Double.isNaN(d3);
                add.O000000o(261, d3 + (d4 / pow2));
                add.O000000o(264, adm.O0000Ooo);
                add.O000000o(265, adm.O0000o00);
                add.O000000o(266, adm.O0000o0);
                add.O000000o(267, adm.O0000o0O);
                add.O000000o(268, adm.O0000o0o);
                add.O000000o(269, adm.O0000o);
                add.O000000o(270, adm.O0000oO0);
            } else if (adh.O00000Oo.equals("ftyp")) {
                adi adi = new adi(xlVar, adh);
                add add2 = this.O00000Oo;
                add2.O000000o(4096, adi.O00000o0);
                add2.O000000o(4097, adi.O00000o);
                add2.O00000Oo(4098, (String[]) adi.O00000oO.toArray(new String[adi.O00000oO.size()]));
            } else if (adh.O00000Oo.equals("hdlr")) {
                adk adk = new adk(xlVar, adh);
                ade ade = this.O00000o0;
                String str = adk.O00000oo;
                xu xuVar = this.f2586O000000o;
                if (str.equals("mdir")) {
                    return new aet(xuVar);
                }
                if (str.equals("mdta")) {
                    return new aes(xuVar);
                }
                if (str.equals("soun")) {
                    return new aef(xuVar);
                }
                if (str.equals("vide")) {
                    return new aer(xuVar);
                }
                if (str.equals("tmcd")) {
                    return new aeo(xuVar);
                }
                if (str.equals("text")) {
                    return new ael(xuVar);
                }
                if (str.equals("sbtl")) {
                    return new aei(xuVar);
                }
                if (str.equals("musi")) {
                    return new aec(xuVar);
                }
                return ade.f12356O000000o;
            } else if (adh.O00000Oo.equals("mdhd")) {
                new adl(xlVar, adh);
            }
        } else if (adh.O00000Oo.equals("cmov")) {
            this.O00000Oo.O000000o("Compressed QuickTime movies not supported");
        }
        return this;
    }
}
