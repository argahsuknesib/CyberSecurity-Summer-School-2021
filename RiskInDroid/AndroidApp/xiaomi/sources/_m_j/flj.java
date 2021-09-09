package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.RequestBody;

public final class flj {
    public static String O000000o(String str, List<KeyValuePair> list) {
        if (list == null || list.isEmpty()) {
            return str;
        }
        String O000000o2 = O000000o(list, "UTF-8");
        if (!str.contains("?")) {
            return str + "?" + O000000o2;
        }
        return str + "&" + O000000o2;
    }

    private static String O000000o(List<? extends KeyValuePair> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (KeyValuePair keyValuePair : list) {
            String O000000o2 = O000000o(keyValuePair.f6728O000000o, str);
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

    public static Headers O000000o(List<KeyValuePair> list) {
        if (list == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        for (KeyValuePair next : list) {
            builder.add(next.f6728O000000o, next.O00000Oo);
        }
        return builder.build();
    }

    public static RequestBody O00000Oo(List<KeyValuePair> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (KeyValuePair next : list) {
            String str = next.f6728O000000o;
            String str2 = next.O00000Oo;
            if (!TextUtils.isEmpty(str) && str2 != null) {
                builder.add(str, str2);
            }
        }
        return builder.build();
    }

    public static String O00000o0(List<KeyValuePair> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (KeyValuePair next : list) {
                String str = next.f6728O000000o;
                String str2 = next.O00000Oo;
                if (!TextUtils.isEmpty(str) && str2 != null) {
                    String encode = URLEncoder.encode(str, "UTF-8");
                    String encode2 = URLEncoder.encode(str2, "UTF-8");
                    stringBuffer.append("&" + encode + "=" + encode2);
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                stringBuffer2 = stringBuffer2.replaceFirst("&", "?");
            }
            return stringBuffer2;
        } catch (Exception unused) {
            return null;
        }
    }
}
