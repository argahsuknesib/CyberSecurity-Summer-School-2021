package _m_j;

import android.view.View;

public final class mb extends lr {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f2179O000000o = 0.85f;
    private float O00000Oo = 0.65f;

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
        float max = Math.max(this.f2179O000000o, f + 1.0f);
        float f2 = 1.0f - max;
        cb.O000000o(view, ((((float) view.getWidth()) * f2) / 2.0f) - (((((float) view.getHeight()) * f2) / 2.0f) / 2.0f));
        cb.O00000oo(view, max);
        cb.O0000O0o(view, max);
        float f3 = this.O00000Oo;
        float f4 = this.f2179O000000o;
        cb.O00000o0(view, f3 + (((max - f4) / (1.0f - f4)) * (1.0f - f3)));
    }

    public final void O00000Oo(View view, float f) {
        float max = Math.max(this.f2179O000000o, 1.0f - f);
        float f2 = 1.0f - max;
        cb.O000000o(view, (-((((float) view.getWidth()) * f2) / 2.0f)) + (((((float) view.getHeight()) * f2) / 2.0f) / 2.0f));
        cb.O00000oo(view, max);
        cb.O0000O0o(view, max);
        float f3 = this.O00000Oo;
        float f4 = this.f2179O000000o;
        cb.O00000o0(view, f3 + (((max - f4) / (1.0f - f4)) * (1.0f - f3)));
    }
}
