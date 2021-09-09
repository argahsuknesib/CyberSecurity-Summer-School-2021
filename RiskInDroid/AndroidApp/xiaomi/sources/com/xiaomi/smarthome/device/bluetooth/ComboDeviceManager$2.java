package com.xiaomi.smarthome.device.bluetooth;

import _m_j.fte;
import _m_j.gmc;
import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;
import java.util.concurrent.CountDownLatch;

public class ComboDeviceManager$2 extends BluetoothResponse {
    final /* synthetic */ CountDownLatch val$latch;
    final /* synthetic */ Bundle val$result;

    public ComboDeviceManager$2(Bundle bundle, CountDownLatch countDownLatch) {
        this.val$result = bundle;
        this.val$latch = countDownLatch;
    }

    public final void onResponse(int i, Bundle bundle) throws RemoteException {
        String str = "";
        if (bundle != null) {
            str = bundle.getString("extra.mac", str);
        }
        fte.O00000Oo(String.format("ComboDeviceManager.searchComboDeviceSync onResponse %s, mac = (%s)", gmc.O000000o(i), fte.O000000o(str)));
        if (i == 0 && bundle != null) {
            this.val$result.putAll(bundle);
        }
        this.val$latch.countDown();
    }
}
