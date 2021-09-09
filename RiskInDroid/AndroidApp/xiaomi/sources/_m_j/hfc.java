package _m_j;

import com.xiaomi.smarthome.device.api.spec.definitions.data.Access;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueRange;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hfc {
    public static Access O000000o(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i, ""));
            }
        }
        return Access.valueOf(arrayList);
    }

    public static ValueList O000000o(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                arrayList.add(new ValueDefinition(str, optJSONObject.opt("value"), optJSONObject.optString("description", "")));
            }
        }
        return new ValueList(arrayList);
    }

    public static ValueRange O00000Oo(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.opt(i));
            }
        }
        return new ValueRange(str, arrayList);
    }
}
