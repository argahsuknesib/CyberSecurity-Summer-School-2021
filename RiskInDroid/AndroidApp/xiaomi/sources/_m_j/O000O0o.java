package _m_j;

import O000000o.O000000o.O000000o.O00000oO.h;
import O000000o.O000000o.O000000o.O00000oO.j;
import O000000o.O000000o.O000000o.O00000oO.t;
import O000000o.O000000o.O000000o.O00000oO.u;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.hannto.circledialog.params.CircleParams;

public final class O000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f5256O000000o;
    public CircleParams O00000Oo;
    public u O00000o;
    public LinearLayout O00000o0;
    public h O00000oO;
    public O00oOooO O00000oo;
    public O000O0OO O0000O0o;
    public O0000o0 O0000OOo;
    public t O0000Oo;
    public O000OOOo O0000Oo0;
    public View O0000OoO;

    public O000O0o(Context context, CircleParams circleParams) {
        this.f5256O000000o = context;
        this.O00000Oo = circleParams;
    }

    public final void O000000o() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new t(this.f5256O000000o, this.O00000Oo);
            j jVar = new j(this.f5256O000000o);
            jVar.O000000o();
            this.O00000o0.addView(jVar);
            this.O00000o0.addView(this.O0000Oo);
        }
    }
}
