package _m_j;

import com.imi.fastjson.JSONException;
import java.text.SimpleDateFormat;

public final class bek extends bdw implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bek f12906O000000o = new bek();

    public final int O000000o() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public final <T> T O000000o(bdo bdo, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            return new SimpleDateFormat(str);
        }
        throw new JSONException("parse error");
    }
}
