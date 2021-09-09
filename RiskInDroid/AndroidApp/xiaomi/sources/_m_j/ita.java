package _m_j;

import _m_j.itb;
import com.google.android.exoplayer2.C;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;

public class ita extends isv {
    private static Logger O00000o0 = Logger.getLogger(ita.class.getName());

    public final void O000000o(StringBuilder sb) {
    }

    public void O000000o(JmDNSImpl jmDNSImpl, Set<itb> set) {
    }

    public final boolean O000000o(long j) {
        return false;
    }

    public boolean O000000o(JmDNSImpl jmDNSImpl) {
        return false;
    }

    static class O00000Oo extends ita {
        O00000Oo(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            String lowerCase = O00000Oo().toLowerCase();
            return jmDNSImpl.O0000Oo0.O000000o().equals(lowerCase) || jmDNSImpl.O00000oo.keySet().contains(lowerCase);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: javax.jmdns.impl.HostInfo.O000000o(javax.jmdns.impl.constants.DNSRecordType, boolean):_m_j.itb$O000000o
         arg types: [javax.jmdns.impl.constants.DNSRecordType, int]
         candidates:
          javax.jmdns.impl.HostInfo.O000000o(boolean, int):java.util.Collection<_m_j.itb>
          javax.jmdns.impl.HostInfo.O000000o(javax.jmdns.impl.constants.DNSRecordType, boolean):_m_j.itb$O000000o */
        public final void O000000o(JmDNSImpl jmDNSImpl, Set<itb> set) {
            itb.O000000o O000000o2 = jmDNSImpl.O0000Oo0.O000000o(O00000oO(), true);
            if (O000000o2 != null) {
                set.add(O000000o2);
            }
        }
    }

    static class O00000o0 extends ita {
        O00000o0(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            String lowerCase = O00000Oo().toLowerCase();
            return jmDNSImpl.O0000Oo0.O000000o().equals(lowerCase) || jmDNSImpl.O00000oo.keySet().contains(lowerCase);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: javax.jmdns.impl.HostInfo.O000000o(javax.jmdns.impl.constants.DNSRecordType, boolean):_m_j.itb$O000000o
         arg types: [javax.jmdns.impl.constants.DNSRecordType, int]
         candidates:
          javax.jmdns.impl.HostInfo.O000000o(boolean, int):java.util.Collection<_m_j.itb>
          javax.jmdns.impl.HostInfo.O000000o(javax.jmdns.impl.constants.DNSRecordType, boolean):_m_j.itb$O000000o */
        public final void O000000o(JmDNSImpl jmDNSImpl, Set<itb> set) {
            itb.O000000o O000000o2 = jmDNSImpl.O0000Oo0.O000000o(O00000oO(), true);
            if (O000000o2 != null) {
                set.add(O000000o2);
            }
        }
    }

    static class O00000o extends ita {
        O00000o(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }
    }

    static class O0000O0o extends ita {
        O0000O0o(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        public final void O000000o(JmDNSImpl jmDNSImpl, Set<itb> set) {
            Iterator<ServiceInfo> it = jmDNSImpl.O00000oo.values().iterator();
            while (it.hasNext()) {
                O000000o(jmDNSImpl, set, (ServiceInfoImpl) it.next());
            }
            if (O0000O0o()) {
                for (String str : jmDNSImpl.O0000O0o.keySet()) {
                    set.add(new itb.O0000O0o("_services._dns-sd._udp.local.", DNSRecordClass.CLASS_IN, false, 3600, jmDNSImpl.O0000O0o.get(str).f15371O000000o));
                }
            } else if (O0000Oo0()) {
                String str2 = (String) Collections.unmodifiableMap(this.O00000Oo).get(ServiceInfo.Fields.Instance);
                if (str2 != null && str2.length() > 0) {
                    InetAddress O00000Oo = jmDNSImpl.O0000Oo0.O00000Oo();
                    if (str2.equalsIgnoreCase(O00000Oo != null ? O00000Oo.getHostAddress() : "")) {
                        if (O0000Oo()) {
                            set.add(jmDNSImpl.O0000Oo0.O000000o(DNSRecordType.TYPE_A));
                        }
                        if (O0000OoO()) {
                            set.add(jmDNSImpl.O0000Oo0.O000000o(DNSRecordType.TYPE_AAAA));
                        }
                    }
                }
            } else {
                O0000OOo();
            }
        }
    }

    static class O0000OOo extends ita {
        O0000OOo(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        public final void O000000o(JmDNSImpl jmDNSImpl, Set<itb> set) {
            String lowerCase = O00000Oo().toLowerCase();
            if (jmDNSImpl.O0000Oo0.O000000o().equalsIgnoreCase(lowerCase)) {
                set.addAll(jmDNSImpl.O0000Oo0.O000000o(this.f1610O000000o, 3600));
            } else if (jmDNSImpl.O0000O0o.containsKey(lowerCase)) {
                new O0000O0o(O00000Oo(), DNSRecordType.TYPE_PTR, O00000oo(), this.f1610O000000o).O000000o(jmDNSImpl, set);
            } else {
                O000000o(jmDNSImpl, set, (ServiceInfoImpl) jmDNSImpl.O00000oo.get(lowerCase));
            }
        }

        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            String lowerCase = O00000Oo().toLowerCase();
            return jmDNSImpl.O0000Oo0.O000000o().equals(lowerCase) || jmDNSImpl.O00000oo.keySet().contains(lowerCase);
        }
    }

