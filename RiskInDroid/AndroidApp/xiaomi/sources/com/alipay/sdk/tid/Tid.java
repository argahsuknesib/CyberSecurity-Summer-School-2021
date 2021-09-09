package com.alipay.sdk.tid;

import android.text.TextUtils;

public class Tid {
    protected final String key;
    protected final String tid;
    protected final long time;

    public Tid(String str, String str2, long j) {
        this.tid = str;
        this.key = str2;
        this.time = j;
    }

    public String getTid() {
        return this.tid;
    }

    public String getTidSeed() {
        return this.key;
    }

    public long getTimestamp() {
        return this.time;
    }

    public static boolean isEmpty(Tid tid2) {
        return tid2 == null || TextUtils.isEmpty(tid2.tid);
    }
}
