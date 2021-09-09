package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bzq {
    public static List<bzn> O000000o(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                bzn bzn = new bzn();
                bzn.O00000Oo = jSONObject.optString("key");
                bzn.O00000o = Boolean.valueOf(jSONObject.optBoolean("enable"));
                bzn.O0000OOo = jSONObject.optString("gateway");
                bzn.O00000o0 = jSONObject.optString("img");
                bzn.f13495O000000o = Float.parseFloat(jSONObject.optString("min"));
                bzn.O0000O0o = jSONObject.optString("tips");
                bzn.O0000Oo0 = jSONObject.optString("reason");
                arrayList.add(bzn);
                JSONArray jSONArray2 = jSONObject.getJSONArray("rate");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    bzo bzo = new bzo();
                    bzn.O00000oO.add(bzo);
                    bzo.O00000oo = jSONObject2.optString("desc");
                    bzo.O00000o = jSONObject2.get("monthPay").toString();
                    bzo.O00000Oo = jSONObject2.get("interest").toString() + "%";
                    bzo.f13496O000000o = jSONObject2.optString("code");
                    bzo.O0000OOo = jSONObject2.optString("tips");
                    bzo.O00000o0 = jSONObject2.optString("interest_desc");
                    bzo.O00000oO = jSONObject2.optString("months");
                }
            }
        }
        return arrayList;
    }
}
