package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

public final class bgn implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgn f12954O000000o = new bgn();

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            double[] dArr = (double[]) obj;
            int length = dArr.length - 1;
            if (length == -1) {
                bhu.append((CharSequence) "[]");
                return;
            }
            bhu.O00000Oo('[');
            for (int i = 0; i < length; i++) {
                double d = dArr[i];
                if (Double.isNaN(d)) {
                    bhu.write("null");
                } else {
                    bhu.append((CharSequence) Double.toString(d));
                }
                bhu.O00000Oo(',');
            }
            double d2 = dArr[length];
            if (Double.isNaN(d2)) {
                bhu.write("null");
            } else {
                bhu.append((CharSequence) Double.toString(d2));
            }
            bhu.O00000Oo(']');
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
