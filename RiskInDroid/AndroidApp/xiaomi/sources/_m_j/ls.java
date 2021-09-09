package _m_j;

import android.view.View;

public final class ls extends lr {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f2173O000000o = 90.0f;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, int):void
      _m_j.cb.O00000oO(android.view.View, float):void */
    public final void O000000o(View view) {
        cb.O0000OOo(view, (float) view.getMeasuredWidth());
        cb.O0000Oo0(view, ((float) view.getMeasuredHeight()) * 0.5f);
        cb.O00000oO(view, 0.0f);
    }

    public final void O000000o(View view, float f) {
        cb.O0000OOo(view, (float) view.getMeasuredWidth());
        cb.O0000Oo0(view, ((float) view.getMeasuredHeight()) * 0.5f);
        cb.O00000oO(view, this.f2173O000000o * f);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000OOo(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O0000OOo(android.view.View, int):void
      _m_j.cb.O0000OOo(android.view.View, float):void */
    public final void O00000Oo(View view, float f) {
        cb.O0000OOo(view, 0.0f);
        cb.O0000Oo0(view, ((float) view.getMeasuredHeight()) * 0.5f);
        cb.O00000oO(view, this.f2173O000000o * f);
    }
}
