package _m_j;

import java.io.IOException;

public class afd {
    public long O00000o;
    public String O00000oO;
    public String O00000oo;

    public afd(xm xmVar) throws IOException {
        this.O00000o = xmVar.O0000O0o();
        this.O00000oO = xmVar.O00000Oo(4);
        long j = this.O00000o;
        if (j == 1) {
            this.O00000o = xmVar.O0000Oo0();
        } else if (j == 0) {
            this.O00000o = -1;
        }
        if (this.O00000oO.equals("uuid")) {
            this.O00000oo = xmVar.O00000Oo(16);
        }
    }

    public afd(afd afd) {
        this.O00000o = afd.O00000o;
        this.O00000oO = afd.O00000oO;
        this.O00000oo = afd.O00000oo;
    }
}
