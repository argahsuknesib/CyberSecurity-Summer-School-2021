package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

public final class bfr implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfr f12931O000000o = new bfr();

    public final int O000000o() {
        return 4;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        String str = (String) bdo.O000000o((Object) null);
        if (str == null) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new JSONException("create url error", e);
        }
    }
}
