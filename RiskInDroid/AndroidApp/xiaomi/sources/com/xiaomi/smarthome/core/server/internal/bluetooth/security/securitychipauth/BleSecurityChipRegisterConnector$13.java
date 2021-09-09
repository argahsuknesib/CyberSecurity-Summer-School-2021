package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fec;
import _m_j.fhj;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipRegisterConnector$13 implements IBleResponse {
    final /* synthetic */ fhj this$0;

    public IBinder asBinder() {
        return null;
    }

    BleSecurityChipRegisterConnector$13(fhj fhj) {
        this.this$0 = fhj;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        if (i != 0) {
            fhj.O000000o("writeCloudCert fail ,code=".concat(String.valueOf(i)), new Object[0]);
            this.this$0.O0000o0o();
            this.this$0.O000000o(-28);
            return;
        }
        fec.O00000o().O000000o(14);
        this.this$0.O0000OOo.removeMessages(4098);
        this.this$0.O0000OOo.sendEmptyMessageDelayed(4098, 15000);
    }
}
