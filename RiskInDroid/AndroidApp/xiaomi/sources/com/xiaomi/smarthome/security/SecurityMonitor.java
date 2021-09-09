package com.xiaomi.smarthome.security;

import android.content.Context;

public class SecurityMonitor {
    public native SecurityResult getSecurityKey(Context context, String str);

    public native boolean isValidSign(Context context);
}
