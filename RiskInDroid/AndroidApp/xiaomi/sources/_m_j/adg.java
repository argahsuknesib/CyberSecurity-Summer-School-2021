package _m_j;

import java.io.IOException;

public abstract class adg extends wv {
    /* access modifiers changed from: protected */
    public abstract void O000000o(xl xlVar) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void O000000o(byte[] bArr, xl xlVar) throws IOException;

    public adg(xu xuVar) {
        super(xuVar);
    }

    public final add O000000o() {
        return new aev();
    }

    public boolean O000000o(adh adh) {
        return adh.O00000Oo.equals("hdlr") || adh.O00000Oo.equals("keys") || adh.O00000Oo.equals("data");
    }

    public boolean O00000Oo(adh adh) {
        return adh.O00000Oo.equals("ilst");
    }

    public wv O000000o(adh adh, byte[] bArr) throws IOException {
        if (bArr != null) {
            xl xlVar = new xl(bArr);
            if (adh.O00000Oo.equals("keys")) {
                O000000o(xlVar);
            } else if (adh.O00000Oo.equals("data")) {
                O000000o(bArr, xlVar);
            }
        }
        return this;
    }
}
