package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

public final class bgb implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgb f12942O000000o = new bgb();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            bhu.write(((BigInteger) obj).toString());
        } else if (bhu.O000000o(SerializerFeature.WriteNullNumberAsZero)) {
            bhu.O000000o('0');
        } else {
            bhu.write("null");
        }
    }
}
