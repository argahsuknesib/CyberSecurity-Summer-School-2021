package _m_j;

import android.view.View;

public final class lx extends lr {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f2175O000000o = 15.0f;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000o(android.view.View, int):void
      _m_j.cb.O00000o(android.view.View, float):void */
    public final void O000000o(View view) {
        cb.O0000OOo(view, ((float) view.getMeasuredWidth()) * 0.5f);
        cb.O0000Oo0(view, (float) view.getMeasuredHeight());
        cb.O00000o(view, 0.0f);
    }

    public final void O000000o(View view, float f) {
        float f2 = this.f2175O000000o * f;
        cb.O0000OOo(view, ((float) view.getMeasuredWidth()) * 0.5f);
        cb.O0000Oo0(view, (float) view.getMeasuredHeight());
        cb.O00000o(view, f2);
    }

    public final void O00000Oo(View view, float f) {
        O000000o(view, f);
    }
}
