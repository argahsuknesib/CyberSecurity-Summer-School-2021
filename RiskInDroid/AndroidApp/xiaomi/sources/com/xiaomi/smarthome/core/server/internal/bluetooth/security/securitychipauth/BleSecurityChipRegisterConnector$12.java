package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fhj;
import _m_j.got;
import _m_j.grs;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipRegisterConnector$12 implements IBleResponse {
    final /* synthetic */ fhj this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipRegisterConnector$12(fhj fhj) {
        this.this$0 = fhj;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        if (i != 0) {
            fhj.O000000o("write EncryptData Fail ,code=".concat(String.valueOf(i)), new Object[0]);
            this.this$0.O0000o0o();
            this.this$0.O000000o(-28);
            return;
        }
        fhj fhj = this.this$0;
        byte[] O000000o2 = grs.O000000o(fhj.O0000oOO, 24);
        fhj.O000000o("writeCloudCert2Device cloud cert=%s", got.O00000o0(O000000o2));
        if (!fhj.O000000o(O000000o2, 7, new BleSecurityChipRegisterConnector$13(fhj))) {
            fhj.O000000o("writeCloudCert fail", new Object[0]);
            fhj.O0000o0o();
            fhj.O000000o(-28);
        }
    }
}
