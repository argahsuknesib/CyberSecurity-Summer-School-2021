package _m_j;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public final class fte {
    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!glc.O0000OOo) {
            return str;
        }
        try {
            return grs.O00000Oo(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void O00000Oo(String str) {
        fec.O00000o0().O00000o0("core-bluetooth", str);
    }
}
