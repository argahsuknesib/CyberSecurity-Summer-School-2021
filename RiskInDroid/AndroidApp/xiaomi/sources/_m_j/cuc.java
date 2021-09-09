package _m_j;

import android.content.Intent;

public abstract class cuc extends cve {
    public final boolean O000000o(cvg cvg) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract Intent O00000Oo(cvg cvg);

    public String toString() {
        return "ActivityHandler";
    }

    public final void O000000o(cvg cvg, cvd cvd) {
        Intent O00000Oo = O00000Oo(cvg);
        if (O00000Oo == null || O00000Oo.getComponent() == null) {
            cvb.O0000O0o();
            cvd.O000000o(500);
            return;
        }
        O00000Oo.setData(cvg.O00000Oo);
        cuy.O000000o(O00000Oo, cvg);
        cvg.O00000Oo("com.sankuai.waimai.router.activity.limit_package", Boolean.TRUE);
        cvd.O000000o(cux.O000000o(cvg, O00000Oo));
    }
}
