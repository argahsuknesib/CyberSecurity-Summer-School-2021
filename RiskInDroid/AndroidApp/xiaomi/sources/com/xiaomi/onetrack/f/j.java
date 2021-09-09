package com.xiaomi.onetrack.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.onetrack.h.q;

final class j extends BroadcastReceiver {
    j() {
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_OFF") || action.equals("android.intent.action.SCREEN_ON")) {
            q.a("OneTrackApp", action.equals("android.intent.action.SCREEN_ON") ? "屏幕亮" : "屏幕灭");
        }
    }
}
