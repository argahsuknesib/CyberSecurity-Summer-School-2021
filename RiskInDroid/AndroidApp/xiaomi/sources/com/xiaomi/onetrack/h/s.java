package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s {

    public interface a {
        boolean a(Object obj);
    }

    public static JSONObject a(Map<String, Object> map, boolean z) {
        return a(map, new t(z));
    }

    public static JSONObject a(Map<String, Object> map) {
        return a(map, new u());
    }

    private static JSONObject a(Map<String, Object> map, a aVar) {
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (!aVar.a(value)) {
                    if (q.f6178a) {
                        a("ParamUtil", (String) next.getKey());
                    }
                } else if (b(value)) {
                    jSONObject.put(str, value);
                } else if (value instanceof List) {
                    jSONObject.put(str, a((List) value));
                }
            }
        } catch (Exception e) {
            q.b("ParamUtil", "checkParam error:" + e.toString());
        }
        return jSONObject;
    }

    private static JSONArray a(List list) throws JSONException {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Object next : list) {
            if (b(next)) {
                jSONArray.put(next);
            } else if (next instanceof Map) {
                JSONObject jSONObject = new JSONObject();
                boolean z = false;
                for (Map.Entry entry : ((Map) next).entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if ((key instanceof String) && b(value)) {
                        jSONObject.put((String) key, value);
                        z = true;
                    }
                }
                if (z) {
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    public static void a(String str, String str2) {
        q.b(str, "key is " + str2 + ", the param value is invalid，please change the parameter type to string ,numeric, boolean！");
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return new JSONObject();
        }
        if (jSONObject == null && jSONObject2 != null) {
            return jSONObject2;
        }
        if (jSONObject != null && jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject2.put(next, jSONObject.opt(next));
            }
            return jSONObject2;
        } catch (Exception e) {
            q.b("ParamUtil", "merge error：" + e.toString());
            return jSONObject;
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /* access modifiers changed from: private */
    public static boolean d(Object obj) {
        return obj instanceof Number;
    }

    public static boolean a(Object obj) {
        return b(obj) || (obj instanceof List);
    }

    public static boolean b(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof String);
    }

    public static boolean a(String str) {
        if (!c(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("onetrack_") || lowerCase.startsWith("ot_")) {
            return false;
        }
        return true;
    }

    private static boolean c(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (i == 0 && Character.isDigit(c)) {
                return false;
            }
            if (c != '_' && !Character.isDigit(c) && ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
                return false;
            }
        }
        return true;
    }
}
