package com.xiaomi.accountsdk.request;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class IPInfos {
    private Map<Index, List<String>> ipMap = new ConcurrentHashMap();
    private Map<Index, Long> timeStampMap = new ConcurrentHashMap();

    IPInfos() {
    }

    static class Index {
        final String host;
        final String networkName;

        public int hashCode() {
            if (this.host == null && this.networkName == null) {
                return "null#null".hashCode();
            }
            String str = this.host;
            if (str != null && this.networkName != null) {
                return str.hashCode() + this.networkName.hashCode();
            }
            String str2 = this.host;
            if (str2 != null) {
                return str2.hashCode();
            }
            return this.networkName.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Index)) {
                Index index = (Index) obj;
                if (!TextUtils.equals(this.host, index.host) || !TextUtils.equals(this.networkName, index.networkName)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        Index(String str, String str2) {
            this.host = str;
            this.networkName = str2;
        }
    }

    /* access modifiers changed from: package-private */
    public List<String> getIpList(Index index) {
        if (index == null) {
            return null;
        }
        return this.ipMap.get(index);
    }

    /* access modifiers changed from: package-private */
    public void setIpList(Index index, List<String> list) {
        if (index != null) {
            if (list == null) {
                this.ipMap.remove(index);
            } else {
                this.ipMap.put(index, list);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setIpAsList(Index index, String str) {
        if (index != null) {
            if (str == null) {
                this.ipMap.remove(index);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.ipMap.put(index, arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public String getIp0(Index index) {
        List<String> ipList;
        if (index == null || (ipList = getIpList(index)) == null || ipList.size() <= 0) {
            return null;
        }
        return ipList.get(0);
    }

    /* access modifiers changed from: package-private */
    public Long getTimeStamp(Index index) {
        if (index == null) {
            return null;
        }
        return this.timeStampMap.get(index);
    }

    /* access modifiers changed from: package-private */
    public void setTimeStamp(Index index, long j) {
        if (index != null) {
            this.timeStampMap.put(index, Long.valueOf(j));
        }
    }
}
