package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import com.amap.location.common.log.LogConfig;
import java.io.File;
import java.io.FileFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public final class om {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile String f2356O000000o = "";
    public static volatile Handler O00000Oo = null;
    public static volatile File O00000o = null;
    public static volatile HandlerThread O00000o0 = null;
    public static final ArrayDeque<File> O00000oO = new ArrayDeque<>();
    public static volatile Context O00000oo = null;
    public static String O0000O0o = "";
    public static volatile boolean O0000OOo = false;
    private static volatile boolean O0000Oo = false;
    public static final Runnable O0000Oo0 = new Runnable() {
        /* class _m_j.om.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void
         arg types: [java.lang.String, java.lang.String, java.lang.Exception]
         candidates:
          _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void
          _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void */
        public final void run() {
            try {
                if (!om.O000000o()) {
                    om.O00000o0();
                    return;
                }
                File[] O00000Oo = om.O00000Oo(om.f2356O000000o);
                if (O00000Oo != null && O00000Oo.length > 0) {
                    synchronized (om.O00000oO) {
                        for (File offer : O00000Oo) {
                            om.O00000oO.offer(offer);
                        }
                    }
                }
                om.O0000O0o = on.O000000o(om.O00000oo);
                File O00000Oo2 = om.O00000Oo();
                om.O00000o = O00000Oo2;
                if (O00000Oo2 == null) {
                    om.O00000o0();
                    return;
                }
                om.O0000OOo = true;
                om.O00000Oo.sendMessageDelayed(om.O00000Oo.obtainMessage(2), 20000);
            } catch (Exception e) {
                om.O000000o("ALLog", "InitLogFileTask  error ", (Throwable) e);
            }
        }
    };
    private static volatile boolean O0000OoO = false;
    private static volatile boolean O0000Ooo = false;
    private static long O0000o = 1048576;
    private static boolean O0000o0 = true;
    private static boolean O0000o00 = false;
    private static LogConfig.Product O0000o0O = LogConfig.Product.SDK;
    private static String O0000o0o = "sdk";
    private static long O0000oO = 204800;
    private static long O0000oO0 = 20;
    private static final SimpleDateFormat O0000oOO = new SimpleDateFormat("MM-dd HH:mm:ss:SSS", Locale.US);
    private static final SimpleDateFormat O0000oOo = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS", Locale.US);
    private static LogConfig.O000000o O0000oo;
    private static final Date O0000oo0 = new Date();
    private static long O0000ooO;
    private static volatile LinkedList<String> O0000ooo = new LinkedList<>();
    private static String O000O00o = "";
    private static LinkedList<LinkedList<String>> O00oOooO = new LinkedList<>();
    private static final Object O00oOooo = new Object();

    public static String O000000o(String str) {
        return "@@_" + oz.O000000o(str) + "_@@";
    }

    private static String O000000o(DateFormat dateFormat) {
        String format;
        synchronized (O0000oo0) {
            O0000oo0.setTime(System.currentTimeMillis());
            format = dateFormat.format(O0000oo0);
        }
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private static void O000000o(int i, String str, String str2, boolean z, boolean z2) {
        String str3;
        LogConfig.O000000o o000000o;
        boolean z3 = z && O0000OoO && O0000OOo;
        boolean z4 = z2 && O0000Ooo && (o000000o = O0000oo) != null && o000000o.O000000o();
        if (z3 || z4) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(System.currentTimeMillis()));
            sb.append("|");
            if (i == 1) {
                str3 = "info|";
            } else if (i != 2) {
                if (i == 4) {
                    str3 = "error|";
                }
                long myTid = (long) Process.myTid();
                sb.append(O000O00o);
                sb.append("|");
                sb.append(String.valueOf(myTid));
                sb.append("|");
                sb.append(str);
                sb.append("|");
                sb.append(str2);
                sb.append("\n");
                if (z3) {
                    O00000o0(sb.toString());
                }
                if (!z4) {
                    sb.substring(0, sb.length() - 1);
                    return;
                }
                return;
            } else {
                str3 = "warn|";
            }
            sb.append(str3);
            long myTid2 = (long) Process.myTid();
            sb.append(O000O00o);
            sb.append("|");
            sb.append(String.valueOf(myTid2));
            sb.append("|");
            sb.append(str);
            sb.append("|");
            sb.append(str2);
            sb.append("\n");
            if (z3) {
            }
            if (!z4) {
            }
        }
    }

    public static void O000000o(String str, String str2) {
        if (O0000Oo) {
            gsy.O000000o(4, str, str2);
        }
    }

    public static void O000000o(String str, String str2, Throwable th) {
        if (O0000Oo) {
            Log.e(str, str2, th);
        }
    }

    public static boolean O000000o() {
        File file = new File(f2356O000000o);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        boolean exists = file.exists();
        if (!exists) {
            exists = file.mkdirs();
        }
        if (!exists || !file.canWrite()) {
            return false;
        }
        File file2 = new File(file, ok.O00000oO());
        if (!file2.exists() && !file2.mkdir()) {
            return true;
        }
        f2356O000000o = file2.getAbsolutePath();
        return true;
    }

    public static void O00000Oo(String str, String str2) {
        if (O00000o()) {
            O000000o("trace_".concat(String.valueOf(str)), str2, O0000o00, O0000o0);
        }
    }

    public static void O00000Oo(String str, String str2, Throwable th) {
        O000000o(str, str2, th);
        O000000o(4, str, str2 + Log.getStackTraceString(th), true, false);
    }

    public static File[] O00000Oo(String str) {
        File[] listFiles = new File(str).listFiles(new FileFilter() {
            /* class _m_j.om.AnonymousClass2 */

            public final boolean accept(File file) {
                return !file.isDirectory();
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        Arrays.sort(listFiles, new Comparator<File>() {
            /* class _m_j.om.AnonymousClass3 */

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                long lastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
                if (lastModified > 0) {
                    return 1;
                }
                return lastModified < 0 ? -1 : 0;
            }
        });
        return listFiles;
    }

    private static boolean O00000o() {
        try {
            return O0000Ooo && O0000oo != null && O0000oo.O000000o();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void
     arg types: [java.lang.String, java.lang.String, java.lang.Exception]
     candidates:
      _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void
      _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void */
    public static void O00000o0() {
        O0000OOo = false;
        try {
            if (O00000o0 != null) {
                if (Build.VERSION.SDK_INT > 18) {
                    O00000o0.quitSafely();
                } else {
                    O00000o0.quit();
                }
            }
            O00000Oo = null;
            O00000o0 = null;
            synchronized (O00000oO) {
                O00000oO.clear();
            }
            synchronized (O00oOooo) {
                O0000ooo.clear();
                O00oOooO.clear();
            }
        } catch (Exception e) {
            try {
                O000000o("ALLog", "dispose error ", (Throwable) e);
                O00000Oo = null;
                O00000o0 = null;
                synchronized (O00000oO) {
                    O00000oO.clear();
                    synchronized (O00oOooo) {
                        O0000ooo.clear();
                        O00oOooO.clear();
                    }
                }
            } catch (Throwable th) {
                O00000Oo = null;
                O00000o0 = null;
                synchronized (O00000oO) {
                    O00000oO.clear();
                    synchronized (O00oOooo) {
                        O0000ooo.clear();
                        O00oOooO.clear();
                        throw th;
                    }
                }
            }
        }
    }

    private static void O00000o0(String str) {
        synchronized (O00oOooo) {
            O0000ooo.add(str);
            O0000ooO += (long) str.length();
            if (((long) O0000ooo.size()) >= 5000 || O0000ooO > O0000oO) {
                if (O00000Oo != null) {
                    O00oOooO.add(O0000ooo);
                    while (((long) O00oOooO.size()) > 5) {
                        O00oOooO.removeFirst();
                    }
                    O00000Oo.obtainMessage(1).sendToTarget();
                    O00000Oo.removeMessages(2);
                    O0000ooo = new LinkedList<>();
                } else {
                    O0000ooo.clear();
                }
                O0000ooO = 0;
            }
        }
    }

    public static void O000000o(String str, String str2, boolean z, boolean z2) {
        if (O0000Oo) {
            gsy.O000000o(5, str, str2);
        }
        O000000o(2, str, str2, z, z2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void
     arg types: [java.lang.String, java.lang.String, java.lang.Exception]
     candidates:
      _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void
      _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void */
    public static void O000000o(String str, String str2, Exception exc) {
        if (O00000o()) {
            String concat = "trace_".concat(String.valueOf(str));
            boolean z = O0000o00;
            boolean z2 = O0000o0;
            O000000o(concat, str2, (Throwable) exc);
            O000000o(4, concat, str2 + Log.getStackTraceString(exc), z, z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r1 = _m_j.om.f2356O000000o;
        r0 = new java.io.File(r1, _m_j.om.O0000o0o + "_log_" + O000000o(_m_j.om.O0000oOo) + ".txt");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        if (android.text.TextUtils.isEmpty(_m_j.om.O0000O0o) != false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        _m_j.oy.O000000o(_m_j.om.O0000O0o + "\r\n-------------------\r\n", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        return null;
     */
    public static File O00000Oo() {
        synchronized (O00000oO) {
            File last = O00000oO.size() > 0 ? O00000oO.getLast() : null;
            if (last != null && last.length() < (O0000o * 2) / 3) {
                O00000oO.removeLast();
                return last;
            }
        }
    }
}
