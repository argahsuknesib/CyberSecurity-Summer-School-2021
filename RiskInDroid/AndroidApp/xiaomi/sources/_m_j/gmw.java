package _m_j;

import java.lang.reflect.Proxy;

public final class gmw {
    private static <T> T O000000o(Object obj, Class<?>[] clsArr, gmu gmu, boolean z, boolean z2) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), clsArr, new gmv(obj, gmu, false, z2));
    }

    public static <T> T O000000o(Object obj, Class<?> cls, gmu gmu, boolean z) {
        return O000000o(obj, new Class[]{cls}, gmu, false, z);
    }

    public static <T> T O000000o(Object obj, Class<?>[] clsArr, gmu gmu) {
        return O000000o(obj, clsArr, gmu, false, true);
    }
}
