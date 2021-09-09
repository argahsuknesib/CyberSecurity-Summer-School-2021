package _m_j;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class cze {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final HashMap<Class, Method> f14400O000000o = new HashMap<>();
    private static final Method O00000Oo = cze.class.getDeclaredMethods()[0];

    public static <T> T O000000o(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        Method O00000Oo2 = O00000Oo(cls);
        if (O00000Oo2 == O00000Oo) {
            new Object[1][0] = cls;
            cvb.O00000o();
            return null;
        }
        new Object[1][0] = O00000Oo2;
        cvb.O00000o();
        try {
            return O00000Oo2.invoke(null, new Object[0]);
        } catch (Exception unused) {
            cvb.O0000OOo();
            return null;
        }
    }

    private static <T> Method O00000Oo(Class<T> cls) {
        Method method;
        Method method2 = f14400O000000o.get(cls);
        if (method2 == null) {
            synchronized (f14400O000000o) {
                method2 = f14400O000000o.get(cls);
                if (method2 == null) {
                    boolean z = true;
                    new Object[1][0] = cls;
                    cvb.O00000o();
                    Method[] declaredMethods = cls.getDeclaredMethods();
                    int length = declaredMethods.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        method = declaredMethods[i];
                        if (method.getAnnotation(cug.class) != null) {
                            if (Modifier.isStatic(method.getModifiers()) && method.getReturnType() == cls) {
                                Class<?>[] parameterTypes = method.getParameterTypes();
                                if (parameterTypes != null) {
                                    if (parameterTypes.length != 0) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                }
                            }
                            cvb.O0000O0o();
                        } else {
                            i++;
                        }
                    }
                    method = O00000Oo;
                    f14400O000000o.put(cls, method);
                    method2 = method;
                }
            }
        }
        return method2;
    }
}
