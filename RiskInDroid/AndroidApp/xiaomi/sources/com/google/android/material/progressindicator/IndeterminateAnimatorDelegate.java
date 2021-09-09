package com.google.android.material.progressindicator;

import _m_j.jp;
import android.animation.Animator;

abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    /* access modifiers changed from: package-private */
    public abstract void cancelAnimatorImmediately();

    /* access modifiers changed from: protected */
    public float getFractionInRange(int i, int i2, int i3) {
        return ((float) (i - i2)) / ((float) i3);
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(jp.O000000o o000000o);

    /* access modifiers changed from: package-private */
    public abstract void requestCancelAnimatorAfterCurrentCycle();

    /* access modifiers changed from: package-private */
    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();

    protected IndeterminateAnimatorDelegate(int i) {
        this.segmentPositions = new float[(i * 2)];
        this.segmentColors = new int[i];
    }

    /* access modifiers changed from: protected */
    public void registerDrawable(IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }
}
