package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgw implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bgw f12961O000000o = new bgw();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            float floatValue = ((Float) obj).floatValue();
            if (Float.isNaN(floatValue)) {
                bhu.write("null");
            } else if (Float.isInfinite(floatValue)) {
                bhu.write("null");
            } else {
                String f = Float.toString(floatValue);
                if (f.endsWith(".0")) {
                    f = f.substring(0, f.length() - 2);
                }
                bhu.write(f);
                if (bhc.O000000o(SerializerFeature.WriteClassName)) {
                    bhu.O000000o('F');
                }
            }
        } else if (bhc.O000000o(SerializerFeature.WriteNullNumberAsZero)) {
            bhu.O000000o('0');
        } else {
            bhu.write("null");
        }
    }
}
