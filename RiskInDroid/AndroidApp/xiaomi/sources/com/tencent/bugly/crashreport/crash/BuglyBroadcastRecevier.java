package com.tencent.bugly.crashreport.crash;

import _m_j.dgp;
import _m_j.dgq;
import _m_j.dgs;
import _m_j.dgt;
import _m_j.dgu;
import _m_j.dha;
import _m_j.dia;
import _m_j.dic;
import _m_j.did;
import _m_j.dif;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BuglyBroadcastRecevier extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public static BuglyBroadcastRecevier O00000o;
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public IntentFilter f5813O000000o = new IntentFilter();
    /* access modifiers changed from: private */
    public Context O00000Oo;
    private String O00000o0;
    private boolean O00000oO = true;

    public static synchronized BuglyBroadcastRecevier O000000o() {
        BuglyBroadcastRecevier buglyBroadcastRecevier;
        synchronized (BuglyBroadcastRecevier.class) {
            if (O00000o == null) {
                O00000o = new BuglyBroadcastRecevier();
            }
            buglyBroadcastRecevier = O00000o;
        }
        return buglyBroadcastRecevier;
    }

    public final synchronized void O000000o(String str) {
        if (!this.f5813O000000o.hasAction(str)) {
            this.f5813O000000o.addAction(str);
        }
        did.O00000o0("add action %s", str);
    }

    public final synchronized void O000000o(Context context) {
        this.O00000Oo = context;
        dif.O000000o(new Runnable() {
            /* class com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.AnonymousClass1 */

            public final void run() {
                try {
                    did.O000000o(BuglyBroadcastRecevier.O00000o.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastRecevier.this.O00000Oo.registerReceiver(BuglyBroadcastRecevier.O00000o, BuglyBroadcastRecevier.this.f5813O000000o);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final synchronized void O00000Oo(Context context) {
        try {
            did.O000000o(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.O00000Oo = context;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            O000000o(context, intent);
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c4, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d2, code lost:
        return false;
     */
    private synchronized boolean O000000o(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.O00000oO) {
                    this.O00000oO = false;
                    return true;
                }
                String O00000oo = dgt.O00000oo(this.O00000Oo);
                did.O00000o0("is Connect BC ".concat(String.valueOf(O00000oo)), new Object[0]);
                did.O000000o("network %s changed to %s", this.O00000o0, String.valueOf(O00000oo));
                if (O00000oo == null) {
                    this.O00000o0 = null;
                    return true;
                }
                String str = this.O00000o0;
                this.O00000o0 = O00000oo;
                long currentTimeMillis = System.currentTimeMillis();
                dgu O000000o2 = dgu.O000000o();
                dia O000000o3 = dia.O000000o();
                dgs O000000o4 = dgs.O000000o(context);
                if (!(O000000o2 == null || O000000o3 == null)) {
                    if (O000000o4 != null) {
                        if (!O00000oo.equals(str)) {
                            if (currentTimeMillis - O000000o3.O000000o(dha.f14631O000000o) > DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                                did.O000000o("try to upload crash on network changed.", new Object[0]);
                                dha O000000o5 = dha.O000000o();
                                if (O000000o5 != null) {
                                    dic.O000000o().O000000o(new Thread() {
                                        /* class _m_j.dha.AnonymousClass2 */

                                        public final void run() {
                                            ArrayList arrayList;
                                            if (dif.O000000o(dha.this.O0000oOO, "local_crash_lock", 10000)) {
                                                StrategyBean O00000o0 = dgu.O000000o().O00000o0();
                                                List<CrashDetailBean> list = null;
                                                if (O00000o0 == null) {
                                                    did.O00000o("have not synced remote!", new Object[0]);
                                                } else if (!O00000o0.O0000O0o) {
                                                    did.O00000o("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
                                                    did.O00000Oo("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
                                                } else {
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    long O00000Oo = dif.O00000Oo();
                                                    List<dgv> O000000o2 = dgz.O000000o();
                                                    if (O000000o2 != null && O000000o2.size() > 0) {
                                                        ArrayList arrayList2 = new ArrayList();
                                                        Iterator<dgv> it = O000000o2.iterator();
                                                        while (it.hasNext()) {
                                                            dgv next = it.next();
                                                            if (next.O00000Oo < O00000Oo - dha.O0000O0o) {
                                                                it.remove();
                                                                arrayList2.add(next);
                                                            } else if (next.O00000o) {
                                                                if (next.O00000Oo >= currentTimeMillis - 86400000) {
                                                                    it.remove();
                                                                } else if (!next.O00000oO) {
                                                                    it.remove();
                                                                    arrayList2.add(next);
                                                                }
                                                            } else if (((long) next.O00000oo) >= 3 && next.O00000Oo < currentTimeMillis - 86400000) {
                                                                it.remove();
                                                                arrayList2.add(next);
                                                            }
                                                        }
                                                        if (arrayList2.size() > 0) {
                                                            dgz.O00000Oo(arrayList2);
                                                        }
                                                        ArrayList arrayList3 = new ArrayList();
                                                        List<CrashDetailBean> O000000o3 = dgz.O000000o(O000000o2);
                                                        if (O000000o3 != null && O000000o3.size() > 0) {
                                                            String str = dgs.O000000o().O0000o0;
                                                            Iterator<CrashDetailBean> it2 = O000000o3.iterator();
                                                            while (it2.hasNext()) {
                                                                CrashDetailBean next2 = it2.next();
                                                                if (!str.equals(next2.O00000oo)) {
                                                                    it2.remove();
                                                                    arrayList3.add(next2);
                                                                }
                                                            }
                                                        }
                                                        if (arrayList3.size() > 0) {
                                                            dgz.O00000o0(arrayList3);
                                                        }
                                                        list = O000000o3;
                                                    }
                                                }
                                                if (list != null && list.size() > 0) {
                                                    int size = list.size();
                                                    if (((long) size) > 100) {
                                                        ArrayList arrayList4 = new ArrayList();
                                                        Collections.sort(list);
                                                        for (int i = 0; ((long) i) < 100; i++) {
                                                            arrayList4.add(list.get((size - 1) - i));
                                                        }
                                                        arrayList = arrayList4;
                                                    } else {
                                                        arrayList = list;
                                                    }
                                                    dha.this.O0000o0O.O000000o(arrayList, 0, false, false, false);
                                                }
                                                dif.O00000Oo(dha.this.O0000oOO, "local_crash_lock");
                                            }
                                        }
                                    }, 0);
                                }
                            }
                            if (currentTimeMillis - O000000o3.O000000o(1001) > DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                                did.O000000o("try to upload userinfo on network changed.", new Object[0]);
                                dgp dgp = dgq.f14612O000000o;
                                dic O000000o6 = dic.O000000o();
                                if (O000000o6 != null) {
                                    O000000o6.O000000o(new Runnable() {
                                        /* class _m_j.dgp.AnonymousClass2 */

                                        public final void run() {
                                            try {
                                                dgp.this.O00000Oo();
                                            } catch (Throwable th) {
                                                did.O000000o(th);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
                did.O00000o("not inited BC not work", new Object[0]);
                return true;
            }
        }
    }
}
