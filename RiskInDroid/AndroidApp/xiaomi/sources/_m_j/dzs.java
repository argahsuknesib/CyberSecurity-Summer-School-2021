package _m_j;

import _m_j.dzz;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.mipush.sdk.ae;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.r;
import com.xiaomi.push.es;
import com.xiaomi.push.et;
import com.xiaomi.push.ff;
import com.xiaomi.push.g;
import com.xiaomi.push.hp;
import com.xiaomi.push.hu;
import com.xiaomi.push.hz;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ij;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.ja;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class dzs {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Context f15105O000000o;
    private static long O00000Oo = System.currentTimeMillis();

    public interface O000000o<R> {
    }

    @Deprecated
    public static abstract class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15106O000000o;
    }

    public interface O00000o extends O000000o<O00000o0> {
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15107O000000o = null;
        public long O00000Oo = -1;
    }

    public static void O000000o(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(context, ff.c.f30a, str, (String) null);
        }
    }

    private static void O000000o(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!ff.c.f30a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - O0000OoO(context, str2)) >= 86400000) {
            if (ff.d.f30a.equalsIgnoreCase(str) && O0000OoO(context, str2) < 0) {
                duv.O000000o("Don't cancel alias for " + eml.O000000o(arrayList.toString(), 3) + " is unseted");
            } else if (!ff.e.f30a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - O0000Ooo(context, str2)) >= 3600000) {
                if (!ff.f.f30a.equalsIgnoreCase(str) || O0000Ooo(context, str2) >= 0) {
                    O000000o(context, str, arrayList, (String) null);
                    return;
                }
                duv.O000000o("Don't cancel account for " + eml.O000000o(arrayList.toString(), 3) + " is unseted");
            } else if (1 == eab.O000000o(context)) {
                PushMessageHandler.O00000Oo(null);
            } else {
                eab.O000000o(context, eab.O000000o(ff.e.f30a, arrayList, 0, null, null));
            }
        } else if (1 == eab.O000000o(context)) {
            PushMessageHandler.O00000Oo(null);
        } else {
            eab.O000000o(context, eab.O000000o(ff.c.f30a, arrayList, 0, null, null));
        }
    }

    private static void O000000o(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    public static boolean O000000o(Context context) {
        return eao.O000000o(context).O00000o0();
    }

    public static List<String> O00000Oo(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("alias_")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static void O00000Oo(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            O000000o(context, ff.e.f30a, str, (String) null);
        }
    }

    static synchronized void O00000Oo(Context context, String str, String str2) {
        synchronized (dzs.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("accept_time", str + "," + str2);
            ess.O000000o(edit);
        }
    }

    public static List<String> O00000o(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("account_")) {
                arrayList.add(next.substring(8));
            }
        }
        return arrayList;
    }

    static synchronized void O00000o(Context context, String str) {
        synchronized (dzs.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_".concat(String.valueOf(str)), System.currentTimeMillis()).commit();
        }
    }

    public static List<String> O00000o0(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("topic_") && !next.contains("**ALL**")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    protected static void O00000oO(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    static synchronized void O00000oO(Context context, String str) {
        synchronized (dzs.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_".concat(String.valueOf(str))).commit();
        }
    }

    static synchronized void O00000oo(Context context, String str) {
        synchronized (dzs.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_".concat(String.valueOf(str)), System.currentTimeMillis()).commit();
        }
    }

    static synchronized void O0000O0o(Context context, String str) {
        synchronized (dzs.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_".concat(String.valueOf(str))).commit();
        }
    }

    static synchronized void O0000OOo(Context context, String str) {
        synchronized (dzs.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_".concat(String.valueOf(str)), System.currentTimeMillis()).commit();
        }
    }

    public static long O0000Oo(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_".concat(String.valueOf(str)), -1);
    }

    public static void O0000Oo(Context context) {
        eao.O000000o(context).O000000o((String) null, au.c, e.f6055a);
    }

    static synchronized void O0000Oo0(Context context, String str) {
        synchronized (dzs.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_".concat(String.valueOf(str))).commit();
        }
    }

    public static long O0000OoO(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_".concat(String.valueOf(str)), -1);
    }

    public static void O0000OoO(Context context) {
        eao.O000000o(context).O000000o((String) null, au.d, e.b);
    }

    private static long O0000Ooo(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_".concat(String.valueOf(str)), -1);
    }

    public static void O0000Ooo(Context context) {
        eao.O000000o(context).O000000o((String) null, au.e, e.c);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dzs.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.Context, java.lang.String]
     candidates:
      _m_j.dzs.O000000o(android.content.Context, int):void
      _m_j.dzs.O000000o(android.content.Context, com.xiaomi.push.id):void
      _m_j.dzs.O000000o(android.content.Context, java.lang.String):void
      _m_j.dzs.O000000o(java.lang.Object, java.lang.String):void */
    public static boolean O0000o(Context context) {
        O000000o((Object) context, "context");
        return eay.O000000o(context).O00000Oo(e.f6055a);
    }

    public static void O0000o00(Context context) {
        eao.O000000o(context).O000000o((String) null, au.f, e.d);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dzs.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.Context, java.lang.String]
     candidates:
      _m_j.dzs.O000000o(android.content.Context, int):void
      _m_j.dzs.O000000o(android.content.Context, com.xiaomi.push.id):void
      _m_j.dzs.O000000o(android.content.Context, java.lang.String):void
      _m_j.dzs.O000000o(java.lang.Object, java.lang.String):void */
    public static boolean O0000oO(Context context) {
        O000000o((Object) context, "context");
        return eay.O000000o(context).O00000Oo(e.c);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dzs.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.Context, java.lang.String]
     candidates:
      _m_j.dzs.O000000o(android.content.Context, int):void
      _m_j.dzs.O000000o(android.content.Context, com.xiaomi.push.id):void
      _m_j.dzs.O000000o(android.content.Context, java.lang.String):void
      _m_j.dzs.O000000o(java.lang.Object, java.lang.String):void */
    public static boolean O0000oO0(Context context) {
        O000000o((Object) context, "context");
        return eay.O000000o(context).O00000Oo(e.b);
    }

    public static boolean O0000oOO(Context context) {
        return eay.O000000o(context).O00000Oo(e.d);
    }

    static synchronized void O0000oOo(Context context) {
        synchronized (dzs.class) {
            for (String O00000oO : O00000Oo(context)) {
                O00000oO(context, O00000oO);
            }
        }
    }

    static synchronized void O0000oo(Context context) {
        synchronized (dzs.class) {
            for (String O0000Oo0 : O00000o0(context)) {
                O0000Oo0(context, O0000Oo0);
            }
        }
    }

    static synchronized void O0000oo0(Context context) {
        synchronized (dzs.class) {
            for (String O0000O0o : O00000o(context)) {
                O0000O0o(context, O0000O0o);
            }
        }
    }

    static synchronized void O0000ooO(Context context) {
        synchronized (dzs.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            ess.O000000o(edit);
        }
    }

    protected static String O0000ooo(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
    }

    private static void O00oOooO(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        for (String valueOf : O00000Oo(context)) {
            edit.remove("alias_".concat(String.valueOf(valueOf)));
        }
        for (String valueOf2 : O00000o(context)) {
            edit.remove("account_".concat(String.valueOf(valueOf2)));
        }
        for (String valueOf3 : O00000o0(context)) {
            edit.remove("topic_".concat(String.valueOf(valueOf3)));
        }
        edit.remove("accept_time");
        edit.commit();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dzs.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.Context, java.lang.String]
     candidates:
      _m_j.dzs.O000000o(android.content.Context, int):void
      _m_j.dzs.O000000o(android.content.Context, com.xiaomi.push.id):void
      _m_j.dzs.O000000o(android.content.Context, java.lang.String):void
      _m_j.dzs.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    public static void O000000o(Context context, String str, String str2, eaa eaa) {
        O000000o((Object) context, "context");
        O000000o(str, "appID");
        O000000o(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        f15105O000000o = applicationContext;
        if (applicationContext == null) {
            f15105O000000o = context;
        }
        Context context2 = f15105O000000o;
        esu.O000000o(context2);
        if (!NetworkStatusReceiver.a()) {
            Context context3 = f15105O000000o;
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                eso.O000000o(context3.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter);
                eso.O000000o(context3, NetworkStatusReceiver.class);
            } catch (Throwable th) {
                duv.O000000o("dynamic register network status receiver failed:".concat(String.valueOf(th)));
            }
        }
        eay O000000o2 = eay.O000000o(f15105O000000o);
        O000000o2.O00000Oo = eaa;
        O000000o2.O00000o0 = at.a(O000000o2.f15135O000000o).a(hu.ao.a(), true);
        if (O000000o2.O00000Oo.f15114O000000o || O000000o2.O00000Oo.O00000Oo || O000000o2.O00000Oo.O00000o0 || O000000o2.O00000Oo.O00000o) {
            at.a(O000000o2.f15135O000000o).a(new eaz(O000000o2, "assemblePush"));
        }
        elo.O000000o(context2).O000000o(new dzt(str, str2, null, null), 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.ij, com.xiaomi.push.hp, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, int]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eau.O000000o(android.content.Context, boolean):void
     arg types: [android.content.Context, int]
     candidates:
      _m_j.eau.O000000o(android.content.Context, com.xiaomi.push.io):void
      _m_j.eau.O000000o(android.content.Context, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x04a4 A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x04bb A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x04d2 A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x04e9 A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0500 A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0515 A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x039b A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x03dc A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0450 A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x045c A[Catch:{ Throwable -> 0x0519 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0480 A[Catch:{ Throwable -> 0x0519 }] */
    public static void O000000o(Context context, String str, String str2, String str3, O000000o o000000o) {
        duw O00000Oo2;
        long j;
        SharedPreferences.Editor putLong;
        String str4 = str;
        String str5 = str2;
        try {
            duv.O000000o(context.getApplicationContext());
            duv.O00000oo("sdk_version = 4_2_0");
            elz.O000000o(context);
            eny.O000000o(context);
            if (o000000o != null) {
                PushMessageHandler.O000000o(o000000o);
            }
            if (esu.O00000Oo(f15105O000000o)) {
                new Thread(new ebl(f15105O000000o)).start();
            }
            boolean z = b.O000000o(f15105O000000o).O00000Oo.O0000OoO != dzn.O000000o();
            if (!z) {
                if (!(Math.abs(System.currentTimeMillis() - f15105O000000o.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1)) > 5000)) {
                    eao.O000000o(f15105O000000o).O000000o();
                    duv.O000000o("Could not send  register message within 5s repeatly .");
                    return;
                }
            }
            if (!z) {
                if (b.O000000o(f15105O000000o).O00000Oo.O000000o(str4, str5) && !b.O000000o(f15105O000000o).O00000Oo()) {
                    if (1 == eab.O000000o(f15105O000000o)) {
                        O000000o((Object) null, "callback");
                        b.O000000o(f15105O000000o);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(b.O000000o(f15105O000000o).O00000Oo.O00000o0);
                        eab.O000000o(f15105O000000o, eab.O000000o(ff.f6377a.f30a, arrayList, 0, null, null));
                    }
                    eao.O000000o(f15105O000000o).O000000o();
                    b O000000o2 = b.O000000o(f15105O000000o);
                    if (!TextUtils.equals(g.O000000o(O000000o2.f6053O000000o, O000000o2.f6053O000000o.getPackageName()), O000000o2.O00000Oo.O00000oO)) {
                        io ioVar = new io();
                        ioVar.c = b.O000000o(f15105O000000o).O00000Oo.f6054O000000o;
                        ioVar.d = hz.g.f70a;
                        ioVar.b = aw.a();
                        ioVar.f133a = new HashMap();
                        Map<String, String> map = ioVar.f133a;
                        Context context2 = f15105O000000o;
                        map.put("app_version", g.O000000o(context2, context2.getPackageName()));
                        Map<String, String> map2 = ioVar.f133a;
                        Context context3 = f15105O000000o;
                        map2.put("app_version_code", Integer.toString(g.O00000Oo(context3, context3.getPackageName())));
                        ioVar.f133a.put("push_sdk_vn", "4_2_0");
                        ioVar.f133a.put("push_sdk_vc", Integer.toString(40020));
                        erv.O000000o(f15105O000000o, ioVar.f133a);
                        String str6 = b.O000000o(f15105O000000o).O00000Oo.O0000O0o;
                        if (!TextUtils.isEmpty(str6)) {
                            ioVar.f133a.put("deviceid", str6);
                        }
                        eao.O000000o(f15105O000000o).O000000o((ja) ioVar, hp.i, false, (ic) null);
                    }
                    if (!PreferenceManager.getDefaultSharedPreferences(f15105O000000o).getBoolean("update_devId", false)) {
                        new Thread(new dzv()).start();
                        PreferenceManager.getDefaultSharedPreferences(f15105O000000o).edit().putBoolean("update_devId", true).commit();
                    }
                    String O00000o02 = erv.O00000o0(f15105O000000o);
                    if (!TextUtils.isEmpty(O00000o02)) {
                        ij ijVar = new ij();
                        ijVar.f112a = aw.a();
                        ijVar.b = str4;
                        ijVar.c = ff.j.f30a;
                        ArrayList arrayList2 = new ArrayList();
                        String O00000Oo3 = erv.O00000Oo(f15105O000000o);
                        if (!TextUtils.isEmpty(O00000Oo3)) {
                            arrayList2.add(O00000Oo3);
                        }
                        String str7 = "";
                        if (O00000o02 == null) {
                            O00000o02 = str7;
                        }
                        arrayList2.add(O00000o02);
                        arrayList2.add(Build.MODEL != null ? Build.MODEL : str7);
                        if (Build.BOARD != null) {
                            str7 = Build.BOARD;
                        }
                        arrayList2.add(str7);
                        ijVar.f114a = arrayList2;
                        eao.O000000o(f15105O000000o).O000000o((ja) ijVar, hp.j, false, (ic) null);
                    }
                    if (eao.O000000o(f15105O000000o).O00000o0()) {
                        if (Math.abs(System.currentTimeMillis() - f15105O000000o.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > 300000) {
                            io ioVar2 = new io();
                            ioVar2.c = b.O000000o(f15105O000000o).O00000Oo.f6054O000000o;
                            ioVar2.d = hz.j.f70a;
                            ioVar2.b = aw.a();
                            ioVar2.O000000o(false);
                            eao.O000000o(f15105O000000o).O000000o((ja) ioVar2, hp.i, false, false);
                            SharedPreferences.Editor edit = f15105O000000o.getSharedPreferences("mipush_extra", 0).edit();
                            edit.putLong("last_pull_notification", System.currentTimeMillis());
                            ess.O000000o(edit);
                        }
                    }
                    SharedPreferences.Editor edit2 = f15105O000000o.getSharedPreferences("mipush_extra", 0).edit();
                    edit2.putLong("last_reg_request", System.currentTimeMillis());
                    ess.O000000o(edit2);
                    elo.O000000o(f15105O000000o).O000000o(new ae(f15105O000000o), at.a(f15105O000000o).a(hu.A.a(), 86400), 5);
                    Context context4 = f15105O000000o;
                    if (at.a(f15105O000000o).a(hu.z.a(), esl.O00000Oo())) {
                        eom.O000000o().f15678O000000o = new r(context4);
                        elo.O000000o(f15105O000000o).O000000o(new dzu(), 10);
                    }
                    Context context5 = f15105O000000o;
                    epi.O000000o(new dzw());
                    O00000Oo2 = epi.O00000Oo(context5);
                    dvb.O000000o(context5).O00000oo = "4_2_0";
                    dva.O000000o(context5, O00000Oo2, new es(context5), new et(context5));
                    eac.O000000o(context5);
                    if (O00000Oo2 != null) {
                        Intent intent = new Intent();
                        intent.setAction("action_cr_config");
                        intent.putExtra("action_cr_event_switch", O00000Oo2.O00000Oo);
                        intent.putExtra("action_cr_event_frequency", O00000Oo2.O00000oO);
                        intent.putExtra("action_cr_perf_switch", O00000Oo2.O00000o0);
                        intent.putExtra("action_cr_perf_frequency", O00000Oo2.O00000oo);
                        intent.putExtra("action_cr_event_en", O00000Oo2.f14961O000000o);
                        intent.putExtra("action_cr_max_file_size", O00000Oo2.O00000o);
                        eao.O000000o(context5).O000000o(intent);
                    }
                    at.a(context5).a(new dzx("perf event job update", context5));
                    Context context6 = f15105O000000o;
                    SharedPreferences sharedPreferences = context6.getSharedPreferences("mipush_extra", 0);
                    j = sharedPreferences.getLong("last_sync_info", -1);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long a2 = (long) at.a(context6).a(hu.B.a(), 1209600);
                    if (j != -1) {
                        putLong = sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis);
                    } else {
                        if (Math.abs(currentTimeMillis - j) > a2) {
                            eau.O000000o(context6, true);
                            putLong = sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis);
                        }
                        if (!f15105O000000o.getPackageName().equals("com.xiaomi.xmsf")) {
                            if (dzr.O000000o() != null) {
                                dzr.O000000o(f15105O000000o, dzr.O000000o());
                            }
                            duv.O000000o();
                        }
                        if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.f6052a))) {
                            O0000OOo(f15105O000000o);
                        }
                        if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.b))) {
                            O0000Oo0(f15105O000000o);
                        }
                        if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.c))) {
                            O0000Oo(f15105O000000o);
                        }
                        if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.d))) {
                            O0000OoO(f15105O000000o);
                        }
                        if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.e))) {
                            O0000Ooo(context);
                        }
                        if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.f))) {
                            O0000o00(context);
                            return;
                        }
                        return;
                    }
                    putLong.commit();
                    if (!f15105O000000o.getPackageName().equals("com.xiaomi.xmsf")) {
                    }
                    if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.f6052a))) {
                    }
                    if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.b))) {
                    }
                    if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.c))) {
                    }
                    if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.d))) {
                    }
                    if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.e))) {
                    }
                    if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.f))) {
                    }
                }
            }
            String O000000o3 = eml.O000000o(6);
            b.O000000o(f15105O000000o).O00000Oo.O00000o0();
            b.O000000o(f15105O000000o).O000000o(dzn.O000000o());
            b.O000000o(f15105O000000o).O000000o(str4, str5, O000000o3);
            dzz.O000000o.O000000o().O000000o("com.xiaomi.xmpushsdk.tinydataPending.appId");
            O00000oO(f15105O000000o);
            O0000o0(context);
            ip ipVar = new ip();
            ipVar.f144b = aw.a();
            ipVar.f146c = str4;
            ipVar.f = str5;
            ipVar.e = f15105O000000o.getPackageName();
            ipVar.g = O000000o3;
            Context context7 = f15105O000000o;
            ipVar.d = g.O000000o(context7, context7.getPackageName());
            Context context8 = f15105O000000o;
            ipVar.O000000o(g.O00000Oo(context8, context8.getPackageName()));
            ipVar.k = "4_2_0";
            ipVar.O000000o();
            ipVar.f137a = id.c;
            if (!TextUtils.isEmpty(str3)) {
                ipVar.h = str3;
            }
            if (!esl.O00000oo()) {
                String O00000oO = erv.O00000oO(f15105O000000o);
                if (!TextUtils.isEmpty(O00000oO)) {
                    ipVar.o = eml.O000000o(O00000oO) + "," + erv.O0000O0o(f15105O000000o);
                }
            }
            int O000000o4 = erv.O000000o();
            if (O000000o4 >= 0) {
                ipVar.O00000Oo(O000000o4);
            }
            eao.O000000o(f15105O000000o).O000000o(ipVar, z);
            f15105O000000o.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            SharedPreferences.Editor edit22 = f15105O000000o.getSharedPreferences("mipush_extra", 0).edit();
            edit22.putLong("last_reg_request", System.currentTimeMillis());
            ess.O000000o(edit22);
            elo.O000000o(f15105O000000o).O000000o(new ae(f15105O000000o), at.a(f15105O000000o).a(hu.A.a(), 86400), 5);
            Context context42 = f15105O000000o;
            if (at.a(f15105O000000o).a(hu.z.a(), esl.O00000Oo())) {
            }
            Context context52 = f15105O000000o;
            epi.O000000o(new dzw());
            O00000Oo2 = epi.O00000Oo(context52);
            dvb.O000000o(context52).O00000oo = "4_2_0";
            dva.O000000o(context52, O00000Oo2, new es(context52), new et(context52));
            eac.O000000o(context52);
            if (O00000Oo2 != null) {
            }
            at.a(context52).a(new dzx("perf event job update", context52));
            Context context62 = f15105O000000o;
            SharedPreferences sharedPreferences2 = context62.getSharedPreferences("mipush_extra", 0);
            j = sharedPreferences2.getLong("last_sync_info", -1);
            long currentTimeMillis2 = System.currentTimeMillis() / 1000;
            long a22 = (long) at.a(context62).a(hu.B.a(), 1209600);
            if (j != -1) {
            }
            putLong.commit();
            if (!f15105O000000o.getPackageName().equals("com.xiaomi.xmsf")) {
            }
            if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.f6052a))) {
            }
            if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.b))) {
            }
            if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.c))) {
            }
            if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.d))) {
            }
            if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.e))) {
            }
            if ("syncing".equals(eah.O000000o(f15105O000000o).O000000o(au.f))) {
            }
        } catch (Throwable th) {
            duv.O000000o(th);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ip, boolean):void
     arg types: [com.xiaomi.push.ip, int]
     candidates:
      _m_j.eao.O000000o(_m_j.eao, android.os.Messenger):android.os.Messenger
      _m_j.eao.O000000o(_m_j.eao, java.lang.Integer):java.lang.Integer
      _m_j.eao.O000000o(int, int):void
      _m_j.eao.O000000o(boolean, java.lang.String):void
      _m_j.eao.O000000o(com.xiaomi.push.ip, boolean):void */
    static void O000000o(Context context, id idVar) {
        duv.O00000oo("re-register reason: ".concat(String.valueOf(idVar)));
        String O000000o2 = eml.O000000o(6);
        String str = b.O000000o(context).O00000Oo.f6054O000000o;
        String str2 = b.O000000o(context).O00000Oo.O00000Oo;
        b.O000000o(context).O00000Oo.O00000o0();
        O00oOooO(context);
        O0000o0(context);
        b.O000000o(context).O000000o(dzn.O000000o());
        b.O000000o(context).O000000o(str, str2, O000000o2);
        ip ipVar = new ip();
        ipVar.f144b = aw.a();
        ipVar.f146c = str;
        ipVar.f = str2;
        ipVar.g = O000000o2;
        ipVar.e = context.getPackageName();
        ipVar.d = g.O000000o(context, context.getPackageName());
        ipVar.O000000o(g.O00000Oo(context, context.getPackageName()));
        ipVar.k = "4_2_0";
        ipVar.O000000o();
        ipVar.f137a = idVar;
        int O000000o3 = erv.O000000o();
        if (O000000o3 >= 0) {
            ipVar.O00000Oo(O000000o3);
        }
        eao.O000000o(context).O000000o(ipVar, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void
     arg types: [com.xiaomi.push.io, com.xiaomi.push.hp, int, com.xiaomi.push.ic]
     candidates:
      _m_j.eao.O000000o(java.lang.String, com.xiaomi.mipush.sdk.au, boolean, java.util.HashMap<java.lang.String, java.lang.String>):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, boolean):void
      _m_j.eao.O000000o(com.xiaomi.push.ja, com.xiaomi.push.hp, boolean, com.xiaomi.push.ic):void */
    static void O000000o(Context context, String str, ic icVar, String str2) {
        io ioVar = new io();
        if (!TextUtils.isEmpty(str2)) {
            ioVar.c = str2;
        } else if (b.O000000o(context).O000000o()) {
            ioVar.c = b.O000000o(context).O00000Oo.f6054O000000o;
        } else {
            duv.O00000o("do not report clicked message");
            return;
        }
        ioVar.d = "bar:click";
        ioVar.b = str;
        ioVar.O000000o(false);
        eao.O000000o(context).O000000o((ja) ioVar, hp.i, false, icVar);
    }

    static void O000000o(Context context, String str, ic icVar, String str2, String str3) {
        io ioVar = new io();
        if (TextUtils.isEmpty(str3)) {
            duv.O00000o("do not report clicked message");
            return;
        }
        ioVar.c = str3;
        ioVar.d = "bar:click";
        ioVar.b = str;
        ioVar.O000000o(false);
        eao.O000000o(context).O000000o(ioVar, hp.i, false, true, icVar, true, str2, str3);
    }

    public static void O00000oo(Context context) {
        eao O000000o2 = eao.O000000o(context);
        Intent O00000Oo2 = O000000o2.O00000Oo();
        O00000Oo2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        O00000Oo2.putExtra(bd.A, O000000o2.f15127O000000o.getPackageName());
        O00000Oo2.putExtra(bd.F, emk.O00000Oo(O000000o2.f15127O000000o.getPackageName()));
        O000000o2.O00000o0(O00000Oo2);
    }

    public static void O0000O0o(Context context) {
        ebb.O00000oo(context);
        at.a(context).a();
        if (b.O000000o(context).O000000o()) {
            iv ivVar = new iv();
            ivVar.b = aw.a();
            ivVar.c = b.O000000o(context).O00000Oo.f6054O000000o;
            ivVar.d = b.O000000o(context).O00000Oo.O00000o0;
            ivVar.g = b.O000000o(context).O00000Oo.O00000Oo;
            ivVar.f = context.getPackageName();
            eao.O000000o(context).O000000o(ivVar);
            PushMessageHandler.O00000Oo();
            PushMessageHandler.O00000o0();
            b.a aVar = b.O000000o(context).O00000Oo;
            aVar.O0000Oo0 = false;
            b.O00000Oo(aVar.O0000Ooo).edit().putBoolean("valid", aVar.O0000Oo0).commit();
            O00000oo(context);
            O0000o0(context);
            O00000oO(context);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(boolean, java.lang.String):void
     arg types: [int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(_m_j.eao, android.os.Messenger):android.os.Messenger
      _m_j.eao.O000000o(_m_j.eao, java.lang.Integer):java.lang.Integer
      _m_j.eao.O000000o(int, int):void
      _m_j.eao.O000000o(com.xiaomi.push.ip, boolean):void
      _m_j.eao.O000000o(boolean, java.lang.String):void */
    public static void O0000OOo(Context context) {
        eao.O000000o(context).O000000o(true, (String) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.eao.O000000o(boolean, java.lang.String):void
     arg types: [int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.eao.O000000o(_m_j.eao, android.os.Messenger):android.os.Messenger
      _m_j.eao.O000000o(_m_j.eao, java.lang.Integer):java.lang.Integer
      _m_j.eao.O000000o(int, int):void
      _m_j.eao.O000000o(com.xiaomi.push.ip, boolean):void
      _m_j.eao.O000000o(boolean, java.lang.String):void */
    public static void O0000Oo0(Context context) {
        eao.O000000o(context).O000000o(false, (String) null);
    }

    public static void O00000o0(Context context, String str) {
        if (!TextUtils.isEmpty(b.O000000o(context).O00000Oo.f6054O000000o) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - O0000Oo(context, str)) > 86400000) {
                it itVar = new it();
                String a2 = aw.a();
                itVar.b = a2;
                itVar.c = b.O000000o(context).O00000Oo.f6054O000000o;
                itVar.d = str;
                itVar.e = context.getPackageName();
                itVar.f = null;
                duv.O00000oo("cmd:" + ff.g + ", " + a2);
                eao.O000000o(context).O000000o(itVar, hp.c, (ic) null);
            } else if (1 == eab.O000000o(context)) {
                PushMessageHandler.O000000o((String) null);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                eab.O000000o(context, eab.O000000o(ff.g.f30a, arrayList, 0, null, null));
            }
        }
    }

    public static void O000000o(Context context, int i) {
        eao.O000000o(context).O000000o(i, 0);
    }

    public static void O000000o(Context context, String str, String str2) {
        eao O000000o2 = eao.O000000o(context);
        Intent O00000Oo2 = O000000o2.O00000Oo();
        O00000Oo2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        O00000Oo2.putExtra(bd.A, O000000o2.f15127O000000o.getPackageName());
        O00000Oo2.putExtra(bd.G, str);
        O00000Oo2.putExtra(bd.H, str2);
        O000000o2.O00000o0(O00000Oo2);
    }

    public static void O0000o0(Context context) {
        eao.O000000o(context).O000000o(-1, 0);
    }

    public static String O0000o0O(Context context) {
        if (b.O000000o(context).O00000Oo.O000000o()) {
            return b.O000000o(context).O00000Oo.O00000o0;
        }
        return null;
    }

    public static String O0000o0o(Context context) {
        if (b.O000000o(context).O00000Oo.O000000o()) {
            return b.O000000o(context).O00000Oo.O0000OOo;
        }
        return null;
    }

    private static void O000000o(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(b.O000000o(context).O00000Oo.f6054O000000o)) {
            ij ijVar = new ij();
            String a2 = aw.a();
            ijVar.f112a = a2;
            ijVar.b = b.O000000o(context).O00000Oo.f6054O000000o;
            ijVar.c = str;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (ijVar.f114a == null) {
                    ijVar.f114a = new ArrayList();
                }
                ijVar.f114a.add(next);
            }
            ijVar.e = str2;
            ijVar.d = context.getPackageName();
            duv.O00000oo("cmd:" + str + ", " + a2);
            eao.O000000o(context).O000000o(ijVar, hp.j, (ic) null);
        }
    }
}
