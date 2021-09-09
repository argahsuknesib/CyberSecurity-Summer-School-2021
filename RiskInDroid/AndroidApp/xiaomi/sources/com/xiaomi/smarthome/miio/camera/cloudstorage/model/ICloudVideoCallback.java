package com.xiaomi.smarthome.miio.camera.cloudstorage.model;

public abstract class ICloudVideoCallback<T> {
    public void onCloudVideoFailed(int i, String str) {
    }

    public void onCloudVideoSuccess(Object obj, Object obj2) {
    }

    public void onCloudVideoSuccess(T t, Object obj, boolean z) {
    }
}
