package _m_j;

import android.content.Context;
import java.lang.reflect.Method;

public final class gsb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Object f18202O000000o;
    private static Class<?> O00000Oo;
    private static Method O00000o0;

    public static String O000000o(Context context) {
        return O000000o(context, O00000o0);
    }

    private static String O000000o(Context context, Method method) {
        Object obj = f18202O000000o;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            gsy.O000000o(6, "IdentifierManager", "invoke exception!");
            return null;
        }
    }

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            O00000Oo = cls;
            f18202O000000o = cls.newInstance();
            O00000o0 = O00000Oo.getMethod("getOAID", Context.class);
        } catch (Exception unused) {
            gsy.O000000o(6, "IdentifierManager", "reflect exception!");
        }
    }
}
