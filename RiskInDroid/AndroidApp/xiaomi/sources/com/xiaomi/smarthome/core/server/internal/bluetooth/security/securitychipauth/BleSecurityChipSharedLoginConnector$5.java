package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fhl;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipSharedLoginConnector$5 implements IBleResponse {
    final /* synthetic */ fhl this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipSharedLoginConnector$5(fhl fhl) {
        this.this$0 = fhl;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleSecurityChipSharedLoginConnector Step 4 onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            this.this$0.O0000OOo.removeMessages(4100);
            this.this$0.O0000OOo.sendEmptyMessageDelayed(4100, 15000);
            return;
        }
        this.this$0.O000000o(-28);
    }
}
