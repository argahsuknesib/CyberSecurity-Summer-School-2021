package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public final class bgl implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bgl f12952O000000o = new bgl();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.bhu.O000000o(int, char):void
      _m_j.bhu.O000000o(long, char):void
      _m_j.bhu.O000000o(java.lang.String, boolean):void */
    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhu bhu = bhc.f12968O000000o;
        if (obj == null) {
            bhu.write("null");
            return;
        }
        String pattern = ((SimpleDateFormat) obj).toPattern();
        if (!bhu.O000000o(SerializerFeature.WriteClassName) || obj.getClass() == type) {
            bhu.O000000o(pattern);
            return;
        }
        bhu.O000000o('{');
        bhu.O000000o(bdf.f12884O000000o, false);
        bhc.O000000o(obj.getClass().getName());
        bhu.O000000o(',');
        bhu.O000000o("val", false);
        bhu.O000000o(pattern);
        bhu.O000000o('}');
    }
}
