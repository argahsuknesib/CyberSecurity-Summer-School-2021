package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class fok {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    private static void O000000o(String str, Map<String, String> map) {
        try {
            gnk.O00000o0(String.format("report key = %s", str));
            if (!TextUtils.isEmpty(str)) {
                new Bundle().putString("extra.key", str);
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
                String jSONObject2 = jSONObject.toString();
                try {
                    if (!TextUtils.isEmpty(str)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("extra.key", str);
                        if (!TextUtils.isEmpty(jSONObject2)) {
                            bundle.putString("extra.value", jSONObject2);
                        }
                        CoreApi.O000000o().O000000o(StatType.ADD_DEVICE, str, jSONObject2, (String) null, false);
                    }
                } catch (Throwable th) {
                    gnk.O000000o(th);
                }
            }
        } catch (JSONException e) {
            gnk.O000000o(e);
        } catch (Throwable th2) {
            gnk.O000000o(th2);
        }
    }

    public static void O000000o(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("mac", str);
        O000000o(str2, hashMap);
    }

    public static void O000000o(String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("mac", str);
        StringBuilder sb = new StringBuilder();
        sb.append(bundle.getInt("extra.status"));
        hashMap.put("status", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bundle.getInt("extra.new.state"));
        hashMap.put("newState", sb2.toString());
        O000000o("bluetooth_connect_failure", hashMap);
    }
}
