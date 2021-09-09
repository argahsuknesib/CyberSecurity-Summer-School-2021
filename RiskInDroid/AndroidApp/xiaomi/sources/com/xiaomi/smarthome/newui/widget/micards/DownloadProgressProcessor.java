package com.xiaomi.smarthome.newui.widget.micards;

import com.xiaomi.smarthome.device.Device;

public interface DownloadProgressProcessor {
    float progress(float f, Device device);

    boolean shouldInstallNow(Device device);
}
