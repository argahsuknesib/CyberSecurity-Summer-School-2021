package in.srain.cube.views.ptr;

import android.os.Build;
import android.view.View;
import android.widget.AbsListView;

public abstract class PtrDefaultHandler implements PtrHandler {
    public static boolean canChildScrollUp(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(-1);
        }
        if (!(view instanceof AbsListView)) {
            return view.getScrollY() > 0;
        }
        AbsListView absListView = (AbsListView) view;
        return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
    }

    public static boolean checkContentCanBePulledDown(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        return !canChildScrollUp(view);
    }

    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        return checkContentCanBePulledDown(ptrFrameLayout, view, view2);
    }
}
