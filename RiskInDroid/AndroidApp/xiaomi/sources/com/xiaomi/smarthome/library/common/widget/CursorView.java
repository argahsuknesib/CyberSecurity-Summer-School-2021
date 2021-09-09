package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CursorView extends ImageView {
    int mColor;
    Paint mPaint = new Paint();

    public CursorView(Context context) {
        super(context);
    }

    public CursorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CursorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStrokeWidth(3.0f);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2), 15.0f, this.mPaint);
    }
}
