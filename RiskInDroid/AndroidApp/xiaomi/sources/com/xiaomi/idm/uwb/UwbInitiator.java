package com.xiaomi.idm.uwb;

import android.content.Context;
import com.xiaomi.idm.uwb.IDMUwb;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.idm.uwb.constant.UwbResultCode;

public class UwbInitiator extends IDMUwb {
    public UwbInitiator(Context context, IDMUwb.UwbCallback uwbCallback) {
        super(context, uwbCallback);
    }

    public void startScan(int i, int i2, String str) {
        super.startScan(UwbConst.DeviceRole.INITIATOR.getValue(), i, i2, str);
    }

    public boolean isScanning() {
        return super.isScanning();
    }

    public void stopScan() {
        super.stopScan();
    }

    public void startAdvertising(int i, String str, int i2) {
        super.startAdvertising(i, str, i2);
    }

    public void sendPayload(String str, IDMUwb.Payload payload, UwbConst.Flag flag, UwbConst.Target target, int i) {
        super.sendPayload(str, payload, flag.getValue(), target.getCmd(), i);
    }

    public void connect(String str) {
        super.connect(str);
    }

    public void disconnect(String str) {
        super.disconnect(str);
    }

    public void establishSecurityLine(String str, String str2, byte[] bArr, UwbConst.LoginType loginType, UwbConst.AppId appId) {
        super.establishSecurityLine(str, str2, bArr, loginType.getType(), appId.getId());
    }

    public void switchCommunicationType(UwbConst.AppId appId, String str) {
        super.switchCommunicationType(appId.getId(), str);
    }

    public UwbResultCode stopUwb(String str) {
        return super.stopUwb(str);
    }
}
