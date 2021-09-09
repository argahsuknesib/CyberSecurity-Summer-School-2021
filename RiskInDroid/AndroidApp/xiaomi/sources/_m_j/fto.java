package _m_j;

import android.text.TextUtils;

public final class fto {
    public static String O000000o(String str) {
        if (TextUtils.equals("iw", str)) {
            return "he";
        }
        if (TextUtils.equals("ji", str)) {
            return "yi";
        }
        return TextUtils.equals("in", str) ? "id" : str;
    }
}
