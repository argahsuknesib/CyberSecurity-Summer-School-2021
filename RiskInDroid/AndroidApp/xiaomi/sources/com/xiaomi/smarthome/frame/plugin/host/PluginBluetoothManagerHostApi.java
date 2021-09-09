package com.xiaomi.smarthome.frame.plugin.host;

import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;

public abstract class PluginBluetoothManagerHostApi extends XmBluetoothManager {
    public PluginBluetoothManagerHostApi() {
        instance = this;
    }
}
