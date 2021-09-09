package com.reactnativecommunity.geolocation;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class PositionError {
    public static int PERMISSION_DENIED = 1;
    public static int POSITION_UNAVAILABLE = 2;
    public static int TIMEOUT = 3;

    public static WritableMap buildError(int i, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("code", i);
        if (str != null) {
            createMap.putString("message", str);
        }
        createMap.putInt("PERMISSION_DENIED", PERMISSION_DENIED);
        createMap.putInt("POSITION_UNAVAILABLE", POSITION_UNAVAILABLE);
        createMap.putInt("TIMEOUT", TIMEOUT);
        return createMap;
    }
}
