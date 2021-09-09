package _m_j;

import android.util.Base64;
import java.util.List;

public final class at {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12581O000000o;
    public final String O00000Oo;
    public final List<List<byte[]>> O00000o;
    public final String O00000o0;
    public final int O00000oO = 0;
    public final String O00000oo = (this.f12581O000000o + "-" + this.O00000Oo + "-" + this.O00000o0);

    public at(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f12581O000000o = (String) bf.O000000o(str);
        this.O00000Oo = (String) bf.O000000o(str2);
        this.O00000o0 = (String) bf.O000000o(str3);
        this.O00000o = (List) bf.O000000o(list);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f12581O000000o + ", mProviderPackage: " + this.O00000Oo + ", mQuery: " + this.O00000o0 + ", mCertificates:");
        for (int i = 0; i < this.O00000o.size(); i++) {
            sb.append(" [");
            List list = this.O00000o.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append(jdn.f1779O000000o);
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.O00000oO);
        return sb.toString();
    }
}
