package _m_j;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ap;
import java.util.List;

public final class dgu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f14617O000000o = 1000;
    private static dgu O00000o0;
    private static String O0000OOo;
    public final dic O00000Oo;
    private final List<dgl> O00000o;
    private final StrategyBean O00000oO;
    /* access modifiers changed from: private */
    public StrategyBean O00000oo = null;
    /* access modifiers changed from: private */
    public Context O0000O0o;

    static /* synthetic */ String O00000oO() {
        return null;
    }

    private dgu(Context context, List<dgl> list) {
        this.O0000O0o = context;
        this.O00000oO = new StrategyBean();
        this.O00000o = list;
        this.O00000Oo = dic.O000000o();
    }

    public static synchronized dgu O000000o(Context context, List<dgl> list) {
        dgu dgu;
        synchronized (dgu.class) {
            if (O00000o0 == null) {
                O00000o0 = new dgu(context, list);
            }
            dgu = O00000o0;
        }
        return dgu;
    }

    public static synchronized dgu O000000o() {
        dgu dgu;
        synchronized (dgu.class) {
            dgu = O00000o0;
        }
        return dgu;
    }

    public final synchronized boolean O00000Oo() {
        return this.O00000oo != null;
    }

    public final StrategyBean O00000o0() {
        StrategyBean strategyBean = this.O00000oo;
        if (strategyBean != null) {
            return strategyBean;
        }
        return this.O00000oO;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(StrategyBean strategyBean, boolean z) {
        did.O00000o0("[Strategy] Notify %s", dgq.class.getName());
        dgq.O000000o(strategyBean, z);
        for (dgl next : this.O00000o) {
            try {
                did.O00000o0("[Strategy] Notify %s", next.getClass().getName());
                next.O000000o(strategyBean);
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dgu.O000000o(com.tencent.bugly.crashreport.common.strategy.StrategyBean, boolean):void
     arg types: [com.tencent.bugly.crashreport.common.strategy.StrategyBean, int]
     candidates:
      _m_j.dgu.O000000o(android.content.Context, java.util.List<_m_j.dgl>):_m_j.dgu
      _m_j.dgu.O000000o(_m_j.dgu, com.tencent.bugly.crashreport.common.strategy.StrategyBean):com.tencent.bugly.crashreport.common.strategy.StrategyBean
      _m_j.dgu.O000000o(com.tencent.bugly.crashreport.common.strategy.StrategyBean, boolean):void */
    public final void O000000o(ap apVar) {
        if (apVar != null) {
            if (this.O00000oo == null || apVar.h != this.O00000oo.O0000o0o) {
                StrategyBean strategyBean = new StrategyBean();
                strategyBean.O0000O0o = apVar.f5833a;
                strategyBean.O0000Oo0 = apVar.c;
                strategyBean.O0000OOo = apVar.b;
                if (dif.O000000o((String) null) || !dif.O00000Oo((String) null)) {
                    if (dif.O00000Oo(apVar.d)) {
                        did.O00000o0("[Strategy] Upload url changes to %s", apVar.d);
                        strategyBean.O0000oO0 = apVar.d;
                    }
                    if (dif.O00000Oo(apVar.e)) {
                        did.O00000o0("[Strategy] Exception upload url changes to %s", apVar.e);
                        strategyBean.O0000oO = apVar.e;
                    }
                }
                if (apVar.f != null && !dif.O000000o(apVar.f.f5831a)) {
                    strategyBean.O0000oOo = apVar.f.f5831a;
                }
                if (apVar.h != 0) {
                    strategyBean.O0000o0o = apVar.h;
                }
                if (apVar.g != null && apVar.g.size() > 0) {
                    strategyBean.O0000oo0 = apVar.g;
                    String str = apVar.g.get("B11");
                    if (str == null || !str.equals("1")) {
                        strategyBean.O0000Oo = false;
                    } else {
                        strategyBean.O0000Oo = true;
                    }
                    String str2 = apVar.g.get("B3");
                    if (str2 != null) {
                        strategyBean.O0000ooo = Long.valueOf(str2).longValue();
                    }
                    strategyBean.O0000o = (long) apVar.i;
                    strategyBean.O0000ooO = (long) apVar.i;
                    String str3 = apVar.g.get("B27");
                    if (str3 != null && str3.length() > 0) {
                        try {
                            int parseInt = Integer.parseInt(str3);
                            if (parseInt > 0) {
                                strategyBean.O0000oo = parseInt;
                            }
                        } catch (Exception e) {
                            if (!did.O000000o(e)) {
                                e.printStackTrace();
                            }
                        }
                    }
                    String str4 = apVar.g.get("B25");
                    if (str4 == null || !str4.equals("1")) {
                        strategyBean.O0000Ooo = false;
                    } else {
                        strategyBean.O0000Ooo = true;
                    }
                }
                did.O000000o("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.O0000O0o), Boolean.valueOf(strategyBean.O0000Oo0), Boolean.valueOf(strategyBean.O0000OOo), Boolean.valueOf(strategyBean.O0000Oo), Boolean.valueOf(strategyBean.O0000OoO), Boolean.valueOf(strategyBean.O0000o0), Boolean.valueOf(strategyBean.O0000o0O), Long.valueOf(strategyBean.O0000o), Boolean.valueOf(strategyBean.O0000Ooo), Long.valueOf(strategyBean.O0000o0o));
                this.O00000oo = strategyBean;
                dhv.O000000o().O00000Oo(2);
                dhx dhx = new dhx();
                dhx.O00000Oo = 2;
                dhx.f14652O000000o = strategyBean.O00000oO;
                dhx.O00000oO = strategyBean.O00000oo;
                dhx.O0000O0o = dif.O000000o(strategyBean);
                dhv.O000000o().O000000o(dhx);
                O000000o(strategyBean, true);
            }
        }
    }

    public static StrategyBean O00000o() {
        List<dhx> O000000o2 = dhv.O000000o().O000000o(2);
        if (O000000o2 == null || O000000o2.size() <= 0) {
            return null;
        }
        dhx dhx = O000000o2.get(0);
        if (dhx.O0000O0o != null) {
            return (StrategyBean) dif.O000000o(dhx.O0000O0o, StrategyBean.CREATOR);
        }
        return null;
    }
}
