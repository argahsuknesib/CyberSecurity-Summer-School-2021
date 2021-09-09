package _m_j;

import android.app.Instrumentation;
import com.xiaomi.miot.support.monitor.core.activity.ApmInstrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class dyd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f15061O000000o = false;

    public static boolean O00000Oo() {
        return f15061O000000o;
    }

    public static void O000000o() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            boolean isAccessible = declaredMethod.isAccessible();
            if (!isAccessible) {
                declaredMethod.setAccessible(true);
            }
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!isAccessible) {
                declaredMethod.setAccessible(isAccessible);
            }
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            boolean isAccessible2 = declaredField.isAccessible();
            if (!isAccessible2) {
                declaredField.setAccessible(true);
            }
            declaredField.set(invoke, new ApmInstrumentation((Instrumentation) declaredField.get(invoke)));
            if (!isAccessible2) {
                declaredField.setAccessible(isAccessible2);
            }
            f15061O000000o = true;
        } catch (Exception unused) {
        }
    }
}
