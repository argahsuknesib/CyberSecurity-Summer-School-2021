package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gvb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static long f18329O000000o;

    public static Map<String, Long> O000000o() {
        Set<String> keySet = Collections.unmodifiableMap(guf.O000000o().O00000o0).keySet();
        HashMap hashMap = new HashMap();
        for (String str : keySet) {
            long j = f18329O000000o;
            if (j == 0) {
                long O00000Oo = gpv.O00000Oo(ServiceApplication.getAppContext(), "msg_center_default_check_timestamp", 0);
                if (O00000Oo == 0) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    gpv.O000000o(ServiceApplication.getAppContext(), "msg_center_default_check_timestamp", currentTimeMillis);
                    j = currentTimeMillis;
                } else {
                    j = O00000Oo;
                }
                f18329O000000o = j;
            }
            hashMap.put(str, Long.valueOf(j));
        }
        try {
            JSONArray jSONArray = new JSONArray(gpv.O000000o("new_message_count_json", "[]"));
            if (jSONArray.length() == 0) {
                return hashMap;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("type");
                if (optJSONObject.optBoolean("message_read", false)) {
                    long O000000o2 = O000000o(optString);
                    if (O000000o2 > 0) {
                        O000000o2++;
                    }
                    hashMap.put(optString, Long.valueOf(O000000o2));
                }
            }
            return hashMap;
        } catch (Exception unused) {
        }
    }

    private static long O000000o(String str) {
        try {
            JSONArray jSONArray = new JSONArray(gpv.O000000o("new_message_count_json", "[]"));
            if (jSONArray.length() == 0) {
                return 0;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (TextUtils.equals(optJSONObject.optString("type"), str)) {
                    return optJSONObject.optLong("latest_time_stamp", 0);
                }
            }
            return 0;
        } catch (Exception unused) {
        }
    }
}
