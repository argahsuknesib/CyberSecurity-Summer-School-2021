package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.core.CoreApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hjc {
    public static void O000000o(Context context) {
        String O0000o0 = CoreApi.O000000o().O0000o0();
        hjd.O000000o(context, "noti_device_setting_lite" + gpp.O000000o(O0000o0));
        hjd.O000000o(context, "noti_device_setting" + gpp.O000000o(O0000o0));
    }

    public static void O000000o(Context context, boolean z) {
        String O0000o0 = CoreApi.O000000o().O0000o0();
        if (!TextUtils.isEmpty(O0000o0)) {
            hjd.O000000o(context, "noti_device_setting_lite" + gpp.O000000o(O0000o0), "is_open", String.valueOf(z));
        }
    }

    public static boolean O00000Oo(Context context) {
        String O0000o0 = CoreApi.O000000o().O0000o0();
        if (TextUtils.isEmpty(O0000o0)) {
            return false;
        }
        return Boolean.parseBoolean(hjd.O00000Oo(context, "noti_device_setting_lite" + gpp.O000000o(O0000o0), "is_open", "false"));
    }

    public static String O00000o0(Context context) {
        if (TextUtils.isEmpty(CoreApi.O000000o().O0000o0())) {
            return "uid is null";
        }
        String O00000Oo = hjd.O00000Oo(context, "noti_device_setting_lite" + gpp.O000000o(CoreApi.O000000o().O0000o0()), "dids", "");
        gsy.O00000Oo("DeviceConfigManager", "getDeviceSettingFromFile userId: " + CoreApi.O000000o().O0000o0());
        gsy.O00000Oo("DeviceConfigManager", "getDeviceSettingFromFile: ".concat(String.valueOf(O00000Oo)));
        return O00000Oo;
    }

    public static boolean O000000o(Context context, JSONArray jSONArray, JSONArray jSONArray2) {
        if (TextUtils.isEmpty(CoreApi.O000000o().O0000o0())) {
            gsy.O00000Oo("DeviceConfigManager", "AccountManager uid is null,DeviceNotiSetting fail");
            return false;
        } else if (jSONArray.length() == 0) {
            gsy.O00000Oo("DeviceConfigManager", "DeviceNotiSetting fail");
            return false;
        } else if (jSONArray2.length() == 0) {
            gsy.O00000Oo("DeviceConfigManager", "DeviceNotiSetting fail");
            return false;
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("list", jSONArray);
                jSONObject.put("config", jSONArray2);
            } catch (JSONException unused) {
            }
            gsy.O00000Oo("DeviceConfigManager", "DeviceNotiSetting:  " + jSONObject.toString());
            boolean O000000o2 = hjd.O000000o(context, "noti_device_setting" + gpp.O000000o(CoreApi.O000000o().O0000o0()), "devices", jSONObject.toString());
            if (O000000o2) {
                gsy.O00000Oo("DeviceConfigManager", "DeviceNotiSetting success");
            } else {
                gsy.O00000Oo("DeviceConfigManager", "DeviceNotiSetting fail");
            }
            return O000000o2;
        }
    }
}
