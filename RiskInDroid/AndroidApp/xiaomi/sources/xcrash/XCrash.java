package xcrash;

import _m_j.jrm;
import _m_j.jrn;
import _m_j.jro;
import _m_j.jrp;
import _m_j.jrq;
import _m_j.jrr;
import _m_j.jrs;
import _m_j.jrt;
import _m_j.jrv;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.FileObserver;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import xcrash.XCrash;

public final class XCrash {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f15500O000000o = false;
    private static String O00000Oo;
    private static String O00000o;
    private static String O00000o0;
    private static jrs O00000oO = new jro();
    private static boolean O00000oo = false;
    private static Thread.UncaughtExceptionHandler O0000O0o = new Thread.UncaughtExceptionHandler() {
        /* class xcrash.XCrash.AnonymousClass1 */

        public final void uncaughtException(Thread thread, Throwable th) {
            try {
                if (!XCrash.initGetCalled()) {
                    InitParameters initParameters = new InitParameters();
                    initParameters.setNativeDumpAllThreads(false);
                    initParameters.setLogDir(XCrash.crashPath);
                    initParameters.setNativeDumpMap(false);
                    initParameters.setNativeDumpFds(false);
                    initParameters.setJavaDumpAllThreads(false);
                    XCrash.init(XCrash.tempContext, initParameters);
                }
                XCrash.initSemaphore.acquire();
                jrt.O000000o().O0000o0o = XCrash.defaultHandler;
                jrt.O000000o().uncaughtException(thread, th);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    public static String crashPath;
    public static Thread.UncaughtExceptionHandler defaultHandler = null;
    public static Semaphore initSemaphore;
    public static Context tempContext;

    private XCrash() {
    }

    public static void initHooker(Context context, String str) {
        initSemaphore = new Semaphore(0);
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        tempContext = context;
        crashPath = str;
        try {
            Thread.setDefaultUncaughtExceptionHandler(O0000O0o);
            O00000oo = true;
        } catch (Exception e) {
            O00000oO.O00000o0("xcrash", "JavaCrashHandler setDefaultUncaughtExceptionHandler failed", e);
        }
    }

    public static int init(Context context) {
        return init(context, null);
    }

    public static synchronized boolean initGetCalled() {
        boolean z;
        synchronized (XCrash.class) {
            z = f15500O000000o;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0212 A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x021d A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x027e A[Catch:{ Exception -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x028c A[Catch:{ Exception -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02ab A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e6 A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0159 A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0183 A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01ce A[Catch:{ Exception -> 0x014d }] */
    public static synchronized int init(Context context, InitParameters initParameters) {
        String str;
        String str2;
        Context context2;
        Context context3;
        Context context4;
        int i;
        Context context5;
        jrp O000000o2;
        boolean z;
        boolean z2;
        synchronized (XCrash.class) {
            if (f15500O000000o) {
                return 0;
            }
            f15500O000000o = true;
            if (context == null) {
                return -1;
            }
            Context applicationContext = context.getApplicationContext();
            Context context6 = applicationContext != null ? applicationContext : context;
            InitParameters initParameters2 = initParameters == null ? new InitParameters() : initParameters;
            if (initParameters2.O00000o != null) {
                O00000oO = initParameters2.O00000o;
            }
            String packageName = context6.getPackageName();
            O00000Oo = packageName;
            if (TextUtils.isEmpty(packageName)) {
                O00000Oo = "unknown";
            }
            if (TextUtils.isEmpty(initParameters2.f15501O000000o)) {
                initParameters2.f15501O000000o = jrv.O000000o(context6);
            }
            O00000o0 = initParameters2.f15501O000000o;
            if (TextUtils.isEmpty(initParameters2.O00000Oo)) {
                initParameters2.O00000Oo = context6.getFilesDir() + "/tombstones";
            }
            O00000o = initParameters2.O00000Oo;
            int myPid = Process.myPid();
            if (!initParameters2.O0000OOo) {
                if (!initParameters2.O000O0oO) {
                    str = null;
                    jrp.O000000o().O000000o(initParameters2.O00000Oo, initParameters2.O0000Oo, initParameters2.O0000oo0, initParameters2.O000OO0o, initParameters2.O00000oo, initParameters2.O0000O0o, initParameters2.O00000o0);
                    if ((initParameters2.O0000OOo || initParameters2.O0000oOO || initParameters2.O000O0oO) && (context6 instanceof Application)) {
                        jrm O000000o3 = jrm.O000000o();
                        O000000o3.f2100O000000o = new LinkedList<>();
                        ((Application) context6).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                            /* class _m_j.jrm.AnonymousClass1 */
                            private int O00000Oo = 0;
                            private boolean O00000o0 = false;

                            public final void onActivityPaused(Activity activity) {
                            }

                            public final void onActivityResumed(Activity activity) {
                            }

                            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            }

                            public final void onActivityCreated(Activity activity, Bundle bundle) {
                                jrm.this.f2100O000000o.addFirst(activity);
                                if (jrm.this.f2100O000000o.size() > 100) {
                                    jrm.this.f2100O000000o.removeLast();
                                }
                            }

                            public final void onActivityStarted(Activity activity) {
                                int i = this.O00000Oo + 1;
                                this.O00000Oo = i;
                                if (i == 1 && !this.O00000o0) {
                                    jrm.this.O00000Oo = true;
                                }
                            }

                            public final void onActivityStopped(Activity activity) {
                                this.O00000o0 = activity.isChangingConfigurations();
                                int i = this.O00000Oo - 1;
                                this.O00000Oo = i;
                                if (i == 0 && !this.O00000o0) {
                                    jrm.this.O00000Oo = false;
                                }
                            }

                            public final void onActivityDestroyed(Activity activity) {
                                jrm.this.f2100O000000o.remove(activity);
                            }
                        });
                    }
                    if (!initParameters2.O0000OOo) {
                        jrt O000000o4 = jrt.O000000o();
                        boolean z3 = O00000oo;
                        String str3 = O00000Oo;
                        String str4 = initParameters2.f15501O000000o;
                        String str5 = initParameters2.O00000Oo;
                        boolean z4 = initParameters2.O0000Oo0;
                        int i2 = initParameters2.O0000OoO;
                        int i3 = initParameters2.O0000Ooo;
                        int i4 = initParameters2.O0000o00;
                        boolean z5 = initParameters2.O0000o0;
                        boolean z6 = initParameters2.O0000o0O;
                        context2 = context6;
                        boolean z7 = initParameters2.O0000o0o;
                        boolean z8 = z3;
                        int i5 = initParameters2.O0000o;
                        String[] strArr = initParameters2.O0000oO0;
                        jrq jrq = initParameters2.O0000oO;
                        O000000o4.f2115O000000o = myPid;
                        if (TextUtils.isEmpty(str)) {
                            str2 = str;
                            str = "unknown";
                        } else {
                            str2 = str;
                        }
                        O000000o4.O00000Oo = str;
                        O000000o4.O00000o0 = str3;
                        O000000o4.O00000o = str4;
                        O000000o4.O00000oO = z4;
                        O000000o4.O00000oo = str5;
                        O000000o4.O0000O0o = i2;
                        O000000o4.O0000OOo = i3;
                        O000000o4.O0000Oo0 = i4;
                        O000000o4.O0000Oo = z5;
                        O000000o4.O0000OoO = z6;
                        O000000o4.O0000Ooo = z7;
                        O000000o4.O0000o00 = i5;
                        O000000o4.O0000o0 = strArr;
                        O000000o4.O0000o0O = jrq;
                        if (!z8) {
                            O000000o4.O0000o0o = Thread.getDefaultUncaughtExceptionHandler();
                            try {
                                Thread.setDefaultUncaughtExceptionHandler(O000000o4);
                            } catch (Exception e) {
                                O00000oO.O00000o0("xcrash", "JavaCrashHandler setDefaultUncaughtExceptionHandler failed", e);
                            }
                        }
                    } else {
                        context2 = context6;
                        str2 = str;
                    }
                    if (initParameters2.O000O0oO && Build.VERSION.SDK_INT < 21) {
                        jrn O000000o5 = jrn.O000000o();
                        String str6 = O00000Oo;
                        String str7 = initParameters2.f15501O000000o;
                        String str8 = initParameters2.O00000Oo;
                        boolean z9 = initParameters2.O000OO00;
                        int i6 = initParameters2.O000OO;
                        int i7 = initParameters2.O000OOOo;
                        int i8 = initParameters2.O000OOo0;
                        boolean z10 = initParameters2.O000OOo;
                        boolean z11 = initParameters2.O000OOoO;
                        jrq jrq2 = initParameters2.O000OOoo;
                        if (Build.VERSION.SDK_INT < 21) {
                            context3 = context2;
                            O000000o5.O00000Oo = context3;
                            O000000o5.O00000o0 = myPid;
                            O000000o5.O00000o = TextUtils.isEmpty(str2) ? "unknown" : str2;
                            O000000o5.O00000oO = str6;
                            O000000o5.O00000oo = str7;
                            O000000o5.O0000O0o = str8;
                            O000000o5.O0000OOo = z9;
                            O000000o5.O0000Oo0 = i6;
                            O000000o5.O0000Oo = i7;
                            O000000o5.O0000OoO = i8;
                            O000000o5.O0000Ooo = z10;
                            O000000o5.O0000o00 = z11;
                            O000000o5.O0000o0 = jrq2;
                            O000000o5.O0000o0o = new FileObserver("/data/anr/") {
                                /* class _m_j.jrn.AnonymousClass1 */

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: _m_j.jrv.O000000o(android.content.Context, long):boolean
                                 arg types: [android.content.Context, int]
                                 candidates:
                                  _m_j.jrv.O000000o(android.content.Context, int):java.lang.String
                                  _m_j.jrv.O000000o(java.lang.String, int):java.lang.String
                                  _m_j.jrv.O000000o(android.content.Context, long):boolean */
                                /* JADX WARNING: Can't wrap try/catch for region: R(5:55|56|(2:64|65)|66|67) */
                                /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x015c */
                                /* JADX WARNING: Removed duplicated region for block: B:61:0x0153 A[SYNTHETIC, Splitter:B:61:0x0153] */
                                /* JADX WARNING: Removed duplicated region for block: B:64:0x0159 A[SYNTHETIC, Splitter:B:64:0x0159] */
                                /* JADX WARNING: Removed duplicated region for block: B:71:0x0161 A[ADDED_TO_REGION] */
                                /* JADX WARNING: Removed duplicated region for block: B:87:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
                                public final void onEvent(int i, String str) {
                                    String str2;
                                    File file;
                                    if (str != null) {
                                        try {
                                            String concat = "/data/anr/".concat(String.valueOf(str));
                                            if (concat.contains("trace")) {
                                                jrn jrn = jrn.this;
                                                Date date = new Date();
                                                if (date.getTime() - jrn.O0000o0O < 15000) {
                                                    return;
                                                }
                                                if (!jrn.O0000OOo || jrv.O000000o(jrn.O00000Oo, 15000L)) {
                                                    String O000000o2 = jrn.O000000o(concat, date.getTime());
                                                    if (!TextUtils.isEmpty(O000000o2)) {
                                                        jrn.O0000o0O = date.getTime();
                                                        if (jrp.O000000o().O00000Oo()) {
                                                            RandomAccessFile randomAccessFile = null;
                                                            try {
                                                                str2 = jrv.O000000o(jrn.f2102O000000o, date, "anr", jrn.O00000oO, jrn.O00000oo) + "pid: " + jrn.O00000o0 + "  >>> " + jrn.O00000o + " <<<\n\n--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n" + O000000o2 + "\n+++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++\n\n";
                                                            } catch (Exception e) {
                                                                XCrash.O000000o().O00000o0("xcrash", "AnrHandler getEmergency failed", e);
                                                                str2 = null;
                                                            }
                                                            try {
                                                                file = jrp.O000000o().O000000o(String.format(Locale.US, "%s/%s_%020d_%s__%s%s", jrn.O0000O0o, "tombstone", Long.valueOf(date.getTime() * 1000), jrn.O00000oo, jrn.O00000o, ".anr.xcrash"));
                                                            } catch (Exception e2) {
                                                                XCrash.O000000o().O00000o0("xcrash", "AnrHandler createLogFile failed", e2);
                                                                file = null;
                                                            }
                                                            if (file != null) {
                                                                try {
                                                                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rws");
                                                                    if (str2 != null) {
                                                                        try {
                                                                            randomAccessFile2.write(str2.getBytes("UTF-8"));
                                                                        } catch (Exception e3) {
                                                                            e = e3;
                                                                            randomAccessFile = randomAccessFile2;
                                                                            try {
                                                                                XCrash.O000000o().O00000o0("xcrash", "AnrHandler write log file failed", e);
                                                                                if (randomAccessFile != null) {
                                                                                }
                                                                                if (jrn.O0000o0 == null) {
                                                                                }
                                                                            } catch (Throwable th) {
                                                                                th = th;
                                                                                randomAccessFile2 = randomAccessFile;
                                                                                if (randomAccessFile2 != null) {
                                                                                    randomAccessFile2.close();
                                                                                }
                                                                                throw th;
                                                                            }
                                                                        } catch (Throwable th2) {
                                                                            th = th2;
                                                                            if (randomAccessFile2 != null) {
                                                                            }
                                                                            throw th;
                                                                        }
                                                                    }
                                                                    if (jrn.O0000OoO > 0 || jrn.O0000Oo0 > 0 || jrn.O0000Oo > 0) {
                                                                        randomAccessFile2.write(jrv.O000000o(jrn.O0000OoO, jrn.O0000Oo0, jrn.O0000Oo).getBytes("UTF-8"));
                                                                    }
                                                                    if (jrn.O0000Ooo) {
                                                                        randomAccessFile2.write(jrv.O00000oO().getBytes("UTF-8"));
                                                                    }
                                                                    if (jrn.O0000o00) {
                                                                        randomAccessFile2.write(jrv.O00000o().getBytes("UTF-8"));
                                                                    }
                                                                    randomAccessFile2.write(jrv.O00000o0().getBytes("UTF-8"));
                                                                    try {
                                                                        randomAccessFile2.close();
                                                                    } catch (Exception unused) {
                                                                    }
                                                                } catch (Exception e4) {
                                                                    e = e4;
                                                                    XCrash.O000000o().O00000o0("xcrash", "AnrHandler write log file failed", e);
                                                                    if (randomAccessFile != null) {
                                                                        randomAccessFile.close();
                                                                    }
                                                                    if (jrn.O0000o0 == null) {
                                                                        return;
                                                                    }
                                                                }
                                                            }
                                                            if (jrn.O0000o0 == null && file != null) {
                                                                try {
                                                                    file.getAbsolutePath();
                                                                } catch (Exception unused2) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e5) {
                                            XCrash.O000000o().O00000o0("xcrash", "AnrHandler fileObserver onEvent failed", e5);
                                        }
                                    }
                                }
                            };
                            try {
                                O000000o5.O0000o0o.startWatching();
                                context4 = null;
                            } catch (Exception e2) {
                                context4 = null;
                                O000000o5.O0000o0o = null;
                                O00000oO.O00000o0("xcrash", "AnrHandler fileObserver startWatching failed", e2);
                            }
                            if (!initParameters2.O0000oOO) {
                                if (!initParameters2.O000O0oO || Build.VERSION.SDK_INT < 21) {
                                    context5 = context4;
                                    i = 0;
                                    O000000o2 = jrp.O000000o();
                                    if (O000000o2.O00000o != null && O000000o2.O00000oO >= 0) {
                                        if (O000000o2.O00000oO == 0) {
                                            new Thread(new Runnable() {
                                                /* class _m_j.jrp.AnonymousClass1 */

                                                public final void run() {
                                                    jrp.this.O00000o0();
                                                }
                                            }, "xcrash_file_mgr").start();
                                        } else {
                                            new Timer("xcrash_file_mgr").schedule(new TimerTask() {
                                                /* class _m_j.jrp.AnonymousClass3 */

                                                public final void run() {
                                                    jrp.this.O00000o0();
                                                }
                                            }, (long) O000000o2.O00000oO);
                                        }
                                    }
                                    if (initSemaphore != null) {
                                        initSemaphore.release();
                                    }
                                    tempContext = context5;
                                    return i;
                                }
                            }
                            NativeHandler O000000o6 = NativeHandler.O000000o();
                            jrr jrr = initParameters2.O00000oO;
                            String str9 = O00000Oo;
                            String str10 = initParameters2.f15501O000000o;
                            String str11 = initParameters2.O00000Oo;
                            boolean z12 = initParameters2.O0000oOO;
                            boolean z13 = initParameters2.O0000oOo;
                            int i9 = initParameters2.O0000oo;
                            int i10 = initParameters2.O0000ooO;
                            int i11 = initParameters2.O0000ooo;
                            boolean z14 = initParameters2.O00oOooO;
                            boolean z15 = initParameters2.O00oOooo;
                            boolean z16 = initParameters2.O000O00o;
                            boolean z17 = initParameters2.O000O0OO;
                            boolean z18 = initParameters2.O000O0Oo;
                            int i12 = initParameters2.O00oOoOo;
                            String[] strArr2 = initParameters2.O000O0o0;
                            jrq jrq3 = initParameters2.O000O0o;
                            if (initParameters2.O000O0oO) {
                                z2 = z14;
                                if (Build.VERSION.SDK_INT >= 21) {
                                    z = true;
                                    int i13 = i11;
                                    context5 = null;
                                    i = O000000o6.O000000o(context3, jrr, str9, str10, str11, z12, z13, i9, i10, i13, z2, z15, z16, z17, z18, i12, strArr2, jrq3, z, initParameters2.O000O0oo, initParameters2.O000OO00, initParameters2.O000OO, initParameters2.O000OOOo, initParameters2.O000OOo0, initParameters2.O000OOo, initParameters2.O000OOoO, initParameters2.O000OOoo);
                                    O000000o2 = jrp.O000000o();
                                    if (O000000o2.O00000oO == 0) {
                                    }
                                    if (initSemaphore != null) {
                                    }
                                    tempContext = context5;
                                    return i;
                                }
                            } else {
                                z2 = z14;
                            }
                            z = false;
                            int i132 = i11;
                            context5 = null;
                            i = O000000o6.O000000o(context3, jrr, str9, str10, str11, z12, z13, i9, i10, i132, z2, z15, z16, z17, z18, i12, strArr2, jrq3, z, initParameters2.O000O0oo, initParameters2.O000OO00, initParameters2.O000OO, initParameters2.O000OOOo, initParameters2.O000OOo0, initParameters2.O000OOo, initParameters2.O000OOoO, initParameters2.O000OOoo);
                            O000000o2 = jrp.O000000o();
                            if (O000000o2.O00000oO == 0) {
                            }
                            if (initSemaphore != null) {
                            }
                            tempContext = context5;
                            return i;
                        }
                    }
                    context3 = context2;
                    context4 = null;
                    if (!initParameters2.O0000oOO) {
                    }
                    NativeHandler O000000o62 = NativeHandler.O000000o();
                    jrr jrr2 = initParameters2.O00000oO;
                    String str92 = O00000Oo;
                    String str102 = initParameters2.f15501O000000o;
                    String str112 = initParameters2.O00000Oo;
                    boolean z122 = initParameters2.O0000oOO;
                    boolean z132 = initParameters2.O0000oOo;
                    int i92 = initParameters2.O0000oo;
                    int i102 = initParameters2.O0000ooO;
                    int i112 = initParameters2.O0000ooo;
                    boolean z142 = initParameters2.O00oOooO;
                    boolean z152 = initParameters2.O00oOooo;
                    boolean z162 = initParameters2.O000O00o;
                    boolean z172 = initParameters2.O000O0OO;
                    boolean z182 = initParameters2.O000O0Oo;
                    int i122 = initParameters2.O00oOoOo;
                    String[] strArr22 = initParameters2.O000O0o0;
                    jrq jrq32 = initParameters2.O000O0o;
                    if (initParameters2.O000O0oO) {
                    }
                    z = false;
                    int i1322 = i112;
                    context5 = null;
                    i = O000000o62.O000000o(context3, jrr2, str92, str102, str112, z122, z132, i92, i102, i1322, z2, z152, z162, z172, z182, i122, strArr22, jrq32, z, initParameters2.O000O0oo, initParameters2.O000OO00, initParameters2.O000OO, initParameters2.O000OOOo, initParameters2.O000OOo0, initParameters2.O000OOo, initParameters2.O000OOoO, initParameters2.O000OOoo);
                    O000000o2 = jrp.O000000o();
                    if (O000000o2.O00000oO == 0) {
                    }
                    if (initSemaphore != null) {
                    }
                    tempContext = context5;
                    return i;
                }
            }
            str = jrv.O000000o(context6, myPid);
            if (initParameters2.O000O0oO && (TextUtils.isEmpty(str) || !str.equals(packageName))) {
                initParameters2.O000O0oO = false;
            }
            jrp.O000000o().O000000o(initParameters2.O00000Oo, initParameters2.O0000Oo, initParameters2.O0000oo0, initParameters2.O000OO0o, initParameters2.O00000oo, initParameters2.O0000O0o, initParameters2.O00000o0);
            jrm O000000o32 = jrm.O000000o();
            O000000o32.f2100O000000o = new LinkedList<>();
            ((Application) context6).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                /* class _m_j.jrm.AnonymousClass1 */
                private int O00000Oo = 0;
                private boolean O00000o0 = false;

                public final void onActivityPaused(Activity activity) {
                }

                public final void onActivityResumed(Activity activity) {
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    jrm.this.f2100O000000o.addFirst(activity);
                    if (jrm.this.f2100O000000o.size() > 100) {
                        jrm.this.f2100O000000o.removeLast();
                    }
                }

                public final void onActivityStarted(Activity activity) {
                    int i = this.O00000Oo + 1;
                    this.O00000Oo = i;
                    if (i == 1 && !this.O00000o0) {
                        jrm.this.O00000Oo = true;
                    }
                }

                public final void onActivityStopped(Activity activity) {
                    this.O00000o0 = activity.isChangingConfigurations();
                    int i = this.O00000Oo - 1;
                    this.O00000Oo = i;
                    if (i == 0 && !this.O00000o0) {
                        jrm.this.O00000Oo = false;
                    }
                }

                public final void onActivityDestroyed(Activity activity) {
                    jrm.this.f2100O000000o.remove(activity);
                }
            });
            if (!initParameters2.O0000OOo) {
            }
            jrn O000000o52 = jrn.O000000o();
            String str62 = O00000Oo;
            String str72 = initParameters2.f15501O000000o;
            String str82 = initParameters2.O00000Oo;
            boolean z92 = initParameters2.O000OO00;
            int i62 = initParameters2.O000OO;
            int i72 = initParameters2.O000OOOo;
            int i82 = initParameters2.O000OOo0;
            boolean z102 = initParameters2.O000OOo;
            boolean z112 = initParameters2.O000OOoO;
            jrq jrq22 = initParameters2.O000OOoo;
            if (Build.VERSION.SDK_INT < 21) {
            }
            context3 = context2;
            context4 = null;
            if (!initParameters2.O0000oOO) {
            }
            NativeHandler O000000o622 = NativeHandler.O000000o();
            jrr jrr22 = initParameters2.O00000oO;
            String str922 = O00000Oo;
            String str1022 = initParameters2.f15501O000000o;
            String str1122 = initParameters2.O00000Oo;
            boolean z1222 = initParameters2.O0000oOO;
            boolean z1322 = initParameters2.O0000oOo;
            int i922 = initParameters2.O0000oo;
            int i1022 = initParameters2.O0000ooO;
            int i1122 = initParameters2.O0000ooo;
            boolean z1422 = initParameters2.O00oOooO;
            boolean z1522 = initParameters2.O00oOooo;
            boolean z1622 = initParameters2.O000O00o;
            boolean z1722 = initParameters2.O000O0OO;
            boolean z1822 = initParameters2.O000O0Oo;
            int i1222 = initParameters2.O00oOoOo;
            String[] strArr222 = initParameters2.O000O0o0;
            jrq jrq322 = initParameters2.O000O0o;
            if (initParameters2.O000O0oO) {
            }
            z = false;
            int i13222 = i1122;
            context5 = null;
            i = O000000o622.O000000o(context3, jrr22, str922, str1022, str1122, z1222, z1322, i922, i1022, i13222, z2, z1522, z1622, z1722, z1822, i1222, strArr222, jrq322, z, initParameters2.O000O0oo, initParameters2.O000OO00, initParameters2.O000OO, initParameters2.O000OOOo, initParameters2.O000OOo0, initParameters2.O000OOo, initParameters2.O000OOoO, initParameters2.O000OOoo);
            O000000o2 = jrp.O000000o();
            try {
                if (O000000o2.O00000oO == 0) {
                }
            } catch (Exception e3) {
                O00000oO.O00000o0("xcrash", "FileManager maintain start failed", e3);
            }
            if (initSemaphore != null) {
            }
            tempContext = context5;
            return i;
        }
    }

    public static class InitParameters {

        /* renamed from: O000000o  reason: collision with root package name */
        String f15501O000000o = null;
        String O00000Oo = null;
        jrs O00000o = null;
        int O00000o0 = 5000;
        jrr O00000oO = null;
        int O00000oo = 0;
        int O0000O0o = NotificationCompat.FLAG_HIGH_PRIORITY;
        boolean O0000OOo = true;
        int O0000Oo = 10;
        boolean O0000Oo0 = true;
        int O0000OoO = 50;
        int O0000Ooo = 50;
        int O0000o = 0;
        boolean O0000o0 = true;
        int O0000o00 = 200;
        boolean O0000o0O = true;
        boolean O0000o0o = true;
        jrq O0000oO = null;
        String[] O0000oO0 = null;
        boolean O0000oOO = true;
        boolean O0000oOo = true;
        int O0000oo = 50;
        int O0000oo0 = 10;
        int O0000ooO = 50;
        int O0000ooo = 200;
        boolean O000O00o = true;
        boolean O000O0OO = true;
        boolean O000O0Oo = true;
        jrq O000O0o = null;
        String[] O000O0o0 = null;
        boolean O000O0oO = true;
        boolean O000O0oo = true;
        int O000OO = 50;
        boolean O000OO00 = true;
        int O000OO0o = 10;
        int O000OOOo = 50;
        boolean O000OOo = true;
        int O000OOo0 = 200;
        boolean O000OOoO = true;
        jrq O000OOoo = null;
        int O00oOoOo = 0;
        boolean O00oOooO = true;
        boolean O00oOooo = true;

        public InitParameters setAppVersion(String str) {
            this.f15501O000000o = str;
            return this;
        }

        public InitParameters setLogDir(String str) {
            this.O00000Oo = str;
            return this;
        }

        public InitParameters setLogFileMaintainDelayMs(int i) {
            if (i < 0) {
                i = 0;
            }
            this.O00000o0 = i;
            return this;
        }

        public InitParameters setLogger(jrs jrs) {
            this.O00000o = jrs;
            return this;
        }

        public InitParameters setLibLoader(jrr jrr) {
            this.O00000oO = jrr;
            return this;
        }

        public InitParameters setPlaceholderCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.O00000oo = i;
            return this;
        }

        public InitParameters setPlaceholderSizeKb(int i) {
            if (i < 0) {
                i = 0;
            }
            this.O0000O0o = i;
            return this;
        }

        public InitParameters enableJavaCrashHandler() {
            this.O0000OOo = true;
            return this;
        }

        public InitParameters disableJavaCrashHandler() {
            this.O0000OOo = false;
            return this;
        }

        public InitParameters setJavaRethrow(boolean z) {
            this.O0000Oo0 = z;
            return this;
        }

        public InitParameters setJavaLogCountMax(int i) {
            if (i <= 0) {
                i = 1;
            }
            this.O0000Oo = i;
            return this;
        }

        public InitParameters setJavaLogcatSystemLines(int i) {
            this.O0000OoO = i;
            return this;
        }

        public InitParameters setJavaLogcatEventsLines(int i) {
            this.O0000Ooo = i;
            return this;
        }

        public InitParameters setJavaLogcatMainLines(int i) {
            this.O0000o00 = i;
            return this;
        }

        public InitParameters setJavaDumpFds(boolean z) {
            this.O0000o0 = z;
            return this;
        }

        public InitParameters setJavaDumpNetworkInfo(boolean z) {
            this.O0000o0O = z;
            return this;
        }

        public InitParameters setJavaDumpAllThreads(boolean z) {
            this.O0000o0o = z;
            return this;
        }

        public InitParameters setJavaDumpAllThreadsCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.O0000o = i;
            return this;
        }

        public InitParameters setJavaDumpAllThreadsWhiteList(String[] strArr) {
            this.O0000oO0 = strArr;
            return this;
        }

        public InitParameters setJavaCallback(jrq jrq) {
            this.O0000oO = jrq;
            return this;
        }

        public InitParameters enableNativeCrashHandler() {
            this.O0000oOO = true;
            return this;
        }

        public InitParameters disableNativeCrashHandler() {
            this.O0000oOO = false;
            return this;
        }

        public InitParameters setNativeRethrow(boolean z) {
            this.O0000oOo = z;
            return this;
        }

        public InitParameters setNativeLogCountMax(int i) {
            if (i <= 0) {
                i = 1;
            }
            this.O0000oo0 = i;
            return this;
        }

        public InitParameters setNativeLogcatSystemLines(int i) {
            this.O0000oo = i;
            return this;
        }

        public InitParameters setNativeLogcatEventsLines(int i) {
            this.O0000ooO = i;
            return this;
        }

        public InitParameters setNativeLogcatMainLines(int i) {
            this.O0000ooo = i;
            return this;
        }

        public InitParameters setNativeDumpElfHash(boolean z) {
            this.O00oOooO = z;
            return this;
        }

        public InitParameters setNativeDumpMap(boolean z) {
            this.O00oOooo = z;
            return this;
        }

        public InitParameters setNativeDumpFds(boolean z) {
            this.O000O00o = z;
            return this;
        }

        public InitParameters setNativeDumpNetwork(boolean z) {
            this.O000O0OO = z;
            return this;
        }

        public InitParameters setNativeDumpAllThreads(boolean z) {
            this.O000O0Oo = z;
            return this;
        }

        public InitParameters setNativeDumpAllThreadsCountMax(int i) {
            if (i < 0) {
                i = 0;
            }
            this.O00oOoOo = i;
            return this;
        }

        public InitParameters setNativeDumpAllThreadsWhiteList(String[] strArr) {
            this.O000O0o0 = strArr;
            return this;
        }

        public InitParameters setNativeCallback(jrq jrq) {
            this.O000O0o = jrq;
            return this;
        }

        public InitParameters enableAnrCrashHandler() {
            this.O000O0oO = true;
            return this;
        }

        public InitParameters disableAnrCrashHandler() {
            this.O000O0oO = false;
            return this;
        }

        public InitParameters setAnrRethrow(boolean z) {
            this.O000O0oo = z;
            return this;
        }

        public InitParameters setAnrCheckProcessState(boolean z) {
            this.O000OO00 = z;
            return this;
        }

        public InitParameters setAnrLogCountMax(int i) {
            if (i <= 0) {
                i = 1;
            }
            this.O000OO0o = i;
            return this;
        }

        public InitParameters setAnrLogcatSystemLines(int i) {
            this.O000OO = i;
            return this;
        }

        public InitParameters setAnrLogcatEventsLines(int i) {
            this.O000OOOo = i;
            return this;
        }

        public InitParameters setAnrLogcatMainLines(int i) {
            this.O000OOo0 = i;
            return this;
        }

        public InitParameters setAnrDumpFds(boolean z) {
            this.O000OOo = z;
            return this;
        }

        public InitParameters setAnrDumpNetwork(boolean z) {
            this.O000OOoO = z;
            return this;
        }

        public InitParameters setAnrCallback(jrq jrq) {
            this.O000OOoo = jrq;
            return this;
        }
    }

    public static jrs O000000o() {
        return O00000oO;
    }

    public static void testJavaCrash(boolean z) throws RuntimeException {
        if (z) {
            AnonymousClass2 r1 = new Thread() {
                /* class xcrash.XCrash.AnonymousClass2 */

                public final void run() {
                    throw new RuntimeException("test java exception");
                }
            };
            r1.setName("xcrash_test_java_thread");
            r1.start();
            return;
        }
        throw new RuntimeException("test java exception");
    }

    public static void testNativeCrash(boolean z) {
        if (NativeHandler.O000000o().O00000Oo) {
            NativeHandler.nativeTestCrash(z ? 1 : 0);
        }
    }
}
