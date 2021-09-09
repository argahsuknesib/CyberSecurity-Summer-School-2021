package _m_j;

import java.lang.reflect.Method;

public final class gpx {

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Object f18133O000000o;
        final Class O00000Oo;

        public O000000o(Object obj, Class cls) {
            this.f18133O000000o = obj;
            this.O00000Oo = cls;
        }
    }

    public static void O000000o(Object obj, String str, O000000o... o000000oArr) {
        if (obj != null) {
            try {
                Class[] clsArr = new Class[1];
                Object[] objArr = new Object[1];
                for (int i = 0; i <= 0; i++) {
                    clsArr[0] = o000000oArr[0].O00000Oo;
                    objArr[0] = o000000oArr[0].f18133O000000o;
                }
                Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj, objArr);
            } catch (Throwable unused) {
            }
        }
    }
}
