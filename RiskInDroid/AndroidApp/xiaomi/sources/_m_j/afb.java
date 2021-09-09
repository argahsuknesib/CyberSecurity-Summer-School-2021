package _m_j;

import _m_j.afs;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public abstract class afb<T extends afs> extends wn<T> {
    /* access modifiers changed from: protected */
    public abstract void O000000o(xm xmVar, afd afd) throws IOException;

    /* access modifiers changed from: protected */
    public abstract String O00000Oo();

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(xm xmVar, afd afd) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void O00000o0(xm xmVar, afd afd) throws IOException;

    public afb(xu xuVar) {
        super(xuVar);
        if (afa.O00000o0 != null && afa.O00000o != null) {
            Calendar instance = Calendar.getInstance();
            instance.set(1904, 0, 1, 0, 0, 0);
            long time = instance.getTime().getTime();
            String date = new Date((afa.O00000o0.longValue() * 1000) + time).toString();
            String date2 = new Date((afa.O00000o.longValue() * 1000) + time).toString();
            String str = afa.O00000oo;
            ((afs) this.O00000Oo).O000000o(101, date);
            ((afs) this.O00000Oo).O000000o(102, date2);
            ((afs) this.O00000Oo).O000000o(104, str);
        }
    }

    public final boolean O000000o(afd afd) {
        return afd.O00000oO.equals(O00000Oo()) || afd.O00000oO.equals("stsd") || afd.O00000oO.equals("stts");
    }

    public final boolean O00000Oo(afd afd) {
        return afd.O00000oO.equals("stbl") || afd.O00000oO.equals("minf");
    }

    public final wn O000000o(afd afd, byte[] bArr) throws IOException {
        if (bArr != null) {
            xl xlVar = new xl(bArr);
            if (afd.O00000oO.equals(O00000Oo())) {
                O00000Oo(xlVar, afd);
            } else if (afd.O00000oO.equals("stsd")) {
                O000000o(xlVar, afd);
            } else if (afd.O00000oO.equals("stts")) {
                O00000o0(xlVar, afd);
            }
        }
        return this;
    }
}
