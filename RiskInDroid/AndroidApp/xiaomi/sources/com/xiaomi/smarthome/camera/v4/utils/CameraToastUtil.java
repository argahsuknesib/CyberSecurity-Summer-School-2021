package com.xiaomi.smarthome.camera.v4.utils;

import _m_j.gqg;
import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.plugin.DeviceConstant;

public class CameraToastUtil {
    public static void showPowerOffToast(String str, Context context, int i) {
        if (DeviceConstant.isSupportAiNative(str)) {
            gqg.O000000o((int) R.string.camera_closed_wulizhebi_tip);
        } else {
            gqg.O000000o(i);
        }
    }
}
