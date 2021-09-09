package com.xiaomi.smarthome.frame.plugin.host;

import com.xiaomi.smarthome.upnp.UPnPApi;

public abstract class PluginUPnPHostApi extends UPnPApi {
    public PluginUPnPHostApi() {
        _instance = this;
    }
}
