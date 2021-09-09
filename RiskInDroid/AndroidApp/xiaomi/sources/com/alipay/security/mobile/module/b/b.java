package com.alipay.security.mobile.module.b;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.alipay.security.mobile.module.a.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f3235a = new b();

    private b() {
    }

    public static b a() {
        return f3235a;
    }

    public static String a(Context context) {
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    private static boolean a(Context context, String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static String b() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    public static String b(Context context) {
        String str;
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                    return str != null ? "" : str;
                }
            } catch (Throwable unused) {
            }
        }
        str = "";
        if (str != null) {
        }
    }

    public static String c() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(a.a().getPath());
                j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(j);
    }

    public static String c(Context context) {
        int i = 0;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i == 1 ? "1" : "0";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0083, code lost:
        if (r2 != null) goto L_0x004f;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0061 A[SYNTHETIC, Splitter:B:36:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0068 A[SYNTHETIC, Splitter:B:40:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006f A[SYNTHETIC, Splitter:B:44:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0077 A[SYNTHETIC, Splitter:B:51:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x007e A[SYNTHETIC, Splitter:B:55:0x007e] */
    public static String d() {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        String str = "0000000000000000";
        LineNumberReader lineNumberReader = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/cpuinfo"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (Throwable unused) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused2) {
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(inputStreamReader);
                int i = 1;
                while (true) {
                    if (i < 100) {
                        try {
                            String readLine = lineNumberReader2.readLine();
                            if (readLine != null) {
                                if (readLine.indexOf("Serial") >= 0) {
                                    str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                                    break;
                                }
                                i++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            lineNumberReader = lineNumberReader2;
                            if (lineNumberReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (lineNumberReader != null) {
                }
                if (inputStreamReader != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            inputStreamReader = null;
            if (lineNumberReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused4) {
        }
        return str == null ? "" : str;
    }

    public static String d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i));
            jSONObject.put("call", String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put("alarm", String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static String e(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getNetworkOperatorName();
                }
            } catch (Throwable unused) {
            }
        }
        return (str == null || "null".equals(str)) ? "" : str;
    }

    public static String f() {
        String v = v();
        return !a.a(v) ? v : w();
    }

    public static String f(Context context) {
        List<Sensor> sensorList;
        String str = null;
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0)) {
                    StringBuilder sb = new StringBuilder();
                    for (Sensor next : sensorList) {
                        sb.append(next.getName());
                        sb.append(next.getVersion());
                        sb.append(next.getVendor());
                    }
                    str = a.e(sb.toString());
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|19|20|51) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003f A[SYNTHETIC, Splitter:B:30:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0046 A[SYNTHETIC, Splitter:B:34:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x004d A[SYNTHETIC, Splitter:B:41:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0054 A[SYNTHETIC, Splitter:B:45:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    public static String g() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String[] split = bufferedReader.readLine().split(":\\s+", 2);
                    if (split == null || split.length <= 1) {
                        fileReader.close();
                        bufferedReader.close();
                        return "";
                    }
                    String str = split[1];
                    fileReader.close();
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = null;
                th = th4;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Throwable th5) {
            bufferedReader = null;
            th = th5;
            fileReader = null;
            if (fileReader != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public static String g(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0)) {
                    for (Sensor next : sensorList) {
                        if (next != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", next.getName());
                            jSONObject.put("version", next.getVersion());
                            jSONObject.put("vendor", next.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:5|6|(2:8|9)|10|11|12|13) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0045 A[SYNTHETIC, Splitter:B:27:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004c A[SYNTHETIC, Splitter:B:34:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A[SYNTHETIC, Splitter:B:38:0x0053] */
    public static String h() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        long j = 0;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j = (long) Integer.parseInt(readLine.split("\\s+")[1]);
                }
                fileReader.close();
                bufferedReader.close();
            } catch (Throwable th3) {
                th = th3;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
            if (fileReader != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        return String.valueOf(j);
    }

    public static String h(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    public static String i(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.widthPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String j() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(j);
    }

    public static String j(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.heightPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String k(Context context) {
        String str = "";
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            return str;
        }
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (str == null || str.length() == 0 || "02:00:00:00:00:00".equals(str)) {
                return u();
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String l() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String l(Context context) {
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            if (simSerialNumber != null) {
                if (simSerialNumber == null) {
                    return simSerialNumber;
                }
                try {
                    if (simSerialNumber.length() != 0) {
                        return simSerialNumber;
                    }
                } catch (Throwable unused) {
                    return simSerialNumber;
                }
            }
        } catch (Throwable unused2) {
        }
        return "";
    }

    public static String m() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String m(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String n() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String n(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String o() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    public static String o(Context context) {
        String str;
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager.isWifiEnabled()) {
                str = wifiManager.getConnectionInfo().getBSSID();
                return str != null ? "" : str;
            }
        } catch (Throwable unused) {
        }
        str = "";
        if (str != null) {
        }
    }

    public static String p() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append("00" + ":");
            for (int i = 0; i < 7; i++) {
                sb.append(new File(strArr[i]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public static String p(Context context) {
        String str;
        int i = context.getApplicationInfo().targetSdkVersion;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                str = "";
                return str != null ? "" : str;
            }
            str = (Build.VERSION.SDK_INT < 26 || i < 28) ? Build.SERIAL : Build.getSerial();
            if (str != null) {
            }
        } catch (Throwable unused) {
        }
    }

    public static String q() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        for (int i = 0; i <= 0; i++) {
            try {
                Class.forName(strArr[0]);
                sb.append("1");
            } catch (Throwable unused) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    public static String q(Context context) {
        try {
            String t = t(context);
            String x = x();
            if (!a.b(t) || !a.b(x)) {
                return "";
            }
            return t + ":" + x();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085 A[SYNTHETIC, Splitter:B:23:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008e A[SYNTHETIC, Splitter:B:30:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x003b A[SYNTHETIC] */
    public static String r() {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb.append("00" + ":");
        for (String str : linkedHashMap.keySet()) {
            LineNumberReader lineNumberReader = null;
            char c = '0';
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine != null) {
                            if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                                c = '1';
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        lineNumberReader = lineNumberReader2;
                        sb.append('0');
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th;
                    }
                }
                sb.append(c);
                try {
                    lineNumberReader2.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                sb.append('0');
                if (lineNumberReader != null) {
                }
                throw th;
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|9|10|11|12|13|6) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0032 */
    public static String r(Context context) {
        try {
            long j = 0;
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            for (int i = 0; i < 5; i++) {
                long j2 = -1;
                j2 = new File(strArr[i]).lastModified();
                j = Math.max(j2, j);
            }
            return "1:".concat(String.valueOf(j));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String s() {
        StringBuilder sb = new StringBuilder();
        sb.append("00" + ":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            try {
                String str2 = null;
                String str3 = (String) Build.class.getField(str).get(null);
                String str4 = (String) linkedHashMap.get(str);
                if (str3 != null) {
                    str2 = str3.toLowerCase();
                }
                if (str2 != null && str2.contains(str4)) {
                    c = '1';
                }
            } catch (Throwable th) {
                sb.append('0');
                throw th;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a A[Catch:{ Throwable -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d A[Catch:{ Throwable -> 0x003f }] */
    public static String s(Context context) {
        boolean z;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("status", -1);
            if (intExtra2 != 2) {
                if (intExtra2 != 5) {
                    z = false;
                    StringBuilder sb = new StringBuilder();
                    sb.append(!z ? "1" : "0");
                    sb.append(":");
                    sb.append(intExtra);
                    return sb.toString();
                }
            }
            z = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(!z ? "1" : "0");
            sb2.append(":");
            sb2.append(intExtra);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String t() {
        StringBuilder sb = new StringBuilder();
        sb.append("00" + ":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            String str2 = (String) linkedHashMap.get(str);
            String b = a.b(str, "");
            if (b != null && b.contains(str2)) {
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static String t(Context context) {
        if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (!(subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7)) {
                if (subtype != 11) {
                    if (!(subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14)) {
                        if (subtype != 15) {
                            return subtype == 13 ? "4G" : "UNKNOW";
                        }
                    }
                    return "3G";
                }
            }
            return "2G";
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String u() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list == null) {
                return "02:00:00:00:00:00";
            }
            for (NetworkInterface networkInterface : list) {
                if (networkInterface != null && networkInterface.getName() != null && networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "02:00:00:00:00:00";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Integer.valueOf(hardwareAddress[i] & 255)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Throwable unused) {
            return "02:00:00:00:00:00";
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0038 A[SYNTHETIC, Splitter:B:27:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003d A[SYNTHETIC, Splitter:B:31:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0044 A[SYNTHETIC, Splitter:B:39:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    private static String v() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!a.a(readLine)) {
                        String trim = readLine.trim();
                        bufferedReader2.close();
                        try {
                            fileReader.close();
                        } catch (Throwable unused) {
                        }
                        return trim;
                    }
                    bufferedReader2.close();
                    try {
                        fileReader.close();
                        return "";
                    } catch (Throwable unused2) {
                        return "";
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedReader = bufferedReader2;
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                }
                if (fileReader != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            if (bufferedReader != null) {
            }
            if (fileReader != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004f A[SYNTHETIC, Splitter:B:30:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0056 A[SYNTHETIC, Splitter:B:34:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005d A[SYNTHETIC, Splitter:B:41:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0064 A[SYNTHETIC, Splitter:B:45:0x0064] */
    private static String w() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String[] split;
        String str = "";
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!a.a(readLine) && (split = readLine.split(":")) != null && split.length > 1 && split[0].contains("BogoMIPS")) {
                                str = split[1].trim();
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        return str;
    }

    private static String x() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String e() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }
}
