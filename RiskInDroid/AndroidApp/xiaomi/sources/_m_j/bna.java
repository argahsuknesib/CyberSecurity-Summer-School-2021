package _m_j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class bna {
    public static Object O000000o(Object obj, String str) {
        return O000000o(obj, O000000o(obj.getClass(), str, (Class[]) null), new Object[0]);
    }

    public static Object O000000o(Object obj, String str, Class[] clsArr, Object[] objArr) {
        return O000000o(obj, O000000o(obj.getClass(), str, clsArr), objArr);
    }

    private static Object O000000o(Object obj, Field field) {
        field.setAccessible(true);
        return field.get(obj);
    }

    private static Object O000000o(Object obj, Method method, Object... objArr) {
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }

    public static Object O000000o(String str, String str2) {
        return O000000o((Object) null, O000000o(Class.forName(str), str2, (Class[]) null), new Object[0]);
    }

    public static Object O000000o(String str, String str2, Class[] clsArr, Object[] objArr) {
        return O000000o((Object) null, O000000o(Class.forName(str), str2, clsArr), objArr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bna.O000000o(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
     arg types: [java.lang.Class<? super ?>, java.lang.String]
     candidates:
      _m_j.bna.O000000o(java.lang.Object, java.lang.String):java.lang.Object
      _m_j.bna.O000000o(java.lang.Object, java.lang.reflect.Field):java.lang.Object
      _m_j.bna.O000000o(java.lang.String, java.lang.String):java.lang.Object
      _m_j.bna.O000000o(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:2|3|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return r2.getDeclaredField(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r2.getSuperclass() != null) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return O000000o((java.lang.Class<?>) r2.getSuperclass(), r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    private static Field O000000o(Class<?> cls, String str) {
        return cls.getField(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:2|3|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return r2.getDeclaredMethod(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r2.getSuperclass() != null) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return O000000o(r2.getSuperclass(), r3, r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    private static Method O000000o(Class<?> cls, String str, Class[] clsArr) {
        return cls.getMethod(str, clsArr);
    }

    public static Object O00000Oo(Object obj, String str) {
        return O000000o(obj, O000000o(obj.getClass(), str));
    }
}
