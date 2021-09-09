package com.inuker.bluetooth.library;

import _m_j.bii;
import _m_j.bju;
import android.os.Bundle;
import com.inuker.bluetooth.library.connect.response.BluetoothResponse;

public class BluetoothClientImpl$11 extends BluetoothResponse {
    final /* synthetic */ bii this$0;
    final /* synthetic */ bju val$response;

    BluetoothClientImpl$11(bii bii, bju bju) {
        this.this$0 = bii;
        this.val$response = bju;
    }

    public void onAsyncResponse(int i, Bundle bundle) {
        this.this$0.O00000Oo();
        bju bju = this.val$response;
        if (bju != null) {
            bju.O000000o(i, Integer.valueOf(bundle.getInt("extra.rssi", 0)));
        }
    }
}
