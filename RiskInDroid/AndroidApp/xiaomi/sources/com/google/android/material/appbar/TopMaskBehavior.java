package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public class TopMaskBehavior extends ViewOffsetBehavior<View> {
    public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
        return super.getLeftAndRightOffset();
    }

    public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }

    public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
        return super.isHorizontalOffsetEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
        return super.isVerticalOffsetEnabled();
    }

    public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        return super.onLayoutChild(coordinatorLayout, view, i);
    }

    public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
        super.setHorizontalOffsetEnabled(z);
    }

    public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
        return super.setLeftAndRightOffset(i);
    }

    public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
        return super.setTopAndBottomOffset(i);
    }

    public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
        super.setVerticalOffsetEnabled(z);
    }

    public TopMaskBehavior() {
    }

    public TopMaskBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof AppBarLayout;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.O00000o) view2.getLayoutParams()).f2811O000000o;
        if (!(behavior instanceof AppBarLayout.BaseBehavior)) {
            return false;
        }
        setTopAndBottomOffset(((AppBarLayout.BaseBehavior) behavior).getTopAndBottomOffset());
        return true;
    }
}
