package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset = 0.0f;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        setCradleVerticalOffset(f3);
    }

    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        float f4 = f;
        ShapePath shapePath2 = shapePath;
        float f5 = this.fabDiameter;
        if (f5 == 0.0f) {
            shapePath2.lineTo(f4, 0.0f);
            return;
        }
        float f6 = ((this.fabMargin * 2.0f) + f5) / 2.0f;
        float f7 = f3 * this.roundedCornerRadius;
        float f8 = f2 + this.horizontalOffset;
        float f9 = (this.cradleVerticalOffset * f3) + ((1.0f - f3) * f6);
        if (f9 / f6 >= 1.0f) {
            shapePath2.lineTo(f4, 0.0f);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float sqrt = (float) Math.sqrt((double) ((f10 * f10) - (f11 * f11)));
        float f12 = f8 - sqrt;
        float f13 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f11)));
        float f14 = 90.0f - degrees;
        shapePath2.lineTo(f12, 0.0f);
        float f15 = f7 * 2.0f;
        float f16 = degrees;
        shapePath.addArc(f12 - f7, 0.0f, f12 + f7, f15, 270.0f, degrees);
        shapePath.addArc(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        shapePath.addArc(f13 - f7, 0.0f, f13 + f7, f15, 270.0f - f16, f16);
        shapePath2.lineTo(f4, 0.0f);
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    /* access modifiers changed from: package-private */
    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* access modifiers changed from: package-private */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    /* access modifiers changed from: package-private */
    public void setCradleVerticalOffset(float f) {
        if (f >= 0.0f) {
            this.cradleVerticalOffset = f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    /* access modifiers changed from: package-private */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* access modifiers changed from: package-private */
    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    /* access modifiers changed from: package-private */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    /* access modifiers changed from: package-private */
    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }
}
