package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLongArray;

public final class bfy implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfy f12938O000000o = new bfy();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
            int length = atomicLongArray.length();
            bhu.O00000Oo('[');
            for (int i = 0; i < length; i++) {
                long j = atomicLongArray.get(i);
                if (i != 0) {
                    bhu.O000000o(',');
                }
                bhu.O000000o(j);
            }
            bhu.O00000Oo(']');
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
