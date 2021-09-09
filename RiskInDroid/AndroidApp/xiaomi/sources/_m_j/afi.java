package _m_j;

import java.io.IOException;

public final class afi extends aff {

    /* renamed from: O000000o  reason: collision with root package name */
    long f12372O000000o;
    long O00000Oo;
    long O00000o0;
    String O0000Oo;
    long O0000Oo0;

    public afi(xm xmVar, afd afd) throws IOException {
        super(xmVar, afd);
        if (this.O0000O0o == 1) {
            this.f12372O000000o = xmVar.O0000Oo0();
            this.O00000Oo = xmVar.O0000Oo0();
            this.O00000o0 = (long) xmVar.O0000OOo();
            this.O0000Oo0 = xmVar.O0000Oo0();
        } else {
            this.f12372O000000o = xmVar.O0000O0o();
            this.O00000Oo = xmVar.O0000O0o();
            this.O00000o0 = xmVar.O0000O0o();
            this.O0000Oo0 = xmVar.O0000O0o();
        }
        short O00000oo = xmVar.O00000oo();
        this.O0000Oo = new String(new char[]{(char) (((O00000oo & 31744) >> 10) + 96), (char) (((O00000oo & 992) >> 5) + 96), (char) ((O00000oo & 31) + 96)});
        afa.O00000o0 = Long.valueOf(this.f12372O000000o);
        afa.O00000o = Long.valueOf(this.O00000Oo);
        afa.O00000Oo = Long.valueOf(this.O00000o0);
        afa.O00000oO = Long.valueOf(this.O0000Oo0);
        afa.O00000oo = this.O0000Oo;
    }
}
