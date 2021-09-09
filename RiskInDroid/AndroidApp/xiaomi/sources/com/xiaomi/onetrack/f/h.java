package com.xiaomi.onetrack.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.onetrack.h.j;

class h extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f6140a;

    h(f fVar) {
        this.f6140a = fVar;
    }

    public void onReceive(Context context, Intent intent) {
        j.a(new i(this));
    }
}
