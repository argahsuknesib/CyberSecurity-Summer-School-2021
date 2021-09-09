package com.xiaomi.onetrack.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class w extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f6115a;

    w(f fVar) {
        this.f6115a = fVar;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (action.equals("android.intent.action.SCREEN_OFF") || action.equals("android.intent.action.SCREEN_ON")) {
                    this.f6115a.k();
                }
            }
        } catch (Exception unused) {
        }
    }
}
