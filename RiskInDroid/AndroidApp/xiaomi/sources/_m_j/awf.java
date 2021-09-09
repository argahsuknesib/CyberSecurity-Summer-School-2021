package _m_j;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import java.lang.reflect.InvocationTargetException;

public final class awf {
    static DisplayCutout O000000o(Activity activity) {
        Window window;
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || activity == null || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0041 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0042 A[RETURN] */
    static boolean O000000o(Context context) {
        int i;
        if ("Xiaomi".equals(Build.MANUFACTURER)) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                i = ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            return i != 1;
        }
        i = 0;
        if (i != 1) {
        }
    }

    static boolean O00000Oo(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    static boolean O00000o0(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    static boolean O00000o(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception unused) {
            return false;
        }
    }

    static int[] O00000oO(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return iArr;
        }
    }
}
