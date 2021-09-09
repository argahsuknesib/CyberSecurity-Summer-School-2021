package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.push.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public final class erv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15757O000000o = null;
    private static String O00000Oo = null;
    private static String O00000o = null;
    private static String O00000o0 = "";
    private static String O00000oO = null;
    private static final String O00000oo = "\u0002";
    private static final String[] O0000O0o = {"--", "a-", "u-", "v-", "o-", "g-"};
    private static String O0000OOo = null;
    private static volatile boolean O0000Oo0 = false;

    @TargetApi(17)
    public static int O000000o() {
        Object O000000o2;
        if (Build.VERSION.SDK_INT >= 17 && (O000000o2 = emg.O000000o("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return Integer.class.cast(O000000o2).intValue();
        }
        return -1;
    }

    private static long O000000o(File file) {
        long j;
        long j2;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockCountLong();
            j = statFs.getBlockSizeLong();
        } else {
            j2 = (long) statFs.getBlockCount();
            j = (long) statFs.getBlockSize();
        }
        return j * j2;
    }

    public static void O000000o(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            O0000OOo = str;
            esw esw = null;
            try {
                if (O0000o00(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    esw = esw.O000000o(context, file2);
                    ele.O000000o(file2);
                    ele.O000000o(file2, O0000OOo);
                }
                ele.O000000o(new File(context.getFilesDir(), ".vdevid"), O0000OOo);
                if (esw != null) {
                    esw.O000000o();
                }
            } catch (IOException unused) {
                duv.O000000o("update vdevid failure.");
                if (esw != null) {
                    esw.O000000o();
                }
            } catch (Throwable th) {
                if (esw != null) {
                    esw.O000000o();
                }
                throw th;
            }
        }
    }

    public static void O000000o(Context context, Map<String, String> map) {
        if (map != null && context != null) {
            String O0000o0 = O0000o0(context);
            if (!TextUtils.isEmpty(O0000o0)) {
                map.put("local_virt_devid", O0000o0);
            }
        }
    }

    public static boolean O000000o(int i) {
        Integer num = (Integer) emg.O000000o("android.os.UserHandle", "getUserId", Integer.valueOf(i));
        return num != null && num.intValue() == 999;
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = O0000O0o;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [_m_j.esw, java.lang.String] */
    public static String O00000Oo(Context context) {
        ? r1 = 0;
        if (!O0000o00(context)) {
            return r1;
        }
        if (!TextUtils.isEmpty(O0000OOo)) {
            return O0000OOo;
        }
        String O00000Oo2 = ele.O00000Oo(new File(context.getFilesDir(), ".vdevid"));
        O0000OOo = O00000Oo2;
        if (!TextUtils.isEmpty(O00000Oo2)) {
            return O0000OOo;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            esw O000000o2 = esw.O000000o(context, file);
            O0000OOo = "";
            String O00000Oo3 = ele.O00000Oo(file);
            if (O00000Oo3 != null) {
                O0000OOo = O00000Oo3;
            }
            String str = O0000OOo;
            O000000o2.O000000o();
            return str;
        } catch (IOException unused) {
            duv.O000000o("getVDevID failure.");
            if (r1 != 0) {
                r1.O000000o();
            }
            return O0000OOo;
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.O000000o();
            }
            throw th;
        }
    }

    private static boolean O00000Oo(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown");
    }

    public static String O00000o() {
        return O0000O0o() + "KB";
    }

    public static String O00000o(Context context) {
        int O00000oo2 = O00000oo();
        String O00000oO2 = O00000oO(context);
        while (O00000oO2 == null) {
            int i = O00000oo2 - 1;
            if (O00000oo2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            O00000oO2 = O00000oO(context);
            O00000oo2 = i;
        }
        return O00000oO2;
    }

    private static boolean O00000o(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && eml.O00000oO(str) && !eml.O00000oo(str);
    }

    private static int O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i * 31) + str.charAt(i2);
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c  */
    public static String O00000o0(Context context) {
        String str;
        esw esw;
        esw esw2 = null;
        if (!O0000o00(context) || O0000Oo0) {
            return null;
        }
        O0000Oo0 = true;
        String O00000Oo2 = ele.O00000Oo(new File(context.getFilesDir(), ".vdevid"));
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            esw = esw.O000000o(context, file);
            try {
                str = ele.O00000Oo(file);
                esw.O000000o();
            } catch (IOException unused) {
                try {
                    duv.O000000o("check id failure.");
                    if (esw != null) {
                    }
                    str = null;
                    if (!TextUtils.isEmpty(O00000Oo2)) {
                    }
                } catch (Throwable th) {
                    th = th;
                    esw2 = esw;
                    if (esw2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException unused2) {
            esw = null;
            duv.O000000o("check id failure.");
            if (esw != null) {
                esw.O000000o();
            }
            str = null;
            if (!TextUtils.isEmpty(O00000Oo2)) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (esw2 != null) {
                esw2.O000000o();
            }
            throw th;
        }
        if (!TextUtils.isEmpty(O00000Oo2)) {
            O0000OOo = O00000Oo2;
            if (TextUtils.isEmpty(str) || str.length() > 128) {
                O000000o(context, O00000Oo2);
            } else if (!TextUtils.equals(O00000Oo2, str)) {
                duv.O000000o("vid changed, need sync");
                return str;
            }
            return null;
        }
        duv.O000000o("empty local vid");
        return "F*";
    }

    public static String O00000oO() {
        long O000000o2 = O000000o(Environment.getDataDirectory());
        return (O000000o2 / 1024) + "KB";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [android.telephony.TelephonyManager, java.lang.String, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    public static String O00000oO(Context context) {
        String str;
        Object O000000o2;
        Object O000000o3;
        Object O000000o4;
        if (esl.O00000oo()) {
            return "";
        }
        String str2 = f15757O000000o;
        if (str2 != null) {
            return str2;
        }
        try {
            if (O0000oO(context)) {
                String cast = (!esl.O000000o() || (O000000o3 = emg.O000000o("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (O000000o4 = emg.O000000o(O000000o3, "getMiuiDeviceId", new Object[0])) == null || !(O000000o4 instanceof String)) ? null : String.class.cast(O000000o4);
                if (cast == null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (Build.VERSION.SDK_INT < 26) {
                        str = telephonyManager.getDeviceId();
                    } else {
                        if (1 == telephonyManager.getPhoneType()) {
                            O000000o2 = emg.O000000o((Object) telephonyManager, "getImei", (Object[]) null);
                        } else if (2 == telephonyManager.getPhoneType()) {
                            O000000o2 = emg.O000000o((Object) telephonyManager, "getMeid", (Object[]) null);
                        }
                        str = (String) O000000o2;
                    }
                }
                str = cast;
            } else {
                str = null;
            }
            if (!O00000o(str)) {
                return "";
            }
            f15757O000000o = str;
            return str;
        } catch (Throwable th) {
            duv.O000000o("failure to get id:".concat(String.valueOf(th)));
            return null;
        }
    }

    private static int O00000oo() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    public static String O00000oo(Context context) {
        int O00000oo2 = O00000oo();
        String O0000O0o2 = O0000O0o(context);
        while (O0000O0o2 == null) {
            int i = O00000oo2 - 1;
            if (O00000oo2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            O0000O0o2 = O0000O0o(context);
            O00000oo2 = i;
        }
        return O0000O0o2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A[SYNTHETIC, Splitter:B:30:0x0055] */
    private static int O0000O0o() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        int i = 0;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        i = Integer.parseInt(split[1]);
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
            } catch (Exception unused3) {
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return i;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = null;
                th = th4;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        return i;
    }

    public static String O0000O0o(Context context) {
        O0000oO0(context);
        if (TextUtils.isEmpty(O00000o0)) {
            return "";
        }
        String str = "";
        for (String str2 : O00000o0.split(",")) {
            if (O00000o(str2)) {
                str = str + eml.O000000o(str2) + ",";
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String O0000OOo(Context context) {
        synchronized (erv.class) {
            if (O00000oO != null) {
                String str = O00000oO;
                return str;
            }
            String O0000o0o = O0000o0o(context);
            String O0000o0O = O0000o0O(context);
            String O00000Oo2 = eml.O00000Oo(O0000o0o + O0000o0O);
            O00000oO = O00000Oo2;
            return O00000Oo2;
        }
    }

    public static String O0000Oo(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static synchronized String O0000Oo0(Context context) {
        String O00000Oo2;
        synchronized (erv.class) {
            String O0000o0o = O0000o0o(context);
            O00000Oo2 = eml.O00000Oo(O0000o0o + ((String) null));
        }
        return O00000Oo2;
    }

    public static boolean O0000OoO(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean O0000Ooo(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static String O0000o(Context context) {
        int O00000oo2 = O00000oo();
        String O00000oO2 = O00000oO(context);
        while (TextUtils.isEmpty(O00000oO2)) {
            int i = O00000oo2 - 1;
            if (O00000oo2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            O00000oO2 = O00000oO(context);
            O00000oo2 = i;
        }
        return O00000oO2;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:21:0x0054 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [_m_j.esw] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|(2:13|(5:15|16|17|18|(1:20)))|21|22|(1:24)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a A[Catch:{ IOException -> 0x0066, all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static String O0000o0(Context context) {
        esw esw;
        String str;
        esw esw2;
        ? r1 = 0;
        if (!O0000o00(context)) {
            duv.O000000o("not support read lvdd.");
            return null;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevidlocal");
            if (!file.exists() || !file.isFile()) {
                duv.O00000Oo("lvdf not exists");
                esw2 = null;
            } else {
                esw2 = esw.O000000o(context, file);
                try {
                    String O00000Oo2 = ele.O00000Oo(file);
                    if (!TextUtils.isEmpty(O00000Oo2)) {
                        String[] split = O00000Oo2.split(O00000oo);
                        if (split.length == 2) {
                            String str2 = split[0];
                            if (O00000o0(str2) == Integer.parseInt(split[1])) {
                                r1 = str2;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(r1)) {
                        ele.O000000o(file);
                        duv.O00000Oo("lvdd content invalid, remove it.");
                    }
                } catch (IOException unused) {
                    String str3 = r1;
                    r1 = esw2;
                    str = str3;
                    try {
                        duv.O000000o("get lvdd failure.");
                        if (r1 != 0) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        esw = r1;
                        if (esw != null) {
                            esw.O000000o();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    esw = esw2;
                    if (esw != null) {
                    }
                    throw th;
                }
            }
            if (esw2 != null) {
                esw2.O000000o();
            }
            return r1;
        } catch (IOException unused2) {
            str = null;
            duv.O000000o("get lvdd failure.");
            if (r1 != 0) {
                return str;
            }
            r1.O000000o();
            return str;
        }
    }

    private static boolean O0000o00(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 || !esm.O000000o(context, "android.permission.WRITE_EXTERNAL_STORAGE") || esl.O000000o()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            z = true;
        }
        if (!z) {
            return esu.O00000Oo(context);
        }
        return true;
    }

    private static String O0000o0O(Context context) {
        if (!O0000oO(context)) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 8 && Build.VERSION.SDK_INT < 26) {
            return Build.SERIAL;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return (String) emg.O000000o("android.os.Build", "getSerial", (Object[]) null);
        }
        return null;
    }

    private static String O0000o0o(Context context) {
        String str = O00000Oo;
        if (str != null) {
            return str;
        }
        try {
            O00000Oo = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            duv.O000000o("failure to get androidId: ".concat(String.valueOf(th)));
        }
        return O00000Oo;
    }

    private static boolean O0000oO(Context context) {
        String packageName = context.getPackageName();
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [android.telephony.TelephonyManager, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    private static String O0000oO0(Context context) {
        Object O000000o2;
        if (esl.O00000oo() || Build.VERSION.SDK_INT < 22) {
            return "";
        }
        if (!TextUtils.isEmpty(O00000o0)) {
            return O00000o0;
        }
        O00000oO(context);
        if (TextUtils.isEmpty(f15757O000000o)) {
            return "";
        }
        try {
            if (O0000oO(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Integer num = (Integer) emg.O000000o((Object) telephonyManager, "getPhoneCount", new Object[0]);
                if (num != null && num.intValue() > 1) {
                    String str = null;
                    for (int i = 0; i < num.intValue(); i++) {
                        if (Build.VERSION.SDK_INT < 26) {
                            O000000o2 = emg.O000000o((Object) telephonyManager, "getDeviceId", Integer.valueOf(i));
                        } else if (1 == telephonyManager.getPhoneType()) {
                            O000000o2 = emg.O000000o((Object) telephonyManager, "getImei", Integer.valueOf(i));
                        } else {
                            if (2 == telephonyManager.getPhoneType()) {
                                O000000o2 = emg.O000000o((Object) telephonyManager, "getMeid", Integer.valueOf(i));
                            }
                            if (!TextUtils.isEmpty(str) && !TextUtils.equals(f15757O000000o, str) && O00000o(str)) {
                                O00000o0 += str + ",";
                            }
                        }
                        str = (String) O000000o2;
                        O00000o0 += str + ",";
                    }
                    int length = O00000o0.length();
                    if (length > 0) {
                        O00000o0 = O00000o0.substring(0, length - 1);
                    }
                    return O00000o0;
                }
            }
            return "";
        } catch (Exception e) {
            duv.O000000o("failure to get ids: ".concat(String.valueOf(e)));
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0135, code lost:
        if (r7 != null) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013f, code lost:
        if (r7 == null) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0141, code lost:
        r7.O000000o();
     */
    public static String O000000o(Context context, boolean z) {
        String str;
        if (O00000o == null) {
            String O0000o0o = O0000o0o(context);
            String O00000o2 = !esl.O00000oo() ? z ? O00000o(context) : O0000o(context) : "";
            String O0000o0O = O0000o0O(context);
            int i = 1;
            if ((Build.VERSION.SDK_INT < 26) || !O00000Oo(O00000o2) || !O00000Oo(O0000o0O)) {
                O0000o0o = O00000o2 + O0000o0o + O0000o0O;
            } else {
                String O00000Oo2 = elz.O000000o(context).O00000Oo();
                if (!TextUtils.isEmpty(O00000Oo2)) {
                    O0000o0o = O00000Oo2 + O0000o0o;
                    i = 2;
                } else {
                    String O0000o0 = O0000o0(context);
                    if (!TextUtils.isEmpty(O0000o0)) {
                        O0000o0o = O0000o0;
                        i = 3;
                    } else {
                        String O00000o02 = elz.O000000o(context).O00000o0();
                        if (!TextUtils.isEmpty(O00000o02)) {
                            i = 4;
                            O0000o0o = O00000o02;
                        } else {
                            i = 5;
                        }
                    }
                }
            }
            duv.O00000Oo("devid rule select:".concat(String.valueOf(i)));
            if (i == 3) {
                O00000o = O0000o0o;
            } else {
                StringBuilder sb = new StringBuilder();
                if (i > 0) {
                    String[] strArr = O0000O0o;
                    if (i < strArr.length) {
                        str = strArr[i];
                        sb.append(str);
                        sb.append(eml.O00000Oo(O0000o0o));
                        O00000o = sb.toString();
                    }
                }
                str = O0000O0o[0];
                sb.append(str);
                sb.append(eml.O00000Oo(O0000o0o));
                O00000o = sb.toString();
            }
            if (!TextUtils.isEmpty(O00000o)) {
                esw esw = null;
                try {
                    if (O0000o00(context)) {
                        File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                        File file2 = new File(file, ".vdevidlocal");
                        if (!file2.exists() || !file2.isFile()) {
                            esw = esw.O000000o(context, file2);
                            ele.O000000o(file2);
                            ele.O000000o(file2, O00000o + O00000oo + O00000o0(O00000o));
                            duv.O00000Oo("lvdd write succ.");
                        } else {
                            duv.O00000Oo("vdr exists, not rewrite.");
                        }
                    } else {
                        duv.O000000o("not support write lvdd.");
                    }
                } catch (IOException unused) {
                    duv.O000000o("write lvdd failure.");
                } catch (Throwable th) {
                    if (esw != null) {
                        esw.O000000o();
                    }
                    throw th;
                }
            }
        }
        return O00000o;
    }

    public static String O000000o(Context context) {
        try {
            return k.O000000o(context).f6455O000000o;
        } catch (Exception e) {
            duv.O000000o("failure to get gaid:" + e.getMessage());
            return null;
        }
    }

    public static String O00000Oo() {
        StringBuilder sb = new StringBuilder();
        float O0000O0o2 = (((float) (((((O0000O0o() + 102400) / 524288) + 1) * 512) * 1024)) / 1024.0f) / 1024.0f;
        double d = (double) O0000O0o2;
        if (d > 0.5d) {
            O0000O0o2 = (float) Math.ceil(d);
        }
        sb.append(O0000O0o2);
        sb.append("GB");
        return sb.toString();
    }

    public static String O00000o0() {
        double O000000o2 = (double) O000000o(Environment.getDataDirectory());
        Double.isNaN(O000000o2);
        int i = 1;
        while (true) {
            double d = (double) i;
            if (d < ((O000000o2 / 1024.0d) / 1024.0d) / 1024.0d) {
                i <<= 1;
            } else {
                return d + "GB";
            }
        }
    }
}
