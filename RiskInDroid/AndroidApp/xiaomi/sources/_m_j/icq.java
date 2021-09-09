package _m_j;

import com.xiaomi.youpin.login.other.http.KeyValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public final class icq {
    public static String O000000o(List<? extends KeyValuePair> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (KeyValuePair keyValuePair : list) {
            String O000000o2 = O000000o(keyValuePair.f12090O000000o, str);
            String str2 = keyValuePair.O00000Oo;
            String O000000o3 = str2 != null ? O000000o(str2, str) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(O000000o2);
            sb.append("=");
            sb.append(O000000o3);
        }
        return sb.toString();
    }

    private static String O000000o(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
