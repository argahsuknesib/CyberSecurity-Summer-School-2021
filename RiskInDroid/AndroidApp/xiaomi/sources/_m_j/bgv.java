package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgv implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgv f12960O000000o = new bgv();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            float[] fArr = (float[]) obj;
            int length = fArr.length - 1;
            if (length == -1) {
                bhu.append((CharSequence) "[]");
                return;
            }
            bhu.O00000Oo('[');
            for (int i = 0; i < length; i++) {
                float f = fArr[i];
                if (Float.isNaN(f)) {
                    bhu.write("null");
                } else {
                    bhu.append((CharSequence) Float.toString(f));
                }
                bhu.O00000Oo(',');
            }
            float f2 = fArr[length];
            if (Float.isNaN(f2)) {
                bhu.write("null");
            } else {
                bhu.append((CharSequence) Float.toString(f2));
            }
            bhu.O00000Oo(']');
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
