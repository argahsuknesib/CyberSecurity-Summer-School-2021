package _m_j;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class fvw {
    private static volatile fvw O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f17292O000000o = false;
    public String O00000Oo;
    public String O00000o0;

    private fvw() {
    }

    public static fvw O000000o() {
        if (O00000o == null) {
            synchronized (fvw.class) {
                if (O00000o == null) {
                    O00000o = new fvw();
                }
            }
        }
        return O00000o;
    }

    public static boolean O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(fvt.O0000OOo) || !jSONObject.has(fvt.O0000Oo0)) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean O00000Oo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(fvt.O0000OOo);
            String optString2 = jSONObject.optString(fvt.O0000Oo0);
            if (!TextUtils.equals(optString, "localhost") || !TextUtils.equals(optString2, "com.xiaomi.demo")) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
