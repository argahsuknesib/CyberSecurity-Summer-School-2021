package _m_j;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(19)
public final class ico {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1193O000000o = false;

    public static void O000000o(Window window) {
        if (window != null) {
            boolean z = !gku.O000000o(window.getContext());
            boolean z2 = false;
            if (!Build.BRAND.equalsIgnoreCase("htc") || !Build.MODEL.contains("M8w")) {
                if (Build.VERSION.SDK_INT < 19 || !grr.O00000oO() || !O00000Oo(window, z)) {
                    if (Build.VERSION.SDK_INT >= 19 && O000000o(window, z)) {
                        window.setFlags(67108864, 67108864);
                    } else if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                        window.addFlags(67108864);
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        window.clearFlags(67108864);
                        if (Build.VERSION.SDK_INT < 23 || !z) {
                            window.getDecorView().setSystemUiVisibility(1280);
                        } else {
                            window.getDecorView().setSystemUiVisibility(9472);
                        }
                        window.addFlags(Integer.MIN_VALUE);
                        if (!z || (!Build.BRAND.equalsIgnoreCase("oppo") && !Build.BRAND.equalsIgnoreCase("vivo"))) {
                            window.setStatusBarColor(0);
                        } else {
                            window.setStatusBarColor(33554431);
                        }
                    }
                } else if (z) {
                    window.setFlags(67108864, 67108864);
                    window.addFlags(Integer.MIN_VALUE);
                    window.getDecorView().setSystemUiVisibility(8192);
                } else {
                    window.setFlags(67108864, 67108864);
                    window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & -8193);
                }
                z2 = true;
            }
            f1193O000000o = z2;
        }
    }

    public static void O000000o(View view) {
        if (view != null) {
            int O000000o2 = hzf.O000000o(view.getContext());
            if (f1193O000000o && view != null) {
                if (view.getLayoutParams().height >= 0) {
                    view.getLayoutParams().height += O000000o2;
                }
                view.setPadding(0, O000000o2, 0, 0);
                view.setLayoutParams(view.getLayoutParams());
            }
        }
    }

    private static boolean O000000o(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (i ^ -1) & i2);
            window.setAttributes(attributes);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean O00000Oo(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                int i3 = i2 | i;
                method.invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
            } else {
                method.invoke(window, Integer.valueOf(i), Integer.valueOf(i2 | i));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
