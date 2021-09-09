package _m_j;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class fap {

    /* renamed from: O000000o  reason: collision with root package name */
    private Map<String, faq> f16026O000000o;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final fap f16027O000000o = new fap((byte) 0);
    }

    /* synthetic */ fap(byte b) {
        this();
    }

    private fap() {
        this.f16026O000000o = new HashMap();
    }

    public final faq O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new faq();
        }
        String upperCase = str.toUpperCase();
        faq faq = this.f16026O000000o.get(upperCase);
        if (faq != null) {
            return faq;
        }
        faq faq2 = new faq(upperCase);
        this.f16026O000000o.put(upperCase, faq2);
        return faq2;
    }
}
