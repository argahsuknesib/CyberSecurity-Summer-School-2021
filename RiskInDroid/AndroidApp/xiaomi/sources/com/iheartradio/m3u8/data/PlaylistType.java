package com.iheartradio.m3u8.data;

import java.util.HashMap;
import java.util.Map;

public enum PlaylistType {
    EVENT("EVENT"),
    VOD("VOD");
    
    private static final Map<String, PlaylistType> sMap = new HashMap();
    private final String value;

    static {
        for (PlaylistType playlistType : values()) {
            sMap.put(playlistType.value, playlistType);
        }
    }

    private PlaylistType(String str) {
        this.value = str;
    }

    public static PlaylistType fromValue(String str) {
        return sMap.get(str);
    }

    public final String getValue() {
        return this.value;
    }
}
