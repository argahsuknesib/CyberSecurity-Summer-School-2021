package _m_j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class bwd {
    public static Object O000000o(Object obj, Class<?> cls, String str, Object... objArr) throws Exception {
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

    public static Object O000000o(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    public static Object O000000o(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(null, objArr);
    }

    public static int O00000Oo(Object obj, String str, Object... objArr) throws Exception {
        return ((Integer) O000000o(obj, str, objArr)).intValue();
    }

    public static int O00000Oo(String str, String str2) throws Exception {
        return ((Integer) O000000o(str, str2)).intValue();
    }
}
