package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothManager$25 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleResponseV2 val$response;

    public BluetoothManager$25(foj foj, Response.BleResponseV2 bleResponseV2) {
        this.this$0 = foj;
        this.val$response = bleResponseV2;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        int[] iArr;
        if (this.val$response != null) {
            String str = null;
            if (bundle != null) {
                str = bundle.getString("extra.message");
                iArr = bundle.getIntArray("extra.int.array");
            } else {
                iArr = null;
            }
            this.val$response.onResponse(i, str, iArr);
        }
    }
}
