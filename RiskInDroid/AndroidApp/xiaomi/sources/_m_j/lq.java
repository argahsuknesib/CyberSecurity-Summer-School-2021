package _m_j;

import android.view.View;

public final class lq extends lr {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f2171O000000o = 0.4f;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000o0(android.view.View, int):void
      _m_j.cb.O00000o0(android.view.View, boolean):void
      _m_j.cb.O00000o0(android.view.View, float):void */
    public final void O000000o(View view) {
        cb.O00000o0(view, 0.0f);
    }

    public final void O000000o(View view, float f) {
        float f2 = this.f2171O000000o;
        cb.O00000o0(view, f2 + ((1.0f - f2) * (f + 1.0f)));
    }

    public final void O00000Oo(View view, float f) {
        float f2 = this.f2171O000000o;
        cb.O00000o0(view, f2 + ((1.0f - f2) * (1.0f - f)));
    }
}
