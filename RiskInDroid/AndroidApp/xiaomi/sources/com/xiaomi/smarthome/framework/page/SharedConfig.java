package com.xiaomi.smarthome.framework.page;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedConfig {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f7790O000000o;
    SharedPreferences O00000Oo;

    public SharedConfig(Context context) {
        this.f7790O000000o = context;
        this.O00000Oo = context.getSharedPreferences("welcome_config", 0);
    }
}
