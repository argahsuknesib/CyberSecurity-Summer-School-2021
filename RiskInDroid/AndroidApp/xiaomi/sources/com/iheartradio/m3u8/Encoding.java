package com.iheartradio.m3u8;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum Encoding {
    UTF_8("utf-8", true),
    WINDOWS_1252("windows-1252", false);
    
    private static final Map<String, Encoding> sMap = new HashMap();
    public final boolean supportsByteOrderMark;
    public final String value;

    static {
        for (Encoding encoding : values()) {
            sMap.put(encoding.value, encoding);
        }
    }

    private Encoding(String str, boolean z) {
        this.value = str;
        this.supportsByteOrderMark = z;
    }

    public static Encoding fromValue(String str) {
        if (str == null) {
            return null;
        }
        return sMap.get(str.toLowerCase(Locale.US));
    }

    public final String getValue() {
        return this.value;
    }
}
