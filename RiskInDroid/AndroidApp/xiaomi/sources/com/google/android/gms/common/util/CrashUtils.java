package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Debug;
import android.os.DropBoxManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedList;

public final class CrashUtils {
    private static final String[] zzzc = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager zzzd = null;
    private static boolean zzze = false;
    private static boolean zzzf;
    private static boolean zzzg;
    private static int zzzh = -1;
    private static int zzzi = 0;
    private static int zzzj = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorDialogData {
    }

    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th) {
        return addErrorToDropBoxInternal(context, th, 536870912);
    }

    @Deprecated
    public static boolean addErrorToDropBox(Context context, Throwable th) {
        return addDynamiteErrorToDropBox(context, th);
    }

    public static boolean addErrorToDropBoxInternal(Context context, String str, String str2, int i) {
        return zza(context, str, str2, i, null);
    }

    public static boolean addErrorToDropBoxInternal(Context context, Throwable th, int i) {
        boolean z;
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
            if (!isPackageSide()) {
                return false;
            }
            if (zzdb() || (th = zza(th)) != null) {
                return zza(context, Log.getStackTraceString(th), ProcessUtils.getMyProcessName(), i, th);
            }
            return false;
        } catch (Exception e) {
            try {
                z = zzdb();
            } catch (Exception e2) {
                Log.e("CrashUtils", "Error determining which process we're running in!", e2);
                z = false;
            }
            if (!z) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e);
                return false;
            }
            throw e;
        }
    }

    private static boolean isPackageSide() {
        if (zzze) {
            return zzzf;
        }
        return false;
    }

    public static boolean isSystemClassPrefixInternal(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String startsWith : zzzc) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public static synchronized void setTestVariables(DropBoxManager dropBoxManager, boolean z, boolean z2, int i) {
        synchronized (CrashUtils.class) {
            zzze = true;
            zzzd = dropBoxManager;
            zzzg = z;
            zzzf = z2;
            zzzh = i;
            zzzi = 0;
            zzzj = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:41|42|43|44|45|46|47|48|49|50|51|52|53|(2:54|(1:56)(1:57))|58) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:63|(2:72|73)|74|75) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x014c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0153 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x0189 */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0166 A[Catch:{ IOException -> 0x0171, all -> 0x016e }, LOOP:0: B:54:0x0160->B:56:0x0166, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x016a A[EDGE_INSN: B:57:0x016a->B:58:? ?: BREAK  , SYNTHETIC, Splitter:B:57:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0180 A[SYNTHETIC, Splitter:B:69:0x0180] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0186 A[SYNTHETIC, Splitter:B:72:0x0186] */
    @VisibleForTesting
    private static synchronized String zza(Context context, String str, String str2, int i) {
        synchronized (CrashUtils.class) {
            StringBuilder sb = new StringBuilder(1024);
            sb.append("Process: ");
            sb.append(Strings.nullToEmpty(str2));
            sb.append("\n");
            sb.append("Package: com.google.android.gms");
            int i2 = 12451009;
            String str3 = "12.4.51 (020308-{{cl}})";
            if (zzdb()) {
                try {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0);
                    i2 = packageInfo.versionCode;
                    if (packageInfo.versionName != null) {
                        str3 = packageInfo.versionName;
                    }
                } catch (Exception e) {
                    Log.w("CrashUtils", "Error while trying to get the package information! Using static version.", e);
                }
            }
            sb.append(" v");
            sb.append(i2);
            if (!TextUtils.isEmpty(str3)) {
                if (str3.contains("(") && !str3.contains(")")) {
                    if (str3.endsWith("-")) {
                        str3 = String.valueOf(str3).concat("111111111");
                    }
                    str3 = String.valueOf(str3).concat(")");
                }
                sb.append(" (");
                sb.append(str3);
                sb.append(")");
            }
            sb.append("\n");
            sb.append("Build: ");
            sb.append(Build.FINGERPRINT);
            sb.append("\n");
            if (Debug.isDebuggerConnected()) {
                sb.append("Debugger: Connected\n");
            }
            if (i != 0) {
                sb.append("DD-EDD: ");
                sb.append(i);
                sb.append("\n");
            }
            sb.append("\n");
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            int i3 = zzdb() ? zzzh >= 0 ? zzzh : Settings.Secure.getInt(context.getContentResolver(), "logcat_for_system_app_crash", 0) : 0;
            if (i3 > 0) {
                sb.append("\n");
                InputStreamReader inputStreamReader = null;
                try {
                    Process start = new ProcessBuilder("/system/bin/logcat", "-v", "time", "-b", "events", "-b", "system", "-b", "main", "-b", "crash", "-t", String.valueOf(i3)).redirectErrorStream(true).start();
                    start.getOutputStream().close();
                    start.getErrorStream().close();
                    InputStreamReader inputStreamReader2 = new InputStreamReader(start.getInputStream());
                    try {
                        char[] cArr = new char[8192];
                        while (true) {
                            int read = inputStreamReader2.read(cArr);
                            if (read > 0) {
                                sb.append(cArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException unused) {
                                }
                            }
                        }
                        inputStreamReader2.close();
                    } catch (IOException e2) {
                        e = e2;
                        inputStreamReader = inputStreamReader2;
                        try {
                            Log.e("CrashUtils", "Error running logcat", e);
                            if (inputStreamReader != null) {
                            }
                            String sb2 = sb.toString();
                            return sb2;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = inputStreamReader2;
                        if (inputStreamReader != null) {
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    Log.e("CrashUtils", "Error running logcat", e);
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    String sb22 = sb.toString();
                    return sb22;
                }
            }
            String sb222 = sb.toString();
        }
        return sb222;
    }

    @VisibleForTesting
    private static synchronized Throwable zza(Throwable th) {
        synchronized (CrashUtils.class) {
            LinkedList linkedList = new LinkedList();
            while (th != null) {
                linkedList.push(th);
                th = th.getCause();
            }
            Throwable th2 = null;
            boolean z = false;
            while (!linkedList.isEmpty()) {
                Throwable th3 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th3.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                boolean z2 = z;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    String fileName = stackTraceElement.getFileName();
                    boolean z3 = !TextUtils.isEmpty(fileName) && fileName.startsWith(":com.google.android.gms");
                    z2 |= z3;
                    if (!z3 && !isSystemClassPrefixInternal(className)) {
                        stackTraceElement = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    }
                    arrayList.add(stackTraceElement);
                }
                th2 = th2 == null ? new Throwable("<filtered>") : new Throwable("<filtered>", th2);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                z = z2;
            }
            if (!z) {
                return null;
            }
            return th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0058, code lost:
        return false;
     */
    private static synchronized boolean zza(Context context, String str, String str2, int i, Throwable th) {
        synchronized (CrashUtils.class) {
            Preconditions.checkNotNull(context);
            if (isPackageSide()) {
                if (!Strings.isEmptyOrWhitespace(str)) {
                    int hashCode = str.hashCode();
                    int hashCode2 = th == null ? zzzj : th.hashCode();
                    if (zzzi == hashCode && zzzj == hashCode2) {
                        return false;
                    }
                    zzzi = hashCode;
                    zzzj = hashCode2;
                    DropBoxManager dropBoxManager = zzzd != null ? zzzd : (DropBoxManager) context.getSystemService("dropbox");
                    if (dropBoxManager != null) {
                        if (dropBoxManager.isTagEnabled("system_app_crash")) {
                            dropBoxManager.addText("system_app_crash", zza(context, str, str2, i));
                            return true;
                        }
                    }
                }
            }
        }
    }

    private static boolean zzdb() {
        if (zzze) {
            return zzzg;
        }
        return false;
    }
}
