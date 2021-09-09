package _m_j;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fkq {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16549O000000o;
    public long O00000Oo;
    public HashMap<Long, String> O00000o0 = new HashMap<>();

    public static fkq O000000o(JSONObject jSONObject) throws JSONException {
        fkq fkq = new fkq();
        fkq.f16549O000000o = jSONObject.optString("type");
        fkq.O00000Oo = jSONObject.optLong("last_modify");
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                if (jSONObject2 != null) {
                    fkq.O00000o0.put(Long.valueOf(jSONObject2.optLong("developer_id")), jSONObject2.optString("key"));
                }
            }
        }
        return fkq;
    }
}
