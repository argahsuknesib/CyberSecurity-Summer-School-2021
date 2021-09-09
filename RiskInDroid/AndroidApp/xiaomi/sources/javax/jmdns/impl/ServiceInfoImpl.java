package javax.jmdns.impl;

import _m_j.isu;
import _m_j.isv;
import _m_j.isx;
import _m_j.itb;
import _m_j.itd;
import _m_j.ith;
import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.DNSStatefulObject;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import javax.jmdns.impl.constants.DNSState;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class ServiceInfoImpl extends ServiceInfo implements isx, DNSStatefulObject {
    private static Logger O0000Oo0 = Logger.getLogger(ServiceInfoImpl.class.getName());
    String O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public boolean O00000oo;
    boolean O0000O0o;
    public final ServiceInfoState O0000OOo;
    private String O0000Oo;
    private String O0000OoO;
    private String O0000Ooo;
    private final Set<Inet4Address> O0000o;
    private String O0000o0;
    private String O0000o00;
    private byte[] O0000o0O;
    private Map<String, byte[]> O0000o0o;
    private transient String O0000oO;
    private final Set<Inet6Address> O0000oO0;

    public static final class ServiceInfoState extends DNSStatefulObject.DefaultImplementation {
        private static final long serialVersionUID = 1104131034952196820L;
        private final ServiceInfoImpl _info;

        public ServiceInfoState(ServiceInfoImpl serviceInfoImpl) {
            this._info = serviceInfoImpl;
        }

        /* access modifiers changed from: protected */
        public final void setTask(ith ith) {
            super.setTask(ith);
            if (this._task == null && this._info.O0000O0o) {
                lock();
                try {
                    if (this._task == null && this._info.O0000O0o) {
                        if (this._state.isAnnounced()) {
                            setState(DNSState.ANNOUNCING_1);
                            if (getDns() != null) {
                                getDns().O00000oo();
                            }
                        }
                        this._info.O0000oo0();
                    }
                } finally {
                    unlock();
                }
            }
        }

        public final void setDns(JmDNSImpl jmDNSImpl) {
            super.setDns(jmDNSImpl);
        }
    }

    public ServiceInfoImpl(Map<ServiceInfo.Fields, String> map, boolean z, Map<String, ?> map2) {
        this(map, 0, 0, 0, z, O00000Oo(map2));
    }

    public ServiceInfoImpl(Map<ServiceInfo.Fields, String> map, int i, int i2, int i3, boolean z, String str) {
        this(map, i, i2, i3, z, (byte[]) null);
        this.O00000Oo = str;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            O000000o(byteArrayOutputStream, str);
            this.O0000o0O = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("unexpected exception: ".concat(String.valueOf(e)));
        }
    }

    public ServiceInfoImpl(Map<ServiceInfo.Fields, String> map, int i, int i2, int i3, boolean z, byte[] bArr) {
        Map<ServiceInfo.Fields, String> O000000o2 = O000000o(map);
        this.O0000Oo = O000000o2.get(ServiceInfo.Fields.Domain);
        this.O0000OoO = O000000o2.get(ServiceInfo.Fields.Protocol);
        this.O0000Ooo = O000000o2.get(ServiceInfo.Fields.Application);
        this.O0000o00 = O000000o2.get(ServiceInfo.Fields.Instance);
        this.O0000o0 = O000000o2.get(ServiceInfo.Fields.Subtype);
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = i3;
        this.O0000o0O = bArr;
        O0000oo0();
        this.O0000OOo = new ServiceInfoState(this);
        this.O00000oo = z;
        this.O0000o = Collections.synchronizedSet(new LinkedHashSet());
        this.O0000oO0 = Collections.synchronizedSet(new LinkedHashSet());
    }

    ServiceInfoImpl(ServiceInfo serviceInfo) {
        this.O0000o = Collections.synchronizedSet(new LinkedHashSet());
        this.O0000oO0 = Collections.synchronizedSet(new LinkedHashSet());
        if (serviceInfo != null) {
            this.O0000Oo = serviceInfo.O0000o0();
            this.O0000OoO = serviceInfo.O0000o0O();
            this.O0000Ooo = serviceInfo.O0000o0o();
            this.O0000o00 = serviceInfo.O00000o0();
            this.O0000o0 = serviceInfo.O0000o();
            this.O00000o0 = serviceInfo.O0000Oo0();
            this.O00000o = serviceInfo.O0000OoO();
            this.O00000oO = serviceInfo.O0000Oo();
            this.O0000o0O = serviceInfo.O0000Ooo();
            this.O00000oo = serviceInfo.O0000o00();
            Collections.addAll(this.O0000oO0, serviceInfo.O0000OOo());
            Collections.addAll(this.O0000o, serviceInfo.O0000O0o());
        }
        this.O0000OOo = new ServiceInfoState(this);
    }

    public static Map<ServiceInfo.Fields, String> O00000Oo(String str) {
        String str2;
        String str3;
        String str4;
        String substring;
        String str5;
        String str6;
        String str7;
        int indexOf;
        String lowerCase = str.toLowerCase();
        String str8 = "";
        if (lowerCase.contains("in-addr.arpa") || lowerCase.contains("ip6.arpa")) {
            int indexOf2 = lowerCase.contains("in-addr.arpa") ? lowerCase.indexOf("in-addr.arpa") : lowerCase.indexOf("ip6.arpa");
            str4 = O00000o(str.substring(0, indexOf2));
            substring = str.substring(indexOf2);
        } else if (lowerCase.contains("_") || !lowerCase.contains(".")) {
            if ((!lowerCase.startsWith("_") || lowerCase.startsWith("_services")) && (indexOf = lowerCase.indexOf(46)) > 0) {
                str6 = str.substring(0, indexOf);
                int i = indexOf + 1;
                if (i < lowerCase.length()) {
                    str5 = lowerCase.substring(i);
                    str = str.substring(i);
                } else {
                    str5 = lowerCase;
                }
            } else {
                str5 = lowerCase;
                str6 = str8;
            }
            int lastIndexOf = str5.lastIndexOf("._");
            if (lastIndexOf > 0) {
                int i2 = lastIndexOf + 2;
                str3 = str.substring(i2, str5.indexOf(46, i2));
            } else {
                str3 = str8;
            }
            if (str3.length() > 0) {
                int indexOf3 = str5.indexOf("_" + str3.toLowerCase() + ".");
                try {
                    str7 = str.substring(str3.length() + indexOf3 + 2, str5.length() - (str5.endsWith(".") ? 1 : 0));
                } catch (StringIndexOutOfBoundsException unused) {
                    str7 = str8;
                }
                int i3 = indexOf3 - 1;
                if (i3 > 0) {
                    lowerCase = str.substring(0, i3);
                }
                str2 = str7;
            } else {
                str2 = str8;
            }
            int indexOf4 = lowerCase.toLowerCase().indexOf("._sub");
            if (indexOf4 > 0) {
                str8 = O00000o(lowerCase.substring(0, indexOf4));
                lowerCase = lowerCase.substring(indexOf4 + 5);
            }
            str4 = str6;
            HashMap hashMap = new HashMap(5);
            hashMap.put(ServiceInfo.Fields.Domain, O00000o(str2));
            hashMap.put(ServiceInfo.Fields.Protocol, str3);
            hashMap.put(ServiceInfo.Fields.Application, O00000o(lowerCase));
            hashMap.put(ServiceInfo.Fields.Instance, str4);
            hashMap.put(ServiceInfo.Fields.Subtype, str8);
            return hashMap;
        } else {
            int indexOf5 = lowerCase.indexOf(46);
            str4 = O00000o(str.substring(0, indexOf5));
            substring = O00000o(str.substring(indexOf5));
        }
        lowerCase = str8;
        str3 = lowerCase;
        HashMap hashMap2 = new HashMap(5);
        hashMap2.put(ServiceInfo.Fields.Domain, O00000o(str2));
        hashMap2.put(ServiceInfo.Fields.Protocol, str3);
        hashMap2.put(ServiceInfo.Fields.Application, O00000o(lowerCase));
        hashMap2.put(ServiceInfo.Fields.Instance, str4);
        hashMap2.put(ServiceInfo.Fields.Subtype, str8);
        return hashMap2;
    }

    private static Map<ServiceInfo.Fields, String> O000000o(Map<ServiceInfo.Fields, String> map) {
        String str;
        String str2;
        HashMap hashMap = new HashMap(5);
        String str3 = map.containsKey(ServiceInfo.Fields.Domain) ? map.get(ServiceInfo.Fields.Domain) : "local";
        if (str3 == null || str3.length() == 0) {
            str3 = "local";
        }
        hashMap.put(ServiceInfo.Fields.Domain, O00000o(str3));
        String str4 = map.containsKey(ServiceInfo.Fields.Protocol) ? map.get(ServiceInfo.Fields.Protocol) : "tcp";
        if (str4 == null || str4.length() == 0) {
            str4 = "tcp";
        }
        hashMap.put(ServiceInfo.Fields.Protocol, O00000o(str4));
        String str5 = map.containsKey(ServiceInfo.Fields.Application) ? map.get(ServiceInfo.Fields.Application) : "";
        if (str5 == null || str5.length() == 0) {
            str5 = "";
        }
        hashMap.put(ServiceInfo.Fields.Application, O00000o(str5));
        if (map.containsKey(ServiceInfo.Fields.Instance)) {
            str = map.get(ServiceInfo.Fields.Instance);
        } else {
            str = "";
        }
        if (str == null || str.length() == 0) {
            str = "";
        }
        hashMap.put(ServiceInfo.Fields.Instance, O00000o(str));
        if (map.containsKey(ServiceInfo.Fields.Subtype)) {
            str2 = map.get(ServiceInfo.Fields.Subtype);
        } else {
            str2 = "";
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "";
        }
        hashMap.put(ServiceInfo.Fields.Subtype, O00000o(str2));
        return hashMap;
    }

    private static String O00000o(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.startsWith(".")) {
            trim = trim.substring(1);
        }
        if (trim.startsWith("_")) {
            trim = trim.substring(1);
        }
        return trim.endsWith(".") ? trim.substring(0, trim.length() - 1) : trim;
    }

    public final String O00000Oo() {
        String str;
        String O0000o02 = O0000o0();
        String O0000o0O2 = O0000o0O();
        String O0000o0o2 = O0000o0o();
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (O0000o0o2.length() > 0) {
            str = "_" + O0000o0o2 + ".";
        } else {
            str = str2;
        }
        sb.append(str);
        if (O0000o0O2.length() > 0) {
            str2 = "_" + O0000o0O2 + ".";
        }
        sb.append(str2);
        sb.append(O0000o02);
        sb.append(".");
        return sb.toString();
    }

    public final String O0000oO() {
        String str;
        String O0000o2 = O0000o();
        StringBuilder sb = new StringBuilder();
        if (O0000o2.length() > 0) {
            str = "_" + O0000o2.toLowerCase() + "._sub.";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(O00000Oo());
        return sb.toString();
    }

    public final String O00000o0() {
        String str = this.O0000o00;
        return str != null ? str : "";
    }

    public final String O0000oOO() {
        if (this.O0000oO == null) {
            this.O0000oO = O00000o().toLowerCase();
        }
        return this.O0000oO;
    }

    public final void O00000o0(String str) {
        this.O0000o00 = str;
        this.O0000oO = null;
    }

    public final String O00000o() {
        String str;
        String str2;
        String O0000o02 = O0000o0();
        String O0000o0O2 = O0000o0O();
        String O0000o0o2 = O0000o0o();
        String O00000o02 = O00000o0();
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        if (O00000o02.length() > 0) {
            str = O00000o02 + ".";
        } else {
            str = str3;
        }
        sb.append(str);
        if (O0000o0o2.length() > 0) {
            str2 = "_" + O0000o0o2 + ".";
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (O0000o0O2.length() > 0) {
            str3 = "_" + O0000o0O2 + ".";
        }
        sb.append(str3);
        sb.append(O0000o02);
        sb.append(".");
        return sb.toString();
    }

    public final String O00000oO() {
        String str = this.O00000Oo;
        return str != null ? str : "";
    }

    public final void O000000o(Inet4Address inet4Address) {
        this.O0000o.add(inet4Address);
    }

    public final void O000000o(Inet6Address inet6Address) {
        this.O0000oO0.add(inet6Address);
    }

    private InetAddress[] O0000oo() {
        ArrayList arrayList = new ArrayList(this.O0000o.size() + this.O0000oO0.size());
        arrayList.addAll(this.O0000o);
        arrayList.addAll(this.O0000oO0);
        return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
    }

    public final Inet4Address[] O0000O0o() {
        Set<Inet4Address> set = this.O0000o;
        return (Inet4Address[]) set.toArray(new Inet4Address[set.size()]);
    }

    public final Inet6Address[] O0000OOo() {
        Set<Inet6Address> set = this.O0000oO0;
        return (Inet6Address[]) set.toArray(new Inet6Address[set.size()]);
    }

    public final int O0000Oo0() {
        return this.O00000o0;
    }

    public final int O0000Oo() {
        return this.O00000oO;
    }

    public final int O0000OoO() {
        return this.O00000o;
    }

    public final byte[] O0000Ooo() {
        byte[] bArr = this.O0000o0O;
        return (bArr == null || bArr.length <= 0) ? itb.O00000oo : bArr;
    }

    public final synchronized String O000000o(String str) {
        byte[] bArr = O0000ooO().get(str);
        if (bArr == null) {
            return null;
        }
        if (bArr == f15358O000000o) {
            return "true";
        }
        return O000000o(bArr, 0, bArr.length);
    }

    public final String O0000o0o() {
        String str = this.O0000Ooo;
        return str != null ? str : "";
    }

    public final String O0000o0() {
        String str = this.O0000Oo;
        return str != null ? str : "local";
    }

    public final String O0000o0O() {
        String str = this.O0000OoO;
        return str != null ? str : "tcp";
    }

    public final String O0000o() {
        String str = this.O0000o0;
        return str != null ? str : "";
    }

    public final Map<ServiceInfo.Fields, String> O0000oOo() {
        HashMap hashMap = new HashMap(5);
        hashMap.put(ServiceInfo.Fields.Domain, O0000o0());
        hashMap.put(ServiceInfo.Fields.Protocol, O0000o0O());
        hashMap.put(ServiceInfo.Fields.Application, O0000o0o());
        hashMap.put(ServiceInfo.Fields.Instance, O00000o0());
        hashMap.put(ServiceInfo.Fields.Subtype, O0000o());
        return hashMap;
    }

    private static void O000000o(OutputStream outputStream, String str) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt > 0 && charAt <= 127) {
                outputStream.write(charAt);
            } else if (charAt > 2047) {
                outputStream.write(((charAt >> 12) & 15) | 224);
                outputStream.write(((charAt >> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
                outputStream.write(((charAt >> 0) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            } else {
                outputStream.write(((charAt >> 6) & 31) | 192);
                outputStream.write(((charAt >> 0) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY);
            }
        }
    }

    private static String O000000o(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte b;
        StringBuilder sb = new StringBuilder();
        int i5 = i + i2;
        while (i < i5) {
            int i6 = i + 1;
            byte b2 = bArr[i] & 255;
            switch (b2 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    sb.append((char) b2);
                    i = i6;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                case 9:
                case 10:
                case 11:
                default:
                    i4 = i6 + 1;
                    if (i4 < i2) {
                        i3 = (b2 & 63) << 4;
                        b = bArr[i6] & 15;
                        break;
                    } else {
                        return null;
                    }
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 13:
                    if (i6 < i2) {
                        i3 = (b2 & 31) << 6;
                        i4 = i6 + 1;
                        b = bArr[i6] & 63;
                        break;
                    } else {
                        return null;
                    }
                case 14:
                    if (i6 + 2 >= i2) {
                        return null;
                    }
                    int i7 = i6 + 1;
                    byte b3 = ((b2 & 15) << 12) | ((bArr[i6] & 63) << 6);
                    i6 = i7 + 1;
                    b2 = b3 | (bArr[i7] & 63);
                    continue;
                    sb.append((char) b2);
                    i = i6;
            }
            b2 = i3 | b;
            i6 = i4;
            sb.append((char) b2);
            i = i6;
        }
        return sb.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.Exception]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        r0.clear();
     */
    private synchronized Map<String, byte[]> O0000ooO() {
        if (this.O0000o0o == null && O0000Ooo() != null) {
            Hashtable hashtable = new Hashtable();
            int i = 0;
            while (true) {
                try {
                    if (i >= O0000Ooo().length) {
                        break;
                    }
                    int i2 = i + 1;
                    byte b = O0000Ooo()[i] & 255;
                    if (b == 0) {
                        break;
                    }
                    int i3 = i2 + b;
                    if (i3 > O0000Ooo().length) {
                        break;
                    }
                    int i4 = 0;
                    while (i4 < b && O0000Ooo()[i2 + i4] != 61) {
                        i4++;
                    }
                    String O000000o2 = O000000o(O0000Ooo(), i2, i4);
                    if (O000000o2 == null) {
                        hashtable.clear();
                        break;
                    } else if (i4 == b) {
                        hashtable.put(O000000o2, f15358O000000o);
                        i = i2;
                    } else {
                        int i5 = i4 + 1;
                        int i6 = b - i5;
                        byte[] bArr = new byte[i6];
                        System.arraycopy(O0000Ooo(), i2 + i5, bArr, 0, i6);
                        hashtable.put(O000000o2, bArr);
                        i = i3;
                    }
                } catch (Exception e) {
                    O0000Oo0.log(Level.WARNING, "Malformed TXT Field ", (Throwable) e);
                }
            }
            this.O0000o0o = hashtable;
        }
        if (this.O0000o0o != null) {
            return this.O0000o0o;
        }
        return Collections.emptyMap();
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0157 A[SYNTHETIC] */
    public final void O000000o(isu isu, long j, isv isv) {
        JmDNSImpl dns;
        List list;
        ArrayList<itd.O000000o> arrayList;
        if ((isv instanceof itb) && !isv.O000000o(j)) {
            int i = AnonymousClass1.f15372O000000o[isv.O00000oO().ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5 && O0000o().length() == 0 && isv.O000000o().length() != 0) {
                                this.O0000o0 = isv.O000000o();
                                if (z && O000000o() && (dns = this.O0000OOo.getDns()) != null) {
                                    ServiceEvent O00000o02 = ((itb) isv).O00000o0(dns);
                                    ServiceEventImpl serviceEventImpl = new ServiceEventImpl(dns, O00000o02.O00000Oo(), O00000o02.O00000o0(), this);
                                    list = dns.O00000o.get(serviceEventImpl.O00000Oo().toLowerCase());
                                    if (list != null && !list.isEmpty() && serviceEventImpl.O00000o() != null && serviceEventImpl.O00000o().O000000o()) {
                                        synchronized (list) {
                                            arrayList = new ArrayList<>(list);
                                        }
                                        for (itd.O000000o r9 : arrayList) {
                                            dns.O0000Ooo.submit(new Runnable(r9, serviceEventImpl) {
                                                /* class javax.jmdns.impl.JmDNSImpl.AnonymousClass1 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ itd.O000000o f15363O000000o;
                                                final /* synthetic */ ServiceEvent O00000Oo;

                                                {
                                                    this.f15363O000000o = r2;
                                                    this.O00000Oo = r3;
                                                }

                                                public final void run() {
                                                    this.f15363O000000o.O00000o0(this.O00000Oo);
                                                }
                                            });
                                        }
                                    }
                                }
                                synchronized (this) {
                                    notifyAll();
                                }
                                return;
                            }
                        } else if (isv.O00000Oo().equalsIgnoreCase(O00000o())) {
                            this.O0000o0O = ((itb.O0000Oo0) isv).O0000O0o;
                            ServiceEvent O00000o022 = ((itb) isv).O00000o0(dns);
                            ServiceEventImpl serviceEventImpl2 = new ServiceEventImpl(dns, O00000o022.O00000Oo(), O00000o022.O00000o0(), this);
                            list = dns.O00000o.get(serviceEventImpl2.O00000Oo().toLowerCase());
                            synchronized (list) {
                            }
                        }
                    } else if (isv.O00000Oo().equalsIgnoreCase(O00000o())) {
                        itb.O0000OOo o0000OOo = (itb.O0000OOo) isv;
                        String str = this.O00000Oo;
                        boolean z2 = str == null || !str.equalsIgnoreCase(o0000OOo.O0000Oo);
                        this.O00000Oo = o0000OOo.O0000Oo;
                        this.O00000o0 = o0000OOo.O0000Oo0;
                        this.O00000o = o0000OOo.O0000OOo;
                        this.O00000oO = o0000OOo.O0000O0o;
                        if (z2) {
                            this.O0000o.clear();
                            this.O0000oO0.clear();
                            for (isv O000000o2 : isu.O00000Oo(this.O00000Oo, DNSRecordType.TYPE_A, DNSRecordClass.CLASS_IN)) {
                                O000000o(isu, j, O000000o2);
                            }
                            for (isv O000000o3 : isu.O00000Oo(this.O00000Oo, DNSRecordType.TYPE_AAAA, DNSRecordClass.CLASS_IN)) {
                                O000000o(isu, j, O000000o3);
                            }
                        }
                        ServiceEvent O00000o0222 = ((itb) isv).O00000o0(dns);
                        ServiceEventImpl serviceEventImpl22 = new ServiceEventImpl(dns, O00000o0222.O00000Oo(), O00000o0222.O00000o0(), this);
                        list = dns.O00000o.get(serviceEventImpl22.O00000Oo().toLowerCase());
                        synchronized (list) {
                        }
                    }
                } else if (isv.O00000Oo().equalsIgnoreCase(O00000oO())) {
                    this.O0000oO0.add((Inet6Address) ((itb.O000000o) isv).O0000O0o);
                    ServiceEvent O00000o02222 = ((itb) isv).O00000o0(dns);
                    ServiceEventImpl serviceEventImpl222 = new ServiceEventImpl(dns, O00000o02222.O00000Oo(), O00000o02222.O00000o0(), this);
                    list = dns.O00000o.get(serviceEventImpl222.O00000Oo().toLowerCase());
                    synchronized (list) {
                    }
                }
            } else if (isv.O00000Oo().equalsIgnoreCase(O00000oO())) {
                this.O0000o.add((Inet4Address) ((itb.O000000o) isv).O0000O0o);
                ServiceEvent O00000o022222 = ((itb) isv).O00000o0(dns);
                ServiceEventImpl serviceEventImpl2222 = new ServiceEventImpl(dns, O00000o022222.O00000Oo(), O00000o022222.O00000o0(), this);
                list = dns.O00000o.get(serviceEventImpl2222.O00000Oo().toLowerCase());
                synchronized (list) {
                }
            }
            z = false;
            ServiceEvent O00000o0222222 = ((itb) isv).O00000o0(dns);
            ServiceEventImpl serviceEventImpl22222 = new ServiceEventImpl(dns, O00000o0222222.O00000Oo(), O00000o0222222.O00000o0(), this);
            list = dns.O00000o.get(serviceEventImpl22222.O00000Oo().toLowerCase());
            synchronized (list) {
            }
        }
    }

    /* renamed from: javax.jmdns.impl.ServiceInfoImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f15372O000000o = new int[DNSRecordType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f15372O000000o[DNSRecordType.TYPE_A.ordinal()] = 1;
            f15372O000000o[DNSRecordType.TYPE_AAAA.ordinal()] = 2;
            f15372O000000o[DNSRecordType.TYPE_SRV.ordinal()] = 3;
            f15372O000000o[DNSRecordType.TYPE_TXT.ordinal()] = 4;
            f15372O000000o[DNSRecordType.TYPE_PTR.ordinal()] = 5;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        return false;
     */
    public final synchronized boolean O000000o() {
        boolean z;
        if (O00000oO() != null) {
            if (this.O0000o.size() <= 0) {
                if (this.O0000oO0.size() <= 0) {
                    z = false;
                    if (z && O0000Ooo() != null && O0000Ooo().length > 0) {
                        return true;
                    }
                }
            }
            z = true;
            return true;
        }
    }

    public boolean advanceState(ith ith) {
        return this.O0000OOo.advanceState(ith);
    }

    public final void O000000o(ith ith) {
        this.O0000OOo.removeAssociationWithTask(ith);
    }

    public final void O000000o(ith ith, DNSState dNSState) {
        this.O0000OOo.associateWithTask(ith, dNSState);
    }

    public int hashCode() {
        return O00000o().hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ServiceInfoImpl) && O00000o().equals(((ServiceInfoImpl) obj).O00000o());
    }

    /* access modifiers changed from: private */
    /* renamed from: O0000ooo */
    public ServiceInfoImpl clone() {
        ServiceInfoImpl serviceInfoImpl = new ServiceInfoImpl(O0000oOo(), this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000o0O);
        Collections.addAll(serviceInfoImpl.O0000oO0, O0000OOo());
        Collections.addAll(serviceInfoImpl.O0000o, O0000O0o());
        return serviceInfoImpl;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(System.identityHashCode(this));
        sb.append(" ");
        sb.append("name: '");
        String str2 = "";
        if (O00000o0().length() > 0) {
            str = O00000o0() + ".";
        } else {
            str = str2;
        }
        sb.append(str);
        sb.append(O0000oO());
        sb.append("' address: '");
        InetAddress[] O0000oo = O0000oo();
        if (O0000oo.length > 0) {
            for (InetAddress append : O0000oo) {
                sb.append(append);
                sb.append(':');
                sb.append(this.O00000o0);
                sb.append(' ');
            }
        } else {
            sb.append("(null):");
            sb.append(this.O00000o0);
        }
        sb.append("' status: '");
        sb.append(this.O0000OOo.toString());
        sb.append(this.O00000oo ? "' is persistent," : "',");
        sb.append(" has ");
        if (!O000000o()) {
            str2 = "NO ";
        }
        sb.append(str2);
        sb.append("data");
        if (O0000Ooo().length > 0) {
            Map<String, byte[]> O0000ooO = O0000ooO();
            if (!O0000ooO.isEmpty()) {
                sb.append("\n");
                for (String next : O0000ooO.keySet()) {
                    sb.append("\t");
                    sb.append(next);
                    sb.append(": ");
                    sb.append(new String(O0000ooO.get(next)));
                    sb.append("\n");
                }
            } else {
                sb.append(" empty");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public final Collection<itb> O000000o(int i, HostInfo hostInfo) {
        ArrayList arrayList = new ArrayList();
        if (O0000o().length() > 0) {
            arrayList.add(new itb.O0000O0o(O0000oO(), DNSRecordClass.CLASS_IN, false, i, O00000o()));
        }
        arrayList.add(new itb.O0000O0o(O00000Oo(), DNSRecordClass.CLASS_IN, false, i, O00000o()));
        String O00000o2 = O00000o();
        DNSRecordClass dNSRecordClass = DNSRecordClass.CLASS_IN;
        int i2 = this.O00000oO;
        int i3 = this.O00000o;
        arrayList.add(new itb.O0000OOo(O00000o2, dNSRecordClass, true, i, i2, i3, this.O00000o0, hostInfo.O000000o()));
        arrayList.add(new itb.O0000Oo0(O00000o(), DNSRecordClass.CLASS_IN, true, i, O0000Ooo()));
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(byte[] bArr) {
        this.O0000o0O = bArr;
        this.O0000o0o = null;
    }

    private static byte[] O00000Oo(Map<String, ?> map) {
        byte[] bArr = null;
        if (map != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
                for (String next : map.keySet()) {
                    Object obj = map.get(next);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(100);
                    O000000o(byteArrayOutputStream2, next);
                    if (obj != null) {
                        if (obj instanceof String) {
                            byteArrayOutputStream2.write(61);
                            O000000o(byteArrayOutputStream2, (String) obj);
                        } else if (obj instanceof byte[]) {
                            byte[] bArr2 = (byte[]) obj;
                            if (bArr2.length > 0) {
                                byteArrayOutputStream2.write(61);
                                byteArrayOutputStream2.write(bArr2, 0, bArr2.length);
                            } else {
                                obj = null;
                            }
                        } else {
                            throw new IllegalArgumentException("invalid property value: ".concat(String.valueOf(obj)));
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (byteArray.length > 255) {
                        StringBuilder sb = new StringBuilder("Cannot have individual values larger that 255 chars. Offending value: ");
                        sb.append(next);
                        sb.append(obj != null ? "" : "=".concat(String.valueOf(obj)));
                        throw new IOException(sb.toString());
                    }
                    byteArrayOutputStream.write((byte) byteArray.length);
                    byteArrayOutputStream.write(byteArray, 0, byteArray.length);
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("unexpected exception: ".concat(String.valueOf(e)));
            }
        }
        return (bArr == null || bArr.length <= 0) ? itb.O00000oo : bArr;
    }

    public final void O000000o(JmDNSImpl jmDNSImpl) {
        this.O0000OOo.setDns(jmDNSImpl);
    }

    public final boolean O0000o00() {
        return this.O00000oo;
    }

    public final void O0000oo0() {
        this.O0000O0o = false;
        if (this.O0000O0o) {
            this.O0000OOo.setTask(null);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public ServiceInfoImpl(String str, String str2, String str3, boolean z) {
        this(O000000o(r8), 0, 0, 0, z, (byte[]) null);
        Map<ServiceInfo.Fields, String> O00000Oo2 = O00000Oo(str);
        O00000Oo2.put(ServiceInfo.Fields.Instance, str2);
        O00000Oo2.put(ServiceInfo.Fields.Subtype, str3);
    }

    @Deprecated
    public final InetAddress O00000oo() {
        InetAddress[] O0000oo = O0000oo();
        if (O0000oo.length > 0) {
            return O0000oo[0];
        }
        return null;
    }
}
