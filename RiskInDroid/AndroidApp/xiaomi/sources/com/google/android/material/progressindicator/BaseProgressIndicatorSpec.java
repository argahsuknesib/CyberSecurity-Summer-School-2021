package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.xiaomi.smarthome.R;

public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;
    public int[] indicatorColors = new int[0];
    public int showAnimationBehavior;
    public int trackColor;
    public int trackCornerRadius;
    public int trackThickness;

    /* access modifiers changed from: package-private */
    public abstract void validateSpec();

    protected BaseProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, new int[]{16843065, R.attr.hideAnimationBehavior, R.attr.indicatorColor, R.attr.minHideDelay, R.attr.showAnimationBehavior, R.attr.showDelay, R.attr.trackColor, R.attr.trackCornerRadius, R.attr.trackThickness}, i, i2, new int[0]);
        this.trackThickness = MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, 8, dimensionPixelSize);
        this.trackCornerRadius = Math.min(MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, 7, 0), this.trackThickness / 2);
        this.showAnimationBehavior = obtainStyledAttributes.getInt(4, 0);
        this.hideAnimationBehavior = obtainStyledAttributes.getInt(1, 0);
        loadIndicatorColors(context, obtainStyledAttributes);
        loadTrackColor(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void loadIndicatorColors(Context context, TypedArray typedArray) {
        if (!typedArray.hasValue(2)) {
            this.indicatorColors = new int[]{MaterialColors.getColor(context, (int) R.attr.colorPrimary, -1)};
        } else if (typedArray.peekValue(2).type != 1) {
            this.indicatorColors = new int[]{typedArray.getColor(2, -1)};
        } else {
            this.indicatorColors = context.getResources().getIntArray(typedArray.getResourceId(2, -1));
            if (this.indicatorColors.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    private void loadTrackColor(Context context, TypedArray typedArray) {
        if (typedArray.hasValue(6)) {
            this.trackColor = typedArray.getColor(6, -1);
            return;
        }
        this.trackColor = this.indicatorColors[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
        float f = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.trackColor = MaterialColors.compositeARGBWithAlpha(this.trackColor, (int) (f * 255.0f));
    }

    public boolean isShowAnimationEnabled() {
        return this.showAnimationBehavior != 0;
    }

    public boolean isHideAnimationEnabled() {
        return this.hideAnimationBehavior != 0;
    }
}
