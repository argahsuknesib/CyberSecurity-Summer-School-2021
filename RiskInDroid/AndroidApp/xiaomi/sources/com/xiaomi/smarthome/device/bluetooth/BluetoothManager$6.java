package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothManager$6 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleReadRssiResponse val$response;

    public BluetoothManager$6(foj foj, Response.BleReadRssiResponse bleReadRssiResponse) {
        this.this$0 = foj;
        this.val$response = bleReadRssiResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        this.val$response.onResponse(i, Integer.valueOf(bundle.getInt("extra.rssi", 0)));
    }
}
