package com.scwang.smartrefresh.header.waterdrop;

import _m_j.czm;
import _m_j.dao;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class WaterDropView extends View {
    protected static int O0000O0o = 2;

    /* renamed from: O000000o  reason: collision with root package name */
    protected czm f5551O000000o = new czm();
    protected czm O00000Oo = new czm();
    protected Paint O00000o = new Paint();
    protected Path O00000o0 = new Path();
    protected int O00000oO;
    protected int O00000oo;

    public WaterDropView(Context context) {
        super(context);
        this.O00000o.setColor(-7829368);
        this.O00000o.setAntiAlias(true);
        this.O00000o.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint = this.O00000o;
        int O000000o2 = dao.O000000o(1.0f);
        O0000O0o = O000000o2;
        paint.setStrokeWidth((float) O000000o2);
        Paint paint2 = this.O00000o;
        int i = O0000O0o;
        paint2.setShadowLayer((float) i, (float) (i / 2), (float) i, -1728053248);
        setLayerType(1, null);
        int i2 = O0000O0o * 4;
        setPadding(i2, i2, i2, i2);
        this.O00000o.setColor(-7829368);
        this.O00000oO = dao.O000000o(20.0f);
        int i3 = this.O00000oO;
        this.O00000oo = i3 / 5;
        czm czm = this.f5551O000000o;
        czm.O00000o0 = (float) i3;
        czm czm2 = this.O00000Oo;
        czm2.O00000o0 = (float) i3;
        int i4 = O0000O0o;
        czm.f14411O000000o = (float) (i4 + i3);
        czm.O00000Oo = (float) (i4 + i3);
        czm2.f14411O000000o = (float) (i4 + i3);
        czm2.O00000Oo = (float) (i4 + i3);
    }

    public int getMaxCircleRadius() {
        return this.O00000oO;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(((this.O00000oO + O0000O0o) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil((double) (this.O00000Oo.O00000Oo + this.O00000Oo.O00000o0 + ((float) (O0000O0o * 2))))) + getPaddingTop() + getPaddingBottom(), i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        O000000o(getHeight());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f = (float) height;
        float f2 = (float) paddingTop;
        float f3 = (float) paddingBottom;
        if (f <= (this.f5551O000000o.O00000o0 * 2.0f) + f2 + f3) {
            canvas.translate((float) paddingLeft, (f - (this.f5551O000000o.O00000o0 * 2.0f)) - f3);
            canvas.drawCircle(this.f5551O000000o.f14411O000000o, this.f5551O000000o.O00000Oo, this.f5551O000000o.O00000o0, this.O00000o);
        } else {
            canvas.translate((float) paddingLeft, f2);
            this.O00000o0.reset();
            this.O00000o0.addCircle(this.f5551O000000o.f14411O000000o, this.f5551O000000o.O00000Oo, this.f5551O000000o.O00000o0, Path.Direction.CCW);
            if (this.O00000Oo.O00000Oo > this.f5551O000000o.O00000Oo + ((float) dao.O000000o(1.0f))) {
                this.O00000o0.addCircle(this.O00000Oo.f14411O000000o, this.O00000Oo.O00000Oo, this.O00000Oo.O00000o0, Path.Direction.CCW);
                double angle = getAngle();
                double d = (double) this.f5551O000000o.f14411O000000o;
                double d2 = (double) this.f5551O000000o.O00000o0;
                double cos = Math.cos(angle);
                Double.isNaN(d2);
                Double.isNaN(d);
                double d3 = (double) this.f5551O000000o.O00000Oo;
                double d4 = (double) this.f5551O000000o.O00000o0;
                double sin = Math.sin(angle);
                Double.isNaN(d4);
                Double.isNaN(d3);
                float f4 = (float) (d3 + (d4 * sin));
                double d5 = (double) this.f5551O000000o.f14411O000000o;
                double d6 = (double) this.f5551O000000o.O00000o0;
                double cos2 = Math.cos(angle);
                Double.isNaN(d6);
                Double.isNaN(d5);
                float f5 = (float) (d5 + (d6 * cos2));
                double d7 = (double) this.O00000Oo.f14411O000000o;
                double d8 = (double) this.O00000Oo.O00000o0;
                double cos3 = Math.cos(angle);
                Double.isNaN(d8);
                Double.isNaN(d7);
                double d9 = (double) this.O00000Oo.O00000Oo;
                double d10 = (double) this.O00000Oo.O00000o0;
                double sin2 = Math.sin(angle);
                Double.isNaN(d10);
                Double.isNaN(d9);
                float f6 = (float) (d9 + (d10 * sin2));
                double d11 = (double) this.O00000Oo.f14411O000000o;
                double d12 = (double) this.O00000Oo.O00000o0;
                double cos4 = Math.cos(angle);
                Double.isNaN(d12);
                Double.isNaN(d11);
                float f7 = (float) (d11 + (d12 * cos4));
                this.O00000o0.moveTo(this.f5551O000000o.f14411O000000o, this.f5551O000000o.O00000Oo);
                this.O00000o0.lineTo((float) (d - (d2 * cos)), f4);
                this.O00000o0.quadTo(this.O00000Oo.f14411O000000o - this.O00000Oo.O00000o0, (this.O00000Oo.O00000Oo + this.f5551O000000o.O00000Oo) / 2.0f, (float) (d7 - (d8 * cos3)), f6);
                this.O00000o0.lineTo(f7, f6);
                this.O00000o0.quadTo(this.O00000Oo.f14411O000000o + this.O00000Oo.O00000o0, (this.O00000Oo.O00000Oo + f4) / 2.0f, f5, f4);
            }
            this.O00000o0.close();
            canvas.drawPath(this.O00000o0, this.O00000o);
        }
        canvas.restore();
    }

    private double getAngle() {
        if (this.O00000Oo.O00000o0 > this.f5551O000000o.O00000o0) {
            return 0.0d;
        }
        return Math.asin((double) ((this.f5551O000000o.O00000o0 - this.O00000Oo.O00000o0) / (this.O00000Oo.O00000Oo - this.f5551O000000o.O00000Oo)));
    }

    public final void O000000o(float f) {
        int i = this.O00000oO;
        double d = (double) i;
        double d2 = (double) f;
        Double.isNaN(d2);
        double d3 = (double) i;
        Double.isNaN(d3);
        Double.isNaN(d);
        float f2 = f * 4.0f * ((float) i);
        czm czm = this.f5551O000000o;
        czm.O00000o0 = (float) (d - ((d2 * 0.25d) * d3));
        czm czm2 = this.O00000Oo;
        czm2.O00000o0 = (((float) (this.O00000oo - i)) * f) + ((float) i);
        czm2.O00000Oo = czm.O00000Oo + f2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    public final void O000000o(int i) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = this.O00000oO;
        float f = (float) ((i2 * 2) + paddingTop + paddingBottom);
        float f2 = (float) i;
        if (f2 < f) {
            czm czm = this.f5551O000000o;
            czm.O00000o0 = (float) i2;
            czm czm2 = this.O00000Oo;
            czm2.O00000o0 = (float) i2;
            czm2.O00000Oo = czm.O00000Oo;
            return;
        }
        float max = Math.max(0.0f, f2 - f);
        double d = (double) ((float) (i2 - this.O00000oo));
        Double.isNaN(d);
        float pow = (float) (d * (1.0d - Math.pow(100.0d, (double) ((-max) / ((float) dao.O000000o(200.0f))))));
        czm czm3 = this.f5551O000000o;
        int i3 = this.O00000oO;
        czm3.O00000o0 = ((float) i3) - (pow / 4.0f);
        czm czm4 = this.O00000Oo;
        czm4.O00000o0 = ((float) i3) - pow;
        czm4.O00000Oo = ((float) ((i - paddingTop) - paddingBottom)) - czm4.O00000o0;
    }

    public czm getTopCircle() {
        return this.f5551O000000o;
    }

    public czm getBottomCircle() {
        return this.O00000Oo;
    }

    public void setIndicatorColor(int i) {
        this.O00000o.setColor(i);
    }

    public int getIndicatorColor() {
        return this.O00000o.getColor();
    }
}
