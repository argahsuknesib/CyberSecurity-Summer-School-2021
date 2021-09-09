package _m_j;

import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class iji {
    private static String O00000Oo(String str, Map<String, String> map) {
        byte[] bArr;
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : map.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) next.getValue());
            stringBuffer.append("&");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        try {
            String O000000o2 = ijh.O000000o(stringBuffer.toString());
            if (O000000o2 == null) {
                return null;
            }
            if (str == null) {
                return null;
            }
            byte[] bytes = O000000o2.getBytes();
            byte[] bytes2 = str.getBytes();
            if (bytes != null) {
                if (bytes2 != null) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "HmacSHA1");
                    Mac instance = Mac.getInstance("HmacSHA1");
                    instance.init(secretKeySpec);
                    bArr = instance.doFinal(bytes);
                    return ili.O000000o(bArr);
                }
            }
            bArr = null;
            return ili.O000000o(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O000000o(String str, Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        return O00000Oo(str, treeMap);
    }
}
