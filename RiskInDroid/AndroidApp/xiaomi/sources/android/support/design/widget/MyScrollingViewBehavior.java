package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public class MyScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    private CoordinatorLayout.Behavior mListenerBehavior;

    public MyScrollingViewBehavior() {
    }

    public MyScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setListenerBehavior(CoordinatorLayout.Behavior behavior) {
        this.mListenerBehavior = behavior;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return super.onDependentViewChanged(coordinatorLayout, view, view2);
    }
}
