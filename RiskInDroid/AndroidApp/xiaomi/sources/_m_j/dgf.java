package _m_j;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class dgf {

    /* renamed from: O000000o  reason: collision with root package name */
    String f14600O000000o = null;
    String O00000Oo = null;
    long O00000o = 0;
    public String O00000o0 = "0";

    static dgf O000000o(String str) {
        dgf dgf = new dgf();
        if (dgi.O000000o(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    dgf.f14600O000000o = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    dgf.O00000Oo = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    dgf.O00000o0 = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    dgf.O00000o = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
                Log.w("MID", e);
            }
        }
        return dgf;
    }

    private JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            dgi.O000000o(jSONObject, "ui", this.f14600O000000o);
            dgi.O000000o(jSONObject, "mc", this.O00000Oo);
            dgi.O000000o(jSONObject, "mid", this.O00000o0);
            jSONObject.put("ts", this.O00000o);
        } catch (JSONException e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    public final String toString() {
        return O000000o().toString();
    }
}
