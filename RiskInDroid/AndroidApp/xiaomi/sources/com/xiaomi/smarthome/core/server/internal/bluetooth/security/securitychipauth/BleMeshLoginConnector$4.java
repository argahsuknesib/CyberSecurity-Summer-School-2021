package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fha;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleMeshLoginConnector$4 implements IBleResponse {
    final /* synthetic */ fha this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleMeshLoginConnector$4(fha fha) {
        this.this$0 = fha;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleMeshLoginConnector Step 4 onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            this.this$0.O0000OOo.removeMessages(4099);
            this.this$0.O0000OOo.sendEmptyMessageDelayed(4099, 15000);
            return;
        }
        this.this$0.O000000o(-28);
    }
}
