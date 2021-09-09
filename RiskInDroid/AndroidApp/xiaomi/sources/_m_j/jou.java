package _m_j;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class jou {

    /* renamed from: O000000o  reason: collision with root package name */
    public final jot f2002O000000o;
    public final Proxy O00000Oo;
    public final InetSocketAddress O00000o0;

    public jou(jot jot, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (jot == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f2002O000000o = jot;
            this.O00000Oo = proxy;
            this.O00000o0 = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof jou) {
            jou jou = (jou) obj;
            return this.f2002O000000o.equals(jou.f2002O000000o) && this.O00000Oo.equals(jou.O00000Oo) && this.O00000o0.equals(jou.O00000o0);
        }
    }

    public final int hashCode() {
        return ((((this.f2002O000000o.hashCode() + 527) * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode();
    }
}
