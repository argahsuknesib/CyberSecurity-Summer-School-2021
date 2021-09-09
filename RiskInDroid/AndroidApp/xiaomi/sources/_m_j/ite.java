package _m_j;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ite implements isr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Logger f1622O000000o = Logger.getLogger(ite.class.getName());
    private final Method O00000Oo;
    private final Method O00000o0;

    public ite() {
        Method method;
        Method method2 = null;
        try {
            method = NetworkInterface.class.getMethod("isUp", null);
        } catch (Exception unused) {
            method = null;
        }
        this.O00000Oo = method;
        try {
            method2 = NetworkInterface.class.getMethod("supportsMulticast", null);
        } catch (Exception unused2) {
        }
        this.O00000o0 = method2;
    }

    public final InetAddress[] O000000o() {
        HashSet hashSet = new HashSet();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (f1622O000000o.isLoggable(Level.FINEST)) {
                        Logger logger = f1622O000000o;
                        logger.finest("Found NetworkInterface/InetAddress: " + nextElement + " -- " + nextElement2);
                    }
                    if (O000000o(nextElement, nextElement2)) {
                        hashSet.add(nextElement2);
                    }
                }
            }
        } catch (SocketException e) {
            f1622O000000o.warning("Error while fetching network interfaces addresses: ".concat(String.valueOf(e)));
        }
        return (InetAddress[]) hashSet.toArray(new InetAddress[hashSet.size()]);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|(3:5|6|(1:8))|9|10|(3:12|13|(1:15))|16|17|(1:19)(1:20)) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0019 A[SYNTHETIC, Splitter:B:12:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f A[RETURN] */
    private boolean O000000o(NetworkInterface networkInterface, InetAddress inetAddress) {
        if (this.O00000Oo != null) {
            if (!((Boolean) this.O00000Oo.invoke(networkInterface, null)).booleanValue()) {
                return false;
            }
        }
        if (this.O00000o0 != null) {
            if (!((Boolean) this.O00000o0.invoke(networkInterface, null)).booleanValue()) {
                return false;
            }
        }
        if (inetAddress.isLoopbackAddress()) {
            return false;
        }
        return true;
    }
}
