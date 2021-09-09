package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import com.google.android.gms.internal.stable.zzg;

public final class DeviceStateUtils {
    private static final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzzw;
    private static float zzzx = Float.NaN;

    private DeviceStateUtils() {
    }

    @TargetApi(20)
    public static int getDeviceState(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, filter);
        int i = 0;
        if (((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0) {
            i = 1;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((isInteractive(powerManager) ? 1 : 0) << true) | i;
    }

    public static synchronized float getPowerPercentage(Context context) {
        synchronized (DeviceStateUtils.class) {
            if (SystemClock.elapsedRealtime() - zzzw >= 60000 || Float.isNaN(zzzx)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, filter);
                if (registerReceiver != null) {
                    zzzx = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzzw = SystemClock.elapsedRealtime();
                float f = zzzx;
                return f;
            }
            float f2 = zzzx;
            return f2;
        }
    }

    public static boolean hasConsentedNlp(Context context) {
        return zzg.getInt(context.getContentResolver(), "network_location_opt_in", -1) == 1;
    }

    public static boolean isCallActive(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getMode() == 2;
    }

    public static boolean isInteractive(Context context) {
        return isInteractive((PowerManager) context.getSystemService("power"));
    }

    @TargetApi(20)
    public static boolean isInteractive(PowerManager powerManager) {
        return PlatformVersion.isAtLeastKitKatWatch() ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    public static boolean isUserSetupComplete(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.Secure.getInt(context.getContentResolver(), "user_setup_complete", -1) == 1;
    }

    @VisibleForTesting
    public static synchronized void resetForTest() {
        synchronized (DeviceStateUtils.class) {
            zzzw = 0;
            zzzx = Float.NaN;
        }
    }
}
