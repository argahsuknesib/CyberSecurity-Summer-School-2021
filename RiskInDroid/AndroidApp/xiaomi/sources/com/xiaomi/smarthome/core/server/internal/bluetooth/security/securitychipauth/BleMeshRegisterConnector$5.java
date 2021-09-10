package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fec;
import _m_j.fhc;
import _m_j.fte;
import _m_j.gmc;
import _m_j.grs;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleMeshRegisterConnector$5 implements IBleResponse {
    final /* synthetic */ fhc this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleMeshRegisterConnector$5(fhc fhc) {
        this.this$0 = fhc;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleMeshRegisterConnector Step 3 onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            fec.O00000o().O00000Oo(26);
            fhc fhc = this.this$0;
            fec.O00000o().O000000o(27);
            if (!fhc.O000000o(grs.O000000o(fhc.O0000o0, 24), 3, new BleMeshRegisterConnector$6(fhc))) {
                fec.O00000o().O000000o(27, 2);
                fhc.O000000o(-28);
                return;
            }
            return;
        }
        fec.O00000o().O000000o(26, "error_code", String.valueOf(i));
        fec.O00000o().O000000o(26, 2);
        this.this$0.O000000o(-28);
    }
}
