package com.google.android.play.core.splitinstall.model;

import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, String> f3822a = new HashMap();
    private static final Map<Integer, String> b = new HashMap();

    static {
        f3822a.put(-1, "Too many sessions are running for current app, existing sessions must be resolved first.");
        f3822a.put(-2, "A requested module is not available (to this user/device, for the installed apk).");
        f3822a.put(-3, "Request is otherwise invalid.");
        f3822a.put(-4, "Requested session is not found.");
        f3822a.put(-5, "Split Install API is not available.");
        f3822a.put(-6, "Network error: unable to obtain split details.");
        f3822a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f3822a.put(-8, "Requested session contains modules from an existing active session and also new");
        f3822a.put(-9, "Service handling split install has died.");
        f3822a.put(-10, "Install failed due to insufficient storage.");
        f3822a.put(-11, "Signature verification error when invoking SplitCompat.");
        f3822a.put(-12, "Error in SplitCompat emulation.");
        f3822a.put(-13, "Error in copying files for SplitCompat.");
        f3822a.put(-100, "Unknown error processing split install.");
        b.put(-1, "ACTIVE_SESSIONS_LIMIT_EXCEEDED");
        b.put(-2, "MODULE_UNAVAILABLE");
        b.put(-3, "INVALID_REQUEST");
        b.put(-4, "DOWNLOAD_NOT_FOUND");
        b.put(-5, "API_NOT_AVAILABLE");
        b.put(-6, "NETWORK_ERROR");
        b.put(-7, "ACCESS_DENIED");
        b.put(-8, "INCOMPATIBLE_WITH_EXISTING_SESSION");
        b.put(-9, "SERVICE_DIED");
        b.put(-10, "INSUFFICIENT_STORAGE");
        b.put(-11, "SPLITCOMPAT_VERIFICATION_ERROR");
        b.put(-12, "SPLITCOMPAT_EMULATION_ERROR");
        b.put(-13, "SPLITCOMPAT_COPY_ERROR");
        b.put(-14, "PLAY_STORE_NOT_FOUND");
    }

    public static String a(@SplitInstallErrorCode int i) {
        Map<Integer, String> map = f3822a;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf) || !b.containsKey(valueOf)) {
            return "";
        }
        String str = f3822a.get(valueOf);
        String str2 = b.get(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 118 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" (https://developer.android.com/reference/com/google/android/play/core/splitinstall/model/SplitInstallErrorCode.html#");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}
