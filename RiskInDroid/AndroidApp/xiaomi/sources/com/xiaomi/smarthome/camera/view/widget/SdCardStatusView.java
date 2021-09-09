package com.xiaomi.smarthome.camera.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class SdCardStatusView extends View {
    private Paint mPaint;
    private RectF mRect;

    public SdCardStatusView(Context context) {
        this(context, null);
    }

    public SdCardStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = getLayoutParams().width;
        int i4 = getLayoutParams().height;
        RectF rectF = this.mRect;
        rectF.right = (float) i3;
        rectF.bottom = (float) i4;
    }

    public SdCardStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRect = new RectF();
        RectF rectF = this.mRect;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        Drawable background = getBackground();
        this.mPaint = new Paint();
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (background instanceof ColorDrawable) {
            this.mPaint.setColor(((ColorDrawable) background).getColor());
        } else {
            this.mPaint.setColor(-1);
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawOval(this.mRect, this.mPaint);
    }
}
