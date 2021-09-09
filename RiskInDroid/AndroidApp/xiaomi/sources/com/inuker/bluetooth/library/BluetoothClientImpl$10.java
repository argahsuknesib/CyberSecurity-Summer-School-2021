package com.inuker.bluetooth.library;

import _m_j.bii;
import _m_j.bjs;
import android.os.Bundle;
import com.inuker.bluetooth.library.connect.response.BluetoothResponse;
import java.util.UUID;

public class BluetoothClientImpl$10 extends BluetoothResponse {
    final /* synthetic */ bii this$0;
    final /* synthetic */ UUID val$character;
    final /* synthetic */ String val$mac;
    final /* synthetic */ bjs val$response;
    final /* synthetic */ UUID val$service;

    BluetoothClientImpl$10(bii bii, bjs bjs, String str, UUID uuid, UUID uuid2) {
        this.this$0 = bii;
        this.val$response = bjs;
        this.val$mac = str;
        this.val$service = uuid;
        this.val$character = uuid2;
    }

    public void onAsyncResponse(int i, Bundle bundle) {
        this.this$0.O00000Oo();
        bjs bjs = this.val$response;
        if (bjs != null && i == 0) {
            this.this$0.O000000o(this.val$mac, this.val$service, this.val$character, bjs);
        }
    }
}
