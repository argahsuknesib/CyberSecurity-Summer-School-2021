package com.xiaomi.smarthome.device.api;

import com.xiaomi.plugin.core.XmPluginPackage;

public interface IXmPluginActivity {
    void attach(IXmPluginHostActivity iXmPluginHostActivity, XmPluginPackage xmPluginPackage, DeviceStat deviceStat);
}
