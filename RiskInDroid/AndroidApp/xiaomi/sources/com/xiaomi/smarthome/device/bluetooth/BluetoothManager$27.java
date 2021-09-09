package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import _m_j.gnk;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.device.api.IBleCallback;

public class BluetoothManager$27 extends IBleCallback.Stub {
    final /* synthetic */ foj this$0;
    final /* synthetic */ Response.BleConnectResponse val$response;

    public BluetoothManager$27(foj foj, Response.BleConnectResponse bleConnectResponse) {
        this.this$0 = foj;
        this.val$response = bleConnectResponse;
    }

    public void onResponse(final int i, final Bundle bundle) throws RemoteException {
        if (this.val$response != null) {
            this.this$0.f16763O000000o.post(new Runnable() {
                /* class com.xiaomi.smarthome.device.bluetooth.BluetoothManager$27.AnonymousClass1 */

                public final void run() {
                    try {
                        if (bundle != null) {
                            bundle.setClassLoader(BluetoothManager$27.this.val$response.getClass().getClassLoader());
                        }
                        BluetoothManager$27.this.val$response.onResponse(i, bundle);
                    } catch (Throwable th) {
                        gnk.O00000Oo(gnk.O00000Oo(th));
                    }
                }
            });
        }
    }
}
