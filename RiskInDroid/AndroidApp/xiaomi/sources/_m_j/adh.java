package _m_j;

import java.io.IOException;

public class adh {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f12357O000000o;
    public String O00000Oo;

    public adh(xm xmVar) throws IOException {
        this.f12357O000000o = xmVar.O0000O0o();
        this.O00000Oo = xmVar.O00000Oo(4);
        long j = this.f12357O000000o;
        if (j == 1) {
            this.f12357O000000o = xmVar.O0000Oo0();
        } else if (j == 0) {
            this.f12357O000000o = -1;
        }
    }

    public adh(adh adh) {
        this.f12357O000000o = adh.f12357O000000o;
        this.O00000Oo = adh.O00000Oo;
    }
}
