package com.google.android.material.transition;

import _m_j.is;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Visibility;

public final class Hold extends Visibility {
    public final Animator onAppear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        return ValueAnimator.ofFloat(0.0f);
    }

    public final Animator onDisappear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        return ValueAnimator.ofFloat(0.0f);
    }
}
