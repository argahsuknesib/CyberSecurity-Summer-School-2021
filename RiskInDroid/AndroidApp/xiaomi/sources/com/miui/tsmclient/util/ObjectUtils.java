package com.miui.tsmclient.util;

import com.miui.tsmclient.database.JSONSerializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class ObjectUtils {
    public static Map<String, String> listToMap(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                List list = (List) next.getValue();
                if (!(str == null || list == null || list.size() <= 0)) {
                    hashMap.put(str, list.get(0));
                }
            }
        }
        return hashMap;
    }

    public static String joinMap(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
            i++;
        }
        return sb.toString();
    }

    public static boolean isCollectionEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isCollectionEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static JSONArray serialize(List<? extends JSONSerializable> list) {
        JSONArray jSONArray = new JSONArray();
        for (JSONSerializable serialize : list) {
            jSONArray.put(serialize.serialize());
        }
        return jSONArray;
    }
}
