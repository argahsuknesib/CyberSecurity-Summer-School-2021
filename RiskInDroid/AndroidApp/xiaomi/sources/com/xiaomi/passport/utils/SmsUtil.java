package com.xiaomi.passport.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.util.concurrent.CountDownLatch;

public final class SmsUtil {

    public static class SendSmsReceiver extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        private volatile CountDownLatch f6349O000000o = new CountDownLatch(1);
        private volatile int O00000Oo;

        public void onReceive(Context context, Intent intent) {
            context.unregisterReceiver(this);
            this.O00000Oo = getResultCode();
            AccountLog.i("SmsUtil", "received sms result code :" + this.O00000Oo);
            this.f6349O000000o.countDown();
        }
    }
}
