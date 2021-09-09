package _m_j;

import android.net.Uri;
import android.text.TextUtils;

public final class czf {
    public static String O00000Oo(String str) {
        return str == null ? "" : str;
    }

    public static String O000000o(String str) {
        return TextUtils.isEmpty(str) ? str : str.toLowerCase();
    }

    public static String O000000o(String str, String str2) {
        return O00000Oo(O000000o(str)) + "://" + O00000Oo(O000000o(str2));
    }

    public static String O000000o(Uri uri) {
        if (uri == null) {
            return null;
        }
        return O000000o(uri.getScheme(), uri.getHost());
    }

    public static String O00000o0(String str) {
        return (str == null || str.startsWith("/")) ? str : "/".concat(String.valueOf(str));
    }
}
