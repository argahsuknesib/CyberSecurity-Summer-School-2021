package com.google.android.gms.common.stats;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.DeviceStateUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Arrays;
import java.util.List;

public class WakeLockTracker {
    @VisibleForTesting
    private static boolean zzyh = false;
    private static WakeLockTracker zzyz = new WakeLockTracker();
    private static Boolean zzza;

    public static WakeLockTracker getInstance() {
        return zzyz;
    }

    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i, String str4) {
        Context context2 = context;
        Intent intent2 = intent;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        int i2 = i;
        registerAcquireEvent(context2, intent2, str5, str6, str7, i2, Arrays.asList(str4));
    }

    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i, List<String> list) {
        registerEvent(context, intent.getStringExtra("WAKE_LOCK_KEY"), 7, str, str2, str3, i, list);
    }

    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        registerEvent(context, str, i, str2, str3, str4, i2, list, 0);
    }

    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        int i3 = i;
        List<String> list2 = list;
        if (zzza == null) {
            zzza = Boolean.FALSE;
        }
        if (zzza.booleanValue()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i3 || 8 == i3 || 10 == i3 || 11 == i3) {
                if (list2 != null && list.size() == 1 && "com.google.android.gms".equals(list2.get(0))) {
                    list2 = null;
                }
                List<String> list3 = list2;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int deviceState = DeviceStateUtils.getDeviceState(context);
                String packageName = context.getPackageName();
                WakeLockEvent wakeLockEvent = r1;
                String str5 = "WakeLockTracker";
                WakeLockEvent wakeLockEvent2 = new WakeLockEvent(currentTimeMillis, i, str2, i2, list3, str, elapsedRealtime, deviceState, str3, "com.google.android.gms".equals(packageName) ? null : packageName, DeviceStateUtils.getPowerPercentage(context), j, str4);
                try {
                    context.startService(new Intent().setComponent(LoggingConstants.STATS_SERVICE_COMPONENT_NAME).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
                } catch (Exception e) {
                    Log.wtf(str5, e);
                }
            }
        }
    }

    public void registerReleaseEvent(Context context, Intent intent) {
        registerEvent(context, intent.getStringExtra("WAKE_LOCK_KEY"), 8, null, null, null, 0, null);
    }

    public void registerSyncEnd(Context context, AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str, String str2, boolean z) {
        registerEvent(context, StatsUtils.getEventKey(abstractThreadedSyncAdapter, str), 11, str, str2, null, 0, null);
    }

    public void registerSyncStart(Context context, AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str, String str2) {
        registerEvent(context, StatsUtils.getEventKey(abstractThreadedSyncAdapter, str), 10, str, str2, null, 0, null);
    }
}
