package _m_j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public final class gkx {
    public static String O000000o(List<? extends gkw> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (gkw gkw : list) {
            String O000000o2 = O000000o(gkw.O000000o(), str);
            String O00000Oo = gkw.O00000Oo();
            String O000000o3 = O00000Oo != null ? O000000o(O00000Oo, str) : "";
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
