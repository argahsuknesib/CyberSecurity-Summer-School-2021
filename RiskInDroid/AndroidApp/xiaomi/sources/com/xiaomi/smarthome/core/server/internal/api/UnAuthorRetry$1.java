package com.xiaomi.smarthome.core.server.internal.api;

import _m_j.fdk;
import _m_j.fdt;
import _m_j.fdu;
import _m_j.fsr;
import _m_j.gsy;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.account.RefreshServiceTokenResult;
import com.xiaomi.smarthome.core.server.IServerCallback;
import com.xiaomi.smarthome.library.log.LogType;

public class UnAuthorRetry$1 extends IServerCallback.Stub {
    final /* synthetic */ fdu this$0;
    final /* synthetic */ fdk val$account;
    final /* synthetic */ String val$content;
    final /* synthetic */ String val$passToken;
    final /* synthetic */ String val$url;
    final /* synthetic */ String val$userId;

    public UnAuthorRetry$1(fdu fdu, fdk fdk, String str, String str2, String str3, String str4) {
        this.this$0 = fdu;
        this.val$account = fdk;
        this.val$passToken = str;
        this.val$url = str2;
        this.val$content = str3;
        this.val$userId = str4;
    }

    public void onSuccess(Bundle bundle) throws RemoteException {
        CommonApplication.getGlobalWorkerHandler().post(new Runnable(bundle, this.val$account) {
            /* class com.xiaomi.smarthome.core.server.internal.api.$$Lambda$UnAuthorRetry$1$FlFdph56gBnJrz0pqhsSslgjQo8 */
            private final /* synthetic */ Bundle f$1;
            private final /* synthetic */ fdk f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                UnAuthorRetry$1.this.lambda$onSuccess$0$UnAuthorRetry$1(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onSuccess$0$UnAuthorRetry$1(Bundle bundle, fdk fdk) {
        gsy.O00000o0(LogType.NETWORK, "UnAuthorRetry", "refreshServiceToken onSuccess");
        if (fsr.O0000O0o || fsr.O0000Oo0) {
            gsy.O000000o(6, "MIIO", "refreshServiceToken onSuccess");
        }
        bundle.setClassLoader(RefreshServiceTokenResult.class.getClassLoader());
        RefreshServiceTokenResult refreshServiceTokenResult = (RefreshServiceTokenResult) bundle.getParcelable("result");
        this.this$0.O00000o0.writeLock().lock();
        try {
            fdk.O000000o(this.this$0.f16135O000000o.f12086O000000o, refreshServiceTokenResult.O00000o, refreshServiceTokenResult.O00000Oo, refreshServiceTokenResult.O00000oO, this.this$0.f16135O000000o.O00000oo, refreshServiceTokenResult.O00000oo);
            fdk.O0000O0o();
            fdt.O000000o().O000000o(false);
            this.this$0.O000000o((Error) null);
        } finally {
            this.this$0.O00000o0.writeLock().unlock();
        }
    }

    public void onFailure(Bundle bundle) throws RemoteException {
        LogType logType = LogType.NETWORK;
        gsy.O00000o0(logType, "UnAuthorRetry", "refreshServiceToken onFailure " + bundle + " passToken " + this.val$passToken);
        if (fsr.O0000O0o || fsr.O0000Oo0) {
            gsy.O000000o(6, "MIIO", "refreshServiceToken onFailure");
        }
        fdu.O000000o(1, this.val$url + ":" + this.val$content, this.val$userId);
        fdu.O000000o(this.val$url, this.val$userId);
        this.this$0.O000000o(new Error(-1, String.valueOf(bundle)));
    }
}
