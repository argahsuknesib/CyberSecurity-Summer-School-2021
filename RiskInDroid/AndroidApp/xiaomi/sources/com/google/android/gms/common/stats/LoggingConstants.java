package com.google.android.gms.common.stats;

import android.content.ComponentName;

public final class LoggingConstants {
    public static int IGNORE_INTRA_PROCESS = 16;
    public static int LOG_CLOSE_EVENTS = 4;
    public static int LOG_LEVEL_OFF = 0;
    public static int LOG_MEM_INFO = 32;
    public static int LOG_OPEN_EVENTS = 2;
    public static int LOG_TOO_LONG_EVENTS = 1;
    public static int LOG_VERBOSE = 8;
    public static int LOG_WAKEFUL_ALARMS = 1;
    public static final ComponentName STATS_SERVICE_COMPONENT_NAME = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");

    private LoggingConstants() {
    }
}
