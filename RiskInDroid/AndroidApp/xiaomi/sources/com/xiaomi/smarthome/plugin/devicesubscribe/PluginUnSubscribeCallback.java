package com.xiaomi.smarthome.plugin.devicesubscribe;

import com.xiaomi.smarthome.plugin.Error;

public interface PluginUnSubscribeCallback {
    void onFailure(Error error);

    void onSuccess();
}
