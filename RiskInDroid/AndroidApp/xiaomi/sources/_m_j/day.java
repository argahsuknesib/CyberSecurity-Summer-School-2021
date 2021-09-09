package _m_j;

import org.json.JSONObject;

public final class day extends daw {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14426O000000o;
    private long O00000Oo;

    /* access modifiers changed from: protected */
    public final void O000000o(JSONObject jSONObject) {
        this.O00000Oo = jSONObject.optLong("timestamp");
        this.f14426O000000o = jSONObject.optString("homepage");
    }

    public final String toString() {
        return "ServerConfig{serverTime=" + this.O00000Oo + ", ur='" + this.f14426O000000o + '\'' + '}';
    }
}
