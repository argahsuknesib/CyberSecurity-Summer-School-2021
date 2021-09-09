package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class hgu {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f18924O000000o;
    public String O00000Oo;
    public String O00000o0;

    public static hgu O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hgu hgu = new hgu();
        if (!jSONObject.isNull("pm25")) {
            hgu.f18924O000000o = jSONObject.optString("pm25");
        }
        if (!jSONObject.isNull("hum")) {
            hgu.O00000Oo = jSONObject.optString("hum");
        }
        if (!jSONObject.isNull("temp")) {
            hgu.O00000o0 = jSONObject.optString("temp");
        }
        return hgu;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pm25", this.f18924O000000o);
            jSONObject.put("hum", this.O00000Oo);
            jSONObject.put("temp", this.O00000o0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
