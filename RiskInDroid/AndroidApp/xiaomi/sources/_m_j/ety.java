package _m_j;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class ety {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f15813O000000o = "ety";

    public static JSONObject O000000o(Context context, etz etz) {
        euh.O000000o("Welcome to use XiaoMi SafeData SDK,SDK Version is :1.0.3");
        JSONObject jSONObject = new JSONObject();
        try {
            if (etz.f15814O000000o) {
                long currentTimeMillis = System.currentTimeMillis();
                jSONObject.put("root", euf.O000000o(context));
                euh.O000000o("Root spend time: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
            if (etz.O00000Oo) {
                long currentTimeMillis2 = System.currentTimeMillis();
                jSONObject.put("debug", eub.O000000o(context));
                euh.O000000o("Debug spend time: " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
            }
            if (etz.O00000o0) {
                long currentTimeMillis3 = System.currentTimeMillis();
                jSONObject.put("complete", eua.O000000o(context));
                euh.O000000o("Complete spend time: " + (System.currentTimeMillis() - currentTimeMillis3) + "ms");
            }
            if (etz.O00000o) {
                long currentTimeMillis4 = System.currentTimeMillis();
                jSONObject.put("moreOpen", eue.O000000o(context, etz.O0000O0o));
                euh.O000000o("MoreOpen spend time: " + (System.currentTimeMillis() - currentTimeMillis4) + "ms");
            }
            if (etz.O00000oO) {
                long currentTimeMillis5 = System.currentTimeMillis();
                jSONObject.put("hook", eud.O000000o(context, etz.O0000O0o));
                euh.O000000o("Hook spend time: " + (System.currentTimeMillis() - currentTimeMillis5) + "ms");
            }
            if (etz.O00000oo) {
                long currentTimeMillis6 = System.currentTimeMillis();
                jSONObject.put("emulator", euc.O000000o(context));
                euh.O000000o("Emulator spend time: " + (System.currentTimeMillis() - currentTimeMillis6) + "ms");
            }
        } catch (JSONException e) {
            euh.O000000o(e.toString());
        }
        return jSONObject;
    }
}
