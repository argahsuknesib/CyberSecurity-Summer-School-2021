package com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth;

import _m_j.fiu;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleStandardAuthLoginConnector$5 implements IBleResponse {
    final /* synthetic */ fiu this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleStandardAuthLoginConnector$5(fiu fiu) {
        this.this$0 = fiu;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleStandardAuthLoginConnector sendAppConfirm onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            this.this$0.O0000OOo.removeMessages(4103);
            this.this$0.O0000OOo.sendEmptyMessageDelayed(4103, 15000);
            return;
        }
        this.this$0.O000000o(-28);
    }
}
