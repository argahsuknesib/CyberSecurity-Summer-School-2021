package com.xiaomi.smarthome.frame.plugin.runtime.activity;

import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;

public interface IPluginRnActivity {
    String getDeviceModel();

    DeviceStat getDeviceStat();

    PluginDeviceInfo getPluginInfo();

    PluginPackageInfo getPluginRecord();
}
