package _m_j;

import _m_j.elo;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.xiaomi.push.ec;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.at;

public class eop {
    private static volatile eop O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f15680O000000o;

    private eop(Context context) {
        this.f15680O000000o = context;
    }

    public static eop O000000o(Context context) {
        if (O00000Oo == null) {
            synchronized (eop.class) {
                if (O00000Oo == null) {
                    O00000Oo = new eop(context);
                }
            }
        }
        return O00000Oo;
    }

    private boolean O000000o() {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                ((Application) (this.f15680O000000o instanceof Application ? this.f15680O000000o : this.f15680O000000o.getApplicationContext())).registerActivityLifecycleCallbacks(new eok(this.f15680O000000o, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Exception e) {
                duv.O000000o(e);
            }
        }
        return false;
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.elo.O000000o(_m_j.elo$O000000o, int):boolean
     arg types: [com.xiaomi.push.ec, int]
     candidates:
      _m_j.elo.O000000o(java.lang.Runnable, int):void
      _m_j.elo.O000000o(_m_j.elo$O000000o, int):boolean */
    private void O000000o(at atVar, elo elo, boolean z) {
        if (atVar.a(hu.f6396a.a(), true)) {
            ec ecVar = new ec(this.f15680O000000o);
            if (z) {
                elo.O000000o(ecVar, Math.max(60, atVar.a(hu.b.a(), 86400)), 0);
            } else {
                elo.O000000o((elo.O000000o) ecVar, 0);
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
    static /* synthetic */ void O000000o(eop eop) {
        elo O000000o2 = elo.O000000o(eop.f15680O000000o);
        at a2 = at.a(eop.f15680O000000o);
        SharedPreferences sharedPreferences = eop.f15680O000000o.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) >= 172800000) {
            eop.O000000o(a2, O000000o2, false);
            if (a2.a(hu.aI.a(), true)) {
                int max = Math.max(60, a2.a(hu.aJ.a(), 86400));
                O000000o2.O000000o(new eot(eop.f15680O000000o, max), max, 0);
            }
            esl.O000000o(eop.f15680O000000o);
            if (a2.a(hu.ap.a(), false)) {
                eop.O000000o();
            }
            eop.O000000o(a2, O000000o2, true);
        }
    }
}
