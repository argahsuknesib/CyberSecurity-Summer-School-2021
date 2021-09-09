package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bhh implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bhh f12973O000000o = new bhh();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            long longValue = ((Long) obj).longValue();
            bhu.O000000o(longValue);
            if (bhc.O000000o(SerializerFeature.WriteClassName) && longValue <= 2147483647L && longValue >= -2147483648L && type != Long.class) {
                bhu.O000000o('L');
            }
        } else if (bhu.O000000o(SerializerFeature.WriteNullNumberAsZero)) {
            bhu.O000000o('0');
        } else {
            bhu.write("null");
        }
    }
}
