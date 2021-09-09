package com.inuker.bluetooth.library;

import _m_j.bii;
import _m_j.bjt;
import android.os.Bundle;
import com.inuker.bluetooth.library.connect.response.BluetoothResponse;

public class BluetoothClientImpl$5 extends BluetoothResponse {
    final /* synthetic */ bii this$0;
    final /* synthetic */ bjt val$response;

    BluetoothClientImpl$5(bii bii, bjt bjt) {
        this.this$0 = bii;
        this.val$response = bjt;
    }

    public void onAsyncResponse(int i, Bundle bundle) {
        this.this$0.O00000Oo();
        bjt bjt = this.val$response;
        if (bjt != null) {
            bjt.O000000o(i, bundle.getByteArray("extra.byte.value"));
        }
    }
}
