package com.xiaomi.onetrack.h;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.preference.PreferenceManager;

public class k {
    private k() {
    }

    public static Context a(Context context) {
        if (e(context)) {
            q.a("FbeUtil", "getSafeContext return origin ctx");
            return context;
        }
        q.a("FbeUtil", "getSafeContext , create the safe ctx");
        return context.createDeviceProtectedStorageContext();
    }

    public static boolean a() {
        try {
            return ((Boolean) StorageManager.class.getDeclaredMethod("isFileEncryptedNativeOrEmulated", new Class[0]).invoke(null, new Object[0]).getClass().getDeclaredMethod("isFileEncryptedNativeOrEmulated", Boolean.TYPE).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            q.b("FbeUtil", "*** ".concat(String.valueOf(e)));
            return false;
        }
    }

    public static void a(PreferenceManager preferenceManager) {
        boolean z = true;
        boolean z2 = Build.VERSION.SDK_INT == 24 && a();
        boolean z3 = Build.VERSION.SDK_INT == 25 && a();
        if (Build.VERSION.SDK_INT <= 25) {
            z = false;
        }
        if (z2 || z3 || z) {
            preferenceManager.setStorageDeviceProtected();
        }
    }

    public static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (!a() || keyguardManager == null || !keyguardManager.isKeyguardSecure()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean c(Context context) {
        if (Build.VERSION.SDK_INT < 24 || !b(context) || e(context)) {
            return false;
        }
        return true;
    }

    public static boolean d(Context context) {
        return Build.VERSION.SDK_INT >= 24 && !e(context);
    }

    private static boolean e(Context context) {
        UserManager userManager;
        if (Build.VERSION.SDK_INT < 24 || (userManager = (UserManager) context.getSystemService("user")) == null || !userManager.isUserUnlocked()) {
            return false;
        }
        return true;
    }

    private static boolean f(Context context) {
        return (Build.VERSION.SDK_INT == 24 || Build.VERSION.SDK_INT == 25) ? context.isDeviceProtectedStorage() || !a() : Build.VERSION.SDK_INT <= 25;
    }
}
