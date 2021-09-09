package com.xiaomi.smarthome.miio.device;

import android.graphics.Color;
import com.xiaomi.smarthome.device.MiioDeviceV2;

public class SmartBulbDevice extends MiioDeviceV2 {
    int b;
    int g;
    int mBright;
    int r;

    public String getName() {
        return this.name;
    }

    public String getMac() {
        return this.mac;
    }

    public boolean isOpen() {
        return this.mBright > 0;
    }

    public void parseProp() {
        if (this.propInfo != null && this.isOnline) {
            this.mBright = this.propInfo.optInt("bright");
            int optInt = this.propInfo.optInt("rgb");
            this.r = Color.red(optInt);
            this.g = Color.green(optInt);
            this.b = Color.blue(optInt);
        }
    }
}
