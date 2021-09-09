package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothManager$5 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleNotifyResponse val$response;

    public BluetoothManager$5(foj foj, Response.BleNotifyResponse bleNotifyResponse) {
        this.this$0 = foj;
        this.val$response = bleNotifyResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        Response.BleNotifyResponse bleNotifyResponse = this.val$response;
        if (bleNotifyResponse != null) {
            bleNotifyResponse.onResponse(i, null);
        }
    }
}
