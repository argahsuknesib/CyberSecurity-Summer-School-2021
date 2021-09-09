package _m_j;

import android.content.Intent;

public final class cup extends cve {
    public final String toString() {
        return "StartUriHandler";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cvg.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cvg.O000000o(java.lang.String, java.lang.Object):_m_j.cvg
      _m_j.cvg.O000000o(java.lang.String, boolean):boolean */
    public final boolean O000000o(cvg cvg) {
        return cvg.O000000o("com.sankuai.waimai.router.common.try_start_uri", true);
    }

    public final void O000000o(cvg cvg, cvd cvd) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(cvg.O00000Oo);
        cuy.O000000o(intent, cvg);
        cvg.O00000Oo("com.sankuai.waimai.router.activity.limit_package", Boolean.FALSE);
        int O000000o2 = cux.O000000o(cvg, intent);
        if (O000000o2 == 200) {
            cvd.O000000o(O000000o2);
        } else {
            cvd.O000000o();
        }
    }
}
