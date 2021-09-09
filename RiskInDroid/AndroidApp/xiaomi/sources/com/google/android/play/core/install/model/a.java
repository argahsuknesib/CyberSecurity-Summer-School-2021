package com.google.android.play.core.install.model;

import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, String> f3740a = new HashMap();
    private static final Map<Integer, String> b = new HashMap();

    static {
        f3740a.put(-2, "An unknown error occurred.");
        f3740a.put(-3, "The API is not available on this device.");
        f3740a.put(-4, "The request that was sent by the app is malformed.");
        f3740a.put(-5, "The install is unavailable to this user or device.");
        f3740a.put(-6, "The download/install is not allowed, due to the current device state (e.g. low battery, low disk space, ...).");
        f3740a.put(-7, "The install/update has not been (fully) downloaded yet.");
        f3740a.put(-8, "The install is already in progress and there is no UI flow to resume.");
        f3740a.put(-100, "An internal error happened in the Play Store.");
        b.put(-2, "ERROR_UNKNOWN");
        b.put(-3, "ERROR_API_NOT_AVAILABLE");
        b.put(-4, "ERROR_INVALID_REQUEST");
        b.put(-5, "ERROR_INSTALL_UNAVAILABLE");
        b.put(-6, "ERROR_INSTALL_NOT_ALLOWED");
        b.put(-7, "ERROR_DOWNLOAD_NOT_PRESENT");
        b.put(-8, "ERROR_INSTALL_IN_PROGRESS");
        b.put(-100, "ERROR_INTERNAL_ERROR");
        b.put(-9, "ERROR_PLAY_STORE_NOT_FOUND");
    }

    public static String a(@InstallErrorCode int i) {
        Map<Integer, String> map = f3740a;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf) || !b.containsKey(valueOf)) {
            return "";
        }
        String str = f3740a.get(valueOf);
        String str2 = b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 103 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/install/model/InstallErrorCode#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}
