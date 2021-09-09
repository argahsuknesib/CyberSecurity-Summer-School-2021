package com.xiaomi.smarthome.camera;

import android.content.Context;
import com.xiaomi.smarthome.device.api.Callback;

public interface IRDTPanoramaListener {
    void init(Callback<Object> callback, Context context, long j);

    void onPanoramaReceived(byte[] bArr);
}
