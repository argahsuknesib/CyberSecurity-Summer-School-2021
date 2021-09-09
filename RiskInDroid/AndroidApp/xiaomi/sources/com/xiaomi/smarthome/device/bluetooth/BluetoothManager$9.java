package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.device.api.IBleCallback;

public class BluetoothManager$9 extends IBleCallback.Stub {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleCallResponse val$response;

    public BluetoothManager$9(foj foj, Response.BleCallResponse bleCallResponse) {
        this.this$0 = foj;
        this.val$response = bleCallResponse;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        Response.BleCallResponse bleCallResponse = this.val$response;
        if (bleCallResponse != null) {
            bleCallResponse.onResponse(i, bundle);
        }
    }
}
