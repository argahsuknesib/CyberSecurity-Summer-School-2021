package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import xcrash.XCrash;

public final class jrv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f2116O000000o = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0075, code lost:
        if (r0 != null) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070 A[SYNTHETIC, Splitter:B:34:0x0070] */
    public static String O000000o(Context context, int i) {
        BufferedReader bufferedReader;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next.pid == i && !TextUtils.isEmpty(next.processName)) {
                        return next.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    String trim = readLine.trim();
                    if (!TextUtils.isEmpty(trim)) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                        return trim;
                    }
                }
            } catch (Exception unused3) {
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        try {
            bufferedReader.close();
        } catch (Exception unused6) {
        }
        return null;
    }

    private static boolean O00000oo() {
        try {
            for (String file : f2116O000000o) {
                if (new File(file).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String O000000o() {
        if (Build.VERSION.SDK_INT >= 21) {
            return TextUtils.join(",", Build.SUPPORTED_ABIS);
        }
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "," + str2;
    }

    public static String O000000o(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    public static String O00000Oo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Process Summary (From: android.os.Debug.MemoryInfo)\n");
        sb.append(String.format(Locale.US, "%21s %8s\n", "", "Pss(KB)"));
        sb.append(String.format(Locale.US, "%21s %8s\n", "", "------"));
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            if (Build.VERSION.SDK_INT >= 23) {
                sb.append(String.format(Locale.US, "%21s %8s\n", "Java Heap:", memoryInfo.getMemoryStat("summary.java-heap")));
                sb.append(String.format(Locale.US, "%21s %8s\n", "Native Heap:", memoryInfo.getMemoryStat("summary.native-heap")));
                sb.append(String.format(Locale.US, "%21s %8s\n", "Code:", memoryInfo.getMemoryStat("summary.code")));
                sb.append(String.format(Locale.US, "%21s %8s\n", "Stack:", memoryInfo.getMemoryStat("summary.stack")));
                sb.append(String.format(Locale.US, "%21s %8s\n", "Graphics:", memoryInfo.getMemoryStat("summary.graphics")));
                sb.append(String.format(Locale.US, "%21s %8s\n", "Private Other:", memoryInfo.getMemoryStat("summary.private-other")));
                sb.append(String.format(Locale.US, "%21s %8s\n", "System:", memoryInfo.getMemoryStat("summary.system")));
                sb.append(String.format(Locale.US, "%21s %8s %21s %8s\n", "TOTAL:", memoryInfo.getMemoryStat("summary.total-pss"), "TOTAL SWAP:", memoryInfo.getMemoryStat("summary.total-swap")));
            } else {
                Locale locale = Locale.US;
                sb.append(String.format(locale, "%21s %8s\n", "Java Heap:", "~ " + memoryInfo.dalvikPrivateDirty));
                sb.append(String.format(Locale.US, "%21s %8s\n", "Native Heap:", String.valueOf(memoryInfo.nativePrivateDirty)));
                Locale locale2 = Locale.US;
                sb.append(String.format(locale2, "%21s %8s\n", "Private Other:", "~ " + memoryInfo.otherPrivateDirty));
                if (Build.VERSION.SDK_INT >= 19) {
                    sb.append(String.format(Locale.US, "%21s %8s\n", "System:", String.valueOf((memoryInfo.getTotalPss() - memoryInfo.getTotalPrivateDirty()) - memoryInfo.getTotalPrivateClean())));
                } else {
                    Locale locale3 = Locale.US;
                    sb.append(String.format(locale3, "%21s %8s\n", "System:", "~ " + (memoryInfo.getTotalPss() - memoryInfo.getTotalPrivateDirty())));
                }
                sb.append(String.format(Locale.US, "%21s %8s\n", "TOTAL:", String.valueOf(memoryInfo.getTotalPss())));
            }
        } catch (Exception e) {
            XCrash.O000000o().O000000o("xcrash", "Util getProcessMemoryInfo failed", e);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A[SYNTHETIC, Splitter:B:27:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b A[SYNTHETIC, Splitter:B:33:0x007b] */
    private static String O000000o(String str, int i) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            int i2 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String trim = readLine.trim();
                    if (trim.length() > 0) {
                        i2++;
                        if (i == 0 || i2 <= i) {
                            sb.append("  ");
                            sb.append(trim);
                            sb.append("\n");
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        jrs O000000o2 = XCrash.O000000o();
                        O000000o2.O000000o("xcrash", "Util getInfo(" + str + ") failed", e);
                        if (bufferedReader != null) {
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            if (i > 0 && i2 > i) {
                sb.append("  ......\n  (number of records: ");
                sb.append(i2);
                sb.append(")\n");
            }
            try {
                bufferedReader2.close();
            } catch (Exception unused2) {
            }
        } catch (Exception e2) {
            e = e2;
            jrs O000000o22 = XCrash.O000000o();
            O000000o22.O000000o("xcrash", "Util getInfo(" + str + ") failed", e);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return sb.toString();
        }
        return sb.toString();
    }

    static boolean O000000o(String str) {
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.isDirectory();
            }
            file.mkdirs();
            if (!file.exists() || !file.isDirectory()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean O000000o(Context context, long j) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        int myPid = Process.myPid();
        long j2 = j / 500;
        for (int i = 0; ((long) i) < j2; i++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo next : processesInErrorState) {
                    if (next.pid == myPid && next.condition == 2) {
                        return true;
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    static String O000000o(Date date, Date date2, String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        StringBuilder sb = new StringBuilder("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\nTombstone maker: 'xCrash 2.4.9'\nCrash type: '");
        sb.append(str);
        sb.append("'\nStart time: '");
        sb.append(simpleDateFormat.format(date));
        sb.append("'\nCrash time: '");
        sb.append(simpleDateFormat.format(date2));
        sb.append("'\nApp ID: '");
        sb.append(str2);
        sb.append("'\nApp version: '");
        sb.append(str3);
        sb.append("'\nRooted: '");
        sb.append(O00000oo() ? "Yes" : "No");
        sb.append("'\nAPI level: '");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("'\nOS version: '");
        sb.append(Build.VERSION.RELEASE);
        sb.append("'\nABI list: '");
        sb.append(O000000o());
        sb.append("'\nManufacturer: '");
        sb.append(Build.MANUFACTURER);
        sb.append("'\nBrand: '");
        sb.append(Build.BRAND);
        sb.append("'\nModel: '");
        sb.append(Build.MODEL);
        sb.append("'\nBuild fingerprint: '");
        sb.append(Build.FINGERPRINT);
        sb.append("'\n");
        return sb.toString();
    }

    static String O00000o0() {
        return "memory info:\n System Summary (From: /proc/meminfo)\n" + O000000o("/proc/meminfo", 0) + "-\n Process Status (From: /proc/PID/status)\n" + O000000o("/proc/self/status", 0) + "-\n Process Limits (From: /proc/PID/limits)\n" + O000000o("/proc/self/limits", 0) + "-\n" + O00000Oo() + "\n";
    }

    static String O00000o() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "network info:\nNot supported on Android Q (API level 29) and later.\n\n";
        }
        return "network info:\n TCP over IPv4 (From: /proc/PID/net/tcp)\n" + O000000o("/proc/self/net/tcp", 1024) + "-\n TCP over IPv6 (From: /proc/PID/net/tcp6)\n" + O000000o("/proc/self/net/tcp6", 1024) + "-\n UDP over IPv4 (From: /proc/PID/net/udp)\n" + O000000o("/proc/self/net/udp", 1024) + "-\n UDP over IPv6 (From: /proc/PID/net/udp6)\n" + O000000o("/proc/self/net/udp6", 1024) + "-\n ICMP in IPv4 (From: /proc/PID/net/icmp)\n" + O000000o("/proc/self/net/icmp", 256) + "-\n ICMP in IPv6 (From: /proc/PID/net/icmp6)\n" + O000000o("/proc/self/net/icmp6", 256) + "-\n UNIX domain (From: /proc/PID/net/unix)\n" + O000000o("/proc/self/net/unix", 256) + "\n";
    }

    static String O00000oO() {
        StringBuilder sb = new StringBuilder("open files:\n");
        try {
            File[] listFiles = new File("/proc/self/fd").listFiles(new FilenameFilter() {
                /* class _m_j.jrv.AnonymousClass1 */

                public final boolean accept(File file, String str) {
                    return TextUtils.isDigitsOnly(str);
                }
            });
            if (listFiles != null) {
                int i = 0;
                for (File file : listFiles) {
                    String str = null;
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            str = Os.readlink(file.getAbsolutePath());
                        } else {
                            str = file.getCanonicalPath();
                        }
                    } catch (Exception unused) {
                    }
                    sb.append("    fd ");
                    sb.append(file.getName());
                    sb.append(": ");
                    sb.append(TextUtils.isEmpty(str) ? "???" : str.trim());
                    sb.append(10);
                    i++;
                    if (i > 1024) {
                        break;
                    }
                }
                if (listFiles.length > 1024) {
                    sb.append("    ......\n");
                }
                sb.append("    (number of FDs: ");
                sb.append(listFiles.length);
                sb.append(")\n");
            }
        } catch (Exception unused2) {
        }
        sb.append(10);
        return sb.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jrv.O000000o(int, java.lang.StringBuilder, java.lang.String, int, char):void
     arg types: [int, java.lang.StringBuilder, java.lang.String, int, int]
     candidates:
      _m_j.jrv.O000000o(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.jrv.O000000o(int, java.lang.StringBuilder, java.lang.String, int, char):void */
    static String O000000o(int i, int i2, int i3) {
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("logcat:\n");
        if (i > 0) {
            O000000o(myPid, sb, "main", i, 'D');
        }
        if (i2 > 0) {
            O000000o(myPid, sb, "system", i2, 'W');
        }
        if (i3 > 0) {
            O000000o(myPid, sb, "events", i2, 'I');
        }
        sb.append("\n");
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e0 A[SYNTHETIC, Splitter:B:32:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6 A[SYNTHETIC, Splitter:B:36:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    private static void O000000o(int i, StringBuilder sb, String str, int i2, char c) {
        boolean z = Build.VERSION.SDK_INT >= 24;
        String num = Integer.toString(i);
        String str2 = " " + num + " ";
        ArrayList arrayList = new ArrayList();
        arrayList.add("/system/bin/logcat");
        arrayList.add("-b");
        arrayList.add(str);
        arrayList.add("-d");
        arrayList.add("-v");
        arrayList.add("threadtime");
        arrayList.add("-t");
        if (!z) {
            double d = (double) i2;
            Double.isNaN(d);
            i2 = (int) (d * 1.2d);
        }
        arrayList.add(Integer.toString(i2));
        if (z) {
            arrayList.add("--pid");
            arrayList.add(num);
        }
        arrayList.add("*:".concat(String.valueOf(c)));
        Object[] array = arrayList.toArray();
        sb.append("--------- tail end of log ");
        sb.append(str);
        sb.append(" (");
        sb.append(TextUtils.join(" ", array));
        sb.append(")\n");
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[0]).command(arrayList).start().getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    } else if (z || readLine.contains(str2)) {
                        sb.append(readLine);
                        sb.append("\n");
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        XCrash.O000000o().O00000Oo("xcrash", "Util run logcat command failed", e);
                        if (bufferedReader == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
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
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            XCrash.O000000o().O00000Oo("xcrash", "Util run logcat command failed", e);
            if (bufferedReader == null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
            }
        }
    }
}
