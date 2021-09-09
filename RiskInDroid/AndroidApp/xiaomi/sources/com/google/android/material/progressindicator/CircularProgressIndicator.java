package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* renamed from: DEF_STYLE_RES */
    public static final int Widget_MaterialComponents_CircularProgressIndicator = 2132739127;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, Widget_MaterialComponents_CircularProgressIndicator);
        initializeDrawables();
    }

    /* access modifiers changed from: package-private */
    public final CircularProgressIndicatorSpec createSpec(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
    }

    public final void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
    }

    public final int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    public final void setIndicatorInset(int i) {
        if (((CircularProgressIndicatorSpec) this.spec).indicatorInset != i) {
            ((CircularProgressIndicatorSpec) this.spec).indicatorInset = i;
            invalidate();
        }
    }

    public final int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    public final void setIndicatorSize(int i) {
        if (((CircularProgressIndicatorSpec) this.spec).indicatorSize != i) {
            ((CircularProgressIndicatorSpec) this.spec).indicatorSize = i;
            ((CircularProgressIndicatorSpec) this.spec).validateSpec();
            invalidate();
        }
    }

    public final int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    public final void setIndicatorDirection(int i) {
        ((CircularProgressIndicatorSpec) this.spec).indicatorDirection = i;
        invalidate();
    }
}
