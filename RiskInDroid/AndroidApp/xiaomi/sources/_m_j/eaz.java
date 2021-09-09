package _m_j;

import com.xiaomi.push.hu;
import com.xiaomi.push.service.at;

final class eaz extends at.a {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ eay f15136O000000o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    eaz(eay eay, String str) {
        super(101, str);
        this.f15136O000000o = eay;
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
    public final void onCallback() {
        boolean a2 = at.a(this.f15136O000000o.f15135O000000o).a(hu.ao.a(), true);
        if (this.f15136O000000o.O00000o0 != a2) {
            boolean unused = this.f15136O000000o.O00000o0 = a2;
            ebb.O00000oO(this.f15136O000000o.f15135O000000o);
        }
    }
}
