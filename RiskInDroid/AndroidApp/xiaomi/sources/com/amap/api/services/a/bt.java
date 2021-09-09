package com.amap.api.services.a;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class bt {

    /* renamed from: a  reason: collision with root package name */
    static String f3351a = "";
    static String b = "";
    public static boolean c = false;
    static String d = "";
    static boolean e = false;
    static int f = -1;
    static String g = "";
    static String h = "";
    private static String i = null;
    private static boolean j = false;
    private static String k = "";
    private static String l = "";
    private static String m = "";
    private static String n = "";
    private static String o = "";
    private static String p = "";
    private static boolean q = false;
    private static long r = 0;
    private static int s = 0;
    private static String t = null;
    private static String u = "";

    public static String a() {
        return i;
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String b2 = a.b();
        d = b2;
        return b2;
    }

    public static String b(final Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String a2 = a.a(context);
        if (!TextUtils.isEmpty(a2)) {
            b = a2;
            return a2;
        } else if (j) {
            return "";
        } else {
            j = true;
            cl.c().submit(new Runnable() {
                /* class com.amap.api.services.a.bt.AnonymousClass1 */

                public final void run() {
                    Map<String, String> a2 = a.a();
                    if (a2 != null) {
                        String a3 = a.a(bt.h(context), bt.u(context), bt.m(context), bt.w(context));
                        if (!TextUtils.isEmpty(a3)) {
                            byte[] bArr = new byte[0];
                            try {
                                bArr = db.a().a(new da(a3.getBytes(), a2));
                            } catch (bo e) {
                                e.printStackTrace();
                            }
                            a.a(context, new String(bArr));
                        }
                    }
                }
            });
            return "";
        }
    }

    public static String c(Context context) {
        try {
            return B(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            return E(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        try {
            return F(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int f(Context context) {
        try {
            return C(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String g(Context context) {
        try {
            return A(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void b() {
        try {
            if (Build.VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", Integer.TYPE).invoke(null, 40964);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x009e A[SYNTHETIC, Splitter:B:50:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    private static String z(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (bz.a(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 0) {
                            if (eventType != 2) {
                                if (eventType == 3) {
                                    z = false;
                                } else if (eventType == 4) {
                                    if (z) {
                                        String text = newPullParser.getText();
                                        try {
                                            fileInputStream2.close();
                                        } catch (Throwable unused) {
                                        }
                                        return text;
                                    }
                                }
                            } else if (newPullParser.getAttributeCount() > 0) {
                                int attributeCount = newPullParser.getAttributeCount();
                                boolean z2 = z;
                                for (int i2 = 0; i2 < attributeCount; i2++) {
                                    String attributeValue = newPullParser.getAttributeValue(i2);
                                    if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                                        z2 = true;
                                    }
                                }
                                z = z2;
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
            }
            throw th;
        }
        try {
            fileInputStream.close();
            return "";
        } catch (Throwable unused3) {
            return "";
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a A[RETURN] */
    public static String h(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (f3351a != null && !"".equals(f3351a)) {
            return f3351a;
        }
        if (a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f3351a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (f3351a != null && !"".equals(f3351a)) {
            return f3351a;
        }
        try {
            f3351a = z(context);
        } catch (Throwable unused) {
        }
        String str = f3351a;
        if (str != null) {
            return "";
        }
        return str;
    }

    public static String i(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        if (!a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) bz.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                l = Build.SERIAL;
            }
            String str = l;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable unused) {
        }
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), bz.c(new String(cg.a(13))));
            k = string;
            return string == null ? "" : k;
        } catch (Throwable unused) {
            return k;
        }
    }

    private static boolean a(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    static String k(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (!a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && wifiManager.isWifiEnabled()) {
                return wifiManager.getConnectionInfo().getBSSID();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    static String l(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                List<ScanResult> a2 = a(scanResults);
                                int i2 = 0;
                                boolean z = true;
                                while (i2 < a2.size() && i2 < 7) {
                                    ScanResult scanResult = a2.get(i2);
                                    if (z) {
                                        z = false;
                                    } else {
                                        sb.append(";");
                                    }
                                    sb.append(scanResult.BSSID);
                                    i2++;
                                }
                            }
                        }
                        return sb.toString();
                    }
                    return sb.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    public static String m(Context context) {
        try {
            if (m != null) {
                if (!"".equals(m)) {
                    return m;
                }
            }
            if (!a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return m;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            m = wifiManager.getConnectionInfo().getMacAddress();
            if (bz.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(m) || bz.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(m)) {
                m = e();
            }
            return m;
        } catch (Throwable unused) {
        }
    }

    private static String e() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    if (Build.VERSION.SDK_INT >= 9) {
                        bArr = networkInterface.getHardwareAddress();
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArr) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append(":");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    static String[] n(Context context) {
        try {
            if (a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (a(context, bz.c("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return new String[]{"", ""};
                    }
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        int cid = gsmCellLocation.getCid();
                        int lac = gsmCellLocation.getLac();
                        return new String[]{lac + "||" + cid, "gsm"};
                    }
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        int systemId = cdmaCellLocation.getSystemId();
                        int networkId = cdmaCellLocation.getNetworkId();
                        int baseStationId = cdmaCellLocation.getBaseStationId();
                        return new String[]{systemId + "||" + networkId + "||" + baseStationId, "cdma"};
                    }
                    return new String[]{"", ""};
                }
            }
            return new String[]{"", ""};
        } catch (Throwable unused) {
        }
    }

    static String o(Context context) {
        try {
            TelephonyManager G = G(context);
            if (G == null) {
                return "";
            }
            String networkOperator = G.getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                return "";
            }
            if (networkOperator.length() < 3) {
                return "";
            }
            return networkOperator.substring(3);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int p(Context context) {
        try {
            return F(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int q(Context context) {
        try {
            return C(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NetworkInfo r(Context context) {
        ConnectivityManager D;
        if (a(context, bz.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (D = D(context)) != null) {
            return D.getActiveNetworkInfo();
        }
        return null;
    }

    static String s(Context context) {
        try {
            NetworkInfo r2 = r(context);
            if (r2 == null) {
                return null;
            }
            return r2.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    static String t(Context context) {
        StringBuilder sb;
        try {
            if (n != null) {
                if (!"".equals(n)) {
                    return n;
                }
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i3 > i2) {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("*");
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append("*");
                sb.append(i2);
            }
            n = sb.toString();
            return n;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r7 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0092, code lost:
        if (r7.length() == 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0094, code lost:
        com.amap.api.services.a.bt.f = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0096, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0097, code lost:
        r7 = r7.substring(0, r7.length() - 1);
        com.amap.api.services.a.bt.g = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a2, code lost:
        return r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008a */
    public static String a(Context context, String str, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 21) {
            return "";
        }
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (!z && f >= 0 && f < 2) {
            return "";
        }
        TelephonyManager G = G(context);
        if (f == -1) {
            Method a2 = bz.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
            if (a2 != null) {
                f = ((Integer) a2.invoke(G, new Object[0])).intValue();
            }
            try {
                f = 0;
            } catch (Throwable unused) {
                return "";
            }
        }
        if (z || f > 1) {
            Method a3 = bz.a(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
            if (a3 != null) {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    if (i2 < f) {
                        sb.append((String) a3.invoke(G, Integer.valueOf(i2)));
                        sb.append(str);
                        i2++;
                    }
                    break;
                }
            }
            f = 0;
            return "";
        }
        return "";
    }

    public static String u(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            if (o != null && !"".equals(o)) {
                return o;
            }
            if (!a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return o;
            }
            TelephonyManager G = G(context);
            if (G == null) {
                return "";
            }
            Method a2 = bz.a(G.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                a2 = bz.a(G.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (a2 != null) {
                o = (String) a2.invoke(G, new Object[0]);
            }
            if (o == null) {
                o = "";
            }
            return o;
        } catch (Throwable unused) {
        }
    }

    public static String v(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            if (p != null && !"".equals(p)) {
                return p;
            }
            if (!a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return p;
            }
            TelephonyManager G = G(context);
            if (G == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Method a2 = bz.a(G.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (a2 != null) {
                    p = (String) a2.invoke(G, new Object[0]);
                }
                if (p == null) {
                    p = "";
                }
            }
            return p;
        } catch (Throwable unused) {
        }
    }

    public static String w(Context context) {
        try {
            return A(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long c() {
        long j2;
        long j3;
        long j4 = r;
        if (j4 != 0) {
            return j4;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                j3 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                j2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                j3 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1048576;
                j2 = (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize())) / 1048576;
            }
            r = j3 + j2;
        } catch (Throwable unused) {
        }
        return r;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A[SYNTHETIC, Splitter:B:22:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060 A[SYNTHETIC, Splitter:B:28:0x0060] */
    public static int x(Context context) {
        int i2 = s;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            i3 = (int) (memoryInfo.totalMem / 1024);
        } else {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File("/proc/meminfo")));
                try {
                    i3 = Integer.valueOf(bufferedReader2.readLine().split("\\s+")[1]).intValue();
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                }
                throw th;
            }
        }
        int i4 = i3 / 1024;
        s = i4;
        return i4;
    }

    public static String d() {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        String property = System.getProperty("os.arch");
        t = property;
        return property;
    }

    static String y(Context context) {
        try {
            return B(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String A(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String str = u;
        if (str != null && !"".equals(str)) {
            return u;
        }
        if (!a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return u;
        }
        TelephonyManager G = G(context);
        if (G == null) {
            return "";
        }
        Method a2 = bz.a(G.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (a2 != null) {
            u = (String) a2.invoke(G, new Object[0]);
        }
        if (u == null) {
            u = "";
        }
        return u;
    }

    private static String B(Context context) {
        if (!a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager G = G(context);
        if (G == null) {
            return "";
        }
        String simOperatorName = G.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? G.getNetworkOperatorName() : simOperatorName;
    }

    private static int C(Context context) {
        ConnectivityManager D;
        NetworkInfo activeNetworkInfo;
        if (context == null || !a(context, bz.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (D = D(context)) == null || (activeNetworkInfo = D.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager D(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static String E(Context context) {
        String w = w(context);
        return (w == null || w.length() < 5) ? "" : w.substring(3, 5);
    }

    private static int F(Context context) {
        TelephonyManager G;
        if (a(context, bz.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (G = G(context)) != null) {
            return G.getNetworkType();
        }
        return -1;
    }

    private static TelephonyManager G(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static List<ScanResult> a(List<ScanResult> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            for (int i3 = 1; i3 < size - i2; i3++) {
                int i4 = i3 - 1;
                if (list.get(i4).level > list.get(i3).level) {
                    list.set(i4, list.get(i3));
                    list.set(i3, list.get(i4));
                }
            }
        }
        return list;
    }
}
