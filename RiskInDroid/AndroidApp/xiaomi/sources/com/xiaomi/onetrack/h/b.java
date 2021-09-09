package com.xiaomi.onetrack.h;

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
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class b {
    private static final String[] m = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};

    private b() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0075, code lost:
        if (r0 != null) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070 A[SYNTHETIC, Splitter:B:34:0x0070] */
    public static String a(Context context, int i) {
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

    static boolean a() {
        try {
            for (String file : m) {
                if (new File(file).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    static String b() {
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

    public static String a(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    static String c() {
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
            q.b("CrashUtil", "CrashUtil getProcessMemoryInfo failed", e);
        }
        return sb.toString();
    }

    private static String a(String str) {
        return a(str, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d A[SYNTHETIC, Splitter:B:28:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077 A[SYNTHETIC, Splitter:B:34:0x0077] */
    private static String a(String str, int i) {
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
                        q.c("CrashUtil", "CrashUtil getInfo(" + str + ") failed", e);
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
            q.c("CrashUtil", "CrashUtil getInfo(" + str + ") failed", e);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return sb.toString();
        }
        return sb.toString();
    }

    public static String a(Date date, Date date2, String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        StringBuilder sb = new StringBuilder("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\nTombstone maker: 'OneTrack 1.1.5'\nCrash type: '");
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
        sb.append(a() ? "Yes" : "No");
        sb.append("'\nAPI level: '");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("'\nOS version: '");
        sb.append(Build.VERSION.RELEASE);
        sb.append("'\nABI list: '");
        sb.append(b());
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

    public static String d() {
        return "memory info:\n System Summary (From: /proc/meminfo)\n" + a("/proc/meminfo") + "-\n Process Status (From: /proc/PID/status)\n" + a("/proc/self/status") + "-\n Process Limits (From: /proc/PID/limits)\n" + a("/proc/self/limits") + "-\n" + c() + "\n";
    }

    public static String e() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "network info:\nNot supported on Android Q (API level 29) and later.\n\n";
        }
        return "network info:\n TCP over IPv4 (From: /proc/PID/net/tcp)\n" + a("/proc/self/net/tcp", 1024) + "-\n TCP over IPv6 (From: /proc/PID/net/tcp6)\n" + a("/proc/self/net/tcp6", 1024) + "-\n UDP over IPv4 (From: /proc/PID/net/udp)\n" + a("/proc/self/net/udp", 1024) + "-\n UDP over IPv6 (From: /proc/PID/net/udp6)\n" + a("/proc/self/net/udp6", 1024) + "-\n ICMP in IPv4 (From: /proc/PID/net/icmp)\n" + a("/proc/self/net/icmp", 256) + "-\n ICMP in IPv6 (From: /proc/PID/net/icmp6)\n" + a("/proc/self/net/icmp6", 256) + "-\n UNIX domain (From: /proc/PID/net/unix)\n" + a("/proc/self/net/unix", 256) + "\n";
    }

    public static String f() {
        StringBuilder sb = new StringBuilder("open files:\n");
        try {
            File[] listFiles = new File("/proc/self/fd").listFiles(new c());
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
     method: com.xiaomi.onetrack.h.b.a(int, java.lang.StringBuilder, java.lang.String, int, char):void
     arg types: [int, java.lang.StringBuilder, java.lang.String, int, int]
     candidates:
      com.xiaomi.onetrack.h.b.a(java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      com.xiaomi.onetrack.h.b.a(int, java.lang.StringBuilder, java.lang.String, int, char):void */
    public static String a(int i, int i2, int i3) {
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("logcat:\n");
        if (i > 0) {
            a(myPid, sb, "main", i, 'D');
        }
        if (i2 > 0) {
            a(myPid, sb, "system", i2, 'W');
        }
        if (i3 > 0) {
            a(myPid, sb, "events", i2, 'I');
        }
        sb.append("\n");
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00dc A[SYNTHETIC, Splitter:B:33:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e2 A[SYNTHETIC, Splitter:B:37:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    private static void a(int i, StringBuilder sb, String str, int i2, char c) {
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
                        q.b("CrashUtil", "CrashUtil run logcat command failed", e);
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
            q.b("CrashUtil", "CrashUtil run logcat command failed", e);
            if (bufferedReader == null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
            }
        }
    }
}
