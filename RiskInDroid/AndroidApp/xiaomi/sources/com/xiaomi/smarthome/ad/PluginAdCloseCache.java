package com.xiaomi.smarthome.ad;

import android.content.Context;
import android.content.SharedPreferences;

public class PluginAdCloseCache {
    private static volatile PluginAdCloseCache O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f4146O000000o;

    public PluginAdCloseCache(Context context) {
        this.f4146O000000o = context.getSharedPreferences("xiaomi.plugin.ad.close", 0);
    }

    public static PluginAdCloseCache O000000o(Context context) {
        if (O00000Oo == null) {
            synchronized (PluginAdCloseCache.class) {
                if (O00000Oo == null) {
                    O00000Oo = new PluginAdCloseCache(context);
                }
            }
        }
        return O00000Oo;
    }
}
