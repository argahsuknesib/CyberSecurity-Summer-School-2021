package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Objects;

public final class DeviceProperties {
    private static Boolean zzzl;
    private static Boolean zzzm;
    private static Boolean zzzn;
    private static Boolean zzzo;
    private static Boolean zzzp;
    private static Boolean zzzq;
    private static Boolean zzzr;
    private static Boolean zzzs;
    private static Boolean zzzt;
    private static Boolean zzzu;
    private static Boolean zzzv;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        if (zzzt == null) {
            zzzt = Boolean.valueOf(PlatformVersion.isAtLeastO() && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"));
        }
        return zzzt.booleanValue();
    }

    public static boolean isChromeOsDevice(Context context) {
        if (zzzs == null) {
            zzzs = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
        }
        return zzzs.booleanValue();
    }

    public static boolean isIoT(Context context) {
        if (zzzr == null) {
            zzzr = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzzr.booleanValue();
    }

    public static boolean isLatchsky(Context context) {
        if (zzzp == null) {
            zzzp = Boolean.valueOf(PlatformVersion.isAtLeastM() && context.getPackageManager().hasSystemFeature("cn.google.services"));
        }
        return zzzp.booleanValue();
    }

    public static boolean isLowRamOrPreKitKat(Context context) {
        ActivityManager activityManager;
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        if (zzzq == null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
            zzzq = Boolean.valueOf(activityManager.isLowRamDevice());
        }
        return Objects.equal(zzzq, Boolean.TRUE);
    }

    public static boolean isPixelDevice(Context context) {
        if (zzzv == null) {
            zzzv = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.PIXEL_EXPERIENCE"));
        }
        return zzzv.booleanValue();
    }

    @TargetApi(21)
    public static boolean isSidewinder(Context context) {
        if (zzzo == null) {
            zzzo = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzzo.booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (com.google.android.gms.common.util.DeviceProperties.zzzm.booleanValue() != false) goto L_0x003e;
     */
    public static boolean isTablet(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (zzzl == null) {
            if (!((resources.getConfiguration().screenLayout & 15) > 3)) {
                if (zzzm == null) {
                    Configuration configuration = resources.getConfiguration();
                    zzzm = Boolean.valueOf((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
                }
            }
            z = true;
            zzzl = Boolean.valueOf(z);
        }
        return zzzl.booleanValue();
    }

    public static boolean isTv(Context context) {
        if (zzzu == null) {
            PackageManager packageManager = context.getPackageManager();
            zzzu = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return zzzu.booleanValue();
    }

    public static boolean isUserBuild() {
        return GooglePlayServicesUtilLight.sIsTestMode ? GooglePlayServicesUtilLight.sTestIsUserBuild : "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean isWearable(Context context) {
        if (zzzn == null) {
            zzzn = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzzn.booleanValue();
    }

    @TargetApi(24)
    public static boolean isWearableWithoutPlayStore(Context context) {
        return (!PlatformVersion.isAtLeastN() || isSidewinder(context)) && isWearable(context);
    }

    @VisibleForTesting
    public static void resetForTest() {
        zzzm = null;
        zzzl = null;
        zzzn = null;
        zzzo = null;
        zzzp = null;
        zzzq = null;
        zzzr = null;
        zzzs = null;
        zzzt = null;
        zzzu = null;
        zzzv = null;
    }

    @VisibleForTesting
    public static void setIsAutoForTest(boolean z) {
        zzzt = Boolean.valueOf(z);
    }

    @VisibleForTesting
    public static void setIsIoTForTest(boolean z) {
        zzzr = Boolean.valueOf(z);
    }

    @VisibleForTesting
    public static void setIsLatchskyForTest(boolean z) {
        zzzp = Boolean.valueOf(z);
    }

    @VisibleForTesting
    public static void setIsLowRamForTest(boolean z) {
        zzzq = Boolean.valueOf(z);
    }

    @VisibleForTesting
    public static void setIsPixelForTest(boolean z) {
        zzzv = Boolean.valueOf(z);
    }

    @VisibleForTesting
    public static void setIsSideWinderForTest(boolean z) {
        zzzo = Boolean.valueOf(z);
    }

    @VisibleForTesting
    public static void setIsTvForTest(boolean z) {
        zzzu = Boolean.valueOf(z);
    }

    @VisibleForTesting
    public static void setIsWearableForTest(boolean z) {
        zzzn = Boolean.valueOf(z);
    }
}
