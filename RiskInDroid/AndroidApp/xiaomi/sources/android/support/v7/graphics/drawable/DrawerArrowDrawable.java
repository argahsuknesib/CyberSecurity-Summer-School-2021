package android.support.v7.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
    private static final float ARROW_HEAD_ANGLE = ((float) Math.toRadians(45.0d));
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection = 2;
    private float mMaxCutForBarSize;
    private final Paint mPaint = new Paint();
    private final Path mPath = new Path();
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror = false;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    private static float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public int getOpacity() {
        return -3;
    }

    public DrawerArrowDrawable(Context context) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.MITER);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.arrowHeadLength, R.attr.arrowShaftLength, R.attr.barLength, R.attr.color, R.attr.drawableSize, R.attr.gapBetweenBars, R.attr.spinBars, R.attr.thickness}, R.attr.drawerArrowStyle, 2132738277);
        setColor(obtainStyledAttributes.getColor(3, 0));
        setBarThickness(obtainStyledAttributes.getDimension(7, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(6, true));
        setGapSize((float) Math.round(obtainStyledAttributes.getDimension(5, 0.0f)));
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.mBarLength = (float) Math.round(obtainStyledAttributes.getDimension(2, 0.0f));
        this.mArrowHeadLength = (float) Math.round(obtainStyledAttributes.getDimension(0, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void setArrowHeadLength(float f) {
        if (this.mArrowHeadLength != f) {
            this.mArrowHeadLength = f;
            invalidateSelf();
        }
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public void setArrowShaftLength(float f) {
        if (this.mArrowShaftLength != f) {
            this.mArrowShaftLength = f;
            invalidateSelf();
        }
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public void setBarLength(float f) {
        if (this.mBarLength != f) {
            this.mBarLength = f;
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i) {
        if (i != this.mPaint.getColor()) {
            this.mPaint.setColor(i);
            invalidateSelf();
        }
    }

    @ColorInt
    public int getColor() {
        return this.mPaint.getColor();
    }

    public void setBarThickness(float f) {
        if (this.mPaint.getStrokeWidth() != f) {
            this.mPaint.setStrokeWidth(f);
            double d = (double) (f / 2.0f);
            double cos = Math.cos((double) ARROW_HEAD_ANGLE);
            Double.isNaN(d);
            this.mMaxCutForBarSize = (float) (d * cos);
            invalidateSelf();
        }
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    public void setGapSize(float f) {
        if (f != this.mBarGap) {
            this.mBarGap = f;
            invalidateSelf();
        }
    }

    public void setDirection(int i) {
        if (i != this.mDirection) {
            this.mDirection = i;
            invalidateSelf();
        }
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    public void setSpinEnabled(boolean z) {
        if (this.mSpin != z) {
            this.mSpin = z;
            invalidateSelf();
        }
    }

    public int getDirection() {
        return this.mDirection;
    }

    public void setVerticalMirror(boolean z) {
        if (this.mVerticalMirror != z) {
            this.mVerticalMirror = z;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i = this.mDirection;
        boolean z = false;
        if (i != 0 && (i == 1 || (i == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z = true;
        }
        float f = this.mArrowHeadLength;
        float lerp = lerp(this.mBarLength, (float) Math.sqrt((double) (f * f * 2.0f)), this.mProgress);
        float lerp2 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float round = (float) Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float lerp3 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        double d = (double) lerp;
        float lerp4 = lerp(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.mProgress);
        double d2 = (double) lerp3;
        double cos = Math.cos(d2);
        Double.isNaN(d);
        boolean z2 = z;
        float round2 = (float) Math.round(cos * d);
        double sin = Math.sin(d2);
        Double.isNaN(d);
        float round3 = (float) Math.round(d * sin);
        this.mPath.rewind();
        float lerp5 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float f2 = (-lerp2) / 2.0f;
        this.mPath.moveTo(f2 + round, 0.0f);
        this.mPath.rLineTo(lerp2 - (round * 2.0f), 0.0f);
        this.mPath.moveTo(f2, lerp5);
        this.mPath.rLineTo(round2, round3);
        this.mPath.moveTo(f2, -lerp5);
        this.mPath.rLineTo(round2, -round3);
        this.mPath.close();
        canvas.save();
        float strokeWidth = this.mPaint.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f3 = this.mBarGap;
        double d3 = (double) ((float) ((((int) (height - (2.0f * f3))) / 4) * 2));
        double d4 = (double) strokeWidth;
        Double.isNaN(d4);
        double d5 = (double) f3;
        Double.isNaN(d5);
        Double.isNaN(d3);
        canvas2.translate((float) bounds.centerX(), (float) (d3 + (d4 * 1.5d) + d5));
        if (this.mSpin) {
            canvas2.rotate(lerp4 * ((float) (this.mVerticalMirror ^ z2 ? -1 : 1)));
        } else if (z2) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.mSize;
    }

    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.mProgress != f) {
            this.mProgress = f;
            invalidateSelf();
        }
    }

    public final Paint getPaint() {
        return this.mPaint;
    }
}
