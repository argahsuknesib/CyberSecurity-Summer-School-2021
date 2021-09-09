package _m_j;

import org.json.JSONObject;

public final class dax extends daw {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14425O000000o = "";
    public String O00000Oo = "";

    /* access modifiers changed from: protected */
    public final void O000000o(JSONObject jSONObject) {
        this.f14425O000000o = jSONObject.optString("openid");
        this.O00000Oo = jSONObject.optString("channel");
    }

    public final String toString() {
        return "OpenId{openid='" + this.f14425O000000o + '\'' + ", channel='" + this.O00000Oo + '\'' + '}';
    }
}
