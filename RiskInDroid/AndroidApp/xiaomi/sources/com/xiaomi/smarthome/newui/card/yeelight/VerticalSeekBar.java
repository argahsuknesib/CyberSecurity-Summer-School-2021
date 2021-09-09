package com.xiaomi.smarthome.newui.card.yeelight;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class VerticalSeekBar extends SeekBar {
    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setPadding(0, 0, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPadding(0, 0, 0, 0);
    }

    public VerticalSeekBar(Context context) {
        super(context);
        setPadding(0, 0, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate((float) (-getHeight()), 0.0f);
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 2) {
            setProgress(getMax() - ((int) ((((float) getMax()) * motionEvent.getY()) / ((float) getHeight()))));
            onSizeChanged(getWidth(), getHeight(), 0, 0);
        }
        return true;
    }
}
