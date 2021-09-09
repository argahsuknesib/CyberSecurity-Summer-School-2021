package com.xiaomi.smarthome.device.bluetooth.utils;

import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;

public class BluetoothHelper$18 extends BluetoothResponse {
    final /* synthetic */ Response.BleResponse val$response;

    BluetoothHelper$18(Response.BleResponse bleResponse) {
        this.val$response = bleResponse;
    }

    public final void onResponse(int i, Bundle bundle) throws RemoteException {
        this.val$response.onResponse(i, Integer.valueOf(bundle.getInt("extra.mtu", 23)));
    }
}
