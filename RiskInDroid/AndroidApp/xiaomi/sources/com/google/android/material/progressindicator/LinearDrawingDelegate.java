package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float trackLength = 300.0f;

    public final int getPreferredWidth() {
        return -1;
    }

    public LinearDrawingDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    public final int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void adjustCanvas(Canvas canvas, float f) {
        Rect clipBounds = canvas.getClipBounds();
        this.trackLength = (float) clipBounds.width();
        float f2 = (float) ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate(((float) clipBounds.width()) / 2.0f, (((float) clipBounds.height()) / 2.0f) + Math.max(0.0f, ((float) (clipBounds.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.drawable.isShowing() && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.drawable.isShowing() || this.drawable.isHiding()) {
            canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness) * (f - 1.0f)) / 2.0f);
        }
        float f3 = this.trackLength;
        canvas.clipRect((-f3) / 2.0f, (-f2) / 2.0f, f3 / 2.0f, f2 / 2.0f);
        this.displayedTrackThickness = ((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness) * f;
        this.displayedCornerRadius = ((float) ((LinearProgressIndicatorSpec) this.spec).trackCornerRadius) * f;
    }

    public final void fillIndicator(Canvas canvas, Paint paint, float f, float f2, int i) {
        if (f != f2) {
            float f3 = this.trackLength;
            float f4 = this.displayedCornerRadius;
            float f5 = ((-f3) / 2.0f) + f4 + ((f3 - (f4 * 2.0f)) * f);
            float f6 = ((-f3) / 2.0f) + f4 + ((f3 - (f4 * 2.0f)) * f2);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(i);
            float f7 = this.displayedTrackThickness;
            canvas.drawRect(f5, (-f7) / 2.0f, f6, f7 / 2.0f, paint);
            float f8 = this.displayedCornerRadius;
            RectF rectF = new RectF(-f8, -f8, f8, f8);
            Canvas canvas2 = canvas;
            Paint paint2 = paint;
            float f9 = f5;
            RectF rectF2 = rectF;
            drawRoundedEnd(canvas2, paint2, this.displayedTrackThickness, this.displayedCornerRadius, f9, true, rectF2);
            drawRoundedEnd(canvas2, paint2, this.displayedTrackThickness, this.displayedCornerRadius, f6, false, rectF2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void fillTrack(Canvas canvas, Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        float f = ((-this.trackLength) / 2.0f) + this.displayedCornerRadius;
        float f2 = -f;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        float f3 = this.displayedTrackThickness;
        canvas.drawRect(f, (-f3) / 2.0f, f2, f3 / 2.0f, paint);
        float f4 = this.displayedCornerRadius;
        RectF rectF = new RectF(-f4, -f4, f4, f4);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f, true, rectF);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f2, false, rectF);
    }

    private static void drawRoundedEnd(Canvas canvas, Paint paint, float f, float f2, float f3, boolean z, RectF rectF) {
        float f4 = f;
        float f5 = f2;
        canvas.save();
        canvas.translate(f3, 0.0f);
        if (!z) {
            canvas.rotate(180.0f);
        }
        float f6 = ((-f4) / 2.0f) + f5;
        float f7 = (f4 / 2.0f) - f5;
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        canvas2.drawRect(-f5, f6, 0.0f, f7, paint2);
        canvas.save();
        canvas.translate(0.0f, f6);
        RectF rectF2 = rectF;
        canvas2.drawArc(rectF2, 180.0f, 90.0f, true, paint2);
        canvas.restore();
        canvas.translate(0.0f, f7);
        canvas2.drawArc(rectF2, 180.0f, -90.0f, true, paint2);
        canvas.restore();
    }
}
