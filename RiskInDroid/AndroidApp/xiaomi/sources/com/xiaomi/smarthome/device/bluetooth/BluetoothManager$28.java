package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothManager$28 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleReadFirmwareVersionResponse val$response;

    public BluetoothManager$28(foj foj, Response.BleReadFirmwareVersionResponse bleReadFirmwareVersionResponse) {
        this.this$0 = foj;
        this.val$response = bleReadFirmwareVersionResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        this.val$response.onResponse(i, bundle.getString("extra.value"));
    }
}
