package com.xiaomi.smarthome.core.server.internal.account;

import _m_j.fdh;
import _m_j.fdj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.IServerCallback;

public class AccountApiImpl$1 extends IServerCallback.Stub {
    final /* synthetic */ fdj this$0;
    final /* synthetic */ fdh val$callback;

    public AccountApiImpl$1(fdj fdj, fdh fdh) {
        this.this$0 = fdj;
        this.val$callback = fdh;
    }

    public void onSuccess(Bundle bundle) throws RemoteException {
        fdh fdh = this.val$callback;
        if (fdh != null) {
            fdh.onSuccess(bundle);
        }
    }

    public void onFailure(Bundle bundle) throws RemoteException {
        fdh fdh = this.val$callback;
        if (fdh != null) {
            fdh.onFailure(null);
        }
    }
}
