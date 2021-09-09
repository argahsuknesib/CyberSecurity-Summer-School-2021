package _m_j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class jpq<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Class<?> f2029O000000o;
    private final String O00000Oo;
    private final Class[] O00000o0;

    public jpq(Class<?> cls, String str, Class... clsArr) {
        this.f2029O000000o = cls;
        this.O00000Oo = str;
        this.O00000o0 = clsArr;
    }

    private Method O000000o(Class<?> cls) {
        Class<?> cls2;
        String str = this.O00000Oo;
        if (str == null) {
            return null;
        }
        Method O000000o2 = O000000o(cls, str, this.O00000o0);
        if (O000000o2 == null || (cls2 = this.f2029O000000o) == null || cls2.isAssignableFrom(O000000o2.getReturnType())) {
            return O000000o2;
        }
        return null;
    }

    private static Method O000000o(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) != 0) {
                    return method;
                }
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
        }
        return null;
    }

    private Object O00000o(T t, Object... objArr) throws InvocationTargetException {
        Method O000000o2 = O000000o(t.getClass());
        if (O000000o2 != null) {
            try {
                return O000000o2.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(O000000o2)));
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.O00000Oo + " not supported for object " + ((Object) t));
        }
    }

    private Object O00000o0(T t, Object... objArr) throws InvocationTargetException {
        Method O000000o2 = O000000o(t.getClass());
        if (O000000o2 == null) {
            return null;
        }
        try {
            return O000000o2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public final Object O000000o(T t, Object... objArr) {
        try {
            return O00000o0(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public final boolean O000000o(T t) {
        return O000000o(t.getClass()) != null;
    }

    public final Object O00000Oo(T t, Object... objArr) {
        try {
            return O00000o(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
