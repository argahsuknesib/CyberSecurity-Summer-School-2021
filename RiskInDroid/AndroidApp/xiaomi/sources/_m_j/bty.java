package _m_j;

import java.lang.reflect.Method;

public final class bty {
    private static Object O000000o(Object obj, Class<?> cls, String str, Object... objArr) throws Exception {
        Class<Double>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
            if (clsArr[i] == Boolean.class) {
                clsArr[i] = Boolean.TYPE;
            }
            if (clsArr[i] == Double.class) {
                clsArr[i] = Double.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object O000000o(Object obj, String str, Object... objArr) {
        try {
            return O000000o(obj, obj.getClass(), str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
