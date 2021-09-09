package com.mijia.camera;

import _m_j.oOOO00o0;
import android.content.Context;

public class MediaRemuxing {
    private static native int native_remuxing(String str, String str2);

    static {
        System.loadLibrary("media_remuxing");
    }

    public static int remuxing(Context context, String str, String str2) {
        if (oOOO00o0.O000000o(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            return 1;
        }
        return native_remuxing(str, str2);
    }
}
