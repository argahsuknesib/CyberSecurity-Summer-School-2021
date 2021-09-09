package com.xiaomi.miot.support.monitor.dns;

import java.io.Serializable;

public class DnsInfo implements Serializable {
    public String hostName = "";
    public String ip = "";
    public long tcpTime = 0;

    public DnsInfo(String str, String str2, long j) {
        this.hostName = str;
        this.ip = str2;
        this.tcpTime = j;
    }
}
