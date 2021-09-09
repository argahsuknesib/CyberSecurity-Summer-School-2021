package _m_j;

import android.text.TextUtils;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public final class gbn {
    public static RequestBody O000000o(ReadableMap readableMap, String str) {
        Map<String, Object> O000000o2 = gbv.O000000o(readableMap);
        FormBody.Builder builder = new FormBody.Builder();
        for (String next : O000000o2.keySet()) {
            Object obj = O000000o2.get(next);
            if (obj != null) {
                builder.add(next, obj.toString());
            }
        }
        builder.add("access_token", str);
        builder.add("token", str);
        return builder.build();
    }

    public static String O000000o(String str, ReadableMap readableMap, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str3);
        sb.append("?");
        sb.append("access_token=".concat(String.valueOf(str2)));
        sb.append("&token=".concat(String.valueOf(str2)));
        if (!TextUtils.isEmpty(str) && "GET".equalsIgnoreCase(str)) {
            Map<String, Object> O000000o2 = gbv.O000000o(readableMap);
            for (String next : O000000o2.keySet()) {
                Object obj = O000000o2.get(next);
                if (obj != null) {
                    sb.append("&" + next + "=" + obj.toString());
                }
            }
        }
        return sb.toString();
    }
}
