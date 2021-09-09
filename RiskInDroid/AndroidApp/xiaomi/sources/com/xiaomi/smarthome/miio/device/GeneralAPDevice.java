package com.xiaomi.smarthome.miio.device;

import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;

public class GeneralAPDevice extends Device {
    public String content;

    public boolean hasShortcut() {
        return false;
    }

    public boolean isBinded() {
        return true;
    }

    public boolean isOpen() {
        return true;
    }

    public boolean isOwner() {
        return false;
    }

    public GeneralAPDevice(String str) {
        this.model = str;
        if (this.model.equals("fimi.camera.c1")) {
            this.did = "feimi_device";
        } else {
            this.did = "general_ap_device".concat(String.valueOf(str));
        }
        this.canAuth = false;
        setOwner(true);
        this.isOnline = true;
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.model);
        if (O00000oO != null) {
            this.name = O00000oO.O0000Oo0();
        }
    }
}
