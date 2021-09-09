package _m_j;

import android.view.View;

public final class lu extends lr {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f2174O000000o = 0.8f;

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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000o0(android.view.View, int):void
      _m_j.cb.O00000o0(android.view.View, boolean):void
      _m_j.cb.O00000o0(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O000000o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O000000o(int, int):int
      _m_j.cb.O000000o(android.view.View, _m_j.ci):_m_j.ci
      _m_j.cb.O000000o(int, android.view.View):void
      _m_j.cb.O000000o(android.view.View, _m_j.bh):void
      _m_j.cb.O000000o(android.view.View, _m_j.bw):void
      _m_j.cb.O000000o(android.view.View, _m_j.by):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl$O000000o):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl):void
      _m_j.cb.O000000o(android.view.View, android.content.res.ColorStateList):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Paint):void
      _m_j.cb.O000000o(android.view.View, android.graphics.PorterDuff$Mode):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Rect):void
      _m_j.cb.O000000o(android.view.View, android.graphics.drawable.Drawable):void
      _m_j.cb.O000000o(android.view.View, java.lang.Runnable):void
      _m_j.cb.O000000o(android.view.View, java.lang.String):void
      _m_j.cb.O000000o(android.view.View, boolean):void
      _m_j.cb.O000000o(android.view.View, int):boolean
      _m_j.cb.O000000o(android.view.View, android.view.KeyEvent):boolean
      _m_j.cb.O000000o(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oo(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000oo(android.view.View, int):void
      _m_j.cb.O00000oo(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000O0o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O0000O0o(android.view.View, int):void
      _m_j.cb.O0000O0o(android.view.View, float):void */
    public final void O000000o(View view, float f) {
        cb.O00000o0(view, 1.0f);
        cb.O000000o(view, 0.0f);
        cb.O00000oo(view, 1.0f);
        cb.O0000O0o(view, 1.0f);
    }

    public final void O00000Oo(View view, float f) {
        float f2 = 1.0f - f;
        cb.O00000o0(view, f2);
        cb.O000000o(view, ((float) (-view.getWidth())) * f);
        float f3 = this.f2174O000000o;
        float f4 = f3 + ((1.0f - f3) * f2);
        cb.O00000oo(view, f4);
        cb.O0000O0o(view, f4);
    }
}
