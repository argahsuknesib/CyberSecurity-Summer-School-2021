package _m_j;

import android.graphics.Canvas;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.widget.RecyclerView;

public abstract class axc extends RecyclerView.O0000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public RecyclerView f12677O000000o;
    EdgeEffectCompat O00000Oo;
    public boolean O00000o;
    EdgeEffectCompat O00000o0;
    int O00000oO;
    int O00000oo;

    /* access modifiers changed from: protected */
    public abstract int O000000o(int i);

    public axc(RecyclerView recyclerView) {
        this.f12677O000000o = recyclerView;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        EdgeEffectCompat edgeEffectCompat = this.O00000Oo;
        boolean z = false;
        if (edgeEffectCompat != null) {
            z = false | O000000o(canvas, recyclerView, this.O00000oO, edgeEffectCompat);
        }
        EdgeEffectCompat edgeEffectCompat2 = this.O00000o0;
        if (edgeEffectCompat2 != null) {
            z |= O000000o(canvas, recyclerView, this.O00000oo, edgeEffectCompat2);
        }
        if (z) {
            cb.O00000oo(recyclerView);
        }
    }

    public final void O000000o() {
        if (!this.O00000o) {
            this.O00000oO = O000000o(0);
            this.O00000oo = O000000o(1);
            this.f12677O000000o.addItemDecoration(this);
            this.O00000o = true;
        }
    }

    public final void O00000Oo() {
        EdgeEffectCompat edgeEffectCompat = this.O00000Oo;
        boolean z = false;
        if (edgeEffectCompat != null) {
            z = false | edgeEffectCompat.O000000o();
        }
        EdgeEffectCompat edgeEffectCompat2 = this.O00000o0;
        if (edgeEffectCompat2 != null) {
            z |= edgeEffectCompat2.O000000o();
        }
        if (z) {
            cb.O00000oo(this.f12677O000000o);
        }
    }

    static void O000000o(RecyclerView recyclerView, EdgeEffectCompat edgeEffectCompat, int i) {
        int measuredWidth = recyclerView.getMeasuredWidth();
        int measuredHeight = recyclerView.getMeasuredHeight();
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            measuredWidth -= recyclerView.getPaddingLeft() + recyclerView.getPaddingRight();
            measuredHeight -= recyclerView.getPaddingTop() + recyclerView.getPaddingBottom();
        }
        int max = Math.max(0, measuredWidth);
        int max2 = Math.max(0, measuredHeight);
        if (!(i == 0 || i == 2)) {
            int i2 = max;
            max = max2;
            max2 = i2;
        }
        edgeEffectCompat.O000000o(max2, max);
    }

    private static boolean O000000o(Canvas canvas, RecyclerView recyclerView, int i, EdgeEffectCompat edgeEffectCompat) {
        if (edgeEffectCompat.f2846O000000o.isFinished()) {
            return false;
        }
        int save = canvas.save();
        boolean clipToPadding = recyclerView.getLayoutManager().getClipToPadding();
        if (i == 0) {
            canvas.rotate(-90.0f);
            if (clipToPadding) {
                canvas.translate((float) ((-recyclerView.getHeight()) + recyclerView.getPaddingTop()), (float) recyclerView.getPaddingLeft());
            } else {
                canvas.translate((float) (-recyclerView.getHeight()), 0.0f);
            }
        } else if (i != 1) {
            if (i == 2) {
                canvas.rotate(90.0f);
                if (clipToPadding) {
                    canvas.translate((float) recyclerView.getPaddingTop(), (float) ((-recyclerView.getWidth()) + recyclerView.getPaddingRight()));
                } else {
                    canvas.translate(0.0f, (float) (-recyclerView.getWidth()));
                }
            } else if (i == 3) {
                canvas.rotate(180.0f);
                if (clipToPadding) {
                    canvas.translate((float) ((-recyclerView.getWidth()) + recyclerView.getPaddingRight()), (float) ((-recyclerView.getHeight()) + recyclerView.getPaddingBottom()));
                } else {
                    canvas.translate((float) (-recyclerView.getWidth()), (float) (-recyclerView.getHeight()));
                }
            }
        } else if (clipToPadding) {
            canvas.translate((float) recyclerView.getPaddingLeft(), (float) recyclerView.getPaddingTop());
        }
        boolean O000000o2 = edgeEffectCompat.O000000o(canvas);
        canvas.restoreToCount(save);
        return O000000o2;
    }
}
