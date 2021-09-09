package _m_j;

import _m_j.duw;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.es;
import com.xiaomi.push.et;
import com.xiaomi.push.ff;
import com.xiaomi.push.hp;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.hz;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.bs;
import com.xiaomi.push.service.bt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class epi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static O000000o f15700O000000o;
    private static Map<String, hz> O00000Oo;

    public interface O000000o {
        void O000000o(Context context, ht htVar);
    }

    public static int O000000o(Enum enumR) {
        if (enumR != null) {
            if (enumR instanceof hp) {
                return enumR.ordinal() + 1001;
            }
            if (enumR instanceof hz) {
                return enumR.ordinal() + 2001;
            }
            if (enumR instanceof ff) {
                return enumR.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static hz O000000o(String str) {
        if (O00000Oo == null) {
            synchronized (hz.class) {
                if (O00000Oo == null) {
                    O00000Oo = new HashMap();
                    for (hz hzVar : hz.values()) {
                        O00000Oo.put(hzVar.f70a.toLowerCase(), hzVar);
                    }
                }
            }
        }
        hz hzVar2 = O00000Oo.get(str.toLowerCase());
        return hzVar2 != null ? hzVar2 : hz.f6403a;
    }

    public static String O000000o(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    public static void O000000o(O000000o o000000o) {
        f15700O000000o = o000000o;
    }

    public static void O000000o(Context context, duw duw) {
        dva.O000000o(context, duw, new es(context), new et(context));
    }

    public static int O00000Oo(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static dux O000000o(String str, String str2, int i, long j, String str3) {
        dux dux = new dux();
        dux.O00000oO = 1000;
        dux.O0000O0o = 1001;
        dux.O00000oo = str;
        dux.f14963O000000o = str2;
        dux.O00000Oo = i;
        dux.O00000o0 = j;
        dux.O00000o = str3;
        return dux;
    }

    public static duy O000000o(int i, long j, long j2) {
        duy duy = new duy();
        duy.O00000oO = 1000;
        duy.O0000O0o = 1000;
        duy.O00000oo = "P100000";
        duy.f14964O000000o = i;
        duy.O00000Oo = 1;
        duy.O00000o0 = j2;
        return duy;
    }

    public static void O000000o(Context context, List<String> list) {
        ht htVar;
        if (list != null) {
            try {
                for (String next : list) {
                    if (TextUtils.isEmpty(next)) {
                        htVar = null;
                    } else {
                        ht htVar2 = new ht();
                        htVar2.d = "category_client_report_data";
                        htVar2.f52a = "push_sdk_channel";
                        htVar2.O000000o(1);
                        htVar2.f56b = next;
                        htVar2.O000000o(true);
                        htVar2.O00000Oo(System.currentTimeMillis());
                        htVar2.g = context.getPackageName();
                        htVar2.e = "com.xiaomi.xmsf";
                        htVar2.f = bs.a();
                        htVar2.c = "quality_support";
                        htVar = htVar2;
                    }
                    boolean z = false;
                    if (!bs.a(htVar, false)) {
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null && !TextUtils.isEmpty(applicationContext.getPackageName()) && "com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
                            z = true;
                        }
                        if (z) {
                            bt.a(context.getApplicationContext(), htVar);
                        } else if (f15700O000000o != null) {
                            f15700O000000o.O000000o(context, htVar);
                        }
                    }
                }
            } catch (Throwable th) {
                duv.O00000o(th.getMessage());
            }
        }
    }

    public static void O000000o(Context context) {
        duw O00000Oo2 = O00000Oo(context);
        if (O00000Oo2 != null) {
            dvb O000000o2 = dvb.O000000o(context);
            boolean z = O00000Oo2.O00000Oo;
            boolean z2 = O00000Oo2.O00000o0;
            long j = O00000Oo2.O00000oO;
            long j2 = O00000Oo2.O00000oo;
            if (O000000o2.O00000oO == null) {
                return;
            }
            if (z != O000000o2.O00000oO.O00000Oo || z2 != O000000o2.O00000oO.O00000o0 || j != O000000o2.O00000oO.O00000oO || j2 != O000000o2.O00000oO.O00000oo) {
                long j3 = O000000o2.O00000oO.O00000oO;
                long j4 = O000000o2.O00000oO.O00000oo;
                duw.O000000o o000000o = new duw.O000000o();
                o000000o.O00000o = emn.O000000o(O000000o2.O00000o);
                duw.O000000o O00000Oo3 = o000000o.O000000o(O000000o2.O00000oO.f14961O000000o).O00000Oo(z);
                O00000Oo3.O00000oo = j;
                duw.O000000o O00000o0 = O00000Oo3.O00000o0(z2);
                O00000o0.O0000O0o = j2;
                duw O000000o3 = O00000o0.O000000o(O000000o2.O00000o);
                O000000o2.O00000oO = O000000o3;
                if (!O000000o2.O00000oO.O00000Oo) {
                    elo.O000000o(O000000o2.O00000o).O000000o("100886");
                } else if (j3 != O000000o3.O00000oO) {
                    duv.O00000o0(O000000o2.O00000o.getPackageName() + "reset event job " + O000000o3.O00000oO);
                    O000000o2.O00000Oo();
                }
                if (!O000000o2.O00000oO.O00000o0) {
                    elo.O000000o(O000000o2.O00000o).O000000o("100887");
                } else if (j4 != O000000o3.O00000oo) {
                    duv.O00000o0(O000000o2.O00000o.getPackageName() + " reset perf job " + O000000o3.O00000oo);
                    O000000o2.O00000o0();
                }
            }
        }
    }

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
    public static duw O00000Oo(Context context) {
        boolean a2 = at.a(context).a(hu.aA.a(), false);
        boolean a3 = at.a(context).a(hu.aU.a(), false);
        int a4 = at.a(context).a(hu.aC.a(), 86400);
        int a5 = at.a(context).a(hu.aB.a(), 86400);
        duw.O000000o O00000Oo2 = new duw.O000000o().O00000Oo(a3);
        O00000Oo2.O00000oo = (long) a5;
        duw.O000000o O00000o0 = O00000Oo2.O00000o0(a2);
        O00000o0.O0000O0o = (long) a4;
        return O00000o0.O000000o(context);
    }
}
