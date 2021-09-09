package _m_j;

import android.annotation.SuppressLint;
import android.os.Process;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import xcrash.NativeHandler;
import xcrash.XCrash;

@SuppressLint({"StaticFieldLeak"})
public final class jrt implements Thread.UncaughtExceptionHandler {
    private static final jrt O0000o = new jrt();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2115O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public boolean O00000oO;
    public String O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public boolean O0000Oo;
    public int O0000Oo0;
    public boolean O0000OoO;
    public boolean O0000Ooo;
    public String[] O0000o0;
    public int O0000o00;
    public jrq O0000o0O;
    public Thread.UncaughtExceptionHandler O0000o0o = null;
    private final Date O0000oO0 = new Date();

    private jrt() {
    }

    public static jrt O000000o() {
        return O0000o;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:82:0x01e1 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fe A[SYNTHETIC, Splitter:B:40:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01d8 A[SYNTHETIC, Splitter:B:77:0x01d8] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01de A[SYNTHETIC, Splitter:B:80:0x01de] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0204  */
    public final void uncaughtException(Thread thread, Throwable th) {
        jrn O000000o2;
        File file;
        String str;
        String str2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.O0000o0o;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        try {
            Date date = new Date();
            NativeHandler O000000o3 = NativeHandler.O000000o();
            if (O000000o3.O00000Oo && O000000o3.f15499O000000o) {
                NativeHandler.nativeNotifyJavaCrashed();
            }
            O000000o2 = jrn.O000000o();
            RandomAccessFile randomAccessFile = null;
            if (O000000o2.O0000o0o != null) {
                try {
                    O000000o2.O0000o0o.stopWatching();
                } catch (Exception e) {
                    XCrash.O000000o().O00000o0("xcrash", "AnrHandler fileObserver stopWatching failed", e);
                }
                O000000o2.O0000o0o = null;
            }
            try {
                file = jrp.O000000o().O000000o(String.format(Locale.US, "%s/%s_%020d_%s__%s%s", this.O00000oo, "tombstone", Long.valueOf(this.O0000oO0.getTime() * 1000), this.O00000o, this.O00000Oo, ".java.xcrash"));
            } catch (Exception e2) {
                XCrash.O000000o().O00000o0("xcrash", "JavaCrashHandler createLogFile failed", e2);
                file = null;
            }
            try {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.toString();
                try {
                    str2 = jrv.O000000o(this.O0000oO0, date, "java", this.O00000o0, this.O00000o) + "pid: " + this.f2115O000000o + ", tid: " + Process.myTid() + ", name: " + thread.getName() + "  >>> " + this.O00000Oo + " <<<\n\njava stacktrace:\n" + str + "\n";
                } catch (Exception e3) {
                    e = e3;
                    XCrash.O000000o().O00000o0("xcrash", "JavaCrashHandler getEmergency failed", e);
                    str2 = null;
                    if (file != null) {
                    }
                    try {
                        file.getAbsolutePath();
                    } catch (Exception unused) {
                    }
                    if (this.O00000oO) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                str = null;
                XCrash.O000000o().O00000o0("xcrash", "JavaCrashHandler getEmergency failed", e);
                str2 = null;
                if (file != null) {
                }
                file.getAbsolutePath();
                if (this.O00000oO) {
                }
            }
            if (file != null) {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rws");
                    try {
                        randomAccessFile2.write(("backtrace feature id:\n\t" + dvs.O000000o(str) + "\n\n").getBytes("UTF-8"));
                        randomAccessFile2.write(("error reason:\n\t" + th.toString() + "\n\n").getBytes("UTF-8"));
                        if (str2 != null) {
                            randomAccessFile2.write(str2.getBytes("UTF-8"));
                        }
                        if (this.O0000Oo0 > 0 || this.O0000O0o > 0 || this.O0000OOo > 0) {
                            randomAccessFile2.write(jrv.O000000o(this.O0000Oo0, this.O0000O0o, this.O0000OOo).getBytes("UTF-8"));
                        }
                        if (this.O0000Oo) {
                            randomAccessFile2.write(jrv.O00000oO().getBytes("UTF-8"));
                        }
                        if (this.O0000OoO) {
                            randomAccessFile2.write(jrv.O00000o().getBytes("UTF-8"));
                        }
                        randomAccessFile2.write(jrv.O00000o0().getBytes("UTF-8"));
                        StringBuilder sb = new StringBuilder("foreground:\n");
                        sb.append(jrm.O000000o().O00000Oo ? "yes" : "no");
                        sb.append("\n\n");
                        randomAccessFile2.write(sb.toString().getBytes("UTF-8"));
                        if (this.O0000Ooo) {
                            randomAccessFile2.write(O000000o(thread).getBytes("UTF-8"));
                        }
                    } catch (Exception e5) {
                        e = e5;
                        randomAccessFile = randomAccessFile2;
                        try {
                            XCrash.O000000o().O00000o0("xcrash", "JavaCrashHandler write log file failed", e);
                            if (randomAccessFile != null) {
                            }
                            file.getAbsolutePath();
                            if (this.O00000oO) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (randomAccessFile2 != null) {
                        }
                        throw th;
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused2) {
                    }
                } catch (Exception e6) {
                    e = e6;
                    XCrash.O000000o().O00000o0("xcrash", "JavaCrashHandler write log file failed", e);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    file.getAbsolutePath();
                    if (this.O00000oO) {
                    }
                }
            }
            if (!(this.O0000o0O == null || file == null)) {
                file.getAbsolutePath();
            }
        } catch (Exception e7) {
            XCrash.O000000o().O00000o0("xcrash", "JavaCrashHandler handleException failed", e7);
        } catch (Throwable th4) {
            O000000o2.O0000o0o = null;
            throw th4;
        }
        if (this.O00000oO) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.O0000o0o;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
                return;
            }
            return;
        }
        jrm.O000000o().O00000Oo();
        Process.killProcess(this.f2115O000000o);
        System.exit(10);
    }

    private String O000000o(Thread thread) {
        ArrayList arrayList;
        if (this.O0000o0 != null) {
            arrayList = new ArrayList();
            for (String compile : this.O0000o0) {
                try {
                    arrayList.add(Pattern.compile(compile));
                } catch (Exception e) {
                    XCrash.O000000o().O00000Oo("xcrash", "JavaCrashHandler pattern compile failed", e);
                }
            }
        } else {
            arrayList = null;
        }
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (Map.Entry next : allStackTraces.entrySet()) {
            Thread thread2 = (Thread) next.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
            if (!thread2.getName().equals(thread.getName()) && (arrayList == null || O000000o(arrayList, thread2.getName()))) {
                i2++;
                int i4 = this.O0000o00;
                if (i4 <= 0 || i < i4) {
                    sb.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                    sb.append("pid: ");
                    sb.append(this.f2115O000000o);
                    sb.append(", tid: ");
                    sb.append(thread2.getId());
                    sb.append(", name: ");
                    sb.append(thread2.getName());
                    sb.append("  >>> ");
                    sb.append(this.O00000Oo);
                    sb.append(" <<<\n");
                    sb.append("\n");
                    sb.append("java stacktrace:\n");
                    for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                        sb.append("    at ");
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                    sb.append("\n");
                    i++;
                } else {
                    i3++;
                }
            }
        }
        if (allStackTraces.size() > 1) {
            if (i == 0) {
                sb.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            }
            sb.append("total JVM threads (exclude the crashed thread): ");
            sb.append(allStackTraces.size() - 1);
            sb.append("\n");
            if (arrayList != null) {
                sb.append("JVM threads matched whitelist: ");
                sb.append(i2);
                sb.append("\n");
            }
            if (this.O0000o00 > 0) {
                sb.append("JVM threads ignored by max count limit: ");
                sb.append(i3);
                sb.append("\n");
            }
            sb.append("dumped JVM threads:");
            sb.append(i);
            sb.append("\n");
            sb.append("+++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++\n");
        }
        return sb.toString();
    }

    private static boolean O000000o(ArrayList<Pattern> arrayList, String str) {
        Iterator<Pattern> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }
}
