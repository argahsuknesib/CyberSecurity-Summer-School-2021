package _m_j;

import _m_j.itb;
import java.io.IOException;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;

public final class itm extends itk {
    private final String O00000o0;

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        return "querying service";
    }

    public itm(JmDNSImpl jmDNSImpl, String str) {
        super(jmDNSImpl);
        this.O00000o0 = str;
    }

    public final String O000000o() {
        String str;
        StringBuilder sb = new StringBuilder("ServiceResolver(");
        if (this.f1625O000000o != null) {
            str = this.f1625O000000o.O0000o0O;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final isz O00000Oo(isz isz) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        for (ServiceInfo next : this.f1625O000000o.O00000oo.values()) {
            isz = O000000o(isz, new itb.O0000O0o(next.O00000Oo(), DNSRecordClass.CLASS_IN, false, 3600, next.O00000o()), currentTimeMillis);
        }
        return isz;
    }

    /* access modifiers changed from: protected */
    public final isz O000000o(isz isz) throws IOException {
        return O000000o(isz, ita.O000000o(this.O00000o0, DNSRecordType.TYPE_PTR, DNSRecordClass.CLASS_IN, false));
    }
}
