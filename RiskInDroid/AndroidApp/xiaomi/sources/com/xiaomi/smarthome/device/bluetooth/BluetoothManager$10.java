package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import _m_j.glc;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothManager$10 extends BluetoothResponse {
    final /* synthetic */ foj this$0;
    final /* synthetic */ String val$mac;
    final /* synthetic */ Response.BleDeviceStatusResponse val$response;

    public BluetoothManager$10(foj foj, String str, Response.BleDeviceStatusResponse bleDeviceStatusResponse) {
        this.this$0 = foj;
        this.val$mac = str;
        this.val$response = bleDeviceStatusResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        int i2 = bundle.getInt("extra.device.status", 48);
        Intent intent = new Intent("action.online.status.changed");
        intent.putExtra("extra_mac", this.val$mac);
        intent.putExtra("extra_online_status", i2);
        glc.O0000O0o.sendBroadcast(intent);
        Response.BleDeviceStatusResponse bleDeviceStatusResponse = this.val$response;
        if (bleDeviceStatusResponse != null) {
            bleDeviceStatusResponse.onResponse(i, Integer.valueOf(i2));
        }
    }
}
