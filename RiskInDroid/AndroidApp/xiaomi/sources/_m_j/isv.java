package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;

public abstract class isv {

    /* renamed from: O000000o  reason: collision with root package name */
    public final boolean f1610O000000o;
    final Map<ServiceInfo.Fields, String> O00000Oo = ServiceInfoImpl.O00000Oo(O00000Oo());
    private final String O00000o;
    private final String O00000o0;
    private final String O00000oO;
    private final DNSRecordType O00000oo;
    private final DNSRecordClass O0000O0o;

    /* access modifiers changed from: protected */
    public void O000000o(StringBuilder sb) {
    }

    public abstract boolean O000000o(long j);

    isv(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
        String str2;
        String str3;
        this.O00000o = str;
        this.O00000oo = dNSRecordType;
        this.O0000O0o = dNSRecordClass;
        this.f1610O000000o = z;
        String str4 = this.O00000Oo.get(ServiceInfo.Fields.Domain);
        String str5 = this.O00000Oo.get(ServiceInfo.Fields.Protocol);
        String str6 = this.O00000Oo.get(ServiceInfo.Fields.Application);
        String lowerCase = this.O00000Oo.get(ServiceInfo.Fields.Instance).toLowerCase();
        StringBuilder sb = new StringBuilder();
        String str7 = "";
        if (str6.length() > 0) {
            str2 = "_" + str6 + ".";
        } else {
            str2 = str7;
        }
        sb.append(str2);
        if (str5.length() > 0) {
            str3 = "_" + str5 + ".";
        } else {
            str3 = str7;
        }
        sb.append(str3);
        sb.append(str4);
        sb.append(".");
        this.O00000oO = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        if (lowerCase.length() > 0) {
            str7 = lowerCase + ".";
        }
        sb2.append(str7);
        sb2.append(this.O00000oO);
        this.O00000o0 = sb2.toString().toLowerCase();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof isv)) {
            return false;
        }
        isv isv = (isv) obj;
        if (!O00000o().equals(isv.O00000o()) || !O00000oO().equals(isv.O00000oO()) || O00000oo() != isv.O00000oo()) {
            return false;
        }
        return true;
    }

    public boolean O000000o(isv isv) {
        if (!O00000o().equals(isv.O00000o()) || !O00000oO().equals(isv.O00000oO())) {
            return false;
        }
        return DNSRecordClass.CLASS_ANY == isv.O00000oo() || O00000oo().equals(isv.O00000oo());
    }

    public final String O00000Oo() {
        String str = this.O00000o;
        return str != null ? str : "";
    }

    public final String O00000o0() {
        String str = this.O00000oO;
        return str != null ? str : "";
    }

    public final String O00000o() {
        String str = this.O00000o0;
        return str != null ? str : "";
    }

    public final DNSRecordType O00000oO() {
        DNSRecordType dNSRecordType = this.O00000oo;
        return dNSRecordType != null ? dNSRecordType : DNSRecordType.TYPE_IGNORE;
    }

    public final DNSRecordClass O00000oo() {
        DNSRecordClass dNSRecordClass = this.O0000O0o;
        return dNSRecordClass != null ? dNSRecordClass : DNSRecordClass.CLASS_UNKNOWN;
    }

    public final boolean O0000O0o() {
        return this.O00000Oo.get(ServiceInfo.Fields.Application).equals("dns-sd") && this.O00000Oo.get(ServiceInfo.Fields.Instance).equals("_services");
    }

    public final boolean O0000OOo() {
        if (!this.O00000Oo.get(ServiceInfo.Fields.Application).equals("dns-sd")) {
            return false;
        }
        String str = this.O00000Oo.get(ServiceInfo.Fields.Instance);
        if ("b".equals(str) || "db".equals(str) || "r".equals(str) || "dr".equals(str) || "lb".equals(str)) {
            return true;
        }
        return false;
    }

    public final boolean O0000Oo0() {
        return O0000Oo() || O0000OoO();
    }

    public final boolean O0000Oo() {
        return this.O00000Oo.get(ServiceInfo.Fields.Domain).endsWith("in-addr.arpa");
    }

    public final boolean O0000OoO() {
        return this.O00000Oo.get(ServiceInfo.Fields.Domain).endsWith("ip6.arpa");
    }

    public boolean O00000Oo(isv isv) {
        return isv != null && isv.O00000oO() == O00000oO();
    }

    /* access modifiers changed from: protected */
    public void O000000o(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(O00000Oo().getBytes("UTF8"));
        dataOutputStream.writeShort(O00000oO().indexValue());
        dataOutputStream.writeShort(O00000oo().indexValue());
    }

    private byte[] O0000Ooo() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            O000000o(dataOutputStream);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new InternalError();
        }
    }

    public final int O00000o0(isv isv) {
        byte[] O0000Ooo = O0000Ooo();
        byte[] O0000Ooo2 = isv.O0000Ooo();
        int min = Math.min(O0000Ooo.length, O0000Ooo2.length);
        for (int i = 0; i < min; i++) {
            if (O0000Ooo[i] > O0000Ooo2[i]) {
                return 1;
            }
            if (O0000Ooo[i] < O0000Ooo2[i]) {
                return -1;
            }
        }
        return O0000Ooo.length - O0000Ooo2.length;
    }

    public int hashCode() {
        return O00000o().hashCode() + O00000oO().indexValue() + O00000oo().indexValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("[");
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(System.identityHashCode(this));
        sb.append(" type: ");
        sb.append(O00000oO());
        sb.append(", class: ");
        sb.append(O00000oo());
        sb.append(this.f1610O000000o ? "-unique," : ",");
        sb.append(" name: ");
        sb.append(this.O00000o);
        O000000o(sb);
        sb.append("]");
        return sb.toString();
    }

    public final String O000000o() {
        String str = (String) Collections.unmodifiableMap(this.O00000Oo).get(ServiceInfo.Fields.Subtype);
        return str != null ? str : "";
    }
}
