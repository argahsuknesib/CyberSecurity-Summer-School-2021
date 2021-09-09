package com.xiaomi.smarthome.miio.device;

import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.concurrent.atomic.AtomicInteger;

public class TemporaryDevice extends Device {

    /* renamed from: O000000o  reason: collision with root package name */
    private static AtomicInteger f9715O000000o = new AtomicInteger(-1);

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

    public TemporaryDevice(String str) {
        this.model = str;
        this.did = "temprory_device" + f9715O000000o.addAndGet(1);
        this.canAuth = false;
        setOwner(true);
        this.isOnline = true;
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O00000oO != null) {
            this.name = O00000oO.O0000Oo0();
        }
    }
}
