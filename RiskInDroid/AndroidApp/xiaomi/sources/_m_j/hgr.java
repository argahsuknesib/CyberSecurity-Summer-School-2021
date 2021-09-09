package _m_j;

import org.json.JSONObject;

public final class hgr {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f18915O000000o;
    public String O00000Oo;

    public hgr(String str, String str2) {
        this.f18915O000000o = str == null ? "" : str;
        this.O00000Oo = str2 == null ? "" : str2;
    }

    public hgr() {
    }

    public static hgr O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hgr hgr = new hgr();
        hgr.f18915O000000o = jSONObject.optString("prop_name");
        hgr.O00000Oo = jSONObject.optString("did");
        return hgr;
    }
}
