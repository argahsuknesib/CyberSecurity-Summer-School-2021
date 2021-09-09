package _m_j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface jpg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jpg f2018O000000o = new jpg() {
        /* class _m_j.jpg.AnonymousClass1 */

        public final List<InetAddress> O000000o(String str) throws UnknownHostException {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    };

    List<InetAddress> O000000o(String str) throws UnknownHostException;
}
