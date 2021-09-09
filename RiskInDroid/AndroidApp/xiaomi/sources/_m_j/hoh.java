package _m_j;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hoh {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f444O000000o;
    public long O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;
    public String O00000oO;
    private String O00000oo;
    private JSONArray O0000O0o;

    public static HashMap<Long, hoh> O000000o(JSONArray jSONArray, String str) {
        HashMap<Long, hoh> hashMap = new HashMap<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.has("template_id")) {
                    try {
                        hashMap.put(Long.valueOf(Long.parseLong(optJSONObject.optString("template_id"))), O000000o(optJSONObject, str));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return hashMap;
    }

    public static hoh O000000o(JSONObject jSONObject, String str) {
        hoh hoh = new hoh();
        try {
            hoh.O00000oo = str;
            String optString = jSONObject.optString("template_id");
            if (!TextUtils.isEmpty(optString)) {
                hoh.f444O000000o = Long.parseLong(optString);
            }
            String optString2 = jSONObject.optString("scene_id");
            if (!TextUtils.isEmpty(optString2)) {
                hoh.O00000Oo = Long.parseLong(optString2);
            }
            hoh.O00000o0 = jSONObject.optBoolean("enable");
            hoh.O0000O0o = jSONObject.optJSONArray("trigger_key_list");
            if (hoh.O0000O0o != null) {
                for (int i = 0; i < hoh.O0000O0o.length(); i++) {
                    if (TextUtils.equals(hoh.O0000O0o.optString(i), "user.click")) {
                        hoh.O00000o = true;
                    }
                    if (TextUtils.equals(hoh.O0000O0o.optString(i), "location.enter_fence") || TextUtils.equals(hoh.O0000O0o.optString(i), "location.leave_fence")) {
                        hoh.O00000oO = hoh.O0000O0o.optString(i);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hoh;
    }
}
