package com.inuker.bluetooth.library;

import _m_j.bii;
import _m_j.bjq;
import android.os.Bundle;
import com.inuker.bluetooth.library.connect.response.BluetoothResponse;
import com.inuker.bluetooth.library.model.BleGattProfile;

public class BluetoothClientImpl$2 extends BluetoothResponse {
    final /* synthetic */ bii this$0;
    final /* synthetic */ bjq val$response;

    BluetoothClientImpl$2(bii bii, bjq bjq) {
        this.this$0 = bii;
        this.val$response = bjq;
    }

    public void onAsyncResponse(int i, Bundle bundle) {
        this.this$0.O00000Oo();
        if (this.val$response != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.val$response.O000000o(i, (BleGattProfile) bundle.getParcelable("extra.gatt.profile"));
        }
    }
}
