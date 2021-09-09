package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;

public final class htt {
    public static boolean O000000o(String str) {
        PluginDeviceInfo pluginInfo;
        if (!TextUtils.isEmpty(str) && (pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(str)) != null && pluginInfo.O00000o() == 24) {
            return true;
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        PluginDeviceInfo pluginInfo;
        if (!TextUtils.isEmpty(str) && (pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(str)) != null && pluginInfo.O00000o() == 23) {
            return true;
        }
        return false;
    }
}
