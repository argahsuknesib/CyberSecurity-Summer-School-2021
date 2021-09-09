package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgp implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgp f12956O000000o = new bgp();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj == null) {
            bhc.f12968O000000o.write("null");
        } else if (bhc.O000000o(SerializerFeature.WriteEnumUsingToString)) {
            bhc.O000000o(((Enum) obj).name());
        } else {
            bhu.O000000o(((Enum) obj).ordinal());
        }
    }
}
