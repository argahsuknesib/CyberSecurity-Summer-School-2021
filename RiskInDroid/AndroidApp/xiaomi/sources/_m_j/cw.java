package _m_j;

import android.os.Build;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class cw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Method f14385O000000o;
    private static boolean O00000Oo;
    private static boolean O00000o;
    private static Field O00000o0;

    public static void O000000o(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!O00000o) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    O00000o0 = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                O00000o = true;
            }
            Field field = O00000o0;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }

    public static void O000000o(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!O00000Oo) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f14385O000000o = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            O00000Oo = true;
        }
        Method method = f14385O000000o;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception unused2) {
            }
        }
    }
}
