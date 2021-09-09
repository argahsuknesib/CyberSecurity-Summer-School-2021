package _m_j;

import _m_j.ado;
import java.io.IOException;
import java.util.ArrayList;

public abstract class adp<T extends ado> extends adj {
    long O00000oO;
    public ArrayList<T> O00000oo = new ArrayList<>((int) this.O00000oO);

    /* access modifiers changed from: package-private */
    public abstract T O000000o(xm xmVar) throws IOException;

    public adp(xm xmVar, adh adh) throws IOException {
        super(xmVar, adh);
        this.O00000oO = xmVar.O0000O0o();
        for (int i = 0; ((long) i) < this.O00000oO; i++) {
            this.O00000oo.add(O000000o(xmVar));
        }
    }
}
