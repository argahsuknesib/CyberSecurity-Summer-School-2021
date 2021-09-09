package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class O00o {

    public class O000000o implements FileFilter {
        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static int O000000o(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getResources().getColor(i, null) : context.getResources().getColor(i);
    }

    public static long O000000o(String str) {
        try {
            return new File(str).getTotalSpace();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String O000000o() {
        int i = 0;
        String[][] strArr = {new String[]{"/system/xbin/which", "su"}, new String[]{"/system/bin/which", " su"}, new String[]{"which", "su"}};
        Process process = null;
        while (i < 3) {
            String[] strArr2 = strArr[i];
            try {
                process = Runtime.getRuntime().exec(strArr2);
                if (new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() != null) {
                    String O000000o2 = O000000o(strArr2);
                    if (process != null) {
                        process.destroy();
                    }
                    return O000000o2;
                }
                if (process == null) {
                    i++;
                }
                process.destroy();
                i++;
            } catch (Throwable unused) {
                if (process == null) {
                }
            }
        }
        return "";
    }

    private static String O000000o(TelephonyManager telephonyManager, String str, int i) {
        return telephonyManager.getClass().getMethod(str, Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i)).toString();
    }

    public static String O000000o(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append("|");
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(3:20|(2:22|23)|36)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:24|25|(2:(2:28|29)|37)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r0.size() == 1) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (r2 < 10) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r0.add(O000000o(r1, "getDeviceIdGemini", r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (r0.size() == 1) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (r5 < 10) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        r0.add(O000000o(r1, "getDeviceIdDs", r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0051 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0066 */
    @SuppressLint({"HardwareIds"})
    public static List<String> O000000o(Context context) {
        ArrayList arrayList = new ArrayList();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (Build.VERSION.SDK_INT < 23) {
            String deviceId = telephonyManager.getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                arrayList.add(deviceId);
            } else {
                arrayList.add(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            int i = 1;
            int i2 = 1;
            while (true) {
                if (i2 >= 10) {
                    break;
                }
                arrayList.add(O000000o(telephonyManager, "getDeviceId", i2));
                i2++;
            }
        } else {
            try {
                int phoneCount = telephonyManager.getPhoneCount();
                for (int i3 = 0; i3 < phoneCount; i3++) {
                    arrayList.add(telephonyManager.getDeviceId(i3));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void O000000o(String str, String str2) {
        Log.d(str, "log: ".concat(String.valueOf(str2)));
    }

    public static double O00000Oo() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
            Matcher matcher = Pattern.compile("(\\d+)").matcher(randomAccessFile.readLine());
            String str = "";
            while (matcher.find()) {
                str = matcher.group(1);
            }
            randomAccessFile.close();
            return Double.parseDouble(str);
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    public static String O00000Oo(String str) {
        File file = new File("/proc/cpuinfo");
        if (!file.exists()) {
            return "NA";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split(":");
                    if (split.length > 1 && split[0].trim().equalsIgnoreCase(str.trim())) {
                        return split[1].trim();
                    }
                } else {
                    bufferedReader.close();
                    return "NA";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "NA";
        }
    }

    public static int O00000o() {
        File file = new File("/proc/cpuinfo");
        if (!file.exists()) {
            return 0;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split(":");
                    if (split.length > 1 && split[0].trim().equals("processor")) {
                        try {
                            Integer.parseInt(split[1].trim());
                            i++;
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    bufferedReader.close();
                    return i;
                }
            }
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static int O00000o0() {
        try {
            return Runtime.getRuntime().availableProcessors();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int O00000oO() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new O000000o()).length;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
