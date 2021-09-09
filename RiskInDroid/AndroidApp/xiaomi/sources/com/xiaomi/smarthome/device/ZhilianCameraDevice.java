package com.xiaomi.smarthome.device;

import android.net.wifi.ScanResult;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;

public class ZhilianCameraDevice extends Device {
    public boolean hasShortcut() {
        return false;
    }

    public ZhilianCameraDevice(ScanResult scanResult) {
        if (scanResult.SSID.contains("isa-camera-isc5")) {
            this.name = CommonApplication.getAppContext().getString(R.string.smart_config_xiaofang_name);
            this.model = "isa.camera.isc5";
        } else if (scanResult.SSID.contains("mijia-camera-v1")) {
            this.name = CommonApplication.getAppContext().getString(R.string.smart_config_mijia_camera_zhilian);
            this.model = "mijia.camera.v1";
        }
        this.did = "zhilian_camera_did";
        this.isOnline = true;
        this.permitLevel = 16;
    }
}
