package com.xiaomi.smarthome.device.api;

public class KeyValuePair {
    private final String key;
    private final String value;

    public KeyValuePair(String str, String str2) {
        if (str != null) {
            this.key = str;
            this.value = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
