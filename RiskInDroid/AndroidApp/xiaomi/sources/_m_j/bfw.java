package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class bfw implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfw f12936O000000o = new bfw();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            int length = atomicIntegerArray.length();
            bhu.O00000Oo('[');
            for (int i = 0; i < length; i++) {
                int i2 = atomicIntegerArray.get(i);
                if (i != 0) {
                    bhu.O000000o(',');
                }
                bhu.O000000o(i2);
            }
            bhu.O00000Oo(']');
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
