package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fec;
import _m_j.fhj;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipRegisterConnector$9 implements IBleResponse {
    final /* synthetic */ fhj this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipRegisterConnector$9(fhj fhj) {
        this.this$0 = fhj;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleSecurityChipRegisterConnector sendBindKey onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            fec.O00000o().O00000Oo(42);
            this.this$0.O0000OOo.removeMessages(4098);
            fec.O00000o().O000000o(24);
            this.this$0.O0000OOo.sendEmptyMessageDelayed(4098, 15000);
            return;
        }
        fec.O00000o().O000000o(42, "error_code", String.valueOf(i));
        fec.O00000o().O000000o(42, 2);
        this.this$0.O000000o(-28);
    }
}
