package com.google.android.material.shadow;

import _m_j.q;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

public class ShadowRenderer {
    private static final int[] cornerColors = new int[4];
    private static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};
    private static final int[] edgeColors = new int[3];
    private static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    private final Paint cornerShadowPaint;
    private final Paint edgeShadowPaint;
    private final Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;
    private final Paint shadowPaint;
    private int shadowStartColor;
    private Paint transparentPaint;

    public ShadowRenderer() {
        this(-16777216);
    }

    public ShadowRenderer(int i) {
        this.scratch = new Path();
        this.transparentPaint = new Paint();
        this.shadowPaint = new Paint();
        setShadowColor(i);
        this.transparentPaint.setColor(0);
        this.cornerShadowPaint = new Paint(4);
        this.cornerShadowPaint.setStyle(Paint.Style.FILL);
        this.edgeShadowPaint = new Paint(this.cornerShadowPaint);
    }

    public void setShadowColor(int i) {
        this.shadowStartColor = q.O00000Oo(i, 68);
        this.shadowMiddleColor = q.O00000Oo(i, 20);
        this.shadowEndColor = q.O00000Oo(i, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }

    public void drawEdgeShadow(Canvas canvas, Matrix matrix, RectF rectF, int i) {
        rectF.bottom += (float) i;
        rectF.offset(0.0f, (float) (-i));
        int[] iArr = edgeColors;
        iArr[0] = this.shadowEndColor;
        iArr[1] = this.shadowMiddleColor;
        iArr[2] = this.shadowStartColor;
        this.edgeShadowPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, edgeColors, edgePositions, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.edgeShadowPaint);
        canvas.restore();
    }

    public void drawCornerShadow(Canvas canvas, Matrix matrix, RectF rectF, int i, float f, float f2) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        int i2 = i;
        float f3 = f2;
        boolean z = f3 < 0.0f;
        Path path = this.scratch;
        if (z) {
            int[] iArr = cornerColors;
            iArr[0] = 0;
            iArr[1] = this.shadowEndColor;
            iArr[2] = this.shadowMiddleColor;
            iArr[3] = this.shadowStartColor;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF2, f, f3);
            path.close();
            float f4 = (float) (-i2);
            rectF2.inset(f4, f4);
            int[] iArr2 = cornerColors;
            iArr2[0] = 0;
            iArr2[1] = this.shadowStartColor;
            iArr2[2] = this.shadowMiddleColor;
            iArr2[3] = this.shadowEndColor;
        }
        float width = rectF.width() / 2.0f;
        if (width > 0.0f) {
            float f5 = 1.0f - (((float) i2) / width);
            float[] fArr = cornerPositions;
            fArr[1] = f5;
            fArr[2] = ((1.0f - f5) / 2.0f) + f5;
            this.cornerShadowPaint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, cornerColors, cornerPositions, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            if (!z) {
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawPath(path, this.transparentPaint);
            }
            canvas.drawArc(rectF, f, f2, true, this.cornerShadowPaint);
            canvas.restore();
        }
    }

    public Paint getShadowPaint() {
        return this.shadowPaint;
    }
}
