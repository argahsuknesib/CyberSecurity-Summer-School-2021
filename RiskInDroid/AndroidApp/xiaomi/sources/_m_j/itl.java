package _m_j;

import java.io.IOException;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;

public final class itl extends itk {
    private final ServiceInfoImpl O00000o0;

    public itl(JmDNSImpl jmDNSImpl, ServiceInfoImpl serviceInfoImpl) {
        super(jmDNSImpl);
        this.O00000o0 = serviceInfoImpl;
        serviceInfoImpl.O000000o(this.f1625O000000o);
        JmDNSImpl jmDNSImpl2 = this.f1625O000000o;
        ita O000000o2 = ita.O000000o(serviceInfoImpl.O00000o(), DNSRecordType.TYPE_ANY, DNSRecordClass.CLASS_IN, false);
        long currentTimeMillis = System.currentTimeMillis();
        jmDNSImpl2.O00000o0.add(serviceInfoImpl);
        for (isv isv : jmDNSImpl2.O00000oO.O000000o(O000000o2.O00000Oo().toLowerCase())) {
            boolean z = true;
            if (((!(isv != null && isv.O00000oo() == O000000o2.O00000oo()) || !O000000o2.O00000Oo(isv) || !O000000o2.O00000Oo().equals(isv.O00000Oo())) ? false : z) && !isv.O000000o(currentTimeMillis)) {
                serviceInfoImpl.O000000o(jmDNSImpl2.O00000oO, currentTimeMillis, isv);
            }
        }
    }

    public final String O000000o() {
        String str;
        StringBuilder sb = new StringBuilder("ServiceInfoResolver(");
        if (this.f1625O000000o != null) {
            str = this.f1625O000000o.O0000o0O;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    public final boolean cancel() {
        boolean cancel = super.cancel();
        if (!this.O00000o0.O00000oo) {
            JmDNSImpl jmDNSImpl = this.f1625O000000o;
            jmDNSImpl.O00000o0.remove(this.O00000o0);
        }
        return cancel;
    }

    /* access modifiers changed from: protected */
    public final isz O00000Oo(isz isz) throws IOException {
        if (this.O00000o0.O000000o()) {
            return isz;
        }
        long currentTimeMillis = System.currentTimeMillis();
        isz O000000o2 = O000000o(O000000o(isz, (itb) this.f1625O000000o.O00000oO.O000000o(this.O00000o0.O00000o(), DNSRecordType.TYPE_SRV, DNSRecordClass.CLASS_IN), currentTimeMillis), (itb) this.f1625O000000o.O00000oO.O000000o(this.O00000o0.O00000o(), DNSRecordType.TYPE_TXT, DNSRecordClass.CLASS_IN), currentTimeMillis);
        return this.O00000o0.O00000oO().length() > 0 ? O000000o(O000000o(O000000o2, (itb) this.f1625O000000o.O00000oO.O000000o(this.O00000o0.O00000oO(), DNSRecordType.TYPE_A, DNSRecordClass.CLASS_IN), currentTimeMillis), (itb) this.f1625O000000o.O00000oO.O000000o(this.O00000o0.O00000oO(), DNSRecordType.TYPE_AAAA, DNSRecordClass.CLASS_IN), currentTimeMillis) : O000000o2;
    }

    /* access modifiers changed from: protected */
    public final isz O000000o(isz isz) throws IOException {
        if (this.O00000o0.O000000o()) {
            return isz;
        }
        isz O000000o2 = O000000o(O000000o(isz, ita.O000000o(this.O00000o0.O00000o(), DNSRecordType.TYPE_SRV, DNSRecordClass.CLASS_IN, false)), ita.O000000o(this.O00000o0.O00000o(), DNSRecordType.TYPE_TXT, DNSRecordClass.CLASS_IN, false));
        return this.O00000o0.O00000oO().length() > 0 ? O000000o(O000000o(O000000o2, ita.O000000o(this.O00000o0.O00000oO(), DNSRecordType.TYPE_A, DNSRecordClass.CLASS_IN, false)), ita.O000000o(this.O00000o0.O00000oO(), DNSRecordType.TYPE_AAAA, DNSRecordClass.CLASS_IN, false)) : O000000o2;
    }

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        StringBuilder sb = new StringBuilder("querying service info: ");
        ServiceInfoImpl serviceInfoImpl = this.O00000o0;
        sb.append(serviceInfoImpl != null ? serviceInfoImpl.O00000o() : "null");
        return sb.toString();
    }
}
