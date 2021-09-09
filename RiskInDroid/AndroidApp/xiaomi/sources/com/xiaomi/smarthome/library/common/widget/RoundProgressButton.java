package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;

public class RoundProgressButton extends AppCompatButton {
    private Context context;
    private RectF dstRect;
    GradientDrawable mDrawableProgress;
    private boolean mFinish;
    private Paint mPaint;
    private float maxProgress;
    private Canvas proCanvas;
    private float progress;
    private int progressBackgroundColor;
    private int progressBackgroundTextColor;
    private Bitmap progressBitmap;
    private int progressForegroundColor;
    private int progressForegroundTextColor;
    private int radius;
    private RectF srcRect;
    private Bitmap textBitmap;
    private Canvas textCanvas;
    private int viewHeight;
    private int viewWidth;
    private Xfermode xfermode;

    public RoundProgressButton(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public RoundProgressButton(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.maxProgress = 100.0f;
        this.progress = 0.0f;
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.mFinish = false;
        this.progressForegroundTextColor = -1;
        this.mDrawableProgress = new GradientDrawable();
        init(context2, attributeSet);
    }

    private void init(Context context2, AttributeSet attributeSet) {
        this.context = context2;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize(getTextSize());
        this.progressBackgroundTextColor = ContextCompat.O00000o0(context2, R.color.mj_color_btn_green_nor);
        this.progressForegroundTextColor = -1;
        this.progressBackgroundColor = ContextCompat.O00000o0(context2, R.color.mj_color_updae_btn_bg_color);
        this.progressForegroundColor = ContextCompat.O00000o0(context2, R.color.mj_color_btn_green_nor);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        this.viewHeight = i2;
        this.progressBitmap = Bitmap.createBitmap(this.viewWidth, this.viewHeight, Bitmap.Config.ARGB_8888);
        this.textBitmap = Bitmap.createBitmap(this.viewWidth, this.viewHeight, Bitmap.Config.ARGB_8888);
        this.proCanvas = new Canvas(this.progressBitmap);
        this.textCanvas = new Canvas(this.textBitmap);
        this.radius = dp2px(17.0f);
        float f = (float) i;
        float f2 = (float) i2;
        this.srcRect = new RectF(0.0f, 0.0f, f, f2);
        this.dstRect = new RectF(0.0f, 0.0f, f, f2);
    }

    public RoundProgressButton setMaxProgress(float f) {
        this.maxProgress = f;
        return this;
    }

    public boolean setProgress(float f) {
        int i;
        String str;
        float f2 = f;
        Canvas canvas = this.proCanvas;
        if (canvas == null) {
            return false;
        }
        this.progress = f2;
        canvas.drawColor(this.progressBackgroundColor, PorterDuff.Mode.CLEAR);
        int i2 = this.viewWidth;
        int i3 = (int) ((((float) i2) * f2) / this.maxProgress);
        int i4 = this.radius;
        int i5 = i2 - (i4 * 2);
        int i6 = this.viewHeight;
        if (i3 < i4) {
            int i7 = (i6 / 2) - i4;
            double sqrt = Math.sqrt(Math.pow((double) i4, 2.0d) - Math.pow((double) (this.radius - i3), 2.0d));
            int i8 = this.viewHeight;
            double d = (double) ((i8 / 2) - i7);
            Double.isNaN(d);
            i = (int) (d - sqrt);
            double d2 = (double) ((i8 / 2) + i7);
            Double.isNaN(d2);
            i6 = (int) (d2 + sqrt);
            float f3 = (float) i3;
            float f4 = (float) ((int) sqrt);
            this.mDrawableProgress.setCornerRadii(new float[]{f3, f4, 0.0f, 0.0f, 0.0f, 0.0f, f3, f4});
        } else {
            if (i2 - i3 < i4) {
                float f5 = (float) ((i3 - i5) - i4);
                this.mDrawableProgress.setCornerRadii(new float[]{(float) i4, (float) i4, f5, f5, f5, f5, (float) i4, (float) i4});
            } else {
                setCornerRadii(this.mDrawableProgress, (float) i4, 0.0f, 0.0f, (float) i4);
            }
            i = 0;
        }
        this.mDrawableProgress.setBounds(new Rect(0, i, i3, i6));
        this.mDrawableProgress.draw(this.proCanvas);
        this.mDrawableProgress.setColor(this.progressForegroundColor);
        int i9 = (int) f2;
        if (i9 >= 0) {
            str = i9 + "%";
        } else {
            str = "";
        }
        this.mPaint.setColor(this.progressBackgroundTextColor);
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        float f6 = fontMetrics.bottom - fontMetrics.top;
        int i10 = this.viewHeight;
        float f7 = (((float) i10) - ((((float) i10) - f6) / 2.0f)) - fontMetrics.bottom;
        this.textCanvas.drawColor(this.progressForegroundTextColor, PorterDuff.Mode.CLEAR);
        this.textCanvas.drawText(str, (((float) this.viewWidth) - this.mPaint.measureText(str)) / 2.0f, f7, this.mPaint);
        invalidate();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(this.srcRect, this.mPaint, 31);
        canvas.drawBitmap(this.progressBitmap, (Rect) null, this.srcRect, this.mPaint);
        this.mPaint.setXfermode(this.xfermode);
        canvas.drawBitmap(this.textBitmap, (Rect) null, this.dstRect, this.mPaint);
        this.mPaint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    private int dp2px(float f) {
        return (int) ((f * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void reset() {
        this.mFinish = false;
        this.progress = 0.0f;
    }

    private void setCornerRadii(GradientDrawable gradientDrawable, float f, float f2, float f3, float f4) {
        gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
    }
}
