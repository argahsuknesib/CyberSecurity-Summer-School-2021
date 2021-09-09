package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class ProfileInformationCache {
    private static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap<>();

    ProfileInformationCache() {
    }

    public static JSONObject getProfileInformation(String str) {
        return infoCache.get(str);
    }

    public static void putProfileInformation(String str, JSONObject jSONObject) {
        infoCache.put(str, jSONObject);
    }
}
