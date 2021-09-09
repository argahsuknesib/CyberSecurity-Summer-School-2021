package com.xiaomi.smarthome.library.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressBar extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f9153O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    private float O00000oo;
    private float O0000O0o = 100.0f;
    private Paint O0000OOo = new Paint();
    private int O0000Oo;
    private RectF O0000Oo0 = new RectF();

    public CircleProgressBar(Context context) {
        super(context);
        O000000o();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    @TargetApi(21)
    public CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o();
    }

    private void O000000o() {
        this.O0000OOo.setAntiAlias(true);
        this.O0000OOo.setStyle(Paint.Style.STROKE);
        this.O0000OOo.setStrokeCap(Paint.Cap.ROUND);
        this.O0000OOo.setStrokeJoin(Paint.Join.ROUND);
        int i = (int) (getContext().getResources().getDisplayMetrics().density * 3.0f);
        this.O00000o0 = i;
        this.O00000o = i;
        this.O00000oO = -16777216;
        this.O00000Oo = -65536;
        this.f9153O000000o = -65536;
        this.O0000Oo = this.O00000o0 * 4;
    }

    public void setProgress(float f) {
        this.O00000oo = f;
        invalidate();
    }

    public void setMaxProgress(float f) {
        this.O0000O0o = f;
        invalidate();
    }

    public float getProgress() {
        return this.O00000oo;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O0000Oo0.set((float) (getPaddingLeft() + this.O00000o), (float) (getPaddingTop() + this.O00000o), (float) ((getWidth() - getPaddingRight()) - this.O00000o), (float) ((getHeight() - getPaddingBottom()) - this.O00000o));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.O0000OOo.setStrokeWidth((float) this.O00000o);
        this.O0000OOo.setColor(this.O00000oO);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.O0000Oo0, 0.0f, 360.0f, false, this.O0000OOo);
        this.O0000OOo.setColor(this.O00000Oo);
        float f = (this.O00000oo * 360.0f) / this.O0000O0o;
        canvas2.drawArc(this.O0000Oo0, 270.0f, f, false, this.O0000OOo);
        int height = getHeight() / 2;
        float width = (float) (getWidth() / 2);
        float f2 = (float) height;
        canvas.rotate(f, width, f2);
        this.O0000OOo.setStrokeWidth((float) this.O00000o0);
        this.O0000OOo.setColor(this.f9153O000000o);
        float f3 = this.O00000oo;
        float f4 = this.O0000O0o;
        if (f3 > f4) {
            int i = this.O0000Oo;
            float f5 = ((((f3 * 1.7f) / f4) * ((float) i)) / 3.0f) + f2;
            canvas.drawLine(width - (((f3 / f4) * ((float) i)) / 1.5f), f5, width, (float) (height - (i / 2)), this.O0000OOo);
        } else {
            int i2 = this.O0000Oo;
            canvas.drawLine(width - (((float) i2) / 1.5f), (float) ((i2 / 3) + height), width, (float) (height - (i2 / 2)), this.O0000OOo);
        }
        int i3 = this.O0000Oo;
        canvas.drawLine(width, (float) (height - (i3 / 2)), width + (((float) i3) / 1.5f), (float) (height + (i3 / 3)), this.O0000OOo);
    }
}
