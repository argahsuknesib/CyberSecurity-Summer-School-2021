package com.xiaomi.smarthome.fastvideo.decoder;

import android.os.Build;

public class Util {
    public static final String DEVICE = Build.DEVICE;
    public static final String DEVICE_DEBUG_INFO = (DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT);
    public static final String MANUFACTURER = Build.MANUFACTURER;
    public static final String MODEL = Build.MODEL;
    public static final int SDK_INT = ((Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT);
}
