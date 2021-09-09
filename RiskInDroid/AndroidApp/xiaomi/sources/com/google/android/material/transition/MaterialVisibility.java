package com.google.android.material.transition;

import _m_j.is;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.List;

abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final List<VisibilityAnimatorProvider> additionalAnimatorProviders = new ArrayList();
    private final P primaryAnimatorProvider;
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    protected MaterialVisibility(P p, VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.additionalAnimatorProviders.add(visibilityAnimatorProvider);
    }

    public boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.additionalAnimatorProviders.remove(visibilityAnimatorProvider);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.material.transition.MaterialVisibility.createAnimator(android.view.ViewGroup, android.view.View, boolean):android.animation.Animator
     arg types: [android.view.ViewGroup, android.view.View, int]
     candidates:
      androidx.transition.Visibility.createAnimator(android.view.ViewGroup, _m_j.is, _m_j.is):android.animation.Animator
      androidx.transition.Transition.createAnimator(android.view.ViewGroup, _m_j.is, _m_j.is):android.animation.Animator
      com.google.android.material.transition.MaterialVisibility.createAnimator(android.view.ViewGroup, android.view.View, boolean):android.animation.Animator */
    public Animator onAppear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        return createAnimator(viewGroup, view, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.material.transition.MaterialVisibility.createAnimator(android.view.ViewGroup, android.view.View, boolean):android.animation.Animator
     arg types: [android.view.ViewGroup, android.view.View, int]
     candidates:
      androidx.transition.Visibility.createAnimator(android.view.ViewGroup, _m_j.is, _m_j.is):android.animation.Animator
      androidx.transition.Transition.createAnimator(android.view.ViewGroup, _m_j.is, _m_j.is):android.animation.Animator
      com.google.android.material.transition.MaterialVisibility.createAnimator(android.view.ViewGroup, android.view.View, boolean):android.animation.Animator */
    public Animator onDisappear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        return createAnimator(viewGroup, view, false);
    }

    private Animator createAnimator(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        addAnimatorIfNeeded(arrayList, this.primaryAnimatorProvider, viewGroup, view, z);
        addAnimatorIfNeeded(arrayList, this.secondaryAnimatorProvider, viewGroup, view, z);
        for (VisibilityAnimatorProvider addAnimatorIfNeeded : this.additionalAnimatorProviders) {
            addAnimatorIfNeeded(arrayList, addAnimatorIfNeeded, viewGroup, view, z);
        }
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private static void addAnimatorIfNeeded(List<Animator> list, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z) {
        Animator animator;
        if (visibilityAnimatorProvider != null) {
            if (z) {
                animator = visibilityAnimatorProvider.createAppear(viewGroup, view);
            } else {
                animator = visibilityAnimatorProvider.createDisappear(viewGroup, view);
            }
            if (animator != null) {
                list.add(animator);
            }
        }
    }
}
