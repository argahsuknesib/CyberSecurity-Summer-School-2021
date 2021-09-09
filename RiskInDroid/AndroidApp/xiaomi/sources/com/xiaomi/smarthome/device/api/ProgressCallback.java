package com.xiaomi.smarthome.device.api;

public interface ProgressCallback<T> extends Callback<T> {
    void onProgress(long j, long j2);
}
