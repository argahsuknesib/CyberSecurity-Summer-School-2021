package _m_j;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public final class bfh implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfh f12923O000000o = new bfh();

    public final int O000000o() {
        return 12;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Object O000000o2 = bdo.O000000o(parameterizedType.getActualTypeArguments()[0]);
        Type rawType = parameterizedType.getRawType();
        if (rawType == AtomicReference.class) {
            return new AtomicReference(O000000o2);
        }
        if (rawType == WeakReference.class) {
            return new WeakReference(O000000o2);
        }
        if (rawType == SoftReference.class) {
            return new SoftReference(O000000o2);
        }
        throw new UnsupportedOperationException(rawType.toString());
    }
}
