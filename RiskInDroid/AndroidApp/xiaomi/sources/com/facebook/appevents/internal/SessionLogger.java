package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import java.util.Locale;

class SessionLogger {
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final String TAG = "com.facebook.appevents.internal.SessionLogger";

    SessionLogger() {
    }

    public static void logActivateApp(String str, SourceApplicationInfo sourceApplicationInfo, String str2, Context context) {
        String sourceApplicationInfo2 = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
        Bundle bundle = new Bundle();
        bundle.putString("fb_mobile_launch_source", sourceApplicationInfo2);
        bundle.putString("fb_mobile_pckg_fp", computePackageChecksum(context));
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, null);
        internalAppEventsLogger.logEvent("fb_mobile_activate_app", bundle);
        if (InternalAppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            internalAppEventsLogger.flush();
        }
    }

    public static void logDeactivateApp(String str, SessionInfo sessionInfo, String str2) {
        Long valueOf = Long.valueOf(sessionInfo.getDiskRestoreTime() - sessionInfo.getSessionLastEventTime().longValue());
        if (valueOf.longValue() < 0) {
            logClockSkewEvent();
            valueOf = 0L;
        }
        Long valueOf2 = Long.valueOf(sessionInfo.getSessionLength());
        if (valueOf2.longValue() < 0) {
            logClockSkewEvent();
            valueOf2 = 0L;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("fb_mobile_app_interruptions", sessionInfo.getInterruptionCount());
        bundle.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", Integer.valueOf(getQuantaIndex(valueOf.longValue()))));
        SourceApplicationInfo sourceApplicationInfo = sessionInfo.getSourceApplicationInfo();
        bundle.putString("fb_mobile_launch_source", sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified");
        bundle.putLong("_logTime", sessionInfo.getSessionLastEventTime().longValue() / 1000);
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, null);
        double longValue = (double) valueOf2.longValue();
        Double.isNaN(longValue);
        internalAppEventsLogger.logEvent("fb_mobile_deactivate_app", longValue / 1000.0d, bundle);
    }

    private static void logClockSkewEvent() {
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }

    private static int getQuantaIndex(long j) {
        int i = 0;
        while (true) {
            long[] jArr = INACTIVE_SECONDS_QUANTA;
            if (i >= jArr.length || jArr[i] >= j) {
                return i;
            }
            i++;
        }
        return i;
    }

    private static String computePackageChecksum(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String concat = "PCKGCHKSUM;".concat(String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 0).versionName));
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(concat, null);
            if (string != null && string.length() == 32) {
                return string;
            }
            String computeChecksum = HashUtils.computeChecksum(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
            sharedPreferences.edit().putString(concat, computeChecksum).apply();
            return computeChecksum;
        } catch (Exception unused) {
            return null;
        }
    }
}
