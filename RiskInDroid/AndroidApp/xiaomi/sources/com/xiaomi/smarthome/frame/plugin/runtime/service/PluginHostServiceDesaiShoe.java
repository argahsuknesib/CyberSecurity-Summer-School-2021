package com.xiaomi.smarthome.frame.plugin.runtime.service;

import android.os.Handler;
import android.os.Looper;

public class PluginHostServiceDesaiShoe extends PluginHostService {
    public void onCreate() {
        super.onCreate();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.service.PluginHostServiceDesaiShoe.AnonymousClass1 */

            public void run() {
                PluginHostServiceDesaiShoe.this.stopSelf();
                System.exit(0);
            }
        }, 28800000);
    }
}
