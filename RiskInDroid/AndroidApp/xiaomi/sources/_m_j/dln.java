package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class dln {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14771O000000o = null;
    public String O00000Oo = null;
    private String O00000o = null;
    public int O00000o0;
    private String O00000oO = "0";
    private int O00000oo = 0;
    private long O0000O0o = 0;

    public dln() {
    }

    public dln(String str, String str2, int i) {
        this.f14771O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = i;
    }

    private JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            dmb.O000000o(jSONObject, "ui", this.f14771O000000o);
            dmb.O000000o(jSONObject, "mc", this.O00000Oo);
            dmb.O000000o(jSONObject, "mid", this.O00000oO);
            dmb.O000000o(jSONObject, "aid", this.O00000o);
            jSONObject.put("ts", this.O0000O0o);
            jSONObject.put("ver", this.O00000oo);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return O000000o().toString();
    }
}
