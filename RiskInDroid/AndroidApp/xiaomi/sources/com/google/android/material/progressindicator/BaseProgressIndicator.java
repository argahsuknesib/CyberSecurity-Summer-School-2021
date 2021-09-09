package com.google.android.material.progressindicator;

import _m_j.cb;
import _m_j.jp;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    static final int DEF_STYLE_RES = 2132739168;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final Runnable delayedHide = new Runnable() {
        /* class com.google.android.material.progressindicator.BaseProgressIndicator.AnonymousClass2 */

        public void run() {
            BaseProgressIndicator.this.internalHide();
            BaseProgressIndicator.this.lastShowStartTime = -1;
        }
    };
    private final Runnable delayedShow = new Runnable() {
        /* class com.google.android.material.progressindicator.BaseProgressIndicator.AnonymousClass1 */

        public void run() {
            BaseProgressIndicator.this.internalShow();
        }
    };
    private final jp.O000000o hideAnimationCallback = new jp.O000000o() {
        /* class com.google.android.material.progressindicator.BaseProgressIndicator.AnonymousClass4 */

        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (!BaseProgressIndicator.this.isIndeterminateModeChangeRequested) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.visibilityAfterHide);
            }
        }
    };
    public boolean isIndeterminateModeChangeRequested = false;
    private boolean isParentDoneInitializing;
    public long lastShowStartTime = -1;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    public int storedProgress;
    public boolean storedProgressAnimated;
    private final jp.O000000o switchIndeterminateModeCallback = new jp.O000000o() {
        /* class com.google.android.material.progressindicator.BaseProgressIndicator.AnonymousClass3 */

        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.setProgressCompat(0, false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.storedProgress, BaseProgressIndicator.this.storedProgressAnimated);
        }
    };
    public int visibilityAfterHide = 4;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowAnimationBehavior {
    }

    /* access modifiers changed from: package-private */
    public abstract S createSpec(Context context, AttributeSet attributeSet);

    protected BaseProgressIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Context context2 = getContext();
        this.spec = createSpec(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, new int[]{16843065, R.attr.hideAnimationBehavior, R.attr.indicatorColor, R.attr.minHideDelay, R.attr.showAnimationBehavior, R.attr.showDelay, R.attr.trackColor, R.attr.trackCornerRadius, R.attr.trackThickness}, i, i2, new int[0]);
        this.showDelay = obtainStyledAttributes.getInt(5, -1);
        this.minHideDelay = Math.min(obtainStyledAttributes.getInt(3, -1), 1000);
        obtainStyledAttributes.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    private void registerAnimationCallbacks() {
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().getAnimatorDelegate().registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
    }

    private void unregisterAnimationCallbacks() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
            getIndeterminateDrawable().getAnimatorDelegate().unregisterAnimatorsCompleteCallback();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        }
    }

    public void show() {
        if (this.showDelay > 0) {
            removeCallbacks(this.delayedShow);
            postDelayed(this.delayedShow, (long) this.showDelay);
            return;
        }
        this.delayedShow.run();
    }

    public void internalShow() {
        if (this.minHideDelay > 0) {
            this.lastShowStartTime = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    public void hide() {
        if (getVisibility() != 0) {
            removeCallbacks(this.delayedShow);
            return;
        }
        removeCallbacks(this.delayedHide);
        long uptimeMillis = SystemClock.uptimeMillis() - this.lastShowStartTime;
        if (uptimeMillis >= ((long) this.minHideDelay)) {
            this.delayedHide.run();
        } else {
            postDelayed(this.delayedHide, ((long) this.minHideDelay) - uptimeMillis);
        }
    }

    public void internalHide() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible()) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        applyNewVisibility(i == 0);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        applyNewVisibility(false);
    }

    /* access modifiers changed from: protected */
    public void applyNewVisibility(boolean z) {
        if (this.isParentDoneInitializing) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, z);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerAnimationCallbacks();
        if (visibleToUser()) {
            internalShow();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        DrawingDelegate currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate != null) {
            int preferredWidth = currentDrawingDelegate.getPreferredWidth();
            int preferredHeight = currentDrawingDelegate.getPreferredHeight();
            if (preferredWidth < 0) {
                i3 = getMeasuredWidth();
            } else {
                i3 = preferredWidth + getPaddingLeft() + getPaddingRight();
            }
            if (preferredHeight < 0) {
                i4 = getMeasuredHeight();
            } else {
                i4 = preferredHeight + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(i3, i4);
        }
    }

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().getDrawingDelegate();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().getDrawingDelegate();
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof DeterminateDrawable) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.hideNow();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevelByFraction(((float) getProgress()) / ((float) getMax()));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof IndeterminateDrawable) {
            ((DrawableWithAnimatedVisibilityChange) drawable).hideNow();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }

    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    /* access modifiers changed from: package-private */
    public boolean visibleToUser() {
        return cb.O000OO0o(this) && getWindowVisibility() == 0 && isEffectivelyVisible();
    }

    /* access modifiers changed from: package-private */
    public boolean isEffectivelyVisible() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() == 0) {
                    return true;
                }
                return false;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    private boolean isNoLongerNeedToBeVisible() {
        if (getProgressDrawable() == null || !getProgressDrawable().isVisible()) {
            return getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible();
        }
        return false;
    }

    public synchronized void setIndeterminate(boolean z) {
        if (z != isIndeterminate()) {
            if (visibleToUser()) {
                if (z) {
                    throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
                }
            }
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange != null) {
                drawableWithAnimatedVisibilityChange.hideNow();
            }
            super.setIndeterminate(z);
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange2 != null) {
                drawableWithAnimatedVisibilityChange2.setVisible(visibleToUser(), false, false);
            }
            this.isIndeterminateModeChangeRequested = false;
        }
    }

    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    public void setTrackThickness(int i) {
        if (this.spec.trackThickness != i) {
            this.spec.trackThickness = i;
            requestLayout();
        }
    }

    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), (int) R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.spec.indicatorColors = iArr;
            getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
            invalidate();
        }
    }

    public int getTrackColor() {
        return this.spec.trackColor;
    }

    public void setTrackColor(int i) {
        if (this.spec.trackColor != i) {
            this.spec.trackColor = i;
            invalidate();
        }
    }

    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    public void setTrackCornerRadius(int i) {
        if (this.spec.trackCornerRadius != i) {
            S s = this.spec;
            s.trackCornerRadius = Math.min(i, s.trackThickness / 2);
        }
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    public void setShowAnimationBehavior(int i) {
        this.spec.showAnimationBehavior = i;
        invalidate();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    public void setHideAnimationBehavior(int i) {
        this.spec.hideAnimationBehavior = i;
        invalidate();
    }

    public synchronized void setProgress(int i) {
        if (!isIndeterminate()) {
            setProgressCompat(i, false);
        }
    }

    public void setProgressCompat(int i, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (getProgressDrawable() != null && !z) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.storedProgress = i;
            this.storedProgressAnimated = z;
            this.isIndeterminateModeChangeRequested = true;
            if (!getIndeterminateDrawable().isVisible() || this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) {
                this.switchIndeterminateModeCallback.onAnimationEnd(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().getAnimatorDelegate().requestCancelAnimatorAfterCurrentCycle();
            }
        }
    }

    public void setVisibilityAfterHide(int i) {
        if (i == 0 || i == 4 || i == 8) {
            this.visibilityAfterHide = i;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void setAnimatorDurationScaleProvider(AnimatorDurationScaleProvider animatorDurationScaleProvider2) {
        this.animatorDurationScaleProvider = animatorDurationScaleProvider2;
        if (getProgressDrawable() != null) {
            getProgressDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider2;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider2;
        }
    }
}
