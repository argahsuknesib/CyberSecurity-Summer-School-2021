package com.xiaomi.smarthome.device.renderer;

import _m_j.eyc;
import _m_j.fob;
import _m_j.foc;
import _m_j.fpo;
import _m_j.gsy;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;

public class BleDeviceRenderer extends DeviceRenderer {
    public void refreshClickedDeviceDesc() {
    }

    public Intent getAction(Device device, Context context, Bundle bundle, boolean z, eyc.O000000o o000000o) {
        gsy.O000000o(4, "stopScan", "render stop");
        fpo.O00000Oo();
        fpo.O000000o(device.mac);
        BleDevice O00000o0 = fob.O00000o0(device.mac);
        if (O00000o0 != null) {
            O00000o0.O000000o(false);
        }
        if (TextUtils.isEmpty(device.ownerId)) {
            device.ownerId = foc.O00000oO(device.mac);
        }
        if (!device.isOnline) {
            return super.getAction(device, context, bundle, z, null);
        }
        if (CoreApi.O000000o().O00000o(device.model)) {
            return super.getAction(device, context, bundle, z, null);
        }
        return super.getAction(device, context, bundle, z, null);
    }

    /* access modifiers changed from: protected */
    public boolean isClickable(Context context, Device device, Handler handler) {
        return super.isClickable(context, device, handler);
    }
}
