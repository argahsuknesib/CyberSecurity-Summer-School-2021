package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

@TargetApi(19)
public class DraweeTransition extends Transition {
    private final PointF mFromFocusPoint;
    private final ScalingUtils.ScaleType mFromScale;
    public final PointF mToFocusPoint;
    public final ScalingUtils.ScaleType mToScale;

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2) {
        return createTransitionSet(scaleType, scaleType2, null, null);
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2, PointF pointF, PointF pointF2) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new DraweeTransition(scaleType, scaleType2, pointF, pointF2));
        return transitionSet;
    }

    public DraweeTransition(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2, PointF pointF, PointF pointF2) {
        this.mFromScale = scaleType;
        this.mToScale = scaleType2;
        this.mFromFocusPoint = pointF;
        this.mToFocusPoint = pointF2;
    }

    public DraweeTransition(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2) {
        this(scaleType, scaleType2, null, null);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (!(transitionValues == null || transitionValues2 == null)) {
            Rect rect = (Rect) transitionValues.values.get("draweeTransition:bounds");
            Rect rect2 = (Rect) transitionValues2.values.get("draweeTransition:bounds");
            if (!(rect == null || rect2 == null)) {
                if (this.mFromScale == this.mToScale && this.mFromFocusPoint == this.mToFocusPoint) {
                    return null;
                }
                final GenericDraweeView genericDraweeView = (GenericDraweeView) transitionValues.view;
                final ScalingUtils.InterpolatingScaleType interpolatingScaleType = new ScalingUtils.InterpolatingScaleType(this.mFromScale, this.mToScale, rect, rect2, this.mFromFocusPoint, this.mToFocusPoint);
                ((GenericDraweeHierarchy) genericDraweeView.getHierarchy()).setActualImageScaleType(interpolatingScaleType);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.facebook.drawee.view.DraweeTransition.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        interpolatingScaleType.setValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new AnimatorListenerAdapter() {
                    /* class com.facebook.drawee.view.DraweeTransition.AnonymousClass2 */

                    public void onAnimationEnd(Animator animator) {
                        ((GenericDraweeHierarchy) genericDraweeView.getHierarchy()).setActualImageScaleType(DraweeTransition.this.mToScale);
                        if (DraweeTransition.this.mToFocusPoint != null) {
                            ((GenericDraweeHierarchy) genericDraweeView.getHierarchy()).setActualImageFocusPoint(DraweeTransition.this.mToFocusPoint);
                        }
                    }
                });
                return ofFloat;
            }
        }
        return null;
    }

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof GenericDraweeView) {
            transitionValues.values.put("draweeTransition:bounds", new Rect(0, 0, transitionValues.view.getWidth(), transitionValues.view.getHeight()));
        }
    }
}
