package com.xiaomi.onetrack.h;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.f.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

public class r {
    private static volatile long A = 0;
    private static Method E;
    private static boolean F;
    private static String G;
    private static boolean H = false;
    private static int I;
    private static final Set<String> J = new HashSet(Arrays.asList("AT", "BE", "BG", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FR", "GB", "GR", "HR", "HU", "IE", "IT", "LT", "LU", "LV", "MT", "NL", "PL", "PT", "RO", "SE", "SI", "SK"));
    private static Class k;
    private static Method l;
    private static Boolean m;
    private static final DecimalFormat y = new DecimalFormat("#0");
    private static final DecimalFormat z = new DecimalFormat("#0.#");

    static {
        try {
            E = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
        } catch (Exception unused) {
        }
        try {
            k = Class.forName("miui.os.Build");
        } catch (Exception unused2) {
        }
        try {
            Method declaredMethod = Class.forName("android.provider.MiuiSettings$Secure").getDeclaredMethod("isUserExperienceProgramEnable", ContentResolver.class);
            l = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Exception unused3) {
        }
    }

    private static String f(String str) {
        try {
            if (E != null) {
                return String.valueOf(E.invoke(null, str));
            }
        } catch (Exception e) {
            q.a("OsUtil", "getProp failed ex: " + e.getMessage());
        }
        return null;
    }

    public static boolean a() {
        Boolean bool = m;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!TextUtils.isEmpty(f("ro.miui.ui.version.code"))) {
            m = Boolean.TRUE;
        } else {
            m = Boolean.FALSE;
        }
        return m.booleanValue();
    }

    public static String b() {
        return Build.VERSION.RELEASE;
    }

    public static String c() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String d() {
        return a(TimeZone.getDefault().getRawOffset());
    }

    public static String a(int i) {
        try {
            int i2 = i / 60000;
            char c = '+';
            if (i2 < 0) {
                c = '-';
                i2 = -i2;
            }
            StringBuilder sb = new StringBuilder(9);
            sb.append("GMT");
            sb.append(c);
            a(sb, i2 / 60);
            sb.append(':');
            a(sb, i2 % 60);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static void a(StringBuilder sb, int i) {
        String num = Integer.toString(i);
        for (int i2 = 0; i2 < 2 - num.length(); i2++) {
            sb.append('0');
        }
        sb.append(num);
    }

    public static String e() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public static String a(Context context) {
        String f = f("gsm.operator.numeric");
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(f)) {
            for (String str : f.split(",")) {
                if (!TextUtils.isEmpty(str) && !"00000".equals(str)) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str);
                }
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            sb2 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        }
        return sb2 == null ? "" : sb2;
    }

    public static String f() {
        Class cls = k;
        if (cls == null) {
            return "";
        }
        try {
            if (((Boolean) cls.getField("IS_ALPHA_BUILD").get(null)).booleanValue()) {
                return "A";
            }
            if (((Boolean) k.getField("IS_DEVELOPMENT_VERSION").get(null)).booleanValue()) {
                return "D";
            }
            if (((Boolean) k.getField("IS_STABLE_VERSION").get(null)).booleanValue()) {
                return "S";
            }
            return "";
        } catch (Exception e) {
            Log.e("OsUtil", "getRomBuildCode failed: " + e.toString());
            return "";
        }
    }

    public static boolean b(Context context) {
        Method method = l;
        if (method == null) {
            return true;
        }
        try {
            return ((Boolean) method.invoke(null, context.getContentResolver())).booleanValue();
        } catch (Exception e) {
            Log.e("OsUtil", "isUserExperiencePlanEnabled failed: " + e.toString());
            return true;
        }
    }

    public static boolean a(String str) {
        if (OneTrack.isDisable() || OneTrack.isUseSystemNetTrafficOnly()) {
            q.c(str, "should not access network or location, cta");
            return true;
        } else if (!z()) {
            q.c(str, "should not access network or location, not provisioned");
            return true;
        } else if (g.b()) {
            return false;
        } else {
            q.c(str, "should not access network or location, cta");
            return true;
        }
    }

    public static String g() {
        return aa.a("ro.carrier.name", "");
    }

    public static String h() {
        return aa.a("ro.miui.xms.version", "");
    }

    public static boolean i() {
        String a2 = aa.a("ro.miui.region", "unknown");
        if (TextUtils.isEmpty(a2) || TextUtils.equals(a2, "unknown")) {
            return true;
        }
        return J.contains(a2.toUpperCase());
    }

    public static String j() {
        return Build.VERSION.RELEASE;
    }

    public static String k() {
        return Build.VERSION.INCREMENTAL;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static String D() {
        try {
            String a2 = aa.a("ro.miui.region", "");
            if (TextUtils.isEmpty(a2)) {
                a2 = aa.a("ro.product.locale.region", "");
            }
            if (TextUtils.isEmpty(a2) && Build.VERSION.SDK_INT >= 24) {
                Object invoke = Class.forName("android.os.LocaleList").getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
                Object invoke2 = invoke.getClass().getMethod("size", new Class[0]).invoke(invoke, new Object[0]);
                if ((invoke2 instanceof Integer) && ((Integer) invoke2).intValue() > 0) {
                    Object invoke3 = invoke.getClass().getMethod("get", Integer.TYPE).invoke(invoke, 0);
                    Object invoke4 = invoke3.getClass().getMethod("getCountry", new Class[0]).invoke(invoke3, new Object[0]);
                    if (invoke4 instanceof String) {
                        a2 = invoke4;
                    }
                }
            }
            if (TextUtils.isEmpty(a2)) {
                a2 = Locale.getDefault().getCountry();
            }
            if (!TextUtils.isEmpty(a2)) {
                return a2.trim();
            }
        } catch (Exception e) {
            q.b("OsUtil", "getRegion Exception: ", e);
        }
        return "";
    }

    public static String l() {
        return Build.VERSION.RELEASE;
    }

    public static int m() {
        return Build.VERSION.SDK_INT;
    }

    public static String n() {
        return aa.a("ro.miui.cust_variant", "");
    }

    public static String o() {
        return aa.a("ro.miui.region", "");
    }

    public static String p() {
        return aa.a("persist.radio.modem", "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.r.a(long, boolean):java.lang.String
     arg types: [long, int]
     candidates:
      com.xiaomi.onetrack.h.r.a(java.lang.StringBuilder, int):void
      com.xiaomi.onetrack.h.r.a(android.content.Context, java.lang.String):boolean
      com.xiaomi.onetrack.h.r.a(android.content.Context, java.io.File):android.content.pm.Signature[]
      com.xiaomi.onetrack.h.r.a(long, boolean):java.lang.String */
    public static String c(Context context) {
        return a(f(context), true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.onetrack.h.r.a(long, boolean):java.lang.String
     arg types: [long, int]
     candidates:
      com.xiaomi.onetrack.h.r.a(java.lang.StringBuilder, int):void
      com.xiaomi.onetrack.h.r.a(android.content.Context, java.lang.String):boolean
      com.xiaomi.onetrack.h.r.a(android.content.Context, java.io.File):android.content.pm.Signature[]
      com.xiaomi.onetrack.h.r.a(long, boolean):java.lang.String */
    public static String q() {
        return a(E(), true);
    }

    public static String r() {
        return aa.a("ro.board.platform", "");
    }

    public static boolean s() {
        return aa.a("ro.product.mod_device", "").endsWith("_global");
    }

    public static int t() {
        try {
            Class<?> cls = Class.forName("miui.telephony.TelephonyManager");
            return ((Integer) cls.getMethod("getPhoneCount", new Class[0]).invoke(cls.getMethod("getDefault", new Class[0]).invoke(null, new Object[0]), new Object[0])).intValue();
        } catch (Exception e) {
            q.b("OsUtil", "getPhoneCount Exception: ", e);
            return 0;
        }
    }

    private static long f(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 2048);
            String readLine = bufferedReader.readLine();
            String substring = readLine.substring(readLine.indexOf("MemTotal:"));
            bufferedReader.close();
            return ((long) Integer.parseInt(substring.replaceAll("\\D+", ""))) * 1024;
        } catch (Exception e) {
            q.b("OsUtil", "getTotalRAM Exception: ", e);
            return 0;
        }
    }

    public static double d(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            double intExtra = (double) registerReceiver.getIntExtra("level", -1);
            double intExtra2 = (double) registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra);
            Double.isNaN(intExtra2);
            double round = (double) Math.round((intExtra / intExtra2) * 100.0d * 10.0d);
            Double.isNaN(round);
            return round / 10.0d;
        } catch (Exception e) {
            Log.e(q.a("OsUtil"), "getBatteryInfo exception", e);
            return 0.0d;
        }
    }

    private static long E() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            if (blockCount >= 8589934592L) {
                return (((blockCount / 8) / 1073741824) + 1) * 1073741824 * 8;
            }
            return ((blockCount / 1073741824) + 1) * 1073741824;
        } catch (Exception e) {
            q.b("OsUtil", "getTotalROM Exception: ", e);
            return 0;
        }
    }

