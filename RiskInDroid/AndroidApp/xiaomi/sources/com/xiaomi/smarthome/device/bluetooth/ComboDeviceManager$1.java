package com.xiaomi.smarthome.device.bluetooth;

import _m_j.fol;
import android.net.wifi.ScanResult;
import java.util.concurrent.Callable;

public class ComboDeviceManager$1 implements Callable<String> {
    final /* synthetic */ ScanResult val$scanResult;

    public ComboDeviceManager$1(ScanResult scanResult) {
        this.val$scanResult = scanResult;
    }

    public final String call() throws Exception {
        return fol.O00000Oo(this.val$scanResult);
    }
}
