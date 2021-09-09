package com.google.android.material.progressindicator;

import _m_j.cb;
import android.content.Context;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {

    /* renamed from: DEF_STYLE_RES */
    public static final int Widget_MaterialComponents_LinearProgressIndicator = 2132739139;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, Widget_MaterialComponents_LinearProgressIndicator);
        initializeDrawables();
    }

    /* access modifiers changed from: package-private */
    public final LinearProgressIndicatorSpec createSpec(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.spec;
        boolean z2 = true;
        if (!(((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 1 || ((cb.O0000Oo0(this) == 1 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) || (cb.O0000Oo0(this) == 0 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 3)))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z2;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        DeterminateDrawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
    }

    public final void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    public final void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }

    public final int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public final void setIndeterminateAnimationType(int i) {
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType != i) {
            if (!visibleToUser() || !isIndeterminate()) {
                ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType = i;
                ((LinearProgressIndicatorSpec) this.spec).validateSpec();
                if (i == 0) {
                    getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.spec));
                } else {
                    getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.spec));
                }
                invalidate();
                return;
            }
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
    }

    public final int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    public final void setIndicatorDirection(int i) {
        ((LinearProgressIndicatorSpec) this.spec).indicatorDirection = i;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.spec;
        boolean z = true;
        if (!(i == 1 || ((cb.O0000Oo0(this) == 1 && ((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) || (cb.O0000Oo0(this) == 0 && i == 3)))) {
            z = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z;
        invalidate();
    }

    public final void setProgressCompat(int i, boolean z) {
        if (this.spec == null || ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType != 0 || !isIndeterminate()) {
            super.setProgressCompat(i, z);
        }
    }
}
