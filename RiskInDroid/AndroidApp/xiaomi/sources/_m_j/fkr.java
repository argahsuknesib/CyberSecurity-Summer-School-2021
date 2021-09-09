package _m_j;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fkr {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16550O000000o;
    public long O00000Oo;
    public HashMap<String, fkp> O00000o0;

    public static fkr O000000o(JSONObject jSONObject) throws JSONException {
        fkr fkr = new fkr();
        fkr.f16550O000000o = jSONObject.optString("type");
        fkr.O00000Oo = jSONObject.optLong("last_modify");
        fkr.O00000o0 = O000000o(jSONObject.optJSONArray("list"));
        return fkr;
    }

    public static HashMap<String, fkp> O000000o(JSONArray jSONArray) throws JSONException {
        HashMap<String, fkp> hashMap = new HashMap<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                if (jSONObject != null) {
                    fkp O000000o2 = fkp.O000000o(jSONObject);
                    hashMap.put(O000000o2.f16547O000000o, O000000o2);
                }
            }
        }
        return hashMap;
    }
}
