package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothManager$18 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleReadResponse val$response;

    public BluetoothManager$18(foj foj, Response.BleReadResponse bleReadResponse) {
        this.this$0 = foj;
        this.val$response = bleReadResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        if (this.val$response != null) {
            this.val$response.onResponse(i, bundle.getByteArray("extra.byte.array"));
        }
    }
}
