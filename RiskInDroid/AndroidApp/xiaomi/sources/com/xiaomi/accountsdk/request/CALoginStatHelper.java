package com.xiaomi.accountsdk.request;

import android.os.SystemClock;
import com.xiaomi.accountsdk.account.PassportCAConstants;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import java.util.LinkedHashMap;
import java.util.Map;

class CALoginStatHelper extends RequestWithIPStatHelper {
    final Map<Integer, Info> backupIpInfos = new LinkedHashMap();
    final Info cachedIpInfo = new Info();
    final Info dnsIpInfo = new Info();
    final Info dnsResolvingInfo = new Info();
    final Info hostNameInfo = new Info();
    final Info overallInfo = new Info();

    CALoginStatHelper() {
    }

    static class Info {
        Long finishTime = null;
        String ip = null;
        Boolean result = null;
        Long startTime = null;

        Info() {
        }

        /* access modifiers changed from: package-private */
        public String timeSpent(Long l) {
            if (l == null) {
                l = 0L;
            }
            Long l2 = this.startTime;
            if (l2 == null || this.finishTime == null) {
                Long l3 = this.startTime;
                if (l3 != null) {
                    return String.format("%d_", Long.valueOf(l3.longValue() - l.longValue()));
                }
                Long l4 = this.finishTime;
                if (l4 == null) {
                    return null;
                }
                return String.format("_%d", Long.valueOf(l4.longValue() - l.longValue()));
            }
            return String.format("%d_%d", Long.valueOf(l2.longValue() - l.longValue()), Long.valueOf(this.finishTime.longValue() - l.longValue()));
        }

        /* access modifiers changed from: package-private */
        public String resultString() {
            Boolean bool = this.result;
            if (bool == null) {
                return null;
            }
            return bool.booleanValue() ? "1" : "0";
        }

        /* access modifiers changed from: package-private */
        public void start(String str) {
            this.ip = str;
            this.startTime = Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* access modifiers changed from: package-private */
        public void finish(boolean z) {
            this.result = Boolean.valueOf(z);
            this.finishTime = Long.valueOf(SystemClock.elapsedRealtime());
        }
    }

    public void onCachedIpStarted(String str) {
        this.cachedIpInfo.start(str);
    }

    public void onCachedIpSucceed() {
        this.cachedIpInfo.finish(true);
    }

    public void onCachedIpFailed() {
        this.cachedIpInfo.finish(false);
    }

    public void onDnsip0Started(String str) {
        this.dnsIpInfo.start(str);
    }

    public void onDnsIp0Succeed() {
        this.dnsIpInfo.finish(true);
    }

    public void onDnsIp0Failed() {
        this.dnsIpInfo.finish(false);
    }

    public void onBackupIpStarted(int i, String str) {
        backupIpInfo(i).start(str);
    }

    public void onBackupIpSucceeded(int i) {
        backupIpInfo(i).finish(true);
    }

    public void onBackupIpFailed(int i) {
        backupIpInfo(i).finish(false);
    }

    public void onHostNameRequestStarted() {
        this.hostNameInfo.start(null);
    }

    public void onHostNameRequestFinished(boolean z) {
        this.hostNameInfo.finish(z);
    }

    public void onDnsResolvingStarted() {
        this.dnsResolvingInfo.start(null);
    }

    public void onDnsResolvingFinished(String str) {
        this.dnsResolvingInfo.finish(str != null);
    }

    public void start() {
        this.overallInfo.start(null);
    }

    public void finish() {
        this.overallInfo.finish(computeOverallResult());
        statDummyUrl(buildDummyUrl());
    }

    /* access modifiers changed from: package-private */
    public final boolean computeOverallResult() {
        boolean z = (this.cachedIpInfo.result != null && this.cachedIpInfo.result.booleanValue()) | false | (this.dnsIpInfo.result != null && this.dnsIpInfo.result.booleanValue()) | (this.hostNameInfo.result != null && this.hostNameInfo.result.booleanValue());
        for (Info next : this.backupIpInfos.values()) {
            z |= next.result != null && next.result.booleanValue();
        }
        return z;
    }

    private final Info backupIpInfo(int i) {
        Info info = this.backupIpInfos.get(Integer.valueOf(i));
        if (info != null) {
            return info;
        }
        Info info2 = new Info();
        this.backupIpInfos.put(Integer.valueOf(i), info2);
        return info2;
    }

    /* access modifiers changed from: package-private */
    public final String buildDummyUrl() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("c_ip", this.cachedIpInfo.ip);
        linkedHashMap.put("c_t", this.cachedIpInfo.timeSpent(this.overallInfo.startTime));
        linkedHashMap.put("c_r", this.cachedIpInfo.resultString());
        linkedHashMap.put("r_t", this.dnsResolvingInfo.timeSpent(this.overallInfo.startTime));
        linkedHashMap.put("d_ip", this.dnsIpInfo.ip);
        linkedHashMap.put("d_t", this.dnsIpInfo.timeSpent(this.overallInfo.startTime));
        linkedHashMap.put("d_r", this.dnsIpInfo.resultString());
        for (Integer next : this.backupIpInfos.keySet()) {
            Info info = this.backupIpInfos.get(next);
            if (info != null) {
                String str = "b" + next + "_";
                linkedHashMap.put(str + "ip", info.ip);
                linkedHashMap.put(str + "t", info.timeSpent(this.overallInfo.startTime));
                linkedHashMap.put(str + "r", info.resultString());
            } else {
                throw new NullPointerException("should no be null here");
            }
        }
        linkedHashMap.put("h_t", this.hostNameInfo.timeSpent(this.overallInfo.startTime));
        linkedHashMap.put("h_r", this.hostNameInfo.resultString());
        Info info2 = this.overallInfo;
        linkedHashMap.put("all_t", info2.timeSpent(info2.startTime));
        linkedHashMap.put("all_r", this.overallInfo.resultString());
        linkedHashMap.put("hdid", new HashedDeviceIdUtil(XMPassportSettings.getApplicationContext()).getHashedDeviceIdNoThrow());
        StringBuffer stringBuffer = new StringBuffer("http://dummyurl/caLoginDiagnosis?");
        stringBuffer.append("_ver=");
        stringBuffer.append(PassportCAConstants.IMPL_VERSION);
        for (String str2 : linkedHashMap.keySet()) {
            String str3 = (String) linkedHashMap.get(str2);
            if (!(str2 == null || str3 == null)) {
                stringBuffer.append("&");
                stringBuffer.append(str2);
                stringBuffer.append('=');
                stringBuffer.append(str3);
            }
        }
        return stringBuffer.toString();
    }
}
