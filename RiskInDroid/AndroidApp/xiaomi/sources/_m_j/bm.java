package _m_j;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public final class bm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Field f13084O000000o;
    private static boolean O00000Oo;

    private static void O00000Oo(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!O00000Oo) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f13084O000000o = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            O00000Oo = true;
        }
        Field field = f13084O000000o;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void O000000o(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                O00000Oo(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                O00000Oo(layoutInflater, factory2);
            }
        }
    }
}
