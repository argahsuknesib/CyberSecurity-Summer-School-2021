package javax.jmdns.impl;

import _m_j.isr;
import _m_j.itb;
import _m_j.ith;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.impl.DNSStatefulObject;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;

public class HostInfo implements DNSStatefulObject {
    private static Logger O00000oO = Logger.getLogger(HostInfo.class.getName());

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f15360O000000o;
    protected InetAddress O00000Oo;
    public final HostInfoState O00000o;
    protected NetworkInterface O00000o0;
    private int O00000oo;

    public static final class HostInfoState extends DNSStatefulObject.DefaultImplementation {
        private static final long serialVersionUID = -8191476803620402088L;

        public HostInfoState(JmDNSImpl jmDNSImpl) {
            setDns(jmDNSImpl);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.io.IOException]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static HostInfo O000000o(InetAddress inetAddress, JmDNSImpl jmDNSImpl, String str) {
        InetAddress inetAddress2;
        String str2;
        if (inetAddress == null) {
            try {
                String property = System.getProperty("net.mdns.interface");
                if (property != null) {
                    inetAddress2 = InetAddress.getByName(property);
                } else {
                    inetAddress2 = InetAddress.getLocalHost();
                    if (inetAddress2.isLoopbackAddress()) {
                        InetAddress[] O000000o2 = isr.O000000o.O000000o().O000000o();
                        if (O000000o2.length > 0) {
                            inetAddress2 = O000000o2[0];
                        }
                    }
                }
                str2 = inetAddress2.getHostName();
                if (inetAddress2.isLoopbackAddress()) {
                    O00000oO.warning("Could not find any address beside the loopback.");
                }
            } catch (IOException e) {
                Logger logger = O00000oO;
                Level level = Level.WARNING;
                logger.log(level, "Could not intialize the host network interface on " + inetAddress + "because of an error: " + e.getMessage(), (Throwable) e);
                inetAddress2 = O0000O0o();
                str2 = "computer";
            }
        } else {
            str2 = inetAddress.getHostName();
            inetAddress2 = inetAddress;
        }
        if (str2.contains("in-addr.arpa") || str2.equals(inetAddress2.getHostAddress())) {
            str2 = inetAddress2.getHostAddress();
        }
        String replace = str2.replace('.', '-');
        return new HostInfo(inetAddress2, replace + ".local.", jmDNSImpl);
    }

