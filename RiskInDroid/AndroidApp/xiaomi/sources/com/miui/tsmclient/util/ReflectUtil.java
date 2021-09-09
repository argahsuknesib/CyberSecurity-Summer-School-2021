package com.miui.tsmclient.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtil {
    private ReflectUtil() {
    }

    public static Object callObjectMethod(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static Class<?> getClassFromName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            LogUtils.w("ClassNotFoundException className:".concat(String.valueOf(str)));
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
            try {
                method.setAccessible(true);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            method = null;
            LogUtils.e("getMethod: ".concat(String.valueOf(str)), e);
            return method;
        }
        return method;
    }

    public static Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        Class<?> classFromName = getClassFromName(str);
        if (classFromName != null) {
            return newInstance(classFromName, clsArr, objArr);
        }
        return null;
    }

    public static Object newInstance(Class<?> cls, Class<?>[] clsArr, Object... objArr) {
        try {
            return cls.getConstructor(clsArr).newInstance(objArr);
        } catch (Exception e) {
            LogUtils.e("newInstance failed", e);
            return null;
        }
    }

    public static Object invoke(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            LogUtils.e("invoke error", e);
            return null;
        }
    }
}
