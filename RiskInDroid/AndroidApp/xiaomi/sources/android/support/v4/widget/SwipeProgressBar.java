package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

final class SwipeProgressBar {
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private Rect mBounds = new Rect();
    private final RectF mClipRect = new RectF();
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    private long mFinishTime;
    private final Paint mPaint = new Paint();
    private View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;

    SwipeProgressBar(View view) {
        this.mParent = view;
        this.mColor1 = -1291845632;
        this.mColor2 = Integer.MIN_VALUE;
        this.mColor3 = 1291845632;
        this.mColor4 = 436207616;
    }

    /* access modifiers changed from: package-private */
    public final void setColorScheme(int i, int i2, int i3, int i4) {
        this.mColor1 = i;
        this.mColor2 = i2;
        this.mColor3 = i3;
        this.mColor4 = i4;
    }

    /* access modifiers changed from: package-private */
    public final void setTriggerPercentage(float f) {
        this.mTriggerPercentage = f;
        this.mStartTime = 0;
        ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        if (!this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = true;
            this.mParent.postInvalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void stop() {
        if (this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mFinishTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = false;
            this.mParent.postInvalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isRunning() {
        return this.mRunning || this.mFinishTime > 0;
    }

    /* access modifiers changed from: package-private */
    public final void draw(Canvas canvas) {
        long j;
        Canvas canvas2 = canvas;
        int width = this.mBounds.width();
        int height = this.mBounds.height();
        int i = width / 2;
        int i2 = height / 2;
        int save = canvas.save();
        canvas2.clipRect(this.mBounds);
        if (this.mRunning || this.mFinishTime > 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j2 = this.mStartTime;
            long j3 = (currentAnimationTimeMillis - j2) / 2000;
            float f = ((float) ((currentAnimationTimeMillis - j2) % 2000)) / 20.0f;
            boolean z = false;
            if (!this.mRunning) {
                j = j3;
                long j4 = this.mFinishTime;
                if (currentAnimationTimeMillis - j4 >= 1000) {
                    this.mFinishTime = 0;
                    return;
                }
                float f2 = (float) i;
                float interpolation = INTERPOLATOR.getInterpolation((((float) ((currentAnimationTimeMillis - j4) % 1000)) / 10.0f) / 100.0f) * f2;
                this.mClipRect.set(f2 - interpolation, 0.0f, f2 + interpolation, (float) height);
                canvas2.saveLayerAlpha(this.mClipRect, 0, 0);
                z = true;
            } else {
                j = j3;
            }
            if (j == 0) {
                canvas2.drawColor(this.mColor1);
            } else if (f >= 0.0f && f < 25.0f) {
                canvas2.drawColor(this.mColor4);
            } else if (f >= 25.0f && f < 50.0f) {
                canvas2.drawColor(this.mColor1);
            } else if (f < 50.0f || f >= 75.0f) {
                canvas2.drawColor(this.mColor3);
            } else {
                canvas2.drawColor(this.mColor2);
            }
            if (f >= 0.0f && f <= 25.0f) {
                Canvas canvas3 = canvas;
                drawCircle(canvas3, (float) i, (float) i2, this.mColor1, ((f + 25.0f) * 2.0f) / 100.0f);
            }
            if (f >= 0.0f && f <= 50.0f) {
                Canvas canvas4 = canvas;
                drawCircle(canvas4, (float) i, (float) i2, this.mColor2, (f * 2.0f) / 100.0f);
            }
            if (f >= 25.0f && f <= 75.0f) {
                Canvas canvas5 = canvas;
                drawCircle(canvas5, (float) i, (float) i2, this.mColor3, ((f - 25.0f) * 2.0f) / 100.0f);
            }
            if (f >= 50.0f && f <= 100.0f) {
                Canvas canvas6 = canvas;
                drawCircle(canvas6, (float) i, (float) i2, this.mColor4, ((f - 50.0f) * 2.0f) / 100.0f);
            }
            if (f >= 75.0f && f <= 100.0f) {
                Canvas canvas7 = canvas;
                drawCircle(canvas7, (float) i, (float) i2, this.mColor1, ((f - 75.0f) * 2.0f) / 100.0f);
            }
            if (this.mTriggerPercentage > 0.0f && z) {
                canvas2.restoreToCount(save);
                int save2 = canvas.save();
                canvas2.clipRect(this.mBounds);
                drawTrigger(canvas2, i, i2);
                save = save2;
            }
            ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
        } else {
            float f3 = this.mTriggerPercentage;
            if (f3 > 0.0f && ((double) f3) <= 1.0d) {
                drawTrigger(canvas2, i, i2);
            }
        }
        canvas2.restoreToCount(save);
    }

    private void drawTrigger(Canvas canvas, int i, int i2) {
        this.mPaint.setColor(this.mColor1);
        float f = (float) i;
        canvas.drawCircle(f, (float) i2, this.mTriggerPercentage * f, this.mPaint);
    }

    private void drawCircle(Canvas canvas, float f, float f2, int i, float f3) {
        this.mPaint.setColor(i);
        canvas.save();
        canvas.translate(f, f2);
        float interpolation = INTERPOLATOR.getInterpolation(f3);
        canvas.scale(interpolation, interpolation);
        canvas.drawCircle(0.0f, 0.0f, f, this.mPaint);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    public final void setBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.mBounds;
        rect.left = i;
        rect.top = i2;
        rect.right = i3;
        rect.bottom = i4;
    }
}
