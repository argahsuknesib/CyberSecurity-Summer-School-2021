package com.xiaomi.smarthome.frame.plugin.runtime.service;

import android.os.Handler;
import android.os.Looper;

public class PluginHostServiceOneMore extends PluginHostService {
    public void onCreate() {
        super.onCreate();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.frame.plugin.runtime.service.PluginHostServiceOneMore.AnonymousClass1 */

            public void run() {
                PluginHostServiceOneMore.this.stopSelf();
                System.exit(0);
            }
        }, 7200000);
    }
}
