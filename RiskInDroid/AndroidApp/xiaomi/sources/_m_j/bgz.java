package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgz implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bgz f12964O000000o = new bgz();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            int[] iArr = (int[]) obj;
            bhu.O000000o('[');
            for (int i = 0; i < iArr.length; i++) {
                if (i != 0) {
                    bhu.O000000o(',');
                }
                bhu.O000000o(iArr[i]);
            }
            bhu.O000000o(']');
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
