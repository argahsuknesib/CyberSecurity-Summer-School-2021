package com.xiaomi.smarthome.mitsmsdk;

import android.content.Context;
import com.miui.tsmclient.util.IDeviceInfo;
import java.util.Collections;
import java.util.List;

public class DeviceInfoImpl implements IDeviceInfo {
    public int getDeviceType() {
        return 4;
    }

    public boolean isEseEnabled(Context context) {
        return true;
    }

    public String getDeviceId(Context context) {
        return NfcChannelManager.getInstance().getDid();
    }

    public String getDeviceModel() {
        return NfcChannelManager.getInstance().getModel();
    }

    public List<String> getSIMNumber() {
        return Collections.emptyList();
    }
}
