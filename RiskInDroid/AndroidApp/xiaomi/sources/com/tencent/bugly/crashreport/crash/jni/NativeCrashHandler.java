package com.tencent.bugly.crashreport.crash.jni;

import _m_j.dgo;
import _m_j.dgs;
import _m_j.dgt;
import _m_j.dgu;
import _m_j.dgz;
import _m_j.dha;
import _m_j.dhd;
import _m_j.dhe;
import _m_j.dhf;
import _m_j.dic;
import _m_j.did;
import _m_j.dif;
import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.io.File;

public class NativeCrashHandler implements dgo {
    private static NativeCrashHandler O00000Oo = null;
    private static boolean O0000Ooo = false;
    private static boolean O0000o00 = false;
    /* access modifiers changed from: package-private */

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5816O000000o;
    /* access modifiers changed from: private */
    public final dgs O00000o;
    /* access modifiers changed from: private */
    public final Context O00000o0;
    private final dic O00000oO;
    /* access modifiers changed from: private */
    public dhd O00000oo;
    private final boolean O0000O0o;
    private boolean O0000OOo = false;
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;
    private boolean O0000OoO = false;
    /* access modifiers changed from: private */
    public dgz O0000o0;

    /* access modifiers changed from: protected */
    public native boolean appendNativeLog(String str, String str2, String str3);

    /* access modifiers changed from: protected */
    public native boolean appendWholeNativeLog(String str);

    /* access modifiers changed from: protected */
    public native String getNativeKeyValueList();

    /* access modifiers changed from: protected */
    public native String getNativeLog();

    /* access modifiers changed from: protected */
    public native boolean putNativeKeyValue(String str, String str2);

    /* access modifiers changed from: protected */
    public native String regist(String str, boolean z, int i);

    /* access modifiers changed from: protected */
    public native String removeNativeKeyValue(String str);

    /* access modifiers changed from: protected */
    public native void setNativeInfo(int i, String str);

    /* access modifiers changed from: protected */
    public native void testCrash();

