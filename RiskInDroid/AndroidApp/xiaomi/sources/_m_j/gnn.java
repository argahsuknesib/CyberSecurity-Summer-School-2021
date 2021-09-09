package _m_j;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;

public final class gnn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final boolean f18048O000000o = (Build.VERSION.SDK_INT >= 11);
    public static final boolean O00000Oo = (Build.VERSION.SDK_INT >= 27);
    public static final boolean O00000o = (Build.VERSION.SDK_INT > 10);
    public static final boolean O00000o0 = (Build.VERSION.SDK_INT >= 26);
    public static final boolean O00000oO = (Build.VERSION.SDK_INT >= 23);
    public static final boolean O00000oo = (Build.VERSION.SDK_INT >= 24);
    public static final boolean O0000O0o = (Build.VERSION.SDK_INT >= 11);
    public static final boolean O0000OOo = (Build.VERSION.SDK_INT >= 13);
    public static final boolean O0000Oo = (Build.VERSION.SDK_INT >= 16 && O000000o(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE"));
    public static final boolean O0000Oo0 = (Build.VERSION.SDK_INT >= 17);
    public static final boolean O0000OoO = (Build.VERSION.SDK_INT >= 14 ? O000000o(MediaStore.MediaColumns.class, "WIDTH") : false);
    public static final boolean O0000Ooo = (Build.VERSION.SDK_INT >= 15 ? O000000o("android.graphics.SurfaceTexture", "setDefaultBufferSize", Integer.TYPE, Integer.TYPE) : false);
    public static final boolean O0000o = (Runtime.getRuntime().availableProcessors() > 1);
    public static final boolean O0000o0 = (Build.VERSION.SDK_INT >= 11 ? O000000o(View.class, "setSystemUiVisibility", Integer.TYPE) : false);
    public static final boolean O0000o00 = (Build.VERSION.SDK_INT >= 14 ? O000000o("android.graphics.SurfaceTexture", "release", new Class[0]) : false);
    public static final boolean O0000o0O = (Build.VERSION.SDK_INT >= 9 ? O000000o(SharedPreferences.Editor.class, "apply", (Class<?>[]) null) : false);
    public static final boolean O0000o0o = (Build.VERSION.SDK_INT >= 14 ? O000000o(DevicePolicyManager.class, "getCameraDisabled", ComponentName.class) : false);
    public static final boolean O0000oO0;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 13) {
            z = false;
        }
        O0000oO0 = z;
    }

    private static boolean O000000o(Class<?> cls, String str) {
        try {
            cls.getDeclaredField(str);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    private static boolean O000000o(String str, String str2, Class<?>... clsArr) {
        try {
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean O000000o(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            cls.getDeclaredMethod(str, clsArr);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }
}
