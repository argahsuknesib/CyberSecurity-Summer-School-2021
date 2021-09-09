package _m_j;

import android.text.TextUtils;

public final class ewt {
    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http:") || str.startsWith("https:")) {
            return str;
        }
        if (str.startsWith("//")) {
            return "http:".concat(String.valueOf(str));
        }
        return "http://".concat(String.valueOf(str));
    }
}
