package cn.com.xm.bt.a;

import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f3074a = 2;
    public static int b = 2;
    private static int c = 0;
    private static boolean d = true;
    private static boolean e = true;
    private static boolean f = true;
    private static boolean g = true;
    private static File h;

    private static String c() {
        return "";
    }

    public static void a(boolean z) {
        c = z ? 0 : -1;
        d = z;
        e = z;
        f = z;
        g = z;
    }

    public static synchronized void a(File file) {
        synchronized (a.class) {
            h = file;
        }
    }

    public static void a(Object obj) {
        if (f && obj == null) {
            a("DEBUG", ">>> `NOT NULL` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void a(Thread thread) {
        if (f && thread != null && Thread.currentThread().getId() != thread.getId()) {
            a("DEBUG", ">>> `RUN ON THREAD` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void b(boolean z) {
        if (f && !z) {
            a("DEBUG", ">>> `TRUE` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void a(String str) {
        a("DEBUG", str, 0, 'd');
    }

    public static void b(String str) {
        if (g) {
            a("DEBUG", "LOCK#".concat(String.valueOf(str)), 0, 'v');
        }
    }

    public static void c(String str) {
        a("DEBUG", str, 0, 'e');
    }

    public static void a(String str, String str2) {
        int i = c;
        if (i >= 0 && i <= 0) {
            Log.i(str, c() + str2);
        }
        c(str, str2);
    }

    public static void b(String str, String str2) {
        int i = c;
        if (i >= 0 && i <= 0) {
            Log.i(str, c() + str2);
        }
    }

    public static void d(String str) {
        a("DEBUG", str, 0, 'i');
    }

    public static void a() {
        if (e) {
            a("DEBUG", "<<<<====", 0, 'v');
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
      ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        return;
     */
    private static synchronized void c(String str, String str2) {
        synchronized (a.class) {
            if (h != null && h.canWrite()) {
                try {
                    FileWriter fileWriter = new FileWriter(h, true);
                    fileWriter.write(b() + "  " + str + "  " + str2 + "\n");
                    fileWriter.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    private static String b() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public static void e(String str) {
        a("DEBUG", str, 0, 'w');
    }

    private static void a(String str, String str2, int i, char c2) {
        if (d) {
            String name = Thread.currentThread().getName();
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i + 4];
            String className = stackTraceElement.getClassName();
            String str3 = "[" + name + "]<" + className.substring(className.lastIndexOf(46) + 1) + ":" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "> ";
            if (c2 == 'd') {
                Log.d(str, str3 + str2 + "");
            } else if (c2 == 'e') {
                Log.e(str, str3 + str2 + "");
            } else if (c2 == 'i') {
                Log.i(str, str3 + str2 + "");
            } else if (c2 == 'v') {
                Log.v(str, str3 + str2 + "");
            } else if (c2 == 'w') {
                Log.w(str, str3 + str2 + "");
            }
        }
    }
}
