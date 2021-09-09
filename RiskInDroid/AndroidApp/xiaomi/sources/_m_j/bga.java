package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public final class bga implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bga f12941O000000o = new bga();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            bhu.write(bigDecimal.toString());
            if (bhu.O000000o(SerializerFeature.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
                bhu.O000000o('.');
            }
        } else if (bhu.O000000o(SerializerFeature.WriteNullNumberAsZero)) {
            bhu.O000000o('0');
        } else {
            bhu.write("null");
        }
    }
}
