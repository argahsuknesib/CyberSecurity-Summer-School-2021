package _m_j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class ipr implements ipv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ipa f1540O000000o = new ipk();
    private ipz O00000Oo;
    private ioi<List<String>> O00000o;
    private String[] O00000o0;
    private ioi<List<String>> O00000oO;

    public final ipv O000000o(iom<List<String>> iom) {
        return this;
    }

    ipr(ipz ipz) {
        this.O00000Oo = ipz;
    }

    public final ipv O000000o(String... strArr) {
        this.O00000o0 = strArr;
        return this;
    }

    public final ipv O000000o(ioi<List<String>> ioi) {
        this.O00000o = ioi;
        return this;
    }

    public final ipv O00000Oo(ioi<List<String>> ioi) {
        this.O00000oO = ioi;
        return this;
    }

    public final void J_() {
        ipz ipz = this.O00000Oo;
        String[] strArr = this.O00000o0;
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!f1540O000000o.O000000o(ipz.O000000o(), str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            ioi<List<String>> ioi = this.O00000oO;
            if (ioi != null) {
                ioi.O000000o(arrayList);
            }
        } else if (this.O00000o != null) {
            List asList = Arrays.asList(this.O00000o0);
            try {
                this.O00000o.O000000o(asList);
            } catch (Exception unused) {
                ioi<List<String>> ioi2 = this.O00000oO;
                if (ioi2 != null) {
                    ioi2.O000000o(asList);
                }
            }
        }
    }
}
