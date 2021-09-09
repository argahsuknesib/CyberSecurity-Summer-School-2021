package com.xiaomi.miot.support.monitor.core.net;

import java.io.Serializable;

public class NetRateInfo implements Serializable {
    public int failedCount = 0;
    public int hdc = 0;
    public int sdc = 0;
    public int totalCount = 0;
}
