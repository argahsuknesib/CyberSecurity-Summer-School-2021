package com.xiaomi.smarthome.camera;

public interface IMISSListener {
    void onFailed(int i, String str);

    void onProgress(int i);

    void onSuccess(String str, Object obj);
}
