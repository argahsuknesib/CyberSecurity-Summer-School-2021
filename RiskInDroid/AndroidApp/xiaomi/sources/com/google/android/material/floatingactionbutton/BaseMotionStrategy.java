package com.google.android.material.floatingactionbutton;

import _m_j.bf;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

abstract class BaseMotionStrategy implements MotionStrategy {
    private final Context context;
    private MotionSpec defaultMotionSpec;
    public final ExtendedFloatingActionButton fab;
    private final ArrayList<Animator.AnimatorListener> listeners = new ArrayList<>();
    private MotionSpec motionSpec;
    private final AnimatorTracker tracker;

    BaseMotionStrategy(ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.fab = extendedFloatingActionButton;
        this.context = extendedFloatingActionButton.getContext();
        this.tracker = animatorTracker;
    }

    public final void setMotionSpec(MotionSpec motionSpec2) {
        this.motionSpec = motionSpec2;
    }

    public final MotionSpec getCurrentMotionSpec() {
        MotionSpec motionSpec2 = this.motionSpec;
        if (motionSpec2 != null) {
            return motionSpec2;
        }
        if (this.defaultMotionSpec == null) {
            this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
        }
        return (MotionSpec) bf.O000000o(this.defaultMotionSpec);
    }

    public final void addAnimationListener(Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    public final void removeAnimationListener(Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    public final List<Animator.AnimatorListener> getListeners() {
        return this.listeners;
    }

    public MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    public void onAnimationStart(Animator animator) {
        this.tracker.onNextAnimationStart(animator);
    }

    public void onAnimationEnd() {
        this.tracker.clear();
    }

    public void onAnimationCancel() {
        this.tracker.clear();
    }

    public AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    /* access modifiers changed from: package-private */
    public AnimatorSet createAnimator(MotionSpec motionSpec2) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec2.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec2.getAnimator("opacity", this.fab, View.ALPHA));
        }
        if (motionSpec2.hasPropertyValues("scale")) {
            arrayList.add(motionSpec2.getAnimator("scale", this.fab, View.SCALE_Y));
            arrayList.add(motionSpec2.getAnimator("scale", this.fab, View.SCALE_X));
        }
        if (motionSpec2.hasPropertyValues("width")) {
            arrayList.add(motionSpec2.getAnimator("width", this.fab, ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec2.hasPropertyValues("height")) {
            arrayList.add(motionSpec2.getAnimator("height", this.fab, ExtendedFloatingActionButton.HEIGHT));
        }
        if (motionSpec2.hasPropertyValues("paddingStart")) {
            arrayList.add(motionSpec2.getAnimator("paddingStart", this.fab, ExtendedFloatingActionButton.PADDING_START));
        }
        if (motionSpec2.hasPropertyValues("paddingEnd")) {
            arrayList.add(motionSpec2.getAnimator("paddingEnd", this.fab, ExtendedFloatingActionButton.PADDING_END));
        }
        if (motionSpec2.hasPropertyValues("labelOpacity")) {
            arrayList.add(motionSpec2.getAnimator("labelOpacity", this.fab, new Property<ExtendedFloatingActionButton, Float>(Float.class, "LABEL_OPACITY_PROPERTY") {
                /* class com.google.android.material.floatingactionbutton.BaseMotionStrategy.AnonymousClass1 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.google.android.material.animation.AnimationUtils.lerp(float, float, float):float
                 arg types: [int, int, float]
                 candidates:
                  com.google.android.material.animation.AnimationUtils.lerp(int, int, float):int
                  com.google.android.material.animation.AnimationUtils.lerp(float, float, float):float */
                public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
                    return Float.valueOf(AnimationUtils.lerp(0.0f, 1.0f, (((float) Color.alpha(extendedFloatingActionButton.getCurrentTextColor())) / 255.0f) / ((float) Color.alpha(extendedFloatingActionButton.originalTextCsl.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.fab.originalTextCsl.getDefaultColor())))));
                }

                public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f) {
                    int colorForState = extendedFloatingActionButton.originalTextCsl.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.fab.originalTextCsl.getDefaultColor());
                    ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.lerp(0.0f, ((float) Color.alpha(colorForState)) / 255.0f, f.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                    if (f.floatValue() == 1.0f) {
                        extendedFloatingActionButton.silentlyUpdateTextColor(extendedFloatingActionButton.originalTextCsl);
                    } else {
                        extendedFloatingActionButton.silentlyUpdateTextColor(valueOf);
                    }
                }
            }));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }
}
