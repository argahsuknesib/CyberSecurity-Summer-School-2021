package com.mobikwik.sdk.ui.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.ui.util.d;

class e extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.b f5342a;

    e(d.b bVar) {
        this.f5342a = bVar;
    }

    public void onReceive(Context context, Intent intent) {
        System.currentTimeMillis();
        long unused = this.f5342a.h;
        this.f5342a.f();
        this.f5342a.b();
        String stringExtra = intent.getStringExtra("otpValue");
        Utils.print("BroadcastReceiver onReceive ".concat(String.valueOf(stringExtra)));
        if (this.f5342a.f != null) {
            this.f5342a.f.a(stringExtra);
        }
    }
}
