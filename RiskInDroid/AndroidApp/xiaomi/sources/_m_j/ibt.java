package _m_j;

import java.util.HashMap;
import java.util.Map;

public final class ibt {
    public static Map<String, String> O000000o(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", String.valueOf(i));
        hashMap.put("errMsg", str);
        return hashMap;
    }
}
