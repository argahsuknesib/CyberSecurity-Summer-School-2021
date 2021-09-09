package com.google.android.gms.common.stats;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.stats.StatisticalEventTrackerProvider;

public class StatsUtils {
    public static String getEventKey(AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str) {
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(abstractThreadedSyncAdapter))));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public static String getEventKey(Context context, Intent intent) {
        return String.valueOf(((long) System.identityHashCode(intent)) | (((long) System.identityHashCode(context)) << 32));
    }

    public static String getEventKey(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public static boolean isLoggingEnabled() {
        StatisticalEventTrackerProvider.StatisticalEventTracker impl = StatisticalEventTrackerProvider.getImpl();
        if (impl == null || !impl.isEnabled()) {
            return false;
        }
        return zza(Integer.valueOf(impl.getLogLevel(3))) || zza(Integer.valueOf(impl.getLogLevel(2))) || zza(Integer.valueOf(impl.getLogLevel(1)));
    }

    public static boolean isTimeOutEvent(StatsEvent statsEvent) {
        int eventType = statsEvent.getEventType();
        return eventType == 6 || eventType == 9 || eventType == 12;
    }

    private static boolean zza(Integer num) {
        return !num.equals(Integer.valueOf(LoggingConstants.LOG_LEVEL_OFF));
    }
}
