package _m_j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class anx {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Class<?>[] f12491O000000o = new Class[0];
    final String O00000Oo;
    final Class<?>[] O00000o0;

    public anx(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public anx(Constructor<?> constructor) {
        this("", constructor.getParameterTypes());
    }

    public anx(String str, Class<?>[] clsArr) {
        this.O00000Oo = str;
        this.O00000o0 = clsArr == null ? f12491O000000o : clsArr;
    }

    public final String toString() {
        return this.O00000Oo + "(" + this.O00000o0.length + "-args)";
    }

    public final int hashCode() {
        return this.O00000Oo.hashCode() + this.O00000o0.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        anx anx = (anx) obj;
        if (!this.O00000Oo.equals(anx.O00000Oo)) {
            return false;
        }
        Class<?>[] clsArr = anx.O00000o0;
        int length = this.O00000o0.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Class<?> cls = clsArr[i];
            Class<?> cls2 = this.O00000o0[i];
            if (cls != cls2 && !cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                return false;
            }
        }
        return true;
    }
}
