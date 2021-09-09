package com.xiaomi.push.service.receivers;

import android.content.Context;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6575a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f348a;

    a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f348a = networkStatusReceiver;
        this.f6575a = context;
    }

    public void run() {
        this.f348a.a(this.f6575a);
    }
}
