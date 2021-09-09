package com.mi.global.shop.xmsf.account;

import _m_j.ccr;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.CountDownLatch;

public class SmsBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    private volatile CountDownLatch f5058O000000o;
    private volatile int O00000Oo;

    public void onReceive(Context context, Intent intent) {
        this.O00000Oo = getResultCode();
        ccr.O00000Oo("SmsBroadcastReceiver", "sms sent, result:" + this.O00000Oo);
        this.f5058O000000o.countDown();
    }
}
