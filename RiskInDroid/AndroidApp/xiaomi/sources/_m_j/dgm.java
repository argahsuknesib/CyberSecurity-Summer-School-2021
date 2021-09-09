package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class dgm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f14605O000000o = true;
    public static List<dgl> O00000Oo = new ArrayList();
    private static dhv O00000o;
    public static boolean O00000o0;
    private static boolean O00000oO;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhv.O000000o(int, java.lang.String, byte[], boolean):boolean
     arg types: [int, java.lang.String, byte[], int]
     candidates:
      _m_j.dhv.O000000o(java.lang.String, java.lang.String, java.lang.String[], _m_j.dhu):int
      _m_j.dhv.O000000o(_m_j.dhv, java.lang.String, android.content.ContentValues, _m_j.dhu):long
      _m_j.dhv.O000000o(int, java.lang.String, byte[], _m_j.dhu):boolean
      _m_j.dhv.O000000o(_m_j.dhv, int, java.lang.String, _m_j.dhu):boolean
      _m_j.dhv.O000000o(int, java.lang.String, byte[], boolean):boolean */
    public static synchronized void O000000o(Context context, String str, boolean z, dgj dgj) {
        byte[] bArr;
        synchronized (dgm.class) {
            if (O00000oO) {
                did.O00000o("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(did.f14660O000000o, "[init] context is null, check it.");
            } else {
                O00000oO = true;
                O00000o0 = true;
                did.O00000Oo = true;
                did.O00000o("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                did.O00000oO("--------------------------------------------------------------------------------------------", new Object[0]);
                did.O00000o("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                did.O00000o("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                did.O00000o("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                did.O00000o("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                did.O00000oO("--------------------------------------------------------------------------------------------", new Object[0]);
                did.O00000Oo("[init] Open debug mode of Bugly.", new Object[0]);
                did.O000000o("[init] Bugly version: v%s", "2.6.6");
                did.O000000o(" crash report start initializing...", new Object[0]);
                did.O00000Oo("[init] Bugly start initializing...", new Object[0]);
                did.O000000o("[init] Bugly complete version: v%s", "2.6.6");
                Context O000000o2 = dif.O000000o(context);
                dgs O000000o3 = dgs.O000000o(O000000o2);
                O000000o3.O0000o();
                die.O000000o(O000000o2);
                O00000o = dhv.O000000o(O000000o2, O00000Oo);
                dia.O000000o(O000000o2);
                dgu O000000o4 = dgu.O000000o(O000000o2, O00000Oo);
                dht O000000o5 = dht.O000000o(O000000o2);
                List<String> list = O000000o3.O0000oOO;
                O000000o3.getClass();
                if (list != null && list.contains("bugly")) {
                    f14605O000000o = false;
                    return;
                }
                O000000o3.O0000o0o = str;
                did.O000000o("[param] Set APP ID:%s", str);
                String O00000o2 = dgj.O00000o();
                if (!TextUtils.isEmpty(O00000o2)) {
                    if (O00000o2.length() > 100) {
                        String substring = O00000o2.substring(0, 100);
                        did.O00000o("appVersion %s length is over limit %d substring to %s", O00000o2, 100, substring);
                        O00000o2 = substring;
                    }
                    O000000o3.O0000o0 = O00000o2;
                    did.O000000o("[param] Set App version: %s", dgj.O00000o());
                }
                try {
                    if (dgj.f14603O000000o) {
                        String O00000oo = dgj.O00000oo();
                        if (!TextUtils.isEmpty(O00000oo)) {
                            if (O00000oo.length() > 100) {
                                String substring2 = O00000oo.substring(0, 100);
                                did.O00000o("appChannel %s length is over limit %d substring to %s", O00000oo, 100, substring2);
                                O00000oo = substring2;
                            }
                            O00000o.O000000o(556, "app_channel", O00000oo.getBytes(), false);
                            O000000o3.O0000o = O00000oo;
                        }
                    } else {
                        Map<String, byte[]> O000000o6 = O00000o.O000000o(556, (dhu) null);
                        if (!(O000000o6 == null || (bArr = O000000o6.get("app_channel")) == null)) {
                            O000000o3.O0000o = new String(bArr);
                        }
                    }
                    did.O000000o("[param] Set App channel: %s", O000000o3.O0000o);
                } catch (Exception e) {
                    if (O00000o0) {
                        e.printStackTrace();
                    }
                }
                String O0000O0o = dgj.O0000O0o();
                if (!TextUtils.isEmpty(O0000O0o)) {
                    if (O0000O0o.length() > 100) {
                        String substring3 = O0000O0o.substring(0, 100);
                        did.O00000o("appPackageName %s length is over limit %d substring to %s", O0000O0o, 100, substring3);
                        O0000O0o = substring3;
                    }
                    O000000o3.O00000oO = O0000O0o;
                    did.O000000o("[param] Set App package: %s", dgj.O0000O0o());
                }
                String O0000Oo = dgj.O0000Oo();
                if (O0000Oo != null) {
                    if (O0000Oo.length() > 100) {
                        String substring4 = O0000Oo.substring(0, 100);
                        did.O00000o("deviceId %s length is over limit %d substring to %s", O0000Oo, 100, substring4);
                        O0000Oo = substring4;
                    }
                    O000000o3.O0000OoO = O0000Oo;
                    synchronized (O000000o3.O000OOoO) {
                        O000000o3.O0000oo0.put("E8", O0000Oo);
                    }
                    did.O000000o("s[param] Set device ID: %s", O0000Oo);
                }
                O000000o3.O0000O0o = dgj.O000000o();
                die.f14661O000000o = dgj.O00000Oo();
                dgq.O000000o(O000000o2, dgj);
                for (int i = 0; i < O00000Oo.size(); i++) {
                    try {
                        if (O000000o5.O00000Oo(O00000Oo.get(i).f14604O000000o)) {
                            O00000Oo.get(i).O000000o(O000000o2, true, dgj);
                        }
                    } catch (Throwable th) {
                        if (!did.O000000o(th)) {
                            th.printStackTrace();
                        }
                    }
                }
                O000000o4.O00000Oo.O000000o(new Thread() {
                    /* class _m_j.dgu.AnonymousClass1 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.dgu.O000000o(com.tencent.bugly.crashreport.common.strategy.StrategyBean, boolean):void
                     arg types: [com.tencent.bugly.crashreport.common.strategy.StrategyBean, int]
                     candidates:
                      _m_j.dgu.O000000o(android.content.Context, java.util.List<_m_j.dgl>):_m_j.dgu
                      _m_j.dgu.O000000o(_m_j.dgu, com.tencent.bugly.crashreport.common.strategy.StrategyBean):com.tencent.bugly.crashreport.common.strategy.StrategyBean
                      _m_j.dgu.O000000o(com.tencent.bugly.crashreport.common.strategy.StrategyBean, boolean):void */
                    public final void run() {
                        try {
                            Map<String, byte[]> O000000o2 = dhv.O000000o().O000000o(dgu.f14617O000000o, (dhu) null);
                            if (O000000o2 != null) {
                                byte[] bArr = O000000o2.get("key_imei");
                                byte[] bArr2 = O000000o2.get("key_ip");
                                if (bArr != null) {
                                    dgs.O000000o(dgu.this.O0000O0o).O00000Oo(new String(bArr));
                                }
                                if (bArr2 != null) {
                                    dgs.O000000o(dgu.this.O0000O0o).O000000o(new String(bArr2));
                                }
                            }
                            StrategyBean unused = dgu.this.O00000oo = dgu.O00000o();
                            if (dgu.this.O00000oo != null && !dif.O000000o(dgu.O00000oO()) && dif.O00000Oo(dgu.O00000oO())) {
                                dgu.this.O00000oo.O0000oO0 = dgu.O00000oO();
                                dgu.this.O00000oo.O0000oO = dgu.O00000oO();
                            }
                        } catch (Throwable th) {
                            if (!did.O000000o(th)) {
                                th.printStackTrace();
                            }
                        }
                        dgu dgu = dgu.this;
                        dgu.O000000o(dgu.O00000oo, false);
                    }
                }, dgj.O0000OOo());
                did.O00000Oo("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    public static synchronized void O000000o(dgl dgl) {
        synchronized (dgm.class) {
            if (!O00000Oo.contains(dgl)) {
                O00000Oo.add(dgl);
            }
        }
    }
}
