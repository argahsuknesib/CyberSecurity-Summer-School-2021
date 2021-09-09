package _m_j;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class fdb {
    public static <T> T O000000o(Class cls, Object... objArr) {
        if (cls != null) {
            try {
                int length = objArr.length;
                Class[] clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
                Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objArr);
            } catch (Throwable th) {
                Log.e("ReflectUtils", "fatal getInstance", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("className 不能为空");
        }
    }

    public static Object O000000o(String str, Object obj, String str2, Object... objArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        } else if (!str2.equals("")) {
            try {
                Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, new Class[0]);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throw new IllegalArgumentException("methodName不能为空");
        }
    }

    public static Object O000000o(Method method, Object... objArr) {
        if (method != null) {
            method.setAccessible(true);
            try {
                return method.invoke(null, objArr);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throw new IllegalArgumentException("method 不能为空");
        }
    }

    public static void O000000o(String str, Object obj, String str2, Object obj2) {
        if (str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        } else if (!str2.equals("")) {
            try {
                Field declaredField = Class.forName(str).getDeclaredField(str2);
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("fieldName 不能为空");
        }
    }

    public static void O000000o(Object obj, String str, Object obj2) {
        String name = obj.getClass().getName();
        if (!str.equals("")) {
            try {
                Field declaredField = Class.forName(name).getDeclaredField(str);
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("fieldName 不能为空");
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000e */
    public static Method O000000o(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        while (cls != null) {
            method = cls.getDeclaredMethod(str, clsArr);
            method.setAccessible(true);
            try {
                cls = cls.getSuperclass();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return method;
    }
}
