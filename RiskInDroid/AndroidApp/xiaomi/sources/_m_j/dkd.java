package _m_j;

import android.content.Context;
import android.os.Build;
import com.tencent.wxop.stat.StatReportStrategy;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class dkd {

    /* renamed from: O000000o  reason: collision with root package name */
    static dmf f14737O000000o = new dmf(2);
    static dmf O00000Oo = new dmf(1);
    static String O00000o = "__HIBERNATE__TIME";
    static String O00000o0 = "__HIBERNATE__";
    static String O00000oO = "__MTA_KILL__";
    static String O00000oo = "";
    static boolean O0000O0o = false;
    static int O0000OOo = 100;
    static boolean O0000Oo = true;
    static long O0000Oo0 = 10000;
    public static boolean O0000OoO = true;
    static volatile String O0000Ooo = "pingma.qq.com:80";
    private static dlm O0000o = dlv.O00000o0();
    static int O0000o0 = 0;
    static boolean O0000o00 = true;
    static long O0000o0O = 10000;
    static int O0000o0o = 512;
    private static boolean O0000oO = false;
    private static StatReportStrategy O0000oO0 = StatReportStrategy.APP_LAUNCH;
    private static boolean O0000oOO = true;
    private static int O0000oOo = 30000;
    private static int O0000oo = 30;
    private static int O0000oo0 = 100000;
    private static int O0000ooO = 10;
    private static int O0000ooo = 100;
    private static String O000O00o = null;
    private static String O000O0OO;
    private static String O000O0Oo;
    private static int O000O0o = 1024;
    private static int O000O0o0 = 180;
    private static long O000O0oO = 0;
    private static long O000O0oo = 300000;
    private static volatile int O000OO = 0;
    private static volatile String O000OO00 = "http://pingma.qq.com:80/mstat/report";
    private static int O000OO0o = 0;
    private static int O000OOOo = 20;
    private static boolean O000OOo = false;
    private static int O000OOo0 = 0;
    private static int O000OOoO = 4096;
    private static boolean O000OOoo = false;
    private static boolean O000Oo0 = false;
    private static String O000Oo00 = null;
    private static dmg O000Oo0O = null;
    private static String O00oOoOo = "mta_channel";
    private static int O00oOooO = 30;
    private static int O00oOooo = 1;

    public static StatReportStrategy O000000o() {
        return O0000oO0;
    }

    public static synchronized String O000000o(Context context) {
        synchronized (dkd.class) {
            if (O000O0OO != null) {
                String str = O000O0OO;
                return str;
            }
            if (context != null) {
                if (O000O0OO == null) {
                    O000O0OO = dlv.O00000oo(context);
                }
            }
            if (O000O0OO == null || O000O0OO.trim().length() == 0) {
                O0000o.O00000o("AppKey can not be null or empty, please read Developer's Guide first!");
            }
            String str2 = O000O0OO;
            return str2;
        }
    }

    public static String O000000o(String str) {
        try {
            String string = O00000Oo.O00000Oo.getString(str);
            if (string != null) {
                return string;
            }
            return null;
        } catch (Throwable unused) {
            O0000o.O00000o0("can't find custom key:".concat(String.valueOf(str)));
            return null;
        }
    }

    private static void O000000o(long j) {
        dma.O000000o(dmi.O000000o(), O00000o0, j);
        O000000o(false);
        O0000o.O00000Oo("MTA is disable for current SDK version");
    }

    static void O000000o(Context context, dmf dmf) {
        if (dmf.f14783O000000o == O00000Oo.f14783O000000o) {
            O00000Oo = dmf;
            O000000o(dmf.O00000Oo);
            if (!O00000Oo.O00000Oo.isNull("iplist")) {
                dkg.O000000o(context).O000000o(O00000Oo.O00000Oo.getString("iplist"));
            }
        } else if (dmf.f14783O000000o == f14737O000000o.f14783O000000o) {
            f14737O000000o = dmf;
        }
    }

    private static void O000000o(Context context, dmf dmf, JSONObject jSONObject) {
        boolean z = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(next);
                    if (dmf.O00000o != i) {
                        z = true;
                    }
                    dmf.O00000o = i;
                } else if (next.equalsIgnoreCase("c")) {
                    String string = jSONObject.getString("c");
                    if (string.length() > 0) {
                        dmf.O00000Oo = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase("m")) {
                    dmf.O00000o0 = jSONObject.getString("m");
                }
            }
            if (z) {
                dkz O000000o2 = dkz.O000000o(dmi.O000000o());
                if (O000000o2 != null) {
                    O000000o2.O000000o(dmf);
                }
                if (dmf.f14783O000000o == O00000Oo.f14783O000000o) {
                    O000000o(dmf.O00000Oo);
                    O00000Oo(dmf.O00000Oo);
                }
            }
            O000000o(context, dmf);
        } catch (Throwable th) {
            O0000o.O00000Oo(th);
        }
    }

    public static void O000000o(boolean z) {
        O0000oOO = z;
        if (!z) {
            O0000o.O00000Oo("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    private static boolean O000000o(JSONObject jSONObject, String str, String str2) {
        if (jSONObject.isNull(str)) {
            return false;
        }
        String optString = jSONObject.optString(str);
        return dlv.O00000o0(str2) && dlv.O00000o0(optString) && str2.equalsIgnoreCase(optString);
    }

    public static synchronized String O00000Oo(Context context) {
        synchronized (dkd.class) {
            if (O000O0Oo != null) {
                String str = O000O0Oo;
                return str;
            }
            String O000000o2 = dma.O000000o(context, O00oOoOo, "");
            O000O0Oo = O000000o2;
            if (O000000o2 == null || O000O0Oo.trim().length() == 0) {
                O000O0Oo = dlv.O0000O0o(context);
            }
            if (O000O0Oo == null || O000O0Oo.trim().length() == 0) {
                O0000o.O00000o0("installChannel can not be null or empty, please read Developer's Guide first!");
            }
            String str2 = O000O0Oo;
            return str2;
        }
    }

    public static void O00000Oo(Context context, String str) {
        if (str.length() > 128) {
            O0000o.O00000o("the length of installChannel can not exceed the range of 128 bytes.");
            return;
        }
        O000O0Oo = str;
        dma.O00000Oo(context, O00oOoOo, str);
    }

    public static void O00000Oo(String str) {
        if (str.length() > 128) {
            O0000o.O00000o("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            O000O0Oo = str;
        }
    }

    public static boolean O00000Oo() {
        return O0000oO;
    }

    public static int O00000o() {
        return O0000oOo;
    }

    public static String O00000o(Context context) {
        if (context == null) {
            O0000o.O00000o("Context for getCustomUid is null.");
            return null;
        }
        if (O000Oo00 == null) {
            O000Oo00 = dma.O000000o(context, "MTA_CUSTOM_UID", "");
        }
        return O000Oo00;
    }

    private static boolean O00000o(String str) {
        if (str == null) {
            return false;
        }
        String str2 = O000O0OO;
        if (str2 == null) {
            O000O0OO = str;
            return true;
        } else if (str2.contains(str)) {
            return false;
        } else {
            O000O0OO += "|" + str;
            return true;
        }
    }

    public static String O00000o0(Context context) {
        return dma.O000000o(context, "mta.acc.qq", O00000oo);
    }

    public static boolean O00000o0() {
        return O0000oOO;
    }

    public static int O00000oO() {
        return O0000ooo;
    }

    public static int O00000oo() {
        return O00oOooO;
    }

    public static int O0000O0o() {
        return O0000ooO;
    }

    public static int O0000OOo() {
        return O00oOooo;
    }

    public static int O0000Oo() {
        return O0000oo0;
    }

    static int O0000Oo0() {
        return O0000oo;
    }

    public static void O0000OoO() {
        O000O0o0 = 60;
    }

    public static int O0000Ooo() {
        return O000O0o0;
    }

    static synchronized void O0000o() {
        synchronized (dkd.class) {
            O000OO = 0;
        }
    }

    public static void O0000o0() {
        O0000Oo = true;
    }

    public static int O0000o00() {
        return O000O0o;
    }

    public static boolean O0000o0O() {
        return O0000OoO;
    }

    public static String O0000o0o() {
        return O000OO00;
    }

    static void O0000oO() {
        O000OOo0++;
    }

    public static int O0000oO0() {
        return O000OOOo;
    }

    static void O0000oOO() {
        O000OOo0 = 0;
    }

    static int O0000oOo() {
        return O000OOo0;
    }

    public static dmg O0000oo() {
        return O000Oo0O;
    }

    public static boolean O0000oo0() {
        return O000OOoo;
    }

    public static void O000000o(StatReportStrategy statReportStrategy) {
        O0000oO0 = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            dke.O00000o0 = 0;
        }
        if (O0000oO) {
            O0000o.O0000O0o("Change to statSendStrategy: ".concat(String.valueOf(statReportStrategy)));
        }
    }

    static void O000000o(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        dmf dmf;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(O00000Oo.f14783O000000o))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    dmf = O00000Oo;
                } else if (next.equalsIgnoreCase(Integer.toString(f14737O000000o.f14783O000000o))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    dmf = f14737O000000o;
                } else if (next.equalsIgnoreCase("rs")) {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(next));
                    if (statReportStrategy != null) {
                        O0000oO0 = statReportStrategy;
                        if (O0000oO) {
                            dlm dlm = O0000o;
                            dlm.O0000O0o("Change to ReportStrategy:" + statReportStrategy.name());
                        }
                    }
                } else {
                    return;
                }
                O000000o(context, dmf, jSONObject2);
            }
        } catch (JSONException e) {
            O0000o.O00000Oo((Throwable) e);
        }
    }

    private static void O000000o(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                O000000o(statReportStrategy);
            }
        } catch (JSONException unused) {
            if (O0000oO) {
                O0000o.O000000o("rs not found.");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[Catch:{ Exception -> 0x01ab }] */
    private static void O00000Oo(Context context, JSONObject jSONObject) {
        int i;
        Integer valueOf;
        try {
            String optString = jSONObject.optString(O00000oO);
            if (dlv.O00000o0(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.length() != 0) {
                    boolean z = false;
                    if (!jSONObject2.isNull("sm")) {
                        Object obj = jSONObject2.get("sm");
                        if (obj instanceof Integer) {
                            valueOf = (Integer) obj;
                        } else if (obj instanceof String) {
                            valueOf = Integer.valueOf((String) obj);
                        } else {
                            i = 0;
                            if (i > 0) {
                                if (O0000oO) {
                                    dlm dlm = O0000o;
                                    dlm.O000000o("match sleepTime:" + i + " minutes");
                                }
                                dma.O000000o(context, O00000o, System.currentTimeMillis() + ((long) (i * 60 * 1000)));
                                O000000o(false);
                                O0000o.O00000Oo("MTA is disable for current SDK version");
                            }
                        }
                        i = valueOf.intValue();
                        if (i > 0) {
                        }
                    }
                    boolean z2 = true;
                    if (O000000o(jSONObject2, "sv", "2.0.3")) {
                        O0000o.O000000o("match sdk version:2.0.3");
                        z = true;
                    }
                    if (O000000o(jSONObject2, "md", Build.MODEL)) {
                        dlm dlm2 = O0000o;
                        dlm2.O000000o("match MODEL:" + Build.MODEL);
                        z = true;
                    }
                    if (O000000o(jSONObject2, "av", dlv.O0000Oo(context))) {
                        dlm dlm3 = O0000o;
                        dlm3.O000000o("match app version:" + dlv.O0000Oo(context));
                        z = true;
                    }
                    if (O000000o(jSONObject2, "mf", Build.MANUFACTURER)) {
                        dlm dlm4 = O0000o;
                        dlm4.O000000o("match MANUFACTURER:" + Build.MANUFACTURER);
                        z = true;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(Build.VERSION.SDK_INT);
                    if (O000000o(jSONObject2, "osv", sb.toString())) {
                        dlm dlm5 = O0000o;
                        dlm5.O000000o("match android SDK version:" + Build.VERSION.SDK_INT);
                        z = true;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Build.VERSION.SDK_INT);
                    if (O000000o(jSONObject2, "ov", sb2.toString())) {
                        dlm dlm6 = O0000o;
                        dlm6.O000000o("match android SDK version:" + Build.VERSION.SDK_INT);
                        z = true;
                    }
                    if (O000000o(jSONObject2, "ui", dkz.O000000o(context).O00000Oo(context).f14771O000000o)) {
                        dlm dlm7 = O0000o;
                        dlm7.O000000o("match imei:" + dkz.O000000o(context).O00000Oo(context).f14771O000000o);
                        z = true;
                    }
                    if (O000000o(jSONObject2, "mid", O00000oO(context))) {
                        dlm dlm8 = O0000o;
                        dlm8.O000000o("match mid:" + O00000oO(context));
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        O000000o(dlv.O00000Oo("2.0.3"));
                    }
                }
            }
        } catch (Exception e) {
            O0000o.O00000Oo((Throwable) e);
        }
    }

    private static void O00000Oo(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                O00000Oo(dmi.O000000o(), jSONObject);
                String string = jSONObject.getString(O00000o0);
                if (O0000oO) {
                    dlm dlm = O0000o;
                    dlm.O0000O0o("hibernateVer:" + string + ", current version:2.0.3");
                }
                long O00000Oo2 = dlv.O00000Oo(string);
                if (dlv.O00000Oo("2.0.3") <= O00000Oo2) {
                    O000000o(O00000Oo2);
                }
            } catch (JSONException unused) {
                O0000o.O0000O0o("__HIBERNATE__ not found.");
            }
        }
    }

    public static void O000000o(Context context, String str) {
        dlm dlm;
        String str2;
        String str3;
        if (context == null) {
            dlm = O0000o;
            str2 = "ctx in StatConfig.setAppKey() is null";
        } else if (str == null || str.length() > 256) {
            dlm = O0000o;
            str2 = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes";
        } else {
            if (O000O0OO == null) {
                O000O0OO = dmb.O000000o(dma.O000000o(context, "_mta_ky_tag_", (String) null));
            }
            if ((O00000o(str) || O00000o(dlv.O00000oo(context))) && (str3 = O000O0OO) != null) {
                dma.O00000Oo(context, "_mta_ky_tag_", dmb.O00000Oo(str3));
                return;
            }
            return;
        }
        dlm.O00000o(str2);
    }

    public static void O00000o0(String str) {
        if (str == null || str.length() == 0) {
            O0000o.O00000o("statReportUrl cannot be null or empty.");
            return;
        }
        O000OO00 = str;
        try {
            O0000Ooo = new URI(O000OO00).getHost();
        } catch (Exception e) {
            O0000o.O00000o0(e);
        }
        if (O0000oO) {
            dlm dlm = O0000o;
            dlm.O000000o("url:" + O000OO00 + ", domain:" + O0000Ooo);
        }
    }

    public static String O00000oO(Context context) {
        return context != null ? dgh.O000000o(context).O000000o().O00000o0 : "0";
    }
}
