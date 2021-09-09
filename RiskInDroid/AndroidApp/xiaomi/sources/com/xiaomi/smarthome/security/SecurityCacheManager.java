package com.xiaomi.smarthome.security;

import android.content.Context;
import java.util.UUID;

public class SecurityCacheManager {
    private SecurityMonitor monitor;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final SecurityCacheManager f11341O000000o = new SecurityCacheManager();
    }

    static {
        System.loadLibrary("smarthome_security");
    }

    private SecurityCacheManager() {
        this.monitor = new SecurityMonitor();
    }

    public static SecurityCacheManager getInstance() {
        return O000000o.f11341O000000o;
    }

    public String getQRCodeEncryptKey(Context context) {
        return getSecurityKeyByAlias(context, "QRCODE.ENCRYPT.KEY");
    }

    public String getSecurityKeyByAlias(Context context, String str) {
        SecurityResult securityKey = this.monitor.getSecurityKey(context, str);
        if (securityKey.isSuccess()) {
            return securityKey.message;
        }
        return UUID.randomUUID().toString();
    }

    public SecurityResult getSecurityResultByAlias(Context context, String str) {
        return this.monitor.getSecurityKey(context, str);
    }

    public boolean isValidApp(Context context) {
        return this.monitor.isValidSign(context);
    }
}
