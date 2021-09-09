package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;

public final class fqx {
    public static boolean O000000o(String str, String str2) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if ((O00000oO != null && O00000oO.O00000o() == 18) || TextUtils.equals(str, "lumi.lock.mcn01") || TextUtils.equals(str, "loock.lock.v5")) {
            return true;
        }
        if (O000000o(str)) {
            return O00000Oo(str2);
        }
        return false;
    }

    public static boolean O000000o(String str) {
        PluginDeviceInfo O00000oO;
        if (!TextUtils.isEmpty(str) && (O00000oO = CoreApi.O000000o().O00000oO(str)) != null && ((O00000oO.O0000o() == 6 || O00000oO.O00000o() == 18) && O00000oO.O000O00o() == 1)) {
            return true;
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("[._]");
        if (split.length < 2) {
            return false;
        }
        try {
            int intValue = Integer.valueOf(split[0]).intValue();
            int intValue2 = Integer.valueOf(split[1]).intValue();
            if (intValue > 2 || (intValue == 2 && intValue2 >= 2)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
