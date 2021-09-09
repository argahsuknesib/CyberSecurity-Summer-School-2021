package _m_j;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class asz {

    /* renamed from: O000000o  reason: collision with root package name */
    private final EnumMap<?, aja> f12580O000000o;

    public asz(Map<Enum<?>, aja> map) {
        this.f12580O000000o = new EnumMap<>(map);
    }

    public static asz O000000o(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) asw.O00000oo(cls).getEnumConstants();
        if (enumArr != null) {
            HashMap hashMap = new HashMap();
            for (Enum enumR : enumArr) {
                hashMap.put(enumR, new aja(annotationIntrospector.O000000o(enumR)));
            }
            return new asz(hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
    }

    public final aja O000000o(Enum<?> enumR) {
        return this.f12580O000000o.get(enumR);
    }
}
