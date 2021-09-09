package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bhl implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bhl f12975O000000o = new bhl();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        Object[] objArr = (Object[]) obj;
        if (obj != null) {
            int length = objArr.length;
            int i = length - 1;
            if (i == -1) {
                bhu.append((CharSequence) "[]");
                return;
            }
            bhs bhs = bhc.O00000oo;
            bhc.O000000o(bhs, obj, obj2);
            try {
                bhu.O00000Oo('[');
                int i2 = 0;
                if (bhu.O000000o(SerializerFeature.PrettyFormat)) {
                    bhc.O00000Oo();
                    bhc.O00000o();
                    while (i2 < length) {
                        if (i2 != 0) {
                            bhu.O000000o(',');
                            bhc.O00000o();
                        }
                        bhc.O00000o0(objArr[i2]);
                        i2++;
                    }
                    bhc.O00000o0();
                    bhc.O00000o();
                    bhu.O000000o(']');
                    return;
                }
                Class<?> cls = null;
                bhn bhn = null;
                while (i2 < i) {
                    Object obj3 = objArr[i2];
                    if (obj3 == null) {
                        bhu.append((CharSequence) "null,");
                    } else {
                        if (bhc.O000000o(obj3)) {
                            bhc.O00000Oo(obj3);
                        } else {
                            Class<?> cls2 = obj3.getClass();
                            if (cls2 == cls) {
                                bhn.O000000o(bhc, obj3, null, null);
                            } else {
                                bhn = bhc.O000000o(cls2);
                                bhn.O000000o(bhc, obj3, null, null);
                                cls = cls2;
                            }
                        }
                        bhu.O00000Oo(',');
                    }
                    i2++;
                }
                Object obj4 = objArr[i];
                if (obj4 == null) {
                    bhu.append((CharSequence) "null]");
                } else {
                    if (bhc.O000000o(obj4)) {
                        bhc.O00000Oo(obj4);
                    } else {
                        bhc.O00000o0(obj4);
                    }
                    bhu.O00000Oo(']');
                }
                bhc.O00000oo = bhs;
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
