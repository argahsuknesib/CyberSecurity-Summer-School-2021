package _m_j;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference1;

public final class ixf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ixg f1643O000000o;
    private static final ixt[] O00000Oo = new ixt[0];

    public static ixx O000000o(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public static ixz O000000o(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    static {
        ixg ixg = null;
        try {
            ixg = (ixg) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (ixg == null) {
            ixg = new ixg();
        }
        f1643O000000o = ixg;
    }

    public static String O000000o(ixd ixd) {
        return ixg.O000000o(ixd);
    }

    public static ixt O000000o(Class cls) {
        return new ixa(cls);
    }

    public static String O000000o(Lambda lambda) {
        return ixg.O000000o(lambda);
    }
}
