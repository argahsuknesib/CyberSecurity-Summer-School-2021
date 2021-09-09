package com.facebook.internal;

public class InternalSettings {
    private static volatile String mCustomUserAgent;

    public static void setCustomUserAgent(String str) {
        mCustomUserAgent = str;
    }

    public static String getCustomUserAgent() {
        return mCustomUserAgent;
    }

    public static boolean isUnityApp() {
        return mCustomUserAgent != null && mCustomUserAgent.startsWith("Unity.");
    }
}
