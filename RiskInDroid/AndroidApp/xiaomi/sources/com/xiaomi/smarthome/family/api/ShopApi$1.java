package com.xiaomi.smarthome.family.api;

import _m_j.fcn;
import _m_j.fcy;
import _m_j.frv;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.entity.account.RefreshServiceTokenResult;
import com.xiaomi.smarthome.core.server.IServerCallback;

public class ShopApi$1 extends IServerCallback.Stub {
    final /* synthetic */ frv this$0;

    ShopApi$1(frv frv) {
        this.this$0 = frv;
    }

    public void onSuccess(Bundle bundle) throws RemoteException {
        synchronized (this.this$0.f17036O000000o) {
            this.this$0.O00000Oo = false;
        }
        bundle.setClassLoader(RefreshServiceTokenResult.class.getClassLoader());
        RefreshServiceTokenResult refreshServiceTokenResult = (RefreshServiceTokenResult) bundle.getParcelable("result");
        fcn.O000000o().O000000o("xiaomiio", refreshServiceTokenResult.O00000o, refreshServiceTokenResult.O00000Oo, refreshServiceTokenResult.O00000oO, ".io.mi.com", refreshServiceTokenResult.O00000oo);
        fcn.O000000o().O0000Oo();
        this.this$0.O00000Oo();
    }

    public void onFailure(Bundle bundle) throws RemoteException {
        synchronized (this.this$0.f17036O000000o) {
            this.this$0.O00000Oo = false;
        }
        frv frv = this.this$0;
        fcn.O000000o().O0000O0o();
        frv.O00000Oo();
        for (IClientApi onUnAuthorized : fcy.O000000o().O00000o0()) {
            try {
                onUnAuthorized.onUnAuthorized();
            } catch (Exception unused) {
            }
        }
    }
}
