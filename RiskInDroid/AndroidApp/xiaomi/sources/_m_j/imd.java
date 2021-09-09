package _m_j;

import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;

public final class imd {
    public static String O000000o(String str) {
        if (str != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                str = new BigInteger(1, instance.digest()).toString(16);
                while (str.length() < 32) {
                    str = "0".concat(String.valueOf(str));
                }
            } catch (Exception e) {
                imc.O000000o("md5加密出错" + e.getMessage());
            }
        }
        return str;
    }

    public static String O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("/", 7);
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return O000000o(str.substring(indexOf2, indexOf));
    }
}
