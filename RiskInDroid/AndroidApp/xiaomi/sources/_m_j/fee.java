package _m_j;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class fee extends glc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ConcurrentMap<String, String> f16181O000000o = new ConcurrentHashMap();

    public static void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            gnk.O00000o0(String.format("addCombo: key = %s, mac = %s", str, str2));
            if (!f16181O000000o.containsKey(str)) {
                f16181O000000o.put(str, str2);
            }
        }
    }

    public static String O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            return f16181O000000o.get(str.toUpperCase());
        }
        return null;
    }
}
