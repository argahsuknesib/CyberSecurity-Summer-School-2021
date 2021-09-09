package com.xiaomi.accountsdk.utils;

import android.annotation.SuppressLint;
import java.lang.reflect.InvocationTargetException;

@SuppressLint({"NewApi"})
public class SystemPropertiesHelper {
    public static final boolean IS_SYSTEM_DEBUGGABLE;

    static {
        boolean z = false;
        try {
            if (SystemPropertiesReflection.getInt("ro.debuggable", 0) == 1) {
                z = true;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            AccountLog.w("SystemPropertiesHelper", e);
        }
        IS_SYSTEM_DEBUGGABLE = z;
    }

    private SystemPropertiesHelper() {
    }
}
