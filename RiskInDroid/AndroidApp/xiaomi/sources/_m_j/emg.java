package _m_j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class emg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f15626O000000o;

    public static class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Class<? extends T> f15627O000000o;
        public final T O00000Oo;
    }

    static {
        HashMap hashMap = new HashMap();
        f15626O000000o = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        f15626O000000o.put(Byte.class, Byte.TYPE);
        f15626O000000o.put(Character.class, Character.TYPE);
        f15626O000000o.put(Short.class, Short.TYPE);
        f15626O000000o.put(Integer.class, Integer.TYPE);
        f15626O000000o.put(Float.class, Float.TYPE);
        f15626O000000o.put(Long.class, Long.TYPE);
        f15626O000000o.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = f15626O000000o;
        Class cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = f15626O000000o;
        Class cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = f15626O000000o;
        Class cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = f15626O000000o;
        Class cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = f15626O000000o;
        Class cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = f15626O000000o;
        Class cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = f15626O000000o;
        Class cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = f15626O000000o;
        Class cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:15:0x0010 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x0010 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:14:0x0010 */
    private static <T> T O000000o(Class<? extends Object> cls, Object obj, String str) {
        Field field = null;
        Class<? extends Object> cls2 = cls;
        while (field == null) {
            try {
                field = cls2.getDeclaredField(str);
                field.setAccessible(true);
                continue;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
                continue;
            }
            if (cls2 == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return field.get(obj);
    }

    public static <T> T O000000o(Class<? extends Object> cls, String str) {
        try {
            return O000000o(cls, (Object) null, str);
        } catch (Exception e) {
            gsy.O000000o(5, "JavaCalls", "Meet exception when call getStaticField '" + str + "' in " + cls.getSimpleName() + ", " + e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
     arg types: [java.lang.Class<?>, java.lang.Object, java.lang.String]
     candidates:
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T */
    public static <T> T O000000o(Object obj, String str) {
        try {
            return O000000o((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (Exception e) {
            gsy.O000000o(5, "JavaCalls", "Meet exception when call getField '" + str + "' in " + obj + ", " + e);
            return null;
        }
    }

    public static <T> T O000000o(Object obj, String str, Object... objArr) {
        try {
            return O00000Oo(obj, str, objArr);
        } catch (Exception e) {
            gsy.O000000o(5, "JavaCalls", "Meet exception when call Method '" + str + "' in " + obj + ", " + e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
     arg types: [java.lang.Class<?>, ?[OBJECT, ARRAY], java.lang.String]
     candidates:
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T */
    public static <T> T O000000o(String str, String str2) {
        try {
            return O000000o((Class<? extends Object>) esu.O000000o(null, str), (Object) null, str2);
        } catch (Exception e) {
            gsy.O000000o(5, "JavaCalls", "Meet exception when call getStaticField '" + str2 + "' in " + str + ", " + e);
            return null;
        }
    }

    private static Method O000000o(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method O000000o2 = O000000o(cls.getDeclaredMethods(), str, clsArr);
            if (O000000o2 != null) {
                O000000o2.setAccessible(true);
                return O000000o2;
            } else if (cls.getSuperclass() != null) {
                cls = cls.getSuperclass();
            } else {
                throw new NoSuchMethodException();
            }
        }
    }

    private static Method O000000o(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && O000000o(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    private static boolean O000000o(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr2[i] != null && !clsArr[i].isAssignableFrom(clsArr2[i]) && (!f15626O000000o.containsKey(clsArr[i]) || !f15626O000000o.get(clsArr[i]).equals(f15626O000000o.get(clsArr2[i])))) {
                return false;
            }
        }
        return true;
    }

    private static Class<?>[] O000000o(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = (obj == null || !(obj instanceof O000000o)) ? obj == null ? null : obj.getClass() : ((O000000o) obj).f15627O000000o;
        }
        return clsArr;
    }

    public static <T> T O00000Oo(Object obj, String str, Object... objArr) {
        return O000000o(obj.getClass(), str, O000000o(objArr)).invoke(obj, O00000Oo(objArr));
    }

    private static Object[] O00000Oo(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof O000000o)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((O000000o) obj).O00000Oo;
            }
        }
        return objArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0 = r0.getSuperclass();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000c */
    public static void O000000o(Object obj, String str, Object obj2) {
        try {
            Class<?> cls = obj.getClass();
            Field field = null;
            while (field == null) {
                field = cls.getDeclaredField(str);
                if (cls == null) {
                    throw new NoSuchFieldException();
                }
            }
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception e) {
            gsy.O000000o(5, "JavaCalls", "Meet exception when call setField '" + str + "' in " + obj + ", " + e);
        }
    }

    public static <T> T O000000o(String str, String str2, Object... objArr) {
        try {
            return O000000o(esu.O000000o(null, str), str2, O000000o(objArr)).invoke(null, O00000Oo(objArr));
        } catch (Exception e) {
            gsy.O000000o(5, "JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str + ", " + e);
            return null;
        }
    }
}
