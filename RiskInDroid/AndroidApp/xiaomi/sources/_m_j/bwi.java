package _m_j;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONObject;

public final class bwi {

    /* renamed from: O000000o  reason: collision with root package name */
    static WifiManager f13335O000000o = null;
    private static int O00000Oo;
    private static Hashtable<String, Long> O00000o = new Hashtable<>();
    private static String[] O00000o0;
    private static SparseArray<String> O00000oO = null;
    private static String[] O00000oo = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static String O0000O0o = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static boolean O0000OOo = false;

    public static double O000000o(double d) {
        double d2 = (double) ((long) (d * 1000000.0d));
        Double.isNaN(d2);
        return d2 / 1000000.0d;
    }

    public static float O000000o(float f) {
        double d = (double) f;
        Double.isNaN(d);
        double d2 = (double) ((long) (d * 100.0d));
        Double.isNaN(d2);
        return (float) (d2 / 100.0d);
    }

    public static float O000000o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return O000000o(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static float O000000o(DPoint dPoint, DPoint dPoint2) {
        return O000000o(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static float O000000o(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int O000000o(int i) {
        return (i * 2) - 113;
    }

    public static int O000000o(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static Object O000000o(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            bvz.O000000o(th, "Utils", "getServ");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    public static String O000000o(long j, String str) {
        SimpleDateFormat simpleDateFormat;
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            simpleDateFormat = new SimpleDateFormat(str, Locale.CHINA);
            try {
                simpleDateFormat.applyPattern(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            simpleDateFormat = null;
            bvz.O000000o(th, "Utils", "formatUTC");
            if (j <= 0) {
            }
            if (simpleDateFormat != null) {
            }
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        return simpleDateFormat != null ? "NULL" : simpleDateFormat.format(Long.valueOf(j));
    }

    public static void O000000o() {
    }

    public static boolean O000000o(long j, long j2) {
        String O000000o2 = O000000o(j, "yyyyMMddHH");
        String O000000o3 = O000000o(j2, "yyyyMMddHH");
        if ("NULL".equals(O000000o2) || "NULL".equals(O000000o3)) {
            return false;
        }
        return O000000o2.equals(O000000o3);
    }

    public static boolean O000000o(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return O00000o() < 17 ? O00000o(context, "android.provider.Settings$System") : O00000o(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String[], android.database.Cursor] */
    public static boolean O000000o(SQLiteDatabase sQLiteDatabase, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = "2.0.201501131131".replace(".", "");
        if (sQLiteDatabase != null) {
            ? r3 = 0;
            try {
                if (sQLiteDatabase.isOpen()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SELECT count(*) as c FROM sqlite_master WHERE type = 'table' AND name = '");
                    sb.append(str.trim());
                    sb.append(replace);
                    sb.append("' ");
                    Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), r3);
                    boolean z = rawQuery != null && rawQuery.moveToFirst() && rawQuery.getInt(0) > 0;
                    sb.delete(0, sb.length());
                    if (rawQuery == null) {
                        return z;
                    }
                    rawQuery.close();
                    return z;
                }
            } catch (Throwable th) {
                if (r3 != 0) {
                    r3.close();
                }
                throw th;
            }
        }
        return false;
    }

    public static boolean O000000o(Location location, int i) {
        Boolean bool = Boolean.FALSE;
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                bool = (Boolean) bwd.O000000o(location, "isFromMockProvider", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        if (bool.booleanValue()) {
            return true;
        }
        Bundle extras = location.getExtras();
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        return i == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f && location.getSpeed() == 0.0f;
    }

    public static boolean O000000o(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return O00000Oo(aMapLocation);
        }
        return false;
    }

    public static boolean O000000o(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null && !"8".equals(aMapLocationServer.d()) && !"5".equals(aMapLocationServer.d()) && !"6".equals(aMapLocationServer.d())) {
            return O00000Oo(aMapLocationServer);
        }
        return false;
    }

    public static boolean O000000o(String str) {
        return !TextUtils.isEmpty(str) && !"00:00:00:00:00:00".equals(str) && !str.contains(" :");
    }

    public static boolean O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> O00000o2 = O00000o(str);
            String[] split = str2.toString().split("#");
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].contains(",nb") || split[i3].contains(",access")) {
                    i++;
                    if (O00000o2.contains(split[i3])) {
                        i2++;
                    }
                }
            }
            double size = (double) (O00000o2.size() + i);
            Double.isNaN(size);
            if (((double) (i2 * 2)) >= size * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static boolean O000000o(JSONObject jSONObject, String str) {
        return brs.O000000o(jSONObject, str);
    }

    public static byte[] O000000o(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & 65280) >> 8);
        return bArr;
    }

    public static byte[] O000000o(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] O000000o(byte[] bArr) {
        try {
            return brs.O00000Oo(bArr);
        } catch (Throwable th) {
            bvz.O000000o(th, "Utils", "gz");
            return null;
        }
    }

    public static String[] O000000o(TelephonyManager telephonyManager) {
        int i;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            bvz.O000000o(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if (!"0".equals(strArr2[0]) && !"0".equals(strArr2[1])) {
            O00000o0 = strArr2;
        } else if ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = O00000o0) != null) {
            return strArr;
        }
        return strArr2;
    }

    public static double O00000Oo(double d) {
        double d2 = (double) ((long) (d * 100.0d));
        Double.isNaN(d2);
        return d2 / 100.0d;
    }

    public static long O00000Oo() {
        return System.currentTimeMillis();
    }

    public static String O00000Oo(int i) {
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 16:
            case 17:
            default:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            case 18:
                return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
            case 19:
                return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
        }
    }

