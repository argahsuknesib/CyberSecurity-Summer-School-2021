package com.alipay.android.app.helper;

public class Tid extends com.alipay.sdk.tid.Tid {
    public Tid(String str, String str2, long j) {
        super(str, str2, j);
    }

    static Tid fromRealTidModel(com.alipay.sdk.tid.Tid tid) {
        if (tid == null) {
            return null;
        }
        return new Tid(tid.getTid(), tid.getTidSeed(), tid.getTimestamp());
    }
}
