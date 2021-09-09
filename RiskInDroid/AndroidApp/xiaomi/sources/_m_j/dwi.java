package _m_j;

import java.util.HashMap;
import java.util.Map;

public final class dwi {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Map<String, String> f14999O000000o = new HashMap();

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry next : this.f14999O000000o.entrySet()) {
            if (i != 0) {
                sb.append('&');
            }
            sb.append((String) next.getKey());
            String str = (String) next.getValue();
            if (str != null) {
                sb.append('=');
                sb.append(str);
            }
            i++;
        }
        return sb.toString();
    }
}
