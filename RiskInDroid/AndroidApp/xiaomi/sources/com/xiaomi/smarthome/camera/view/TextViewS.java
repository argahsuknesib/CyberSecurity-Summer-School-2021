package com.xiaomi.smarthome.camera.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewS extends TextView {
    public TextViewS(Context context) {
        super(context);
    }

    public TextViewS(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextViewS(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public TextViewS(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        rectF.left = 0.0f;
        rectF.right = (float) getMeasuredWidth();
        rectF.top = 0.0f;
        rectF.bottom = (float) getMeasuredHeight();
        Rect rect = new Rect();
        if (!TextUtils.isEmpty(getText())) {
            getPaint().getTextBounds(getText().toString(), 0, getText().toString().length(), rect);
            int measuredWidth = (getMeasuredWidth() - rect.width()) / 2;
            rectF.left = (float) (measuredWidth - getPaddingLeft());
            rectF.right = (float) (rect.width() + measuredWidth + getPaddingRight());
        }
        canvas.drawRoundRect(rectF, 8.0f, 8.0f, paint);
    }
}
