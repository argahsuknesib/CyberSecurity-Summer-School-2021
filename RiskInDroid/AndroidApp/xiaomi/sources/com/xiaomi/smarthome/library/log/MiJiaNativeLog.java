package com.xiaomi.smarthome.library.log;

import _m_j.gsy;
import androidx.annotation.Keep;

@Keep
public class MiJiaNativeLog {
    public static void logNativeCamera(String str, String str2) {
        gsy.O00000o0(LogType.NATIVE_CAMERA, str, str2);
    }

    public static void logNativeMiss(String str, String str2) {
        gsy.O00000o0(LogType.NATIVE_MISS, str, str2);
    }

    public static void logNativeGeneral(String str, String str2) {
        gsy.O00000o0(LogType.NATIVE_GENERAL, str, str2);
    }
}
