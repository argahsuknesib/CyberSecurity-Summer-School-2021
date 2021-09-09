package _m_j;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class gwf {
    public static HashMap<String, Object> O000000o(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    hashMap.put(next, O000000o((JSONObject) obj));
                } else if (obj instanceof Integer) {
                    hashMap.put(next, obj);
                } else if (obj instanceof String) {
                    hashMap.put(next, obj);
                } else if (obj instanceof Double) {
                    hashMap.put(next, obj);
                }
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }
}
