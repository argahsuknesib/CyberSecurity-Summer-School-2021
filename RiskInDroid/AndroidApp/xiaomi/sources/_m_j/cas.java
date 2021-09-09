package _m_j;

import android.text.TextUtils;

public final class cas {
    public static float O000000o(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static long O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
