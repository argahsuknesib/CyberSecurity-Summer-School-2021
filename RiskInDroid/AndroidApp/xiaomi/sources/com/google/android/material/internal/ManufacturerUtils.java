package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

public class ManufacturerUtils {
    private ManufacturerUtils() {
    }

    public static boolean isMeizuDevice() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
    }

    public static boolean isLGEDevice() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
    }

    public static boolean isSamsungDevice() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
    }

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        return isLGEDevice() || isSamsungDevice();
    }
}
