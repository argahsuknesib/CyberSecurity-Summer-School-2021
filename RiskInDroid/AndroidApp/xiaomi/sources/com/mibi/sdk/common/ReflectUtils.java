package com.mibi.sdk.common;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtils {
    private ReflectUtils() {
    }

    public static Class<?> getClassFromName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            Log.e("ReflectUtils", "getClassFromName:".concat(String.valueOf(str)), e);
            return null;
        }
    }

    public static Field getFiled(Class<?> cls, String str) {
        Field field;
        try {
            field = cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Log.e("ReflectUtils", "getFiled:".concat(String.valueOf(str)), e);
            field = null;
        }
        if (field != null) {
            field.setAccessible(true);
        }
        return field;
    }

    public static <T> T getMember(Class<?> cls, Object obj, String str) {
        Field filed = getFiled(cls, str);
        if (filed == null) {
            return null;
        }
        try {
            return filed.get(obj);
        } catch (Exception e) {
            Log.e("ReflectUtils", "getMember:".concat(String.valueOf(str)), e);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        try {
            method = cls.getDeclaredMethod(str, clsArr);
        } catch (Exception e) {
            Log.e("ReflectUtils", "getMethod:".concat(String.valueOf(str)), e);
            method = null;
        }
        if (method != null) {
            method.setAccessible(true);
        }
        return method;
    }

    public static boolean isMethodExist(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            cls.getDeclaredMethod(str, clsArr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T> T invoke(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            Log.e("ReflectUtils", "invoke error", e);
            return null;
        }
    }
}
