package _m_j;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class id implements ib {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Class<?> f1205O000000o;
    public static Method O00000Oo;
    private static boolean O00000o;
    public static boolean O00000o0;
    private static Method O00000oO;
    private static boolean O00000oo;
    private final View O0000O0o;

    public final void O000000o(ViewGroup viewGroup, View view) {
    }

    private id(View view) {
        this.O0000O0o = view;
    }

    public final void setVisibility(int i) {
        this.O0000O0o.setVisibility(i);
    }

    public static void O000000o() {
        if (!O00000o) {
            try {
                f1205O000000o = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e);
            }
            O00000o = true;
        }
    }

    public static ib O000000o(View view, ViewGroup viewGroup, Matrix matrix) {
        if (!O00000oo) {
            try {
                O000000o();
                Method declaredMethod = f1205O000000o.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                O00000oO = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e);
            }
            O00000oo = true;
        }
        Method method = O00000oO;
        if (method != null) {
            try {
                return new id((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }
}
