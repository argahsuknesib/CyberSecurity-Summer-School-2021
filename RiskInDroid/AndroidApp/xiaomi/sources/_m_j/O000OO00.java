package _m_j;

import android.view.View;

public final class O000OO00 implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ O000OOOo f5259O000000o;

    public O000OO00(O000OOOo o000OOOo) {
        this.f5259O000000o = o000OOOo;
    }

    public final void onClick(View view) {
        if (this.f5259O000000o.f5261O000000o.O00000o0 != null) {
            this.f5259O000000o.f5261O000000o.O00000o0.onClick(view);
        }
        if (this.f5259O000000o.f5261O000000o.O0000OoO) {
            this.f5259O000000o.f5261O000000o.O00000o0 = null;
            this.f5259O000000o.f5261O000000o.O000000o();
        }
    }
}
