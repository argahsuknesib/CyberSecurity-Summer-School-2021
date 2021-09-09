package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothManager$15 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleWriteResponse val$response;

    public BluetoothManager$15(foj foj, Response.BleWriteResponse bleWriteResponse) {
        this.this$0 = foj;
        this.val$response = bleWriteResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        Response.BleWriteResponse bleWriteResponse = this.val$response;
        if (bleWriteResponse != null) {
            bleWriteResponse.onResponse(i, null);
        }
    }
}
