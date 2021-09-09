package _m_j;

import java.io.IOException;

public final class aet extends adg {
    private String O00000o0;

    public final void O000000o(xl xlVar) throws IOException {
    }

    public aet(xu xuVar) {
        super(xuVar);
    }

    public final boolean O000000o(adh adh) {
        return adh.O00000Oo.equals("data");
    }

    public final boolean O00000Oo(adh adh) {
        return aev.O0000Oo0.containsKey(adh.O00000Oo) || adh.O00000Oo.equals("ilst");
    }

    public final wv O000000o(adh adh, byte[] bArr) throws IOException {
        if (bArr != null) {
            xl xlVar = new xl(bArr);
            if (!adh.O00000Oo.equals("data") || this.O00000o0 == null) {
                this.O00000o0 = new String(xlVar.O000000o(4));
            } else {
                O000000o(bArr, xlVar);
            }
        } else if (aev.O0000Oo0.containsKey(adh.O00000Oo)) {
            this.O00000o0 = adh.O00000Oo;
        } else {
            this.O00000o0 = null;
        }
        return this;
    }

    public final void O000000o(byte[] bArr, xl xlVar) throws IOException {
        xlVar.O000000o(8L);
        this.O00000Oo.O000000o(aev.O0000Oo0.get(this.O00000o0).intValue(), new String(xlVar.O000000o(bArr.length - 8)));
    }
}
