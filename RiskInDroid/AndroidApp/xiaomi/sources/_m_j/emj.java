package _m_j;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public final class emj {
    private static String O000000o(String str) {
        try {
            return String.valueOf(emi.O000000o(MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException | Exception | NoSuchAlgorithmException e) {
            duv.O000000o("CloudCoder.hash4SHA1 ", e);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String O000000o(String str, Map<String, String> map, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList.add(str.toUpperCase());
            }
            boolean z = true;
            if (!map.isEmpty()) {
                for (Map.Entry entry : new TreeMap(map).entrySet()) {
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            arrayList.add(str2);
            StringBuilder sb = new StringBuilder();
            for (String str3 : arrayList) {
                if (!z) {
                    sb.append('&');
                }
                sb.append(str3);
                z = false;
            }
            return O000000o(sb.toString());
        }
        throw new InvalidParameterException("security is not nullable");
    }
}
