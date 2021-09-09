package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.frame.core.CoreApi;
import org.json.JSONException;
import org.json.JSONObject;

public final class cjm {
    public static void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            O000000o(str, "click:".concat(String.valueOf(str2)), null, null);
        }
    }

    public static void O000000o(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String concat = "result:".concat(String.valueOf(str2));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", j);
                O000000o(str, concat, jSONObject.toString(), null);
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    private static void O000000o(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
                String str5 = "plugin." + O0000Oo.O000000o() + "." + O0000Oo.O00000Oo();
                cki.O00000o("CloudVideoEventLogger", "am:".concat(String.valueOf(str5)));
                CoreApi.O000000o().O000000o(StatType.PLUGIN, str5, str2, str3, (String) null, false);
            } catch (Exception unused) {
            }
        }
    }
}
