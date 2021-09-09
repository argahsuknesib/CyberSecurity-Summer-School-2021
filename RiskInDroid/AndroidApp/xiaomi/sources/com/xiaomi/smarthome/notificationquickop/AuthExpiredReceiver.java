package com.xiaomi.smarthome.notificationquickop;

import _m_j.fbs;
import _m_j.fbt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class AuthExpiredReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.equals("com.xiaomi.smarthome.notification.auth_expired", action)) {
            fbt fbt = new fbt(applicationContext, "SmartHomeMainActivity");
            fbt.O00000Oo(268468224);
            fbs.O000000o(fbt);
        }
    }
}
