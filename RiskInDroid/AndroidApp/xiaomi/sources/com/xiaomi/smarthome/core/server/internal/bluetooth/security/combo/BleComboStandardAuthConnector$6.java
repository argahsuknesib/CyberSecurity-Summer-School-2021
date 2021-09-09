package com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo;

import _m_j.fgr;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleComboStandardAuthConnector$6 implements IBleResponse {
    final /* synthetic */ fgr this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleComboStandardAuthConnector$6(fgr fgr) {
        this.this$0 = fgr;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleComboStandardAuthConnector sendWifiConfig onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            this.this$0.O000000o(0);
        } else {
            this.this$0.O000000o(-28);
        }
    }
}
