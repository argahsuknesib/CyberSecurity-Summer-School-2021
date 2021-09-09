package _m_j;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class ha extends he {
    private gz O00000Oo;
    private gz O00000o0;

    public final int[] O000000o(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = O000000o(view, O00000o(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = O000000o(view, O00000o0(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View O000000o(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return O000000o(layoutManager, O00000o0(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return O000000o(layoutManager, O00000o(layoutManager));
        }
        return null;
    }

    public final int O000000o(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        gz gzVar;
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        if (layoutManager.canScrollVertically()) {
            gzVar = O00000o0(layoutManager);
        } else if (layoutManager.canScrollHorizontally()) {
            gzVar = O00000o(layoutManager);
        } else {
            gzVar = null;
        }
        if (gzVar == null) {
            return -1;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        boolean z = false;
        View view = null;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int O000000o2 = O000000o(childAt, gzVar);
                if (O000000o2 <= 0 && O000000o2 > i3) {
                    view2 = childAt;
                    i3 = O000000o2;
                }
                if (O000000o2 >= 0 && O000000o2 < i4) {
                    view = childAt;
                    i4 = O000000o2;
                }
            }
        }
        int i6 = 1;
        boolean z2 = !layoutManager.canScrollHorizontally() ? i2 > 0 : i > 0;
        if (z2 && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!z2 && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (z2) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view);
        int itemCount2 = layoutManager.getItemCount();
        if ((layoutManager instanceof RecyclerView.O000OO00.O00000Oo) && (computeScrollVectorForPosition = ((RecyclerView.O000OO00.O00000Oo) layoutManager).computeScrollVectorForPosition(itemCount2 - 1)) != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f)) {
            z = true;
        }
        if (z == z2) {
            i6 = -1;
        }
        int i7 = position + i6;
        if (i7 < 0 || i7 >= itemCount) {
            return -1;
        }
        return i7;
    }

    /* access modifiers changed from: protected */
    public final LinearSmoothScroller O00000Oo(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.O000OO00.O00000Oo)) {
            return null;
        }
        return new LinearSmoothScroller(this.f18829O000000o.getContext()) {
            /* class _m_j.ha.AnonymousClass1 */

            public final void onTargetFound(View view, RecyclerView.O000OO0o o000OO0o, RecyclerView.O000OO00.O000000o o000000o) {
                ha haVar = ha.this;
                int[] O000000o2 = haVar.O000000o(haVar.f18829O000000o.getLayoutManager(), view);
                int i = O000000o2[0];
                int i2 = O000000o2[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    o000000o.O000000o(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            public final int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }
        };
    }

    private static int O000000o(View view, gz gzVar) {
        return (gzVar.O000000o(view) + (gzVar.O00000oO(view) / 2)) - (gzVar.O00000Oo() + (gzVar.O00000oO() / 2));
    }

    private static View O000000o(RecyclerView.LayoutManager layoutManager, gz gzVar) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int O00000Oo2 = gzVar.O00000Oo() + (gzVar.O00000oO() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs((gzVar.O000000o(childAt) + (gzVar.O00000oO(childAt) / 2)) - O00000Oo2);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    private gz O00000o0(RecyclerView.LayoutManager layoutManager) {
        gz gzVar = this.O00000Oo;
        if (gzVar == null || gzVar.f18606O000000o != layoutManager) {
            this.O00000Oo = gz.O00000Oo(layoutManager);
        }
        return this.O00000Oo;
    }

    private gz O00000o(RecyclerView.LayoutManager layoutManager) {
        gz gzVar = this.O00000o0;
        if (gzVar == null || gzVar.f18606O000000o != layoutManager) {
            this.O00000o0 = gz.O000000o(layoutManager);
        }
        return this.O00000o0;
    }
}
