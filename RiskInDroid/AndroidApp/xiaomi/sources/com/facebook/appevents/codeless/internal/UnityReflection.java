package com.facebook.appevents.codeless.internal;

import android.util.Log;

public class UnityReflection {
    private static final String TAG = "com.facebook.appevents.codeless.internal.UnityReflection";
    private static Class<?> unityPlayer;

    public static void sendMessage(String str, String str2, String str3) {
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName("com.unity3d.player.UnityPlayer");
            }
            unityPlayer.getMethod("UnitySendMessage", String.class, String.class, String.class).invoke(unityPlayer, str, str2, str3);
        } catch (Exception e) {
            Log.e(TAG, "Failed to send message to Unity", e);
        }
    }

    public static void captureViewHierarchy() {
        sendMessage("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    public static void sendEventMapping(String str) {
        sendMessage("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }
}
