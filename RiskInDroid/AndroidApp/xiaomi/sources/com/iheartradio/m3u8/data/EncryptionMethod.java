package com.iheartradio.m3u8.data;

import java.util.HashMap;
import java.util.Map;

public enum EncryptionMethod {
    NONE("NONE"),
    AES("AES-128"),
    SAMPLE_AES("SAMPLE-AES");
    
    private static final Map<String, EncryptionMethod> sMap = new HashMap();
    private final String value;

    static {
        for (EncryptionMethod encryptionMethod : values()) {
            sMap.put(encryptionMethod.value, encryptionMethod);
        }
    }

    private EncryptionMethod(String str) {
        this.value = str;
    }

    public static EncryptionMethod fromValue(String str) {
        return sMap.get(str);
    }

    public final String getValue() {
        return this.value;
    }
}
