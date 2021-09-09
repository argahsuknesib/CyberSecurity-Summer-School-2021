package com.xiaomi.smarthome.camera.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewP extends TextView {
    public TextViewP(Context context) {
        super(context);
    }

    public TextViewP(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextViewP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public TextViewP(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(getTextSize());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int measuredWidth = getMeasuredWidth() / 2;
        int measuredHeight = getMeasuredHeight() / 2;
        RectF rectF = new RectF();
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(4.0f);
        paint2.setStyle(Paint.Style.STROKE);
        int measureText = (((int) paint.measureText(getText().toString())) + 3) / 2;
        rectF.left = (float) (measuredWidth - measureText);
        rectF.right = (float) (measuredWidth + measureText);
        int ceil = (((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent))) + 3) / 2;
        rectF.top = (float) (measuredHeight - ceil);
        rectF.bottom = (float) (measuredHeight + ceil);
        canvas.drawRoundRect(rectF, 8.0f, 8.0f, paint2);
    }
}
