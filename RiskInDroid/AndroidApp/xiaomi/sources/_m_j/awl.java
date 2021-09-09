package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class awl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Method f12665O000000o;
    private static Method O00000Oo;
    private static int O00000o;
    private static Field O00000o0;

    static {
        Class<Activity> cls = Activity.class;
        try {
            f12665O000000o = cls.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        Class<Activity> cls2 = Activity.class;
        try {
            O00000Oo = cls2.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            O00000o0 = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            O00000o = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.awl.O000000o(android.view.View, boolean):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.awl.O000000o(android.app.Activity, int):void
      _m_j.awl.O000000o(android.app.Activity, boolean):void
      _m_j.awl.O000000o(android.view.Window, int):void
      _m_j.awl.O000000o(android.view.Window, boolean):void
      _m_j.awl.O000000o(android.view.View, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.awl.O000000o(android.app.Activity, boolean, boolean):void
     arg types: [android.app.Activity, boolean, int]
     candidates:
      _m_j.awl.O000000o(android.view.Window, java.lang.String, boolean):void
      _m_j.awl.O000000o(android.view.WindowManager$LayoutParams, java.lang.String, boolean):boolean
      _m_j.awl.O000000o(android.app.Activity, boolean, boolean):void */
    public static void O000000o(Activity activity, int i) {
        Method method = f12665O000000o;
        boolean z = false;
        if (method != null) {
            try {
                method.invoke(activity, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else {
            if (((((((16711680 & i) >> 16) * 38) + (((65280 & i) >> 8) * 75)) + ((i & 255) * 15)) >> 7) < 50) {
                z = true;
            }
            if (O00000o0 != null) {
                O000000o(activity, z, z);
                Window window = activity.getWindow();
                try {
                    O000000o(window, i);
                    if (Build.VERSION.SDK_INT > 22) {
                        O000000o(window.getDecorView(), true);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else {
                O000000o(activity, z, true);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.awl.O000000o(android.app.Activity, boolean, boolean):void
     arg types: [android.app.Activity, boolean, int]
     candidates:
      _m_j.awl.O000000o(android.view.Window, java.lang.String, boolean):void
      _m_j.awl.O000000o(android.view.WindowManager$LayoutParams, java.lang.String, boolean):boolean
      _m_j.awl.O000000o(android.app.Activity, boolean, boolean):void */
    public static void O000000o(Activity activity, boolean z) {
        O000000o(activity, z, true);
    }

    private static boolean O000000o(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(layoutParams);
            int i3 = z ? i | i2 : (i ^ -1) & i2;
            if (i2 == i3) {
                return false;
            }
            declaredField2.setInt(layoutParams, i3);
            return true;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static void O000000o(View view, boolean z) {
        int i;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i = O00000o | systemUiVisibility;
        } else {
            i = (O00000o ^ -1) & systemUiVisibility;
        }
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    private static void O000000o(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = O00000o0;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i) {
                    O00000o0.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void O000000o(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            O000000o(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
            return;
        }
        O000000o(window.getDecorView(), z);
        O000000o(window, 0);
    }

    private static void O000000o(Activity activity, boolean z, boolean z2) {
        Method method = O00000Oo;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else if (z2) {
            O000000o(activity.getWindow(), z);
        }
    }

    @SuppressLint({"PrivateApi"})
    static void O000000o(Window window, String str, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField(str).getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                    return;
                }
                method.invoke(window, 0, Integer.valueOf(i));
            } catch (Exception unused) {
            }
        }
    }
}
