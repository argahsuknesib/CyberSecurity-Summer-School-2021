package com.xiaomi.smarthome.device;

public class ApDevice extends Device {
    public String apBSSID;
    public String apPasswd;
    public String apSSID;

    public String getName() {
        return DeviceFactory.O0000OoO(this.model);
    }
}
