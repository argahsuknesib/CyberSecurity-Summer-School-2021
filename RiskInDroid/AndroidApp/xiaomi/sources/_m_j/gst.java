package _m_j;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public final class gst {
    public static String O000000o(String str, List<gsi> list) {
        if (list == null || list.isEmpty()) {
            return str;
        }
        String O000000o2 = O000000o(list, "UTF-8");
        if (!str.contains("?")) {
            return str + "?" + O000000o2;
        }
        return str + "&" + O000000o2;
    }

    private static String O000000o(List<? extends gsi> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (gsi gsi : list) {
            String O000000o2 = O000000o(gsi.f18210O000000o, str);
            String str2 = gsi.O00000Oo;
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

    public static RequestBody O000000o(List<gsi> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (gsi next : list) {
            String str = next.f18210O000000o;
            String str2 = next.O00000Oo;
            if (!TextUtils.isEmpty(str) && str2 != null) {
                builder.add(str, str2);
            }
        }
        return builder.build();
    }

    public static RequestBody O000000o(gsj gsj) {
        if (gsj == null) {
            return null;
        }
        RequestBody requestBody = gsj.O00000o;
        if (requestBody != null) {
            return requestBody;
        }
        return O000000o(gsj.O00000o0);
    }
}
