package _m_j;

import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hfg {
    public static Map<Integer, SpecService> O000000o(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(0, 0.75f, false);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            SpecService specService = new SpecService(optJSONObject.optInt("iid", -1), optJSONObject.optString("type", ""), optJSONObject.optString("name", ""), optJSONObject.optString("description", ""), hff.O000000o(optJSONObject.optJSONArray("properties")), hfb.O000000o(optJSONObject.optJSONArray("actions")), hfe.O000000o(optJSONObject.optJSONArray("events")));
            linkedHashMap.put(Integer.valueOf(specService.getIid()), specService);
        }
        return linkedHashMap;
    }
}
