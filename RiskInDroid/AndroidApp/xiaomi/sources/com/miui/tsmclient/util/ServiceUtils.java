package com.miui.tsmclient.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import java.util.List;

public class ServiceUtils {
    private ServiceUtils() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void startService(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (isInWhiteList(context)) {
                    context.startService(intent);
                } else if (needStartInForeground(context, intent)) {
                    intent.putExtra("key_start_foreground_service", true);
                    context.startForegroundService(intent);
                } else {
                    context.startService(intent);
                }
            } catch (Exception e) {
                LogUtils.e("startService failed", e);
            }
        }
    }

    public static boolean isStartByForeground(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("key_start_foreground_service", false);
    }

    private static boolean isAppRunInBackground(Context context, Intent intent) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return true;
        }
        String packageName = TextUtils.isEmpty(intent.getPackage()) ? context.getPackageName() : intent.getPackage();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (TextUtils.equals(next.processName, packageName) && next.importance == 100) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInWhiteList(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(context.getPackageName())) {
            return false;
        }
        return true;
    }

    private static boolean needStartInForeground(Context context, Intent intent) {
        return Build.VERSION.SDK_INT >= 26 && isAppRunInBackground(context, intent);
    }
}
