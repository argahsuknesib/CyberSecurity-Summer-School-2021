package _m_j;

import com.xiaomi.smarthome.devicelistswitch.model.ModelOperations;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class fqz {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f16941O000000o = false;
    Map<String, ModelOperations> O00000Oo = new HashMap();

    public static fqz O000000o(JSONObject jSONObject) {
        fqz fqz = new fqz();
        if (jSONObject.isNull("data")) {
            return fqz;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        ArrayList<ModelOperations> arrayList = new ArrayList<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.addAll(ModelOperations.O000000o(optJSONArray.optJSONObject(i)));
        }
        HashMap hashMap = new HashMap();
        for (ModelOperations modelOperations : arrayList) {
            hashMap.put(modelOperations.f7303O000000o, modelOperations);
        }
        fqz.O00000Oo = hashMap;
        if (!jSONObject.isNull("enabled")) {
            fqz.f16941O000000o = jSONObject.optBoolean("enabled", false);
        }
        return fqz;
    }
}
