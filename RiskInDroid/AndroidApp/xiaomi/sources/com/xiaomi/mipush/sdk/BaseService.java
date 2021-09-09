package com.xiaomi.mipush.sdk;

import _m_j.duv;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class BaseService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f6044O000000o;

    public static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<BaseService> f6045O000000o;

        public O000000o(WeakReference<BaseService> weakReference) {
            this.f6045O000000o = weakReference;
        }

        public final void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what == 1001 && (weakReference = this.f6045O000000o) != null && (baseService = weakReference.get()) != null) {
                duv.O00000o0("TimeoutHandler " + baseService.toString() + " kill self");
                if (!baseService.O000000o()) {
                    baseService.stopSelf();
                    return;
                }
                duv.O00000o0("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean O000000o();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f6044O000000o == null) {
            this.f6044O000000o = new O000000o(new WeakReference(this));
        }
        O000000o o000000o = this.f6044O000000o;
        if (o000000o.hasMessages(1001)) {
            o000000o.removeMessages(1001);
        }
        o000000o.sendEmptyMessageDelayed(1001, 1000);
    }
}
