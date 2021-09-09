package _m_j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class fli {

    public interface O000000o<T> {
        T addItem(JSONArray jSONArray, int i);
    }

    public interface O00000Oo<T> extends flg<T, JSONObject> {
    }

    public static String O000000o(Object obj) {
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static void O000000o(List<String> list, JSONArray jSONArray) {
        $$Lambda$fli$Cgi60mepisDdS2GZgSzBiKwNLXM r0 = new O000000o(list) {
            /* class _m_j.$$Lambda$fli$Cgi60mepisDdS2GZgSzBiKwNLXM */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final Object addItem(JSONArray jSONArray, int i) {
                return jSONArray.put(this.f$0.get(i));
            }
        };
        for (int i = 0; i < list.size(); i++) {
            r0.addItem(jSONArray, i);
        }
    }

    public static JSONArray O00000Oo(Object obj) {
        try {
            return (JSONArray) obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] O000000o(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        int length = optJSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = optJSONArray.optString(i);
        }
        Arrays.sort(strArr);
        return strArr;
    }

    public static <T> void O000000o(JSONObject jSONObject, Map map, O00000Oo o00000Oo) {
        if (map != null) {
            map.clear();
        }
        if (jSONObject != null && jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object item = o00000Oo.getItem(jSONObject, next);
                if (map != null) {
                    map.put(next, item);
                }
            }
        }
    }

    public static void O000000o(JSONArray jSONArray, List<String> list) {
        O000000o(jSONArray, list, $$Lambda$vZcOzrIVcw8V4Bvw6dw4WSZoXJ0.INSTANCE);
    }

    public static void O00000Oo(JSONArray jSONArray, List<Integer> list) {
        O000000o(jSONArray, list, $$Lambda$tFHdaffeBHsq1S2ysM1sakU8P8k.INSTANCE);
    }

    public static <T> void O000000o(JSONArray jSONArray, List list, O000000o o000000o) {
        if (list != null) {
            list.clear();
        }
        if (jSONArray != null && jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object addItem = o000000o.addItem(jSONArray, i);
                if (list != null) {
                    list.add(addItem);
                }
            }
        }
    }

    public static int O000000o(Object obj, int i) {
        return hhc.O000000o(obj, i);
    }
}
