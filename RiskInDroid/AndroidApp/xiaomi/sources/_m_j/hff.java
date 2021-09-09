package _m_j;

import com.xiaomi.smarthome.device.api.spec.definitions.data.Access;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hff {
    public static Map<Integer, SpecProperty> O000000o(JSONArray jSONArray) {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(0, 0.75f, false);
        if (jSONArray != null) {
            while (i < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("type", "");
                String optString2 = optJSONObject.optString("name", "");
                String optString3 = optJSONObject.optString("description", "");
                String optString4 = optJSONObject.optString("format", "");
                Access O000000o2 = hfc.O000000o(optJSONObject.optJSONArray("access"));
                ConstraintValue constraintValue = null;
                if (!optJSONObject.has("value-list") || !optJSONObject.has("value-range")) {
                    if (optJSONObject.has("value-list")) {
                        constraintValue = hfc.O000000o(optString4, optJSONObject.optJSONArray("value-list"));
                    }
                    if (optJSONObject.has("value-range")) {
                        constraintValue = hfc.O00000Oo(optString4, optJSONObject.optJSONArray("value-range"));
                    }
                    SpecProperty specProperty = new SpecProperty(optJSONObject.optInt("iid", -1), optString, optString2, optString3, O000000o2, optString4, constraintValue, optJSONObject.optString("unit", ""));
                    linkedHashMap.put(Integer.valueOf(specProperty.getIid()), specProperty);
                    i++;
                } else {
                    throw new IllegalArgumentException("value-list & value-range both exist!");
                }
            }
        }
        return linkedHashMap;
    }
}
