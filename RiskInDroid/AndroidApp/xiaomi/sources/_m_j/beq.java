package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class beq implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final beq f12911O000000o = new beq();

    public final int O000000o() {
        return 4;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        String str = (String) bdo.O000000o((Object) null);
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return InetAddress.getByName(str);
        } catch (UnknownHostException e) {
            throw new JSONException("deserialize error", e);
        }
    }
}
