package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public final class flp {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f16581O000000o;
    private String O00000Oo;

    public flp(String str, String str2) {
        this.f16581O000000o = str;
        this.O00000Oo = str2;
    }

    flp() {
    }

    static flp O000000o(String str) {
        flp flp = new flp();
        try {
            JSONObject jSONObject = new JSONObject(str);
            flp.f16581O000000o = jSONObject.optString("package_name");
            flp.O00000Oo = jSONObject.optString("cert");
            return flp;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final synchronized String O000000o() {
        return this.f16581O000000o;
    }

    public final synchronized String O00000Oo() {
        return this.O00000Oo;
    }
}
