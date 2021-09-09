package _m_j;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class dca {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14464O000000o = -2;
    public String O00000Oo;

    private dca() {
    }

    public static dca O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        dca dca = new dca();
        try {
            JSONObject jSONObject = new JSONObject(str);
            dca.f14464O000000o = jSONObject.optInt("code", -2);
            dca.O00000Oo = jSONObject.optString("data", "");
        } catch (JSONException unused) {
        }
        return dca;
    }
}
