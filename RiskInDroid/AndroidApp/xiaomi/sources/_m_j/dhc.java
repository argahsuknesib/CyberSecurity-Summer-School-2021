package _m_j;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.lang.Thread;
import java.util.HashMap;

public final class dhc implements Thread.UncaughtExceptionHandler {
    private static String O0000OOo;
    private static final Object O0000Oo0 = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f14636O000000o;
    private dgz O00000Oo;
    private dgs O00000o;
    private dgu O00000o0;
    private Thread.UncaughtExceptionHandler O00000oO;
    private Thread.UncaughtExceptionHandler O00000oo;
    private boolean O0000O0o = false;
    private int O0000Oo;

    public dhc(Context context, dgz dgz, dgu dgu, dgs dgs) {
        this.f14636O000000o = context;
        this.O00000Oo = dgz;
        this.O00000o0 = dgu;
        this.O00000o = dgs;
    }

    public final synchronized void O000000o() {
        if (this.O0000Oo >= 10) {
            did.O000000o("java crash handler over %d, no need set.", 10);
            return;
        }
        this.O0000O0o = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (!getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    did.O000000o("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.O00000oo = defaultUncaughtExceptionHandler;
                    this.O00000oO = defaultUncaughtExceptionHandler;
                } else {
                    did.O000000o("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.O00000oO = defaultUncaughtExceptionHandler;
                }
            } else {
                return;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.O0000Oo++;
        did.O000000o("registered java monitor: %s", toString());
    }

    public final synchronized void O00000Oo() {
        this.O0000O0o = false;
        did.O000000o("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            did.O000000o("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.O00000oO);
            this.O0000Oo--;
        }
    }

    private CrashDetailBean O00000Oo(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String str2;
        String str3;
        boolean z2 = false;
        if (th == null) {
            did.O00000o("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean O00000o02 = dha.O000000o().O00000o0();
        String str4 = (!O00000o02 || !z) ? "" : " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
        if (O00000o02 && z) {
            did.O00000oO("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.O000O00o = dgt.O0000OOo();
        crashDetailBean.O000O0OO = dgt.O00000oo();
        crashDetailBean.O000O0Oo = dgt.O0000Oo();
        crashDetailBean.O00oOoOo = this.O00000o.O0000o00();
        crashDetailBean.O000O0o0 = this.O00000o.O0000Ooo();
        crashDetailBean.O000O0o = this.O00000o.O0000o0();
        crashDetailBean.O0000oo = dif.O000000o(this.f14636O000000o, dha.O00000oO);
        crashDetailBean.O0000ooO = die.O000000o();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.O0000ooO == null ? 0 : crashDetailBean.O0000ooO.length);
        did.O000000o("user log size:%d", objArr);
        crashDetailBean.O00000Oo = z ? 0 : 2;
        crashDetailBean.O00000oO = this.O00000o.O00000oO();
        crashDetailBean.O00000oo = this.O00000o.O0000o0;
        crashDetailBean.O0000O0o = this.O00000o.O0000oOO();
        crashDetailBean.O0000o00 = this.O00000o.O00000o();
        String name = th.getClass().getName();
        String O000000o2 = O000000o(th);
        if (O000000o2 == null) {
            O000000o2 = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        did.O00000oO("stack frame :%d, has cause %b", objArr2);
        if (th.getStackTrace().length > 0) {
            str2 = th.getStackTrace()[0].toString();
        } else {
            str2 = "";
        }
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 == null || th2 == th) {
            crashDetailBean.O0000o0 = name;
            crashDetailBean.O0000o0O = O000000o2 + str4;
            if (crashDetailBean.O0000o0O == null) {
                crashDetailBean.O0000o0O = "";
            }
            crashDetailBean.O0000o0o = str2;
            str3 = O000000o(th, dha.O00000oo);
            crashDetailBean.O0000o = str3;
        } else {
            crashDetailBean.O0000o0 = th2.getClass().getName();
            crashDetailBean.O0000o0O = O000000o(th2);
            if (crashDetailBean.O0000o0O == null) {
                crashDetailBean.O0000o0O = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.O0000o0o = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(O000000o2);
            sb.append("\n");
            sb.append(str2);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.O0000o0);
            sb.append(":");
            sb.append(crashDetailBean.O0000o0O);
            sb.append("\n");
            str3 = O000000o(th2, dha.O00000oo);
            sb.append(str3);
            crashDetailBean.O0000o = sb.toString();
        }
        crashDetailBean.O0000oO0 = System.currentTimeMillis();
        crashDetailBean.O0000oOo = dif.O00000o(crashDetailBean.O0000o.getBytes());
        try {
            crashDetailBean.O0000ooo = dif.O000000o(dha.O00000oo);
            crashDetailBean.O00oOooO = this.O00000o.O00000oo;
            crashDetailBean.O00oOooo = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.O0000ooo.put(crashDetailBean.O00oOooo, str3);
            crashDetailBean.O000O0oO = this.O00000o.O0000oo0();
            crashDetailBean.O0000OOo = this.O00000o.O0000oO();
            crashDetailBean.O0000Oo0 = this.O00000o.O000O0o0();
            crashDetailBean.O000OO = this.O00000o.O00000o0;
            crashDetailBean.O000OOOo = this.O00000o.O0000oo;
            crashDetailBean.O000OOo = this.O00000o.O00oOoOo();
            crashDetailBean.O000OOoO = this.O00000o.O0000oOo;
            crashDetailBean.O000OOoo = this.O00000o.O0000ooo();
            crashDetailBean.O000Oo00 = this.O00000o.O000O0Oo();
        } catch (Throwable th3) {
            did.O00000oO("handle crash error %s", th3.toString());
        }
        if (z) {
            this.O00000Oo.O00000Oo(crashDetailBean);
        } else {
            boolean z3 = str != null && str.length() > 0;
            if (bArr != null && bArr.length > 0) {
                z2 = true;
            }
            if (z3) {
                crashDetailBean.O000OOo0 = new HashMap(1);
                crashDetailBean.O000OOo0.put("UserData", str);
            }
            if (z2) {
                crashDetailBean.O000Oo0 = bArr;
            }
        }
        return crashDetailBean;
    }

    private static boolean O000000o(Thread thread) {
        synchronized (O0000Oo0) {
            if (O0000OOo != null && thread.getName().equals(O0000OOo)) {
                return true;
            }
            O0000OOo = thread.getName();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x029a A[Catch:{ all -> 0x02e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    public final void O000000o(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Thread thread2 = thread;
        Throwable th2 = th;
        boolean z2 = z;
        if (z2) {
            did.O00000oO("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (O000000o(thread)) {
                did.O000000o("this class has handled this exception", new Object[0]);
                if (this.O00000oo != null) {
                    did.O000000o("call system handler", new Object[0]);
                    this.O00000oo.uncaughtException(thread2, th2);
                } else {
                    did.O00000oO("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            did.O00000oO("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.O0000O0o) {
                did.O00000o0("Java crash handler is disable. Just return.", new Object[0]);
                if (z2) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.O00000oO;
                    if (uncaughtExceptionHandler != null && O000000o(uncaughtExceptionHandler)) {
                        did.O00000oO("sys default last handle start!", new Object[0]);
                        this.O00000oO.uncaughtException(thread2, th2);
                        did.O00000oO("sys default last handle end!", new Object[0]);
                    } else if (this.O00000oo != null) {
                        did.O00000oO("system handle start!", new Object[0]);
                        this.O00000oo.uncaughtException(thread2, th2);
                        did.O00000oO("system handle end!", new Object[0]);
                    } else {
                        did.O00000oO("crashreport last handle start!", new Object[0]);
                        did.O00000oO("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        did.O00000oO("crashreport last handle end!", new Object[0]);
                    }
                }
            } else {
                if (!this.O00000o0.O00000Oo()) {
                    did.O00000oO("waiting for remote sync", new Object[0]);
                    int i2 = 0;
                    while (!this.O00000o0.O00000Oo()) {
                        dif.O00000Oo(500);
                        i2 += 500;
                        if (i2 >= 3000) {
                            break;
                        }
                    }
                }
                if (!this.O00000o0.O00000Oo()) {
                    did.O00000o("no remote but still store!", new Object[0]);
                }
                String str10 = "JAVA_CRASH";
                if (!this.O00000o0.O00000o0().O0000O0o) {
                    try {
                        if (this.O00000o0.O00000Oo()) {
                            did.O00000oO("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                            if (!z2) {
                                str10 = "JAVA_CATCH";
                            }
                            String str11 = "crashreport last handle end!";
                            String str12 = "current process die";
                            String str13 = "crashreport last handle start!";
                            try {
                                dgz.O000000o(str10, dif.O000000o(), this.O00000o.O00000oo, thread, dif.O000000o(th), null);
                                if (z2) {
                                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.O00000oO;
                                    if (uncaughtExceptionHandler2 != null && O000000o(uncaughtExceptionHandler2)) {
                                        did.O00000oO("sys default last handle start!", new Object[0]);
                                        this.O00000oO.uncaughtException(thread2, th2);
                                        did.O00000oO("sys default last handle end!", new Object[0]);
                                        return;
                                    } else if (this.O00000oo != null) {
                                        did.O00000oO("system handle start!", new Object[0]);
                                        this.O00000oo.uncaughtException(thread2, th2);
                                        did.O00000oO("system handle end!", new Object[0]);
                                        return;
                                    } else {
                                        did.O00000oO(str13, new Object[0]);
                                        did.O00000oO(str12, new Object[0]);
                                        Process.killProcess(Process.myPid());
                                        System.exit(1);
                                        did.O00000oO(str11, new Object[0]);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str4 = str13;
                                str2 = str11;
                                str3 = str12;
                                i = 0;
                                if (z2) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str9 = "crashreport last handle end!";
                        str8 = "crashreport last handle start!";
                        str2 = str9;
                        str3 = "current process die";
                        str4 = str8;
                        i = 0;
                        if (z2) {
                        }
                        throw th;
                    }
                }
                str9 = "crashreport last handle end!";
                str8 = "crashreport last handle start!";
                try {
                    CrashDetailBean O00000Oo2 = O00000Oo(thread, th, z, str, bArr);
                    if (O00000Oo2 == null) {
                        did.O00000oO("pkg crash datas fail!", new Object[0]);
                        if (z2) {
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.O00000oO;
                            if (uncaughtExceptionHandler3 != null && O000000o(uncaughtExceptionHandler3)) {
                                did.O00000oO("sys default last handle start!", new Object[0]);
                                this.O00000oO.uncaughtException(thread2, th2);
                                did.O00000oO("sys default last handle end!", new Object[0]);
                            } else if (this.O00000oo != null) {
                                did.O00000oO("system handle start!", new Object[0]);
                                this.O00000oo.uncaughtException(thread2, th2);
                                did.O00000oO("system handle end!", new Object[0]);
                            } else {
                                did.O00000oO(str8, new Object[0]);
                                did.O00000oO("current process die", new Object[0]);
                                Process.killProcess(Process.myPid());
                                System.exit(1);
                                did.O00000oO(str9, new Object[0]);
                            }
                        }
                    } else {
                        if (!z2) {
                            str10 = "JAVA_CATCH";
                        }
                        String str14 = str9;
                        String str15 = "current process die";
                        String str16 = str8;
                        i = 0;
                        try {
                            dgz.O000000o(str10, dif.O000000o(), this.O00000o.O00000oo, thread, dif.O000000o(th), O00000Oo2);
                            if (!this.O00000Oo.O000000o(O00000Oo2)) {
                                this.O00000Oo.O000000o(O00000Oo2, z2);
                            }
                            if (z2) {
                                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.O00000oO;
                                if (uncaughtExceptionHandler4 != null && O000000o(uncaughtExceptionHandler4)) {
                                    did.O00000oO("sys default last handle start!", new Object[0]);
                                    this.O00000oO.uncaughtException(thread2, th2);
                                    did.O00000oO("sys default last handle end!", new Object[0]);
                                } else if (this.O00000oo != null) {
                                    did.O00000oO("system handle start!", new Object[0]);
                                    this.O00000oo.uncaughtException(thread2, th2);
                                    did.O00000oO("system handle end!", new Object[0]);
                                } else {
                                    did.O00000oO(str16, new Object[0]);
                                    did.O00000oO(str15, new Object[0]);
                                    Process.killProcess(Process.myPid());
                                    System.exit(1);
                                    did.O00000oO(str14, new Object[0]);
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str4 = str16;
                            str2 = str14;
                            str3 = str15;
                            if (z2) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    str2 = str9;
                    str3 = "current process die";
                    str4 = str8;
                    i = 0;
                    if (z2) {
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.O00000oO;
                        if (uncaughtExceptionHandler5 != null && O000000o(uncaughtExceptionHandler5)) {
                            did.O00000oO("sys default last handle start!", new Object[i]);
                            this.O00000oO.uncaughtException(thread2, th2);
                            did.O00000oO("sys default last handle end!", new Object[i]);
                        } else if (this.O00000oo != null) {
                            did.O00000oO("system handle start!", new Object[i]);
                            this.O00000oo.uncaughtException(thread2, th2);
                            did.O00000oO("system handle end!", new Object[i]);
                        } else {
                            did.O00000oO(str4, new Object[i]);
                            did.O00000oO(str3, new Object[i]);
                            Process.killProcess(Process.myPid());
                            System.exit(1);
                            did.O00000oO(str2, new Object[i]);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            str3 = "current process die";
            str4 = "crashreport last handle start!";
            str2 = "crashreport last handle end!";
            i = 0;
            if (z2) {
            }
            throw th;
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (O0000Oo0) {
            O000000o(thread, th, true, null, null);
        }
    }

    private static boolean O000000o(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    public final synchronized void O000000o(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.O0000O0o != this.O0000O0o) {
                did.O000000o("java changed to %b", Boolean.valueOf(strategyBean.O0000O0o));
                if (strategyBean.O0000O0o) {
                    O000000o();
                    return;
                }
                O00000Oo();
            }
        }
    }

    private static String O000000o(Throwable th, int i) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (i2 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (i <= 0 || sb.length() < i) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i2++;
                    } else {
                        sb.append("\n[Stack over limit size :" + i + " , has been cutted !]");
                        return sb.toString();
                    }
                }
            }
        } catch (Throwable th2) {
            did.O00000oO("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String O000000o(Throwable th) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
