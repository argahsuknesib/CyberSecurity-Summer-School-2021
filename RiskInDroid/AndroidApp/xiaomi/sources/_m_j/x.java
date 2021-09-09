package _m_j;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class x extends w {
    /* access modifiers changed from: protected */
    public final Typeface O000000o(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2567O000000o, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.O0000O0o.invoke(null, newInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final Method O000000o(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
