package _m_j;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

abstract class axb extends RecyclerView.O0000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    int f12675O000000o = 200;
    Interpolator O00000Oo;
    protected RecyclerView.O000OOo0 O00000o;
    protected final RecyclerView O00000o0;
    private final int O00000oO;

    public axb(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
        this.O00000o0 = recyclerView;
        this.O00000o = o000OOo0;
        this.O00000oO = (int) ((recyclerView.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
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
     method: _m_j.cb.O00000Oo(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O00000Oo(android.view.View, _m_j.ci):_m_j.ci
      _m_j.cb.O00000Oo(android.view.View, boolean):void
      _m_j.cb.O00000Oo(android.view.View, int):boolean
      _m_j.cb.O00000Oo(android.view.View, android.view.KeyEvent):boolean
      _m_j.cb.O00000Oo(android.view.View, float):void */
    /* access modifiers changed from: protected */
    public final void O000000o(View view, boolean z) {
        int O0000o00 = (int) cb.O0000o00(view);
        int O0000o0 = (int) cb.O0000o0(view);
        int width = view.getWidth() / 2;
        int height = view.getHeight() / 2;
        float abs = width > 0 ? Math.abs(((float) O0000o00) / ((float) width)) : 0.0f;
        float abs2 = height > 0 ? Math.abs(((float) O0000o0) / ((float) height)) : 0.0f;
        float min = 1.0f - Math.min(abs, 1.0f);
        float min2 = 1.0f - Math.min(abs2, 1.0f);
        int i = this.f12675O000000o;
        int max = Math.max((int) ((((float) i) * (1.0f - (min * min))) + 0.5f), (int) ((((float) i) * (1.0f - (min2 * min2))) + 0.5f));
        int max2 = Math.max(Math.abs(O0000o00), Math.abs(O0000o0));
        if (!(Build.VERSION.SDK_INT >= 11) || max <= 20 || max2 <= this.O00000oO) {
            cb.O000000o(view, 0.0f);
            cb.O00000Oo(view, 0.0f);
            return;
        }
        final ce O0000o = cb.O0000o(view);
        O0000o.O00000Oo();
        O0000o.O000000o((long) max);
        O0000o.O000000o(this.O00000Oo);
        O0000o.O00000Oo(0.0f);
        O0000o.O00000o0(0.0f);
        O0000o.O000000o(new cf() {
            /* class _m_j.axb.AnonymousClass1 */

            public final void O000000o(View view) {
            }

            public final void O00000o0(View view) {
            }

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
             method: _m_j.cb.O00000Oo(android.view.View, float):void
             arg types: [android.view.View, int]
             candidates:
              _m_j.cb.O00000Oo(android.view.View, _m_j.ci):_m_j.ci
              _m_j.cb.O00000Oo(android.view.View, boolean):void
              _m_j.cb.O00000Oo(android.view.View, int):boolean
              _m_j.cb.O00000Oo(android.view.View, android.view.KeyEvent):boolean
              _m_j.cb.O00000Oo(android.view.View, float):void */
            public final void O00000Oo(View view) {
                O0000o.O000000o((cf) null);
                cb.O000000o(view, 0.0f);
                cb.O00000Oo(view, 0.0f);
                if (view.getParent() instanceof RecyclerView) {
                    cb.O00000oo((RecyclerView) view.getParent());
                }
            }
        });
        O0000o.O00000o0();
    }

    protected static void O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, float f, float f2) {
        RecyclerView.O0000OOo itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.O00000o0(o000OOo0);
        }
        cb.O000000o(o000OOo0.itemView, f);
        cb.O00000Oo(o000OOo0.itemView, f2);
    }
}
