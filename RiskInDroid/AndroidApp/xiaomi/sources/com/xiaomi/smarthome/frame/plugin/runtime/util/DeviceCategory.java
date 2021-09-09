package com.xiaomi.smarthome.frame.plugin.runtime.util;

public enum DeviceCategory {
    Unknow(-1),
    Wifi(0),
    YunYI(1),
    Cloud(2),
    SubDevice(3),
    WebSocket(4),
    Virtual(5),
    Bluetooth(6),
    LocalAp(7),
    Combo(8),
    NBIOT(13),
    IR(15),
    BleMesh(16),
    VirtualGroup(17);
    
    private int pid;

    private DeviceCategory(int i) {
        this.pid = i;
    }

    public static DeviceCategory fromPid(int i) {
        for (DeviceCategory deviceCategory : values()) {
            if (deviceCategory.pid == i) {
                return deviceCategory;
            }
        }
        return Unknow;
    }
}
