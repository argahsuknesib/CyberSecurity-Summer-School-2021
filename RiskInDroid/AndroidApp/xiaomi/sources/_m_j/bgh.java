package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgh implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bgh f12948O000000o = new bgh();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            bhu.O000000o(new String((char[]) obj));
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
