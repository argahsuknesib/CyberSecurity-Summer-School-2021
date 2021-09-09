package com.inuker.bluetooth.library;

import _m_j.bij;
import _m_j.bky;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class BluetoothService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Context f4485O000000o;

    public static Context getContext() {
        return f4485O000000o;
    }

    public void onCreate() {
        super.onCreate();
        bky.O00000Oo(String.format("BluetoothService onCreate", new Object[0]));
        Context applicationContext = getApplicationContext();
        f4485O000000o = applicationContext;
        bij.f13001O000000o = applicationContext;
    }

    public IBinder onBind(Intent intent) {
        bky.O00000Oo(String.format("BluetoothService onBind", new Object[0]));
        return BluetoothServiceImpl.getInstance();
    }
}