    public static String a(long j, boolean z2) {
        DecimalFormat decimalFormat;
        if (z2) {
            try {
                decimalFormat = y;
            } catch (Exception e) {
                q.b("OsUtil", "formatFileSize Exception: ", e);
                return "";
            }
        } else {
            decimalFormat = z;
        }
        if (j < 1024 && j > 0) {
            return decimalFormat.format((double) j) + "B";
        } else if (j < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d = (double) j;
            Double.isNaN(d);
            sb.append(decimalFormat.format(d / 1024.0d));
            sb.append("KB");
            return sb.toString();
        } else if (j < 1073741824) {
            StringBuilder sb2 = new StringBuilder();
            double d2 = (double) j;
            Double.isNaN(d2);
            sb2.append(decimalFormat.format(d2 / 1048576.0d));
            sb2.append("MB");
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            double d3 = (double) j;
            Double.isNaN(d3);
            sb3.append(decimalFormat.format(d3 / 1.073741824E9d));
            sb3.append("GB");
            return sb3.toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    public static int u() {
        Integer num = null;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                Method declaredMethod = Class.forName("android.os.UserHandle").getDeclaredMethod("getUserId", Integer.TYPE);
                declaredMethod.setAccessible(true);
                int myUid = Process.myUid();
                Integer num2 = (Integer) declaredMethod.invoke(null, Integer.valueOf(myUid));
                try {
                    q.a("OsUtil", String.format("getUserId, uid:%d, userId:%d", Integer.valueOf(myUid), num2));
                    num = num2;
                } catch (Exception e) {
                    Integer num3 = num2;
                    e = e;
                    num = num3;
                    Log.e(q.a("OsUtil"), "getUserId exception: ", e);
                    if (num == null) {
                    }
                    return num.intValue();
                }
            }
        } catch (Exception e2) {
            e = e2;
            Log.e(q.a("OsUtil"), "getUserId exception: ", e);
            if (num == null) {
            }
            return num.intValue();
        }
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    public static boolean v() {
        return u() == 0;
    }

    public static boolean w() {
        int u = u();
        if (u < 10 || u == 99 || u == 999) {
            return false;
        }
        q.a("OsUtil", "second space");
        return true;
    }

    public static boolean x() {
        return u() == 999;
    }

    public static boolean b(String str) {
        try {
            return ((Boolean) Class.forName("miui.os.MiuiInit").getMethod("isPreinstalledPackage", String.class).invoke(null, str)).booleanValue();
        } catch (ClassNotFoundException e) {
            if (a()) {
                Log.e(q.a("OsUtil"), "checkPreinstallApp failed:", e);
            }
            return false;
        } catch (Exception e2) {
            Log.e(q.a("OsUtil"), "checkPreinstallApp failed:", e2);
            return false;
        }
    }

    public static boolean c(String str) {
        try {
            return ((Boolean) Class.forName("miui.os.MiuiInit").getMethod("isPreinstalledPAIPackage", String.class).invoke(null, str)).booleanValue();
        } catch (Exception e) {
            Log.e(q.a("OsUtil"), "isPreinstalledPAIPackage failed:", e);
            return false;
        }
    }

    public static int d(String str) {
        boolean b = b(str);
        return c(str) ? b | true ? 1 : 0 : b ? 1 : 0;
    }

    public static String y() {
        long currentTimeMillis = System.currentTimeMillis();
        Random random = new Random(currentTimeMillis);
        double d = (double) currentTimeMillis;
        double nextDouble = random.nextDouble();
        Double.isNaN(d);
        return d.h(String.valueOf(d + nextDouble)).substring(0, 24);
    }

    public static boolean a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    public static boolean b(Context context, String str) {
        try {
            return a(a(context, str, 0).applicationInfo);
        } catch (Exception unused) {
            return false;
        }
    }

    public static PackageInfo a(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String e(String str) {
        try {
            return a.a().getPackageManager().getPackageInfo(str, 16384).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean c(Context context, String str) {
        PackageInfo a2 = a(context, str, 0);
        if (a2 == null || a2.applicationInfo == null) {
            return false;
        }
        return true;
    }

    public static Signature[] a(Context context, File file) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(file.getPath(), 64).signatures;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Signature[] d(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception unused) {
            return null;
        }
    }

    @TargetApi(17)
    public static boolean z() {
        try {
            Context a2 = a.a();
            if (Build.VERSION.SDK_INT < 17) {
                return true;
            }
            boolean z2 = false;
            if (Settings.Global.getInt(a2.getContentResolver(), "device_provisioned", 0) != 0) {
                z2 = true;
            }
            if (!z2) {
                q.c("OsUtil", new StringBuilder("Provisioned: false").toString());
            }
            return z2;
        } catch (Exception e) {
            q.b("OsUtil", "isDeviceProvisioned exception", e);
            return true;
        }
    }

    public static String e(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return String.format("%d*%d", Integer.valueOf(point.y), Integer.valueOf(point.x));
    }

    private static boolean F() {
        Class cls = k;
        if (cls != null) {
            try {
                return ((Boolean) cls.getField("IS_INTERNATIONAL_BUILD").get(null)).booleanValue();
            } catch (Exception unused) {
            }
        }
        String D = D();
        if (TextUtils.isEmpty(D) || TextUtils.equals("CN", D.toUpperCase())) {
            return false;
        }
        return true;
    }

    public static boolean A() {
        if (!a() || H) {
            return F;
        }
        return F();
    }

    public static String B() {
        if (!a() || H) {
            return !TextUtils.isEmpty(G) ? G : D();
        }
        return D();
    }

    public static void a(boolean z2, String str, OneTrack.Mode mode) {
        int i;
        if (mode == OneTrack.Mode.APP) {
            i = 3;
        } else if (mode == OneTrack.Mode.PLUGIN) {
            i = 2;
        } else {
            i = mode == OneTrack.Mode.SDK ? 1 : 0;
        }
        if (I <= i) {
            F = z2;
            G = str;
            I = i;
        }
    }

    public static void a(boolean z2) {
        H = z2;
    }

    public static String C() {
        return D();
    }
}
