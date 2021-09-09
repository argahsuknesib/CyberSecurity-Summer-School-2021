package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bfu implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Class<?> f12934O000000o;
    private final bhn O00000Oo;

    public bfu(Class<?> cls, bhn bhn) {
        this.f12934O000000o = cls;
        this.O00000Oo = bhn;
    }

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            bhs bhs = bhc.O00000oo;
            bhc.O000000o(bhs, obj, obj2);
            try {
                bhu.O00000Oo('[');
                for (int i = 0; i < length; i++) {
                    if (i != 0) {
                        bhu.O00000Oo(',');
                    }
                    Object obj3 = objArr[i];
                    if (obj3 == null) {
                        bhu.append((CharSequence) "null");
                    } else if (obj3.getClass() == this.f12934O000000o) {
                        this.O00000Oo.O000000o(bhc, obj3, Integer.valueOf(i), null);
                    } else {
                        bhc.O000000o(obj3.getClass()).O000000o(bhc, obj3, Integer.valueOf(i), null);
                    }
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
