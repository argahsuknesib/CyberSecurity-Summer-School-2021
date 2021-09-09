package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothManager$1 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleConnectResponse val$response;

    public BluetoothManager$1(foj foj, Response.BleConnectResponse bleConnectResponse) {
        this.this$0 = foj;
        this.val$response = bleConnectResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        Response.BleConnectResponse bleConnectResponse = this.val$response;
        if (bleConnectResponse != null) {
            if (bundle != null) {
                bundle.setClassLoader(bleConnectResponse.getClass().getClassLoader());
            }
            this.val$response.onResponse(i, bundle);
        }
    }
}
