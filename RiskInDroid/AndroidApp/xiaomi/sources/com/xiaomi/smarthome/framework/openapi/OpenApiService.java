package com.xiaomi.smarthome.framework.openapi;

import _m_j.fvj;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OpenApiService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        fvj.O000000o(intent);
        return super.onStartCommand(intent, i, i2);
    }
}
