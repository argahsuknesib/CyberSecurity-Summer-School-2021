package _m_j;

import _m_j.dya;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

public final class dyt implements Dns {
    private static dyt O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15080O000000o = 101;
    private dyr O00000o0 = dyr.O000000o();

    private dyt() {
    }

    public static synchronized dyt O000000o() {
        dyt dyt;
        synchronized (dyt.class) {
            if (O00000Oo == null) {
                O00000Oo = new dyt();
            }
            dyt = O00000Oo;
        }
        return dyt;
    }

    private List<InetAddress> O000000o(String str) {
        dys O000000o2;
        dyr dyr = this.O00000o0;
        if (!(dyr == null || (O000000o2 = dyr.O000000o(str)) == null)) {
            InetAddress[] O000000o3 = O000000o2.O000000o();
            StringBuilder sb = new StringBuilder("lookup: ");
            sb.append(str);
            sb.append(" &&  ");
            sb.append(O000000o3);
            if (O000000o3 != null && O000000o3.length > 0) {
                return Arrays.asList(O000000o3);
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dya.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.dya.O000000o(java.lang.String, java.lang.ref.SoftReference<java.util.Map<java.lang.String, java.util.List<com.xiaomi.miot.support.monitor.core.net.NetInfo>>>):void
      _m_j.dya.O000000o(java.lang.String, com.xiaomi.miot.support.monitor.core.net.NetInfo):void
      _m_j.dya.O000000o(java.lang.String, boolean):void */
    public final List<InetAddress> lookup(String str) throws UnknownHostException {
        boolean z;
        List<InetAddress> O000000o2;
        List<InetAddress> O000000o3;
        if (this.O00000o0 == null) {
            z = false;
        } else {
            z = dyr.O00000Oo(str);
        }
        if (!z) {
            return Dns.SYSTEM.lookup(str);
        }
        if (this.f15080O000000o != 100 || (O000000o3 = O000000o(str)) == null || O000000o3.size() <= 0) {
            List<InetAddress> lookup = Dns.SYSTEM.lookup(str);
            if (lookup != null && lookup.size() > 0) {
                if (lookup.get(0) != null) {
                    StringBuilder sb = new StringBuilder("system: ");
                    sb.append(str);
                    sb.append("  ");
                    sb.append(lookup.get(0).getHostAddress());
                    sb.append("  priority = ");
                    sb.append(this.f15080O000000o);
                    sb.append("  ipCount = ");
                    sb.append(lookup.size());
                }
                dya.O000000o.f15057O000000o.O000000o(str, false);
                return lookup;
            } else if (this.f15080O000000o != 101 || (O000000o2 = O000000o(str)) == null || O000000o2.size() <= 0) {
                new StringBuilder("lookup: backup failed  priority = ").append(this.f15080O000000o);
                dya.O000000o.f15057O000000o.O000000o(str, false);
                return Dns.SYSTEM.lookup(str);
            } else {
                if (O000000o2.get(0) != null) {
                    StringBuilder sb2 = new StringBuilder("cache backup: ");
                    sb2.append(str);
                    sb2.append("  ");
                    sb2.append(O000000o2.get(0).getHostAddress());
                    sb2.append("  ipCount = ");
                    sb2.append(O000000o2.size());
                }
                dya.O000000o.f15057O000000o.O000000o(str, true);
                return O000000o2;
            }
        } else {
            if (O000000o3.get(0) != null) {
                StringBuilder sb3 = new StringBuilder("cache priority: ");
                sb3.append(str);
                sb3.append("  ");
                sb3.append(O000000o3.get(0).getHostAddress());
                sb3.append("  ipCount = ");
                sb3.append(O000000o3.size());
            }
            dya.O000000o.f15057O000000o.O000000o(str, true);
            return O000000o3;
        }
    }
}
