package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;
import java.util.UUID;

public class BluetoothManager$3 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ UUID val$character;
    final /* synthetic */ String val$mac;
    final /* synthetic */ Response.BleWriteResponse val$response;
    final /* synthetic */ UUID val$service;

    public BluetoothManager$3(foj foj, Response.BleWriteResponse bleWriteResponse, String str, UUID uuid, UUID uuid2) {
        this.this$0 = foj;
        this.val$response = bleWriteResponse;
        this.val$mac = str;
        this.val$service = uuid;
        this.val$character = uuid2;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        if (this.val$response != null) {
            this.this$0.O000000o(this.val$mac, i, "write", this.val$service, this.val$character);
            this.val$response.onResponse(i, null);
        }
    }
}
