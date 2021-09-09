package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class gxj {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18466O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public String O00000oo;
    public String O0000O0o;

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userid", this.f18466O000000o);
            jSONObject.put("avatar", this.O0000O0o);
            jSONObject.put("username", this.O00000oo);
            jSONObject.put("age", this.O00000o);
            jSONObject.put("weight", this.O00000Oo);
            jSONObject.put("height", this.O00000o0);
            jSONObject.put("stepsGoal", this.O00000oO);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static gxj O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        gxj gxj = new gxj();
        gxj.f18466O000000o = jSONObject.optInt("userid");
        gxj.O00000Oo = jSONObject.optInt("weight");
        gxj.O00000o0 = jSONObject.optInt("height");
        gxj.O00000o = jSONObject.optInt("age");
        gxj.O00000oO = jSONObject.optInt("stepsGoal", -1);
        if (gxj.O00000oO == -1) {
            gxj.O00000oO = Integer.decode(jSONObject.optString("stepsGoal", "0")).intValue();
        }
        gxj.O00000oo = jSONObject.optString("username");
        gxj.O0000O0o = jSONObject.optString("avatar");
        return gxj;
    }
}
