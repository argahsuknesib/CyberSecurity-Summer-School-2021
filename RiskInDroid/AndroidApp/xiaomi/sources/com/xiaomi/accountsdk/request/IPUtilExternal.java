package com.xiaomi.accountsdk.request;

import java.util.List;

public interface IPUtilExternal {
    String getNetworkName();

    boolean isWifi();

    List<String> loadBackupIpList(String str, String str2, List<String> list);

    long loadBackupIpListExpireDuration(long j);

    long loadBackupTimeStamp(String str, String str2, long j);

    String loadCachedIp(String str, String str2, String str3);

    long loadCachedIpExpireDuration(long j);

    long loadCachedTimeStamp(String str, String str2, long j);

    long loadPingThreshold(long j);

    long loadPingTimeCoefficient(long j);

    void saveBackupIpList(String str, String str2, List<String> list);

    void saveBackupIpListExpireDuration(long j);

    void saveBackupTimeStamp(String str, String str2, long j);

    void saveCachedIp(String str, String str2, String str3);

    void saveCachedIpExpireDuration(long j);

    void saveCachedTimeStamp(String str, String str2, long j);

    void savePingThreshold(long j);

    void savePingTimeCoefficient(long j);
}
