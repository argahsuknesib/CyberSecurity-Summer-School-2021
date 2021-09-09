package _m_j;

import android.text.TextUtils;
import org.json.JSONObject;

public final class hxe {
    public static void O000000o(long j, String str, String str2, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("delay", j);
            jSONObject.put("rpc", str);
            jSONObject.put("did", str2);
            jSONObject.put("succ", z ? 1 : 0);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("model", str3);
            }
            hxi.O0000Oo.O000000o(2, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
