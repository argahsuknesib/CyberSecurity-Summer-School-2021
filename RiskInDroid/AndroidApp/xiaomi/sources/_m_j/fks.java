package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class fks {

    /* renamed from: O000000o  reason: collision with root package name */
    public fkr f16551O000000o;
    public fkq O00000Oo;

    public static fks O000000o(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        fks fks = new fks();
        JSONObject optJSONObject = jSONObject.optJSONObject("devices");
        if (optJSONObject != null && z) {
            fks.f16551O000000o = fkr.O000000o(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("developers");
        if (optJSONObject2 != null && z2) {
            fks.O00000Oo = fkq.O000000o(optJSONObject2);
        }
        return fks;
    }
}
