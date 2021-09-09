package com.xiaomi.push.service.receivers;

import _m_j.duv;
import _m_j.epp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bd;

public class PingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        duv.O00000o0(intent.getPackage() + " is the package name");
        if (!XMPushService.m114e()) {
            if (!bd.o.equals(intent.getAction())) {
                duv.O000000o("cancel the old ping timer");
                epp.O000000o();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                duv.O00000o0("Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                } catch (Exception e) {
                    duv.O000000o(e);
                }
            }
        }
    }
}
