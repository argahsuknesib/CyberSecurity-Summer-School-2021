package _m_j;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public final class iap {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Cache<Class<?>, Object> f1115O000000o = CacheBuilder.newBuilder().build();

    public static <T> T O000000o(Class<T> cls) throws Exception {
        jcy.O000000o(cls, "Config class is null");
        iaq iaq = (iaq) cls.getAnnotation(iaq.class);
        jcy.O000000o(iaq, "No config provider");
        Class<? extends Object> O000000o2 = iaq.O000000o();
        T newInstance = cls.newInstance();
        O000000o2.newInstance();
        return newInstance;
    }
}
