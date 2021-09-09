package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public final class ber implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ber f12912O000000o = new ber();

    public final int O000000o() {
        return 12;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 8) {
            O0000O0o.O000000o();
            return null;
        }
        bdo.O000000o(12);
        InetAddress inetAddress = null;
        int i = 0;
        while (true) {
            String O0000oO0 = O0000O0o.O0000oO0();
            O0000O0o.O000000o(17);
            if (O0000oO0.equals("address")) {
                bdo.O000000o(17);
                inetAddress = (InetAddress) bdo.O000000o((Type) InetAddress.class);
            } else if (O0000oO0.equals("port")) {
                bdo.O000000o(17);
                if (O0000O0o.O00000o0() == 2) {
                    i = O0000O0o.O0000o0O();
                    O0000O0o.O000000o();
                } else {
                    throw new JSONException("port is not int");
                }
            } else {
                bdo.O000000o(17);
                bdo.O000000o((Object) null);
            }
            if (O0000O0o.O00000o0() == 16) {
                O0000O0o.O000000o();
            } else {
                bdo.O000000o(13);
                return new InetSocketAddress(inetAddress, i);
            }
        }
    }
}
