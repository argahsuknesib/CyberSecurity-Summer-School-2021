package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public final class bgk implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgk f12951O000000o = new bgk();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            Type type2 = null;
            int i = 0;
            if (bhc.O000000o(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Collection collection = (Collection) obj;
            bhs bhs = bhc.O00000oo;
            bhc.O000000o(bhs, obj, obj2);
            if (bhc.O000000o(SerializerFeature.WriteClassName)) {
                if (HashSet.class == collection.getClass()) {
                    bhu.append((CharSequence) "Set");
                } else if (TreeSet.class == collection.getClass()) {
                    bhu.append((CharSequence) "TreeSet");
                }
            }
            try {
                bhu.O00000Oo('[');
                for (Object next : collection) {
                    int i2 = i + 1;
                    if (i != 0) {
                        bhu.O00000Oo(',');
                    }
                    if (next == null) {
                        bhu.write("null");
                    } else {
                        Class<?> cls = next.getClass();
                        if (cls == Integer.class) {
                            bhu.O000000o(((Integer) next).intValue());
                        } else if (cls == Long.class) {
                            bhu.O000000o(((Long) next).longValue());
                            if (bhu.O000000o(SerializerFeature.WriteClassName)) {
                                bhu.O000000o('L');
                            }
                        } else {
                            bhc.O000000o(cls).O000000o(bhc, next, Integer.valueOf(i2 - 1), type2);
                        }
                    }
                    i = i2;
                }
                bhu.O00000Oo(']');
            } finally {
                bhc.O00000oo = bhs;
            }
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
