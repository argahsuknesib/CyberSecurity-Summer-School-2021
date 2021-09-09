package _m_j;

import android.view.View;

public final class lz extends lr {
    public final void O000000o(View view) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000o0(android.view.View, int):void
      _m_j.cb.O00000o0(android.view.View, boolean):void
      _m_j.cb.O00000o0(android.view.View, float):void */
    public final void O000000o(View view, float f) {
        cb.O000000o(view, ((float) (-view.getWidth())) * f);
        cb.O0000OOo(view, ((float) view.getWidth()) * 0.5f);
        cb.O0000Oo0(view, ((float) view.getHeight()) * 0.5f);
        float f2 = f + 1.0f;
        cb.O00000oo(view, f2);
        cb.O0000O0o(view, f2);
        if (f < -0.95f) {
            cb.O00000o0(view, 0.0f);
        } else {
            cb.O00000o0(view, 1.0f);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000o0(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000o0(android.view.View, int):void
      _m_j.cb.O00000o0(android.view.View, boolean):void
      _m_j.cb.O00000o0(android.view.View, float):void */
    public final void O00000Oo(View view, float f) {
        cb.O000000o(view, ((float) (-view.getWidth())) * f);
        cb.O0000OOo(view, ((float) view.getWidth()) * 0.5f);
        cb.O0000Oo0(view, ((float) view.getHeight()) * 0.5f);
        float f2 = 1.0f - f;
        cb.O00000oo(view, f2);
        cb.O0000O0o(view, f2);
        if (f > 0.95f) {
            cb.O00000o0(view, 0.0f);
        } else {
            cb.O00000o0(view, 1.0f);
        }
    }
}
