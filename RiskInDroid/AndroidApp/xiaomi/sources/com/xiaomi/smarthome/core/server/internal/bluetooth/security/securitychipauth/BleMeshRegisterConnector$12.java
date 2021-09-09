package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fec;
import _m_j.fhc;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleMeshRegisterConnector$12 implements IBleResponse {
    final /* synthetic */ fhc this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleMeshRegisterConnector$12(fhc fhc) {
        this.this$0 = fhc;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleMeshRegisterConnector sendMeshProvisionInfoToDevice onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            fec.O00000o().O00000Oo(35);
            this.this$0.O0000OOo.removeMessages(4101);
            fec.O00000o().O000000o(14);
            this.this$0.O0000OOo.sendEmptyMessageDelayed(4101, 20000);
            return;
        }
        fec.O00000o().O000000o(35, "error_code", String.valueOf(i));
        fec.O00000o().O000000o(35, 2);
        this.this$0.O000000o(-28);
    }
}
