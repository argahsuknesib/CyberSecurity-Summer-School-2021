package _m_j;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class daw {

    /* renamed from: O000000o  reason: collision with root package name */
    private JSONObject f14424O000000o;
    public String O00000o = "data error";
    public int O00000o0 = -1;

    public final void O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.O00000o0 = jSONObject.optInt("errno", -1);
            this.O00000o = jSONObject.optString("errmsg", "data error");
            this.f14424O000000o = jSONObject.optJSONObject("data");
            if (this.f14424O000000o == null) {
                this.f14424O000000o = new JSONObject();
            }
            O000000o(this.f14424O000000o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(JSONObject jSONObject);

    public final boolean O000000o() {
        return this.O00000o0 == 0;
    }
}
