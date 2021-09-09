package com.google.android.material.progressindicator;

import _m_j.jp;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements jp {
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> GROW_FRACTION = new Property<DrawableWithAnimatedVisibilityChange, Float>(Float.class, "growFraction") {
        /* class com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.AnonymousClass3 */

        public final Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.getGrowFraction());
        }

        public final void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f) {
            drawableWithAnimatedVisibilityChange.setGrowFraction(f.floatValue());
        }
    };
    private List<jp.O000000o> animationCallbacks;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    final BaseProgressIndicatorSpec baseSpec;
    final Context context;
    private float growFraction;
    private ValueAnimator hideAnimator;
    private boolean ignoreCallbacks;
    private jp.O000000o internalAnimationCallback;
    private float mockGrowFraction;
    private boolean mockHideAnimationRunning;
    private boolean mockShowAnimationRunning;
    final Paint paint = new Paint();
    private ValueAnimator showAnimator;
    private int totalAlpha;

    public int getOpacity() {
        return -3;
    }

    DrawableWithAnimatedVisibilityChange(Context context2, BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.context = context2;
        this.baseSpec = baseProgressIndicatorSpec;
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        setAlpha(255);
    }

    private void maybeInitializeAnimators() {
        if (this.showAnimator == null) {
            this.showAnimator = ObjectAnimator.ofFloat(this, GROW_FRACTION, 0.0f, 1.0f);
            this.showAnimator.setDuration(500L);
            this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            setShowAnimator(this.showAnimator);
        }
        if (this.hideAnimator == null) {
            this.hideAnimator = ObjectAnimator.ofFloat(this, GROW_FRACTION, 1.0f, 0.0f);
            this.hideAnimator.setDuration(500L);
            this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            setHideAnimator(this.hideAnimator);
        }
    }

    public void registerAnimationCallback(jp.O000000o o000000o) {
        if (this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }
        if (!this.animationCallbacks.contains(o000000o)) {
            this.animationCallbacks.add(o000000o);
        }
    }

    public boolean unregisterAnimationCallback(jp.O000000o o000000o) {
        List<jp.O000000o> list = this.animationCallbacks;
        if (list == null || !list.contains(o000000o)) {
            return false;
        }
        this.animationCallbacks.remove(o000000o);
        if (!this.animationCallbacks.isEmpty()) {
            return true;
        }
        this.animationCallbacks = null;
        return true;
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    /* access modifiers changed from: package-private */
    public void setInternalAnimationCallback(jp.O000000o o000000o) {
        this.internalAnimationCallback = o000000o;
    }

    public void dispatchAnimationStart() {
        jp.O000000o o000000o = this.internalAnimationCallback;
        if (o000000o != null) {
            o000000o.onAnimationStart(this);
        }
        List<jp.O000000o> list = this.animationCallbacks;
        if (list != null && !this.ignoreCallbacks) {
            for (jp.O000000o onAnimationStart : list) {
                onAnimationStart.onAnimationStart(this);
            }
        }
    }

    public void dispatchAnimationEnd() {
        jp.O000000o o000000o = this.internalAnimationCallback;
        if (o000000o != null) {
            o000000o.onAnimationEnd(this);
        }
        List<jp.O000000o> list = this.animationCallbacks;
        if (list != null && !this.ignoreCallbacks) {
            for (jp.O000000o onAnimationEnd : list) {
                onAnimationEnd.onAnimationEnd(this);
            }
        }
    }

    public void start() {
        setVisibleInternal(true, true, false);
    }

    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean isRunning() {
        return isShowing() || isHiding();
    }

    public boolean isShowing() {
        ValueAnimator valueAnimator = this.showAnimator;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.mockShowAnimationRunning;
    }

    public boolean isHiding() {
        ValueAnimator valueAnimator = this.hideAnimator;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.mockHideAnimationRunning;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return setVisible(z, z2, true);
    }

    public boolean setVisible(boolean z, boolean z2, boolean z3) {
        return setVisibleInternal(z, z2, z3 && this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver()) > 0.0f);
    }

    /* access modifiers changed from: package-private */
    public boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        maybeInitializeAnimators();
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator = z ? this.showAnimator : this.hideAnimator;
        if (!z3) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                endAnimatorWithoutCallbacks(valueAnimator);
            }
            return super.setVisible(z, false);
        } else if (z3 && valueAnimator.isRunning()) {
            return false;
        } else {
            boolean z4 = !z || super.setVisible(z, false);
            if (!(z ? this.baseSpec.isShowAnimationEnabled() : this.baseSpec.isHideAnimationEnabled())) {
                endAnimatorWithoutCallbacks(valueAnimator);
                return z4;
            }
            if (z2 || Build.VERSION.SDK_INT < 19 || !valueAnimator.isPaused()) {
                valueAnimator.start();
            } else {
                valueAnimator.resume();
            }
            return z4;
        }
    }

    private void endAnimatorWithoutCallbacks(ValueAnimator... valueAnimatorArr) {
        boolean z = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        for (ValueAnimator end : valueAnimatorArr) {
            end.end();
        }
        this.ignoreCallbacks = z;
    }

    public void setAlpha(int i) {
        this.totalAlpha = i;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.totalAlpha;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    private void setShowAnimator(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.showAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.showAnimator = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                /* class com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.AnonymousClass1 */

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    DrawableWithAnimatedVisibilityChange.this.dispatchAnimationStart();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    /* access modifiers changed from: package-private */
    public ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    private void setHideAnimator(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.hideAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.hideAnimator = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                /* class com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.AnonymousClass2 */

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                    DrawableWithAnimatedVisibilityChange.this.dispatchAnimationEnd();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    /* access modifiers changed from: package-private */
    public float getGrowFraction() {
        if (!this.baseSpec.isShowAnimationEnabled() && !this.baseSpec.isHideAnimationEnabled()) {
            return 1.0f;
        }
        if (this.mockHideAnimationRunning || this.mockShowAnimationRunning) {
            return this.mockGrowFraction;
        }
        return this.growFraction;
    }

    /* access modifiers changed from: package-private */
    public void setGrowFraction(float f) {
        if (this.growFraction != f) {
            this.growFraction = f;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void setMockShowAnimationRunning(boolean z, float f) {
        this.mockShowAnimationRunning = z;
        this.mockGrowFraction = f;
    }

    /* access modifiers changed from: package-private */
    public void setMockHideAnimationRunning(boolean z, float f) {
        this.mockHideAnimationRunning = z;
        this.mockGrowFraction = f;
    }
}
