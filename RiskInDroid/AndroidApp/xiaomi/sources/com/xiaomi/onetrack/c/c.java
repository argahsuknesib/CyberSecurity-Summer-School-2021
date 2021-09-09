package com.xiaomi.onetrack.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.onetrack.h.q;

final class c extends BroadcastReceiver {
    c() {
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_OFF") || action.equals("android.intent.action.SCREEN_ON")) {
            q.a("EventManager", "screen on/off");
            int i = action.equals("android.intent.action.SCREEN_ON") ? 0 : 2;
            q.a("EventManager", "screenReceiver will post prio=".concat(String.valueOf(i)));
            m.a().a(i, false);
        }
    }
}