    private static InetAddress O0000O0o() {
        try {
            return InetAddress.getByName(null);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    private HostInfo(InetAddress inetAddress, String str, JmDNSImpl jmDNSImpl) {
        this.O00000o = new HostInfoState(jmDNSImpl);
        this.O00000Oo = inetAddress;
        this.f15360O000000o = str;
        if (inetAddress != null) {
            try {
                this.O00000o0 = NetworkInterface.getByInetAddress(inetAddress);
            } catch (Exception e) {
                O00000oO.log(Level.SEVERE, "LocalHostInfo() exception ", (Throwable) e);
            }
        }
    }

    public final String O000000o() {
        return this.f15360O000000o;
    }

    public final InetAddress O00000Oo() {
        return this.O00000Oo;
    }

    public final NetworkInterface O00000oO() {
        return this.O00000o0;
    }

    public final boolean O000000o(itb.O000000o o000000o) {
        itb.O000000o O000000o2 = O000000o(o000000o.O00000oO(), o000000o.f1610O000000o);
        if (O000000o2 == null || !O000000o2.O00000Oo((itb) o000000o) || !O000000o2.O00000o0((itb) o000000o) || O000000o2.O000000o((itb) o000000o)) {
            return false;
        }
        return true;
    }

    public final synchronized String O00000oo() {
        this.O00000oo++;
        int indexOf = this.f15360O000000o.indexOf(".local.");
        int lastIndexOf = this.f15360O000000o.lastIndexOf(45);
        StringBuilder sb = new StringBuilder();
        String str = this.f15360O000000o;
        if (lastIndexOf != -1) {
            indexOf = lastIndexOf;
        }
        sb.append(str.substring(0, indexOf));
        sb.append("-");
        sb.append(this.O00000oo);
        sb.append(".local.");
        this.f15360O000000o = sb.toString();
        return this.f15360O000000o;
    }

    /* renamed from: javax.jmdns.impl.HostInfo$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f15361O000000o = new int[DNSRecordType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f15361O000000o[DNSRecordType.TYPE_A.ordinal()] = 1;
            f15361O000000o[DNSRecordType.TYPE_A6.ordinal()] = 2;
            try {
                f15361O000000o[DNSRecordType.TYPE_AAAA.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final itb.O000000o O000000o(DNSRecordType dNSRecordType, boolean z) {
        int i = AnonymousClass1.f15361O000000o[dNSRecordType.ordinal()];
        if (i == 1) {
            return O00000Oo(z, 3600);
        }
        if (i == 2 || i == 3) {
            return O00000o0(z, 3600);
        }
        return null;
    }

    public final itb.O0000O0o O000000o(DNSRecordType dNSRecordType) {
        int i = AnonymousClass1.f15361O000000o[dNSRecordType.ordinal()];
        if (i == 1) {
            return O00000o(false, 3600);
        }
        if (i == 2 || i == 3) {
            return O00000oO(false, 3600);
        }
        return null;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("local host info[");
        String str2 = this.f15360O000000o;
        if (str2 == null) {
            str2 = "no name";
        }
        sb.append(str2);
        sb.append(", ");
        NetworkInterface networkInterface = this.O00000o0;
        if (networkInterface != null) {
            str = networkInterface.getDisplayName();
        } else {
            str = "???";
        }
        sb.append(str);
        sb.append(":");
        InetAddress inetAddress = this.O00000Oo;
        sb.append(inetAddress != null ? inetAddress.getHostAddress() : "no address");
        sb.append(", ");
        sb.append(this.O00000o);
        sb.append("]");
        return sb.toString();
    }

    public final Collection<itb> O000000o(boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        itb.O000000o O00000Oo2 = O00000Oo(z, i);
        if (O00000Oo2 != null) {
            arrayList.add(O00000Oo2);
        }
        itb.O000000o O00000o02 = O00000o0(z, i);
        if (O00000o02 != null) {
            arrayList.add(O00000o02);
        }
        return arrayList;
    }

    public boolean advanceState(ith ith) {
        return this.O00000o.advanceState(ith);
    }

    public final boolean O000000o(long j) {
        if (this.O00000Oo == null) {
            return true;
        }
        return this.O00000o.waitForCanceled(5000);
    }

    /* access modifiers changed from: package-private */
    public final Inet4Address O00000o0() {
        InetAddress inetAddress = this.O00000Oo;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Inet6Address O00000o() {
        InetAddress inetAddress = this.O00000Oo;
        if (inetAddress instanceof Inet6Address) {
            return (Inet6Address) inetAddress;
        }
        return null;
    }

    public final boolean O000000o(DatagramPacket datagramPacket) {
        InetAddress address;
        boolean z = false;
        if (this.O00000Oo == null || (address = datagramPacket.getAddress()) == null) {
            return false;
        }
        if (address.isLinkLocalAddress() && !this.O00000Oo.isLinkLocalAddress()) {
            z = true;
        }
        if (!address.isLoopbackAddress() || this.O00000Oo.isLoopbackAddress()) {
            return z;
        }
        return true;
    }

    private itb.O000000o O00000Oo(boolean z, int i) {
        InetAddress inetAddress = this.O00000Oo;
        if (!(inetAddress instanceof Inet4Address) && (!(inetAddress instanceof Inet6Address) || !((Inet6Address) inetAddress).isIPv4CompatibleAddress())) {
            return null;
        }
        return new itb.O00000o0(this.f15360O000000o, DNSRecordClass.CLASS_IN, z, i, this.O00000Oo);
    }

    private itb.O000000o O00000o0(boolean z, int i) {
        if (!(this.O00000Oo instanceof Inet6Address)) {
            return null;
        }
        return new itb.O00000o(this.f15360O000000o, DNSRecordClass.CLASS_IN, z, i, this.O00000Oo);
    }

    private itb.O0000O0o O00000o(boolean z, int i) {
        InetAddress inetAddress = this.O00000Oo;
        if (inetAddress instanceof Inet4Address) {
            return new itb.O0000O0o(this.O00000Oo.getHostAddress() + ".in-addr.arpa.", DNSRecordClass.CLASS_IN, false, 3600, this.f15360O000000o);
        } else if (!(inetAddress instanceof Inet6Address) || !((Inet6Address) inetAddress).isIPv4CompatibleAddress()) {
            return null;
        } else {
            byte[] address = this.O00000Oo.getAddress();
            return new itb.O0000O0o((((int) (address[12] & 255)) + "." + ((int) (address[13] & 255)) + "." + ((int) (address[14] & 255)) + "." + ((int) (address[15] & 255))) + ".in-addr.arpa.", DNSRecordClass.CLASS_IN, false, 3600, this.f15360O000000o);
        }
    }

    private itb.O0000O0o O00000oO(boolean z, int i) {
        if (!(this.O00000Oo instanceof Inet6Address)) {
            return null;
        }
        return new itb.O0000O0o(this.O00000Oo.getHostAddress() + ".ip6.arpa.", DNSRecordClass.CLASS_IN, false, 3600, this.f15360O000000o);
    }
}
