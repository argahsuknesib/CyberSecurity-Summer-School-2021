package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;
import java.util.UUID;

public class BluetoothManager$2 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ UUID val$character;
    final /* synthetic */ String val$mac;
    final /* synthetic */ Response.BleReadResponse val$response;
    final /* synthetic */ UUID val$service;

    public BluetoothManager$2(foj foj, String str, UUID uuid, UUID uuid2, Response.BleReadResponse bleReadResponse) {
        this.this$0 = foj;
        this.val$mac = str;
        this.val$service = uuid;
        this.val$character = uuid2;
        this.val$response = bleReadResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        byte[] byteArray = bundle.getByteArray("extra.byte.array");
        this.this$0.O000000o(this.val$mac, i, "read", this.val$service, this.val$character);
        this.val$response.onResponse(i, byteArray);
    }
}
