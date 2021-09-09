package _m_j;

import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

public final class daq {
    public static boolean O000000o(View view, PointF pointF) {
        if (O000000o(view) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (O000000o(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                pointF.offset(pointF2.x, pointF2.y);
                boolean O000000o2 = O000000o(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return O000000o2;
            }
        }
        return true;
    }

    public static boolean O000000o(View view, PointF pointF, boolean z) {
        if (O00000Oo(view) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !dar.O00000Oo(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (O000000o(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean O000000o2 = O000000o(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return O000000o2;
                }
            }
        }
        if (z || O000000o(view)) {
            return true;
        }
        return false;
    }

    public static boolean O000000o(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(-1);
        }
        if (!(view instanceof AbsListView)) {
            return view.getScrollY() > 0;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        return viewGroup.getChildCount() > 0 && (((AbsListView) view).getFirstVisiblePosition() > 0 || viewGroup.getChildAt(0).getTop() < view.getPaddingTop());
    }

    public static boolean O00000Oo(View view) {
        int i;
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(1);
        }
        if (view instanceof AbsListView) {
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            int childCount = viewGroup.getChildCount();
            if (childCount <= 0 || (absListView.getLastVisiblePosition() >= (i = childCount - 1) && viewGroup.getChildAt(i).getBottom() <= view.getPaddingBottom())) {
                return false;
            }
            return true;
        } else if (view.getScrollY() < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean O000000o(View view, View view2, float f, float f2, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f, f2};
        fArr[0] = fArr[0] + ((float) (view.getScrollX() - view2.getLeft()));
        fArr[1] = fArr[1] + ((float) (view.getScrollY() - view2.getTop()));
        boolean z = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z) {
            pointF.set(fArr[0] - f, fArr[1] - f2);
        }
        return z;
    }
}
