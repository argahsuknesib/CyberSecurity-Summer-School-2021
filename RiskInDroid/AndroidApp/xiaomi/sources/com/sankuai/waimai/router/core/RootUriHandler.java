package com.sankuai.waimai.router.core;

import _m_j.cuz;
import _m_j.cvb;
import _m_j.cvc;
import _m_j.cvd;
import _m_j.cve;
import _m_j.cvg;
import android.content.Context;
import android.net.Uri;

public class RootUriHandler extends cuz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected cvc f5508O000000o;
    private final Context O00000Oo;

    public RootUriHandler(Context context) {
        this.O00000Oo = context.getApplicationContext();
    }

    /* renamed from: O00000Oo */
    public final RootUriHandler O000000o(cve cve, int i) {
        return (RootUriHandler) super.O000000o(cve, i);
    }

    public final void O00000Oo(cvg cvg) {
        if (cvg == null) {
            cvb.O0000O0o();
            O000000o(new cvg(this.O00000Oo, Uri.EMPTY).O000000o("UriRequest为空"), 400);
        } else if (cvg.f14384O000000o == null) {
            cvb.O0000O0o();
            O000000o(new cvg(this.O00000Oo, cvg.O00000Oo, cvg.O00000o0).O000000o("UriRequest.Context为空"), 400);
        } else if (cvg.O00000o()) {
            cvb.O00000oo();
            cvg.O000000o("跳转链接为空");
            O000000o(cvg, 400);
        } else {
            if (cvb.O00000o0()) {
                cvb.O00000o();
                new Object[1][0] = cvg.O00000oO();
                cvb.O00000o();
            }
            O00000Oo(cvg, new O000000o(cvg));
        }
    }

    public final void O000000o(cvg cvg, int i) {
        cvc cvc = this.f5508O000000o;
        if (cvc != null) {
            cvc.O000000o(cvg, i);
        }
        cvc O00000Oo2 = cvg.O00000Oo();
        if (O00000Oo2 != null) {
            O00000Oo2.O000000o(cvg, i);
        }
    }

    public class O000000o implements cvd {
        private final cvg O00000Oo;

        public O000000o(cvg cvg) {
            this.O00000Oo = cvg;
        }

        public final void O000000o() {
            O000000o(404);
        }

        public final void O000000o(int i) {
            if (i == 200) {
                this.O00000Oo.O000000o("com.sankuai.waimai.router.core.result", Integer.valueOf(i));
                this.O00000Oo.O00000Oo();
                new Object[1][0] = Integer.valueOf(i);
                cvb.O00000o();
            } else if (i != 301) {
                this.O00000Oo.O000000o("com.sankuai.waimai.router.core.result", Integer.valueOf(i));
                RootUriHandler.this.O000000o(this.O00000Oo, i);
                new Object[1][0] = Integer.valueOf(i);
                cvb.O00000o();
            } else {
                new Object[1][0] = Integer.valueOf(i);
                cvb.O00000o();
                RootUriHandler.this.O00000Oo(this.O00000Oo);
            }
        }
    }
}
