package _m_j;

import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hfb {
    public static Map<Integer, SpecAction> O000000o(JSONArray jSONArray) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(0, 0.75f, false);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                SpecAction specAction = new SpecAction(optJSONObject.optInt("iid", -1), optJSONObject.optString("type", ""), optJSONObject.optString("name", ""), optJSONObject.optString("description", ""), optJSONObject.optJSONArray("in"), optJSONObject.optJSONArray("out"));
                linkedHashMap.put(Integer.valueOf(specAction.getIid()), specAction);
            }
        }
        return linkedHashMap;
    }

    public static List<Object> O00000Oo(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.opt(i));
            }
        }
        return arrayList;
    }
}
