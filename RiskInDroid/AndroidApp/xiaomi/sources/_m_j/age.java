package _m_j;

import java.io.IOException;

public final class age extends afb<agd> {
    public final String O00000Oo() {
        return "vmhd";
    }

    public age(xu xuVar) {
        super(xuVar);
    }

    public final void O000000o(xm xmVar, afd afd) throws IOException {
        afo afo = new afo(xmVar, afd);
        agd agd = (agd) this.O00000Oo;
        agd.O000000o(104, afo.O0000o0O);
        agd.O000000o(105, afo.O0000o0o);
        agd.O000000o(110, afo.O0000oOO.trim());
        agd.O000000o(109, afo.O0000oOo);
        double d = (double) ((afo.O0000o & -65536) >> 16);
        double d2 = (double) (afo.O0000o & 65535);
        double pow = Math.pow(2.0d, 4.0d);
        Double.isNaN(d2);
        Double.isNaN(d);
        agd.O000000o(106, d + (d2 / pow));
        double d3 = (double) ((afo.O0000oO0 & -65536) >> 16);
        double d4 = (double) (afo.O0000oO0 & 65535);
        double pow2 = Math.pow(2.0d, 4.0d);
        Double.isNaN(d4);
        Double.isNaN(d3);
        agd.O000000o(107, d3 + (d4 / pow2));
    }

    public final void O00000Oo(xm xmVar, afd afd) throws IOException {
        afn afn = new afn(xmVar, afd);
        agd agd = (agd) this.O00000Oo;
        agd.O00000Oo(112, afn.O00000Oo);
        agd.O000000o(111, afn.f12377O000000o);
    }

    public final void O00000o0(xm xmVar, afd afd) throws IOException {
        ((agd) this.O00000Oo).O000000o(114, ((float) afa.O00000Oo.longValue()) / ((float) new afm(xmVar, afd).O00000Oo.get(0).O00000Oo));
    }

    public final /* synthetic */ aez O000000o() {
        return new agd();
    }
}
