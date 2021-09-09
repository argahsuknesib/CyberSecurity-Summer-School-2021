package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgf implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bgf f12946O000000o = new bgf();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        Number number = (Number) obj;
        if (number != null) {
            bhu.O000000o((int) number.shortValue());
            if (bhc.O000000o(SerializerFeature.WriteClassName)) {
                bhu.O000000o('B');
            }
        } else if (bhu.O000000o(SerializerFeature.WriteNullNumberAsZero)) {
            bhu.O000000o('0');
        } else {
            bhu.write("null");
        }
    }
}
