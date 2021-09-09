package _m_j;

import _m_j.dgj;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class dgk extends dgl {
    private static int O00000oo = 0;
    private static boolean O0000O0o = false;
    private static dgk O0000OOo = new dgk();
    private long O00000o;
    private dgj.O000000o O00000oO;

    public static dgk O000000o() {
        dgk dgk = O0000OOo;
        dgk.f14604O000000o = 1004;
        return dgk;
    }

    public static boolean O00000Oo() {
        return O0000O0o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    public final synchronized void O000000o(Context context, boolean z, dgj dgj) {
        if (context != null) {
            if (!O0000O0o) {
                did.O000000o("Initializing crash module.", new Object[0]);
                dht O000000o2 = dht.O000000o();
                int i = O00000oo + 1;
                O00000oo = i;
                O000000o2.O000000o(i);
                O0000O0o = true;
                CrashReport.f5809O000000o = context;
                O000000o(context, dgj);
                dha.O000000o(context, z, this.O00000oO);
                dha O000000o3 = dha.O000000o();
                O000000o3.O0000o0o.O000000o();
                if (dgj != null) {
                    if (!dgj.O0000OoO()) {
                        did.O000000o("[crash] Closed native crash monitor!", new Object[0]);
                        O000000o3.O0000o.O00000Oo(false);
                        if (dgj != null) {
                            if (!dgj.O0000o00()) {
                                did.O000000o("[crash] Closed ANR monitor!", new Object[0]);
                                O000000o3.O0000oO.O000000o(false);
                                dhb.O000000o(context);
                                BuglyBroadcastRecevier O000000o4 = BuglyBroadcastRecevier.O000000o();
                                O000000o4.O000000o("android.net.conn.CONNECTIVITY_CHANGE");
                                O000000o4.O000000o(context);
                                dht O000000o5 = dht.O000000o();
                                int i2 = O00000oo - 1;
                                O00000oo = i2;
                                O000000o5.O000000o(i2);
                            }
                        }
                        O000000o3.O0000oO.O000000o(true);
                        dhb.O000000o(context);
                        BuglyBroadcastRecevier O000000o42 = BuglyBroadcastRecevier.O000000o();
                        O000000o42.O000000o("android.net.conn.CONNECTIVITY_CHANGE");
                        O000000o42.O000000o(context);
                        dht O000000o52 = dht.O000000o();
                        int i22 = O00000oo - 1;
                        O00000oo = i22;
                        O000000o52.O000000o(i22);
                    }
                }
                O000000o3.O0000o.O00000Oo(true);
                if (dgj != null) {
                }
                O000000o3.O0000oO.O000000o(true);
                dhb.O000000o(context);
                BuglyBroadcastRecevier O000000o422 = BuglyBroadcastRecevier.O000000o();
                O000000o422.O000000o("android.net.conn.CONNECTIVITY_CHANGE");
                O000000o422.O000000o(context);
                dht O000000o522 = dht.O000000o();
                int i222 = O00000oo - 1;
                O00000oo = i222;
                O000000o522.O000000o(i222);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        return;
     */
    private synchronized void O000000o(Context context, dgj dgj) {
        if (dgj != null) {
            String O0000Oo0 = dgj.O0000Oo0();
            if (!TextUtils.isEmpty(O0000Oo0)) {
                dgs.O000000o(context).O0000oO0 = O0000Oo0;
                did.O000000o("setted libBugly.so file path :%s", O0000Oo0);
            }
            if (dgj.O0000o0() != null) {
                this.O00000oO = dgj.O0000o0();
                did.O000000o("setted CrashHanldeCallback", new Object[0]);
            }
            if (dgj.O0000OOo() > 0) {
                this.O00000o = dgj.O0000OOo();
                did.O000000o("setted delay: %d", Long.valueOf(this.O00000o));
            }
        }
    }

    public final void O000000o(StrategyBean strategyBean) {
        dha O000000o2;
        if (strategyBean != null && (O000000o2 = dha.O000000o()) != null) {
            O000000o2.O0000o0o.O000000o(strategyBean);
            O000000o2.O0000o.O000000o(strategyBean);
            O000000o2.O0000oO.O000000o(strategyBean);
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

    public final String[] O00000o0() {
        return new String[]{"t_cr"};
    }
}
