package com.mi.global.shop.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class PercentageRing extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private Paint f4958O000000o;
    private Paint O00000Oo;
    private Paint O00000o;
    private Paint O00000o0;
    private int O00000oO;
    private int O00000oo;
    private float O0000O0o;
    private RectF O0000OOo;
    private float O0000Oo;
    private float O0000Oo0;
    private float O0000OoO;
    private int O0000Ooo;
    private int O0000o;
    private int O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private int O0000o0o;

    public PercentageRing(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public PercentageRing(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.antiRingColor, R.attr.circleBackground, R.attr.radius1, R.attr.ringColor, R.attr.textColor});
        this.O0000o00 = obtainStyledAttributes.getColor(1, -5262117);
        this.O0000o0 = obtainStyledAttributes.getColor(3, -9875295);
        this.O0000o0O = obtainStyledAttributes.getColor(0, 16777215);
        this.O0000Ooo = obtainStyledAttributes.getInt(2, 60);
        this.O0000o = obtainStyledAttributes.getColor(4, -1);
        obtainStyledAttributes.recycle();
        O000000o();
    }

    public PercentageRing(Context context) {
        super(context);
        O000000o();
    }

    private void O000000o() {
        this.O0000Oo0 = -90.0f;
        this.O0000O0o = 0.0f;
        this.O0000OoO = 0.0f;
        this.f4958O000000o = new Paint();
        this.f4958O000000o.setAntiAlias(true);
        this.f4958O000000o.setColor(this.O0000o00);
        this.f4958O000000o.setStyle(Paint.Style.FILL);
        this.O00000Oo = new Paint();
        this.O00000Oo.setColor(this.O0000o);
        this.O00000Oo.setAntiAlias(true);
        this.O00000Oo.setStyle(Paint.Style.FILL);
        Paint paint = this.O00000Oo;
        double d = (double) this.O0000Ooo;
        Double.isNaN(d);
        paint.setStrokeWidth((float) (d * 0.025d));
        this.O00000Oo.setTextSize((float) (this.O0000Ooo / 2));
        this.O00000Oo.setTextAlign(Paint.Align.CENTER);
        this.O00000o0 = new Paint();
        this.O00000o0.setAntiAlias(true);
        this.O00000o0.setColor(this.O0000o0);
        this.O00000o0.setStyle(Paint.Style.STROKE);
        Paint paint2 = this.O00000o0;
        double d2 = (double) this.O0000Ooo;
        Double.isNaN(d2);
        paint2.setStrokeWidth((float) (d2 * 0.075d));
        this.O00000o = new Paint();
        this.O00000o.setAntiAlias(true);
        this.O00000o.setColor(this.O0000o0O);
        this.O00000o.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.O00000o;
        double d3 = (double) this.O0000Ooo;
        Double.isNaN(d3);
        paint3.setStrokeWidth((float) (d3 * 0.075d));
        this.O0000o0o = (int) this.O00000Oo.getTextSize();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(O000000o(i), O000000o(i));
        this.O00000oO = getMeasuredWidth() / 2;
        this.O00000oo = getMeasuredHeight() / 2;
        int i3 = this.O0000Ooo;
        int i4 = this.O00000oO;
        if (i3 > i4) {
            this.O0000Ooo = i4;
            double d = (double) i4;
            double d2 = (double) this.O0000Ooo;
            Double.isNaN(d2);
            Double.isNaN(d);
            this.O0000Ooo = (int) (d - (d2 * 0.075d));
            Paint paint = this.O00000Oo;
            double d3 = (double) this.O0000Ooo;
            Double.isNaN(d3);
            paint.setStrokeWidth((float) (d3 * 0.025d));
            this.O00000Oo.setTextSize((float) (this.O0000Ooo / 2));
            Paint paint2 = this.O00000o0;
            double d4 = (double) this.O0000Ooo;
            Double.isNaN(d4);
            paint2.setStrokeWidth((float) (d4 * 0.075d));
            Paint paint3 = this.O00000o;
            double d5 = (double) this.O0000Ooo;
            Double.isNaN(d5);
            paint3.setStrokeWidth((float) (d5 * 0.075d));
            this.O0000o0o = (int) this.O00000Oo.getTextSize();
        }
        int i5 = this.O00000oO;
        int i6 = this.O0000Ooo;
        int i7 = this.O00000oo;
        this.O0000OOo = new RectF((float) (i5 - i6), (float) (i7 - i6), (float) (i5 + i6), (float) (i7 + i6));
    }

    private int O000000o(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        double d = (double) this.O0000Ooo;
        Double.isNaN(d);
        int i2 = (int) (d * 1.075d * 2.0d);
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float) this.O00000oO, (float) this.O00000oo, (float) this.O0000Ooo, this.f4958O000000o);
        canvas.drawArc(this.O0000OOo, this.O0000Oo0, this.O0000O0o, false, this.O00000o0);
        RectF rectF = this.O0000OOo;
        float f = this.O0000Oo0;
        float f2 = this.O0000O0o;
        float f3 = f + f2;
        float f4 = 360.0f - f2;
        canvas.drawArc(rectF, f3, f4, false, this.O00000o);
        canvas.drawText(this.O0000OoO + "%", (float) this.O00000oO, (float) (this.O00000oo + (this.O0000o0o / 4)), this.O00000Oo);
        float f5 = this.O0000OoO;
        if (f5 < this.O0000Oo) {
            this.O0000OoO = f5 + 1.0f;
            double d = (double) this.O0000O0o;
            Double.isNaN(d);
            this.O0000O0o = (float) (d + 3.6d);
            postInvalidateDelayed(10);
        }
    }

    public void setTargetPercent(int i) {
        this.O0000Oo = (float) i;
    }

    public void setCurrentPercent(float f) {
        if (this.O0000OoO != f) {
            this.O0000OoO = f;
            this.O0000O0o = this.O0000OoO * 3.6f;
            invalidate();
        }
    }
}
