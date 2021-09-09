package _m_j;

import _m_j.add;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public abstract class adf<T extends add> extends wv<T> {
    /* access modifiers changed from: protected */
    public abstract void O000000o(xm xmVar, adh adh) throws IOException;

    /* access modifiers changed from: protected */
    public abstract String O00000Oo();

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(xm xmVar, adh adh) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void O00000o0(xm xmVar, adh adh) throws IOException;

    public adf(xu xuVar) {
        super(xuVar);
        if (ade.O00000o0 != null && ade.O00000o != null) {
            Calendar instance = Calendar.getInstance();
            instance.set(1904, 0, 1, 0, 0, 0);
            long time = instance.getTime().getTime();
            String date = new Date((ade.O00000o0.longValue() * 1000) + time).toString();
            String date2 = new Date((ade.O00000o.longValue() * 1000) + time).toString();
            this.O00000Oo.O000000o(20481, date);
            this.O00000Oo.O000000o(20482, date2);
        }
    }

    public final boolean O000000o(adh adh) {
        return adh.O00000Oo.equals(O00000Oo()) || adh.O00000Oo.equals("stsd") || adh.O00000Oo.equals("stts");
    }

    public final boolean O00000Oo(adh adh) {
        return adh.O00000Oo.equals("stbl") || adh.O00000Oo.equals("minf") || adh.O00000Oo.equals("gmhd") || adh.O00000Oo.equals("tmcd");
    }

    public final /* synthetic */ wv O000000o(adh adh, byte[] bArr) throws IOException {
        if (bArr != null) {
            xl xlVar = new xl(bArr);
            if (adh.O00000Oo.equals(O00000Oo())) {
                O00000Oo(xlVar, adh);
            } else if (adh.O00000Oo.equals("stsd")) {
                O000000o(xlVar, adh);
            } else if (adh.O00000Oo.equals("stts")) {
                O00000o0(xlVar, adh);
            }
        }
        return this;
    }
}