    public static String O00000Oo(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(bvz.O0000O0o)) {
            return bvz.O0000O0o;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(bwt.O00000o0(context), 64);
        } catch (Throwable th) {
            bvz.O000000o(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(bvz.O0000OOo)) {
                bvz.O0000OOo = null;
            }
        } catch (Throwable th2) {
            bvz.O000000o(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String O00000o02 = bwt.O00000o0(context);
        if (!TextUtils.isEmpty(O00000o02)) {
            sb.append(",");
            sb.append(O00000o02);
        }
        if (!TextUtils.isEmpty(bvz.O0000OOo)) {
            sb.append(",");
            sb.append(bvz.O0000OOo);
        }
        String sb2 = sb.toString();
        bvz.O0000O0o = sb2;
        return sb2;
    }

    public static String O00000Oo(TelephonyManager telephonyManager) {
        int i = 0;
        if (O00000oO == null) {
            SparseArray<String> sparseArray = new SparseArray<>();
            O00000oO = sparseArray;
            sparseArray.append(0, "UNKWN");
            O00000oO.append(1, "GPRS");
            O00000oO.append(2, "EDGE");
            O00000oO.append(3, "UMTS");
            O00000oO.append(4, "CDMA");
            O00000oO.append(5, "EVDO_0");
            O00000oO.append(6, "EVDO_A");
            O00000oO.append(7, "1xRTT");
            O00000oO.append(8, "HSDPA");
            O00000oO.append(9, "HSUPA");
            O00000oO.append(10, "HSPA");
            O00000oO.append(11, "IDEN");
            O00000oO.append(12, "EVDO_B");
            O00000oO.append(13, "LTE");
            O00000oO.append(14, "EHRPD");
            O00000oO.append(15, "HSPAP");
        }
        if (telephonyManager != null) {
            try {
                i = telephonyManager.getNetworkType();
            } catch (Throwable unused) {
            }
        }
        return O00000oO.get(i, "UNKWN");
    }

    public static boolean O00000Oo(long j, long j2) {
        String O000000o2 = O000000o(j, "yyyyMMdd");
        String O000000o3 = O000000o(j2, "yyyyMMdd");
        if ("NULL".equals(O000000o2) || "NULL".equals(O000000o3)) {
            return false;
        }
        return O000000o2.equals(O000000o3);
    }

    public static boolean O00000Oo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean O00000Oo(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static byte[] O00000Oo(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] O00000Oo(String str) {
        return O000000o(Integer.parseInt(str), (byte[]) null);
    }

    public static int O00000o() {
        int i = O00000Oo;
        if (i > 0) {
            return i;
        }
        try {
            return bwd.O00000Oo("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static ArrayList<String> O00000o(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(",nb") || split[i].contains(",access")) {
                    arrayList.add(split[i]);
                }
            }
        }
        return arrayList;
    }

    public static boolean O00000o(Context context) {
        try {
            NetworkInfo O00000o02 = O00000o0(context);
            return O00000o02 != null && O00000o02.isConnectedOrConnecting();
        } catch (Throwable unused) {
        }
    }

    private static boolean O00000o(Context context, String str) throws Throwable {
        return ((Integer) bwd.O000000o(str, "getInt", new Object[]{context.getContentResolver(), ((String) bwd.O000000o(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static double O00000o0(double d) {
        double d2 = (double) ((long) (d * 1000000.0d));
        Double.isNaN(d2);
        return d2 / 1000000.0d;
    }

    public static long O00000o0() {
        return SystemClock.elapsedRealtime();
    }

    public static NetworkInfo O00000o0(Context context) {
        try {
            return bww.O0000oO0(context);
        } catch (Throwable th) {
            bvz.O000000o(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static boolean O00000o0(long j, long j2) {
        if (!O00000Oo(j, j2)) {
            return false;
        }
        Calendar instance = Calendar.getInstance(Locale.CHINA);
        instance.setTimeInMillis(j);
        int i = instance.get(11);
        instance.setTimeInMillis(j2);
        int i2 = instance.get(11);
        if (i > 12) {
            if (i2 > 12) {
                return true;
            }
        } else if (i2 <= 12) {
            return true;
        }
        return false;
    }

    public static boolean O00000o0(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static byte[] O00000o0(String str) {
        return O00000Oo(Integer.parseInt(str), (byte[]) null);
    }

    public static double O00000oO(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static String O00000oO() {
        return Build.MODEL;
    }

    public static boolean O00000oO(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.equals(bwt.O00000o0(context))) {
                    if (next.importance != 100) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            bvz.O000000o(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    public static float O00000oo(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static String O00000oo() {
        return Build.VERSION.RELEASE;
    }

    public static boolean O00000oo(Context context) {
        int i;
        if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            for (String checkCallingOrSelfPermission : O00000oo) {
                if (context.checkCallingOrSelfPermission(checkCallingOrSelfPermission) != 0) {
                    return false;
                }
            }
        } else {
            Application application = (Application) context;
            for (String str : O00000oo) {
                try {
                    i = bwd.O00000Oo(application.getBaseContext(), "checkSelfPermission", str);
                } catch (Throwable unused) {
                    i = 0;
                }
                if (i != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int O0000O0o() {
        return new Random().nextInt(65536) - 32768;
    }

    public static int O0000O0o(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static boolean O0000O0o(Context context) {
        int i;
        if (context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        try {
            i = bwd.O00000Oo(((Application) context).getBaseContext(), "checkSelfPermission", O0000O0o);
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 0;
    }

    public static int O0000OOo(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static void O0000OOo() {
        O00000o.clear();
    }

    @SuppressLint({"NewApi"})
    public static boolean O0000OOo(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (f13335O000000o == null) {
            f13335O000000o = (WifiManager) O000000o(context, "wifi");
        }
        try {
            z = f13335O000000o.isWifiEnabled();
        } catch (Throwable unused) {
            z = false;
        }
        if (z || O00000o() <= 17) {
            return z;
        }
        try {
            return "true".equals(String.valueOf(bwd.O000000o(f13335O000000o, "isScanAlwaysAvailable", new Object[0])));
        } catch (Throwable unused2) {
            return z;
        }
    }

    public static String O0000Oo(Context context) {
        String O0000Ooo = bww.O0000Ooo(context);
        if (TextUtils.isEmpty(O0000Ooo) || O0000Ooo.equals("00:00:00:00:00:00")) {
            O0000Ooo = context == null ? "00:00:00:00:00:00" : bwg.O00000Oo(context, "pref", "smac", "00:00:00:00:00:00");
        }
        if (TextUtils.isEmpty(O0000Ooo)) {
            O0000Ooo = "00:00:00:00:00:00";
        }
        if (!O0000OOo) {
            if (context != null && !TextUtils.isEmpty(O0000Ooo)) {
                bwg.O000000o(context, "pref", "smac", O0000Ooo);
            }
            O0000OOo = true;
        }
        return O0000Ooo;
    }

    public static byte O0000Oo0(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static String O0000Oo0() {
        try {
            return bwx.O00000Oo("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String O0000Oo0(Context context) {
        NetworkInfo O00000o02 = O00000o0(context);
        if (O00000o02 == null || !O00000o02.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = O00000o02.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return "UNKNOWN";
        }
        String subtypeName = O00000o02.getSubtypeName();
        switch (O00000o02.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                break;
            case 3:
            case 5:
            case 6:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                if (!"GSM".equalsIgnoreCase(subtypeName)) {
                    return ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
                }
                break;
        }
        return "2G";
    }

    public static boolean O0000OoO(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static boolean O0000Ooo(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), NotificationCompat.FLAG_HIGH_PRIORITY);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }
}
