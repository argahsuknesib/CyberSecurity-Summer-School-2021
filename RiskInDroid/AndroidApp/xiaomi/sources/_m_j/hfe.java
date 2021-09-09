package _m_j;

import com.xiaomi.smarthome.device.api.spec.definitions.EventDefinition;
import com.xiaomi.smarthome.device.api.spec.instance.SpecEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hfe {
    private static SpecEvent O000000o(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("iid", -1);
        String optString = jSONObject.optString("type", "");
        String optString2 = jSONObject.optString("name", "");
        String optString3 = jSONObject.optString("description", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("arguments");
        if (optJSONArray == null) {
            return new SpecEvent(optInt, optString, optString2, optString3, (long[]) null);
        }
        int length = optJSONArray.length();
        EventDefinition.SpecArguments[] specArgumentsArr = null;
        long[] jArr = null;
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                if (jArr == null) {
                    jArr = new long[length];
                }
                jArr[i] = optJSONArray.optLong(i);
            } else {
                if (specArgumentsArr == null) {
                    specArgumentsArr = new EventDefinition.SpecArguments[length];
                }
                specArgumentsArr[i] = new EventDefinition.SpecArguments(optJSONObject.optString("format"), optJSONObject.optString("description"));
            }
        }
        if (specArgumentsArr != null) {
            return new SpecEvent(optInt, optString, optString2, optString3, specArgumentsArr);
        }
        return new SpecEvent(optInt, optString, optString2, optString3, jArr);
    }

    public static Map<Integer, SpecEvent> O000000o(JSONArray jSONArray) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(0, 0.75f, false);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                SpecEvent O000000o2 = O000000o(jSONArray.optJSONObject(i));
                linkedHashMap.put(Integer.valueOf(O000000o2.getIid()), O000000o2);
            }
        }
        return linkedHashMap;
    }
}
