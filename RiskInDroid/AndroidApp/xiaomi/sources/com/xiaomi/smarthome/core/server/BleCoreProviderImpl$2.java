package com.xiaomi.smarthome.core.server;

import _m_j.fct;
import _m_j.fep;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.client.IClientCallback;

public class BleCoreProviderImpl$2 implements IClientCallback {
    final /* synthetic */ fct this$0;
    final /* synthetic */ fep val$callback;

    public IBinder asBinder() {
        return null;
    }

    public void onFailure(Bundle bundle) throws RemoteException {
    }

    public BleCoreProviderImpl$2(fct fct, fep fep) {
        this.this$0 = fct;
        this.val$callback = fep;
    }

    public void onSuccess(Bundle bundle) throws RemoteException {
        fep fep = this.val$callback;
        if (fep != null) {
            fep.O000000o();
        }
    }
}
