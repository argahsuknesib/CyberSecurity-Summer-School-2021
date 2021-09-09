package com.xiaomi.mipush.sdk;

import _m_j.duv;
import _m_j.epj;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.MessageHandleService;

public abstract class PushMessageReceiver extends BroadcastReceiver {
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            duv.O00000oo("[CRcv] receive a msg broadcast: " + intent.getAction());
        }
        MessageHandleService.addJob(context.getApplicationContext(), new MessageHandleService.O000000o(intent, this));
        try {
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (intExtra == 2000) {
                epj.O000000o(context.getApplicationContext()).O000000o(context.getPackageName(), intent, 2003);
            } else if (intExtra == 6000) {
                epj.O000000o(context.getApplicationContext()).O000000o(context.getPackageName(), intent, 6005);
            }
        } catch (Exception e) {
            duv.O00000o("meet error in PushMessageReceiver. ".concat(String.valueOf(e)));
        }
    }

    @Deprecated
    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onRequirePermissions(Context context, String[] strArr) {
    }
}
