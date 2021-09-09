package javax.jmdns.impl;

import _m_j.isq;
import _m_j.iss;
import _m_j.isu;
import _m_j.isv;
import _m_j.isw;
import _m_j.isx;
import _m_j.isz;
import _m_j.itb;
import _m_j.itc;
import _m_j.itd;
import _m_j.itf;
import _m_j.itg;
import _m_j.ith;
import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import javax.jmdns.impl.constants.DNSState;

public class JmDNSImpl extends isq implements itc, DNSStatefulObject {

    /* renamed from: O000000o  reason: collision with root package name */
    static Logger f15362O000000o = Logger.getLogger(JmDNSImpl.class.getName());
    private static final Random O0000oO = new Random();
    public volatile MulticastSocket O00000Oo;
    final ConcurrentMap<String, List<itd.O000000o>> O00000o;
    public final List<isx> O00000o0;
    public final isu O00000oO;
    public final ConcurrentMap<String, ServiceInfo> O00000oo;
    public final ConcurrentMap<String, ServiceTypeEntry> O0000O0o;
    protected Thread O0000OOo;
    public int O0000Oo;
    public HostInfo O0000Oo0;
    public long O0000OoO;
    final ExecutorService O0000Ooo = Executors.newSingleThreadExecutor();
    private final Set<itd.O00000Oo> O0000o;
    public isw O0000o0;
    public final ReentrantLock O0000o00 = new ReentrantLock();
    public final String O0000o0O;
    private volatile InetAddress O0000o0o;
    private Thread O0000oO0;
    private final ConcurrentMap<String, O000000o> O0000oOO;
    private final Object O0000oOo = new Object();

    public enum Operation {
        Remove,
        Update,
        Add,
        RegisterServiceType,
        Noop
    }

    public static class ServiceTypeEntry extends AbstractMap<String, String> implements Cloneable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f15371O000000o;
        private final Set<Map.Entry<String, String>> O00000Oo = new HashSet();

        static class SubTypeEntry implements Serializable, Cloneable, Map.Entry<String, String> {
            private static final long serialVersionUID = 9188503522395855322L;
            private final String _key;
            private final String _value;

            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return this;
            }

            public SubTypeEntry(String str) {
                this._value = str == null ? "" : str;
                this._key = this._value.toLowerCase();
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!this._key.equals(entry.getKey()) || !this._value.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                String str = this._key;
                int i = 0;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this._value;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode ^ i;
            }

            public String toString() {
                return this._key + "=" + this._value;
            }

            public /* synthetic */ Object setValue(Object obj) {
                throw new UnsupportedOperationException();
            }

            public /* bridge */ /* synthetic */ Object getValue() {
                return this._value;
            }

