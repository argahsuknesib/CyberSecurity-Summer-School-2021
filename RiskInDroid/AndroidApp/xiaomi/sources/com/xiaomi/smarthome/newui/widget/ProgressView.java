package com.xiaomi.smarthome.newui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ProgressView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f10321O000000o;
    public int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o = 100.0f;
    private Paint O0000OOo = new Paint();
    private int O0000Oo;
    private RectF O0000Oo0 = new RectF();
    private float O0000OoO = 0.55f;
    private PathMeasure O0000Ooo = new PathMeasure();
    private long O0000o = 500;
    private Path O0000o0 = new Path();
    private Path O0000o00 = new Path();
    private float O0000o0O;
    private long O0000o0o;
    private float O0000oO0;

    public ProgressView(Context context) {
        super(context);
        O000000o();
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    @TargetApi(21)
    public ProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o();
    }

    private void O000000o() {
        this.O0000OOo.setAntiAlias(true);
        this.O0000OOo.setStyle(Paint.Style.STROKE);
        this.O0000OOo.setStrokeCap(Paint.Cap.ROUND);
        this.O0000OOo.setStrokeJoin(Paint.Join.ROUND);
        int i = (int) (getContext().getResources().getDisplayMetrics().density * 3.0f);
        this.f10321O000000o = i;
        this.O00000Oo = i;
        this.O0000Oo = -16777216;
        this.O00000o = -65536;
        this.O00000o0 = -65536;
    }

    public final void setColor$4868d30e(int i) {
        this.O00000o0 = i;
        this.O00000o = -14105143;
        this.O0000Oo = 0;
        invalidate();
    }

    public void setSuccessTime(long j) {
        this.O0000o = j;
    }

    public void setProgress(float f) {
        if (this.O00000oO < 0.0f) {
            this.O00000oo = f;
        }
        if (f != this.O0000O0o) {
            this.O0000o0O = 0.0f;
            this.O0000o0o = 0;
        }
        this.O00000oO = f;
    }

    public float getProgress() {
        return Math.min(this.O00000oO, this.O0000O0o);
    }

    public void setMaxProgress(float f) {
        this.O0000O0o = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O0000Oo0.set(((float) getPaddingLeft()) + (((float) this.O00000Oo) / 2.0f), ((float) getPaddingTop()) + (((float) this.O00000Oo) / 2.0f), ((float) (getWidth() - getPaddingRight())) - (((float) this.O00000Oo) / 2.0f), ((float) (getHeight() - getPaddingBottom())) - (((float) this.O00000Oo) / 2.0f));
        int width = getWidth() / 2;
        int i5 = (int) (this.O0000OoO * ((float) width));
        this.O0000o00.reset();
        double height = (double) (getHeight() / 2);
        double d = (double) i5;
        Double.isNaN(d);
        Double.isNaN(height);
        int i6 = (int) (height + (d / 1.7d));
        float f = (float) (width - (i5 / 10));
        float f2 = (float) i5;
        float f3 = 0.5f * f2;
        float f4 = f - (1.0f * f3);
        float f5 = (float) i6;
        float f6 = f5 - f3;
        this.O0000o0.moveTo(f4, f6);
        this.O0000o00.moveTo(f4, f6);
        this.O0000o00.lineTo(f, f5);
        float f7 = f2 * 0.8f;
        this.O0000o00.lineTo(f + f7, f5 - (f7 * 1.4f));
        this.O0000Ooo.setPath(this.O0000o00, false);
        this.O0000oO0 = this.O0000Ooo.getLength();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        this.O0000OOo.setColor(this.O00000o0);
        this.O0000OOo.setStrokeWidth((float) this.f10321O000000o);
        this.O0000OOo.setAntiAlias(true);
        this.O0000OOo.setStrokeCap(Paint.Cap.ROUND);
        if (this.O00000oO >= this.O0000O0o) {
            long j = this.O0000o0o;
            if (j != 0) {
                this.O0000o0O += (this.O0000oO0 * ((float) (currentTimeMillis - j))) / ((float) this.O0000o);
            }
            this.O0000o0o = currentTimeMillis;
            float f = this.O0000o0O;
            float f2 = this.O0000oO0;
            if (f < f2) {
                postInvalidate();
            } else {
                this.O0000o0O = f2;
            }
            this.O0000Ooo.getSegment(0.0f, this.O0000o0O, this.O0000o0, false);
            canvas.drawPath(this.O0000o0, this.O0000OOo);
        }
        this.O0000OOo.setColor(this.O0000Oo);
        this.O0000OOo.setStrokeWidth((float) this.O00000Oo);
        canvas.drawArc(this.O0000Oo0, 0.0f, 360.0f, false, this.O0000OOo);
        this.O0000OOo.setColor(this.O00000o);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f3 = this.O00000oO;
        if (f3 > 0.0f) {
            float f4 = this.O00000oo;
            if (f4 != f3) {
                this.O00000oo = f4 + Math.max(1.0f, (f3 - f4) / 10.0f);
                postInvalidate();
            }
            canvas.drawArc(this.O0000Oo0, 270.0f, (this.O00000oo * 360.0f) / this.O0000O0o, false, this.O0000OOo);
            return;
        }
        canvas.rotate((float) ((currentTimeMillis / 4) % 360), (float) width, (float) height);
        canvas.drawArc(this.O0000Oo0, 270.0f, 340.0f, false, this.O0000OOo);
        postInvalidate();
    }
}
