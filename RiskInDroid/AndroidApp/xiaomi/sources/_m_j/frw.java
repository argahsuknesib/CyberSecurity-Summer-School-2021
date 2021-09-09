package _m_j;

import org.json.JSONObject;

public final class frw {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f17037O000000o;
    public int O00000Oo = -999;
    public String O00000o0;

    public static frw O000000o(JSONObject jSONObject) {
        frw frw = new frw();
        if (jSONObject != null) {
            if (jSONObject.has("code")) {
                frw.O00000Oo = jSONObject.optInt("code", -999);
            }
            if (jSONObject.has("msg")) {
                frw.O00000o0 = jSONObject.optString("msg");
            }
            if (jSONObject.has("share_key")) {
                frw.f17037O000000o = jSONObject.optString("share_key");
            }
        }
        return frw;
    }
}
