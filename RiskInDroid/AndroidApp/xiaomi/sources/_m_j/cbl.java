package _m_j;

import android.text.TextUtils;

public final class cbl {
    public static String O000000o(String str) {
        if (str.startsWith("http:") || str.startsWith("https:")) {
            return str;
        }
        if (str.startsWith("//")) {
            return "http:".concat(String.valueOf(str));
        }
        return "http://".concat(String.valueOf(str));
    }

    public static String O00000Oo(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("http:") && byl.O00000o0) ? str.replaceFirst("http:", "https:") : str;
    }

    public static String O00000o0(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("http:") && byl.O00000o) ? str.replaceFirst("http:", "https:") : str;
    }

    public static String O00000o(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("http:") && byl.O00000oO) ? str.replaceFirst("http:", "https:") : str;
    }
}
