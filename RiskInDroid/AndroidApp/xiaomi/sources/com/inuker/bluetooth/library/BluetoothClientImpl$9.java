package com.inuker.bluetooth.library;

import _m_j.bii;
import _m_j.bjw;
import android.os.Bundle;
import com.inuker.bluetooth.library.connect.response.BluetoothResponse;
import java.util.HashMap;
import java.util.UUID;

public class BluetoothClientImpl$9 extends BluetoothResponse {
    final /* synthetic */ bii this$0;
    final /* synthetic */ UUID val$character;
    final /* synthetic */ String val$mac;
    final /* synthetic */ bjw val$response;
    final /* synthetic */ UUID val$service;

    BluetoothClientImpl$9(bii bii, String str, UUID uuid, UUID uuid2, bjw bjw) {
        this.this$0 = bii;
        this.val$mac = str;
        this.val$service = uuid;
        this.val$character = uuid2;
        this.val$response = bjw;
    }

    public void onAsyncResponse(int i, Bundle bundle) {
        this.this$0.O00000Oo();
        bii bii = this.this$0;
        String str = this.val$mac;
        UUID uuid = this.val$service;
        UUID uuid2 = this.val$character;
        bii.O00000Oo();
        HashMap hashMap = bii.O00000o0.get(str);
        if (hashMap != null) {
            hashMap.remove(bii.O000000o(uuid, uuid2));
        }
    }
}
