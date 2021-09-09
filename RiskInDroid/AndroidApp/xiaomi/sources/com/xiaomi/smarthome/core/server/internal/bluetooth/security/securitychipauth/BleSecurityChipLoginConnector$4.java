package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fhg;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipLoginConnector$4 implements IBleResponse {
    final /* synthetic */ fhg this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipLoginConnector$4(fhg fhg) {
        this.this$0 = fhg;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleSecurityChipLoginConnector Step 4 onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            this.this$0.O0000OOo.removeMessages(4099);
            this.this$0.O0000OOo.sendEmptyMessageDelayed(4099, 15000);
            return;
        }
        this.this$0.O000000o(-28);
    }
}
