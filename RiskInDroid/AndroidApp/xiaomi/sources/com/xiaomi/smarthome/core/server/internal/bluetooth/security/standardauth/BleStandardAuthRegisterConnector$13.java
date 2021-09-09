package com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth;

import _m_j.fec;
import _m_j.fiw;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleStandardAuthRegisterConnector$13 implements IBleResponse {
    final /* synthetic */ fiw this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleStandardAuthRegisterConnector$13(fiw fiw) {
        this.this$0 = fiw;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleStandardAuthRegisterConnector sendAppConfirmation onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            fec.O00000o().O00000Oo(18);
            fec.O00000o().O000000o(19);
            this.this$0.O0000OOo.removeMessages(4102);
            this.this$0.O0000OOo.sendEmptyMessageDelayed(4102, 15000);
            return;
        }
        fec.O00000o().O000000o(18, "error_code", String.valueOf(i));
        fec.O00000o().O00000Oo(18);
        this.this$0.O000000o(-28);
    }
}
