package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgd implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgd f12944O000000o = new bgd();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            if (bhu.O000000o(SerializerFeature.WriteNullBooleanAsFalse)) {
                bhu.write("false");
            } else {
                bhu.write("null");
            }
        } else if (bool.booleanValue()) {
            bhu.write("true");
        } else {
            bhu.write("false");
        }
    }
}
