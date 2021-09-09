package _m_j;

import android.text.TextUtils;
import java.util.Map;

public final class cfv {

    /* renamed from: O000000o  reason: collision with root package name */
    String f13737O000000o;
    private String O00000Oo;
    private String O00000o0;

    public cfv(Map<String, String> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                if (TextUtils.equals(next, "resultStatus")) {
                    this.f13737O000000o = map.get(next);
                } else if (TextUtils.equals(next, "result")) {
                    this.O00000Oo = map.get(next);
                } else if (TextUtils.equals(next, "memo")) {
                    this.O00000o0 = map.get(next);
                }
            }
        }
    }

    public final String toString() {
        return "resultStatus={" + this.f13737O000000o + "};memo={" + this.O00000o0 + "};result={" + this.O00000Oo + "}";
    }
}
