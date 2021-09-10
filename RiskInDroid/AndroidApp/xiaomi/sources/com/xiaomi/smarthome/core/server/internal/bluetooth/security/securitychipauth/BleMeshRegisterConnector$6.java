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

public class BleMeshRegisterConnector$6 implements IBleResponse {
    final /* synthetic */ fhc this$0;

    public IBinder asBinder() {
        return null;
    }

    BleMeshRegisterConnector$6(fhc fhc) {
        this.this$0 = fhc;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleMeshRegisterConnector Step 4 onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            fec.O00000o().O00000Oo(27);
            fhc fhc = this.this$0;
            fec.O00000o().O000000o(28);
            if (!fhc.O000000o(grs.O000000o(fhc.O0000o0O, 24), 8, new BleMeshRegisterConnector$7(fhc))) {
                fec.O00000o().O000000o(28, 2);
                fhc.O000000o(-28);
                return;
            }
            return;
        }
        fec.O00000o().O000000o(27, "error_code", String.valueOf(i));
        fec.O00000o().O000000o(27, 2);
        this.this$0.O000000o(-28);
    }
}
