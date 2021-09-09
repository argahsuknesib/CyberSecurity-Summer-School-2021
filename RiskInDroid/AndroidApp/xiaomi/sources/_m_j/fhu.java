package _m_j;

import java.io.IOException;
import java.util.Enumeration;

public final class fhu extends fhs {
    private int O00000Oo = -1;

    public fhu() {
    }

    public fhu(fhn fhn) {
        super(fhn);
    }

    private int O00000oO() throws IOException {
        if (this.O00000Oo < 0) {
            int i = 0;
            Enumeration O00000o = O00000o();
            while (O00000o.hasMoreElements()) {
                i += ((fhm) O00000o.nextElement()).O000000o().O00000o0().O00000Oo();
            }
            this.O00000Oo = i;
        }
        return this.O00000Oo;
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo() throws IOException {
        int O00000oO = O00000oO();
        return fhv.O000000o(O00000oO) + 1 + O00000oO;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(fhq fhq) throws IOException {
        fhq O000000o2 = fhq.O000000o();
        int O00000oO = O00000oO();
        fhq.O00000Oo(48);
        fhq.O000000o(O00000oO);
        Enumeration O00000o = O00000o();
        while (O00000o.hasMoreElements()) {
            O000000o2.O000000o((fhm) O00000o.nextElement());
        }
    }
}
