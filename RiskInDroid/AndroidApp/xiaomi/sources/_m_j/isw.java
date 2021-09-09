package _m_j;

import _m_j.itb;
import com.google.android.exoplayer2.C;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.impl.constants.DNSLabel;
import javax.jmdns.impl.constants.DNSOptionCode;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import javax.jmdns.impl.constants.DNSResultCode;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class isw extends isy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1611O000000o = true;
    private static Logger O0000OoO = Logger.getLogger(isw.class.getName());
    private static final char[] O0000o0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final long O00000Oo;
    public int O00000o0;
    private final DatagramPacket O0000Ooo;
    private final O000000o O0000o00;

    public static class O000000o extends ByteArrayInputStream {
        private static Logger O00000Oo = Logger.getLogger(O000000o.class.getName());

        /* renamed from: O000000o  reason: collision with root package name */
        final Map<Integer, String> f1613O000000o;

        public O000000o(byte[] bArr, int i) {
            this(bArr, i, (byte) 0);
        }

        private O000000o(byte[] bArr, int i, byte b) {
            super(bArr, 0, i);
            this.f1613O000000o = new HashMap();
        }

        public final int O000000o() {
            return (read() << 8) | read();
        }

        public final byte[] O000000o(int i) {
            byte[] bArr = new byte[i];
            read(bArr, 0, i);
            return bArr;
        }

        public final String O00000Oo(int i) {
            int i2;
            int read;
            StringBuilder sb = new StringBuilder(i);
            int i3 = 0;
            while (i3 < i) {
                int read2 = read();
                switch (read2 >> 4) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        sb.append((char) read2);
                        i3++;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    case 9:
                    case 10:
                    case 11:
                    default:
                        i2 = (read2 & 63) << 4;
                        read = read() & 15;
                        read2 = i2 | read;
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    case 13:
                        i2 = (read2 & 31) << 6;
                        read = read() & 63;
                        read2 = i2 | read;
                        break;
                    case 14:
                        read2 = ((read2 & 15) << 12) | ((read() & 63) << 6) | (read() & 63);
                        i3++;
                        break;
                }
                i3++;
                sb.append((char) read2);
                i3++;
            }
            return sb.toString();
        }

        public final String O00000Oo() {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (!z) {
                int read = read();
                if (read == 0) {
                    break;
                }
                int i = AnonymousClass1.f1612O000000o[DNSLabel.labelForByte(read).ordinal()];
                if (i == 1) {
                    int i2 = this.pos - 1;
                    String str = O00000Oo(read) + ".";
                    sb.append(str);
                    for (StringBuilder append : hashMap.values()) {
                        append.append(str);
                    }
                    hashMap.put(Integer.valueOf(i2), new StringBuilder(str));
                } else if (i == 2) {
                    int labelValue = (DNSLabel.labelValue(read) << 8) | read();
                    String str2 = this.f1613O000000o.get(Integer.valueOf(labelValue));
                    if (str2 == null) {
                        O00000Oo.severe("bad domain name: possible circular name detected. Bad offset: 0x" + Integer.toHexString(labelValue) + " at 0x" + Integer.toHexString(this.pos - 2));
                        str2 = "";
                    }
                    sb.append(str2);
                    for (StringBuilder append2 : hashMap.values()) {
                        append2.append(str2);
                    }
                    z = true;
                } else if (i != 3) {
                    O00000Oo.severe("unsupported dns label type: '" + Integer.toHexString(read & 192) + "'");
                } else {
                    O00000Oo.severe("Extended label are not currently supported.");
                }
            }
            for (Integer num : hashMap.keySet()) {
                this.f1613O000000o.put(num, ((StringBuilder) hashMap.get(num)).toString());
            }
            return sb.toString();
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
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public isw(DatagramPacket datagramPacket) throws IOException {
        super(0, 0, datagramPacket.getPort() == itg.f1624O000000o);
        this.O0000Ooo = datagramPacket;
        InetAddress address = datagramPacket.getAddress();
        this.O0000o00 = new O000000o(datagramPacket.getData(), datagramPacket.getLength());
        this.O00000Oo = System.currentTimeMillis();
        this.O00000o0 = 1460;
        try {
            this.O00000o = this.O0000o00.O000000o();
            this.O00000oo = this.O0000o00.O000000o();
            int O000000o2 = this.O0000o00.O000000o();
            int O000000o3 = this.O0000o00.O000000o();
            int O000000o4 = this.O0000o00.O000000o();
            int O000000o5 = this.O0000o00.O000000o();
            if (O000000o2 > 0) {
                for (int i = 0; i < O000000o2; i++) {
                    List list = this.O0000O0o;
                    String O00000Oo2 = this.O0000o00.O00000Oo();
                    DNSRecordType typeForIndex = DNSRecordType.typeForIndex(this.O0000o00.O000000o());
                    if (typeForIndex == DNSRecordType.TYPE_IGNORE) {
                        Logger logger = O0000OoO;
                        Level level = Level.SEVERE;
                        logger.log(level, "Could not find record type: " + O00000Oo());
                    }
                    int O000000o6 = this.O0000o00.O000000o();
                    DNSRecordClass classForIndex = DNSRecordClass.classForIndex(O000000o6);
                    list.add(ita.O000000o(O00000Oo2, typeForIndex, classForIndex, classForIndex.isUnique(O000000o6)));
                }
            }
            if (O000000o3 > 0) {
                for (int i2 = 0; i2 < O000000o3; i2++) {
                    itb O000000o7 = O000000o(address);
                    if (O000000o7 != null) {
                        this.O0000OOo.add(O000000o7);
                    }
                }
            }
            if (O000000o4 > 0) {
                for (int i3 = 0; i3 < O000000o4; i3++) {
                    itb O000000o8 = O000000o(address);
                    if (O000000o8 != null) {
                        this.O0000Oo0.add(O000000o8);
                    }
                }
            }
            if (O000000o5 > 0) {
                for (int i4 = 0; i4 < O000000o5; i4++) {
                    itb O000000o9 = O000000o(address);
                    if (O000000o9 != null) {
                        this.O0000Oo.add(O000000o9);
                    }
                }
            }
        } catch (Exception e) {
            Logger logger2 = O0000OoO;
            Level level2 = Level.WARNING;
            logger2.log(level2, "DNSIncoming() dump " + O00000Oo() + "\n exception ", (Throwable) e);
            IOException iOException = new IOException("DNSIncoming corrupted message");
            iOException.initCause(e);
            throw iOException;
        }
    }

    private isw(int i, int i2, boolean z, DatagramPacket datagramPacket, long j) {
        super(i, i2, z);
        this.O0000Ooo = datagramPacket;
        this.O0000o00 = new O000000o(datagramPacket.getData(), datagramPacket.getLength());
        this.O00000Oo = j;
    }

    /* renamed from: O000000o */
    public final isw clone() {
        isw isw = new isw(this.O00000oo, O00000o0(), this.O00000oO, this.O0000Ooo, this.O00000Oo);
        isw.O00000o0 = this.O00000o0;
        isw.O0000O0o.addAll(this.O0000O0o);
        isw.O0000OOo.addAll(this.O0000OOo);
        isw.O0000Oo0.addAll(this.O0000Oo0);
        isw.O0000Oo.addAll(this.O0000Oo);
        return isw;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v4, types: [_m_j.itb] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r2v51, types: [_m_j.itb$O00000o0] */
    /* JADX WARN: Type inference failed for: r2v52, types: [_m_j.itb$O00000o] */
    /* JADX WARN: Type inference failed for: r2v53, types: [_m_j.itb$O0000Oo0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x00c7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0233  */
    /* JADX WARNING: Unknown variable types count: 1 */
    private itb O000000o(InetAddress inetAddress) {
        ? r1;
        String str;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte b;
        byte b2;
        String str2;
        String str3;
        String O00000Oo2 = this.O0000o00.O00000Oo();
        DNSRecordType typeForIndex = DNSRecordType.typeForIndex(this.O0000o00.O000000o());
        if (typeForIndex == DNSRecordType.TYPE_IGNORE) {
            O0000OoO.log(Level.SEVERE, "Could not find record type. domain: " + O00000Oo2 + "\n" + O00000Oo());
        }
        int O000000o2 = this.O0000o00.O000000o();
        DNSRecordClass classForIndex = typeForIndex == DNSRecordType.TYPE_OPT ? DNSRecordClass.CLASS_UNKNOWN : DNSRecordClass.classForIndex(O000000o2);
        if (classForIndex == DNSRecordClass.CLASS_UNKNOWN && typeForIndex != DNSRecordType.TYPE_OPT) {
            O0000OoO.log(Level.SEVERE, "Could not find record class. domain: " + O00000Oo2 + " type: " + typeForIndex + "\n" + O00000Oo());
        }
        boolean isUnique = classForIndex.isUnique(O000000o2);
        O000000o o000000o = this.O0000o00;
        int O000000o3 = (o000000o.O000000o() << 16) | o000000o.O000000o();
        int O000000o4 = this.O0000o00.O000000o();
        String str4 = "";
        switch (AnonymousClass1.O00000o0[typeForIndex.ordinal()]) {
            case 1:
                r1 = new itb.O00000o0(O00000Oo2, classForIndex, isUnique, O000000o3, this.O0000o00.O000000o(O000000o4));
                break;
            case 2:
                r1 = new itb.O00000o(O00000Oo2, classForIndex, isUnique, O000000o3, this.O0000o00.O000000o(O000000o4));
                break;
            case 3:
            case 4:
                String O00000Oo3 = this.O0000o00.O00000Oo();
                if (O00000Oo3.length() <= 0) {
                    O0000OoO.log(Level.WARNING, "PTR record of class: " + classForIndex + ", there was a problem reading the service name of the answer for domain:" + O00000Oo2);
                    r1 = 0;
                    break;
                } else {
                    r1 = new itb.O0000O0o(O00000Oo2, classForIndex, isUnique, O000000o3, O00000Oo3);
                    break;
                }
            case 5:
                r1 = new itb.O0000Oo0(O00000Oo2, classForIndex, isUnique, O000000o3, this.O0000o00.O000000o(O000000o4));
                break;
            case 6:
                int O000000o5 = this.O0000o00.O000000o();
                int O000000o6 = this.O0000o00.O000000o();
                int O000000o7 = this.O0000o00.O000000o();
                if (f1611O000000o) {
                    str = this.O0000o00.O00000Oo();
                } else {
                    O000000o o000000o2 = this.O0000o00;
                    str = o000000o2.O00000Oo(o000000o2.read());
                }
                r1 = new itb.O0000OOo(O00000Oo2, classForIndex, isUnique, O000000o3, O000000o5, O000000o6, O000000o7, str);
                break;
            case 7:
                StringBuilder sb = new StringBuilder();
                sb.append(this.O0000o00.O00000Oo(O000000o4));
                int indexOf = sb.indexOf(" ");
                String trim = (indexOf > 0 ? sb.substring(0, indexOf) : sb.toString()).trim();
                if (indexOf > 0) {
                    str4 = sb.substring(indexOf + 1);
                }
                r1 = new itb.O00000Oo(O00000Oo2, classForIndex, isUnique, O000000o3, trim, str4.trim());
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                DNSResultCode resultCodeForFlags = DNSResultCode.resultCodeForFlags(this.O00000oo, O000000o3);
                int i = (16711680 & O000000o3) >> 16;
                if (i == 0) {
                    this.O00000o0 = O000000o2;
                    while (true) {
                        if (this.O0000o00.available() > 0) {
                            if (this.O0000o00.available() >= 2) {
                                int O000000o8 = this.O0000o00.O000000o();
                                DNSOptionCode resultCodeForFlags2 = DNSOptionCode.resultCodeForFlags(O000000o8);
                                if (this.O0000o00.available() >= 2) {
                                    int O000000o9 = this.O0000o00.O000000o();
                                    byte[] bArr4 = new byte[0];
                                    if (this.O0000o00.available() >= O000000o9) {
                                        bArr4 = this.O0000o00.O000000o(O000000o9);
                                    }
                                    int i2 = AnonymousClass1.O00000Oo[resultCodeForFlags2.ordinal()];
                                    if (i2 == 1) {
                                        try {
                                            b2 = bArr4[0];
                                            try {
                                                b = bArr4[1];
                                            } catch (Exception unused) {
                                                b = 0;
                                                bArr3 = null;
                                                bArr2 = null;
                                                bArr = null;
                                                O0000OoO.warning("Malformed OPT answer. Option code: Owner data: " + O00000Oo(bArr4));
                                                if (O0000OoO.isLoggable(Level.FINE)) {
                                                }
                                            }
                                            try {
                                                bArr = new byte[]{bArr4[2], bArr4[3], bArr4[4], bArr4[5], bArr4[6], bArr4[7]};
                                                try {
                                                    bArr2 = bArr4.length > 8 ? new byte[]{bArr4[8], bArr4[9], bArr4[10], bArr4[11], bArr4[12], bArr4[13]} : bArr;
                                                } catch (Exception unused2) {
                                                    bArr2 = bArr;
                                                    bArr3 = null;
                                                    O0000OoO.warning("Malformed OPT answer. Option code: Owner data: " + O00000Oo(bArr4));
                                                    if (O0000OoO.isLoggable(Level.FINE)) {
                                                    }
                                                }
                                            } catch (Exception unused3) {
                                                bArr3 = null;
                                                bArr2 = null;
                                                bArr = null;
                                                O0000OoO.warning("Malformed OPT answer. Option code: Owner data: " + O00000Oo(bArr4));
                                                if (O0000OoO.isLoggable(Level.FINE)) {
                                                }
                                            }
                                            try {
                                                bArr3 = bArr4.length == 18 ? new byte[]{bArr4[14], bArr4[15], bArr4[16], bArr4[17]} : null;
                                                try {
                                                    if (bArr4.length == 22) {
                                                        bArr3 = new byte[]{bArr4[14], bArr4[15], bArr4[16], bArr4[17], bArr4[18], bArr4[19], bArr4[20], bArr4[21]};
                                                    }
                                                } catch (Exception unused4) {
                                                    O0000OoO.warning("Malformed OPT answer. Option code: Owner data: " + O00000Oo(bArr4));
                                                    if (O0000OoO.isLoggable(Level.FINE)) {
                                                    }
                                                }
                                            } catch (Exception unused5) {
                                                bArr3 = null;
                                                O0000OoO.warning("Malformed OPT answer. Option code: Owner data: " + O00000Oo(bArr4));
                                                if (O0000OoO.isLoggable(Level.FINE)) {
                                                }
                                            }
                                        } catch (Exception unused6) {
                                            b2 = 0;
                                            b = 0;
                                            bArr3 = null;
                                            bArr2 = null;
                                            bArr = null;
                                            O0000OoO.warning("Malformed OPT answer. Option code: Owner data: " + O00000Oo(bArr4));
                                            if (O0000OoO.isLoggable(Level.FINE)) {
                                            }
                                        }
                                        if (O0000OoO.isLoggable(Level.FINE)) {
                                            Logger logger = O0000OoO;
                                            StringBuilder sb2 = new StringBuilder("Unhandled Owner OPT version: ");
                                            sb2.append((int) b2);
                                            sb2.append(" sequence: ");
                                            sb2.append((int) b);
                                            sb2.append(" MAC address: ");
                                            sb2.append(O00000Oo(bArr));
                                            if (bArr2 != bArr) {
                                                str2 = " wakeup MAC address: " + O00000Oo(bArr2);
                                            } else {
                                                str2 = str4;
                                            }
                                            sb2.append(str2);
                                            if (bArr3 != null) {
                                                str3 = " password: " + O00000Oo(bArr3);
                                            } else {
                                                str3 = str4;
                                            }
                                            sb2.append(str3);
                                            logger.fine(sb2.toString());
                                        }
                                    } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                                        if (O0000OoO.isLoggable(Level.FINE)) {
                                            O0000OoO.log(Level.FINE, "There was an OPT answer. Option code: " + resultCodeForFlags2 + " data: " + O00000Oo(bArr4));
                                        }
                                    } else if (i2 == 5) {
                                        O0000OoO.log(Level.WARNING, "There was an OPT answer. Not currently handled. Option code: " + O000000o8 + " data: " + O00000Oo(bArr4));
                                    }
                                } else {
                                    O0000OoO.log(Level.WARNING, "There was a problem reading the OPT record. Ignoring.");
                                }
                            } else {
                                O0000OoO.log(Level.WARNING, "There was a problem reading the OPT record. Ignoring.");
                            }
                        }
                    }
                } else {
                    O0000OoO.log(Level.WARNING, "There was an OPT answer. Wrong version number: " + i + " result code: " + resultCodeForFlags);
                }
                r1 = 0;
                break;
            default:
                if (O0000OoO.isLoggable(Level.FINER)) {
                    O0000OoO.finer("DNSIncoming() unknown type:".concat(String.valueOf(typeForIndex)));
                }
                this.O0000o00.skip((long) O000000o4);
                r1 = 0;
                break;
        }
        if (r1 != 0) {
            r1.O00000oO = inetAddress;
        }
        return r1;
    }

    /* renamed from: _m_j.isw$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1612O000000o = new int[DNSLabel.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[DNSOptionCode.values().length];
        static final /* synthetic */ int[] O00000o0 = new int[DNSRecordType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ba */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c4 */
        static {
            try {
                O00000o0[DNSRecordType.TYPE_A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000o0[DNSRecordType.TYPE_AAAA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000o0[DNSRecordType.TYPE_CNAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000o0[DNSRecordType.TYPE_PTR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            O00000o0[DNSRecordType.TYPE_TXT.ordinal()] = 5;
            O00000o0[DNSRecordType.TYPE_SRV.ordinal()] = 6;
            O00000o0[DNSRecordType.TYPE_HINFO.ordinal()] = 7;
            try {
                O00000o0[DNSRecordType.TYPE_OPT.ordinal()] = 8;
            } catch (NoSuchFieldError unused5) {
            }
            O00000Oo[DNSOptionCode.Owner.ordinal()] = 1;
            O00000Oo[DNSOptionCode.LLQ.ordinal()] = 2;
            O00000Oo[DNSOptionCode.NSID.ordinal()] = 3;
            O00000Oo[DNSOptionCode.UL.ordinal()] = 4;
            try {
                O00000Oo[DNSOptionCode.Unknown.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            f1612O000000o[DNSLabel.Standard.ordinal()] = 1;
            f1612O000000o[DNSLabel.Compressed.ordinal()] = 2;
            f1612O000000o[DNSLabel.Extended.ordinal()] = 3;
            f1612O000000o[DNSLabel.Unknown.ordinal()] = 4;
        }
    }

    public final String O00000Oo() {
        StringBuilder sb = new StringBuilder();
        sb.append(O0000o0o());
        byte[] bArr = new byte[this.O0000Ooo.getLength()];
        System.arraycopy(this.O0000Ooo.getData(), 0, bArr, 0, bArr.length);
        sb.append(O000000o(bArr));
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(O0000o0() ? "dns[query," : "dns[response,");
        if (this.O0000Ooo.getAddress() != null) {
            sb.append(this.O0000Ooo.getAddress().getHostAddress());
        }
        sb.append(':');
        sb.append(this.O0000Ooo.getPort());
        sb.append(", length=");
        sb.append(this.O0000Ooo.getLength());
        sb.append(", id=0x");
        sb.append(Integer.toHexString(O00000o0()));
        if (this.O00000oo != 0) {
            sb.append(", flags=0x");
            sb.append(Integer.toHexString(this.O00000oo));
            if ((this.O00000oo & 32768) != 0) {
                sb.append(":r");
            }
            if ((this.O00000oo & 1024) != 0) {
                sb.append(":aa");
            }
            if ((this.O00000oo & 512) != 0) {
                sb.append(":tc");
            }
        }
        if (O00000oO() > 0) {
            sb.append(", questions=");
            sb.append(O00000oO());
        }
        if (O0000OOo() > 0) {
            sb.append(", answers=");
            sb.append(O0000OOo());
        }
        if (O0000Oo() > 0) {
            sb.append(", authorities=");
            sb.append(O0000Oo());
        }
        if (O0000Ooo() > 0) {
            sb.append(", additionals=");
            sb.append(O0000Ooo());
        }
        if (O00000oO() > 0) {
            sb.append("\nquestions:");
            for (ita append : this.O0000O0o) {
                sb.append("\n\t");
                sb.append(append);
            }
        }
        if (O0000OOo() > 0) {
            sb.append("\nanswers:");
            for (itb append2 : this.O0000OOo) {
                sb.append("\n\t");
                sb.append(append2);
            }
        }
        if (O0000Oo() > 0) {
            sb.append("\nauthorities:");
            for (itb append3 : this.O0000Oo0) {
                sb.append("\n\t");
                sb.append(append3);
            }
        }
        if (O0000Ooo() > 0) {
            sb.append("\nadditionals:");
            for (itb append4 : this.O0000Oo) {
                sb.append("\n\t");
                sb.append(append4);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final void O000000o(isw isw) {
        if (!O0000o0() || !O0000o00() || !isw.O0000o0()) {
            throw new IllegalArgumentException();
        }
        this.O0000O0o.addAll(isw.O00000o());
        this.O0000OOo.addAll(isw.O0000O0o());
        this.O0000Oo0.addAll(isw.O0000Oo0());
        this.O0000Oo.addAll(isw.O0000OoO());
    }

    private static String O00000Oo(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            byte b2 = b & 255;
            sb.append(O0000o0[b2 / 16]);
            sb.append(O0000o0[b2 % 16]);
        }
        return sb.toString();
    }
}
