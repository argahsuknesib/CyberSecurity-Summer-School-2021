package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class frr {

    /* renamed from: O000000o  reason: collision with root package name */
    public Long f16981O000000o;
    public long O00000Oo;

    public static List<frr> O000000o(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("result");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            frr frr = new frr();
            try {
                frr.f16981O000000o = Long.valueOf(optJSONArray.getJSONObject(i).optLong("receiver", -1));
                frr.O00000Oo = optJSONArray.getJSONObject(i).optLong("last_modify");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            arrayList.add(frr);
        }
        return arrayList;
    }

    public static List<frr> O00000Oo(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            frr frr = new frr();
            try {
                frr.f16981O000000o = Long.valueOf(optJSONArray.getJSONObject(i).optLong("uid", -1));
                frr.O00000Oo = optJSONArray.getJSONObject(i).optLong("time_stamp");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            arrayList.add(frr);
        }
        return arrayList;
    }
}
