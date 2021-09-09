package _m_j;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

final class axm extends axb {
    Interpolator O00000oO;
    private RecyclerView.O000OOo0 O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private final Rect O0000Oo = new Rect();
    private final Rect O0000Oo0 = new Rect();
    private final Rect O0000OoO = new Rect();
    private boolean O0000Ooo;
    private boolean O0000o;
    private float O0000o0;
    private float O0000o00;
    private axi O0000o0O;
    private axj O0000o0o;

    public axm(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, axj axj, axi axi) {
        super(recyclerView, o000OOo0);
        this.O0000o0O = axi;
        this.O0000o0o = axj;
        ayd.O000000o(this.O00000o0.getLayoutManager(), this.O00000o.itemView, this.O0000OoO);
    }

    public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        RecyclerView.O000OOo0 o000OOo02 = this.O00000oo;
        if (o000OOo02 != o000OOo0) {
            if (o000OOo02 != null) {
                cb.O0000o(o000OOo02.itemView).O00000Oo(0.0f).O00000o0(0.0f).O000000o(10L).O00000o0();
            }
            this.O00000oo = o000OOo0;
            this.O0000o = true;
        }
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
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        float f;
        RecyclerView.O000OOo0 o000OOo0 = this.O00000o;
        RecyclerView.O000OOo0 o000OOo02 = this.O00000oo;
        if (o000OOo0 != null && o000OOo02 != null && o000OOo0.getItemId() == this.O0000o0O.O00000o0) {
            View view = o000OOo02.itemView;
            int layoutPosition = o000OOo0.getLayoutPosition();
            int layoutPosition2 = o000OOo02.getLayoutPosition();
            ayd.O000000o(this.O00000o0.getLayoutManager(), view, this.O0000Oo0);
            ayd.O000000o(view, this.O0000Oo);
            Rect rect = this.O0000Oo;
            Rect rect2 = this.O0000Oo0;
            int height = view.getHeight() + rect.top + rect.bottom + rect2.top + rect2.bottom;
            int width = view.getWidth() + rect.left + rect.right + rect2.left + rect2.right;
            float left = width != 0 ? ((float) (o000OOo0.itemView.getLeft() - this.O0000O0o)) / ((float) width) : 0.0f;
            float top = height != 0 ? ((float) (o000OOo0.itemView.getTop() - this.O0000OOo)) / ((float) height) : 0.0f;
            int O00000Oo = ayd.O00000Oo(this.O00000o0.getLayoutManager());
            if (O00000Oo == 1) {
                left = layoutPosition > layoutPosition2 ? top : top + 1.0f;
            } else if (O00000Oo != 0) {
                left = 0.0f;
            } else if (layoutPosition <= layoutPosition2) {
                left += 1.0f;
            }
            this.O0000o00 = Math.min(Math.max(left, 0.0f), 1.0f);
            if (this.O0000o) {
                this.O0000o = false;
                f = this.O0000o00;
            } else {
                float f2 = this.O0000o0;
                float f3 = this.O0000o00;
                f = (f2 * 0.7f) + (0.3f * f3);
                if (Math.abs(f - f3) < 0.01f) {
                    f = f3;
                }
            }
            this.O0000o0 = f;
            O000000o(o000OOo0, o000OOo02, this.O0000o0);
        }
    }

    private void O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02, float f) {
        View view = o000OOo02.itemView;
        int layoutPosition = o000OOo0.getLayoutPosition();
        int layoutPosition2 = o000OOo02.getLayoutPosition();
        Rect rect = this.O0000o0O.O0000OOo;
        Rect rect2 = this.O0000OoO;
        int i = this.O0000o0O.O00000Oo + rect.top + rect.bottom + rect2.top + rect2.bottom;
        int i2 = this.O0000o0O.f12680O000000o + rect.left + rect.right + rect2.left + rect2.right;
        Interpolator interpolator = this.O00000oO;
        if (interpolator != null) {
            f = interpolator.getInterpolation(f);
        }
        int O00000Oo = ayd.O00000Oo(this.O00000o0.getLayoutManager());
        if (O00000Oo != 0) {
            if (O00000Oo == 1) {
                if (layoutPosition > layoutPosition2) {
                    cb.O00000Oo(view, f * ((float) i));
                } else {
                    cb.O00000Oo(view, (f - 1.0f) * ((float) i));
                }
            }
        } else if (layoutPosition > layoutPosition2) {
            cb.O000000o(view, f * ((float) i2));
        } else {
            cb.O000000o(view, (f - 1.0f) * ((float) i2));
        }
    }

    public final void O000000o() {
        if (!this.O0000Ooo) {
            this.O00000o0.addItemDecoration(this, 0);
            this.O0000Ooo = true;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axb.O000000o(android.view.View, boolean):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.axm.O000000o(int, int):void
      _m_j.axb.O000000o(android.view.View, boolean):void */
    public final void O00000Oo() {
        if (this.O0000Ooo) {
            this.O00000o0.removeItemDecoration(this);
        }
        RecyclerView.O0000OOo itemAnimator = this.O00000o0.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.O00000o();
        }
        this.O00000o0.stopScroll();
        if (this.O00000oo != null) {
            O000000o(this.O00000o, this.O00000oo, this.O0000o0);
            O000000o(this.O00000oo.itemView, true);
            this.O00000oo = null;
        }
        this.O0000o0o = null;
        this.O00000o = null;
        this.O0000O0o = 0;
        this.O0000OOo = 0;
        this.O0000o0 = 0.0f;
        this.O0000o00 = 0.0f;
        this.O0000Ooo = false;
        this.O0000o0O = null;
    }

    public final void O000000o(int i, int i2) {
        this.O0000O0o = i;
        this.O0000OOo = i2;
    }
}
