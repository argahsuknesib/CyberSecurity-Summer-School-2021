package com.xiaomi.accountsdk.request;

import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.accountsdk.account.PassportCAConstants;
import com.xiaomi.accountsdk.request.IPInfos;
import com.xiaomi.accountsdk.request.PassportSimpleRequest;
import com.xiaomi.accountsdk.request.RequestWithIP;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IPStrategy {
    private static IPInfos sBackupIpInfos = new IPInfos();
    private static IPInfos sCachedIpInfos = new IPInfos();
    private static Map<String, List<String>> sHardCodedBackupIpLists = new HashMap();
    private static IPUtilExternal sIpUtilExternal;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("183.84.5.8");
        arrayList.add("111.13.142.141");
        sHardCodedBackupIpLists.put("c.id.mi.com", arrayList);
    }

    public static void setIpUtilExternal(IPUtilExternal iPUtilExternal) {
        sIpUtilExternal = iPUtilExternal;
    }

    /* access modifiers changed from: package-private */
    public String getCachedIp(String str) {
        IPUtilExternal iPUtilExternal;
        String networkName = getNetworkName();
        IPInfos.Index index = new IPInfos.Index(str, networkName);
        String ip0 = sCachedIpInfos.getIp0(index);
        if (!(ip0 != null || (iPUtilExternal = sIpUtilExternal) == null || (ip0 = iPUtilExternal.loadCachedIp(str, networkName, null)) == null)) {
            sCachedIpInfos.setIpAsList(index, ip0);
        }
        return ip0;
    }

    /* access modifiers changed from: package-private */
    public List<String> getBackupIpList(String str) {
        IPUtilExternal iPUtilExternal;
        String networkName = getNetworkName();
        IPInfos.Index index = new IPInfos.Index(str, networkName);
        List<String> ipList = sBackupIpInfos.getIpList(index);
        if (!(ipList != null || (iPUtilExternal = sIpUtilExternal) == null || (ipList = iPUtilExternal.loadBackupIpList(str, networkName, null)) == null)) {
            sBackupIpInfos.setIpList(index, ipList);
        }
        return ipList == null ? sHardCodedBackupIpLists.get(str) : ipList;
    }

    /* access modifiers changed from: package-private */
    public String getDnsIp0(String str, String str2) {
        try {
            InetAddress[] resolveDNS = resolveDNS(str);
            if (resolveDNS == null) {
                return null;
            }
            if (resolveDNS.length == 1 && resolveDNS[0] != null) {
                return resolveDNS[0].getHostAddress();
            }
            for (InetAddress inetAddress : resolveDNS) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.equals(hostAddress, str2)) {
                        return hostAddress;
                    }
                }
            }
            return null;
        } catch (UnknownHostException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public InetAddress[] resolveDNS(String str) throws UnknownHostException {
        return Inet4Address.getAllByName(str);
    }

    /* access modifiers changed from: package-private */
    public void updateCachedIpIfNeeded(String str, String str2, long j) {
        if (isCachedIpExpired(str)) {
            final CachedIpStatHelper cachedIpStatHelper = new CachedIpStatHelper();
            cachedIpStatHelper.putIpPingResult(str2, true, j);
            cachedIpStatHelper.setCachedIp(str2);
            if (j <= IPStrategyConfig.getPingThreshold()) {
                cachedIpStatHelper.onLessThenPingThreshold(j, IPStrategyConfig.getPingThreshold());
                updateCachedTimeStamp(str);
                return;
            }
            final String dnsIp0 = getDnsIp0(str, str2);
            final String backupIp0 = getBackupIp0(str);
            cachedIpStatHelper.setDnsIp0(dnsIp0);
            cachedIpStatHelper.setBackupip0(backupIp0);
            final String networkName = getNetworkName();
            final String str3 = str;
            final long j2 = j;
            IPExecutorService.execute(new Runnable() {
                /* class com.xiaomi.accountsdk.request.IPStrategy.AnonymousClass1 */

                public void run() {
                    Pair<String, Long> ping = IPStrategy.this.ping(str3, new String[]{dnsIp0, backupIp0}, cachedIpStatHelper);
                    String networkName = IPStrategy.this.getNetworkName();
                    if (!TextUtils.equals(networkName, networkName)) {
                        cachedIpStatHelper.onNetworkChanged(networkName, networkName);
                        AccountLog.w("IPStrategy", String.format("ping: network changed from %s to %s, will NOT update anything", networkName, networkName));
                    } else if (ping == null) {
                        IPStrategy.this.updateCachedTimeStamp(str3);
                    } else {
                        cachedIpStatHelper.onAllIpPingFinishes(IPStrategyConfig.getPingTimeCoefficient());
                        String str = (String) ping.first;
                        if (((Long) ping.second).longValue() * IPStrategyConfig.getPingTimeCoefficient() < j2) {
                            IPStrategy.this.updateCachedIpAndTimeStamp(str3, str);
                        } else {
                            IPStrategy.this.updateCachedTimeStamp(str3);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void updateBackupIpListIfNeeded(final String str) {
        if (isBackupListExpired(str)) {
            final String networkName = getNetworkName();
            IPExecutorService.execute(new Runnable() {
                /* class com.xiaomi.accountsdk.request.IPStrategy.AnonymousClass2 */

                public void run() {
                    String networkName = IPStrategy.this.getNetworkName();
                    if (!TextUtils.equals(networkName, networkName)) {
                        AccountLog.w("IPStrategy", String.format("backupList: network changed from %s to %s, will NOT update anything", networkName, networkName));
                        new BackupIpStatHelper().onNetworkChangedBeforePullingBackupIps();
                        return;
                    }
                    List<String> backupIpListOnline = IPStrategy.this.getBackupIpListOnline(str);
                    new BackupIpStatHelper().onPullingBackupIpsSucceeded(backupIpListOnline);
                    IPStrategy.this.updateBackupIpList(str, networkName, backupIpListOnline);
                }
            });
            IPExecutorService.execute(new Runnable() {
                /* class com.xiaomi.accountsdk.request.IPStrategy.AnonymousClass3 */

                public void run() {
                    String networkName = IPStrategy.this.getNetworkName();
                    if (!TextUtils.equals(networkName, networkName)) {
                        AccountLog.w("IPStrategy", String.format("config, network changed from %s to %s, will NOT update anything", networkName, networkName));
                        return;
                    }
                    IPStrategy.this.updateStrategyConfigOnline();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void updateCachedIpAndTimeStamp(String str, String str2) {
        updateCachedIp(str, getNetworkName(), str2);
        updateCachedTimeStamp(str);
    }

    /* access modifiers changed from: package-private */
    public void updateBackupIpListAndTimeStamp(String str, List<String> list) {
        updateBackupIpList(str, getNetworkName(), list);
        updateBackupTimeStamp(str);
    }

    /* access modifiers changed from: protected */
    public List<String> getBackupIpListOnline(String str) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        Boolean isWifi = isWifi();
        if (isWifi == null) {
            return null;
        }
        PassportRequestArguments passportRequestArguments = new PassportRequestArguments();
        passportRequestArguments.setUrl(String.format("http://resolver.msg.xiaomi.net/gslb/?ver=3.0&list=%s", str));
        try {
            JSONObject jSONObject2 = new JSONObject(new PassportSimpleRequest.GetAsString(passportRequestArguments).execute().getBody()).getJSONObject("R");
            if (isWifi.booleanValue()) {
                jSONObject = jSONObject2.getJSONObject("wifi");
            } else {
                jSONObject = jSONObject2.getJSONObject("wap");
            }
            if (jSONObject == null || (jSONArray = jSONObject.getJSONArray(str)) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj != null) {
                    arrayList.add(obj.toString());
                }
            }
            return arrayList;
        } catch (IOException e) {
            AccountLog.w("IPStrategy", "getBackupIpListOnline", e);
            return null;
        } catch (PassportRequestException e2) {
            AccountLog.w("IPStrategy", "getBackupIpListOnline error, cause : ", e2.getCause());
            return null;
        } catch (JSONException e3) {
            AccountLog.w("IPStrategy", "getBackupIpListOnline error, cause : ", e3.getCause());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Boolean isWifi() {
        IPUtilExternal iPUtilExternal = sIpUtilExternal;
        if (iPUtilExternal == null) {
            return null;
        }
        return Boolean.valueOf(iPUtilExternal.isWifi());
    }

    /* access modifiers changed from: protected */
    public void updateStrategyConfigOnline() {
        long cachedIpExpireDurationMs = IPStrategyConfig.getCachedIpExpireDurationMs();
        long backupIpListExpireDurationMs = IPStrategyConfig.getBackupIpListExpireDurationMs();
        long pingThreshold = IPStrategyConfig.getPingThreshold();
        long pingTimeCoefficient = IPStrategyConfig.getPingTimeCoefficient();
        PassportRequestArguments passportRequestArguments = new PassportRequestArguments();
        passportRequestArguments.setUrl("http://c.id.mi.com/conn/getParams");
        try {
            String body = new PassportSimpleRequest.GetAsString(passportRequestArguments).execute().getBody();
            if (!TextUtils.isEmpty(body)) {
                if (body.startsWith("&&&START&&&")) {
                    body = body.substring(11);
                }
                JSONObject jSONObject = new JSONObject(body).getJSONObject("connectivity_params");
                int optInt = jSONObject.optInt("backup_ip_expire", -1);
                if (optInt != -1) {
                    backupIpListExpireDurationMs = (long) (optInt * 1000);
                }
                int optInt2 = jSONObject.optInt("cached_ip_expire", -1);
                if (optInt2 != -1) {
                    cachedIpExpireDurationMs = (long) (optInt2 * 1000);
                }
                int optInt3 = jSONObject.optInt("ping_threshold", -1);
                if (optInt3 != -1) {
                    pingThreshold = (long) optInt3;
                }
                int optInt4 = jSONObject.optInt("ping_time_coefficient", -1);
                if (optInt4 != -1) {
                    pingTimeCoefficient = (long) optInt4;
                }
                IPStrategyConfig.setCachedIpExpireDurationMs(cachedIpExpireDurationMs);
                IPStrategyConfig.setBackupIpListExpireDurationMs(backupIpListExpireDurationMs);
                IPStrategyConfig.setPingThreshold(pingThreshold);
                IPStrategyConfig.setPingTimeCoefficient(pingTimeCoefficient);
                IPUtilExternal iPUtilExternal = sIpUtilExternal;
                if (iPUtilExternal != null) {
                    iPUtilExternal.saveCachedIpExpireDuration(cachedIpExpireDurationMs);
                    sIpUtilExternal.saveBackupIpListExpireDuration(backupIpListExpireDurationMs);
                    sIpUtilExternal.savePingThreshold(pingThreshold);
                    sIpUtilExternal.savePingTimeCoefficient(pingTimeCoefficient);
                }
            }
        } catch (IOException e) {
            AccountLog.w("IPStrategy", "updateStrategyConfigOnline", e);
        } catch (PassportRequestException e2) {
            AccountLog.w("IPStrategy", "updateStrategyConfigOnline", e2.getCause());
        } catch (JSONException e3) {
            AccountLog.w("IPStrategy", "updateStrategyConfigOnline", e3);
        }
    }

    /* access modifiers changed from: protected */
    public void updateCachedTimeStamp(String str) {
        String networkName = getNetworkName();
        IPInfos.Index index = new IPInfos.Index(str, networkName);
        long currentTimeMillis = System.currentTimeMillis();
        sCachedIpInfos.setTimeStamp(index, currentTimeMillis);
        IPUtilExternal iPUtilExternal = sIpUtilExternal;
        if (iPUtilExternal != null) {
            iPUtilExternal.saveCachedTimeStamp(str, networkName, currentTimeMillis);
        }
    }

    /* access modifiers changed from: protected */
    public void updateBackupTimeStamp(String str) {
        String networkName = getNetworkName();
        IPInfos.Index index = new IPInfos.Index(str, networkName);
        long currentTimeMillis = System.currentTimeMillis();
        sBackupIpInfos.setTimeStamp(index, currentTimeMillis);
        IPUtilExternal iPUtilExternal = sIpUtilExternal;
        if (iPUtilExternal != null) {
            iPUtilExternal.saveBackupTimeStamp(str, networkName, currentTimeMillis);
        }
    }

    /* access modifiers changed from: protected */
    public Pair<String, Long> ping(String str, String[] strArr, CachedIpStatHelper cachedIpStatHelper) {
        long j = Long.MAX_VALUE;
        String str2 = null;
        for (String str3 : strArr) {
            try {
                RequestWithIP.IpRequestResult ipRequestResult = new RequestWithIP.IpRequestResult();
                PassportRequestArguments passportRequestArguments = new PassportRequestArguments();
                passportRequestArguments.setUrl(String.format("http://%s/conn/echo", str));
                boolean executeWithIp = RequestWithIP.executeWithIp(new PassportSimpleRequest.GetAsString(passportRequestArguments), str, str3, ipRequestResult);
                cachedIpStatHelper.putIpPingResult(str3, executeWithIp, ipRequestResult.timeSpent);
                if (executeWithIp && ipRequestResult.timeSpent < j) {
                    try {
                        j = ipRequestResult.timeSpent;
                        str2 = str3;
                    } catch (PassportRequestException unused) {
                        str2 = str3;
                        cachedIpStatHelper.putIpPingException(str3);
                    }
                }
            } catch (PassportRequestException unused2) {
                cachedIpStatHelper.putIpPingException(str3);
            }
        }
        if (str2 == null) {
            return null;
        }
        return Pair.create(str2, Long.valueOf(j));
    }

    /* access modifiers changed from: protected */
    public String getBackupIp0(String str) {
        List<String> backupIpList = getBackupIpList(str);
        if (backupIpList == null || backupIpList.size() <= 0) {
            return null;
        }
        return backupIpList.get(0);
    }

    /* access modifiers changed from: protected */
    public String getNetworkName() {
        IPUtilExternal iPUtilExternal = sIpUtilExternal;
        if (iPUtilExternal == null) {
            return null;
        }
        return iPUtilExternal.getNetworkName();
    }

    /* access modifiers changed from: protected */
    public void updateCachedIp(String str, String str2, String str3) {
        sCachedIpInfos.setIpAsList(new IPInfos.Index(str, str2), str3);
        IPUtilExternal iPUtilExternal = sIpUtilExternal;
        if (iPUtilExternal != null) {
            iPUtilExternal.saveCachedIp(str, str2, str3);
        }
    }

    /* access modifiers changed from: protected */
    public void updateBackupIpList(String str, String str2, List<String> list) {
        sBackupIpInfos.setIpList(new IPInfos.Index(str, str2), list);
        IPUtilExternal iPUtilExternal = sIpUtilExternal;
        if (iPUtilExternal != null) {
            iPUtilExternal.saveBackupIpList(str, str2, list);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isExpired(IPInfos iPInfos, String str, long j) {
        Long timeStamp = iPInfos.getTimeStamp(new IPInfos.Index(str, getNetworkName()));
        if (timeStamp == null) {
            return true;
        }
        return isExpiredSinceLastTime(timeStamp.longValue(), j);
    }

    /* access modifiers changed from: package-private */
    public boolean isExpiredSinceLastTime(long j, long j2) {
        return Math.abs(System.currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: protected */
    public boolean isCachedIpExpired(String str) {
        return isExpired(sCachedIpInfos, str, IPStrategyConfig.getCachedIpExpireDurationMs());
    }

    /* access modifiers changed from: protected */
    public boolean isBackupListExpired(String str) {
        return isExpired(sBackupIpInfos, str, IPStrategyConfig.getBackupIpListExpireDurationMs());
    }

    static void resetIpInfosForTest() {
        sBackupIpInfos = new IPInfos();
        sCachedIpInfos = new IPInfos();
    }

    static class BackupIpStatHelper extends IPStatHelper {
        BackupIpStatHelper() {
        }

        public void onNetworkChangedBeforePullingBackupIps() {
            statCountEvent("backupIpDiagnosis", "PullingBackupIpChanged");
        }

        public void onPullingBackupIpsSucceeded(List<String> list) {
            statDummyUrl(String.format("http://dummyurl/backupIpDiagonose?_ver=%s&_ips=%s&_nets=%s", PassportCAConstants.IMPL_VERSION, list == null ? null : TextUtils.join(",", list), getNetworkName()));
        }
    }

    static class CachedIpStatHelper extends IPStatHelper {
        private String backupip0 = null;
        private String cachedIp = null;
        private String dnsIp0 = null;
        private final HashMap<String, Long> pingTimeMap = new HashMap<>();

        CachedIpStatHelper() {
        }

        public void setCachedIp(String str) {
            this.cachedIp = str;
        }

        public void setDnsIp0(String str) {
            this.dnsIp0 = str;
        }

        public void setBackupip0(String str) {
            this.backupip0 = str;
        }

        public void putIpPingResult(String str, boolean z, long j) {
            HashMap<String, Long> hashMap = this.pingTimeMap;
            if (!z) {
                j = -1;
            }
            hashMap.put(str, Long.valueOf(j));
        }

        public void putIpPingException(String str) {
            this.pingTimeMap.put(str, -2L);
        }

        public void onLessThenPingThreshold(long j, long j2) {
            statDummyUrl(String.format("http://dummyurl/cachedipDiagonis?_ver=%s&_time=%d&_thres=%d", PassportCAConstants.IMPL_VERSION, Long.valueOf(j), Long.valueOf(j2)));
        }

        public void onNetworkChanged(String str, String str2) {
            statDummyUrl(String.format("http://dummyurl/cachedipDiagonis?_ver=%s&_netOld=%s&_netNew=%s", PassportCAConstants.IMPL_VERSION, str, str2));
        }

        public void onAllIpPingFinishes(long j) {
            String str = this.cachedIp;
            String str2 = this.dnsIp0;
            String str3 = this.backupip0;
            statDummyUrl(String.format("http://dummyurl/cachedipDiagonis?_ver=%s&_coef=%d&cachedip=%s&cachediptime=%d&dnsip=%s&dnsiptime=%d&backupip0=%s&backupip0time=%d", PassportCAConstants.IMPL_VERSION, Long.valueOf(j), str, this.pingTimeMap.get(str), str2, this.pingTimeMap.get(str2), str3, this.pingTimeMap.get(str3)));
        }
    }
}
