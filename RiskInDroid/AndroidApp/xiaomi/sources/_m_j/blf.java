package _m_j;

import java.lang.reflect.Proxy;

public final class blf {
    public static <T> T O000000o(Object obj, Class<?> cls, bld bld) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, new ble(obj, bld, false, false));
    }
}
