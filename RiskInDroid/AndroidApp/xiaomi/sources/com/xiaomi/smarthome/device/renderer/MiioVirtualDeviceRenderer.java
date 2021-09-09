package com.xiaomi.smarthome.device.renderer;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;

public class MiioVirtualDeviceRenderer extends DeviceRenderer {
    public void setNameStatus(Context context, TextView textView, Device device, boolean z) {
        if (TextUtils.isEmpty(device.desc)) {
            textView.setText((int) R.string.exp_device_desc);
        } else {
            textView.setText(device.desc);
        }
        textView.setVisibility(0);
    }
}
