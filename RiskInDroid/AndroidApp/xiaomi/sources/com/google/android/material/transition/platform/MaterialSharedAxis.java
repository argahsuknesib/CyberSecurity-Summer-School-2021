package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {
    private final int axis;
    private final boolean forward;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public final /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    public final /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public final /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    public final /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public final /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    public final /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    public final /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    public final /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }

    public MaterialSharedAxis(int i, boolean z) {
        super(createPrimaryAnimatorProvider(i, z), createSecondaryAnimatorProvider());
        this.axis = i;
        this.forward = z;
    }

    public final int getAxis() {
        return this.axis;
    }

    public final boolean isForward() {
        return this.forward;
    }

    private static VisibilityAnimatorProvider createPrimaryAnimatorProvider(int i, boolean z) {
        if (i == 0) {
            return new SlideDistanceProvider(z ? 8388613 : 8388611);
        } else if (i == 1) {
            return new SlideDistanceProvider(z ? 80 : 48);
        } else if (i == 2) {
            return new ScaleProvider(z);
        } else {
            throw new IllegalArgumentException("Invalid axis: ".concat(String.valueOf(i)));
        }
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }
}
