package com.iheartradio.m3u8.data;

import java.util.HashMap;
import java.util.Map;

public enum MediaType {
    AUDIO("AUDIO"),
    VIDEO("VIDEO"),
    SUBTITLES("SUBTITLES"),
    CLOSED_CAPTIONS("CLOSED-CAPTIONS");
    
    private static final Map<String, MediaType> sMap = new HashMap();
    private final String value;

    static {
        for (MediaType mediaType : values()) {
            sMap.put(mediaType.value, mediaType);
        }
    }

    private MediaType(String str) {
        this.value = str;
    }

    public static MediaType fromValue(String str) {
        return sMap.get(str);
    }

    public final String getValue() {
        return this.value;
    }
}
