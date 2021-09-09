package _m_j;

import java.io.File;

public final class bts extends btw {
    private int O00000Oo;
    private String O00000o0;

    public bts(int i, String str, btw btw) {
        super(btw);
        this.O00000Oo = i;
        this.O00000o0 = str;
    }

    private static int O000000o(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            bsf.O00000Oo(th, "fus", "gfn");
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        return O000000o(this.O00000o0) >= this.O00000Oo;
    }
}