            public /* bridge */ /* synthetic */ Object getKey() {
                return this._key;
            }
        }

        public ServiceTypeEntry(String str) {
            this.f15371O000000o = str;
        }

        public final Set<Map.Entry<String, String>> entrySet() {
            return this.O00000Oo;
        }

        public final boolean O000000o(String str) {
            return str != null && containsKey(str.toLowerCase());
        }

        public final boolean O00000Oo(String str) {
            if (str == null || O000000o(str)) {
                return false;
            }
            this.O00000Oo.add(new SubTypeEntry(str));
            return true;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(200);
            if (isEmpty()) {
                sb.append("empty");
            } else {
                for (String append : values()) {
                    sb.append(append);
                    sb.append(", ");
                }
                sb.setLength(sb.length() - 2);
            }
            return sb.toString();
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            ServiceTypeEntry serviceTypeEntry = new ServiceTypeEntry(this.f15371O000000o);
            for (Map.Entry<String, String> value : entrySet()) {
                serviceTypeEntry.O00000Oo((String) value.getValue());
            }
            return serviceTypeEntry;
        }
    }

    public JmDNSImpl(InetAddress inetAddress) throws Exception {
        if (f15362O000000o.isLoggable(Level.FINER)) {
            f15362O000000o.finer("JmDNS instance created");
        }
        this.O00000oO = new isu(100);
        this.O00000o0 = Collections.synchronizedList(new ArrayList());
        this.O00000o = new ConcurrentHashMap();
        this.O0000o = Collections.synchronizedSet(new HashSet());
        this.O0000oOO = new ConcurrentHashMap();
        this.O00000oo = new ConcurrentHashMap(20);
        this.O0000O0o = new ConcurrentHashMap(20);
        this.O0000Oo0 = HostInfo.O000000o(inetAddress, this, null);
        this.O0000o0O = this.O0000Oo0.O000000o();
        O000000o(this.O0000Oo0);
        O000000o(this.O00000oo.values());
        O0000Oo0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* access modifiers changed from: package-private */
    public final void O000000o(Collection<? extends ServiceInfo> collection) {
        if (this.O0000oO0 == null) {
            this.O0000oO0 = new itf(this);
            this.O0000oO0.start();
        }
        O00000oO();
        for (ServiceInfo serviceInfoImpl : collection) {
            try {
                ServiceInfoImpl serviceInfoImpl2 = new ServiceInfoImpl(serviceInfoImpl);
                if (this.O0000Oo0.O00000o.isClosing() || this.O0000Oo0.O00000o.isClosed()) {
                    throw new IllegalStateException("This DNS is closed.");
                }
                ServiceInfoImpl serviceInfoImpl3 = serviceInfoImpl2;
                if (serviceInfoImpl3.O0000OOo.getDns() != null) {
                    if (serviceInfoImpl3.O0000OOo.getDns() != this) {
                        throw new IllegalStateException("A service information can only be registered with a single instamce of JmDNS.");
                    } else if (this.O00000oo.get(serviceInfoImpl3.O0000oOO()) != null) {
                        throw new IllegalStateException("A service information can only be registered once.");
                    }
                }
                serviceInfoImpl3.O000000o(this);
                O00000o0(serviceInfoImpl3.O0000oO());
                serviceInfoImpl3.O0000OOo.recoverState();
                serviceInfoImpl3.O00000Oo = this.O0000Oo0.O000000o();
                serviceInfoImpl3.O000000o(this.O0000Oo0.O00000o0());
                serviceInfoImpl3.O000000o(this.O0000Oo0.O00000o());
                this.O0000Oo0.O00000o.waitForAnnounced(6000);
                O00000Oo(serviceInfoImpl3);
                while (this.O00000oo.putIfAbsent(serviceInfoImpl3.O0000oOO(), serviceInfoImpl3) != null) {
                    O00000Oo(serviceInfoImpl3);
                }
                O00000oO();
                serviceInfoImpl3.O0000OOo.waitForAnnounced(6000);
                if (f15362O000000o.isLoggable(Level.FINE)) {
                    f15362O000000o.fine("registerService() JmDNS registered service as ".concat(String.valueOf(serviceInfoImpl3)));
                }
            } catch (Exception e) {
                f15362O000000o.log(Level.WARNING, "start() Registration exception ", (Throwable) e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(HostInfo hostInfo) throws Exception {
        if (this.O0000o0o == null) {
            if (hostInfo.O00000Oo() instanceof Inet6Address) {
                this.O0000o0o = InetAddress.getByName("FF02::FB");
            } else {
                this.O0000o0o = InetAddress.getByName("224.0.0.251");
            }
        }
        if (this.O00000Oo != null) {
            O0000Oo();
        }
        this.O00000Oo = new MulticastSocket(itg.f1624O000000o);
        if (!(hostInfo == null || hostInfo.O00000oO() == null)) {
            try {
                this.O00000Oo.setNetworkInterface(hostInfo.O00000oO());
            } catch (SocketException e) {
                if (f15362O000000o.isLoggable(Level.FINE)) {
                    Logger logger = f15362O000000o;
                    logger.fine("openMulticastSocket() Set network interface exception: " + e.getMessage());
                }
            }
        }
        this.O00000Oo.setTimeToLive(255);
        this.O00000Oo.joinGroup(this.O0000o0o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:5|6|7|9|10|(3:31|28|11)|32|34|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005e, code lost:
        javax.jmdns.impl.JmDNSImpl.f15362O000000o.log(java.util.logging.Level.WARNING, "closeMulticastSocket() Close socket exception ", (java.lang.Throwable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC, Splitter:B:16:0x0032] */
    public final void O0000Oo() {
        if (f15362O000000o.isLoggable(Level.FINER)) {
            f15362O000000o.finer("closeMulticastSocket()");
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.leaveGroup(this.O0000o0o);
            this.O00000Oo.close();
            while (this.O0000oO0 != null && this.O0000oO0.isAlive()) {
                synchronized (this) {
                    if (this.O0000oO0 != null && this.O0000oO0.isAlive()) {
                        if (f15362O000000o.isLoggable(Level.FINER)) {
                            f15362O000000o.finer("closeMulticastSocket(): waiting for jmDNS monitor");
                        }
                        wait(1000);
                    }
                }
            }
            this.O0000oO0 = null;
            this.O00000Oo = null;
        }
    }

    public boolean advanceState(ith ith) {
        return this.O0000Oo0.advanceState(ith);
    }

    public final void O000000o(ith ith, DNSState dNSState) {
        this.O0000Oo0.O00000o.associateWithTask(ith, dNSState);
    }

    public final void O000000o(ith ith) {
        this.O0000Oo0.O00000o.removeAssociationWithTask(ith);
    }

    public final boolean O0000OoO() {
        return this.O0000Oo0.O00000o.isAnnounced();
    }

    public final boolean O0000Ooo() {
        return this.O0000Oo0.O00000o.isCanceling();
    }

    public final boolean O0000o00() {
        return this.O0000Oo0.O00000o.isCanceled();
    }

    public final boolean O0000o0() {
        return this.O0000Oo0.O00000o.isClosing();
    }

    public final boolean O0000o0O() {
        return this.O0000Oo0.O00000o.isClosed();
    }

    public final boolean O0000o0o() {
        return this.O0000Oo0.O000000o(5000);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: javax.jmdns.impl.JmDNSImpl.O000000o(java.lang.String, _m_j.iss, boolean):void
     arg types: [java.lang.String, javax.jmdns.impl.JmDNSImpl$O000000o, int]
     candidates:
      javax.jmdns.impl.JmDNSImpl.O000000o(long, _m_j.itb, javax.jmdns.impl.JmDNSImpl$Operation):void
      javax.jmdns.impl.JmDNSImpl.O000000o(java.lang.String, _m_j.iss, boolean):void */
    /* access modifiers changed from: package-private */
    public final ServiceInfoImpl O000000o(String str, String str2, String str3, boolean z) {
        O0000oO();
        String lowerCase = str.toLowerCase();
        O00000o0(str);
        if (this.O0000oOO.putIfAbsent(lowerCase, new O000000o(str)) == null) {
            O000000o(lowerCase, (iss) this.O0000oOO.get(lowerCase), true);
        }
        ServiceInfoImpl O00000Oo2 = O00000Oo(str, str2, str3, z);
        O000000o(O00000Oo2);
        return O00000Oo2;
    }

    private ServiceInfoImpl O00000Oo(String str, String str2, String str3, boolean z) {
        ServiceInfoImpl serviceInfoImpl;
        String str4;
        ServiceInfo O000000o2;
        ServiceInfo O000000o3;
        ServiceInfo O000000o4;
        ServiceInfo O000000o5;
        ServiceInfoImpl serviceInfoImpl2 = new ServiceInfoImpl(str, str2, str3, z);
        isv O000000o6 = this.O00000oO.O000000o(new itb.O0000O0o(str, DNSRecordClass.CLASS_ANY, false, 0, serviceInfoImpl2.O00000o()));
        if ((O000000o6 instanceof itb) && (serviceInfoImpl = (ServiceInfoImpl) ((itb) O000000o6).O000000o(z)) != null) {
            Map<ServiceInfo.Fields, String> O0000oOo2 = serviceInfoImpl.O0000oOo();
            byte[] bArr = null;
            isv O000000o7 = this.O00000oO.O000000o(serviceInfoImpl2.O00000o(), DNSRecordType.TYPE_SRV, DNSRecordClass.CLASS_ANY);
            if (!(O000000o7 instanceof itb) || (O000000o5 = ((itb) O000000o7).O000000o(z)) == null) {
                str4 = "";
            } else {
                serviceInfoImpl = new ServiceInfoImpl(O0000oOo2, O000000o5.O0000Oo0(), O000000o5.O0000OoO(), O000000o5.O0000Oo(), z, (byte[]) null);
                bArr = O000000o5.O0000Ooo();
                str4 = O000000o5.O00000oO();
            }
            isv O000000o8 = this.O00000oO.O000000o(str4, DNSRecordType.TYPE_A, DNSRecordClass.CLASS_ANY);
            if ((O000000o8 instanceof itb) && (O000000o4 = ((itb) O000000o8).O000000o(z)) != null) {
                for (Inet4Address O000000o9 : O000000o4.O0000O0o()) {
                    serviceInfoImpl.O000000o(O000000o9);
                }
                serviceInfoImpl.O000000o(O000000o4.O0000Ooo());
            }
            isv O000000o10 = this.O00000oO.O000000o(str4, DNSRecordType.TYPE_AAAA, DNSRecordClass.CLASS_ANY);
            if ((O000000o10 instanceof itb) && (O000000o3 = ((itb) O000000o10).O000000o(z)) != null) {
                for (Inet6Address O000000o11 : O000000o3.O0000OOo()) {
                    serviceInfoImpl.O000000o(O000000o11);
                }
                serviceInfoImpl.O000000o(O000000o3.O0000Ooo());
            }
            isv O000000o12 = this.O00000oO.O000000o(serviceInfoImpl.O00000o(), DNSRecordType.TYPE_TXT, DNSRecordClass.CLASS_ANY);
            if ((O000000o12 instanceof itb) && (O000000o2 = ((itb) O000000o12).O000000o(z)) != null) {
                serviceInfoImpl.O000000o(O000000o2.O0000Ooo());
            }
            if (serviceInfoImpl.O0000Ooo().length == 0) {
                serviceInfoImpl.O000000o(bArr);
            }
            if (serviceInfoImpl.O000000o()) {
                return serviceInfoImpl;
            }
        }
        return serviceInfoImpl2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: javax.jmdns.impl.JmDNSImpl.O000000o(java.lang.String, _m_j.iss, boolean):void
     arg types: [java.lang.String, _m_j.iss, int]
     candidates:
      javax.jmdns.impl.JmDNSImpl.O000000o(long, _m_j.itb, javax.jmdns.impl.JmDNSImpl$Operation):void
      javax.jmdns.impl.JmDNSImpl.O000000o(java.lang.String, _m_j.iss, boolean):void */
    public final void O000000o(String str, iss iss) {
        O000000o(str, iss, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: javax.jmdns.impl.JmDNSImpl.O000000o(java.lang.String, _m_j.iss, boolean):void
     arg types: [java.lang.String, javax.jmdns.impl.JmDNSImpl$O000000o, int]
     candidates:
      javax.jmdns.impl.JmDNSImpl.O000000o(long, _m_j.itb, javax.jmdns.impl.JmDNSImpl$Operation):void
      javax.jmdns.impl.JmDNSImpl.O000000o(java.lang.String, _m_j.iss, boolean):void */
    private void O000000o(String str, iss iss, boolean z) {
        itd.O000000o o000000o = new itd.O000000o(iss, z);
        String lowerCase = str.toLowerCase();
        List list = this.O00000o.get(lowerCase);
        if (list == null) {
            if (this.O00000o.putIfAbsent(lowerCase, new LinkedList()) == null && this.O0000oOO.putIfAbsent(lowerCase, new O000000o(str)) == null) {
                O000000o(lowerCase, (iss) this.O0000oOO.get(lowerCase), true);
            }
            list = this.O00000o.get(lowerCase);
        }
        if (list != null) {
            synchronized (list) {
                if (!list.contains(iss)) {
                    list.add(o000000o);
                }
            }
        }
        ArrayList<ServiceEvent> arrayList = new ArrayList<>();
        Iterator<isv> it = this.O00000oO.O000000o().iterator();
        while (it.hasNext()) {
            itb itb = (itb) it.next();
            if (itb.O00000oO() == DNSRecordType.TYPE_SRV && itb.O00000o().endsWith(lowerCase)) {
                arrayList.add(new ServiceEventImpl(this, itb.O00000o0(), O00000Oo(itb.O00000o0(), itb.O00000Oo()), itb.O000000o(false)));
            }
        }
        for (ServiceEvent O000000o2 : arrayList) {
            o000000o.O000000o(O000000o2);
        }
        O000000o(str);
    }

    public final void O0000o() {
        if (f15362O000000o.isLoggable(Level.FINER)) {
            f15362O000000o.finer("unregisterAllServices()");
        }
        for (String str : this.O00000oo.keySet()) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) this.O00000oo.get(str);
            if (serviceInfoImpl != null) {
                if (f15362O000000o.isLoggable(Level.FINER)) {
                    f15362O000000o.finer("Cancelling service info: ".concat(String.valueOf(serviceInfoImpl)));
                }
                serviceInfoImpl.O0000OOo.cancelState();
            }
        }
        O0000OOo();
        for (String next : this.O00000oo.keySet()) {
            ServiceInfoImpl serviceInfoImpl2 = (ServiceInfoImpl) this.O00000oo.get(next);
            if (serviceInfoImpl2 != null) {
                if (f15362O000000o.isLoggable(Level.FINER)) {
                    f15362O000000o.finer("Wait for service info cancel: ".concat(String.valueOf(serviceInfoImpl2)));
                }
                serviceInfoImpl2.O0000OOo.waitForCanceled(5000);
                this.O00000oo.remove(next, serviceInfoImpl2);
            }
        }
    }

    private boolean O00000o0(String str) {
        String str2;
        String str3;
        boolean z;
        ServiceTypeEntry serviceTypeEntry;
        Map<ServiceInfo.Fields, String> O00000Oo2 = ServiceInfoImpl.O00000Oo(str);
        String str4 = O00000Oo2.get(ServiceInfo.Fields.Domain);
        String str5 = O00000Oo2.get(ServiceInfo.Fields.Protocol);
        String str6 = O00000Oo2.get(ServiceInfo.Fields.Application);
        String str7 = O00000Oo2.get(ServiceInfo.Fields.Subtype);
        StringBuilder sb = new StringBuilder();
        if (str6.length() > 0) {
            str2 = "_" + str6 + ".";
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (str5.length() > 0) {
            str3 = "_" + str5 + ".";
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(str4);
        sb.append(".");
        String sb2 = sb.toString();
        String lowerCase = sb2.toLowerCase();
        if (f15362O000000o.isLoggable(Level.FINE)) {
            Logger logger = f15362O000000o;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.O0000o0O);
            sb3.append(".registering service type: ");
            sb3.append(str);
            sb3.append(" as: ");
            sb3.append(sb2);
            sb3.append(str7.length() > 0 ? " subtype: ".concat(String.valueOf(str7)) : "");
            logger.fine(sb3.toString());
        }
        if (this.O0000O0o.containsKey(lowerCase) || str6.toLowerCase().equals("dns-sd") || str4.toLowerCase().endsWith("in-addr.arpa") || str4.toLowerCase().endsWith("ip6.arpa")) {
            z = false;
        } else {
            z = this.O0000O0o.putIfAbsent(lowerCase, new ServiceTypeEntry(sb2)) == null;
            if (z) {
                Set<itd.O00000Oo> set = this.O0000o;
                itd.O00000Oo[] o00000OoArr = (itd.O00000Oo[]) set.toArray(new itd.O00000Oo[set.size()]);
                final ServiceEventImpl serviceEventImpl = new ServiceEventImpl(this, sb2, "", null);
                for (final itd.O00000Oo o00000Oo : o00000OoArr) {
                    this.O0000Ooo.submit(new Runnable() {
                        /* class javax.jmdns.impl.JmDNSImpl.AnonymousClass2 */

                        public final void run() {
                            itd.O00000Oo o00000Oo = o00000Oo;
                            ServiceEvent serviceEvent = serviceEventImpl;
                            if (o00000Oo.O00000o.putIfAbsent(serviceEvent.O00000Oo(), serviceEvent.O00000Oo()) != null) {
                                itd.O00000Oo.O00000o0.finest("Service Type Added called for a service type already added: ".concat(String.valueOf(serviceEvent)));
                            }
                        }
                    });
                }
            }
        }
        if (str7.length() > 0 && (serviceTypeEntry = this.O0000O0o.get(lowerCase)) != null && !serviceTypeEntry.O000000o(str7)) {
            synchronized (serviceTypeEntry) {
                if (!serviceTypeEntry.O000000o(str7)) {
                    serviceTypeEntry.O00000Oo(str7);
                    itd.O00000Oo[] o00000OoArr2 = (itd.O00000Oo[]) this.O0000o.toArray(new itd.O00000Oo[this.O0000o.size()]);
                    final ServiceEventImpl serviceEventImpl2 = new ServiceEventImpl(this, "_" + str7 + "._sub." + sb2, "", null);
                    for (final itd.O00000Oo o00000Oo2 : o00000OoArr2) {
                        this.O0000Ooo.submit(new Runnable() {
                            /* class javax.jmdns.impl.JmDNSImpl.AnonymousClass3 */

                            public final void run() {
                                itd.O00000Oo o00000Oo = o00000Oo2;
                                ServiceEvent serviceEvent = serviceEventImpl2;
                                if (o00000Oo.O00000o.putIfAbsent(serviceEvent.O00000Oo(), serviceEvent.O00000Oo()) != null) {
                                    itd.O00000Oo.O00000o0.finest("Service Sub Type Added called for a service sub type already added: ".concat(String.valueOf(serviceEvent)));
                                }
                            }
                        });
                    }
                    z = true;
                }
            }
        }
        return z;
    }

    private boolean O00000Oo(ServiceInfoImpl serviceInfoImpl) {
        boolean z;
        isv isv;
        itb.O0000OOo o0000OOo;
        String O0000oOO2 = serviceInfoImpl.O0000oOO();
        long currentTimeMillis = System.currentTimeMillis();
        do {
            Iterator<? extends isv> it = this.O00000oO.O000000o(serviceInfoImpl.O0000oOO()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                isv = (isv) it.next();
                if (DNSRecordType.TYPE_SRV.equals(isv.O00000oO()) && !isv.O000000o(currentTimeMillis)) {
                    o0000OOo = (itb.O0000OOo) isv;
                    if (o0000OOo.O0000Oo0 != serviceInfoImpl.O00000o0 || !o0000OOo.O0000Oo.equals(this.O0000Oo0.O000000o())) {
                    }
                }
            }
            if (f15362O000000o.isLoggable(Level.FINER)) {
                Logger logger = f15362O000000o;
                logger.finer("makeServiceNameUnique() JmDNS.makeServiceNameUnique srv collision:" + isv + " s.server=" + o0000OOo.O0000Oo + " " + this.O0000Oo0.O000000o() + " equals:" + o0000OOo.O0000Oo.equals(this.O0000Oo0.O000000o()));
            }
            serviceInfoImpl.O00000o0(O00000Oo(serviceInfoImpl.O00000o0()));
            z = true;
            ServiceInfo serviceInfo = this.O00000oo.get(serviceInfoImpl.O0000oOO());
            if (!(serviceInfo == null || serviceInfo == serviceInfoImpl)) {
                serviceInfoImpl.O00000o0(O00000Oo(serviceInfoImpl.O00000o0()));
                z = true;
                continue;
            }
        } while (z);
        return !O0000oOO2.equals(serviceInfoImpl.O0000oOO());
    }

    public static String O00000Oo(String str) {
        try {
            int lastIndexOf = str.lastIndexOf(40);
            int lastIndexOf2 = str.lastIndexOf(41);
            if (lastIndexOf < 0 || lastIndexOf >= lastIndexOf2) {
                return str + " (2)";
            }
            return str.substring(0, lastIndexOf) + "(" + (Integer.parseInt(str.substring(lastIndexOf + 1, lastIndexOf2)) + 1) + ")";
        } catch (NumberFormatException unused) {
            return str + " (2)";
        }
    }

    private void O000000o(long j, itb itb, Operation operation) {
        ArrayList<isx> arrayList;
        List<itd.O000000o> list;
        synchronized (this.O00000o0) {
            arrayList = new ArrayList<>(this.O00000o0);
        }
        for (isx O000000o2 : arrayList) {
            O000000o2.O000000o(this.O00000oO, j, itb);
        }
        if (DNSRecordType.TYPE_PTR.equals(itb.O00000oO())) {
            final ServiceEvent O00000o02 = itb.O00000o0(this);
            O00000o02._source = itb.O00000oO;
            if (O00000o02.O00000o() == null || !O00000o02.O00000o().O000000o()) {
                ServiceInfoImpl O00000Oo2 = O00000Oo(O00000o02.O00000Oo(), O00000o02.O00000o0(), "", false);
                if (O00000Oo2.O000000o()) {
                    O00000o02 = new ServiceEventImpl(this, O00000o02.O00000Oo(), O00000o02.O00000o0(), O00000Oo2);
                }
            }
            List list2 = this.O00000o.get(O00000o02.O00000Oo().toLowerCase());
            if (list2 != null) {
                synchronized (list2) {
                    list = new ArrayList<>(list2);
                }
            } else {
                list = Collections.emptyList();
            }
            if (f15362O000000o.isLoggable(Level.FINEST)) {
                Logger logger = f15362O000000o;
                logger.finest(this.O0000o0O + ".updating record for event: " + O00000o02 + " list " + list + " operation: " + operation);
            }
            if (!list.isEmpty()) {
                int i = AnonymousClass7.f15369O000000o[operation.ordinal()];
                if (i == 1) {
                    for (final itd.O000000o o000000o : list) {
                        if (o000000o.O00000Oo) {
                            o000000o.O000000o(O00000o02);
                        } else {
                            this.O0000Ooo.submit(new Runnable() {
                                /* class javax.jmdns.impl.JmDNSImpl.AnonymousClass4 */

                                public final void run() {
                                    o000000o.O000000o(O00000o02);
                                }
                            });
                        }
                    }
                } else if (i == 2) {
                    for (final itd.O000000o o000000o2 : list) {
                        if (o000000o2.O00000Oo) {
                            o000000o2.O00000Oo(O00000o02);
                        } else {
                            this.O0000Ooo.submit(new Runnable() {
                                /* class javax.jmdns.impl.JmDNSImpl.AnonymousClass5 */

                                public final void run() {
                                    o000000o2.O00000Oo(O00000o02);
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    /* renamed from: javax.jmdns.impl.JmDNSImpl$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f15369O000000o = new int[Operation.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f15369O000000o[Operation.Add.ordinal()] = 1;
            f15369O000000o[Operation.Remove.ordinal()] = 2;
        }
    }

    private void O000000o(itb itb, long j) {
        Operation operation = Operation.Noop;
        boolean O000000o2 = itb.O000000o(j);
        if (f15362O000000o.isLoggable(Level.FINE)) {
            Logger logger = f15362O000000o;
            logger.fine(this.O0000o0O + " handle response: " + itb);
        }
        if (!itb.O0000O0o() && !itb.O0000OOo()) {
            boolean z = itb.f1610O000000o;
            itb itb2 = (itb) this.O00000oO.O000000o(itb);
            if (f15362O000000o.isLoggable(Level.FINE)) {
                Logger logger2 = f15362O000000o;
                logger2.fine(this.O0000o0O + " handle response cached record: " + itb2);
            }
            if (z) {
                for (isv isv : this.O00000oO.O000000o(itb.O00000o())) {
                    if (!itb.O00000oO().equals(DNSRecordType.TYPE_PTR) && itb.O00000oO().equals(isv.O00000oO()) && itb.O00000oo().equals(isv.O00000oo()) && isv != itb2) {
                        ((itb) isv).O00000o(j);
                    }
                }
            }
            if (itb2 != null) {
                if (O000000o2) {
                    if (itb.O00000o0 == 0) {
                        operation = Operation.Noop;
                        itb2.O00000o(j);
                    } else {
                        operation = Operation.Remove;
                        this.O00000oO.O00000o0(itb2);
                    }
                } else if (itb.O000000o(itb2) && (itb.O000000o().equals(itb2.O000000o()) || itb.O000000o().length() <= 0)) {
                    itb2.O00000o = itb.O00000o;
                    itb2.O00000o0 = itb.O00000o0;
                    itb = itb2;
                } else if (itb.O0000Ooo()) {
                    operation = Operation.Update;
                    this.O00000oO.O000000o(itb, itb2);
                } else {
                    operation = Operation.Add;
                    this.O00000oO.O00000Oo(itb);
                }
            } else if (!O000000o2) {
                operation = Operation.Add;
                this.O00000oO.O00000Oo(itb);
            }
        }
        if (itb.O00000oO() == DNSRecordType.TYPE_PTR) {
            if (itb.O0000O0o()) {
                if (!O000000o2) {
                    O00000o0(((itb.O0000O0o) itb).O0000O0o);
                    return;
                }
                return;
            } else if ((O00000o0(itb.O00000Oo()) || false) && operation == Operation.Noop) {
                operation = Operation.RegisterServiceType;
            }
        }
        if (operation != Operation.Noop) {
            O000000o(j, itb, operation);
        }
    }

    public final void O000000o(isw isw) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        boolean z2 = false;
        for (itb itb : isw.O00000oo()) {
            O000000o(itb, currentTimeMillis);
            if (DNSRecordType.TYPE_A.equals(itb.O00000oO()) || DNSRecordType.TYPE_AAAA.equals(itb.O00000oO())) {
                z |= itb.O00000Oo(this);
            } else {
                z2 |= itb.O00000Oo(this);
            }
        }
        if (z || z2) {
            O00000oO();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void O00000Oo(isw isw, int i) throws IOException {
        if (f15362O000000o.isLoggable(Level.FINE)) {
            Logger logger = f15362O000000o;
            logger.fine(this.O0000o0O + ".handle query: " + isw);
        }
        boolean z = false;
        System.currentTimeMillis();
        for (itb O000000o2 : isw.O00000oo()) {
            z |= O000000o2.O000000o(this);
        }
        this.O0000o00.lock();
        try {
            if (this.O0000o0 != null) {
                this.O0000o0.O000000o(isw);
            } else {
                isw O000000o3 = isw.clone();
                if (isw.O0000o00()) {
                    this.O0000o0 = O000000o3;
                }
                O000000o(O000000o3, i);
            }
            this.O0000o00.unlock();
            long currentTimeMillis = System.currentTimeMillis();
            for (itb O000000o4 : isw.O0000O0o()) {
                O000000o(O000000o4, currentTimeMillis);
            }
            if (z) {
                O00000oO();
            }
        } catch (Throwable th) {
            this.O0000o00.unlock();
            throw th;
        }
    }

    public final void O000000o(isz isz) throws IOException {
        if (!isz.O0000o0O()) {
            byte[] O000000o2 = isz.O000000o();
            DatagramPacket datagramPacket = new DatagramPacket(O000000o2, O000000o2.length, this.O0000o0o, itg.f1624O000000o);
            if (f15362O000000o.isLoggable(Level.FINEST)) {
                try {
                    isw isw = new isw(datagramPacket);
                    if (f15362O000000o.isLoggable(Level.FINEST)) {
                        Logger logger = f15362O000000o;
                        logger.finest("send(" + this.O0000o0O + ") JmDNS out:" + isw.O00000Oo());
                    }
                } catch (IOException e) {
                    Logger logger2 = f15362O000000o;
                    String cls = getClass().toString();
                    logger2.throwing(cls, "send(" + this.O0000o0O + ") - JmDNS can not parse what it sends!!!", e);
                }
            }
            MulticastSocket multicastSocket = this.O00000Oo;
            if (multicastSocket != null && !multicastSocket.isClosed()) {
                multicastSocket.send(datagramPacket);
            }
        }
    }

    public final void O000000o() {
        itc.O00000Oo.O000000o().O000000o(this).O000000o();
    }

    public final void O00000Oo() {
        itc.O00000Oo.O000000o().O000000o(this).O00000Oo();
    }

    public final void O00000o0() {
        itc.O00000Oo.O000000o().O000000o(this).O00000o0();
    }

    public final void O00000o() {
        itc.O00000Oo.O000000o().O000000o(this).O00000o();
    }

    public final void O00000oO() {
        itc.O00000Oo.O000000o().O000000o(this).O00000oO();
    }

    public final void O00000oo() {
        itc.O00000Oo.O000000o().O000000o(this).O00000oo();
    }

    public final void O0000O0o() {
        itc.O00000Oo.O000000o().O000000o(this).O0000O0o();
    }

    public final void O0000OOo() {
        itc.O00000Oo.O000000o().O000000o(this).O0000OOo();
    }

    public final void O0000Oo0() {
        itc.O00000Oo.O000000o().O000000o(this).O0000Oo0();
    }

    public final void O000000o(ServiceInfoImpl serviceInfoImpl) {
        itc.O00000Oo.O000000o().O000000o(this).O000000o(serviceInfoImpl);
    }

    public final void O000000o(String str) {
        itc.O00000Oo.O000000o().O000000o(this).O000000o(str);
    }

    public final void O000000o(isw isw, int i) {
        itc.O00000Oo.O000000o().O000000o(this).O000000o(isw, i);
    }

    public final void O0000oO0() {
        Logger logger = f15362O000000o;
        logger.finer(this.O0000o0O + "recover()");
        if (!O0000o0() && !O0000o0O() && !O0000Ooo() && !O0000o00()) {
            synchronized (this.O0000oOo) {
                if (this.O0000Oo0.O00000o.cancelState()) {
                    Logger logger2 = f15362O000000o;
                    logger2.finer(this.O0000o0O + "recover() thread " + Thread.currentThread().getName());
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.O0000o0O);
                    sb.append(".recover()");
                    new Thread(sb.toString()) {
                        /* class javax.jmdns.impl.JmDNSImpl.AnonymousClass6 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
                         arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
                         candidates:
                          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
                          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
                          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
                          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
                        public final void run() {
                            JmDNSImpl jmDNSImpl = JmDNSImpl.this;
                            if (JmDNSImpl.f15362O000000o.isLoggable(Level.FINER)) {
                                Logger logger = JmDNSImpl.f15362O000000o;
                                logger.finer(jmDNSImpl.O0000o0O + "recover() Cleanning up");
                            }
                            JmDNSImpl.f15362O000000o.warning("RECOVERING");
                            jmDNSImpl.O000000o();
                            ArrayList<ServiceInfo> arrayList = new ArrayList<>(jmDNSImpl.O00000oo.values());
                            jmDNSImpl.O0000o();
                            jmDNSImpl.O0000oOO();
                            jmDNSImpl.O0000o0o();
                            jmDNSImpl.O00000Oo();
                            jmDNSImpl.O0000Oo();
                            jmDNSImpl.O00000oO.clear();
                            if (JmDNSImpl.f15362O000000o.isLoggable(Level.FINER)) {
                                Logger logger2 = JmDNSImpl.f15362O000000o;
                                logger2.finer(jmDNSImpl.O0000o0O + "recover() All is clean");
                            }
                            if (jmDNSImpl.O0000o00()) {
                                for (ServiceInfo serviceInfo : arrayList) {
                                    ((ServiceInfoImpl) serviceInfo).O0000OOo.recoverState();
                                }
                                jmDNSImpl.O0000Oo0.O00000o.recoverState();
                                try {
                                    jmDNSImpl.O000000o(jmDNSImpl.O0000Oo0);
                                    jmDNSImpl.O000000o(arrayList);
                                } catch (Exception e) {
                                    Logger logger3 = JmDNSImpl.f15362O000000o;
                                    Level level = Level.WARNING;
                                    logger3.log(level, jmDNSImpl.O0000o0O + "recover() Start services exception ", (Throwable) e);
                                }
                                Logger logger4 = JmDNSImpl.f15362O000000o;
                                Level level2 = Level.WARNING;
                                logger4.log(level2, jmDNSImpl.O0000o0O + "recover() We are back!");
                                return;
                            }
                            Logger logger5 = JmDNSImpl.f15362O000000o;
                            Level level3 = Level.WARNING;
                            logger5.log(level3, jmDNSImpl.O0000o0O + "recover() Could not recover we are Down!");
                        }
                    }.start();
                }
            }
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
    public final void O0000oO() {
        long currentTimeMillis = System.currentTimeMillis();
        for (isv next : this.O00000oO.O000000o()) {
            try {
                itb itb = (itb) next;
                if (itb.O000000o(currentTimeMillis)) {
                    O000000o(currentTimeMillis, itb, Operation.Remove);
                    this.O00000oO.O00000o0(itb);
                } else if (itb.O00000o0(currentTimeMillis)) {
                    O000000o(itb);
                }
            } catch (Exception e) {
                Logger logger = f15362O000000o;
                Level level = Level.SEVERE;
                logger.log(level, this.O0000o0O + ".Error while reaping records: " + next, (Throwable) e);
                f15362O000000o.severe(toString());
            }
        }
    }

    public void close() {
        if (!O0000o0()) {
            if (f15362O000000o.isLoggable(Level.FINER)) {
                f15362O000000o.finer("Cancelling JmDNS: ".concat(String.valueOf(this)));
            }
            if (this.O0000Oo0.O00000o.closeState()) {
                f15362O000000o.finer("Canceling the timer");
                O00000o0();
                O0000o();
                O0000oOO();
                if (f15362O000000o.isLoggable(Level.FINER)) {
                    f15362O000000o.finer("Wait for JmDNS cancel: ".concat(String.valueOf(this)));
                }
                O0000o0o();
                f15362O000000o.finer("Canceling the state timer");
                O00000o();
                this.O0000Ooo.shutdown();
                O0000Oo();
                if (this.O0000OOo != null) {
                    Runtime.getRuntime().removeShutdownHook(this.O0000OOo);
                }
                if (f15362O000000o.isLoggable(Level.FINER)) {
                    f15362O000000o.finer("JmDNS closed.");
                }
            }
            advanceState(null);
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:24:0x0085 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:23:0x0085 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.Object} */
    /* JADX WARN: Type inference failed for: r4v10, types: [javax.jmdns.impl.JmDNSImpl$ServiceTypeEntry] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    public String toString() {
        StringBuilder sb = new StringBuilder(2048);
        sb.append("\t---- Local Host -----");
        sb.append("\n\t");
        sb.append(this.O0000Oo0);
        sb.append("\n\t---- Services -----");
        for (String next : this.O00000oo.keySet()) {
            sb.append("\n\t\tService: ");
            sb.append(next);
            sb.append(": ");
            sb.append(this.O00000oo.get(next));
        }
        sb.append("\n");
        sb.append("\t---- Types ----");
        for (String str : this.O0000O0o.keySet()) {
            ? r4 = this.O0000O0o.get(str);
            sb.append("\n\t\tType: ");
            sb.append(r4.f15371O000000o);
            sb.append(": ");
            if (r4.isEmpty()) {
                r4 = "no subtypes";
            }
            sb.append(r4);
        }
        sb.append("\n");
        sb.append(this.O00000oO.toString());
        sb.append("\n");
        sb.append("\t---- Service Collectors ----");
        for (String next2 : this.O0000oOO.keySet()) {
            sb.append("\n\t\tService Collector: ");
            sb.append(next2);
            sb.append(": ");
            sb.append(this.O0000oOO.get(next2));
        }
        sb.append("\n");
        sb.append("\t---- Service Listeners ----");
        for (String next3 : this.O00000o.keySet()) {
            sb.append("\n\t\tService Listener: ");
            sb.append(next3);
            sb.append(": ");
            sb.append(this.O00000o.get(next3));
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void O0000oOO() {
        if (f15362O000000o.isLoggable(Level.FINER)) {
            f15362O000000o.finer("disposeServiceCollectors()");
        }
        for (String next : this.O0000oOO.keySet()) {
            O000000o o000000o = this.O0000oOO.get(next);
            if (o000000o != null) {
                String lowerCase = next.toLowerCase();
                List list = this.O00000o.get(lowerCase);
                if (list != null) {
                    synchronized (list) {
                        list.remove(new itd.O000000o(o000000o, false));
                        if (list.isEmpty()) {
                            this.O00000o.remove(lowerCase, list);
                        }
                    }
                }
                this.O0000oOO.remove(next, o000000o);
            }
        }
    }

    static class O000000o implements iss {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ConcurrentMap<String, ServiceInfo> f15370O000000o = new ConcurrentHashMap();
        private final ConcurrentMap<String, ServiceEvent> O00000Oo = new ConcurrentHashMap();
        private volatile boolean O00000o;
        private final String O00000o0;

        public O000000o(String str) {
            this.O00000o0 = str;
            this.O00000o = true;
        }

        public final void O000000o(ServiceEvent serviceEvent) {
            synchronized (this) {
                ServiceInfo O00000o2 = serviceEvent.O00000o();
                if (O00000o2 == null || !O00000o2.O000000o()) {
                    ServiceInfoImpl O000000o2 = ((JmDNSImpl) serviceEvent.O000000o()).O000000o(serviceEvent.O00000Oo(), serviceEvent.O00000o0(), O00000o2 != null ? O00000o2.O0000o() : "", true);
                    if (O000000o2 != null) {
                        this.f15370O000000o.put(serviceEvent.O00000o0(), O000000o2);
                    } else {
                        this.O00000Oo.put(serviceEvent.O00000o0(), serviceEvent);
                    }
                } else {
                    this.f15370O000000o.put(serviceEvent.O00000o0(), O00000o2);
                }
            }
        }

        public final void O00000Oo(ServiceEvent serviceEvent) {
            synchronized (this) {
                this.f15370O000000o.remove(serviceEvent.O00000o0());
                this.O00000Oo.remove(serviceEvent.O00000o0());
            }
        }

        public final void O00000o0(ServiceEvent serviceEvent) {
            synchronized (this) {
                this.f15370O000000o.put(serviceEvent.O00000o0(), serviceEvent.O00000o());
                this.O00000Oo.remove(serviceEvent.O00000o0());
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\n\tType: ");
            sb.append(this.O00000o0);
            if (this.f15370O000000o.isEmpty()) {
                sb.append("\n\tNo services collected.");
            } else {
                sb.append("\n\tServices");
                for (String next : this.f15370O000000o.keySet()) {
                    sb.append("\n\t\tService: ");
                    sb.append(next);
                    sb.append(": ");
                    sb.append(this.f15370O000000o.get(next));
                }
            }
            if (this.O00000Oo.isEmpty()) {
                sb.append("\n\tNo event queued.");
            } else {
                sb.append("\n\tEvents");
                for (String next2 : this.O00000Oo.keySet()) {
                    sb.append("\n\t\tEvent: ");
                    sb.append(next2);
                    sb.append(": ");
                    sb.append(this.O00000Oo.get(next2));
                }
            }
            return sb.toString();
        }
    }

    public static String O00000Oo(String str, String str2) {
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        return (!lowerCase2.endsWith(lowerCase) || lowerCase2.equals(lowerCase)) ? str2 : str2.substring(0, (str2.length() - str.length()) - 1);
    }

    public static Random O0000oOo() {
        return O0000oO;
    }

    public final ServiceInfo O000000o(String str, String str2) {
        int i = 0;
        ServiceInfoImpl O000000o2 = O000000o(str, str2, "", false);
        synchronized (O000000o2) {
            while (((long) i) < 30) {
                if (!O000000o2.O000000o()) {
                    try {
                        O000000o2.wait(200);
                    } catch (InterruptedException unused) {
                    }
                    i++;
                }
            }
        }
        if (O000000o2.O000000o()) {
            return O000000o2;
        }
        return null;
    }

    private void O000000o(itb itb) {
        ServiceInfo O000000o2 = itb.O000000o(false);
        if (this.O0000oOO.containsKey(O000000o2.O00000Oo().toLowerCase())) {
            O000000o(O000000o2.O00000Oo());
        }
    }
}
