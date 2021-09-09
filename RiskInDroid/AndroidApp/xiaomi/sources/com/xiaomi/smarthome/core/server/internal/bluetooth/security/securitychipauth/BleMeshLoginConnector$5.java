package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fha;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleMeshLoginConnector$5 implements IBleResponse {
    final /* synthetic */ fha this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleMeshLoginConnector$5(fha fha) {
        this.this$0 = fha;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        if (i != 0) {
            this.this$0.O000000o(-28);
        }
    }
}
