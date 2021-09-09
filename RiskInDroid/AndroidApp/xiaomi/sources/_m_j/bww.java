package _m_j;

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
import com.loc.t;
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

public final class bww {

    /* renamed from: O000000o  reason: collision with root package name */
    static String f13366O000000o = "";
    static String O00000Oo = "";
    static String O00000o = "";
    public static boolean O00000o0 = false;
    static boolean O00000oO = false;
    static int O00000oo = -1;
    static String O0000O0o = "";
    static String O0000OOo = "";
    private static boolean O0000Oo = false;
    private static String O0000Oo0 = null;
    private static String O0000OoO = "";
    private static String O0000Ooo = "";
    private static boolean O0000o = false;
    private static String O0000o0 = "";
    private static String O0000o00 = "";
    private static String O0000o0O = "";
    private static String O0000o0o = "";
    private static int O0000oO = 0;
    private static long O0000oO0 = 0;
    private static String O0000oOO = null;
    private static String O0000oOo = "";

    public static String O000000o() {
        return O0000Oo0;
    }

    public static String O000000o(final Context context) {
        if (!TextUtils.isEmpty(O00000Oo)) {
            return O00000Oo;
        }
        String O000000o2 = bro.O000000o(context);
        if (!TextUtils.isEmpty(O000000o2)) {
            O00000Oo = O000000o2;
            return O000000o2;
        } else if (O0000Oo) {
            return "";
        } else {
            O0000Oo = true;
            bsf.O00000o().submit(new Runnable() {
                /* class _m_j.bww.AnonymousClass1 */

                public final void run() {
                    Map<String, String> O000000o2 = bro.O000000o();
                    if (O000000o2 != null) {
                        String O000000o3 = bro.O000000o(bww.O0000O0o(context), bww.O0000oOo(context), bww.O0000Ooo(context), bww.O0000ooO(context));
                        if (!TextUtils.isEmpty(O000000o3)) {
                            byte[] bArr = new byte[0];
                            try {
                                bsw.O000000o();
                                bArr = bsw.O000000o(new bsv(O000000o3.getBytes(), O000000o2));
                            } catch (t e) {
                                e.printStackTrace();
                            }
                            bro.O000000o(context, new String(bArr));
                        }
                    }
                }
            });
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:13|(2:15|16)|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r8 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        if (r8.length() == 0) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0081, code lost:
        _m_j.bww.O00000oo = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        r8 = r8.substring(0, r8.length() - 1);
        _m_j.bww.O0000O0o = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
        return "";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0077 */
    public static String O000000o(Context context, String str) {
        if (Build.VERSION.SDK_INT < 29) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (TextUtils.isEmpty(O0000O0o)) {
                    TelephonyManager O000O0o = O000O0o(context);
                    if (O00000oo == -1) {
                        Method O000000o2 = brs.O000000o(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                        if (O000000o2 != null) {
                            O00000oo = ((Integer) O000000o2.invoke(O000O0o, new Object[0])).intValue();
                        }
                        O00000oo = 0;
                    }
                    Method O000000o3 = brs.O000000o(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
                    if (O000000o3 != null) {
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        while (true) {
                            if (i < O00000oo) {
                                sb.append((String) O000000o3.invoke(O000O0o, Integer.valueOf(i)));
                                sb.append(str);
                                i++;
                            }
                            break;
                        }
                    }
                    O00000oo = 0;
                    return "";
                }
                return O0000O0o;
            }
            return "";
        }
        return "";
    }

    private static List<ScanResult> O000000o(List<ScanResult> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - i; i2++) {
                int i3 = i2 - 1;
                if (list.get(i3).level > list.get(i2).level) {
                    list.set(i3, list.get(i2));
                    list.set(i2, list.get(i3));
                }
            }
        }
        return list;
    }

    public static void O000000o(String str) {
        O0000Oo0 = str;
    }

    public static String O00000Oo() {
        if (!TextUtils.isEmpty(O00000o)) {
            return O00000o;
        }
        String O00000Oo2 = bro.O00000Oo();
        O00000o = O00000Oo2;
        return O00000Oo2;
    }

