package com.inuker.bluetooth.library;

import _m_j.bii;
import _m_j.bkx;
import android.os.Bundle;
import com.inuker.bluetooth.library.connect.response.BluetoothResponse;

public class BluetoothClientImpl$12 extends BluetoothResponse {
    final /* synthetic */ bii this$0;
    final /* synthetic */ bkx val$response;

    BluetoothClientImpl$12(bii bii, bkx bkx) {
        this.this$0 = bii;
        this.val$response = bkx;
    }

    public void onAsyncResponse(int i, Bundle bundle) {
        this.this$0.O00000Oo();
        if (this.val$response != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            if (i != 1 && i != 2 && i != 3) {
                if (i == 4) {
                    bundle.getParcelable("extra.search.result");
                    return;
                }
                throw new IllegalStateException("unknown code");
            }
        }
    }
}
