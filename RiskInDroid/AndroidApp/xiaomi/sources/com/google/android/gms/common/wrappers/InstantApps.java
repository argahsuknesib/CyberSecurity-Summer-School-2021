package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

public class InstantApps {
    private static Context zzaay;
    private static Boolean zzaaz;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0041 */
    public static synchronized boolean isInstantApp(Context context) {
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzaay == null || zzaaz == null || zzaay != applicationContext) {
                zzaaz = null;
                if (PlatformVersion.isAtLeastO()) {
                    bool = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    zzaaz = Boolean.TRUE;
                    bool = Boolean.FALSE;
                }
                zzaaz = bool;
                zzaay = applicationContext;
                boolean booleanValue = zzaaz.booleanValue();
                return booleanValue;
            }
            boolean booleanValue2 = zzaaz.booleanValue();
            return booleanValue2;
        }
    }
}
