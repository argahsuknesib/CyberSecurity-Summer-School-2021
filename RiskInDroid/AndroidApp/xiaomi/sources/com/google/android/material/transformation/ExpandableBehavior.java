package com.google.android.material.transformation;

import _m_j.cb;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    public int currentState = 0;

    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* access modifiers changed from: protected */
    public abstract boolean onExpandedStateChange(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = findExpandableWidget(r3, r4);
     */
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int i) {
        final ExpandableWidget findExpandableWidget;
        if (cb.O000O0oO(view) || findExpandableWidget == null || !didStateChange(findExpandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = findExpandableWidget.isExpanded() ? 1 : 2;
        final int i2 = this.currentState;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.google.android.material.transformation.ExpandableBehavior.AnonymousClass1 */

            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableBehavior.this.currentState == i2) {
                    ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                    ExpandableWidget expandableWidget = findExpandableWidget;
                    expandableBehavior.onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), false);
                }
                return false;
            }
        });
        return false;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = expandableWidget.isExpanded() ? 1 : 2;
        return onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    /* access modifiers changed from: protected */
    public ExpandableWidget findExpandableWidget(CoordinatorLayout coordinatorLayout, View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View view2 = dependencies.get(i);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    private boolean didStateChange(boolean z) {
        if (!z) {
            return this.currentState == 1;
        }
        int i = this.currentState;
        return i == 0 || i == 2;
    }

    public static <T extends ExpandableBehavior> T from(View view, Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.O00000o) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.O00000o) layoutParams).f2811O000000o;
            if (behavior instanceof ExpandableBehavior) {
                return (ExpandableBehavior) cls.cast(behavior);
            }
            throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
