package _m_j;

import _m_j.brr;
import android.content.Context;
import android.os.Looper;
import com.loc.aq$2;
import com.loc.t;
import java.io.File;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class bsf extends bsc implements Thread.UncaughtExceptionHandler {
    private static ExecutorService O00000oO;
    private static Set<Integer> O00000oo = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> O0000O0o;
    private static final ThreadFactory O0000OOo = new aq$2();
    /* access modifiers changed from: private */
    public Context O00000o;
    private List<Object> O0000Oo0;

    private bsf(Context context) {
        this.O00000o = context;
        try {
            this.O00000Oo = Thread.getDefaultUncaughtExceptionHandler();
            if (this.O00000Oo == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.O00000o0 = true;
                return;
            }
            String obj = this.O00000Oo.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.O00000o0 = true;
                return;
            }
            this.O00000o0 = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void O000000o(brr brr, String str, t tVar) {
        if (tVar != null) {
            O000000o(brr, str, tVar.c(), tVar.d(), tVar.b());
        }
    }

    public static void O000000o(brr brr, String str, String str2, String str3, String str4) {
        try {
            if (bsc.f13229O000000o != null) {
                bsc.f13229O000000o.O000000o(brr, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",code:" + str4, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void O00000Oo() {
        synchronized (bsf.class) {
            try {
                if (O00000oO != null) {
                    O00000oO.shutdown();
                }
                bss.O000000o();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(bsc.f13229O000000o == null || Thread.getDefaultUncaughtExceptionHandler() != bsc.f13229O000000o || bsc.f13229O000000o.O00000Oo == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(bsc.f13229O000000o.O00000Oo);
                }
                bsc.f13229O000000o = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    public static void O00000Oo(brr brr, String str, String str2) {
        try {
            if (bsc.f13229O000000o != null) {
                bsc.f13229O000000o.O000000o(brr, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void O00000Oo(Throwable th, String str, String str2) {
        try {
            if (bsc.f13229O000000o != null) {
                bsc.f13229O000000o.O000000o(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized ExecutorService O00000o() {
        ExecutorService executorService;
        synchronized (bsf.class) {
            try {
                if (O00000oO == null || O00000oO.isShutdown()) {
                    O00000oO = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), O0000OOo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = O00000oO;
        }
        return executorService;
    }

    public static void O00000o0() {
        WeakReference<Context> weakReference = O0000O0o;
        if (weakReference != null && weakReference.get() != null) {
            bsd.O00000Oo(O0000O0o.get());
        } else if (bsc.f13229O000000o != null) {
            bsc.f13229O000000o.O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        bsd.O00000Oo(this.O00000o);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(brr brr, String str, String str2) {
        bsg.O00000Oo(brr, this.O00000o, str2, str);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(final Context context, final brr brr, final boolean z) {
        try {
            ExecutorService O00000o2 = O00000o();
            if (O00000o2 == null) {
                return;
            }
            if (!O00000o2.isShutdown()) {
                O00000o2.submit(new Runnable() {
                    /* class _m_j.bsf.AnonymousClass1 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.bsk.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List<T>
                     arg types: [java.lang.String, java.lang.Class, int]
                     candidates:
                      _m_j.bsk.O000000o(android.database.Cursor, java.lang.Class, _m_j.bsl):T
                      _m_j.bsk.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List<T> */
                    public final void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                boolean z = true;
                                bsq bsq = new bsq(context, true);
                                brr brr = brr;
                                if (brr != null) {
                                    try {
                                        if (bsq.f13243O000000o == null) {
                                            bsq.f13243O000000o = bsq.O000000o(bsq.O00000Oo, false);
                                        }
                                        String O000000o2 = brr.O000000o(brr.O000000o());
                                        List O000000o3 = bsq.f13243O000000o.O000000o(O000000o2, brr.class, false);
                                        if (O000000o3.size() == 0) {
                                            bsq.f13243O000000o.O000000o(brr);
                                        } else {
                                            Iterator it = O000000o3.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    if (((brr) it.next()).equals(brr)) {
                                                        z = false;
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                            if (z) {
                                                bsq.f13243O000000o.O000000o(O000000o2, brr);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        bsf.O00000Oo(th, "sd", "it");
                                    }
                                }
                            }
                            if (z) {
                                bsg.O000000o(bsf.this.O00000o);
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Throwable th, int i, String str, String str2) {
        bsg.O000000o(this.O00000o, th, i, str, str2);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        int i = 0;
        while (i < this.O0000Oo0.size() && i < 10) {
            try {
                this.O0000Oo0.get(i);
                i++;
            } catch (Throwable unused) {
            }
        }
        if (th != null) {
            O000000o(th, 0, null, null);
            if (this.O00000Oo != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.O00000Oo);
                } catch (Throwable unused2) {
                }
                this.O00000Oo.uncaughtException(thread, th);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|11|12|(1:14)(1:15)|(1:17)(6:18|19|20|21|22|(4:27|(4:33|(2:37|(1:39)(2:40|(2:42|(1:44)(2:45|(3:47|48|85)(1:84)))))|49|50)|51|23))|53|54|(3:56|57|58)(7:59|60|(1:62)(1:63)|64|68|69|70)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:18|19|20|21|22|(4:27|(4:33|(2:37|(1:39)(2:40|(2:42|(1:44)(2:45|(3:47|48|85)(1:84)))))|49|50)|51|23)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00ab */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007a A[Catch:{ Throwable -> 0x00ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007b A[Catch:{ Throwable -> 0x00ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bb A[Catch:{ Throwable -> 0x00db, all -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c1 A[SYNTHETIC, Splitter:B:59:0x00c1] */
    public static synchronized bsf O000000o(Context context, brr brr) throws t {
        synchronized (bsf.class) {
            if (brr != null) {
                try {
                    if (brr.O000000o() == null || "".equals(brr.O000000o())) {
                        throw new t("sdk name is invalid");
                    }
                    bsh bsh2 = new bsh();
                    File file = new File(bsd.O000000o(context));
                    brr brr2 = null;
                    File[] listFiles = !file.isDirectory() ? null : file.listFiles();
                    if (listFiles != null) {
                        bsh2.O00000oO = listFiles;
                        brr2 = new brr.O000000o(bsh.O00000oo, "1.0", "").O000000o(new String[0]).O000000o();
                        ArrayList arrayList = new ArrayList();
                        int i = 0;
                        while (i < listFiles.length && i < 10) {
                            File file2 = listFiles[i];
                            if (file2 != null && file2.exists() && file2.isFile()) {
                                byte[] O000000o2 = bsh.O000000o(file2);
                                if (!(O000000o2 == null || O000000o2.length == 0)) {
                                    if (O000000o2.length > 100000) {
                                        String O000000o3 = brp.O000000o(O000000o2);
                                        if (!bsh.O000000o(arrayList, O000000o3)) {
                                            if (!bsh.f13236O000000o.contains(O000000o3)) {
                                                bsh.O000000o(context, O000000o2);
                                                bsh.f13236O000000o.add(O000000o3);
                                                bsg.O000000o(brr2, context, bsh.O00000oo, bwx.O00000Oo(O000000o2));
                                                if (file2 != null) {
                                                    try {
                                                        file2.delete();
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                file2.delete();
                            }
                            i++;
                        }
                    }
                    if (O00000oo.add(Integer.valueOf(brr.hashCode()))) {
                        bsf bsf = (bsf) bsc.f13229O000000o;
                        return bsf;
                    }
                    if (bsc.f13229O000000o == null) {
                        bsc.f13229O000000o = new bsf(context);
                    } else {
                        bsc.f13229O000000o.O00000o0 = false;
                    }
                    bsc.f13229O000000o.O000000o(context, brr, bsc.f13229O000000o.O00000o0);
                    bsf bsf2 = (bsf) bsc.f13229O000000o;
                    return bsf2;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new t("sdk info is null");
            }
        }
    }
}
