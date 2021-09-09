package com.xiaomi.smarthome.device.api;

import android.content.Intent;

public interface MessageCallback {
    void onFailure(int i, String str);

    void onSuccess(Intent intent);
}
