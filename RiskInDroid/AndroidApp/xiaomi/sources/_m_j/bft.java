package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bft implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bft f12933O000000o = new bft();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        if (obj == null) {
            bhu bhu = bhc.f12968O000000o;
            if (bhu.O000000o(SerializerFeature.WriteNullStringAsEmpty)) {
                bhu.O000000o("");
            } else {
                bhu.write("null");
            }
        } else {
            bhc.O000000o(obj.toString());
        }
    }
}
