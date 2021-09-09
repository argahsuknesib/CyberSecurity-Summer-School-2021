package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int additionalHiddenOffsetY = 0;
    public ViewPropertyAnimator currentAnimator;
    private int currentState = 2;
    private int height = 0;

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.height = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v, i);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: V
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public void setAdditionalHiddenOffsetY(V r2, int r3) {
        /*
            r1 = this;
            r1.additionalHiddenOffsetY = r3
            int r3 = r1.currentState
            r0 = 1
            if (r3 != r0) goto L_0x0010
            int r3 = r1.height
            int r0 = r1.additionalHiddenOffsetY
            int r3 = r3 + r0
            float r3 = (float) r3
            r2.setTranslationY(r3)
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.setAdditionalHiddenOffsetY(android.view.View, int):void");
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            slideDown(v);
        } else if (i2 < 0) {
            slideUp(v);
        }
    }

    public void slideUp(V v) {
        if (this.currentState != 2) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v.clearAnimation();
            }
            this.currentState = 2;
            animateChildTo(v, 0, 225, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        }
    }

    public void slideDown(V v) {
        if (this.currentState != 1) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v.clearAnimation();
            }
            this.currentState = 1;
            animateChildTo(v, this.height + this.additionalHiddenOffsetY, 175, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        }
    }

    private void animateChildTo(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.currentAnimator = v.animate().translationY((float) i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.behavior.HideBottomViewOnScrollBehavior.AnonymousClass1 */

            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.currentAnimator = null;
            }
        });
    }
}
