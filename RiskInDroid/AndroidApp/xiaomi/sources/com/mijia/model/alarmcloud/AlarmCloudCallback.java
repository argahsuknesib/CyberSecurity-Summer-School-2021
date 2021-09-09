package com.mijia.model.alarmcloud;

import com.xiaomi.smarthome.device.api.Callback;

public interface AlarmCloudCallback<T> extends Callback<T> {
    void onSuccess(Object obj, long j, boolean z);
}
