package _m_j;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class gw extends he {
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

    public final int O000000o(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        View O000000o2;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(layoutManager instanceof RecyclerView.O000OO00.O00000Oo) || (itemCount = layoutManager.getItemCount()) == 0 || (O000000o2 = O000000o(layoutManager)) == null || (position = layoutManager.getPosition(O000000o2)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.O000OO00.O00000Oo) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            i4 = O000000o(layoutManager, O00000o(layoutManager), i, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i5 = O000000o(layoutManager, O00000o0(layoutManager), 0, i2);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = position + i4;
        if (i6 < 0) {
            i6 = 0;
        }
        return i6 >= itemCount ? i3 : i6;
    }

    public final View O000000o(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return O000000o(layoutManager, O00000o0(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return O000000o(layoutManager, O00000o(layoutManager));
        }
        return null;
    }

    private static int O000000o(View view, gz gzVar) {
        return (gzVar.O000000o(view) + (gzVar.O00000oO(view) / 2)) - (gzVar.O00000Oo() + (gzVar.O00000oO() / 2));
    }

    private int O000000o(RecyclerView.LayoutManager layoutManager, gz gzVar, int i, int i2) {
        int[] O00000Oo2 = O00000Oo(i, i2);
        float O00000Oo3 = O00000Oo(layoutManager, gzVar);
        if (O00000Oo3 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(O00000Oo2[0]) > Math.abs(O00000Oo2[1]) ? O00000Oo2[0] : O00000Oo2[1])) / O00000Oo3);
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

    private static float O00000Oo(RecyclerView.LayoutManager layoutManager, gz gzVar) {
        int max;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int position = layoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i) {
                    view = childAt;
                    i = position;
                }
                if (position > i2) {
                    view2 = childAt;
                    i2 = position;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(gzVar.O00000Oo(view), gzVar.O00000Oo(view2)) - Math.min(gzVar.O000000o(view), gzVar.O000000o(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i2 - i) + 1));
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
