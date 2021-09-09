package _m_j;

import java.io.IOException;
import java.util.logging.Logger;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSState;

public class ito extends itp {
    static Logger O00000Oo = Logger.getLogger(ito.class.getName());

    public final String O00000Oo() {
        return "canceling";
    }

    /* access modifiers changed from: protected */
    public final boolean O00000o0() {
        return true;
    }

    public ito(JmDNSImpl jmDNSImpl) {
        super(jmDNSImpl, 0);
        this.O00000oo = DNSState.CANCELING_1;
        O000000o(DNSState.CANCELING_1);
    }

    public final String O000000o() {
        String str;
        StringBuilder sb = new StringBuilder("Canceler(");
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
        return new isz(33792);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: javax.jmdns.impl.HostInfo.O000000o(boolean, int):java.util.Collection<_m_j.itb>
     arg types: [int, int]
     candidates:
      javax.jmdns.impl.HostInfo.O000000o(javax.jmdns.impl.constants.DNSRecordType, boolean):_m_j.itb$O000000o
      javax.jmdns.impl.HostInfo.O000000o(boolean, int):java.util.Collection<_m_j.itb> */
    /* access modifiers changed from: protected */
    public final isz O000000o(isz isz) throws IOException {
        for (itb O000000o2 : this.f1625O000000o.O0000Oo0.O000000o(true, this.O00000o)) {
            isz = O000000o(isz, (isw) null, O000000o2);
        }
        return isz;
    }

    /* access modifiers changed from: protected */
    public final isz O000000o(ServiceInfoImpl serviceInfoImpl, isz isz) throws IOException {
        for (itb O000000o2 : serviceInfoImpl.O000000o(this.O00000o, this.f1625O000000o.O0000Oo0)) {
            isz = O000000o(isz, (isw) null, O000000o2);
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
        if (!this.O00000oo.isCanceling()) {
            cancel();
        }
    }
}
