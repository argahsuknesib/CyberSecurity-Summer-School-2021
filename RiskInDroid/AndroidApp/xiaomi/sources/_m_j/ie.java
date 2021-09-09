package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
public final class ie extends ViewGroup implements ib {

    /* renamed from: O000000o  reason: collision with root package name */
    ViewGroup f1223O000000o;
    View O00000Oo;
    int O00000o;
    final View O00000o0;
    private Matrix O00000oO;
    private final ViewTreeObserver.OnPreDrawListener O00000oo = new ViewTreeObserver.OnPreDrawListener() {
        /* class _m_j.ie.AnonymousClass1 */

        public final boolean onPreDraw() {
            cb.O00000oo(ie.this);
            if (ie.this.f1223O000000o == null || ie.this.O00000Oo == null) {
                return true;
            }
            ie.this.f1223O000000o.endViewTransition(ie.this.O00000Oo);
            cb.O00000oo(ie.this.f1223O000000o);
            ie ieVar = ie.this;
            ieVar.f1223O000000o = null;
            ieVar.O00000Oo = null;
            return true;
        }
    };

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    private ie(View view) {
        super(view.getContext());
        this.O00000o0 = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
        if (O00000Oo(this.O00000o0) == this) {
            jd.O000000o(this.O00000o0, i == 0 ? 4 : 0);
        }
    }

    public final void O000000o(ViewGroup viewGroup, View view) {
        this.f1223O000000o = viewGroup;
        this.O00000Oo = view;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O00000o0.setTag(R.id.ghost_view, this);
        this.O00000o0.getViewTreeObserver().addOnPreDrawListener(this.O00000oo);
        jd.O000000o(this.O00000o0, 4);
        if (this.O00000o0.getParent() != null) {
            ((View) this.O00000o0.getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        this.O00000o0.getViewTreeObserver().removeOnPreDrawListener(this.O00000oo);
        jd.O000000o(this.O00000o0, 0);
        this.O00000o0.setTag(R.id.ghost_view, null);
        if (this.O00000o0.getParent() != null) {
            ((View) this.O00000o0.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        hx.O000000o(canvas, true);
        canvas.setMatrix(this.O00000oO);
        jd.O000000o(this.O00000o0, 0);
        this.O00000o0.invalidate();
        jd.O000000o(this.O00000o0, 4);
        drawChild(canvas, this.O00000o0, getDrawingTime());
        hx.O000000o(canvas, false);
    }

    private static void O000000o(View view, View view2) {
        jd.O000000o(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    private static ie O00000Oo(View view) {
        return (ie) view.getTag(R.id.ghost_view);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ie.O000000o(android.view.View, android.view.View):void
     arg types: [android.view.ViewGroup, _m_j.ic]
     candidates:
      _m_j.ie.O000000o(android.view.ViewGroup, android.view.View):void
      _m_j.ib.O000000o(android.view.ViewGroup, android.view.View):void
      _m_j.ie.O000000o(android.view.View, android.view.View):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ie.O000000o(android.view.View, android.view.View):void
     arg types: [android.view.ViewGroup, _m_j.ie]
     candidates:
      _m_j.ie.O000000o(android.view.ViewGroup, android.view.View):void
      _m_j.ib.O000000o(android.view.ViewGroup, android.view.View):void
      _m_j.ie.O000000o(android.view.View, android.view.View):void */
    public static ie O000000o(View view, ViewGroup viewGroup, Matrix matrix) {
        ic icVar;
        if (view.getParent() instanceof ViewGroup) {
            ic O000000o2 = ic.O000000o(viewGroup);
            ie O00000Oo2 = O00000Oo(view);
            int i = 0;
            if (!(O00000Oo2 == null || (icVar = (ic) O00000Oo2.getParent()) == O000000o2)) {
                i = O00000Oo2.O00000o;
                icVar.removeView(O00000Oo2);
                O00000Oo2 = null;
            }
            if (O00000Oo2 == null) {
                O00000Oo2 = new ie(view);
                O00000Oo2.O00000oO = matrix;
                if (O000000o2 == null) {
                    O000000o2 = new ic(viewGroup);
                } else if (O000000o2.O00000Oo) {
                    iy.O000000o(O000000o2.f1170O000000o).O00000Oo(O000000o2);
                    iy.O000000o(O000000o2.f1170O000000o).O000000o(O000000o2);
                } else {
                    throw new IllegalStateException("This GhostViewHolder is detached!");
                }
                O000000o((View) viewGroup, (View) O000000o2);
                O000000o((View) viewGroup, (View) O00000Oo2);
                ArrayList arrayList = new ArrayList();
                ic.O000000o(O00000Oo2.O00000o0, arrayList);
                int O000000o3 = O000000o2.O000000o(arrayList);
                if (O000000o3 < 0 || O000000o3 >= O000000o2.getChildCount()) {
                    O000000o2.addView(O00000Oo2);
                } else {
                    O000000o2.addView(O00000Oo2, O000000o3);
                }
                O00000Oo2.O00000o = i;
            } else {
                O00000Oo2.O00000oO = matrix;
            }
            O00000Oo2.O00000o++;
            return O00000Oo2;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void O000000o(View view) {
        ie O00000Oo2 = O00000Oo(view);
        if (O00000Oo2 != null) {
            O00000Oo2.O00000o--;
            if (O00000Oo2.O00000o <= 0) {
                ((ic) O00000Oo2.getParent()).removeView(O00000Oo2);
            }
        }
    }
}
