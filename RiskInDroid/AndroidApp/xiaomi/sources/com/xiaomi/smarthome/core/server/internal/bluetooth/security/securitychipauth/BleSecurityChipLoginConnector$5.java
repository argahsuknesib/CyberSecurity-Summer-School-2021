package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fhg;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipLoginConnector$5 implements IBleResponse {
    final /* synthetic */ fhg this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipLoginConnector$5(fhg fhg) {
        this.this$0 = fhg;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        if (i != 0) {
            this.this$0.O000000o(-28);
        }
    }
}
