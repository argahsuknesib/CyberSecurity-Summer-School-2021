package com.xiaomi.smarthome.uwb_mijia.bind;

import _m_j.dcp;
import _m_j.htr;
import _m_j.hzs;
import android.os.RemoteException;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.MijiaProcessor;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class UwbDeviceBinder$1 extends IConfigCompletionHandler.Stub {
    final /* synthetic */ UwbScanDevice val$uwbScanDevice;

    public UwbDeviceBinder$1(UwbScanDevice uwbScanDevice) {
        this.val$uwbScanDevice = uwbScanDevice;
    }

    public final void onSucceed(String str) throws RemoteException {
        dcp.O000000o().O00000Oo(false);
        Device device = (Device) htr.O000000o().O000000o("connected_device");
        if (device == null) {
            UwbLogUtil.e("Mijia-UWB-Binder", "startBindBuiltin error: device is null");
            return;
        }
        hzs.O000000o(this.val$uwbScanDevice, device);
        MijiaProcessor.processUWBScanResult(UwbSdk.getApplication(), this.val$uwbScanDevice);
        UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder startBindBuiltin onSucceed");
    }

    public final void onFailed(int i, String str) throws RemoteException {
        dcp.O000000o().O00000Oo(false);
        UwbLogUtil.e("Mijia-UWB-timestamp", "UwbDeviceBinder onFailed " + i + "," + str);
    }
}
