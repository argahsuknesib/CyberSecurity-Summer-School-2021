package _m_j;

import O000000o.O000000o.O000000o.O00000oO.j;
import android.content.Context;
import com.hannto.circledialog.params.CircleParams;

public final class O000o00 {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f6620O000000o;
    public CircleParams O00000Oo;
    public O000O0o O00000o0 = new O000O0o(this.f6620O000000o, this.O00000Oo);

    public O000o00(Context context, CircleParams circleParams) {
        this.f6620O000000o = context;
        this.O00000Oo = circleParams;
    }

    public final void O000000o() {
        CircleParams circleParams = this.O00000Oo;
        if (circleParams.O00000oo == null || circleParams.O00000oO == null) {
            CircleParams circleParams2 = this.O00000Oo;
            if (circleParams2.O00000oo != null || circleParams2.O00000oO != null) {
                this.O00000o0.O000000o();
                return;
            }
            return;
        }
        O000O0o o000O0o = this.O00000o0;
        if (o000O0o.O0000Oo0 == null) {
            o000O0o.O0000Oo0 = new O000OOOo(o000O0o.f5256O000000o, o000O0o.O00000Oo);
            j jVar = new j(o000O0o.f5256O000000o);
            jVar.O000000o();
            o000O0o.O00000o0.addView(jVar);
            o000O0o.O00000o0.addView(o000O0o.O0000Oo0);
        }
    }
}
