package com.xiaomi.smarthome.plugin.service;

public enum HostService {
    OneMore("OneMore"),
    DesaiShoe("DesaiShoe");
    
    private String mValue;

    private HostService(String str) {
        this.mValue = str;
    }

    public final String getValue() {
        return this.mValue;
    }
}
