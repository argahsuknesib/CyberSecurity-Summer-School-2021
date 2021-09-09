package com.google.android.material.shadow;

import _m_j.OO000o;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;

@Deprecated
public class ShadowDrawableWrapper extends OO000o {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private boolean addPaddingForCorners = true;
    final RectF contentBounds;
    float cornerRadius;
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty = true;
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning = false;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    public int getOpacity() {
        return -3;
    }

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.shadowStartColor = ContextCompat.O00000o0(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.O00000o0(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.O00000o0(context, R.color.design_fab_shadow_end_color);
        this.cornerShadowPaint = new Paint(5);
        this.cornerShadowPaint.setStyle(Paint.Style.FILL);
        this.cornerRadius = (float) Math.round(f);
        this.contentBounds = new RectF();
        this.edgeShadowPaint = new Paint(this.cornerShadowPaint);
        this.edgeShadowPaint.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private static int toEven(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.addPaddingForCorners = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.cornerShadowPaint.setAlpha(i);
        this.edgeShadowPaint.setAlpha(i);
    }

    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setShadowSize(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = (float) toEven(f);
        float even2 = (float) toEven(f2);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize != even || this.rawMaxShadowSize != even2) {
            this.rawShadowSize = even;
            this.rawMaxShadowSize = even2;
            this.shadowSize = (float) Math.round(even * 1.5f);
            this.maxShadowSize = even2;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f) {
        setShadowSize(f, this.rawMaxShadowSize);
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        double d = (double) (f * 1.5f);
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (d + ((1.0d - COS_45) * d2));
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = (double) f;
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (d + ((1.0d - COS_45) * d2));
    }

    public void setCornerRadius(float f) {
        float round = (float) Math.round(f);
        if (this.cornerRadius != round) {
            this.cornerRadius = round;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public final void setRotation(float f) {
        if (this.rotation != f) {
            this.rotation = f;
            invalidateSelf();
        }
    }

    private void drawShadow(Canvas canvas) {
        float f;
        int i;
        int i2;
        float f2;
        float f3;
        float f4;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f5 = this.cornerRadius;
        float f6 = (-f5) - this.shadowSize;
        float f7 = f5 * 2.0f;
        boolean z = this.contentBounds.width() - f7 > 0.0f;
        boolean z2 = this.contentBounds.height() - f7 > 0.0f;
        float f8 = this.rawShadowSize;
        float f9 = f5 / ((f8 - (0.5f * f8)) + f5);
        float f10 = f5 / ((f8 - (0.25f * f8)) + f5);
        float f11 = f5 / ((f8 - (f8 * 1.0f)) + f5);
        int save2 = canvas.save();
        canvas2.translate(this.contentBounds.left + f5, this.contentBounds.top + f5);
        canvas2.scale(f9, f10);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z) {
            canvas2.scale(1.0f / f9, 1.0f);
            i2 = save2;
            f = f11;
            i = save;
            f2 = f10;
            canvas.drawRect(0.0f, f6, this.contentBounds.width() - f7, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            i2 = save2;
            f = f11;
            i = save;
            f2 = f10;
        }
        canvas2.restoreToCount(i2);
        int save3 = canvas.save();
        canvas2.translate(this.contentBounds.right - f5, this.contentBounds.bottom - f5);
        float f12 = f;
        canvas2.scale(f9, f12);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z) {
            canvas2.scale(1.0f / f9, 1.0f);
            f3 = f2;
            f4 = f12;
            canvas.drawRect(0.0f, f6, this.contentBounds.width() - f7, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
        } else {
            f3 = f2;
            f4 = f12;
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        canvas2.translate(this.contentBounds.left + f5, this.contentBounds.bottom - f5);
        canvas2.scale(f9, f4);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas2.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas.save();
        canvas2.translate(this.contentBounds.right - f5, this.contentBounds.top + f5);
        float f13 = f3;
        canvas2.scale(f9, f13);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z2) {
            canvas2.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, int, float, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.RadialGradient.<init>(float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void}
     arg types: [int, float, int, float, int[], float[], android.graphics.Shader$TileMode]
     candidates:
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long, long, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, long[], float[], android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int, int, android.graphics.Shader$TileMode):void}
      ClspMth{android.graphics.LinearGradient.<init>(float, float, float, float, int[], float[], android.graphics.Shader$TileMode):void} */
    private void buildShadowCorners() {
        float f = this.cornerRadius;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.shadowSize;
        rectF2.inset(-f2, -f2);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f3 = -rectF2.top;
        if (f3 > 0.0f) {
            float f4 = this.cornerRadius / f3;
            Paint paint = this.cornerShadowPaint;
            RadialGradient radialGradient = r8;
            RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f4, ((1.0f - f4) / 2.0f) + f4, 1.0f}, Shader.TileMode.CLAMP);
            paint.setShader(radialGradient);
        }
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    private void buildComponents(Rect rect) {
        float f = this.rawMaxShadowSize * 1.5f;
        this.contentBounds.set(((float) rect.left) + this.rawMaxShadowSize, ((float) rect.top) + f, ((float) rect.right) - this.rawMaxShadowSize, ((float) rect.bottom) - f);
        getWrappedDrawable().setBounds((int) this.contentBounds.left, (int) this.contentBounds.top, (int) this.contentBounds.right, (int) this.contentBounds.bottom);
        buildShadowCorners();
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void setMaxShadowSize(float f) {
        setShadowSize(this.rawShadowSize, f);
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinWidth() {
        float f = this.rawMaxShadowSize;
        return (Math.max(f, this.cornerRadius + (f / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    public float getMinHeight() {
        float f = this.rawMaxShadowSize;
        return (Math.max(f, this.cornerRadius + ((f * 1.5f) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 1.5f * 2.0f);
    }
}
