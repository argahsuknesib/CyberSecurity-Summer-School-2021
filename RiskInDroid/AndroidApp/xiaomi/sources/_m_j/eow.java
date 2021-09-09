package _m_j;

import android.text.TextUtils;
import android.util.Base64;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class eow {
    public static String O000000o(String str) {
        return Base64.encodeToString(eml.O00000o0(str), 2);
    }

    public static String O000000o(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String next : hashMap.keySet()) {
                jSONObject.put(next, hashMap.get(next));
            }
        } catch (JSONException e) {
            duv.O000000o(e);
        }
        return jSONObject.toString();
    }

    public static String O00000Oo(String str) {
        return eml.O000000o(Base64.decode(str, 2));
    }

    public static String O00000Oo(HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.put("event_type", hashMap.get("event_type"));
            hashMap2.put("description", hashMap.get("description"));
            String str = hashMap.get("awake_info");
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    hashMap2.put("__planId__", String.valueOf(jSONObject.opt("__planId__")));
                    hashMap2.put("flow_id", String.valueOf(jSONObject.opt("flow_id")));
                    hashMap2.put("jobkey", String.valueOf(jSONObject.opt("jobkey")));
                    hashMap2.put("msg_id", String.valueOf(jSONObject.opt("msg_id")));
                    hashMap2.put("A", String.valueOf(jSONObject.opt("awake_app")));
                    hashMap2.put("B", String.valueOf(jSONObject.opt("awakened_app")));
                    hashMap2.put("module", String.valueOf(jSONObject.opt("awake_type")));
                } catch (JSONException e) {
                    duv.O000000o(e);
                }
            }
        }
        return O000000o(hashMap2);
    }
}
