package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.a.i;
import java.lang.Thread;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class dke {

    /* renamed from: O000000o  reason: collision with root package name */
    static volatile int f14738O000000o = 0;
    static volatile long O00000Oo = 0;
    private static dlp O00000o;
    static volatile long O00000o0 = 0;
    private static volatile Map<dki, Long> O00000oO = new ConcurrentHashMap();
    private static volatile Map<String, Properties> O00000oo = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static volatile Map<Integer, Integer> O0000O0o = new ConcurrentHashMap(10);
    /* access modifiers changed from: private */
    public static volatile long O0000OOo = 0;
    private static volatile long O0000Oo = 0;
    private static volatile long O0000Oo0 = 0;
    private static String O0000OoO = "";
    private static volatile int O0000Ooo = 0;
    /* access modifiers changed from: private */
    public static dlm O0000o = dlv.O00000o0();
    /* access modifiers changed from: private */
    public static volatile String O0000o0 = "";
    /* access modifiers changed from: private */
    public static volatile String O0000o00 = "";
    /* access modifiers changed from: private */
    public static Map<String, Long> O0000o0O = new ConcurrentHashMap();
    private static Map<String, Long> O0000o0o = new ConcurrentHashMap();
    private static volatile boolean O0000oO = true;
    /* access modifiers changed from: private */
    public static Thread.UncaughtExceptionHandler O0000oO0 = null;
    /* access modifiers changed from: private */
    public static Context O0000oOO = null;

    public static Properties O000000o(String str) {
        return O00000oo.get(str);
    }

    public static void O000000o(Context context) {
        if (dkd.O00000o0() && O0000Oo0(context) != null) {
            O00000o.O000000o(new dks(context, null));
        }
    }

    private static void O000000o(Context context, dkf dkf) {
        if (O0000Oo0(context) != null) {
            if (dkd.O00000Oo()) {
                O0000o.O0000O0o("start new session.");
            }
            if (dkf == null || O0000Ooo == 0) {
                O0000Ooo = dlv.O000000o();
            }
            dkd.O0000o();
            dkd.O0000oO();
            new dkv(new dkn(context, O0000Ooo, O0000Ooo(), dkf)).O000000o();
        }
    }

    public static void O000000o(Context context, String str, dkf dkf) {
        if (dkd.O00000o0()) {
            Context O0000O0o2 = O0000O0o(context);
            if (O0000O0o2 == null || str == null || str.length() == 0) {
                O0000o.O00000o("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (O0000Oo0(O0000O0o2) != null) {
                O00000o.O000000o(new dmq(str2, O0000O0o2, dkf));
            }
        }
    }

    static void O000000o(Context context, Throwable th) {
        if (dkd.O00000o0()) {
            Context O0000O0o2 = O0000O0o(context);
            if (O0000O0o2 == null) {
                O0000o.O00000o("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (O0000Oo0(O0000O0o2) != null) {
                O00000o.O000000o(new dmn(O0000O0o2, th));
            }
        }
    }

    static boolean O000000o() {
        if (f14738O000000o < 2) {
            return false;
        }
        O00000Oo = System.currentTimeMillis();
        return true;
    }

    public static boolean O000000o(Context context, String str, String str2) {
        try {
            if (!dkd.O00000o0()) {
                O0000o.O00000o("MTA StatService is disable.");
                return false;
            }
            if (dkd.O00000Oo()) {
                O0000o.O0000O0o("MTA SDK version, current: " + "2.0.3" + " ,required: " + str2);
            }
            if (context == null) {
                O0000o.O00000o("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                dkd.O000000o(false);
                return false;
            } else if (dlv.O00000Oo("2.0.3") < dlv.O00000Oo(str2)) {
                O0000o.O00000o(("MTA SDK version conflicted, current: " + "2.0.3" + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                dkd.O000000o(false);
                return false;
            } else {
                String O00000Oo2 = dkd.O00000Oo(context);
                if (O00000Oo2 == null || O00000Oo2.length() == 0) {
                    dkd.O00000Oo("-");
                }
                if (str != null) {
                    dkd.O000000o(context, str);
                }
                if (O0000Oo0(context) == null) {
                    return true;
                }
                O00000o.O000000o(new dkt(context, null));
                return true;
            }
        } catch (Throwable th) {
            O0000o.O00000Oo(th);
            return false;
        }
    }

    static void O00000Oo() {
        f14738O000000o = 0;
        O00000Oo = 0;
    }

    public static void O00000Oo(Context context) {
        if (dkd.O00000o0() && O0000Oo0(context) != null) {
            O00000o.O000000o(new dmm(context, null));
        }
    }

    public static void O00000Oo(Context context, String str, dkf dkf) {
        if (dkd.O00000o0()) {
            Context O0000O0o2 = O0000O0o(context);
            if (O0000O0o2 == null || str == null || str.length() == 0) {
                O0000o.O00000o("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (O0000Oo0(O0000O0o2) != null) {
                O00000o.O000000o(new dkr(O0000O0o2, str2, dkf));
            }
        }
    }

    public static void O00000o(Context context) {
        if (dkd.O00000o0()) {
            if (dkd.O00000Oo()) {
                O0000o.O000000o("commitEvents, maxNumber=-1");
            }
            Context O0000O0o2 = O0000O0o(context);
            if (O0000O0o2 == null) {
                O0000o.O00000o("The Context of StatService.commitEvents() can not be null!");
            } else if (dkg.O000000o(O0000oOO).O00000Oo() && O0000Oo0(O0000O0o2) != null) {
                O00000o.O000000o(new dko(O0000O0o2, -1));
            }
        }
    }

    static void O00000o0() {
        f14738O000000o++;
        O00000Oo = System.currentTimeMillis();
        O00000oO(O0000oOO);
    }

    static void O00000o0(Context context) {
        if (dkd.O00000o0()) {
            Context O0000O0o2 = O0000O0o(context);
            if (O0000O0o2 == null) {
                O0000o.O00000o("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                dmi.O00000Oo(O0000O0o2).O000000o(new i(O0000O0o2), new dmo());
            } catch (Throwable th) {
                O0000o.O00000Oo(th);
            }
        }
    }

    static void O00000oo(Context context) {
        O00000o0 = System.currentTimeMillis() + ((long) (dkd.O0000Ooo() * 60000));
        dma.O000000o(context, "last_period_ts", O00000o0);
        O00000o(context);
    }

    private static Context O0000O0o(Context context) {
        return context != null ? context : O0000oOO;
    }

    private static dlp O0000Oo0(Context context) {
        if (O00000o == null) {
            synchronized (dke.class) {
                if (O00000o == null) {
                    try {
                        O0000OOo(context);
                    } catch (Throwable th) {
                        O0000o.O000000o(th);
                        dkd.O000000o(false);
                    }
                }
            }
        }
        return O00000o;
    }

    private static JSONObject O0000Ooo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (dkd.O00000Oo.O00000o != 0) {
                jSONObject2.put("v", dkd.O00000Oo.O00000o);
            }
            jSONObject.put(Integer.toString(dkd.O00000Oo.f14783O000000o), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (dkd.f14737O000000o.O00000o != 0) {
                jSONObject3.put("v", dkd.f14737O000000o.O00000o);
            }
            jSONObject.put(Integer.toString(dkd.f14737O000000o.f14783O000000o), jSONObject3);
        } catch (JSONException e) {
            O0000o.O00000Oo((Throwable) e);
        }
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
        return;
     */
    private static synchronized void O0000OOo(Context context) {
        synchronized (dke.class) {
            if (context != null) {
                if (O00000o == null) {
                    long O000000o2 = dma.O000000o(context, dkd.O00000o0);
                    long O00000Oo2 = dlv.O00000Oo("2.0.3");
                    boolean z = true;
                    if (O00000Oo2 <= O000000o2) {
                        dlm dlm = O0000o;
                        dlm.O00000o("MTA is disable for current version:" + O00000Oo2 + ",wakeup version:" + O000000o2);
                        z = false;
                    }
                    long O000000o3 = dma.O000000o(context, dkd.O00000o);
                    if (O000000o3 > System.currentTimeMillis()) {
                        dlm dlm2 = O0000o;
                        dlm2.O00000o("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + O000000o3);
                        z = false;
                    }
                    dkd.O000000o(z);
                    if (z) {
                        Context applicationContext = context.getApplicationContext();
                        O0000oOO = applicationContext;
                        O00000o = new dlp();
                        O0000OoO = dlv.O00000oO();
                        O0000OOo = System.currentTimeMillis() + dkd.O0000Oo0;
                        O00000o.O000000o(new dml(applicationContext));
                    }
                }
            }
        }
    }

    public static int O000000o(Context context, boolean z, dkf dkf) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = z && currentTimeMillis - O0000Oo0 >= ((long) dkd.O00000o());
        O0000Oo0 = currentTimeMillis;
        if (O0000Oo == 0) {
            O0000Oo = dlv.O00000o();
        }
        if (currentTimeMillis >= O0000Oo) {
            O0000Oo = dlv.O00000o();
            if (dkz.O000000o(context).O00000Oo(context).O00000o0 != 1) {
                dkz.O000000o(context).O00000Oo(context).O00000o0 = 1;
            }
            dkd.O0000oOO();
            f14738O000000o = 0;
            O0000OoO = dlv.O00000oO();
            z2 = true;
        }
        String str = O0000OoO;
        if (dlv.O000000o(dkf)) {
            str = dkf.f14739O000000o + O0000OoO;
        }
        if (!O0000o0o.containsKey(str)) {
            z2 = true;
        }
        if (z2) {
            if (dlv.O000000o(dkf)) {
                O000000o(context, dkf);
            } else if (dkd.O0000oOo() < dkd.O0000oO0()) {
                dlv.O0000oOo(context);
                O000000o(context, (dkf) null);
            } else {
                O0000o.O00000oO("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            O0000o0o.put(str, 1L);
        }
        if (O0000oO) {
            if (dkd.O00000o0()) {
                Context O0000O0o2 = O0000O0o(context);
                if (O0000O0o2 == null) {
                    O0000o.O00000o("The Context of StatService.testSpeed() can not be null!");
                } else if (O0000Oo0(O0000O0o2) != null) {
                    O00000o.O000000o(new dkp(O0000O0o2));
                }
            }
            O0000oO = false;
        }
        return O0000Ooo;
    }

    public static void O000000o(Context context, String str, Properties properties) {
        if (dkd.O00000o0()) {
            Context O0000O0o2 = O0000O0o(context);
            if (O0000O0o2 == null) {
                O0000o.O00000o("The Context of StatService.trackCustomEvent() can not be null!");
                return;
            }
            if (str.length() == 0) {
                O0000o.O00000o("The event_id of StatService.trackCustomEvent() can not be null or empty.");
                return;
            }
            dki dki = new dki(str, null);
            if (O0000Oo0(O0000O0o2) != null) {
                O00000o.O000000o(new dmp(O0000O0o2, null, dki));
            }
        }
    }

    public static void O00000oO(Context context) {
        if (dkd.O00000o0() && dkd.O0000o0 > 0) {
            Context O0000O0o2 = O0000O0o(context);
            if (O0000O0o2 == null) {
                O0000o.O00000o("The Context of StatService.testSpeed() can not be null!");
                return;
            }
            dkz O000000o2 = dkz.O000000o(O0000O0o2);
            if (dkd.O00000o0()) {
                try {
                    O000000o2.f14757O000000o.O000000o(new dlc(O000000o2));
                } catch (Throwable th) {
                    dkz.O00000o.O00000Oo(th);
                }
            }
        }
    }
}
