package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

public final class bgo implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgo f12955O000000o = new bgo();
    private DecimalFormat O00000Oo = null;

    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        String str;
        bhu bhu = bhc.f12968O000000o;
        if (obj != null) {
            double doubleValue = ((Double) obj).doubleValue();
            if (Double.isNaN(doubleValue)) {
                bhu.write("null");
            } else if (Double.isInfinite(doubleValue)) {
                bhu.write("null");
            } else {
                DecimalFormat decimalFormat = this.O00000Oo;
                if (decimalFormat == null) {
                    str = Double.toString(doubleValue);
                    if (str.endsWith(".0")) {
                        str = str.substring(0, str.length() - 2);
                    }
                } else {
                    str = decimalFormat.format(doubleValue);
                }
                bhu.append((CharSequence) str);
                if (bhc.O000000o(SerializerFeature.WriteClassName)) {
                    bhu.O000000o('D');
                }
            }
        } else if (bhc.O000000o(SerializerFeature.WriteNullNumberAsZero)) {
            bhu.O000000o('0');
        } else {
            bhu.write("null");
        }
    }
}
