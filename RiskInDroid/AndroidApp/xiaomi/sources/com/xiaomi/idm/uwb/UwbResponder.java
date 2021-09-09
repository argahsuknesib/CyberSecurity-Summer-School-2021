package com.xiaomi.idm.uwb;

import android.content.Context;
import com.xiaomi.idm.uwb.IDMUwb;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.idm.uwb.proto.UwbData;
import java.util.List;

public class UwbResponder extends IDMUwb {
    public UwbResponder(Context context, IDMUwb.UwbCallback uwbCallback) {
        super(context, uwbCallback);
    }

    public void setServerSecurityKey(String str, String str2) {
        super.setServerSecurityKey(str, str2);
    }

    public void startScan() {
        super.startScan(UwbConst.DeviceRole.RESPONDER.getValue(), 0, 0, null);
    }

    public UwbData.TagInfo getTagInfo() {
        return super.getTagInfo();
    }

    public List<String> queryTagConnection() {
        return super.queryTagConnection();
    }

    public void stopScan() {
        super.stopScan();
    }

    public void sendPayload(String str, IDMUwb.Payload payload, UwbConst.Flag flag, int i) {
        super.sendPayload(str, payload, flag.getValue(), 0, i);
    }

    public void tagOTA(String str, int i, byte[] bArr) {
        super.tagOTA(str, i, bArr);
    }
}
