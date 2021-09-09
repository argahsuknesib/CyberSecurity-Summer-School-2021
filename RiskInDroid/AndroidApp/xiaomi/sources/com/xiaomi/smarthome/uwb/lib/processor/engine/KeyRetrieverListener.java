package com.xiaomi.smarthome.uwb.lib.processor.engine;

public interface KeyRetrieverListener {
    void onError(int i, String str);

    void onSuccess(String str, int i, String str2);
}
