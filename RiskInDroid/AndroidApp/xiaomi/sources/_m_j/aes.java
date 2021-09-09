package _m_j;

import java.io.IOException;
import java.util.ArrayList;

public final class aes extends adg {
    private ArrayList<String> O00000o = new ArrayList<>();
    private int O00000o0 = 0;

    public aes(xu xuVar) {
        super(xuVar);
    }

    public final boolean O000000o(adh adh) {
        return adh.O00000Oo.equals("hdlr") || adh.O00000Oo.equals("keys") || adh.O00000Oo.equals("data");
    }

    public final boolean O00000Oo(adh adh) {
        return adh.O00000Oo.equals("ilst") || xe.O000000o(adh.O00000Oo.getBytes()) <= this.O00000o.size();
    }

    public final wv O000000o(adh adh, byte[] bArr) throws IOException {
        if (bArr != null) {
            xl xlVar = new xl(bArr);
            if (adh.O00000Oo.equals("keys")) {
                O000000o(xlVar);
            } else if (adh.O00000Oo.equals("data")) {
                O000000o(bArr, xlVar);
            }
        } else {
            int O000000o2 = xe.O000000o(adh.O00000Oo.getBytes());
            if (O000000o2 > 0 && O000000o2 < this.O00000o.size() + 1) {
                this.O00000o0 = O000000o2 - 1;
            }
        }
        return this;
    }

    public final void O000000o(xl xlVar) throws IOException {
        xlVar.O000000o(4L);
        int O0000OOo = xlVar.O0000OOo();
        for (int i = 0; i < O0000OOo; i++) {
            int O0000OOo2 = xlVar.O0000OOo();
            xlVar.O000000o(4L);
            this.O00000o.add(new String(xlVar.O000000o(O0000OOo2 - 8)));
        }
    }

    public final void O000000o(byte[] bArr, xl xlVar) throws IOException {
        xlVar.O000000o(8L);
        this.O00000Oo.O000000o(aev.O0000Oo0.get(this.O00000o.get(this.O00000o0)).intValue(), new String(xlVar.O000000o(bArr.length - 8)));
    }
}
