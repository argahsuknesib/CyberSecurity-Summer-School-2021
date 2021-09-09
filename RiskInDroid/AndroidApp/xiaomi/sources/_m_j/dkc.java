package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class dkc {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f14736O000000o = 0;
    public int O00000Oo = 0;
    public int O00000o = 0;
    public String O00000o0 = "";
    public String O00000oO = "";

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f14736O000000o);
            jSONObject.put("st", this.O00000Oo);
            if (this.O00000o0 != null) {
                jSONObject.put("dm", this.O00000o0);
            }
            jSONObject.put("pt", this.O00000o);
            if (this.O00000oO != null) {
                jSONObject.put("rip", this.O00000oO);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
