package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class hx {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Method f934O000000o;
    private static Method O00000Oo;
    private static boolean O00000o0;

    @SuppressLint({"SoonBlockedPrivateApi"})
    static void O000000o(Canvas canvas, boolean z) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (z) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        } else if (Build.VERSION.SDK_INT != 28) {
            if (!O00000o0) {
                try {
                    Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    f934O000000o = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    O00000Oo = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                O00000o0 = true;
            }
            if (z) {
                try {
                    if (f934O000000o != null) {
                        f934O000000o.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
            if (!z && O00000Oo != null) {
                O00000Oo.invoke(canvas, new Object[0]);
            }
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }
}
