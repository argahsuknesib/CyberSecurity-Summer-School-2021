package com.xiaomi.onetrack.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f6171a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e(d dVar, Looper looper) {
        super(looper);
        this.f6171a = dVar;
    }

    public void handleMessage(Message message) {
        if (message.what == 100) {
            this.f6171a.b(message.getData().getString("hint"));
        }
    }
}
