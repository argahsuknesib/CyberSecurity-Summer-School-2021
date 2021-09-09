package com.xiaomi.onetrack.a;

import android.os.Process;
import com.xiaomi.onetrack.CrashAnalysis;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.h.b;
import com.xiaomi.onetrack.h.l;
import com.xiaomi.onetrack.h.q;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.Date;
import java.util.Locale;

public class e implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler b;
    private final Date g = new Date();
    private int h = 50;
    private int i = 50;
    private int j = 200;
    private boolean k = true;
    private boolean l = true;

    public void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (!(defaultUncaughtExceptionHandler instanceof e)) {
            this.b = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        q.a("OneTrackExceptionHandler", "uncaughtException start");
        a(thread, th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098 A[SYNTHETIC, Splitter:B:26:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014b A[SYNTHETIC, Splitter:B:63:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0157 A[SYNTHETIC, Splitter:B:70:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    private void a(Thread thread, Throwable th) {
        File file;
        String str;
        String str2;
        Throwable th2;
        Date date = new Date();
        RandomAccessFile randomAccessFile = null;
        try {
            file = new File(String.format(Locale.US, "%s/%s_%020d_%s__%s%s", l.a(), "tombstone", Long.valueOf(this.g.getTime() * 1000), b.a(a.a()), b.a(a.a(), Process.myPid()), ".java.xcrash"));
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Exception e) {
                e = e;
                q.b("OneTrackExceptionHandler", "JavaCrashHandler createLogFile failed", e);
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.toString();
                str2 = a(date, thread, str);
                if (file == null) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
            q.b("OneTrackExceptionHandler", "JavaCrashHandler createLogFile failed", e);
            StringWriter stringWriter2 = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter2));
            str = stringWriter2.toString();
            str2 = a(date, thread, str);
            if (file == null) {
            }
        }
        try {
            StringWriter stringWriter22 = new StringWriter();
            try {
                th.printStackTrace(new PrintWriter(stringWriter22));
                str = stringWriter22.toString();
            } catch (Exception e3) {
                e = e3;
                str = null;
                q.b("OneTrackExceptionHandler", "JavaCrashHandler getEmergency failed", e);
                str2 = null;
                if (file == null) {
                }
            }
            try {
                str2 = a(date, thread, str);
            } catch (Exception e4) {
                e = e4;
                q.b("OneTrackExceptionHandler", "JavaCrashHandler getEmergency failed", e);
                str2 = null;
                if (file == null) {
                }
            }
        } catch (Exception e5) {
            e = e5;
            str = null;
            q.b("OneTrackExceptionHandler", "JavaCrashHandler getEmergency failed", e);
            str2 = null;
            if (file == null) {
            }
        }
        if (file == null) {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rws");
                try {
                    randomAccessFile2.write(("backtrace feature id:\n\t" + CrashAnalysis.calculateJavaDigest(str) + "\n\n").getBytes("UTF-8"));
                    randomAccessFile2.write(("error reason:\n\t" + th.toString() + "\n\n").getBytes("UTF-8"));
                    if (str2 != null) {
                        randomAccessFile2.write(str2.getBytes("UTF-8"));
                    }
                    if (this.j > 0 || this.h > 0 || this.i > 0) {
                        randomAccessFile2.write(b.a(this.j, this.h, this.i).getBytes("UTF-8"));
                    }
                    if (this.k) {
                        randomAccessFile2.write(b.f().getBytes("UTF-8"));
                    }
                    if (this.l) {
                        randomAccessFile2.write(b.e().getBytes("UTF-8"));
                    }
                    randomAccessFile2.write(b.d().getBytes("UTF-8"));
                    randomAccessFile2.write("foreground:\nyes\n\n".getBytes("UTF-8"));
                    try {
                        randomAccessFile2.close();
                    } catch (Exception e6) {
                        q.b("OneTrackExceptionHandler", "JavaCrashHandler close RandomAccessFile failed", e6);
                    }
                } catch (Exception e7) {
                    e = e7;
                    randomAccessFile = randomAccessFile2;
                    try {
                        q.b("OneTrackExceptionHandler", "JavaCrashHandler write log file failed", e);
                        if (randomAccessFile == null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e8) {
                                q.b("OneTrackExceptionHandler", "JavaCrashHandler close RandomAccessFile failed", e8);
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        randomAccessFile2 = randomAccessFile;
                        if (randomAccessFile2 != null) {
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Exception e9) {
                            q.b("OneTrackExceptionHandler", "JavaCrashHandler close RandomAccessFile failed", e9);
                        }
                    }
                    throw th2;
                }
            } catch (Exception e10) {
                e = e10;
                q.b("OneTrackExceptionHandler", "JavaCrashHandler write log file failed", e);
                if (randomAccessFile == null) {
                }
            }
        }
    }

    private String a(Date date, Thread thread, String str) {
        return b.a(this.g, date, "java", a.d(), b.a(a.a())) + "pid: " + Process.myPid() + ", tid: " + Process.myTid() + ", name: " + thread.getName() + "  >>> " + b.a(a.a(), Process.myPid()) + " <<<\n\njava stacktrace:\n" + str + "\n";
    }
}
