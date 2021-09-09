package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fec;
import _m_j.fhj;
import _m_j.fir;
import _m_j.fte;
import _m_j.gmc;
import _m_j.got;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipRegisterConnector$8 implements IBleResponse {
    final /* synthetic */ fhj this$0;
    final /* synthetic */ byte[] val$devRandom;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipRegisterConnector$8(fhj fhj, byte[] bArr) {
        this.this$0 = fhj;
        this.val$devRandom = bArr;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleSecurityChipRegisterConnector recvDevRandom onResponse: " + gmc.O000000o(i));
        if (i != 0) {
            this.this$0.O000000o(-28);
            fec.O00000o().O000000o(20, "error_code", String.valueOf(i));
            fec.O00000o().O000000o(20, 2);
            return;
        }
        fec.O00000o().O00000Oo(20);
        byte[] bArr = new byte[32];
        System.arraycopy(this.val$devRandom, 0, bArr, 0, 16);
        System.arraycopy(this.this$0.O0000o0o, 0, bArr, 16, 16);
        if (got.O000000o(this.this$0.O0000o, fir.O000000o(this.this$0.O0000o0O.getEncoded(), bArr))) {
            this.this$0.O000000o(true);
        } else {
            this.this$0.O000000o(false);
        }
    }
}
