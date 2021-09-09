package com.xiaomi.miio;

import _m_j.dxa;
import _m_j.dxb;
import _m_j.dxc;
import _m_j.dxd;
import _m_j.dxe;
import _m_j.dxf;
import _m_j.dxg;
import _m_j.gsy;
import android.text.TextUtils;
import com.xiaomi.miio.JNIBridge;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public final class MiioLocalAPI {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f6017O000000o = "ffffffffffffffffffffffffffffffff".getBytes();
    private static final byte[] O00000Oo = "00000000000000000000000000000000".getBytes();
    private static String O00000o = null;
    private static boolean O00000o0 = false;
    private static final int O00000oO;
    private static final int O00000oo;
    private static final ExecutorService O0000O0o;
    private static HashMap<Integer, Long> O0000OOo = new HashMap<>();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f6027O000000o;
    }

    private static boolean O000000o(long j) {
        return ((int) ((j >> 32) & -1)) != 0;
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        O00000oO = availableProcessors;
        int i = availableProcessors + 1;
        O00000oo = i;
        O0000O0o = Executors.newFixedThreadPool(i);
    }

    private static void O000000o(DatagramSocket datagramSocket, InetAddress inetAddress, byte[] bArr) throws IOException {
        datagramSocket.send(new DatagramPacket(bArr, bArr.length, inetAddress, 54321));
    }

    private static void O000000o(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        gsy.O00000o0(LogType.KUAILIAN, "MiioLocalAPI", str);
    }

    private static void O000000o(MulticastSocket multicastSocket, String str) throws IOException {
        InetAddress byName = InetAddress.getByName(str);
        multicastSocket.joinGroup(byName);
        multicastSocket.send(new DatagramPacket("miio".getBytes(), 4, byName, 5007));
        multicastSocket.leaveGroup(byName);
    }

    private static void O000000o(String str, MulticastSocket multicastSocket, byte[] bArr) throws IOException, InterruptedException {
        O000000o(multicastSocket, String.format(str, 0, Integer.valueOf(bArr.length + 1)));
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            O000000o(multicastSocket, String.format(str, Integer.valueOf(i2), Integer.valueOf(bArr[i] & 255)));
            if (i != 0 && i % 10 == 0) {
                Thread.sleep(4);
                O000000o(multicastSocket, String.format(str, 0, Integer.valueOf(bArr.length + 1)));
            }
            Thread.sleep(4);
            i = i2;
        }
    }

    private static String O000000o(DatagramSocket datagramSocket, byte[] bArr, int i) throws IOException {
        DatagramPacket datagramPacket = new DatagramPacket(bArr, 65535);
        datagramSocket.setSoTimeout(i);
        datagramSocket.receive(datagramPacket);
        return datagramPacket.getAddress().getHostAddress();
    }

    public static void O000000o(String str, String str2, String str3, String str4, dxc dxc) {
        O00000o0 = false;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final dxc dxc2 = dxc;
        O0000O0o.execute(new Runnable() {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass5 */

            public final void run() {
                MiioLocalAPI.O00000Oo(str5, str6, str7, str8, dxc2);
            }
        });
    }

    public static void O000000o(String str, String str2, String str3, String str4, String str5, dxc dxc) {
        O00000o0 = false;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        final dxc dxc2 = dxc;
        O0000O0o.execute(new Runnable() {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass6 */

            public final void run() {
                MiioLocalAPI.O00000Oo(str6, str7, str8, str9, str10, dxc2);
            }
        });
    }

    public static void O000000o(String str, String str2, String str3, String str4, long j, dxc dxc) {
        O00000o0 = false;
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final long j2 = j;
        final dxc dxc2 = dxc;
        O0000O0o.execute(new Runnable() {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass7 */

            public final void run() {
                MiioLocalAPI.O00000Oo(str5, str6, str7, str8, j2, dxc2);
            }
        });
    }

    public static void O000000o(String str, String str2, String str3, String str4, String str5, long j, dxc dxc) {
        O00000o0 = false;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        final long j2 = j;
        final dxc dxc2 = dxc;
        O0000O0o.execute(new Runnable() {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass8 */

            public final void run() {
                MiioLocalAPI.O00000Oo(str6, str7, str8, str9, str10, j2, dxc2);
            }
        });
    }

    public static void O000000o() {
        O00000o0 = true;
    }

    public static void O000000o(String str) {
        if (str != null && str.length() == 2) {
            O00000o = str.toLowerCase();
        }
    }

    private static byte[] O00000Oo(String str) {
        byte[] bArr = new byte[6];
        String[] split = str.toLowerCase().split(":");
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) Integer.parseInt(split[i], 16);
            i++;
            i2++;
        }
        return bArr;
    }

    public enum WifiEnc {
        OPEN(1, ""),
        WEP_PSK(2, "[WEP]"),
        WEP_SHARED(3, "[WEP]"),
        WPA_TKIP_PSK(4, "[WPA-PSK-TKIP]"),
        WPA_AES_PSK(5, "[WPA-PSK-CCMP]"),
        WPA2_AES_PSK(6, "[WPA2-PSK-CCMP]"),
        WPA2_TKIP_PSK(7, "[WPA2-PSK-TKIP]"),
        WPA2_MIXED_PSK(8, "[WPA2-PSK-CCMP+TKIP]"),
        WPA2_MIXED_PSK1(8, "[WPA2-PSK-TKIP+CCMP]"),
        WPA_MIXED_PSK(9, "[WPA-PSK-CCMP+TKIP]"),
        WPA_MIXED_PSK1(9, "[WPA-PSK-TKIP+CCMP]");
        
        private String capability;
        private byte type;

        public final byte getType() {
            return this.type;
        }

        public final void setType(byte b) {
            this.type = b;
        }

        public final String getCapability() {
            return this.capability;
        }

        public final void setCapability(String str) {
            this.capability = str;
        }

        private WifiEnc(int i, String str) {
            this.type = (byte) i;
            this.capability = str;
        }
    }

    private static byte O00000o0(String str) {
        if (str.contains(WifiEnc.WPA2_MIXED_PSK.getCapability())) {
            return WifiEnc.WPA2_MIXED_PSK.getType();
        }
        if (str.contains(WifiEnc.WPA2_MIXED_PSK1.getCapability())) {
            return WifiEnc.WPA2_MIXED_PSK1.getType();
        }
        if (str.contains(WifiEnc.WPA2_AES_PSK.getCapability())) {
            return WifiEnc.WPA2_AES_PSK.getType();
        }
        if (str.contains(WifiEnc.WPA2_TKIP_PSK.getCapability())) {
            return WifiEnc.WPA2_TKIP_PSK.getType();
        }
        if (str.contains(WifiEnc.WPA_MIXED_PSK.getCapability())) {
            return WifiEnc.WPA_MIXED_PSK.getType();
        }
        if (str.contains(WifiEnc.WPA_MIXED_PSK1.getCapability())) {
            return WifiEnc.WPA_MIXED_PSK1.getType();
        }
        if (str.contains(WifiEnc.WPA_AES_PSK.getCapability())) {
            return WifiEnc.WPA_AES_PSK.getType();
        }
        if (str.contains(WifiEnc.WPA_TKIP_PSK.getCapability())) {
            return WifiEnc.WPA_TKIP_PSK.getType();
        }
        if (str.contains(WifiEnc.WEP_PSK.getCapability())) {
            return WifiEnc.WEP_PSK.getType();
        }
        if (str.contains(WifiEnc.WEP_SHARED.getCapability())) {
            return WifiEnc.WEP_SHARED.getType();
        }
        if (str.length() <= 0 || str.replaceAll("\\[WPS\\]", "").replaceAll("\\[ESS\\]", "").length() != 0) {
            return 0;
        }
        return WifiEnc.OPEN.getType();
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x01cf A[Catch:{ Exception -> 0x01df, all -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x020f A[Catch:{ all -> 0x01e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    private static void O000000o(String str, String str2, String str3, String str4, String str5, long j, long j2, dxc dxc) {
        int i;
        int i2;
        String str6;
        byte[] bArr;
        long j3 = j;
        gsy.O000000o(6, "miio-localapi", "start kuailian");
        MulticastSocket multicastSocket = null;
        try {
            MulticastSocket multicastSocket2 = new MulticastSocket();
            try {
                byte[] bytes = str.getBytes("UTF-8");
                byte[] bytes2 = str2.getBytes("UTF-8");
                int length = bytes.length + bytes2.length + 1;
                boolean z = (str3 == null || str4 == null || O00000o0(str4) == 0) ? false : true;
                int i3 = length + 9;
                if (j2 != 0) {
                    i3 += 6;
                    if (O000000o(j2)) {
                        i3 += 6;
                    }
                }
                if (O00000o != null && O00000o.length() == 2) {
                    i3 += 4;
                }
                byte[] bArr2 = new byte[i3];
                int i4 = 0;
                while (i4 < bytes.length) {
                    bArr2[i4] = bytes[i4];
                    i4++;
                }
                bArr2[i4] = 0;
                int i5 = i4 + 1;
                int i6 = 0;
                while (i6 < bytes2.length) {
                    bArr2[i5] = bytes2[i6];
                    i6++;
                    i5++;
                }
                if (z) {
                    bArr2[i5] = 0;
                    byte[] O00000Oo2 = O00000Oo(str3);
                    int i7 = i5 + 1;
                    int i8 = 0;
                    while (i8 < 6) {
                        bArr2[i7] = O00000Oo2[i8];
                        i8++;
                        i7++;
                    }
                    int i9 = i7 + 1;
                    bArr2[i7] = 0;
                    i = i9 + 1;
                    bArr2[i9] = O00000o0(str4);
                } else {
                    bArr2[i5] = 0;
                    byte[] bArr3 = {0, 0, 0, 0, 0, 0};
                    int i10 = i5 + 1;
                    int i11 = 0;
                    while (i11 < 6) {
                        bArr2[i10] = bArr3[i11];
                        i11++;
                        i10++;
                    }
                    int i12 = i10 + 1;
                    bArr2[i10] = 0;
                    i = i12 + 1;
                    bArr2[i12] = -1;
                }
                if (j2 != 0) {
                    int i13 = i + 1;
                    bArr2[i] = 16;
                    int i14 = i13 + 1;
                    bArr2[i13] = 6;
                    int i15 = i14 + 1;
                    bArr2[i14] = (byte) ((int) ((j2 >> 24) & 255));
                    int i16 = i15 + 1;
                    bArr2[i15] = (byte) ((int) ((j2 >> 16) & 255));
                    int i17 = i16 + 1;
                    bArr2[i16] = (byte) ((int) ((j2 >> 8) & 255));
                    i = i17 + 1;
                    bArr2[i17] = (byte) ((int) (j2 & 255));
                    if (O000000o(j2)) {
                        int i18 = i + 1;
                        bArr2[i] = 18;
                        int i19 = i18 + 1;
                        bArr2[i18] = 6;
                        int i20 = i19 + 1;
                        bArr2[i19] = (byte) ((int) ((j2 >> 56) & 255));
                        int i21 = i20 + 1;
                        bArr2[i20] = (byte) ((int) ((j2 >> 48) & 255));
                        int i22 = i21 + 1;
                        bArr2[i21] = (byte) ((int) ((j2 >> 40) & 255));
                        i = i22 + 1;
                        bArr2[i22] = (byte) ((int) ((j2 >> 32) & 255));
                    }
                }
                if (O00000o == null || O00000o.length() != 2) {
                    i2 = 0;
                } else {
                    int i23 = i + 1;
                    bArr2[i] = 17;
                    int i24 = i23 + 1;
                    bArr2[i23] = 4;
                    i2 = 0;
                    bArr2[i24] = (byte) O00000o.charAt(0);
                    bArr2[i24 + 1] = (byte) O00000o.charAt(1);
                }
                if (str5 == null || str5.length() != 4) {
                    bArr = JNIBridge.smencrypt(bArr2, j3);
                    str6 = "224.126.%s.%s";
                } else {
                    bArr = JNIBridge.smencryptpk(bArr2, j3, str5.toLowerCase().getBytes("UTF-8"));
                    str6 = "224." + ((Integer.parseInt("0000".concat(String.valueOf(str5)), 16) % 124) + 127) + ".%s.%s";
                }
                if (bArr.length > 254) {
                    new dxd(MiioLocalErrorCode.MSG_TOO_LONG);
                } else {
                    while (true) {
                        int i25 = i2 + 1;
                        if (i2 < 30 && !O00000o0) {
                            O000000o(str6, multicastSocket2, bArr);
                            Thread.sleep(50);
                            i2 = i25;
                        } else if (dxc != null) {
                            new dxd(MiioLocalErrorCode.SUCCESS);
                        }
                    }
                    if (dxc != null) {
                    }
                }
                gsy.O000000o(6, "miio-localapi", "end kuailian");
                multicastSocket2.close();
            } catch (Exception e) {
                e = e;
                multicastSocket = multicastSocket2;
                try {
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    gsy.O000000o(6, "miio-localapi", e.toString() + stringWriter.toString());
                    if (dxc != null) {
                        new dxd(MiioLocalErrorCode.EXCEPTION);
                    }
                    gsy.O000000o(6, "miio-localapi", "end kuailian");
                    if (multicastSocket == null) {
                        multicastSocket.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    multicastSocket2 = multicastSocket;
                    gsy.O000000o(6, "miio-localapi", "end kuailian");
                    if (multicastSocket2 != null) {
                        multicastSocket2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gsy.O000000o(6, "miio-localapi", "end kuailian");
                if (multicastSocket2 != null) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            StringWriter stringWriter2 = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter2));
            gsy.O000000o(6, "miio-localapi", e.toString() + stringWriter2.toString());
            if (dxc != null) {
            }
            gsy.O000000o(6, "miio-localapi", "end kuailian");
            if (multicastSocket == null) {
            }
        }
    }

    public static void O00000Oo(String str, String str2, String str3, String str4, String str5, dxc dxc) {
        O000000o(str, str2, str3, str4, str5, 0, 0, dxc);
    }

    public static void O00000Oo(String str, String str2, String str3, String str4, dxc dxc) {
        O000000o(str, str2, str3, str4, null, System.currentTimeMillis(), 0, dxc);
    }

    public static void O00000Oo(String str, String str2, String str3, String str4, String str5, long j, dxc dxc) {
        O000000o(str, str2, str3, str4, str5, 0, j, dxc);
    }

    public static void O00000Oo(String str, String str2, String str3, String str4, long j, dxc dxc) {
        O000000o(str, str2, str3, str4, null, System.currentTimeMillis(), j, dxc);
    }

    public static void O000000o(final InetAddress inetAddress, final dxa dxa) {
        O0000O0o.execute(new Runnable() {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass9 */

            public final void run() {
                MiioLocalAPI.O00000Oo(inetAddress, dxa);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1 A[Catch:{ all -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    public static void O00000Oo(InetAddress inetAddress, dxa dxa) {
        DatagramSocket datagramSocket = null;
        try {
            DatagramSocket datagramSocket2 = new DatagramSocket();
            try {
                datagramSocket2.setReuseAddress(true);
                datagramSocket2.setBroadcast(true);
                try {
                    O000000o(datagramSocket2, inetAddress, JNIBridge.hencrypt(new JNIBridge.MiioMsg(-1, -1, f6017O000000o, null)));
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        try {
                            byte[] bArr = new byte[65535];
                            String O000000o2 = O000000o(datagramSocket2, bArr, 700);
                            JNIBridge.MiioMsg hdecrypt = JNIBridge.hdecrypt(bArr);
                            arrayList.add(new dxf(MiioLocalErrorCode.SUCCESS, null, hdecrypt.did, hdecrypt.stamp, new String(hdecrypt.token).toLowerCase(), O000000o2));
                        } catch (SocketTimeoutException unused) {
                            if (dxa != null) {
                                dxa.O000000o(new dxb(MiioLocalErrorCode.SUCCESS, arrayList));
                            }
                            datagramSocket2.close();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    gsy.O000000o(6, "miio-localapi", th.toString());
                    if (dxa != null) {
                        dxa.O000000o(new dxb(MiioLocalErrorCode.EXCEPTION));
                    }
                    datagramSocket2.close();
                }
            } catch (Exception e) {
                e = e;
                datagramSocket = datagramSocket2;
                try {
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    gsy.O000000o(6, "miio-localapi", e.toString() + stringWriter.toString());
                    if (dxa != null) {
                    }
                    if (datagramSocket == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    datagramSocket2 = datagramSocket;
                    if (datagramSocket2 != null) {
                        datagramSocket2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (datagramSocket2 != null) {
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            StringWriter stringWriter2 = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter2));
            gsy.O000000o(6, "miio-localapi", e.toString() + stringWriter2.toString());
            if (dxa != null) {
                dxa.O000000o(new dxb(MiioLocalErrorCode.EXCEPTION));
            }
            if (datagramSocket == null) {
                datagramSocket.close();
            }
        }
    }

    private static synchronized void O00000Oo(String str, String str2, long j, String str3, int i, dxe dxe) {
        synchronized (MiioLocalAPI.class) {
            O000000o(str, str2, j, str3, i, 2000, dxe);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r14 = new java.lang.StringBuilder("rpc data time out, retry ");
        r15 = r12 + 1;
        r14.append(r15);
        O000000o(r14.toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a5, code lost:
        if (r12 == 2) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a9, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0102, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0103, code lost:
        r3 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7 A[Catch:{ SocketTimeoutException -> 0x0105, Exception -> 0x0102, all -> 0x00ff }, LOOP:0: B:21:0x007d->B:34:0x00a7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ff A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0102 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:10:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013b A[Catch:{ all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014b A[SYNTHETIC, Splitter:B:61:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017f A[Catch:{ all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018f A[SYNTHETIC, Splitter:B:72:0x018f] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019a A[SYNTHETIC, Splitter:B:81:0x019a] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00a9 A[SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:67:0x0152=Splitter:B:67:0x0152, B:56:0x010e=Splitter:B:56:0x010e} */
    private static synchronized void O000000o(String str, String str2, long j, String str3, int i, int i2, dxe dxe) {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2;
        DatagramSocket datagramSocket3;
        String str4;
        int i3;
        String str5 = str2;
        dxe dxe2 = dxe;
        synchronized (MiioLocalAPI.class) {
            if (TextUtils.isEmpty(str2) || !str5.contains("passwd")) {
                O000000o("execute method rpc: body %s, stamp %d, timeout %d", str5, Integer.valueOf(i), Integer.valueOf(i2));
            }
            try {
                datagramSocket = new DatagramSocket();
                try {
                    datagramSocket.setReuseAddress(true);
                    InetAddress byName = InetAddress.getByName(str);
                    byte[] bytes = str3.getBytes("UTF-8");
                    if (bytes.length != 32) {
                        O000000o(" rpc Token size error", new Object[0]);
                        dxe2.onResponse(new dxf(MiioLocalErrorCode.PERMISSION_DENIED).O000000o());
                        datagramSocket.close();
                        return;
                    }
                    byte[] encrypt = JNIBridge.encrypt(new JNIBridge.MiioMsg(j, i, bytes, str5.getBytes("UTF-8")));
                    byte[] bArr = new byte[65535];
                    int i4 = 0;
                    while (true) {
                        if (i4 >= 3) {
                            str4 = null;
                            break;
                        }
                        O000000o(datagramSocket, byName, encrypt);
                        str4 = O000000o(datagramSocket, bArr, i2);
                        break;
                        i4 = i3;
                    }
                    JNIBridge.MiioMsg decrypt = JNIBridge.decrypt(bArr, bytes);
                    if (decrypt.message != null && dxe2 != null) {
                        MiioLocalErrorCode miioLocalErrorCode = MiioLocalErrorCode.SUCCESS;
                        String str6 = new String(decrypt.message);
                        long j2 = decrypt.did;
                        dxe2.onResponse(new dxf(miioLocalErrorCode, str6, j2, decrypt.stamp, new String(decrypt.token).toLowerCase(), str4).O000000o());
                    } else if (dxe2 != null) {
                        O000000o("rpc error:MiioLocalErrorCode.DEVICE_EXCEPTION", new Object[0]);
                        dxe2.onResponse(new dxf(MiioLocalErrorCode.DEVICE_EXCEPTION).O000000o());
                    }
                    datagramSocket.close();
                } catch (SocketTimeoutException e) {
                    e = e;
                    datagramSocket3 = datagramSocket;
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    O000000o("rpc socket timeout exception " + e.toString() + stringWriter.toString(), new Object[0]);
                    if (dxe2 != null) {
                    }
                    if (datagramSocket2 != null) {
                    }
                } catch (Exception e2) {
                } catch (Throwable th) {
                }
            } catch (SocketTimeoutException e3) {
                e = e3;
                datagramSocket3 = null;
                StringWriter stringWriter2 = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter2));
                O000000o("rpc socket timeout exception " + e.toString() + stringWriter2.toString(), new Object[0]);
                if (dxe2 != null) {
                    dxe2.onResponse(new dxf(MiioLocalErrorCode.TIMEOUT).O000000o());
                }
                if (datagramSocket2 != null) {
                    datagramSocket2.close();
                }
            } catch (Exception e4) {
                e = e4;
                datagramSocket2 = null;
                try {
                    StringWriter stringWriter3 = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter3));
                    O000000o("rpc MiioLocalErrorCode.EXCEPTION " + e.toString() + stringWriter3.toString(), new Object[0]);
                    if (dxe2 != null) {
                        dxe2.onResponse(new dxf(MiioLocalErrorCode.EXCEPTION).O000000o());
                    }
                    if (datagramSocket2 != null) {
                        datagramSocket2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    datagramSocket = datagramSocket2;
                    if (datagramSocket != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                datagramSocket = null;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        }
    }

    public static void O000000o(String str, String str2, long j, String str3, dxe dxe) {
        O000000o(str, str2, j, str3, dxe, 2000);
    }

    public static void O000000o(String str, String str2, long j, String str3, dxe dxe, int i) {
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        final String str6 = str3;
        final dxe dxe2 = dxe;
        final int i2 = i;
        O0000O0o.execute(new Runnable() {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass1 */

            public final void run() {
                MiioLocalAPI.O00000Oo(str4, str5, j2, str6, dxe2, i2);
            }
        });
    }

    public static void O00000Oo(String str, String str2, long j, String str3, dxe dxe) {
        O0000O0o.execute(new Runnable(str, str2, j, str3, 5000, dxe) {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ String f6019O000000o;
            final /* synthetic */ String O00000Oo;
            final /* synthetic */ String O00000o;
            final /* synthetic */ long O00000o0;
            final /* synthetic */ int O00000oO = 5000;
            final /* synthetic */ dxe O00000oo;

            {
                this.f6019O000000o = r1;
                this.O00000Oo = r2;
                this.O00000o0 = r3;
                this.O00000o = r5;
                this.O00000oo = r7;
            }

            public final void run() {
                MiioLocalAPI.O000000o(this.f6019O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f9, code lost:
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0255, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r16 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01c0, code lost:
        O000000o("is match %b, i= %d, retry-1 =%d", java.lang.Boolean.valueOf(r10), java.lang.Integer.valueOf(r15), 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01dc, code lost:
        if (r2 == null) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01de, code lost:
        if (r0 == null) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e0, code lost:
        r2.onResponse(r0.O000000o());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0178 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x023f A[Catch:{ all -> 0x0206 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0192 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0106  */
    public static void O000000o(String str, String str2, long j, String str3, int i, dxe dxe) {
        DatagramSocket datagramSocket;
        dxf dxf;
        boolean z;
        byte[] bArr;
        String str4;
        String str5 = str2;
        dxe dxe2 = dxe;
        String str6 = "id";
        String str7 = "UTF-8";
        int O000000o2 = O000000o(str, j, dxe2);
        if (O000000o2 >= 0) {
            int i2 = 3;
            if (TextUtils.isEmpty(str2) || !str5.contains("passwd")) {
                O000000o("execute method rpc: body %s, stamp %d,timeout %d", str5, Integer.valueOf(O000000o2), Integer.valueOf(i));
            }
            DatagramSocket datagramSocket2 = null;
            try {
                DatagramSocket datagramSocket3 = new DatagramSocket();
                try {
                    datagramSocket3.setReuseAddress(true);
                    InetAddress byName = InetAddress.getByName(str);
                    byte[] bytes = str3.getBytes(str7);
                    if (bytes.length != 32) {
                        O000000o(" rpc Token size error", new Object[0]);
                        dxe2.onResponse(new dxf(MiioLocalErrorCode.PERMISSION_DENIED).O000000o());
                        datagramSocket3.close();
                        return;
                    }
                    byte[] bArr2 = new byte[65535];
                    int i3 = 0;
                    while (true) {
                        if (i3 >= i2) {
                            datagramSocket = datagramSocket3;
                            break;
                        }
                        JSONObject jSONObject = new JSONObject(str5);
                        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) + ((long) new Random().nextInt(1000)));
                        jSONObject.put(str6, currentTimeMillis);
                        byte[] bytes2 = jSONObject.toString().getBytes(str7);
                        InetAddress inetAddress = byName;
                        byte[] bArr3 = bytes;
                        datagramSocket = datagramSocket3;
                        String str8 = str7;
                        byte[] bArr4 = bArr2;
                        int i4 = currentTimeMillis;
                        try {
                            try {
                                O000000o(datagramSocket, inetAddress, JNIBridge.encrypt(new JNIBridge.MiioMsg(j, O000000o2, bArr3, bytes2)));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            O0000OOo.put(Integer.valueOf(i4), Long.valueOf(System.currentTimeMillis()));
                            dxf = null;
                            boolean z2 = false;
                            while (true) {
                                Long l = O0000OOo.get(Integer.valueOf(i4));
                                if (l != null) {
                                    if (System.currentTimeMillis() - l.longValue() <= ((long) i)) {
                                        z = false;
                                        if (!z) {
                                            bArr = bArr3;
                                            str4 = str6;
                                            break;
                                        }
                                        try {
                                            String O000000o3 = O000000o(datagramSocket, bArr4, 2000);
                                            bArr = bArr3;
                                            try {
                                                JNIBridge.MiioMsg decrypt = JNIBridge.decrypt(bArr4, bArr);
                                                if (decrypt.message != null) {
                                                    JSONObject jSONObject2 = new JSONObject(new String(decrypt.message));
                                                    new Random();
                                                    if (jSONObject2.optInt(str6, -1) == i4) {
                                                        try {
                                                            str4 = str6;
                                                            try {
                                                                dxf = new dxf(MiioLocalErrorCode.SUCCESS, new String(decrypt.message), decrypt.did, decrypt.stamp, new String(decrypt.token).toLowerCase(), O000000o3);
                                                                z2 = true;
                                                                break;
                                                            } catch (SocketTimeoutException unused) {
                                                            } catch (IOException unused2) {
                                                                z2 = true;
                                                                dxf = new dxf(MiioLocalErrorCode.EXCEPTION);
                                                                bArr3 = bArr;
                                                                str6 = str4;
                                                            }
                                                        } catch (SocketTimeoutException unused3) {
                                                            str4 = str6;
                                                            z2 = true;
                                                            dxf = new dxf(MiioLocalErrorCode.TIMEOUT);
                                                            bArr3 = bArr;
                                                            str6 = str4;
                                                        } catch (IOException unused4) {
                                                            str4 = str6;
                                                            z2 = true;
                                                            dxf = new dxf(MiioLocalErrorCode.EXCEPTION);
                                                            bArr3 = bArr;
                                                            str6 = str4;
                                                        }
                                                    } else {
                                                        str4 = str6;
                                                        try {
                                                            dxf = new dxf(MiioLocalErrorCode.MSG_ID_NOT_MATCH);
                                                        } catch (SocketTimeoutException unused5) {
                                                            dxf = new dxf(MiioLocalErrorCode.TIMEOUT);
                                                        } catch (IOException ) {
                                                            dxf = new dxf(MiioLocalErrorCode.EXCEPTION);
                                                        }
                                                    }
                                                } else {
                                                    str4 = str6;
                                                    dxf = new dxf(MiioLocalErrorCode.DEVICE_EXCEPTION);
                                                }
                                            } catch (SocketTimeoutException unused6) {
                                                str4 = str6;
                                                dxf = new dxf(MiioLocalErrorCode.TIMEOUT);
                                                bArr3 = bArr;
                                                str6 = str4;
                                            } catch (IOException unused7) {
                                                str4 = str6;
                                                dxf = new dxf(MiioLocalErrorCode.EXCEPTION);
                                                bArr3 = bArr;
                                                str6 = str4;
                                            }
                                        } catch (SocketTimeoutException unused8) {
                                            bArr = bArr3;
                                            str4 = str6;
                                            dxf = new dxf(MiioLocalErrorCode.TIMEOUT);
                                            bArr3 = bArr;
                                            str6 = str4;
                                        } catch (IOException unused9) {
                                            bArr = bArr3;
                                            str4 = str6;
                                            dxf = new dxf(MiioLocalErrorCode.EXCEPTION);
                                            bArr3 = bArr;
                                            str6 = str4;
                                        }
                                        bArr3 = bArr;
                                        str6 = str4;
                                    }
                                } else {
                                    int i5 = i;
                                }
                                z = true;
                                if (!z) {
                                }
                            }
                            O0000OOo.remove(Integer.valueOf(i4));
                            if (z2) {
                                break;
                            } else if (i3 == 2) {
                                break;
                            } else {
                                O000000o("continue send message", new Object[0]);
                                i3++;
                                long j2 = j;
                                datagramSocket3 = datagramSocket;
                                bArr2 = bArr4;
                                bytes = bArr;
                                byName = inetAddress;
                                str6 = str4;
                                str7 = str8;
                                i2 = 3;
                                str5 = str2;
                            }
                        } catch (UnsupportedEncodingException | SocketException | UnknownHostException | JSONException e2) {
                            e = e2;
                            datagramSocket2 = datagramSocket;
                            try {
                                StringWriter stringWriter = new StringWriter();
                                e.printStackTrace(new PrintWriter(stringWriter));
                                O000000o("rpc MiioLocalErrorCode.EXCEPTION " + e.toString() + stringWriter.toString(), new Object[0]);
                                if (dxe2 != null) {
                                }
                                if (datagramSocket2 == null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                datagramSocket = datagramSocket2;
                                if (datagramSocket != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (datagramSocket != null) {
                            }
                            throw th;
                        }
                    }
                    datagramSocket.close();
                } catch (UnsupportedEncodingException | SocketException | UnknownHostException | JSONException e3) {
                    e = e3;
                    datagramSocket = datagramSocket3;
                    datagramSocket2 = datagramSocket;
                    StringWriter stringWriter2 = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter2));
                    O000000o("rpc MiioLocalErrorCode.EXCEPTION " + e.toString() + stringWriter2.toString(), new Object[0]);
                    if (dxe2 != null) {
                    }
                    if (datagramSocket2 == null) {
                    }
                } catch (Throwable th3) {
                }
            } catch (UnsupportedEncodingException | SocketException | UnknownHostException | JSONException e4) {
                e = e4;
                StringWriter stringWriter22 = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter22));
                O000000o("rpc MiioLocalErrorCode.EXCEPTION " + e.toString() + stringWriter22.toString(), new Object[0]);
                if (dxe2 != null) {
                    dxe2.onResponse(new dxf(MiioLocalErrorCode.EXCEPTION).O000000o());
                }
                if (datagramSocket2 == null) {
                    datagramSocket2.close();
                }
            }
        }
    }

    public static void O000000o(final String str, final String str2, final dxe dxe) {
        O0000O0o.execute(new Runnable() {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass3 */

            public final void run() {
                MiioLocalAPI.O00000Oo(str, str2, dxe);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a0, code lost:
        r12.onResponse(new _m_j.dxf(com.xiaomi.miio.MiioLocalErrorCode.EXCEPTION).O000000o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b0, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fa, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return -2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return -2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:6:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a0 A[Catch:{ all -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3 A[Catch:{ all -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0073=Splitter:B:33:0x0073, B:40:0x00b6=Splitter:B:40:0x00b6} */
    private static int O000000o(String str, long j, dxe dxe) {
        int i;
        int i2;
        DatagramSocket datagramSocket = null;
        try {
            int O000000o2 = dxg.O000000o(j);
            if (O000000o2 < 0) {
                DatagramSocket datagramSocket2 = new DatagramSocket();
                try {
                    datagramSocket2.setReuseAddress(true);
                    byte[] hencrypt = JNIBridge.hencrypt(new JNIBridge.MiioMsg(-1, -1, f6017O000000o, null));
                    byte[] bArr = new byte[65535];
                    i2 = 0;
                    while (i2 < 3) {
                        O000000o(datagramSocket2, InetAddress.getByName(str), hencrypt);
                        O000000o(datagramSocket2, bArr, 2000);
                    }
                    i = JNIBridge.hdecrypt(bArr).stamp;
                    dxg.O000000o(j, i);
                    datagramSocket = datagramSocket2;
                } catch (SocketTimeoutException e) {
                    StringBuilder sb = new StringBuilder("rpc timestamp time out, retry ");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    O000000o(sb.toString(), new Object[0]);
                    if (i2 != 2) {
                        i2 = i3;
                    } else {
                        throw e;
                    }
                } catch (Exception e2) {
                } catch (SocketTimeoutException e3) {
                    e = e3;
                    datagramSocket = datagramSocket2;
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    O000000o("rpc socket timeout exception " + e.toString() + stringWriter.toString(), new Object[0]);
                    if (dxe != null) {
                        dxe.onResponse(new dxf(MiioLocalErrorCode.TIMEOUT).O000000o());
                    }
                    if (datagramSocket != null) {
                        return -1;
                    }
                    datagramSocket.close();
                    return -1;
                } catch (Throwable th) {
                }
            } else {
                i = O000000o2;
            }
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            return i;
        } catch (SocketTimeoutException e4) {
            e = e4;
            StringWriter stringWriter2 = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter2));
            O000000o("rpc socket timeout exception " + e.toString() + stringWriter2.toString(), new Object[0]);
            if (dxe != null) {
            }
            if (datagramSocket != null) {
            }
        } catch (Exception e5) {
            e = e5;
            try {
                StringWriter stringWriter3 = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter3));
                O000000o("rpc  exception " + e.toString() + stringWriter3.toString(), new Object[0]);
                if (dxe != null) {
                }
                if (datagramSocket == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (datagramSocket != null) {
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0089, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        r9.onResponse(new _m_j.dxf(com.xiaomi.miio.MiioLocalErrorCode.EXCEPTION).O000000o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f9, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:13:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f5 A[SYNTHETIC, Splitter:B:56:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0128 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0138 A[SYNTHETIC, Splitter:B:66:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0141 A[SYNTHETIC, Splitter:B:73:0x0141] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:51:0x00b8=Splitter:B:51:0x00b8, B:61:0x00fb=Splitter:B:61:0x00fb} */
    public static synchronized void O00000Oo(String str, String str2, long j, String str3, dxe dxe, int i) {
        DatagramSocket datagramSocket;
        int i2;
        String str4 = str2;
        dxe dxe2 = dxe;
        synchronized (MiioLocalAPI.class) {
            if (TextUtils.isEmpty(str2) || !str4.contains("passwd")) {
                O000000o("execute method rpc: body %s, timeout %d", str4, Integer.valueOf(i));
            }
            DatagramSocket datagramSocket2 = null;
            try {
                int O000000o2 = dxg.O000000o(j);
                if (O000000o2 < 0) {
                    DatagramSocket datagramSocket3 = new DatagramSocket();
                    try {
                        datagramSocket3.setReuseAddress(true);
                        byte[] hencrypt = JNIBridge.hencrypt(new JNIBridge.MiioMsg(-1, -1, f6017O000000o, null));
                        byte[] bArr = new byte[65535];
                        i2 = 0;
                        while (i2 < 3) {
                            O000000o(datagramSocket3, InetAddress.getByName(str), hencrypt);
                            O000000o(datagramSocket3, bArr, 2000);
                        }
                        O000000o2 = JNIBridge.hdecrypt(bArr).stamp;
                        dxg.O000000o(j, O000000o2);
                        datagramSocket = datagramSocket3;
                    } catch (SocketTimeoutException e) {
                        StringBuilder sb = new StringBuilder("rpc timestamp time out, retry ");
                        int i3 = i2 + 1;
                        sb.append(i3);
                        O000000o(sb.toString(), new Object[0]);
                        if (i2 != 2) {
                            i2 = i3;
                        } else {
                            throw e;
                        }
                    } catch (Exception e2) {
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        datagramSocket2 = datagramSocket3;
                        StringWriter stringWriter = new StringWriter();
                        e.printStackTrace(new PrintWriter(stringWriter));
                        O000000o("rpc socket timeout exception " + e.toString() + stringWriter.toString(), new Object[0]);
                        if (dxe2 != null) {
                            dxe2.onResponse(new dxf(MiioLocalErrorCode.TIMEOUT).O000000o());
                        }
                        if (datagramSocket2 != null) {
                            datagramSocket2.close();
                            return;
                        }
                    } catch (Throwable th) {
                    }
                } else {
                    datagramSocket = null;
                }
                try {
                    O000000o(str, str2, j, str3, O000000o2, i, dxe);
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    datagramSocket2 = datagramSocket;
                    StringWriter stringWriter2 = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter2));
                    O000000o("rpc socket timeout exception " + e.toString() + stringWriter2.toString(), new Object[0]);
                    if (dxe2 != null) {
                    }
                    if (datagramSocket2 != null) {
                    }
                } catch (Exception e5) {
                    e = e5;
                    datagramSocket2 = datagramSocket;
                    try {
                        StringWriter stringWriter3 = new StringWriter();
                        e.printStackTrace(new PrintWriter(stringWriter3));
                        O000000o("rpc  exception " + e.toString() + stringWriter3.toString(), new Object[0]);
                        if (dxe2 != null) {
                        }
                        if (datagramSocket2 != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (datagramSocket2 != null) {
                            datagramSocket2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    datagramSocket2 = datagramSocket;
                    if (datagramSocket2 != null) {
                    }
                    throw th;
                }
            } catch (SocketTimeoutException e6) {
                e = e6;
                StringWriter stringWriter22 = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter22));
                O000000o("rpc socket timeout exception " + e.toString() + stringWriter22.toString(), new Object[0]);
                if (dxe2 != null) {
                }
                if (datagramSocket2 != null) {
                }
            } catch (Exception e7) {
                e = e7;
                StringWriter stringWriter32 = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter32));
                O000000o("rpc  exception " + e.toString() + stringWriter32.toString(), new Object[0]);
                if (dxe2 != null) {
                }
                if (datagramSocket2 != null) {
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0072, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        r13.onResponse(new _m_j.dxf(com.xiaomi.miio.MiioLocalErrorCode.EXCEPTION).O000000o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:6:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ab A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb A[SYNTHETIC, Splitter:B:38:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ec A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fc A[SYNTHETIC, Splitter:B:48:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0105 A[SYNTHETIC, Splitter:B:55:0x0105] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0080=Splitter:B:33:0x0080, B:43:0x00c1=Splitter:B:43:0x00c1} */
    public static synchronized void O00000Oo(String str, String str2, dxe dxe) {
        int i;
        synchronized (MiioLocalAPI.class) {
            DatagramSocket datagramSocket = null;
            try {
                DatagramSocket datagramSocket2 = new DatagramSocket();
                try {
                    datagramSocket2.setReuseAddress(true);
                    byte[] hencrypt = JNIBridge.hencrypt(new JNIBridge.MiioMsg(-1, -1, f6017O000000o, null));
                    byte[] bArr = new byte[65535];
                    i = 0;
                    while (i < 3) {
                        O000000o(datagramSocket2, InetAddress.getByName(str), hencrypt);
                        O000000o(datagramSocket2, bArr, 2000);
                    }
                    JNIBridge.MiioMsg hdecrypt = JNIBridge.hdecrypt(bArr);
                    O00000Oo(str, str2, hdecrypt.did, new String(hdecrypt.token), hdecrypt.stamp, dxe);
                    datagramSocket2.close();
                } catch (SocketTimeoutException e) {
                    StringBuilder sb = new StringBuilder("rpc timestamp time out, retry ");
                    int i2 = i + 1;
                    sb.append(i2);
                    sb.append(" body:");
                    sb.append(str2);
                    gsy.O000000o(6, "miio-localapi", sb.toString());
                    if (i != 2) {
                        i = i2;
                    } else {
                        throw e;
                    }
                } catch (Exception e2) {
                } catch (SocketTimeoutException e3) {
                    e = e3;
                    datagramSocket = datagramSocket2;
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    gsy.O000000o(6, "miio-localapi", e.toString() + stringWriter.toString());
                    if (dxe != null) {
                        dxe.onResponse(new dxf(MiioLocalErrorCode.TIMEOUT).O000000o());
                    }
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                } catch (Throwable th) {
                }
            } catch (SocketTimeoutException e4) {
                e = e4;
                StringWriter stringWriter2 = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter2));
                gsy.O000000o(6, "miio-localapi", e.toString() + stringWriter2.toString());
                if (dxe != null) {
                }
                if (datagramSocket != null) {
                }
            } catch (Exception e5) {
                e = e5;
                try {
                    StringWriter stringWriter3 = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter3));
                    gsy.O000000o(6, "miio-localapi", e.toString() + stringWriter3.toString());
                    if (dxe != null) {
                    }
                    if (datagramSocket != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (datagramSocket != null) {
                    }
                    throw th;
                }
            }
        }
    }

    public static O000000o O000000o(String str, dxe dxe, int i) {
        return O000000o(str, dxe, 2000, i);
    }

    public static O000000o O000000o(String str, dxe dxe, int i, int i2) {
        O000000o o000000o = new O000000o();
        final String str2 = str;
        final dxe dxe2 = dxe;
        final int i3 = i;
        final int i4 = i2;
        final O000000o o000000o2 = o000000o;
        O0000O0o.execute(new Runnable() {
            /* class com.xiaomi.miio.MiioLocalAPI.AnonymousClass4 */

            public final void run() {
                MiioLocalAPI.O000000o(str2, dxe2, i3, i4, o000000o2);
            }
        });
        return o000000o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r1 == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        r1.onResponse(new _m_j.dxf(com.xiaomi.miio.MiioLocalErrorCode.TIMEOUT).O000000o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r3 == null) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        if (new java.lang.String(com.xiaomi.miio.MiioLocalAPI.f6017O000000o).equals(new java.lang.String(r0.token).toLowerCase()) == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        r1.onResponse(new _m_j.dxf(com.xiaomi.miio.MiioLocalErrorCode.PERMISSION_DENIED).O000000o());
        O000000o("get token error PERMISSION_DENIED", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
        O000000o("get token success", new java.lang.Object[0]);
        r1.onResponse(new _m_j.dxf(com.xiaomi.miio.MiioLocalErrorCode.SUCCESS, "{\"id\":1,\"result\":{\"token\":\"" + new java.lang.String(r0.token).toLowerCase() + "\", \"did\":\"" + r0.did + "\"}}", r0.did, r0.stamp, new java.lang.String(r0.token).toLowerCase(), r17).O000000o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013a, code lost:
        r1.onResponse(new _m_j.dxf(com.xiaomi.miio.MiioLocalErrorCode.EXCEPTION).O000000o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0148, code lost:
        if (r3 != null) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x014f, code lost:
        if (r3 != null) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0187, code lost:
        r1.onResponse(new _m_j.dxf(com.xiaomi.miio.MiioLocalErrorCode.TIMEOUT).O000000o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0195, code lost:
        if (r3 != null) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x019b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019c, code lost:
        if (r3 != null) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        java.lang.Thread.sleep(2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        _m_j.gsy.O000000o(4, "sleep", "get_token InterruptedException");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b2, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b7, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:23:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0138 A[ADDED_TO_REGION, Catch:{ all -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0185 A[ADDED_TO_REGION, Catch:{ all -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b2 A[Catch:{ InterruptedException -> 0x01a5 }] */
    public static synchronized void O000000o(String str, dxe dxe, int i, int i2, O000000o o000000o) {
        DatagramSocket datagramSocket;
        int i3;
        int i4;
        dxe dxe2 = dxe;
        synchronized (MiioLocalAPI.class) {
            O000000o("rpc getToken, timeout %d, retry %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 <= 0) {
                datagramSocket = null;
                i3 = 1;
            } else {
                datagramSocket = null;
                i3 = i2;
            }
            while (true) {
                if (i3 <= 0) {
                    break;
                }
                i4 = i3 - 1;
                try {
                    if (o000000o.f6027O000000o) {
                        break;
                    }
                    DatagramSocket datagramSocket2 = new DatagramSocket();
                    try {
                        datagramSocket2.setReuseAddress(true);
                        O000000o(datagramSocket2, InetAddress.getByName(str), JNIBridge.hencrypt(new JNIBridge.MiioMsg(-1, -1, f6017O000000o, null)));
                        byte[] bArr = new byte[65535];
                        String O000000o2 = O000000o(datagramSocket2, bArr, i);
                        JNIBridge.MiioMsg hdecrypt = JNIBridge.hdecrypt(bArr);
                        break;
                    } catch (SocketTimeoutException e) {
                        e = e;
                        datagramSocket = datagramSocket2;
                        try {
                            StringWriter stringWriter = new StringWriter();
                            e.printStackTrace(new PrintWriter(stringWriter));
                            O000000o("getToken Socket timeout exception " + e.toString() + stringWriter.toString(), new Object[0]);
                            if (dxe2 != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            datagramSocket2 = datagramSocket;
                            if (datagramSocket2 != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        datagramSocket = datagramSocket2;
                        StringWriter stringWriter2 = new StringWriter();
                        e.printStackTrace(new PrintWriter(stringWriter2));
                        O000000o("getToken  exception " + e.toString() + stringWriter2.toString(), new Object[0]);
                        if (dxe2 != null) {
                        }
                    } catch (Throwable th2) {
                    }
                } catch (SocketTimeoutException e3) {
                    e = e3;
                    StringWriter stringWriter3 = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter3));
                    O000000o("getToken Socket timeout exception " + e.toString() + stringWriter3.toString(), new Object[0]);
                    if (dxe2 != null) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    StringWriter stringWriter22 = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter22));
                    O000000o("getToken  exception " + e.toString() + stringWriter22.toString(), new Object[0]);
                    if (dxe2 != null) {
                    }
                }
                i3 = i4;
            }
        }
    }
}
