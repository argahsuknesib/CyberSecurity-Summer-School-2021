package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bhx implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bhx f12983O000000o = new bhx();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        O000000o(bhc, (String) obj);
    }

    public static void O000000o(bhc bhc, String str) {
        bhu bhu = bhc.f12968O000000o;
        if (str != null) {
            bhu.O000000o(str);
        } else if (bhu.O000000o(SerializerFeature.WriteNullStringAsEmpty)) {
            bhu.O000000o("");
        } else {
            bhu.write("null");
        }
    }
}
