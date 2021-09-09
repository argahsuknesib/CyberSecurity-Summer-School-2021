package _m_j;

import _m_j.isz;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceEventImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;

public abstract class itb extends isv {
    public static final byte[] O00000oo = {0};
    private static Logger O0000O0o = Logger.getLogger(itb.class.getName());
    public long O00000o = System.currentTimeMillis();
    public int O00000o0;
    public InetAddress O00000oO;

    public abstract ServiceInfo O000000o(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void O000000o(isz.O000000o o000000o);

    public abstract boolean O000000o(itb itb);

    public abstract boolean O000000o(JmDNSImpl jmDNSImpl);

    public abstract boolean O00000Oo(JmDNSImpl jmDNSImpl);

    public abstract ServiceEvent O00000o0(JmDNSImpl jmDNSImpl);

    public abstract boolean O0000Ooo();

    itb(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z, int i) {
        super(str, dNSRecordType, dNSRecordClass, z);
        this.O00000o0 = i;
    }

    public boolean equals(Object obj) {
        return (obj instanceof itb) && super.equals(obj) && O000000o((itb) obj);
    }

    public final boolean O00000Oo(itb itb) {
        return O00000oO() == itb.O00000oO();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.ArrayIndexOutOfBoundsException]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* access modifiers changed from: package-private */
    public final boolean O000000o(isw isw) {
        boolean z;
        try {
            for (itb itb : isw.O00000oo()) {
                if (!equals(itb) || itb.O00000o0 <= this.O00000o0 / 2) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger logger = O0000O0o;
            Level level = Level.WARNING;
            logger.log(level, "suppressedBy() message " + isw + " exception ", (Throwable) e);
            return false;
        }
    }

    private long O000000o(int i) {
        return this.O00000o + (((long) (i * this.O00000o0)) * 10);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* access modifiers changed from: package-private */
    public final int O00000Oo(long j) {
        return (int) Math.max(0L, (O000000o(100) - j) / 1000);
    }

    public final boolean O000000o(long j) {
        return O000000o(100) <= j;
    }

    public final boolean O00000o0(long j) {
        return O000000o(50) <= j;
    }

    public final void O00000o(long j) {
        this.O00000o = j;
        this.O00000o0 = 1;
    }

    public static class O00000o0 extends O000000o {
        public O00000o0(String str, DNSRecordClass dNSRecordClass, boolean z, int i, InetAddress inetAddress) {
            super(str, DNSRecordType.TYPE_A, dNSRecordClass, z, i, inetAddress);
        }

        O00000o0(String str, DNSRecordClass dNSRecordClass, boolean z, int i, byte[] bArr) {
            super(str, DNSRecordType.TYPE_A, dNSRecordClass, z, i, bArr);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(isz.O000000o o000000o) {
            if (this.O0000O0o != null) {
                byte[] address = this.O0000O0o.getAddress();
                if (!(this.O0000O0o instanceof Inet4Address)) {
                    byte[] bArr = new byte[4];
                    System.arraycopy(address, 12, bArr, 0, 4);
                    address = bArr;
                }
                o000000o.O000000o(address, address.length);
            }
        }

        public final ServiceInfo O000000o(boolean z) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) super.O000000o(z);
            serviceInfoImpl.O000000o((Inet4Address) this.O0000O0o);
            return serviceInfoImpl;
        }
    }

    public static class O00000o extends O000000o {
        public O00000o(String str, DNSRecordClass dNSRecordClass, boolean z, int i, InetAddress inetAddress) {
            super(str, DNSRecordType.TYPE_AAAA, dNSRecordClass, z, i, inetAddress);
        }

        O00000o(String str, DNSRecordClass dNSRecordClass, boolean z, int i, byte[] bArr) {
            super(str, DNSRecordType.TYPE_AAAA, dNSRecordClass, z, i, bArr);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(isz.O000000o o000000o) {
            if (this.O0000O0o != null) {
                byte[] address = this.O0000O0o.getAddress();
                if (this.O0000O0o instanceof Inet4Address) {
                    byte[] bArr = new byte[16];
                    for (int i = 0; i < 16; i++) {
                        if (i < 11) {
                            bArr[i] = address[i - 12];
                        } else {
                            bArr[i] = 0;
                        }
                    }
                    address = bArr;
                }
                o000000o.O000000o(address, address.length);
            }
        }

        public final ServiceInfo O000000o(boolean z) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) super.O000000o(z);
            serviceInfoImpl.O000000o((Inet6Address) this.O0000O0o);
            return serviceInfoImpl;
        }
    }

    public static abstract class O000000o extends itb {
        private static Logger O0000OOo = Logger.getLogger(O000000o.class.getName());
        public InetAddress O0000O0o;

        public final boolean O0000Ooo() {
            return false;
        }

        protected O000000o(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z, int i, InetAddress inetAddress) {
            super(str, dNSRecordType, dNSRecordClass, z, i);
            this.O0000O0o = inetAddress;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.net.UnknownHostException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        protected O000000o(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z, int i, byte[] bArr) {
            super(str, dNSRecordType, dNSRecordClass, z, i);
            try {
                this.O0000O0o = InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                O0000OOo.log(Level.WARNING, "Address() exception ", (Throwable) e);
            }
        }

        public final boolean O00000o0(itb itb) {
            return O00000Oo().equalsIgnoreCase(itb.O00000Oo());
        }

        public final boolean O000000o(itb itb) {
            if (!(itb instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) itb;
            if (this.O0000O0o == null && o000000o.O0000O0o != null) {
                return false;
            }
            try {
                return this.O0000O0o.equals(o000000o.O0000O0o);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public final void O000000o(DataOutputStream dataOutputStream) throws IOException {
            itb.super.O000000o(dataOutputStream);
            for (byte writeByte : this.O0000O0o.getAddress()) {
                dataOutputStream.writeByte(writeByte);
            }
        }

        public ServiceInfo O000000o(boolean z) {
            return new ServiceInfoImpl(Collections.unmodifiableMap(this.O00000Oo), 0, 0, 0, z, (byte[]) null);
        }

        public final ServiceEvent O00000o0(JmDNSImpl jmDNSImpl) {
            ServiceInfo O000000o2 = O000000o(false);
            ((ServiceInfoImpl) O000000o2).O000000o(jmDNSImpl);
            return new ServiceEventImpl(jmDNSImpl, O000000o2.O00000Oo(), O000000o2.O00000o0(), O000000o2);
        }

        /* access modifiers changed from: protected */
        public final void O000000o(StringBuilder sb) {
            itb.super.O000000o(sb);
            sb.append(" address: '");
            InetAddress inetAddress = this.O0000O0o;
            sb.append(inetAddress != null ? inetAddress.getHostAddress() : "null");
            sb.append("'");
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            if (!jmDNSImpl.O0000Oo0.O000000o(this)) {
                return false;
            }
            int O00000o0 = O00000o0((isv) jmDNSImpl.O0000Oo0.O000000o(O00000oO(), this.f1610O000000o));
            if (O00000o0 == 0) {
                O0000OOo.finer("handleQuery() Ignoring an identical address query");
                return false;
            }
            O0000OOo.finer("handleQuery() Conflicting query detected.");
            if (jmDNSImpl.O0000Oo0.O00000o.isProbing() && O00000o0 > 0) {
                jmDNSImpl.O0000Oo0.O00000oo();
                jmDNSImpl.O00000oO.clear();
                Iterator<ServiceInfo> it = jmDNSImpl.O00000oo.values().iterator();
                while (it.hasNext()) {
                    ((ServiceInfoImpl) it.next()).O0000OOo.revertState();
                }
            }
            jmDNSImpl.O0000Oo0.O00000o.revertState();
            return true;
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000Oo(JmDNSImpl jmDNSImpl) {
            if (!jmDNSImpl.O0000Oo0.O000000o(this)) {
                return false;
            }
            O0000OOo.finer("handleResponse() Denial detected");
            if (jmDNSImpl.O0000Oo0.O00000o.isProbing()) {
                jmDNSImpl.O0000Oo0.O00000oo();
                jmDNSImpl.O00000oO.clear();
                Iterator<ServiceInfo> it = jmDNSImpl.O00000oo.values().iterator();
                while (it.hasNext()) {
                    ((ServiceInfoImpl) it.next()).O0000OOo.revertState();
                }
            }
            jmDNSImpl.O0000Oo0.O00000o.revertState();
            return true;
        }
    }

    public static class O0000O0o extends itb {
        public final String O0000O0o;

        /* access modifiers changed from: package-private */
        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000Oo(JmDNSImpl jmDNSImpl) {
            return false;
        }

        public final boolean O0000Ooo() {
            return false;
        }

        public O0000O0o(String str, DNSRecordClass dNSRecordClass, boolean z, int i, String str2) {
            super(str, DNSRecordType.TYPE_PTR, dNSRecordClass, z, i);
            this.O0000O0o = str2;
        }

        public final boolean O000000o(isv isv) {
            return itb.super.O000000o(isv) && (isv instanceof O0000O0o) && O000000o((O0000O0o) isv);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(isz.O000000o o000000o) {
            o000000o.O000000o(this.O0000O0o);
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(itb itb) {
            if (!(itb instanceof O0000O0o)) {
                return false;
            }
            O0000O0o o0000O0o = (O0000O0o) itb;
            if (this.O0000O0o != null || o0000O0o.O0000O0o == null) {
                return this.O0000O0o.equals(o0000O0o.O0000O0o);
            }
            return false;
        }

        public final ServiceInfo O000000o(boolean z) {
            if (O0000O0o()) {
                return new ServiceInfoImpl(ServiceInfoImpl.O00000Oo(this.O0000O0o), 0, 0, 0, z, (byte[]) null);
            }
            if (O0000Oo0()) {
                return new ServiceInfoImpl(Collections.unmodifiableMap(this.O00000Oo), 0, 0, 0, z, (byte[]) null);
            }
            if (O0000OOo()) {
                return new ServiceInfoImpl(Collections.unmodifiableMap(this.O00000Oo), 0, 0, 0, z, (byte[]) null);
            }
            Map<ServiceInfo.Fields, String> O00000Oo = ServiceInfoImpl.O00000Oo(this.O0000O0o);
            O00000Oo.put(ServiceInfo.Fields.Subtype, Collections.unmodifiableMap(this.O00000Oo).get(ServiceInfo.Fields.Subtype));
            return new ServiceInfoImpl(O00000Oo, 0, 0, 0, z, this.O0000O0o);
        }

        public final ServiceEvent O00000o0(JmDNSImpl jmDNSImpl) {
            ServiceInfo O000000o2 = O000000o(false);
            ((ServiceInfoImpl) O000000o2).O000000o(jmDNSImpl);
            String O00000Oo = O000000o2.O00000Oo();
            return new ServiceEventImpl(jmDNSImpl, O00000Oo, JmDNSImpl.O00000Oo(O00000Oo, this.O0000O0o), O000000o2);
        }

        /* access modifiers changed from: protected */
        public final void O000000o(StringBuilder sb) {
            itb.super.O000000o(sb);
            sb.append(" alias: '");
            String str = this.O0000O0o;
            sb.append(str != null ? str.toString() : "null");
            sb.append("'");
        }
    }

    public static class O0000Oo0 extends itb {
        public final byte[] O0000O0o;

        /* access modifiers changed from: package-private */
        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000Oo(JmDNSImpl jmDNSImpl) {
            return false;
        }

        public final boolean O0000Ooo() {
            return true;
        }

        public O0000Oo0(String str, DNSRecordClass dNSRecordClass, boolean z, int i, byte[] bArr) {
            super(str, DNSRecordType.TYPE_TXT, dNSRecordClass, z, i);
            this.O0000O0o = (bArr == null || bArr.length <= 0) ? O00000oo : bArr;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(isz.O000000o o000000o) {
            byte[] bArr = this.O0000O0o;
            o000000o.O000000o(bArr, bArr.length);
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(itb itb) {
            if (!(itb instanceof O0000Oo0)) {
                return false;
            }
            O0000Oo0 o0000Oo0 = (O0000Oo0) itb;
            if (this.O0000O0o == null && o0000Oo0.O0000O0o != null) {
                return false;
            }
            int length = o0000Oo0.O0000O0o.length;
            byte[] bArr = this.O0000O0o;
            if (length != bArr.length) {
                return false;
            }
            int length2 = bArr.length;
            while (true) {
                int i = length2 - 1;
                if (length2 <= 0) {
                    return true;
                }
                if (o0000Oo0.O0000O0o[i] != this.O0000O0o[i]) {
                    return false;
                }
                length2 = i;
            }
        }

        public final ServiceInfo O000000o(boolean z) {
            return new ServiceInfoImpl(Collections.unmodifiableMap(this.O00000Oo), 0, 0, 0, z, this.O0000O0o);
        }

        public final ServiceEvent O00000o0(JmDNSImpl jmDNSImpl) {
            ServiceInfo O000000o2 = O000000o(false);
            ((ServiceInfoImpl) O000000o2).O000000o(jmDNSImpl);
            return new ServiceEventImpl(jmDNSImpl, O000000o2.O00000Oo(), O000000o2.O00000o0(), O000000o2);
        }

        /* access modifiers changed from: protected */
        public final void O000000o(StringBuilder sb) {
            String str;
            itb.super.O000000o(sb);
            sb.append(" text: '");
            byte[] bArr = this.O0000O0o;
            if (bArr.length > 20) {
                str = new String(this.O0000O0o, 0, 17) + "...";
            } else {
                str = new String(bArr);
            }
            sb.append(str);
            sb.append("'");
        }
    }

    public static class O0000OOo extends itb {
        private static Logger O0000OoO = Logger.getLogger(O0000OOo.class.getName());
        public final int O0000O0o;
        public final int O0000OOo;
        public final String O0000Oo;
        public final int O0000Oo0;

        public final boolean O0000Ooo() {
            return true;
        }

        public O0000OOo(String str, DNSRecordClass dNSRecordClass, boolean z, int i, int i2, int i3, int i4, String str2) {
            super(str, DNSRecordType.TYPE_SRV, dNSRecordClass, z, i);
            this.O0000O0o = i2;
            this.O0000OOo = i3;
            this.O0000Oo0 = i4;
            this.O0000Oo = str2;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(isz.O000000o o000000o) {
            o000000o.O00000Oo(this.O0000O0o);
            o000000o.O00000Oo(this.O0000OOo);
            o000000o.O00000Oo(this.O0000Oo0);
            if (isw.f1611O000000o) {
                o000000o.O000000o(this.O0000Oo);
                return;
            }
            String str = this.O0000Oo;
            o000000o.O000000o(str, str.length());
            o000000o.O000000o(0);
        }

        /* access modifiers changed from: protected */
        public final void O000000o(DataOutputStream dataOutputStream) throws IOException {
            itb.super.O000000o(dataOutputStream);
            dataOutputStream.writeShort(this.O0000O0o);
            dataOutputStream.writeShort(this.O0000OOo);
            dataOutputStream.writeShort(this.O0000Oo0);
            try {
                dataOutputStream.write(this.O0000Oo.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(itb itb) {
            if (!(itb instanceof O0000OOo)) {
                return false;
            }
            O0000OOo o0000OOo = (O0000OOo) itb;
            if (this.O0000O0o == o0000OOo.O0000O0o && this.O0000OOo == o0000OOo.O0000OOo && this.O0000Oo0 == o0000OOo.O0000Oo0 && this.O0000Oo.equals(o0000OOo.O0000Oo)) {
                return true;
            }
            return false;
        }

        public final ServiceInfo O000000o(boolean z) {
            return new ServiceInfoImpl(Collections.unmodifiableMap(this.O00000Oo), this.O0000Oo0, this.O0000OOo, this.O0000O0o, z, this.O0000Oo);
        }

        public final ServiceEvent O00000o0(JmDNSImpl jmDNSImpl) {
            ServiceInfo O000000o2 = O000000o(false);
            ((ServiceInfoImpl) O000000o2).O000000o(jmDNSImpl);
            return new ServiceEventImpl(jmDNSImpl, O000000o2.O00000Oo(), O000000o2.O00000o0(), O000000o2);
        }

        /* access modifiers changed from: protected */
        public final void O000000o(StringBuilder sb) {
            itb.super.O000000o(sb);
            sb.append(" server: '");
            sb.append(this.O0000Oo);
            sb.append(":");
            sb.append(this.O0000Oo0);
            sb.append("'");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.io.IOException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* access modifiers changed from: package-private */
        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) jmDNSImpl.O00000oo.get(O00000o());
            if (serviceInfoImpl != null && ((serviceInfoImpl.O0000OOo.isAnnouncing() || serviceInfoImpl.O0000OOo.isAnnounced()) && (this.O0000Oo0 != serviceInfoImpl.O00000o0 || !this.O0000Oo.equalsIgnoreCase(jmDNSImpl.O0000Oo0.O000000o())))) {
                Logger logger = O0000OoO;
                logger.finer("handleQuery() Conflicting probe detected from: " + this.O00000oO);
                O0000OOo o0000OOo = new O0000OOo(serviceInfoImpl.O00000o(), DNSRecordClass.CLASS_IN, true, 3600, serviceInfoImpl.O00000oO, serviceInfoImpl.O00000o, serviceInfoImpl.O00000o0, jmDNSImpl.O0000Oo0.O000000o());
                try {
                    if (jmDNSImpl.O00000Oo.getInterface().equals(this.O00000oO)) {
                        Logger logger2 = O0000OoO;
                        logger2.warning("Got conflicting probe from ourselves\nincoming: " + toString() + "\nlocal   : " + o0000OOo.toString());
                    }
                } catch (IOException e) {
                    O0000OoO.log(Level.WARNING, "IOException", (Throwable) e);
                }
                int O00000o0 = O00000o0(o0000OOo);
                if (O00000o0 == 0) {
                    O0000OoO.finer("handleQuery() Ignoring a identical service query");
                    return false;
                } else if (serviceInfoImpl.O0000OOo.isProbing() && O00000o0 > 0) {
                    String lowerCase = serviceInfoImpl.O00000o().toLowerCase();
                    serviceInfoImpl.O00000o0(JmDNSImpl.O00000Oo(serviceInfoImpl.O00000o0()));
                    jmDNSImpl.O00000oo.remove(lowerCase);
                    jmDNSImpl.O00000oo.put(serviceInfoImpl.O00000o().toLowerCase(), serviceInfoImpl);
                    Logger logger3 = O0000OoO;
                    logger3.finer("handleQuery() Lost tie break: new unique name chosen:" + serviceInfoImpl.O00000o0());
                    serviceInfoImpl.O0000OOo.revertState();
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000Oo(JmDNSImpl jmDNSImpl) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) jmDNSImpl.O00000oo.get(O00000o());
            if (serviceInfoImpl == null) {
                return false;
            }
            if (this.O0000Oo0 == serviceInfoImpl.O00000o0 && this.O0000Oo.equalsIgnoreCase(jmDNSImpl.O0000Oo0.O000000o())) {
                return false;
            }
            O0000OoO.finer("handleResponse() Denial detected");
            if (serviceInfoImpl.O0000OOo.isProbing()) {
                String lowerCase = serviceInfoImpl.O00000o().toLowerCase();
                serviceInfoImpl.O00000o0(JmDNSImpl.O00000Oo(serviceInfoImpl.O00000o0()));
                jmDNSImpl.O00000oo.remove(lowerCase);
                jmDNSImpl.O00000oo.put(serviceInfoImpl.O00000o().toLowerCase(), serviceInfoImpl);
                Logger logger = O0000OoO;
                logger.finer("handleResponse() New unique name chose:" + serviceInfoImpl.O00000o0());
            }
            serviceInfoImpl.O0000OOo.revertState();
            return true;
        }
    }

    public static class O00000Oo extends itb {
        String O0000O0o;
        String O0000OOo;

        /* access modifiers changed from: package-private */
        public final boolean O000000o(JmDNSImpl jmDNSImpl) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean O00000Oo(JmDNSImpl jmDNSImpl) {
            return false;
        }

        public final boolean O0000Ooo() {
            return true;
        }

        public O00000Oo(String str, DNSRecordClass dNSRecordClass, boolean z, int i, String str2, String str3) {
            super(str, DNSRecordType.TYPE_HINFO, dNSRecordClass, z, i);
            this.O0000OOo = str2;
            this.O0000O0o = str3;
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(itb itb) {
            if (!(itb instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) itb;
            if (this.O0000OOo == null && o00000Oo.O0000OOo != null) {
                return false;
            }
            if ((this.O0000O0o != null || o00000Oo.O0000O0o == null) && this.O0000OOo.equals(o00000Oo.O0000OOo) && this.O0000O0o.equals(o00000Oo.O0000O0o)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(isz.O000000o o000000o) {
            String str = this.O0000OOo + " " + this.O0000O0o;
            o000000o.O000000o(str, str.length());
        }

        public final ServiceInfo O000000o(boolean z) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cpu", this.O0000OOo);
            hashMap.put("os", this.O0000O0o);
            return new ServiceInfoImpl(Collections.unmodifiableMap(this.O00000Oo), z, hashMap);
        }

        public final ServiceEvent O00000o0(JmDNSImpl jmDNSImpl) {
            ServiceInfo O000000o2 = O000000o(false);
            ((ServiceInfoImpl) O000000o2).O000000o(jmDNSImpl);
            return new ServiceEventImpl(jmDNSImpl, O000000o2.O00000Oo(), O000000o2.O00000o0(), O000000o2);
        }

        /* access modifiers changed from: protected */
        public final void O000000o(StringBuilder sb) {
            itb.super.O000000o(sb);
            sb.append(" cpu: '");
            sb.append(this.O0000OOo);
            sb.append("' os: '");
            sb.append(this.O0000O0o);
            sb.append("'");
        }
    }

    /* access modifiers changed from: protected */
    public void O000000o(StringBuilder sb) {
        super.O000000o(sb);
        sb.append(" ttl: '");
        sb.append(O00000Oo(System.currentTimeMillis()));
        sb.append("/");
        sb.append(this.O00000o0);
        sb.append("'");
    }
}
