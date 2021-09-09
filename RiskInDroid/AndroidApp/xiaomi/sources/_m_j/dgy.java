package _m_j;

import _m_j.dgw;
import android.content.Context;
import android.os.FileObserver;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class dgy {

    /* renamed from: O000000o  reason: collision with root package name */
    public AtomicInteger f14624O000000o = new AtomicInteger(0);
    long O00000Oo = -1;
    final dgu O00000o;
    final Context O00000o0;
    final String O00000oO;
    final dgz O00000oo;
    private final dgs O0000O0o;
    private final dic O0000OOo;
    private boolean O0000Oo = true;
    private FileObserver O0000Oo0;

    public dgy(Context context, dgu dgu, dgs dgs, dic dic, dgz dgz) {
        this.O00000o0 = dif.O000000o(context);
        this.O00000oO = context.getDir("bugly", 0).getAbsolutePath();
        this.O0000O0o = dgs;
        this.O0000OOo = dic;
        this.O00000o = dgu;
        this.O00000oo = dgz;
    }

    /* access modifiers changed from: package-private */
    public CrashDetailBean O000000o(dgx dgx) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.O000O00o = dgt.O0000OOo();
            crashDetailBean.O000O0OO = dgt.O00000oo();
            crashDetailBean.O000O0Oo = dgt.O0000Oo();
            crashDetailBean.O00oOoOo = this.O0000O0o.O0000o00();
            crashDetailBean.O000O0o0 = this.O0000O0o.O0000Ooo();
            crashDetailBean.O000O0o = this.O0000O0o.O0000o0();
            crashDetailBean.O0000oo = dif.O000000o(this.O00000o0, dha.O00000oO);
            crashDetailBean.O00000Oo = 3;
            crashDetailBean.O00000oO = this.O0000O0o.O00000oO();
            crashDetailBean.O00000oo = this.O0000O0o.O0000o0;
            crashDetailBean.O0000O0o = this.O0000O0o.O0000oOO();
            crashDetailBean.O0000o00 = this.O0000O0o.O00000o();
            crashDetailBean.O0000o0 = "ANR_EXCEPTION";
            crashDetailBean.O0000o0O = dgx.O00000oo;
            crashDetailBean.O0000o = dgx.O0000O0o;
            crashDetailBean.O000OOo0 = new HashMap();
            crashDetailBean.O000OOo0.put("BUGLY_CR_01", dgx.O00000oO);
            int i = -1;
            if (crashDetailBean.O0000o != null) {
                i = crashDetailBean.O0000o.indexOf("\n");
            }
            crashDetailBean.O0000o0o = i > 0 ? crashDetailBean.O0000o.substring(0, i) : "GET_FAIL";
            crashDetailBean.O0000oO0 = dgx.O00000o0;
            if (crashDetailBean.O0000o != null) {
                crashDetailBean.O0000oOo = dif.O00000o(crashDetailBean.O0000o.getBytes());
            }
            crashDetailBean.O0000ooo = dgx.O00000Oo;
            crashDetailBean.O00oOooO = this.O0000O0o.O00000oo;
            crashDetailBean.O00oOooo = "main(1)";
            crashDetailBean.O000O0oO = this.O0000O0o.O0000oo0();
            crashDetailBean.O0000OOo = this.O0000O0o.O0000oO();
            crashDetailBean.O0000Oo0 = this.O0000O0o.O000O0o0();
            crashDetailBean.O0000oo0 = dgx.O00000o;
            crashDetailBean.O000OO0o = this.O0000O0o.O0000oO;
            crashDetailBean.O000OO = this.O0000O0o.O00000o0;
            crashDetailBean.O000OOOo = this.O0000O0o.O0000oo;
            crashDetailBean.O000OOo = this.O0000O0o.O00oOoOo();
            crashDetailBean.O000OOoO = this.O0000O0o.O0000oOo;
            crashDetailBean.O000OOoo = this.O0000O0o.O0000ooo();
            crashDetailBean.O000Oo00 = this.O0000O0o.O000O0Oo();
            this.O00000oo.O00000Oo(crashDetailBean);
            crashDetailBean.O0000ooO = die.O000000o();
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
      ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0132 A[Catch:{ all -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015e A[SYNTHETIC, Splitter:B:60:0x015e] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0170 A[SYNTHETIC, Splitter:B:68:0x0170] */
    static boolean O000000o(String str, String str2, String str3) {
        String str4 = str2;
        String str5 = str3;
        dgw.O000000o O000000o2 = dgw.O000000o(str5, str);
        if (O000000o2 == null || O000000o2.O00000o == null || O000000o2.O00000o.size() <= 0) {
            did.O00000oO("not found trace dump for %s", str5);
            return false;
        }
        File file = new File(str4);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                did.O00000oO("backup file create fail %s", str4);
                return false;
            }
            BufferedWriter bufferedWriter = null;
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, false));
                try {
                    String[] strArr = O000000o2.O00000o.get("main");
                    int i = 3;
                    if (strArr != null) {
                        if (strArr.length >= 3) {
                            String str6 = strArr[0];
                            String str7 = strArr[1];
                            String str8 = strArr[2];
                            bufferedWriter2.write("\"main\" tid=" + str8 + " :\n" + str6 + "\n" + str7 + "\n\n");
                            bufferedWriter2.flush();
                        }
                    }
                    for (Map.Entry next : O000000o2.O00000o.entrySet()) {
                        if (!((String) next.getKey()).equals("main")) {
                            if (next.getValue() != null && ((String[]) next.getValue()).length >= i) {
                                String str9 = ((String[]) next.getValue())[0];
                                String str10 = ((String[]) next.getValue())[1];
                                String str11 = ((String[]) next.getValue())[2];
                                bufferedWriter2.write(jdn.f1779O000000o + ((String) next.getKey()) + "\" tid=" + str11 + " :\n" + str9 + "\n" + str10 + "\n\n");
                                bufferedWriter2.flush();
                            }
                            i = 3;
                        }
                    }
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e) {
                        IOException iOException = e;
                        if (!did.O000000o(iOException)) {
                            iOException.printStackTrace();
                        }
                    }
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    try {
                        if (!did.O000000o(e)) {
                        }
                        did.O00000oO("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter != null) {
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter2 = bufferedWriter;
                        Throwable th2 = th;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e3) {
                                IOException iOException2 = e3;
                                if (!did.O000000o(iOException2)) {
                                    iOException2.printStackTrace();
                                }
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Throwable th22 = th;
                    if (bufferedWriter2 != null) {
                    }
                    throw th22;
                }
            } catch (IOException e4) {
                e = e4;
                if (!did.O000000o(e)) {
                    e.printStackTrace();
                }
                did.O00000oO("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e5) {
                        IOException iOException3 = e5;
                        if (!did.O000000o(iOException3)) {
                            iOException3.printStackTrace();
                        }
                    }
                }
                return false;
            }
        } catch (Exception e6) {
            if (!did.O000000o(e6)) {
                e6.printStackTrace();
            }
            did.O00000oO("backup file create error! %s  %s", e6.getClass().getName() + ":" + e6.getMessage(), str4);
            return false;
        }
    }

    private synchronized void O000000o() {
        if (O00000o0()) {
            did.O00000o("start when started!", new Object[0]);
            return;
        }
        this.O0000Oo0 = new FileObserver("/data/anr/") {
            /* class _m_j.dgy.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.dgz.O000000o(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):void
             arg types: [com.tencent.bugly.crashreport.crash.CrashDetailBean, int]
             candidates:
              _m_j.dgz.O000000o(java.util.List<_m_j.dgv>, com.tencent.bugly.crashreport.crash.CrashDetailBean):com.tencent.bugly.crashreport.crash.CrashDetailBean
              _m_j.dgz.O000000o(boolean, java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean>):void
              _m_j.dgz.O000000o(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):void */
            /* JADX WARNING: Code restructure failed: missing block: B:100:0x0268, code lost:
                if (r4.O00000oo.O000000o(r2) != false) goto L_0x0270;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:101:0x026a, code lost:
                r4.O00000oo.O000000o(r2, true);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:102:0x0270, code lost:
                r4.f14624O000000o.set(0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:103:0x0275, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:104:0x0276, code lost:
                r7 = r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
                _m_j.did.O00000o("can't get all thread skip this anr", new java.lang.Object[0]);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:108:0x0281, code lost:
                r4.f14624O000000o.set(0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:109:0x0286, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:110:0x0287, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
                _m_j.did.O000000o(r0);
                _m_j.did.O00000oO("get all thread stack fail!", new java.lang.Object[0]);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:113:0x0292, code lost:
                r4.f14624O000000o.set(0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:114:0x0297, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:115:0x0298, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:116:0x029a, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:119:0x029f, code lost:
                if (_m_j.did.O000000o(r0) == false) goto L_0x02a1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:120:0x02a1, code lost:
                r0.printStackTrace();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:121:0x02a4, code lost:
                _m_j.did.O00000oO("handle anr error %s", r0.getClass().toString());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:123:0x02bb, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:124:0x02bc, code lost:
                r4.f14624O000000o.set(0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:125:0x02c1, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                _m_j.did.O00000o0("read trace first dump for create time!", new java.lang.Object[0]);
                r5 = _m_j.dgw.O000000o(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
                if (r5 == null) goto L_0x004f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
                r8 = r5.O00000o0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
                r8 = -1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
                if (r8 != -1) goto L_0x005f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
                _m_j.did.O00000o("trace dump fail could not get time!", new java.lang.Object[0]);
                r8 = java.lang.System.currentTimeMillis();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
                if (java.lang.Math.abs(r8 - r4.O00000Oo) >= 10000) goto L_0x0082;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
                _m_j.did.O00000o("should not process ANR too Fre in %d", java.lang.Integer.valueOf((int) com.google.android.exoplayer2.C.MSG_CUSTOM_BASE));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
                r4.f14624O000000o.set(0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
                r4.O00000Oo = r8;
                r4.f14624O000000o.set(1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
                r5 = _m_j.dif.O000000o(_m_j.dha.O00000oo);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
                if (r5 == null) goto L_0x027a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x0095, code lost:
                if (r5.size() > 0) goto L_0x0099;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
                r6 = r4.O00000o0;
                _m_j.did.O00000o0("to find!", new java.lang.Object[0]);
                r6 = (android.app.ActivityManager) r6.getSystemService("activity");
                r7 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ab, code lost:
                _m_j.did.O00000o0("waiting!", new java.lang.Object[0]);
                r12 = r6.getProcessesInErrorState();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b9, code lost:
                if (r12 == null) goto L_0x00db;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
                r12 = r12.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c3, code lost:
                if (r12.hasNext() == false) goto L_0x00db;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c5, code lost:
                r2 = r12.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cf, code lost:
                if (r2.condition != 2) goto L_0x00d9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
                _m_j.did.O00000o0("found!", new java.lang.Object[0]);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x00db, code lost:
                _m_j.dif.O00000Oo(500);
                r2 = r7 + 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e5, code lost:
                if (((long) r7) < 20) goto L_0x0276;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e7, code lost:
                _m_j.did.O00000o0("end!", new java.lang.Object[0]);
                r2 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ef, code lost:
                if (r2 != null) goto L_0x00fe;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f1, code lost:
                _m_j.did.O00000o0("proc state is unvisiable!", new java.lang.Object[0]);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f8, code lost:
                r4.f14624O000000o.set(0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fd, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x0104, code lost:
                if (r2.pid == android.os.Process.myPid()) goto L_0x0118;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x0106, code lost:
                _m_j.did.O00000o0("not mind proc!", r2.processName);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x0112, code lost:
                r4.f14624O000000o.set(0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x0117, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
                _m_j.did.O000000o("found visiable anr , start to process!", new java.lang.Object[0]);
                r6 = r4.O00000o0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:0x0127, code lost:
                if (r4.O00000o.O00000Oo() != false) goto L_0x0142;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x0129, code lost:
                _m_j.did.O00000oO("waiting for remote sync", new java.lang.Object[0]);
                r7 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:68:0x0137, code lost:
                if (r4.O00000o.O00000Oo() != false) goto L_0x0142;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:69:0x0139, code lost:
                _m_j.dif.O00000Oo(500);
                r7 = r7 + 500;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:70:0x0140, code lost:
                if (r7 < 3000) goto L_0x0131;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:71:0x0142, code lost:
                r7 = new java.io.File(r6.getFilesDir(), "bugly/bugly_trace_" + r8 + ".txt");
                r6 = new _m_j.dgx();
                r6.O00000o0 = r8;
                r6.O00000o = r7.getAbsolutePath();
                r6.f14623O000000o = r2.processName;
                r6.O00000oo = r2.shortMsg;
                r6.O00000oO = r2.longMsg;
                r6.O00000Oo = r5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:72:0x0179, code lost:
                if (r5 == null) goto L_0x01a0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:73:0x017b, code lost:
                r2 = r5.keySet().iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:75:0x0187, code lost:
                if (r2.hasNext() == false) goto L_0x01a0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:76:0x0189, code lost:
                r7 = r2.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
                if (r7.startsWith("main(") == false) goto L_0x0183;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:78:0x0197, code lost:
                r6.O0000O0o = r5.get(r7);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a0, code lost:
                r5 = new java.lang.Object[6];
                r5[0] = java.lang.Long.valueOf(r6.O00000o0);
                r5[1] = r6.O00000o;
                r5[2] = r6.f14623O000000o;
                r5[3] = r6.O00000oo;
                r5[4] = r6.O00000oO;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:80:0x01c3, code lost:
                if (r6.O00000Oo != null) goto L_0x01c7;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c5, code lost:
                r9 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c7, code lost:
                r9 = r6.O00000Oo.size();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:83:0x01cd, code lost:
                r5[5] = java.lang.Integer.valueOf(r9);
                _m_j.did.O00000o0("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", r5);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:84:0x01dc, code lost:
                if (r4.O00000o.O00000Oo() != false) goto L_0x01f6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:85:0x01de, code lost:
                _m_j.did.O00000oO("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new java.lang.Object[0]);
                _m_j.dgz.O000000o("ANR", _m_j.dif.O000000o(), r6.f14623O000000o, null, r6.O00000oO, null);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:87:0x01fe, code lost:
                if (r4.O00000o.O00000o0().O0000Oo != false) goto L_0x0208;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:88:0x0200, code lost:
                _m_j.did.O00000o("ANR Report is closed!", new java.lang.Object[0]);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:89:0x0208, code lost:
                _m_j.did.O000000o("found visiable anr , start to upload!", new java.lang.Object[0]);
                r2 = r4.O000000o(r6);
                _m_j.dha.O000000o();
                _m_j.dgz.O00000o0(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:90:0x021f, code lost:
                if (r2.f5815O000000o < 0) goto L_0x0229;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:91:0x0221, code lost:
                _m_j.did.O000000o("backup anr record success!", new java.lang.Object[0]);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:92:0x0229, code lost:
                _m_j.did.O00000o("backup anr record fail!", new java.lang.Object[0]);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:93:0x0230, code lost:
                if (r0 == null) goto L_0x0253;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:95:0x023b, code lost:
                if (new java.io.File(r0).exists() == false) goto L_0x0253;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:96:0x023d, code lost:
                r4.f14624O000000o.set(3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:97:0x024a, code lost:
                if (_m_j.dgy.O000000o(r0, r6.O00000o, r6.f14623O000000o) == false) goto L_0x0253;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:98:0x024c, code lost:
                _m_j.did.O000000o("backup trace success", new java.lang.Object[0]);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:99:0x0253, code lost:
                _m_j.dgz.O000000o("ANR", _m_j.dif.O000000o(), r6.f14623O000000o, null, r6.O00000oO, r2);
             */
            public final void onEvent(int i, String str) {
                if (str != null) {
                    String concat = "/data/anr/".concat(String.valueOf(str));
                    if (!concat.contains("trace")) {
                        did.O00000o("not anr file %s", concat);
                        return;
                    }
                    dgy dgy = dgy.this;
                    synchronized (dgy) {
                        if (dgy.f14624O000000o.get() != 0) {
                            did.O00000o0("trace started return ", new Object[0]);
                            return;
                        }
                        dgy.f14624O000000o.set(1);
                    }
                }
            }
        };
        try {
            this.O0000Oo0.startWatching();
            did.O000000o("start anr monitor!", new Object[0]);
            this.O0000OOo.O000000o(new Runnable() {
                /* class _m_j.dgy.AnonymousClass2 */

                public final void run() {
                    File[] listFiles;
                    dgy dgy = dgy.this;
                    long O00000Oo = dif.O00000Oo() - dha.O0000O0o;
                    File file = new File(dgy.O00000oO);
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                        int i = 0;
                        for (File file2 : listFiles) {
                            String name = file2.getName();
                            if (name.startsWith("bugly_trace_")) {
                                try {
                                    int indexOf = name.indexOf(".txt");
                                    if (indexOf > 0 && Long.parseLong(name.substring(12, indexOf)) >= O00000Oo) {
                                    }
                                } catch (Throwable unused) {
                                    did.O00000oO("tomb format error delete %s", name);
                                }
                                if (file2.delete()) {
                                    i++;
                                }
                            }
                        }
                        did.O00000o0("clean tombs %d", Integer.valueOf(i));
                    }
                }
            });
        } catch (Throwable th) {
            this.O0000Oo0 = null;
            did.O00000o("start anr monitor failed!", new Object[0]);
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
    }

    private synchronized void O00000Oo() {
        if (!O00000o0()) {
            did.O00000o("close when closed!", new Object[0]);
            return;
        }
        try {
            this.O0000Oo0.stopWatching();
            this.O0000Oo0 = null;
            did.O00000o("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            did.O00000o("stop anr monitor failed!", new Object[0]);
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
    }

    private synchronized boolean O00000o0() {
        return this.O0000Oo0 != null;
    }

    private synchronized void O00000Oo(boolean z) {
        if (z) {
            O000000o();
        } else {
            O00000Oo();
        }
    }

    private synchronized boolean O00000o() {
        return this.O0000Oo;
    }

    private synchronized void O00000o0(boolean z) {
        if (this.O0000Oo != z) {
            did.O000000o("user change anr %b", Boolean.valueOf(z));
            this.O0000Oo = z;
        }
    }

    public final void O000000o(boolean z) {
        O00000o0(z);
        boolean O00000o2 = O00000o();
        dgu O000000o2 = dgu.O000000o();
        if (O000000o2 != null) {
            O00000o2 = O00000o2 && O000000o2.O00000o0().O0000O0o;
        }
        if (O00000o2 != O00000o0()) {
            did.O000000o("anr changed to %b", Boolean.valueOf(O00000o2));
            O00000Oo(O00000o2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        return;
     */
    public final synchronized void O000000o(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.O0000Oo != O00000o0()) {
                did.O00000o("server anr changed to %b", Boolean.valueOf(strategyBean.O0000Oo));
            }
            boolean z = strategyBean.O0000Oo && O00000o();
            if (z != O00000o0()) {
                did.O000000o("anr changed to %b", Boolean.valueOf(z));
                O00000Oo(z);
            }
        }
    }
}
