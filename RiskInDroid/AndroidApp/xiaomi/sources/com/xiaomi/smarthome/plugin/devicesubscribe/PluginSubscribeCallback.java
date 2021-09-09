package com.xiaomi.smarthome.plugin.devicesubscribe;

import com.xiaomi.smarthome.plugin.Error;
import org.json.JSONArray;

public interface PluginSubscribeCallback {
    void onFailure(Error error);

    void onReceive(String str, String str2, JSONArray jSONArray);

    void onSuccess(String str);
}
