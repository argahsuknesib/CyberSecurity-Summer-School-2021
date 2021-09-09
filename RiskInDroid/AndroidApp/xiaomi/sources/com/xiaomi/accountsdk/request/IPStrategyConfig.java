package com.xiaomi.accountsdk.request;

public class IPStrategyConfig {
    private static long sBackupIpListExpireDurationMs = 604800000;
    private static long sCachedIpExpireDurationMs = 3600000;
    private static long sPingThreshold = 0;
    private static long sPingTimeCoefficient = 2;

    public static void init(IPUtilExternal iPUtilExternal) {
        if (iPUtilExternal != null) {
            sCachedIpExpireDurationMs = iPUtilExternal.loadCachedIpExpireDuration(sCachedIpExpireDurationMs);
            sBackupIpListExpireDurationMs = iPUtilExternal.loadBackupIpListExpireDuration(sBackupIpListExpireDurationMs);
            sPingThreshold = iPUtilExternal.loadPingThreshold(sPingThreshold);
            sPingTimeCoefficient = iPUtilExternal.loadPingTimeCoefficient(sPingTimeCoefficient);
        }
    }

    static long getCachedIpExpireDurationMs() {
        return sCachedIpExpireDurationMs;
    }

    static long getBackupIpListExpireDurationMs() {
        return sBackupIpListExpireDurationMs;
    }

    static long getPingThreshold() {
        return sPingThreshold;
    }

    static long getPingTimeCoefficient() {
        return sPingTimeCoefficient;
    }

    static void setCachedIpExpireDurationMs(long j) {
        sCachedIpExpireDurationMs = j;
    }

    static void setBackupIpListExpireDurationMs(long j) {
        sBackupIpListExpireDurationMs = j;
    }

    static void setPingThreshold(long j) {
        sPingThreshold = j;
    }

    static void setPingTimeCoefficient(long j) {
        sPingTimeCoefficient = j;
    }
}
