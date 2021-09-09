package _m_j;

import _m_j.itb;
import java.io.IOException;
import java.util.logging.Logger;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import javax.jmdns.impl.constants.DNSState;

public class itq extends itp {
    static Logger O00000Oo = Logger.getLogger(itq.class.getName());

    public final String O00000Oo() {
        return "probing";
    }

    public final String O000000o() {
        String str;
        StringBuilder sb = new StringBuilder("Prober(");
        if (this.f1625O000000o != null) {
            str = this.f1625O000000o.O0000o0O;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    public String toString() {
        return super.toString() + " state: " + this.O00000oo;
    }

    public boolean cancel() {
        O0000O0o();
        return super.cancel();
    }

    /* access modifiers changed from: protected */
    public final isz O00000o() {
        return new isz(0);
    }

    /* access modifiers changed from: protected */
    public final isz O000000o(ServiceInfoImpl serviceInfoImpl, isz isz) throws IOException {
        return O000000o(O000000o(isz, ita.O000000o(serviceInfoImpl.O00000o(), DNSRecordType.TYPE_ANY, DNSRecordClass.CLASS_IN, false)), new itb.O0000OOo(serviceInfoImpl.O00000o(), DNSRecordClass.CLASS_IN, false, this.O00000o, serviceInfoImpl.O00000oO, serviceInfoImpl.O00000o, serviceInfoImpl.O00000o0, this.f1625O000000o.O0000Oo0.O000000o()));
    }

    public itq(JmDNSImpl jmDNSImpl) {
        super(jmDNSImpl, itp.O00000oO);
        this.O00000oo = DNSState.PROBING_1;
        O000000o(DNSState.PROBING_1);
    }

    /* access modifiers changed from: protected */
    public final boolean O00000o0() {
        return !this.f1625O000000o.O0000Ooo() && !this.f1625O000000o.O0000o00();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: javax.jmdns.impl.HostInfo.O000000o(boolean, int):java.util.Collection<_m_j.itb>
     arg types: [int, int]
     candidates:
      javax.jmdns.impl.HostInfo.O000000o(javax.jmdns.impl.constants.DNSRecordType, boolean):_m_j.itb$O000000o
      javax.jmdns.impl.HostInfo.O000000o(boolean, int):java.util.Collection<_m_j.itb> */
    /* access modifiers changed from: protected */
    public final isz O000000o(isz isz) throws IOException {
        isz.O000000o(ita.O000000o(this.f1625O000000o.O0000Oo0.O000000o(), DNSRecordType.TYPE_ANY, DNSRecordClass.CLASS_IN, false));
        for (itb O000000o2 : this.f1625O000000o.O0000Oo0.O000000o(false, this.O00000o)) {
            isz = O000000o(isz, O000000o2);
        }
        return isz;
    }

    /* access modifiers changed from: protected */
    public final void O00000oO() {
        this.f1625O000000o.O0000oO0();
    }

    /* access modifiers changed from: protected */
    public final void O00000oo() {
        this.O00000oo = this.O00000oo.advance();
        if (!this.O00000oo.isProbing()) {
            cancel();
            this.f1625O000000o.O00000oo();
        }
    }
}
