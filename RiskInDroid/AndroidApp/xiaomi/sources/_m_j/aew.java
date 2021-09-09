package _m_j;

import java.io.IOException;

public final class aew extends wn<aez> {
    private afa O00000o0 = new afa(this);

    public aew(xu xuVar) {
        super(xuVar);
    }

    public final aez O000000o() {
        return new aez();
    }

    public final boolean O000000o(afd afd) {
        return afd.O00000oO.equals("ftyp") || afd.O00000oO.equals("mvhd") || afd.O00000oO.equals("hdlr") || afd.O00000oO.equals("mdhd");
    }

    public final boolean O00000Oo(afd afd) {
        return afd.O00000oO.equals("trak") || afd.O00000oO.equals("meta") || afd.O00000oO.equals("moov") || afd.O00000oO.equals("mdia");
    }

    public final wn O000000o(afd afd, byte[] bArr) throws IOException {
        if (bArr != null) {
            xl xlVar = new xl(bArr);
            if (afd.O00000oO.equals("mvhd")) {
                new afj(xlVar, afd).O000000o(this.O00000Oo);
            } else if (afd.O00000oO.equals("ftyp")) {
                afe afe = new afe(xlVar, afd);
                aez aez = this.O00000Oo;
                aez.O000000o(1, afe.f12369O000000o);
                aez.O000000o(2, afe.O00000Oo);
                aez.O00000Oo(3, (String[]) afe.O00000o0.toArray(new String[afe.O00000o0.size()]));
            } else if (afd.O00000oO.equals("hdlr")) {
                afg afg = new afg(xlVar, afd);
                afa afa = this.O00000o0;
                xu xuVar = this.f2579O000000o;
                String str = afg.f12370O000000o;
                if (str.equals("soun")) {
                    return new afy(xuVar);
                }
                if (str.equals("vide")) {
                    return new age(xuVar);
                }
                if (str.equals("hint")) {
                    return new afr(xuVar);
                }
                if (str.equals("text")) {
                    return new agb(xuVar);
                }
                if (str.equals("meta")) {
                    return new afv(xuVar);
                }
                return afa.f12367O000000o;
            } else if (afd.O00000oO.equals("mdhd")) {
                new afi(xlVar, afd);
            }
        } else if (afd.O00000oO.equals("cmov")) {
            this.O00000Oo.O000000o("Compressed MP4 movies not supported");
        }
        return this;
    }
}
