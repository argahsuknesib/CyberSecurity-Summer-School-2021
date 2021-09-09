package _m_j;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public final class asw {
    public static List<Class<?>> O000000o(Class<?> cls, Class<?> cls2) {
        return O000000o(cls, cls2, new ArrayList(8));
    }

    public static List<Class<?>> O000000o(Class<?> cls, Class<?> cls2, List<Class<?>> list) {
        O000000o(cls, cls2, list, false);
        return list;
    }

    private static void O000000o(Class<?> cls, Class<?> cls2, Collection<Class<?>> collection, boolean z) {
        while (cls != cls2 && cls != null && cls != Object.class) {
            if (z) {
                if (!collection.contains(cls)) {
                    collection.add(cls);
                } else {
                    return;
                }
            }
            for (Class<?> O000000o2 : cls.getInterfaces()) {
                O000000o(O000000o2, cls2, collection, true);
            }
            cls = cls.getSuperclass();
            z = true;
        }
    }

    public static String O000000o(Class<?> cls) {
        if (cls.isAnnotation()) {
            return "annotation";
        }
        if (cls.isArray()) {
            return "array";
        }
        if (cls.isEnum()) {
            return "enum";
        }
        if (cls.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static String O00000Oo(Class<?> cls) {
        try {
            if (cls.getEnclosingMethod() != null) {
                return "local/anonymous";
            }
            return null;
        } catch (NullPointerException | SecurityException unused) {
            return null;
        }
    }

    public static Class<?> O00000o0(Class<?> cls) {
        try {
            if (cls.getEnclosingMethod() == null && !Modifier.isStatic(cls.getModifiers())) {
                return cls.getEnclosingClass();
            }
        } catch (NullPointerException | SecurityException unused) {
        }
        return null;
    }

    public static boolean O00000o(Class<?> cls) {
        if (Proxy.isProxyClass(cls)) {
            return true;
        }
        String name = cls.getName();
        if (name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.")) {
            return true;
        }
        return false;
    }

    public static boolean O00000oO(Class<?> cls) {
        if (!cls.isArray() && !Collection.class.isAssignableFrom(cls) && !Map.class.isAssignableFrom(cls)) {
            return false;
        }
        return true;
    }

    public static Class<?> O000000o(String str) throws ClassNotFoundException {
        if (str.indexOf(46) < 0) {
            if ("int".equals(str)) {
                return Integer.TYPE;
            }
            if ("long".equals(str)) {
                return Long.TYPE;
            }
            if ("float".equals(str)) {
                return Float.TYPE;
            }
            if ("double".equals(str)) {
                return Double.TYPE;
            }
            if ("boolean".equals(str)) {
                return Boolean.TYPE;
            }
            if ("byte".equals(str)) {
                return Byte.TYPE;
            }
            if ("char".equals(str)) {
                return Character.TYPE;
            }
            if ("short".equals(str)) {
                return Short.TYPE;
            }
            if ("void".equals(str)) {
                return Void.TYPE;
            }
        }
        Throwable th = null;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Exception e) {
                th = O000000o((Throwable) e);
            }
        }
        try {
            return Class.forName(str);
        } catch (Exception e2) {
            if (th == null) {
                th = O000000o((Throwable) e2);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw new ClassNotFoundException(th.getMessage(), th);
        }
    }

    public static Throwable O000000o(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public static void O00000Oo(Throwable th) {
        O00000Oo(th, th.getMessage());
    }

    private static void O00000Oo(Throwable th, String str) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else {
            throw new IllegalArgumentException(str, th);
        }
    }

    public static void O000000o(Throwable th, String str) {
        O00000Oo(O000000o(th), str);
    }

    public static <T> T O000000o(Class cls, boolean z) throws IllegalArgumentException {
        Constructor O00000Oo = O00000Oo(cls, z);
        if (O00000Oo != null) {
            try {
                return O00000Oo.newInstance(new Object[0]);
            } catch (Exception e) {
                O000000o(e, "Failed to instantiate class " + cls.getName() + ", problem: " + e.getMessage());
                return null;
            }
        } else {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
    }

    private static <T> Constructor<T> O00000Oo(Class<T> cls, boolean z) throws IllegalArgumentException {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (z) {
                O000000o((Member) declaredConstructor);
            } else if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: can not instantiate type");
            }
            return declaredConstructor;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (Exception e) {
            O000000o(e, "Failed to find default constructor of class " + cls.getName() + ", problem: " + e.getMessage());
            return null;
        }
    }

    public static void O000000o(Member member) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            if (!accessibleObject.isAccessible()) {
                Class<?> declaringClass = member.getDeclaringClass();
                throw new IllegalArgumentException("Can not access " + member + " (from class " + declaringClass.getName() + "; failed to set access: " + e.getMessage());
            }
        }
    }

    public static Class<? extends Enum<?>> O000000o(EnumSet<?> enumSet) {
        if (!enumSet.isEmpty()) {
            return O000000o((Enum<?>) ((Enum) enumSet.iterator().next()));
        }
        return O000000o.f12577O000000o.O000000o(enumSet);
    }

    public static Class<? extends Enum<?>> O000000o(EnumMap<?, ?> enumMap) {
        if (!enumMap.isEmpty()) {
            return O000000o((Enum<?>) ((Enum) enumMap.keySet().iterator().next()));
        }
        return O000000o.f12577O000000o.O000000o(enumMap);
    }

    private static Class<? extends Enum<?>> O000000o(Enum<?> enumR) {
        Class cls = enumR.getClass();
        return cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Class<?>, java.lang.Class<? extends java.lang.Enum<?>>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static Class<? extends Enum<?>> O00000oo(Class<?> r2) {
        return r2.getSuperclass() != Enum.class ? r2.getSuperclass() : r2;
    }

    public static boolean O000000o(Object obj) {
        return obj != null && O0000O0o(obj.getClass());
    }

    private static boolean O0000O0o(Class<?> cls) {
        return cls.getAnnotation(akg.class) != null;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static final O000000o f12577O000000o = new O000000o();
        private final Field O00000Oo = O000000o(EnumSet.class, "elementType", Class.class);
        private final Field O00000o0 = O000000o(EnumMap.class, "elementType", Class.class);

        private O000000o() {
        }

        public final Class<? extends Enum<?>> O000000o(EnumSet<?> enumSet) {
            Field field = this.O00000Oo;
            if (field != null) {
                return (Class) O000000o(enumSet, field);
            }
            throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
        }

        public final Class<? extends Enum<?>> O000000o(EnumMap<?, ?> enumMap) {
            Field field = this.O00000o0;
            if (field != null) {
                return (Class) O000000o(enumMap, field);
            }
            throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
        }

        private static Object O000000o(Object obj, Field field) {
            try {
                return field.get(obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        private static Field O000000o(Class<?> cls, String str, Class<?> cls2) {
            Field field;
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i];
                if (str.equals(field.getName()) && field.getType() == cls2) {
                    break;
                }
                i++;
            }
            if (field == null) {
                for (Field field2 : declaredFields) {
                    if (field2.getType() == cls2) {
                        if (field != null) {
                            return null;
                        }
                        field = field2;
                    }
                }
            }
            if (field != null) {
                try {
                    field.setAccessible(true);
                } catch (Throwable unused) {
                }
            }
            return field;
        }
    }
}
