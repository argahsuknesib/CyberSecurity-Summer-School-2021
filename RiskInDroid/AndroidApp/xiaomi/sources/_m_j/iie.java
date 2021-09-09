package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class iie {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f1312O000000o = "";
    public String O00000Oo = "";
    public long O00000o = 0;
    public String O00000o0 = "";
    public String O00000oO = "";
    public String O00000oo = "";

    public static iie O000000o(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("{") < 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            iie iie = new iie();
            iie.f1312O000000o = String.valueOf(jSONObject.optInt("uid"));
            iie.O00000Oo = jSONObject.optString("access_token");
            String optString = jSONObject.optString("expires_in");
            if (!TextUtils.isEmpty(optString) && !optString.equals("0")) {
                iie.O00000o = System.currentTimeMillis() + (Long.parseLong(optString) * 1000);
            }
            iie.O00000o0 = jSONObject.optString("refresh_token");
            iie.O00000oO = jSONObject.optString("scope");
            iie.O00000oo = jSONObject.optString("device_id");
            return iie;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean O000000o() {
        return !TextUtils.isEmpty(this.O00000Oo);
    }

    public final Bundle O00000Oo() {
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.f1312O000000o);
        bundle.putString("access_token", this.O00000Oo);
        bundle.putString("refresh_token", this.O00000o0);
        bundle.putString("expires_in", Long.toString(this.O00000o));
        bundle.putString("scope", this.O00000oO);
        bundle.putString("device_id", this.O00000oo);
        return bundle;
    }

    public final String toString() {
        return "uid:" + this.f1312O000000o + ", access_token: " + this.O00000Oo + ", refresh_token: " + this.O00000o0 + ", scope: " + this.O00000oO + ", expires_in: " + Long.toString(this.O00000o) + ", device_id: " + this.O00000oo;
    }
}