    /* access modifiers changed from: protected */
    public native String unregist();

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, dgs dgs, dgz dgz, dic dic, boolean z, String str) {
        this.O00000o0 = dif.O000000o(context);
        try {
            if (dif.O000000o(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + dgs.O000000o(context).O00000oO + "/app_bugly";
        }
        this.O0000o0 = dgz;
        this.f5816O000000o = str;
        this.O00000o = dgs;
        this.O00000oO = dic;
        this.O0000O0o = z;
        this.O00000oo = new dhe(context, dgs, dgz, dgu.O000000o());
    }

    public static synchronized NativeCrashHandler O000000o(Context context, dgs dgs, dgz dgz, dic dic, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (O00000Oo == null) {
                O00000Oo = new NativeCrashHandler(context, dgs, dgz, dic, z, null);
            }
            nativeCrashHandler = O00000Oo;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler O000000o() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = O00000Oo;
        }
        return nativeCrashHandler;
    }

    public final synchronized String O00000Oo() {
        return this.f5816O000000o;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:14|(1:16)(15:18|(1:20)|21|22|(1:24)|25|(1:27)|28|29|(1:31)(1:32)|33|(1:35)(1:36)|37|38|39)|17|21|22|(0)|25|(0)|28|29|(0)(0)|33|(0)(0)|37|38|39) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|9|(3:11|12|(16:14|(1:16)(15:18|(1:20)|21|22|(1:24)|25|(1:27)|28|29|(1:31)(1:32)|33|(1:35)(1:36)|37|38|39)|17|21|22|(0)|25|(0)|28|29|(0)(0)|33|(0)(0)|37|38|39))(2:44|(7:46|47|48|(1:50)(1:51)|52|(1:54)|(7:56|(1:58)|59|(1:61)|62|63|64)))|65|66|67|68) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x008d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x018a */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[Catch:{ Throwable -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b A[Catch:{ Throwable -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091 A[Catch:{ Throwable -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A[Catch:{ Throwable -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4 A[Catch:{ Throwable -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A[Catch:{ Throwable -> 0x00bb }] */
    private synchronized void O00000o0(boolean z) {
        StringBuilder sb;
        if (this.O0000Oo) {
            did.O00000o("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.O0000Oo0) {
            try {
                String regist = regist(this.f5816O000000o, z, 1);
                if (regist != null) {
                    did.O000000o("[Native] Native Crash Report enable.", new Object[0]);
                    did.O00000o0("[Native] Check extra jni for Bugly NDK v%s", regist);
                    String replace = "2.1.1".replace(".", "");
                    String replace2 = "2.3.0".replace(".", "");
                    String replace3 = regist.replace(".", "");
                    if (replace3.length() == 2) {
                        sb = new StringBuilder();
                        sb.append(replace3);
                        sb.append("0");
                    } else {
                        if (replace3.length() == 1) {
                            sb = new StringBuilder();
                            sb.append(replace3);
                            sb.append("00");
                        }
                        if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                            O0000Ooo = true;
                        }
                        if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                            O0000o00 = true;
                        }
                        if (O0000o00) {
                            did.O000000o("[Native] Info setting jni can be accessed.", new Object[0]);
                        } else {
                            did.O00000o("[Native] Info setting jni can not be accessed.", new Object[0]);
                        }
                        if (O0000Ooo) {
                            did.O000000o("[Native] Extra jni can be accessed.", new Object[0]);
                        } else {
                            did.O00000o("[Native] Extra jni can not be accessed.", new Object[0]);
                        }
                        this.O00000o.O0000oO = regist;
                        this.O0000Oo = true;
                        return;
                    }
                    replace3 = sb.toString();
                    if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                    }
                    if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                    }
                    if (O0000o00) {
                    }
                    if (O0000Ooo) {
                    }
                    this.O00000o.O0000oO = regist;
                    this.O0000Oo = true;
                    return;
                }
            } catch (Throwable unused) {
                did.O00000o0("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.O0000OOo) {
            Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
            Object[] objArr = new Object[4];
            objArr[0] = this.f5816O000000o;
            objArr[1] = dgt.O000000o(false);
            int i = 5;
            objArr[2] = Integer.valueOf(z ? 1 : 5);
            objArr[3] = 1;
            String str = (String) dif.O000000o("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", clsArr, objArr);
            if (str == null) {
                Class[] clsArr2 = {String.class, String.class, Integer.TYPE};
                dgs.O000000o();
                str = (String) dif.O000000o("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", clsArr2, new Object[]{this.f5816O000000o, dgt.O000000o(false), Integer.valueOf(dgs.O000O0o())});
            }
            if (str != null) {
                this.O0000Oo = true;
                dgs.O000000o().O0000oO = str;
                Boolean bool = (Boolean) dif.O000000o("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", new Class[]{String.class}, new Object[]{str});
                if (bool != null) {
                    O0000Ooo = bool.booleanValue();
                }
                dif.O000000o("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                if (z) {
                    i = 1;
                }
                dif.O000000o("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
                return;
            }
        }
        this.O0000Oo0 = false;
        this.O0000OOo = false;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0036=Splitter:B:21:0x0036, B:25:0x0047=Splitter:B:25:0x0047} */
    private synchronized void O00000o0() {
        if (!this.O0000Oo0) {
            if (!this.O0000OOo) {
                String str = "Bugly";
                boolean z = !dif.O000000o(this.O00000o.O0000oO0);
                String str2 = this.O00000o.O0000oO0;
                if (!z) {
                    this.O00000o.getClass();
                } else {
                    str = str2;
                }
                this.O0000Oo0 = O000000o(str, z);
                if (this.O0000Oo0 || this.O0000OOo) {
                    O00000o0(this.O0000O0o);
                    this.O00000oO.O000000o(new Runnable() {
                        /* class com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.dgz.O000000o(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):void
                         arg types: [com.tencent.bugly.crashreport.crash.CrashDetailBean, int]
                         candidates:
                          _m_j.dgz.O000000o(java.util.List<_m_j.dgv>, com.tencent.bugly.crashreport.crash.CrashDetailBean):com.tencent.bugly.crashreport.crash.CrashDetailBean
                          _m_j.dgz.O000000o(boolean, java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean>):void
                          _m_j.dgz.O000000o(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):void */
                        public final void run() {
                            File[] listFiles;
                            if (!dif.O000000o(NativeCrashHandler.this.O00000o0, "native_record_lock", 10000)) {
                                did.O000000o("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                                return;
                            }
                            try {
                                NativeCrashHandler.this.O000000o(10, NativeCrashHandler.this.O00000o.O0000o0);
                                NativeCrashHandler.this.O000000o(12, NativeCrashHandler.this.O00000o.O0000o);
                                NativeCrashHandler.this.O000000o(13, NativeCrashHandler.this.O00000o.O00000oO);
                                NativeCrashHandler.this.O000000o(11, NativeCrashHandler.this.O00000o.O00000o());
                                NativeCrashHandler.this.O000000o(NativeCrashHandler.this.O00000o.O0000oo);
                                NativeCrashHandler.this.O000000o(NativeCrashHandler.this.O00000o.O00000o0);
                            } catch (Throwable th) {
                                if (!did.O000000o(th)) {
                                    th.printStackTrace();
                                }
                            }
                            CrashDetailBean O000000o2 = dhf.O000000o(NativeCrashHandler.this.O00000o0, NativeCrashHandler.this.f5816O000000o, NativeCrashHandler.this.O00000oo);
                            if (O000000o2 != null) {
                                did.O000000o("[Native] Get crash from native record.", new Object[0]);
                                if (!NativeCrashHandler.this.O0000o0.O000000o(O000000o2)) {
                                    NativeCrashHandler.this.O0000o0.O000000o(O000000o2, false);
                                }
                                dhf.O00000Oo(NativeCrashHandler.this.f5816O000000o);
                            }
                            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
                            long O00000Oo = dif.O00000Oo() - dha.O0000O0o;
                            File file = new File(nativeCrashHandler.f5816O000000o);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                                int i = 0;
                                for (File file2 : listFiles) {
                                    String name = file2.getName();
                                    if (name.startsWith("tomb_")) {
                                        try {
                                            int indexOf = name.indexOf(".txt");
                                            if (indexOf > 0 && Long.parseLong(name.substring(5, indexOf)) >= O00000Oo) {
                                            }
                                        } catch (Throwable unused) {
                                            did.O00000oO("[Native] Tomb file format error, delete %s", name);
                                        }
                                        if (file2.delete()) {
                                            i++;
                                        }
                                    }
                                }
                                did.O00000o0("[Native] Clean tombs %d", Integer.valueOf(i));
                            }
                            dif.O00000Oo(NativeCrashHandler.this.O00000o0, "native_record_lock");
                        }
                    });
                    return;
                }
                return;
            }
        }
        O00000o0(this.O0000O0o);
    }

    private static boolean O000000o(String str, boolean z) {
        boolean z2;
        try {
            did.O000000o("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                did.O000000o("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
            did.O00000o(th.getMessage(), new Object[0]);
            did.O00000o("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    private synchronized void O00000o() {
        if (!this.O0000Oo) {
            did.O00000o("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                did.O000000o("[Native] Successfully closed native crash report.", new Object[0]);
                this.O0000Oo = false;
                return;
            }
        } catch (Throwable unused) {
            did.O00000o0("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            dif.O000000o("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.O0000Oo = false;
            did.O000000o("[Native] Successfully closed native crash report.", new Object[0]);
            return;
        } catch (Throwable unused2) {
            did.O00000o0("[Native] Failed to close native crash report.", new Object[0]);
            this.O0000Oo0 = false;
            this.O0000OOo = false;
            return;
        }
    }

    private synchronized void O00000o(boolean z) {
        if (z) {
            O00000o0();
        } else {
            O00000o();
        }
    }

    private synchronized boolean O00000oO() {
        return this.O0000OoO;
    }

    private synchronized void O00000oO(boolean z) {
        if (this.O0000OoO != z) {
            did.O000000o("user change native %b", Boolean.valueOf(z));
            this.O0000OoO = z;
        }
    }

    public final synchronized void O00000Oo(boolean z) {
        O00000oO(z);
        boolean O00000oO2 = O00000oO();
        dgu O000000o2 = dgu.O000000o();
        if (O000000o2 != null) {
            O00000oO2 = O00000oO2 && O000000o2.O00000o0().O0000O0o;
        }
        if (O00000oO2 != this.O0000Oo) {
            did.O000000o("native changed to %b", Boolean.valueOf(O00000oO2));
            O00000o(O00000oO2);
        }
    }

    public final synchronized void O000000o(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.O0000O0o != this.O0000Oo) {
                did.O00000o("server native changed to %b", Boolean.valueOf(strategyBean.O0000O0o));
            }
        }
        boolean z = dgu.O000000o().O00000o0().O0000O0o && this.O0000OoO;
        if (z != this.O0000Oo) {
            did.O000000o("native changed to %b", Boolean.valueOf(z));
            O00000o(z);
        }
    }

    public final boolean O000000o(String str, String str2, String str3) {
        if (!((!this.O0000OOo && !this.O0000Oo0) || !O0000Ooo || str == null || str2 == null || str3 == null)) {
            try {
                if (this.O0000Oo0) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) dif.O000000o("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                O0000Ooo = false;
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public final boolean O000000o(String str, String str2) {
        if ((this.O0000OOo || this.O0000Oo0) && O0000Ooo && str != null && str2 != null) {
            try {
                if (this.O0000Oo0) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) dif.O000000o("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                O0000Ooo = false;
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public final boolean O000000o(int i, String str) {
        if (this.O0000Oo0 && O0000o00) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                O0000o00 = false;
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public final boolean O000000o(boolean z) {
        return O000000o(14, z ? "true" : "false");
    }

    public final boolean O000000o(long j) {
        try {
            return O000000o(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (did.O000000o(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }
}
