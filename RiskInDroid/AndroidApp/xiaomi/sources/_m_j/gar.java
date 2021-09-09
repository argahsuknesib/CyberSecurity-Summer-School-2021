package _m_j;

import org.json.JSONObject;

public final class gar {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final gar f17470O000000o = new gar();
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;

    public static gar O000000o(JSONObject jSONObject) {
        gar gar = new gar();
        gar.O00000Oo = jSONObject.optString("deviceID");
        gar.O00000o0 = jSONObject.optString("miotDID");
        gar.O00000o = jSONObject.optString("serialNumber");
        gar.O00000oO = jSONObject.optString("name");
        gar.O00000oo = jSONObject.optString("alias");
        gar.O0000O0o = jSONObject.optString("presence");
        return gar;
    }
}
