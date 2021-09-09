package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class BaselineTextView extends TextView {
    public BaselineTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.translate(0.0f, (float) (getHeight() - getBaseline()));
        super.onDraw(canvas);
    }
}
