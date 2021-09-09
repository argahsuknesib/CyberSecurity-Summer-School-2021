package com.xiaomi.smarthome.frame.plugin.host;

import com.xiaomi.smarthome.bluetooth.XmBluetoothSearchManager;

public abstract class PluginBluetoothSearchManagerHostApi extends XmBluetoothSearchManager {
    public PluginBluetoothSearchManagerHostApi() {
        instance = this;
    }
}
