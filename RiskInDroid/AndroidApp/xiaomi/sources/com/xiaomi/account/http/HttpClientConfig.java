package com.xiaomi.account.http;

import android.net.Network;

public class HttpClientConfig {
    private static volatile long defaultConnectTimeoutMs = 10000;
    private static volatile long defaultWaitCellularTimeoutMs = 5000;
    public final long connectTimeoutMs;
    public final int netWorkSlotId;
    public final Network network;
    public final long readTimeoutMs;
    public final long waitCellularTimeoutMs;
    public final long writeTimeoutMs;

    private HttpClientConfig(Builder builder) {
        this.network = builder.network;
        this.netWorkSlotId = builder.netWorkSlotId;
        this.connectTimeoutMs = defaultConnectTimeoutMs;
        this.waitCellularTimeoutMs = defaultWaitCellularTimeoutMs;
        this.readTimeoutMs = 15000;
        this.writeTimeoutMs = 15000;
    }

    public static void setDefaultConnectTimeoutMs(long j) {
        defaultConnectTimeoutMs = j;
    }

    public static void setDefaultWaitCellularTimeoutMs(long j) {
        defaultWaitCellularTimeoutMs = j;
    }

    public static class Builder {
        int netWorkSlotId = -1;
        Network network;

        public Builder network(Network network2) {
            this.network = network2;
            return this;
        }

        public Builder useDataNetWork(int i) {
            this.netWorkSlotId = i;
            return this;
        }

        public HttpClientConfig build() {
            return new HttpClientConfig(this);
        }
    }
}
