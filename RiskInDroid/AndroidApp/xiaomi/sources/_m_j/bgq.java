package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

public final class bgq implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bgq f12957O000000o = new bgq();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            Type type2 = null;
            int i = 0;
            if (bhc.O000000o(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Enumeration enumeration = (Enumeration) obj;
            bhs bhs = bhc.O00000oo;
            bhc.O000000o(bhs, obj, obj2);
            try {
                bhu.O00000Oo('[');
                while (enumeration.hasMoreElements()) {
                    Object nextElement = enumeration.nextElement();
                    int i2 = i + 1;
                    if (i != 0) {
                        bhu.O00000Oo(',');
                    }
                    if (nextElement == null) {
                        bhu.write("null");
                    } else {
                        bhc.O000000o(nextElement.getClass()).O000000o(bhc, nextElement, Integer.valueOf(i2 - 1), type2);
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
