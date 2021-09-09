package com.mijia.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundCornerImageView extends ImageView {
    public RoundCornerImageView(Context context) {
        super(context);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), 30.0f, 30.0f, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
