package com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth;

import _m_j.fec;
import _m_j.fiw;
import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;

public class BleStandardAuthRegisterConnector$11 implements IBleResponse {
    final /* synthetic */ fiw this$0;
    final /* synthetic */ BleWriteResponse val$response;

    public IBinder asBinder() {
        return null;
    }

    public BleStandardAuthRegisterConnector$11(fiw fiw, BleWriteResponse bleWriteResponse) {
        this.this$0 = fiw;
        this.val$response = bleWriteResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo("BleStandardAuthRegisterConnector writeDidToDevice onResponse: " + gmc.O000000o(i));
        if (i == 0) {
            fec.O00000o().O00000Oo(11);
        } else {
            fec.O00000o().O000000o(11, "error_code", String.valueOf(i));
            fec.O00000o().O000000o(11, 2);
        }
        BleWriteResponse bleWriteResponse = this.val$response;
        if (bleWriteResponse != null) {
            bleWriteResponse.onResponse(i, null);
        }
    }
}
