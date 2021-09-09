package _m_j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public final class bgy implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bgy f12963O000000o = new bgy();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.bhu.O000000o(int, char):void
      _m_j.bhu.O000000o(long, char):void
      _m_j.bhu.O000000o(java.lang.String, boolean):void */
    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        if (obj == null) {
            bhc.f12968O000000o.write("null");
            return;
        }
        bhu bhu = bhc.f12968O000000o;
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
        InetAddress address = inetSocketAddress.getAddress();
        bhu.O000000o('{');
        if (address != null) {
            bhu.O000000o("address", false);
            bhc.O00000o0(address);
            bhu.O000000o(',');
        }
        bhu.O000000o("port", false);
        bhu.O000000o(inetSocketAddress.getPort());
        bhu.O000000o('}');
    }
}
