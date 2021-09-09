package _m_j;

import java.io.IOException;
import java.util.ArrayList;

public final class adi extends adh {
    public long O00000o;
    public String O00000o0;
    public ArrayList<String> O00000oO = new ArrayList<>((int) ((this.f12357O000000o / 16) >> 2));

    public adi(xm xmVar, adh adh) throws IOException {
        super(adh);
        this.O00000o0 = xmVar.O00000Oo(4);
        this.O00000o = xmVar.O0000O0o();
        for (int i = 16; ((long) i) < this.f12357O000000o; i += 4) {
            this.O00000oO.add(xmVar.O00000Oo(4));
        }
    }
}
