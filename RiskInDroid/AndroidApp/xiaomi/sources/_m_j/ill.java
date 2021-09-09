package _m_j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ill {
    public static Object O000000o(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (cls == null) {
            return null;
        }
        Class<?>[] O000000o2 = ilg.O000000o(clsArr);
        Object[] O000000o3 = ilg.O000000o(objArr);
        Method method = cls.getMethod(str, O000000o2);
        if (method != null) {
            return method.invoke(null, O000000o3);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
    }
}
