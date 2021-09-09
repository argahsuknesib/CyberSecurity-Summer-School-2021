package com.xiaomi.smarthome.frame.plugin.rn.debugmock;

import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;

public class MockRnDevicePluginUtil {
    public static PluginPackageInfo mockPluginPackageInfo(long j) {
        PluginPackageInfo pluginPackageInfo = new PluginPackageInfo();
        pluginPackageInfo.O00000Oo(j);
        pluginPackageInfo.O00000Oo("mock_package_".concat(String.valueOf(j)));
        pluginPackageInfo.O00000o0("rn");
        return pluginPackageInfo;
    }

    public static PluginDeviceInfo mockPluginInfo(String str, String str2) {
        PluginDeviceInfo pluginDeviceInfo = new PluginDeviceInfo();
        pluginDeviceInfo.O000000o(str);
        pluginDeviceInfo.O00000Oo(str2);
        return pluginDeviceInfo;
    }

    public static DeviceStat mockDeviceStat(String str, String str2, String str3) {
        DeviceStat deviceStat = new DeviceStat();
        deviceStat.pid = 0;
        deviceStat.did = str;
        deviceStat.model = str2;
        deviceStat.isOnline = true;
        deviceStat.name = str3;
        return deviceStat;
    }
}
