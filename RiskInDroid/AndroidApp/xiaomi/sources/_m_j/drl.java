package _m_j;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class drl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f14873O000000o = "drl";
    private static final Object[] O00000Oo = new Object[0];
    private static final Object[] O00000o = new Object[2];
    private static final Object[] O00000o0 = new Object[1];
    private static final Object[] O00000oO = new Object[3];
    private static final Object[] O00000oo = new Object[4];

    private drl() {
    }

    public static Class<?> O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Method O000000o(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException | SecurityException unused) {
            }
        }
        return null;
    }

    public static Method O00000Oo(Class<?> cls, String str, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    private static Object O000000o(Object obj, Object obj2, Method method, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            Log.e(f14873O000000o, "Exception in invoke", e);
            return null;
        }
    }

    public static Field O000000o(Class<?> cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void O000000o(Object obj, Field field, Object obj2) {
        if (field != null) {
            try {
                field.set(obj, obj2);
            } catch (Exception e) {
                Log.e(f14873O000000o, "Exception in setFieldValue", e);
            }
        }
    }

    public static Object O000000o(Field field) {
        if (field == null) {
            return null;
        }
        try {
            return field.get(null);
        } catch (Exception e) {
            Log.e(f14873O000000o, "Exception in getFieldValue", e);
            return null;
        }
    }

    public static Object O000000o(Object obj, Method method) {
        return O000000o(obj, null, method, O00000Oo);
    }

    public static Object O000000o(Object obj, Method method, Object obj2) {
        Object[] objArr = O00000o0;
        objArr[0] = obj2;
        Object O000000o2 = O000000o(obj, null, method, objArr);
        O00000o0[0] = null;
        return O000000o2;
    }

    public static Object O000000o(Object obj, Method method, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = O00000oo;
        objArr[0] = obj2;
        objArr[1] = obj3;
        objArr[2] = obj4;
        objArr[3] = obj5;
        Object O000000o2 = O000000o(obj, null, method, objArr);
        Object[] objArr2 = O00000oo;
        objArr2[0] = null;
        objArr2[1] = null;
        objArr2[2] = null;
        objArr2[3] = null;
        return O000000o2;
    }
}