    static class O0000Oo0 extends ita {
        O0000Oo0(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            String lowerCase = O00000Oo().toLowerCase();
            return jmDNSImpl.O0000Oo0.O000000o().equals(lowerCase) || jmDNSImpl.O00000oo.keySet().contains(lowerCase);
        }

        public final void O000000o(JmDNSImpl jmDNSImpl, Set<itb> set) {
            O000000o(jmDNSImpl, set, (ServiceInfoImpl) jmDNSImpl.O00000oo.get(O00000Oo().toLowerCase()));
        }
    }

    static class O000000o extends ita {
        public final boolean O00000Oo(isv isv) {
            return isv != null;
        }

        O000000o(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        public final void O000000o(JmDNSImpl jmDNSImpl, Set<itb> set) {
            String lowerCase = O00000Oo().toLowerCase();
            if (jmDNSImpl.O0000Oo0.O000000o().equalsIgnoreCase(lowerCase)) {
                set.addAll(jmDNSImpl.O0000Oo0.O000000o(this.f1610O000000o, 3600));
            } else if (jmDNSImpl.O0000O0o.containsKey(lowerCase)) {
                new O0000O0o(O00000Oo(), DNSRecordType.TYPE_PTR, O00000oo(), this.f1610O000000o).O000000o(jmDNSImpl, set);
            } else {
                O000000o(jmDNSImpl, set, (ServiceInfoImpl) jmDNSImpl.O00000oo.get(lowerCase));
            }
        }

        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            String lowerCase = O00000Oo().toLowerCase();
            return jmDNSImpl.O0000Oo0.O000000o().equals(lowerCase) || jmDNSImpl.O00000oo.keySet().contains(lowerCase);
        }
    }

    ita(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
        super(str, dNSRecordType, dNSRecordClass, z);
    }

    /* renamed from: _m_j.ita$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1617O000000o = new int[DNSRecordType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f1617O000000o[DNSRecordType.TYPE_A.ordinal()] = 1;
            f1617O000000o[DNSRecordType.TYPE_A6.ordinal()] = 2;
            f1617O000000o[DNSRecordType.TYPE_AAAA.ordinal()] = 3;
            f1617O000000o[DNSRecordType.TYPE_ANY.ordinal()] = 4;
            f1617O000000o[DNSRecordType.TYPE_HINFO.ordinal()] = 5;
            f1617O000000o[DNSRecordType.TYPE_PTR.ordinal()] = 6;
            f1617O000000o[DNSRecordType.TYPE_SRV.ordinal()] = 7;
            try {
                f1617O000000o[DNSRecordType.TYPE_TXT.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static ita O000000o(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
        switch (AnonymousClass1.f1617O000000o[dNSRecordType.ordinal()]) {
            case 1:
                return new O00000Oo(str, dNSRecordType, dNSRecordClass, z);
            case 2:
                return new O00000o0(str, dNSRecordType, dNSRecordClass, z);
            case 3:
                return new O00000o0(str, dNSRecordType, dNSRecordClass, z);
            case 4:
                return new O000000o(str, dNSRecordType, dNSRecordClass, z);
            case 5:
                return new O00000o(str, dNSRecordType, dNSRecordClass, z);
            case 6:
                return new O0000O0o(str, dNSRecordType, dNSRecordClass, z);
            case 7:
                return new O0000OOo(str, dNSRecordType, dNSRecordClass, z);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return new O0000Oo0(str, dNSRecordType, dNSRecordClass, z);
            default:
                return new ita(str, dNSRecordType, dNSRecordClass, z);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: javax.jmdns.impl.HostInfo.O000000o(boolean, int):java.util.Collection<_m_j.itb>
     arg types: [int, int]
     candidates:
      javax.jmdns.impl.HostInfo.O000000o(javax.jmdns.impl.constants.DNSRecordType, boolean):_m_j.itb$O000000o
      javax.jmdns.impl.HostInfo.O000000o(boolean, int):java.util.Collection<_m_j.itb> */
    /* access modifiers changed from: protected */
    public final void O000000o(JmDNSImpl jmDNSImpl, Set<itb> set, ServiceInfoImpl serviceInfoImpl) {
        if (serviceInfoImpl != null && serviceInfoImpl.O0000OOo.isAnnounced()) {
            if (O00000Oo().equalsIgnoreCase(serviceInfoImpl.O00000o()) || O00000Oo().equalsIgnoreCase(serviceInfoImpl.O00000Oo())) {
                set.addAll(jmDNSImpl.O0000Oo0.O000000o(true, 3600));
                set.addAll(serviceInfoImpl.O000000o(3600, jmDNSImpl.O0000Oo0));
            }
            if (O00000o0.isLoggable(Level.FINER)) {
                Logger logger = O00000o0;
                logger.finer(jmDNSImpl.O0000o0O + " DNSQuestion(" + O00000Oo() + ").addAnswersForServiceInfo(): info: " + serviceInfoImpl + "\n" + set);
            }
        }
    }
}
