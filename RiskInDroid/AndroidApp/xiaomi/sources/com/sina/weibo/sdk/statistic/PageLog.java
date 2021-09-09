package com.sina.weibo.sdk.statistic;

import android.content.Context;

class PageLog {
    private static String O00000o = "session";
    private static long O00000oO = 1000;

    /* renamed from: O000000o  reason: collision with root package name */
    protected long f5611O000000o;
    private long O00000Oo;
    private long O00000o0;

    public PageLog(Context context) {
        this.f5611O000000o = O000000o(context, "starttime");
        this.O00000Oo = O000000o(context, "endtime");
        this.O00000o0 = this.O00000Oo - this.f5611O000000o;
    }

    public PageLog() {
    }

    private static long O000000o(Context context, String str) {
        return context.getSharedPreferences(O00000o, 0).getLong(str, 0);
    }
}
