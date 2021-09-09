package _m_j;

import _m_j.elo;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.at;

public class emr {
    private static volatile emr O0000Oo0;
    /* access modifiers changed from: package-private */

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f15633O000000o;
    String O00000Oo;
    public eng O00000o;
    String O00000o0;
    private final String O00000oO = "push_stat_sp";
    private final String O00000oo = "upload_time";
    private final String O0000O0o = "delete_time";
    private final String O0000OOo = "check_time";
    /* access modifiers changed from: private */
    public enh O0000Oo;
    private elo.O000000o O0000OoO = new ems(this);
    private elo.O000000o O0000Ooo = new emt(this);
    private elo.O000000o O0000o00 = new emu(this);

    private emr(Context context) {
        this.f15633O000000o = context;
    }

    public static emr O000000o(Context context) {
        if (O0000Oo0 == null) {
            synchronized (emr.class) {
                if (O0000Oo0 == null) {
                    O0000Oo0 = new emr(context);
                }
            }
        }
        return O0000Oo0;
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
    /* access modifiers changed from: package-private */
    public final boolean O000000o() {
        return at.a(this.f15633O000000o).a(hu.bn.a(), true);
    }

    /* access modifiers changed from: package-private */
    public final String O00000Oo() {
        return this.f15633O000000o.getDatabasePath(emv.f15637O000000o).getAbsolutePath();
    }

    static /* synthetic */ void O000000o(emr emr, String str) {
        SharedPreferences.Editor edit = emr.f15633O000000o.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        ess.O000000o(edit);
    }
}
