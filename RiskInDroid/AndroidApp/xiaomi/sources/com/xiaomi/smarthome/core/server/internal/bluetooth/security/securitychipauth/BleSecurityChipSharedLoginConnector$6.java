package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fhl;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipSharedLoginConnector$6 implements IBleResponse {
    final /* synthetic */ fhl this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipSharedLoginConnector$6(fhl fhl) {
        this.this$0 = fhl;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        if (i != 0) {
            this.this$0.O000000o(-28);
        }
    }
}
