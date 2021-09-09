package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class dgt {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14616O000000o;
    private static String O00000Oo;

    public static String O000000o() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String O00000Oo() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static int O00000o0() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String O000000o(Context context) {
        if (context == null) {
            return null;
        }
        if (!dgr.O000000o(context, "android.permission.READ_PHONE_STATE")) {
            did.O00000o("no READ_PHONE_STATE permission to get IMEI", new Object[0]);
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null) {
                return deviceId.toLowerCase();
            }
            return deviceId;
        } catch (Throwable unused) {
            did.O000000o("Failed to get IMEI.", new Object[0]);
            return null;
        }
    }

    public static String O00000Oo(Context context) {
        if (context == null) {
            return null;
        }
        if (!dgr.O000000o(context, "android.permission.READ_PHONE_STATE")) {
            did.O00000o("no READ_PHONE_STATE permission to get IMSI", new Object[0]);
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String subscriberId = telephonyManager.getSubscriberId();
            if (subscriberId != null) {
                return subscriberId.toLowerCase();
            }
            return subscriberId;
        } catch (Throwable unused) {
            did.O000000o("Failed to get IMSI.", new Object[0]);
            return null;
        }
    }

    public static String O00000o0(Context context) {
        if (context == null) {
            return "fail";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string == null) {
                return "null";
            }
            return string.toLowerCase();
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                did.O000000o("Failed to get Android ID.", new Object[0]);
            }
            return "fail";
        }
    }

    public static String O00000o(Context context) {
        WifiInfo connectionInfo;
        String str = "fail";
        if (context == null) {
            return str;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || ((str = connectionInfo.getMacAddress()) != null && !str.equals("02:00:00:00:00:00")))) {
                String O000000o2 = dif.O000000o(context, "wifi.interface");
                did.O00000o0("MAC interface: %s", O000000o2);
                NetworkInterface byName = NetworkInterface.getByName(O000000o2);
                if (byName == null) {
                    byName = NetworkInterface.getByName("wlan0");
                }
                if (byName == null) {
                    byName = NetworkInterface.getByName("eth0");
                }
                if (byName != null) {
                    str = dif.O00000oo(byName.getHardwareAddress());
                }
            }
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
        if (str == null) {
            str = "null";
        }
        did.O00000o0("MAC address: %s", str);
        return str.toLowerCase();
    }

    public static String O00000oO(Context context) {
        if (context == null) {
            return "fail";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "fail";
            }
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            if (simSerialNumber == null) {
                return "null";
            }
            return simSerialNumber;
        } catch (Throwable unused) {
            did.O000000o("Failed to get SIM serial number.", new Object[0]);
            return "fail";
        }
    }

    public static String O00000o() {
        try {
            return Build.SERIAL;
        } catch (Throwable unused) {
            did.O000000o("Failed to get hardware serial number.", new Object[0]);
            return "fail";
        }
    }

    private static boolean O0000o0o() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x007b A[Catch:{ all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080 A[SYNTHETIC, Splitter:B:46:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0090 A[SYNTHETIC, Splitter:B:53:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a2 A[SYNTHETIC, Splitter:B:62:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b2 A[SYNTHETIC, Splitter:B:69:0x00b2] */
    private static String O0000o() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String str;
        try {
            fileReader = new FileReader("/system/build.prop");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            str = null;
                            break;
                        }
                        String[] split = readLine.split("=", 2);
                        if (split.length == 2) {
                            if (split[0].equals("ro.product.cpu.abilist")) {
                                str = split[1];
                                break;
                            } else if (split[0].equals("ro.product.cpu.abi")) {
                                str = split[1];
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!did.O000000o(th)) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (fileReader != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                            }
                            if (fileReader != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (str != null) {
                    str = str.split(",")[0];
                }
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (!did.O000000o(e)) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e2) {
                    if (!did.O000000o(e2)) {
                        e2.printStackTrace();
                    }
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                if (fileReader != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    if (!did.O000000o(e3)) {
                        e3.printStackTrace();
                    }
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e4) {
                    if (!did.O000000o(e4)) {
                        e4.printStackTrace();
                    }
                }
            }
            throw th;
        }
    }

    public static String O000000o(boolean z) {
        String str = null;
        if (z) {
            try {
                str = O0000o();
            } catch (Throwable th) {
                if (did.O000000o(th)) {
                    return "fail";
                }
                th.printStackTrace();
                return "fail";
            }
        }
        if (str == null) {
            str = System.getProperty("os.arch");
        }
        return String.valueOf(str);
    }

    public static long O00000oO() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static long O00000oo() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0092 A[SYNTHETIC, Splitter:B:51:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a2 A[SYNTHETIC, Splitter:B:58:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b6 A[SYNTHETIC, Splitter:B:66:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00c6 A[SYNTHETIC, Splitter:B:73:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    public static long O0000O0o() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            if (!did.O000000o(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1;
                        } catch (IOException e2) {
                            if (did.O000000o(e2)) {
                                return -1;
                            }
                            e2.printStackTrace();
                            return -1;
                        }
                    } else {
                        long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            if (!did.O000000o(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            if (!did.O000000o(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        return parseLong;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!did.O000000o(th)) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (fileReader == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader != null) {
                        }
                        if (fileReader != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                if (fileReader != null) {
                }
                throw th;
            }
        } catch (Throwable th5) {
            fileReader = null;
            th = th5;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    if (!did.O000000o(e5)) {
                        e5.printStackTrace();
                    }
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e6) {
                    if (!did.O000000o(e6)) {
                        e6.printStackTrace();
                    }
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012b A[SYNTHETIC, Splitter:B:100:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013b A[SYNTHETIC, Splitter:B:107:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0101 A[Catch:{ all -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0106 A[SYNTHETIC, Splitter:B:84:0x0106] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0116 A[SYNTHETIC, Splitter:B:91:0x0116] */
    public static long O0000OOo() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader.readLine();
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            if (!did.O000000o(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            if (!did.O000000o(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + 0;
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            if (!did.O000000o(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            if (!did.O000000o(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong2 = parseLong + (Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    String readLine3 = bufferedReader.readLine();
                    if (readLine3 == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            if (!did.O000000o(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e6) {
                            if (!did.O000000o(e6)) {
                                e6.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong3 = parseLong2 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        if (!did.O000000o(e7)) {
                            e7.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e8) {
                        if (!did.O000000o(e8)) {
                            e8.printStackTrace();
                        }
                    }
                    return parseLong3;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                    }
                    if (fileReader != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (!did.O000000o(th)) {
                }
                if (bufferedReader2 != null) {
                }
                if (fileReader == null) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
            if (bufferedReader != null) {
            }
            if (fileReader != null) {
            }
            throw th;
        }
    }

    public static long O0000Oo0() {
        if (!O0000o0o()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return -2;
            }
            th.printStackTrace();
            return -2;
        }
    }

    public static long O0000Oo() {
        if (!O0000o0o()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return -2;
            }
            th.printStackTrace();
            return -2;
        }
    }

    public static String O0000OoO() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String O0000Ooo() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String O00000oo(Context context) {
        TelephonyManager telephonyManager;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "unknown";
            }
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    return "HSPA+";
                default:
                    return "MOBILE(" + networkType + ")";
            }
        } catch (Exception e) {
            if (did.O000000o(e)) {
                return "unknown";
            }
            e.printStackTrace();
            return "unknown";
        }
    }

    public static String O0000O0o(Context context) {
        String O000000o2 = dif.O000000o(context, "ro.miui.ui.version.name");
        if (!dif.O000000o(O000000o2) && !O000000o2.equals("fail")) {
            return "XiaoMi/MIUI/".concat(String.valueOf(O000000o2));
        }
        String O000000o3 = dif.O000000o(context, "ro.build.version.emui");
        if (!dif.O000000o(O000000o3) && !O000000o3.equals("fail")) {
            return "HuaWei/EMOTION/".concat(String.valueOf(O000000o3));
        }
        String O000000o4 = dif.O000000o(context, "ro.lenovo.series");
        if (!dif.O000000o(O000000o4) && !O000000o4.equals("fail")) {
            return "Lenovo/VIBE/".concat(String.valueOf(dif.O000000o(context, "ro.build.version.incremental")));
        }
        String O000000o5 = dif.O000000o(context, "ro.build.nubia.rom.name");
        if (dif.O000000o(O000000o5) || O000000o5.equals("fail")) {
            String O000000o6 = dif.O000000o(context, "ro.meizu.product.model");
            if (dif.O000000o(O000000o6) || O000000o6.equals("fail")) {
                String O000000o7 = dif.O000000o(context, "ro.build.version.opporom");
                if (!dif.O000000o(O000000o7) && !O000000o7.equals("fail")) {
                    return "Oppo/COLOROS/".concat(String.valueOf(O000000o7));
                }
                String O000000o8 = dif.O000000o(context, "ro.vivo.os.build.display.id");
                if (!dif.O000000o(O000000o8) && !O000000o8.equals("fail")) {
                    return "vivo/FUNTOUCH/".concat(String.valueOf(O000000o8));
                }
                String O000000o9 = dif.O000000o(context, "ro.aa.romver");
                if (dif.O000000o(O000000o9) || O000000o9.equals("fail")) {
                    String O000000o10 = dif.O000000o(context, "ro.lewa.version");
                    if (dif.O000000o(O000000o10) || O000000o10.equals("fail")) {
                        String O000000o11 = dif.O000000o(context, "ro.gn.gnromvernumber");
                        if (dif.O000000o(O000000o11) || O000000o11.equals("fail")) {
                            String O000000o12 = dif.O000000o(context, "ro.build.tyd.kbstyle_version");
                            if (!dif.O000000o(O000000o12) && !O000000o12.equals("fail")) {
                                return "dido/".concat(String.valueOf(O000000o12));
                            }
                            return dif.O000000o(context, "ro.build.fingerprint") + "/" + dif.O000000o(context, "ro.build.rom.id");
                        }
                        return "amigo/" + O000000o11 + "/" + dif.O000000o(context, "ro.build.display.id");
                    }
                    return "tcl/" + O000000o10 + "/" + dif.O000000o(context, "ro.build.display.id");
                }
                return "htc/" + O000000o9 + "/" + dif.O000000o(context, "ro.build.description");
            }
            return "Meizu/FLYME/" + dif.O000000o(context, "ro.build.display.id");
        }
        return "Zte/NUBIA/" + O000000o5 + "_" + dif.O000000o(context, "ro.build.nubia.rom.code");
    }

    public static String O0000OOo(Context context) {
        return dif.O000000o(context, "ro.board.platform");
    }

    public static boolean O0000Oo0(Context context) {
        boolean z;
        boolean z2;
        try {
            z = new File("/system/app/Superuser.apk").exists();
        } catch (Throwable th) {
            if (!did.O00000Oo(th)) {
                th.printStackTrace();
            }
            z = false;
        }
        Boolean bool = null;
        ArrayList<String> O000000o2 = dif.O000000o(context, new String[]{"/system/bin/sh", "-c", "type su"});
        if (O000000o2 != null && O000000o2.size() > 0) {
            Iterator<String> it = O000000o2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                did.O00000o0(next, new Object[0]);
                if (next.contains("not found")) {
                    bool = Boolean.FALSE;
                }
            }
            if (bool == null) {
                bool = Boolean.TRUE;
            }
        }
        if (bool == null) {
            z2 = false;
        } else {
            z2 = bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(z2);
        if ((Build.TAGS != null && Build.TAGS.contains("test-keys")) || z || valueOf.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x009b A[SYNTHETIC, Splitter:B:48:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7 A[SYNTHETIC, Splitter:B:56:0x00a7] */
    public static String O0000o00() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        try {
            StringBuilder sb = new StringBuilder();
            if (new File("/sys/block/mmcblk0/device/type").exists()) {
                bufferedReader3 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/type"));
                try {
                    String readLine = bufferedReader3.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    }
                    bufferedReader3.close();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader3;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            did.O000000o(e);
                        }
                    }
                    throw th;
                }
            } else {
                bufferedReader3 = null;
            }
            sb.append(",");
            if (new File("/sys/block/mmcblk0/device/name").exists()) {
                bufferedReader2 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/name"));
                try {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 != null) {
                        sb.append(readLine2);
                    }
                    bufferedReader2.close();
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            } else {
                bufferedReader2 = bufferedReader3;
            }
            sb.append(",");
            if (new File("/sys/block/mmcblk0/device/cid").exists()) {
                bufferedReader = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/cid"));
                try {
                    String readLine3 = bufferedReader.readLine();
                    if (readLine3 != null) {
                        sb.append(readLine3);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            } else {
                bufferedReader = bufferedReader2;
            }
            String sb2 = sb.toString();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    did.O000000o(e2);
                }
            }
            return sb2;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    public static String O0000Oo(Context context) {
        StringBuilder sb = new StringBuilder();
        String O000000o2 = dif.O000000o(context, "ro.genymotion.version");
        if (O000000o2 != null) {
            sb.append("ro.genymotion.version");
            sb.append("|");
            sb.append(O000000o2);
            sb.append("\n");
        }
        String O000000o3 = dif.O000000o(context, "androVM.vbox_dpi");
        if (O000000o3 != null) {
            sb.append("androVM.vbox_dpi");
            sb.append("|");
            sb.append(O000000o3);
            sb.append("\n");
        }
        String O000000o4 = dif.O000000o(context, "qemu.sf.fake_camera");
        if (O000000o4 != null) {
            sb.append("qemu.sf.fake_camera");
            sb.append("|");
            sb.append(O000000o4);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093 A[SYNTHETIC, Splitter:B:36:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a3 A[SYNTHETIC, Splitter:B:44:0x00a3] */
    public static String O0000OoO(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        StringBuilder sb = new StringBuilder();
        if (f14616O000000o == null) {
            f14616O000000o = dif.O000000o(context, "ro.secure");
        }
        if (f14616O000000o != null) {
            sb.append("ro.secure");
            sb.append("|");
            sb.append(f14616O000000o);
            sb.append("\n");
        }
        if (O00000Oo == null) {
            O00000Oo = dif.O000000o(context, "ro.debuggable");
        }
        if (O00000Oo != null) {
            sb.append("ro.debuggable");
            sb.append("|");
            sb.append(O00000Oo);
            sb.append("\n");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        did.O000000o(th);
                        if (bufferedReader != null) {
                        }
                        return sb.toString();
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                did.O000000o(e);
                            }
                        }
                        throw th;
                    }
                }
            } while (!readLine.startsWith("TracerPid:"));
            if (readLine != null) {
                String trim = readLine.substring(10).trim();
                sb.append("tracer_pid");
                sb.append("|");
                sb.append(trim);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                did.O000000o(e2);
            }
            return sb2;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b3 A[SYNTHETIC, Splitter:B:51:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00be A[SYNTHETIC, Splitter:B:57:0x00be] */
    public static String O0000o0() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            if (new File("/sys/class/power_supply/ac/online").exists()) {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader("/sys/class/power_supply/ac/online"));
                try {
                    String readLine = bufferedReader3.readLine();
                    if (readLine != null) {
                        sb.append("ac_online");
                        sb.append("|");
                        sb.append(readLine);
                    }
                    bufferedReader3.close();
                    bufferedReader2 = bufferedReader3;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader3;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            }
            sb.append("\n");
            if (new File("/sys/class/power_supply/usb/online").exists()) {
                BufferedReader bufferedReader4 = new BufferedReader(new FileReader("/sys/class/power_supply/usb/online"));
                try {
                    String readLine2 = bufferedReader4.readLine();
                    if (readLine2 != null) {
                        sb.append("usb_online");
                        sb.append("|");
                        sb.append(readLine2);
                    }
                    bufferedReader4.close();
                    bufferedReader2 = bufferedReader4;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader4;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            did.O000000o(e);
                        }
                    }
                    throw th;
                }
            }
            sb.append("\n");
            if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                bufferedReader = new BufferedReader(new FileReader("/sys/class/power_supply/battery/capacity"));
                try {
                    String readLine3 = bufferedReader.readLine();
                    if (readLine3 != null) {
                        sb.append("battery_capacity");
                        sb.append("|");
                        sb.append(readLine3);
                    }
                    bufferedReader.close();
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            } else {
                bufferedReader = bufferedReader2;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    did.O000000o(e2);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        return sb.toString();
    }

    public static String O0000Ooo(Context context) {
        StringBuilder sb = new StringBuilder();
        String O000000o2 = dif.O000000o(context, "gsm.sim.state");
        if (O000000o2 != null) {
            sb.append("gsm.sim.state");
            sb.append("|");
            sb.append(O000000o2);
        }
        sb.append("\n");
        String O000000o3 = dif.O000000o(context, "gsm.sim.state2");
        if (O000000o3 != null) {
            sb.append("gsm.sim.state2");
            sb.append("|");
            sb.append(O000000o3);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[SYNTHETIC, Splitter:B:20:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a A[SYNTHETIC, Splitter:B:26:0x004a] */
    public static long O0000o0O() {
        BufferedReader bufferedReader;
        Throwable th;
        float f = 0.0f;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    f = ((float) (System.currentTimeMillis() / 1000)) - Float.parseFloat(readLine.split(" ")[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    did.O000000o(th);
                    if (bufferedReader != null) {
                    }
                    return (long) f;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                did.O000000o(e);
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    did.O000000o(e2);
                }
            }
            throw th;
        }
        return (long) f;
    }
}
