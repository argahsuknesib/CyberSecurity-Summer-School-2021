package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class icm {
    private static boolean O00000o0(Context context) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(context)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean O000000o(Context context) {
        boolean z = false;
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            boolean booleanValue = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return booleanValue;
            } catch (Exception e) {
                Exception exc = e;
                z = booleanValue;
                e = exc;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return z;
        }
    }

    public static void O00000Oo(Context context) {
        if (Build.VERSION.SDK_INT == 26 && O000000o(context)) {
            O00000o0(context);
        }
    }
}
