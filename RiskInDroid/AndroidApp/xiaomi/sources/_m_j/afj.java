package _m_j;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public final class afj extends aff {

    /* renamed from: O000000o  reason: collision with root package name */
    protected long f12373O000000o;
    protected long O00000Oo;
    protected long O00000o0;
    protected int O0000Oo;
    protected long O0000Oo0;
    protected int O0000OoO;
    protected int[] O0000Ooo;
    protected long O0000o00;

    public afj(xm xmVar, afd afd) throws IOException {
        super(xmVar, afd);
        if (this.O0000O0o == 1) {
            this.f12373O000000o = xmVar.O0000Oo0();
            this.O00000Oo = xmVar.O0000Oo0();
            this.O00000o0 = xmVar.O0000O0o();
            this.O0000Oo0 = xmVar.O0000Oo0();
        } else {
            this.f12373O000000o = xmVar.O0000O0o();
            this.O00000Oo = xmVar.O0000O0o();
            this.O00000o0 = xmVar.O0000O0o();
            this.O0000Oo0 = xmVar.O0000O0o();
        }
        this.O0000Oo = xmVar.O0000OOo();
        this.O0000OoO = xmVar.O00000oo();
        xmVar.O000000o(2L);
        xmVar.O000000o(8L);
        this.O0000Ooo = new int[]{xmVar.O0000OOo(), xmVar.O0000OOo(), xmVar.O0000OOo(), xmVar.O0000OOo(), xmVar.O0000OOo(), xmVar.O0000OOo(), xmVar.O0000OOo(), xmVar.O0000OOo(), xmVar.O0000OOo()};
        xmVar.O000000o(24L);
        this.O0000o00 = xmVar.O0000O0o();
    }

    public final void O000000o(aez aez) {
        Calendar instance = Calendar.getInstance();
        instance.set(1904, 0, 1, 0, 0, 0);
        long time = instance.getTime().getTime();
        aez.O000000o(256, new Date((this.f12373O000000o * 1000) + time));
        aez.O000000o(257, new Date((this.O00000Oo * 1000) + time));
        this.O0000Oo0 /= this.O00000o0;
        aez.O000000o(259, this.O0000Oo0);
        aez.O000000o(258, this.O00000o0);
        aez.O00000Oo(271, this.O0000Ooo);
        int i = this.O0000Oo;
        double d = (double) ((-65536 & i) >> 16);
        double d2 = (double) (i & 65535);
        double pow = Math.pow(2.0d, 4.0d);
        Double.isNaN(d2);
        Double.isNaN(d);
        aez.O000000o(260, d + (d2 / pow));
        int i2 = this.O0000OoO;
        double d3 = (double) ((65280 & i2) >> 8);
        double d4 = (double) (i2 & 255);
        double pow2 = Math.pow(2.0d, 2.0d);
        Double.isNaN(d4);
        Double.isNaN(d3);
        aez.O000000o(261, d3 + (d4 / pow2));
        aez.O000000o(270, this.O0000o00);
    }
}
