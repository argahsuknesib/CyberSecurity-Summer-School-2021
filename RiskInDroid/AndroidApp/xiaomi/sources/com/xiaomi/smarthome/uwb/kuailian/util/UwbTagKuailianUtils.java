package com.xiaomi.smarthome.uwb.kuailian.util;

import _m_j.dcp;
import _m_j.dct;
import _m_j.fte;
import _m_j.jdn;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;

public class UwbTagKuailianUtils {
    public static boolean isSupport5G(String str) {
        return CoreApi.O000000o().O00000oo(str).O00000oo();
    }

    public static boolean isCurrentConnectedWifiCorrect(Context context, String str) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            String ssid = connectionInfo.getSSID();
            int frequency = Build.VERSION.SDK_INT >= 21 ? connectionInfo.getFrequency() : 0;
            if (ssid.startsWith(jdn.f1779O000000o) && ssid.length() > 2) {
                ssid = ssid.substring(1, ssid.length() - 1);
            }
            String O00000o0 = dcp.O000000o().O00000o0(ssid);
            dct.O00000o0("config ssid: " + ssid + ", pwd: " + fte.O000000o(O00000o0));
            if (!TextUtils.isEmpty(ssid)) {
                if (!TextUtils.isEmpty(O00000o0)) {
                    PluginDeviceInfo O00000oo = CoreApi.O000000o().O00000oo(str);
                    if (O00000oo == null || O00000oo.O00000oo() || frequency <= 4900) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            dct.O00000o0("miui wifi passwd get failed: " + e.getMessage());
            return false;
        }
    }
}
