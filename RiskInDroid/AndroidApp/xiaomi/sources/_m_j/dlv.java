package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class dlv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14776O000000o = null;
    private static String O00000Oo = null;
    private static String O00000o = null;
    private static String O00000o0 = null;
    private static Random O00000oO = null;
    private static DisplayMetrics O00000oo = null;
    private static String O0000O0o = null;
    private static String O0000OOo = "";
    private static int O0000Oo = -1;
    private static String O0000Oo0 = "";
    /* access modifiers changed from: private */
    public static dlm O0000OoO = null;
    private static String O0000Ooo = null;
    private static long O0000o = -1;
    private static volatile int O0000o0 = -1;
    private static String O0000o00 = null;
    private static String O0000o0O = null;
    private static String O0000o0o = null;
    private static dly O0000oO = null;
    private static String O0000oO0 = "";
    private static String O0000oOO = "__MTA_FIRST_ACTIVATE__";
    private static int O0000oOo = -1;
    private static int O0000oo = 0;
    private static long O0000oo0 = -1;
    private static String O0000ooO = "";

    public static int O000000o() {
        return O0000Oo0().nextInt(Integer.MAX_VALUE);
    }

    private static Long O000000o(String str, String str2, Long l) {
        if (str == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\".concat(String.valueOf(str2));
        }
        String[] split = str.split(str2);
        if (split.length == 3) {
            try {
                Long l2 = 0L;
                for (String valueOf : split) {
                    l2 = Long.valueOf((l2.longValue() + Long.valueOf(valueOf).longValue()) * 100);
                }
                return l2;
            } catch (NumberFormatException unused) {
            }
        }
        return l;
    }

    public static String O000000o(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String O000000o(Context context, String str) {
        if (dkd.O0000oo0()) {
            if (O0000o00 == null) {
                O0000o00 = O0000o0O(context);
            }
            if (O0000o00 != null) {
                return str + "_" + O0000o00;
            }
        }
        return str;
    }

    public static String O000000o(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static HttpHost O000000o(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0 || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return null;
            }
            if ((activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) || (extraInfo = activeNetworkInfo.getExtraInfo()) == null) {
                return null;
            }
            if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                if (!extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    if (defaultHost != null && defaultHost.trim().length() > 0) {
                        return new HttpHost(defaultHost, Proxy.getDefaultPort());
                    }
                    return null;
                }
            }
            return new HttpHost("10.0.0.172", 80);
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
    }

    public static void O000000o(Context context, int i) {
        O0000oo = i;
        dma.O00000Oo(context, "mta.qq.com.difftime", i);
    }

    public static byte[] O000000o(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static int O00000Oo() {
        int i = O0000Oo;
        if (i != -1) {
            return i;
        }
        try {
            if (dlz.O000000o()) {
                O0000Oo = 1;
            }
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
        O0000Oo = 0;
        return 0;
    }

    public static long O00000Oo(String str) {
        return O000000o(str, ".", 0L).longValue();
    }

    public static synchronized String O00000Oo(Context context) {
        synchronized (dlv.class) {
            if (f14776O000000o == null || f14776O000000o.trim().length() == 0) {
                String O000000o2 = dmb.O000000o(context);
                f14776O000000o = O000000o2;
                if (O000000o2 == null || f14776O000000o.trim().length() == 0) {
                    f14776O000000o = Integer.toString(O0000Oo0().nextInt(Integer.MAX_VALUE));
                }
                String str = f14776O000000o;
                return str;
            }
            String str2 = f14776O000000o;
            return str2;
        }
    }

    public static long O00000o() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static DisplayMetrics O00000o(Context context) {
        if (O00000oo == null) {
            O00000oo = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(O00000oo);
        }
        return O00000oo;
    }

    public static synchronized String O00000o0(Context context) {
        String str;
        synchronized (dlv.class) {
            if (O00000o0 == null || O00000o0.trim().length() == 0) {
                O00000o0 = dmb.O00000Oo(context);
            }
            str = O00000o0;
        }
        return str;
    }

    public static boolean O00000o0(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static String O00000oO() {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, 0);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static boolean O00000oO(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            if (dmb.O000000o(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
                    for (int i = 0; i < allNetworkInfo.length; i++) {
                        if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                            return true;
                        }
                    }
                }
                return false;
            }
            O0000OoO.O00000Oo("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
    }

    public static String O00000oo(Context context) {
        String str = O00000Oo;
        if (str != null) {
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("TA_APPKEY");
            if (string != null) {
                O00000Oo = string;
                return string;
            }
            O0000OoO.O000000o("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            O0000OoO.O000000o("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String O0000O0o(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null) {
                return null;
            }
            Object obj = applicationInfo.metaData.get("InstallChannel");
            if (obj != null) {
                return obj.toString();
            }
            O0000OoO.O00000o0("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        } catch (Throwable unused) {
            O0000OoO.O00000oO("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static JSONObject O0000O0o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", dlw.O000000o());
            String O00000o2 = dlw.O00000o();
            if (O00000o2 != null && O00000o2.length() > 0) {
                jSONObject.put("na", O00000o2);
            }
            int O00000Oo2 = dlw.O00000Oo();
            if (O00000Oo2 > 0) {
                jSONObject.put("fx", O00000Oo2 / 1000000);
            }
            int O00000o02 = dlw.O00000o0();
            if (O00000o02 > 0) {
                jSONObject.put("fn", O00000o02 / 1000000);
            }
        } catch (Throwable th) {
            Log.w("MtaSDK", "get cpu error", th);
        }
        return jSONObject;
    }

    public static String O0000OOo(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    private static long O0000Oo() {
        long j = O0000o;
        if (j > 0) {
            return j;
        }
        long j2 = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j2 = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception unused) {
        }
        O0000o = j2;
        return j2;
    }

    public static String O0000Oo(Context context) {
        if (O00000o0(O0000OOo)) {
            return O0000OOo;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            O0000OOo = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
        return O0000OOo;
    }

    private static synchronized Random O0000Oo0() {
        Random random;
        synchronized (dlv.class) {
            if (O00000oO == null) {
                O00000oO = new Random();
            }
            random = O00000oO;
        }
        return random;
    }

    public static String O0000OoO(Context context) {
        try {
            if (!dmb.O000000o(context, "android.permission.INTERNET") || !dmb.O000000o(context, "android.permission.ACCESS_NETWORK_STATE")) {
                O0000OoO.O00000oO("can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return "";
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (typeName != null) {
                    if (typeName.equalsIgnoreCase("WIFI")) {
                        return "WIFI";
                    }
                    if (typeName.equalsIgnoreCase("MOBILE")) {
                        if (extraInfo == null) {
                            return "MOBILE";
                        }
                    } else if (extraInfo == null) {
                        return typeName;
                    }
                    return extraInfo;
                }
            }
            return "";
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
    }

    public static Integer O0000Ooo(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized Integer O0000o(Context context) {
        Integer valueOf;
        synchronized (dlv.class) {
            if (O0000o0 <= 0) {
                O0000o0 = dma.O000000o(context, "MTA_EVENT_INDEX", 0);
                dma.O00000Oo(context, "MTA_EVENT_INDEX", O0000o0 + 1000);
            } else if (O0000o0 % 1000 == 0) {
                try {
                    int i = O0000o0 + 1000;
                    if (O0000o0 >= 2147383647) {
                        i = 0;
                    }
                    dma.O00000Oo(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    O0000OoO.O00000o0(th);
                }
            }
            int i2 = O0000o0 + 1;
            O0000o0 = i2;
            valueOf = Integer.valueOf(i2);
        }
        return valueOf;
    }

    public static String O0000o0(Context context) {
        String path;
        if (O00000o0(O0000Ooo)) {
            return O0000Ooo;
        }
        try {
            if (dmb.O000000o(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (!(externalStorageState == null || !externalStorageState.equals("mounted") || (path = Environment.getExternalStorageDirectory().getPath()) == null)) {
                    StatFs statFs = new StatFs(path);
                    String str = String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000);
                    O0000Ooo = str;
                    return str;
                }
                return null;
            }
            O0000OoO.O00000Oo("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
    }

    public static String O0000o00(Context context) {
        if (O00000o0(O0000Oo0)) {
            return O0000Oo0;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            O0000Oo0 = str;
            if (str == null || O0000Oo0.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
        return O0000Oo0;
    }

    static String O0000o0O(Context context) {
        try {
            if (O0000o00 != null) {
                return O0000o00;
            }
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    O0000o00 = next.processName;
                    break;
                }
            }
            return O0000o00;
        } catch (Throwable unused) {
        }
    }

    public static String O0000o0o(Context context) {
        return O000000o(context, dll.O00000Oo);
    }

    public static String O0000oO(Context context) {
        List<Sensor> sensorList;
        if (O00000o0(O0000oO0)) {
            return O0000oO0;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null)) {
                StringBuilder sb = new StringBuilder(sensorList.size() * 10);
                for (int i = 0; i < sensorList.size(); i++) {
                    sb.append(sensorList.get(i).getType());
                    if (i != sensorList.size() - 1) {
                        sb.append(",");
                    }
                }
                O0000oO0 = sb.toString();
            }
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
        return O0000oO0;
    }

    public static synchronized int O0000oOO(Context context) {
        synchronized (dlv.class) {
            if (O0000oOo != -1) {
                int i = O0000oOo;
                return i;
            }
            O0000oOo(context);
            int i2 = O0000oOo;
            return i2;
        }
    }

    public static void O0000oOo(Context context) {
        int O000000o2 = dma.O000000o(context, O0000oOO, 1);
        O0000oOo = O000000o2;
        if (O000000o2 == 1) {
            dma.O00000Oo(context, O0000oOO, 0);
        }
    }

    public static void O0000oo(Context context) {
        O0000oo0 = System.currentTimeMillis();
        dma.O000000o(context, "mta.qq.com.checktime", O0000oo0);
    }

    public static boolean O0000oo0(Context context) {
        if (O0000oo0 < 0) {
            O0000oo0 = dma.O000000o(context, "mta.qq.com.checktime");
        }
        return Math.abs(System.currentTimeMillis() - O0000oo0) > 86400000;
    }

    public static String O0000ooO(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity.activityInfo != null && !resolveActivity.activityInfo.packageName.equals("android")) {
            return resolveActivity.activityInfo.packageName;
        }
        return null;
    }

    public static String O0000Oo0(Context context) {
        TelephonyManager telephonyManager;
        String str = O0000O0o;
        if (str != null) {
            return str;
        }
        try {
            if (dmb.O000000o(context, "android.permission.READ_PHONE_STATE")) {
                if ((context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    O0000O0o = telephonyManager.getSimOperator();
                }
            } else {
                O0000OoO.O00000oO("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            O0000OoO.O00000Oo(th);
        }
        return O0000O0o;
    }

    public static synchronized dlm O00000o0() {
        dlm dlm;
        synchronized (dlv.class) {
            if (O0000OoO == null) {
                dlm dlm2 = new dlm("MtaSDK");
                O0000OoO = dlm2;
                dlm2.f14770O000000o = false;
            }
            dlm = O0000OoO;
        }
        return dlm;
    }

    public static String O00000oo() {
        if (O00000o0(O0000o0o)) {
            return O0000o0o;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (long) statFs.getBlockSize();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs2.getBlockSize()) * ((long) statFs2.getAvailableBlocks())) / 1000000) + "/" + String.valueOf((((long) statFs.getBlockCount()) * blockSize) / 1000000);
        O0000o0o = str;
        return str;
    }

    public static String O0000oO0(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem / 1000000) + "/" + String.valueOf(O0000Oo() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean O000000o(dkf dkf) {
        if (dkf == null) {
            return false;
        }
        return O00000o0(dkf.f14739O000000o);
    }

    public static int O000000o(Context context, boolean z) {
        if (z) {
            O0000oo = dma.O000000o(context, "mta.qq.com.difftime", 0);
        }
        return O0000oo;
    }
}
