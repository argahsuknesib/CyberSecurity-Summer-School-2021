package com.xiaomi.smarthome.miio.miband.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SimpleCircleProgressView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f9757O000000o = 122;
    private static int O00000Oo = 255;
    private Paint O00000o;
    private float O00000o0 = 0.0f;
    private int O00000oO;
    private int O00000oo = 0;
    private int O0000O0o = 0;
    private int O0000OOo = 0;
    private float O0000Oo0 = 0.0f;

    public SimpleCircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public SimpleCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public SimpleCircleProgressView(Context context) {
        super(context);
        O000000o();
    }

    public void setProgress(float f) {
        if (f >= 0.0f && f <= 360.0f) {
            this.O00000o0 = f;
            invalidate();
        }
    }

    private void O000000o() {
        this.O0000Oo0 = getContext().getResources().getDisplayMetrics().density;
        this.O00000oO = -1;
        this.O00000oo = (getWidth() < getHeight() ? getWidth() : getHeight()) / 2;
        this.O00000o = new Paint();
        this.O00000o.setColor(this.O00000oO);
        this.O00000o.setAntiAlias(true);
        this.O00000o.setStyle(Paint.Style.STROKE);
        this.O00000o.setStrokeWidth(this.O0000Oo0 * 1.2f);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O0000O0o = (getRight() - getLeft()) / 2;
        this.O0000OOo = (getBottom() - getTop()) / 2;
        this.O00000oo = (getWidth() > getHeight() ? getHeight() : getWidth()) / 2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.O00000oo - 50;
        for (int i2 = 0; i2 < 250; i2++) {
            float f = (float) i2;
            int i3 = this.O0000O0o;
            double d = (double) this.O00000oo;
            double d2 = (double) ((((2.0f * f) / 250.0f) - 0.5f) * 3.1415927f);
            double cos = Math.cos(d2);
            Double.isNaN(d);
            int i4 = i3 + ((int) (d * cos));
            int i5 = this.O0000OOo;
            double d3 = (double) this.O00000oo;
            double sin = Math.sin(d2);
            Double.isNaN(d3);
            int i6 = i5 + ((int) (d3 * sin));
            int i7 = this.O0000O0o;
            double d4 = (double) i;
            double cos2 = Math.cos(d2);
            Double.isNaN(d4);
            int i8 = i7 + ((int) (cos2 * d4));
            int i9 = this.O0000OOo;
            double sin2 = Math.sin(d2);
            Double.isNaN(d4);
            int i10 = i9 + ((int) (d4 * sin2));
            if ((f * 1.0f) / 250.0f < this.O00000o0) {
                this.O00000o.setAlpha(O00000Oo);
            } else {
                this.O00000o.setAlpha(f9757O000000o);
            }
            canvas.drawLine((float) i4, (float) i6, (float) i8, (float) i10, this.O00000o);
        }
    }
}