    public static String O00000Oo(Context context) {
        try {
            return O000O0OO(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static boolean O00000Oo(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static int O00000o(Context context) {
        try {
            return O000O0o0(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static long O00000o() {
        long j;
        long j2;
        long j3 = O0000oO0;
        if (j3 != 0) {
            return j3;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                j = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                j2 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1048576;
                j = (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize())) / 1048576;
            }
            O0000oO0 = j2 + j;
        } catch (Throwable unused) {
        }
        return O0000oO0;
    }

    public static String O00000o0(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String O0000ooO = O0000ooO(context);
            if (O0000ooO != null) {
                if (O0000ooO.length() >= 5) {
                    return O0000ooO.substring(3, 5);
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void O00000o0() {
        try {
            if (Build.VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", Integer.TYPE).invoke(null, 40964);
            }
        } catch (Throwable unused) {
        }
    }

    public static int O00000oO(Context context) {
        try {
            return O000O0Oo(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String O00000oO() {
        if (!TextUtils.isEmpty(O0000oOO)) {
            return O0000oOO;
        }
        String property = System.getProperty("os.arch");
        O0000oOO = property;
        return property;
    }

    private static String O00000oo() {
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
                    for (byte b : bArr) {
                        String upperCase = Integer.toHexString(b & 255).toUpperCase();
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

    public static String O00000oo(Context context) {
        try {
            return O000O00o(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|(1:10)|11|(2:15|16)|17|18|19|(1:22)(1:23)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    public static String O0000O0o(Context context) {
        if (f13366O000000o != null && !"".equals(f13366O000000o)) {
            return f13366O000000o;
        }
        if (O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f13366O000000o = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (f13366O000000o != null && !"".equals(f13366O000000o)) {
            return f13366O000000o;
        }
        f13366O000000o = O00oOooo(context);
        String str = f13366O000000o;
        return str != null ? "" : str;
    }

    public static String O0000OOo(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        if (!TextUtils.isEmpty(O0000Ooo)) {
            return O0000Ooo;
        }
        if (!O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) brs.O000000o(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                O0000Ooo = Build.SERIAL;
            }
            String str = O0000Ooo;
            return str == null ? "" : str;
        } catch (Throwable unused) {
        }
    }

    static String O0000Oo(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (!O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager != null && wifiManager.isWifiEnabled()) ? wifiManager.getConnectionInfo().getBSSID() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String O0000Oo0(Context context) {
        if (!TextUtils.isEmpty(O0000OoO)) {
            return O0000OoO;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), brs.O00000o0(new String(bsa.O000000o(13))));
            O0000OoO = string;
            return string == null ? "" : O0000OoO;
        } catch (Throwable unused) {
            return O0000OoO;
        }
    }

    static String O0000OoO(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                List<ScanResult> O000000o2 = O000000o(scanResults);
                                int i = 0;
                                boolean z = true;
                                while (i < O000000o2.size() && i < 7) {
                                    ScanResult scanResult = O000000o2.get(i);
                                    if (z) {
                                        z = false;
                                    } else {
                                        sb.append(";");
                                    }
                                    sb.append(scanResult.BSSID);
                                    i++;
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

    public static String O0000Ooo(Context context) {
        try {
            if (O0000o00 != null) {
                if (!"".equals(O0000o00)) {
                    return O0000o00;
                }
            }
            if (!O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return O0000o00;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            O0000o00 = wifiManager.getConnectionInfo().getMacAddress();
            if (brs.O00000o0("YMDI6MDA6MDA6MDA6MDA6MDA").equals(O0000o00) || brs.O00000o0("YMDA6MDA6MDA6MDA6MDA6MDA").equals(O0000o00)) {
                O0000o00 = O00000oo();
            }
            return O0000o00;
        } catch (Throwable unused) {
        }
    }

    public static int O0000o(Context context) {
        try {
            return O000O0Oo(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    static String O0000o0(Context context) {
        try {
            TelephonyManager O000O0o = O000O0o(context);
            if (O000O0o == null) {
                return "";
            }
            String networkOperator = O000O0o.getNetworkOperator();
            return !TextUtils.isEmpty(networkOperator) ? networkOperator.length() < 3 ? "" : networkOperator.substring(0, 3) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    static String[] O0000o00(Context context) {
        try {
            if (O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (O00000Oo(context, brs.O00000o0("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))) {
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

    static String O0000o0O(Context context) {
        try {
            TelephonyManager O000O0o = O000O0o(context);
            if (O000O0o == null) {
                return "";
            }
            String networkOperator = O000O0o.getNetworkOperator();
            return !TextUtils.isEmpty(networkOperator) ? networkOperator.length() < 3 ? "" : networkOperator.substring(3) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int O0000o0o(Context context) {
        try {
            return O000O0o0(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    static String O0000oO(Context context) {
        try {
            NetworkInfo O0000oO02 = O0000oO0(context);
            if (O0000oO02 == null) {
                return null;
            }
            return O0000oO02.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static NetworkInfo O0000oO0(Context context) {
        ConnectivityManager O00oOoOo;
        if (O00000Oo(context, brs.O00000o0("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (O00oOoOo = O00oOoOo(context)) != null) {
            return O00oOoOo.getActiveNetworkInfo();
        }
        return null;
    }

    static String O0000oOO(Context context) {
        StringBuilder sb;
        try {
            if (O0000o0 != null) {
                if (!"".equals(O0000o0)) {
                    return O0000o0;
                }
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i2 > i) {
                sb = new StringBuilder();
                sb.append(i);
                sb.append("*");
                sb.append(i2);
            } else {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("*");
                sb.append(i);
            }
            O0000o0 = sb.toString();
            return O0000o0;
        } catch (Throwable unused) {
        }
    }

    public static String O0000oOo(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            if (O0000o0O != null && !"".equals(O0000o0O)) {
                return O0000o0O;
            }
            if (!O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return O0000o0O;
            }
            TelephonyManager O000O0o = O000O0o(context);
            if (O000O0o == null) {
                return "";
            }
            Method O000000o2 = brs.O000000o(O000O0o.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                O000000o2 = brs.O000000o(O000O0o.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (O000000o2 != null) {
                O0000o0O = (String) O000000o2.invoke(O000O0o, new Object[0]);
            }
            if (O0000o0O == null) {
                O0000o0O = "";
            }
            return O0000o0O;
        } catch (Throwable unused) {
        }
    }

    public static String O0000oo(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            if (O0000o0o != null && !"".equals(O0000o0o)) {
                return O0000o0o;
            }
            if (!O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return O0000o0o;
            }
            TelephonyManager O000O0o = O000O0o(context);
            if (O000O0o == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Method O000000o2 = brs.O000000o(O000O0o.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (O000000o2 != null) {
                    O0000o0o = (String) O000000o2.invoke(O000O0o, new Object[0]);
                }
                if (O0000o0o == null) {
                    O0000o0o = "";
                }
            }
            return O0000o0o;
        } catch (Throwable unused) {
        }
    }

    public static String O0000oo0(Context context) {
        return O0000oOo(context) + "#" + O000000o(context);
    }

    public static String O0000ooO(Context context) {
        try {
            return O000O00o(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A[SYNTHETIC, Splitter:B:22:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060 A[SYNTHETIC, Splitter:B:28:0x0060] */
    public static int O0000ooo(Context context) {
        int i = O0000oO;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            i2 = (int) (memoryInfo.totalMem / 1024);
        } else {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File("/proc/meminfo")));
                try {
                    i2 = Integer.valueOf(bufferedReader2.readLine().split("\\s+")[1]).intValue();
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
        int i3 = i2 / 1024;
        O0000oO = i3;
        return i3;
    }

    private static String O000O00o(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String str = O0000oOo;
        if (str != null && !"".equals(str)) {
            return O0000oOo;
        }
        if (!O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return O0000oOo;
        }
        TelephonyManager O000O0o = O000O0o(context);
        if (O000O0o == null) {
            return "";
        }
        Method O000000o2 = brs.O000000o(O000O0o.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (O000000o2 != null) {
            O0000oOo = (String) O000000o2.invoke(O000O0o, new Object[0]);
        }
        if (O0000oOo == null) {
            O0000oOo = "";
        }
        return O0000oOo;
    }

    private static String O000O0OO(Context context) {
        if (!O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager O000O0o = O000O0o(context);
        if (O000O0o == null) {
            return "";
        }
        String simOperatorName = O000O0o.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? O000O0o.getNetworkOperatorName() : simOperatorName;
    }

    private static int O000O0Oo(Context context) {
        ConnectivityManager O00oOoOo;
        NetworkInfo activeNetworkInfo;
        if (context == null || !O00000Oo(context, brs.O00000o0("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (O00oOoOo = O00oOoOo(context)) == null || (activeNetworkInfo = O00oOoOo.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static TelephonyManager O000O0o(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static int O000O0o0(Context context) {
        TelephonyManager O000O0o;
        if (O00000Oo(context, brs.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (O000O0o = O000O0o(context)) != null) {
            return O000O0o.getNetworkType();
        }
        return -1;
    }

    private static ConnectivityManager O00oOoOo(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    static String O00oOooO(Context context) {
        try {
            return O000O0OO(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x009e A[SYNTHETIC, Splitter:B:50:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    private static String O00oOooo(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (brs.O000000o(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
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
                                for (int i = 0; i < attributeCount; i++) {
                                    String attributeValue = newPullParser.getAttributeValue(i);
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
}
