package _m_j;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class iig {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f1314O000000o = "";
    public String O00000Oo = "";
    public String O00000o0 = "";

    public static iig O000000o(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("{") < 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            iig iig = new iig();
            iig.f1314O000000o = jSONObject.optString("error_no");
            iig.O00000Oo = jSONObject.optString("error_code");
            iig.O00000o0 = jSONObject.optString("error_desc");
            return iig;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
