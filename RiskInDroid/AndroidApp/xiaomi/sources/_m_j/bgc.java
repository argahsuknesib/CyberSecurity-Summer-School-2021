package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgc implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bgc f12943O000000o = new bgc();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            boolean[] zArr = (boolean[]) obj;
            bhu.O000000o('[');
            for (int i = 0; i < zArr.length; i++) {
                if (i != 0) {
                    bhu.O000000o(',');
                }
                if (zArr[i]) {
                    bhu.write("true");
                } else {
                    bhu.write("false");
                }
            }
            bhu.O000000o(']');
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
