package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class DragCircleProgressView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f9174O000000o;
    private float O00000Oo;
    protected int O00000o = 60;
    protected Drawable O00000o0;
    protected int O00000oO = 0;
    protected double O00000oo = 0.0d;
    protected int O0000O0o = 0;
    protected int O0000OOo = 0;
    protected double O0000Oo;
    protected boolean O0000Oo0 = true;
    protected double O0000OoO;
    protected int O0000Ooo;
    protected int O0000o;
    protected int O0000o0;
    protected int O0000o00;
    protected int O0000o0O;
    protected Paint O0000o0o;
    protected Paint O0000oO;
    protected Paint O0000oO0;
    protected int O0000oOO;
    protected RectF O0000oOo = null;
    protected Resources O0000oo;
    protected int O0000oo0 = 1;
    private O000000o O0000ooO;
    private boolean O0000ooo = false;

    public interface O000000o {
    }

    /* access modifiers changed from: protected */
    public void O000000o(Canvas canvas, int i) {
    }

    public DragCircleProgressView(Context context) {
        super(context);
        O000000o();
    }

    public DragCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public DragCircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O0000oo = getContext().getResources();
        float f = this.O0000oo.getDisplayMetrics().density;
        setWillNotDraw(false);
        this.O0000o = getResources().getColor(R.color.mj_color_green_normal);
        this.O0000oOO = -6710887;
        this.O0000o0o = new Paint();
        this.O0000o0o.setColor(this.O0000o);
        this.O0000o0o.setAntiAlias(true);
        this.O0000o0o.setStyle(Paint.Style.STROKE);
        this.O0000o0o.setStrokeWidth(f);
        this.O0000oO0 = new Paint();
        this.O0000oO0.setColor(getResources().getColor(R.color.mj_color_green_normal));
        this.O0000oO0.setAntiAlias(true);
        this.O0000oO0.setStyle(Paint.Style.FILL);
        this.O0000oO0.setTextSize(18.0f * f);
        this.O0000oO = new Paint();
        this.O0000oO.setColor(this.O0000oOO);
        this.O0000oO.setAntiAlias(true);
        this.O0000oO.setStyle(Paint.Style.STROKE);
        this.O0000oO.setStrokeWidth(f * 1.0f);
        O00000oO();
    }

    private void O00000o0() {
        this.O0000OoO = 0.0d;
        this.O0000Oo = 0.0d;
        this.O0000O0o = 0;
        this.O00000oo = 0.0d;
    }

    private void O00000o() {
        int i = this.O0000OOo;
        int i2 = this.O0000O0o;
        if (i != i2) {
            this.O0000OOo = i2;
        }
    }

    private void O00000oO() {
        this.O00000o0 = this.O0000oo.getDrawable(R.drawable.count_down_timer_thumb_off);
        int intrinsicHeight = this.O00000o0.getIntrinsicHeight() / 2;
        int intrinsicWidth = this.O00000o0.getIntrinsicWidth() / 2;
        this.O00000Oo = (float) intrinsicWidth;
        this.O00000o0.setBounds(-intrinsicWidth, -intrinsicHeight, intrinsicWidth, intrinsicHeight);
    }

    private void O00000oo() {
        double d = (double) this.f9174O000000o;
        double sin = Math.sin(Math.toRadians(this.O0000Oo));
        Double.isNaN(d);
        this.O0000o0 = (int) (d * sin);
        double d2 = (double) this.f9174O000000o;
        double cos = Math.cos(Math.toRadians(this.O0000Oo));
        Double.isNaN(d2);
        this.O0000o0O = (int) (d2 * cos);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O0000Ooo = (getRight() - getLeft()) / 2;
        this.O0000o00 = (getBottom() - getTop()) / 2;
        O00000oo();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.O0000oOo == null) {
            int height = getHeight();
            int width = getWidth();
            int min = (int) (((float) ((Math.min(width, height) - getPaddingLeft()) - getPaddingRight())) - (this.O00000Oo * 2.0f));
            this.f9174O000000o = (float) (min / 2);
            float f = this.f9174O000000o;
            float f2 = ((float) (height / 2)) - f;
            float f3 = ((float) (width / 2)) - f;
            this.O0000oOo = new RectF();
            float f4 = (float) min;
            this.O0000oOo.set(f3, f2, f3 + f4, f4 + f2);
        }
        this.O0000o0o.setColor(this.O0000o);
        canvas.drawArc(this.O0000oOo, 9.0f + (((float) (this.O0000Oo % 360.0d)) - 90.0f), 342.0f, false, this.O0000o0o);
        if (this.O00000o0 != null) {
            O00000oo();
            canvas.save();
            canvas.translate((float) (this.O0000Ooo + this.O0000o0), (float) (this.O0000o00 - this.O0000o0O));
            canvas.rotate((float) this.O0000Oo, this.O00000o0.getBounds().exactCenterX(), this.O00000o0.getBounds().exactCenterY());
            this.O00000o0.draw(canvas);
            canvas.restore();
        }
        canvas.save();
        this.O0000oO.setColor(this.O0000oOO);
        float f5 = this.O0000oo.getDisplayMetrics().density;
        for (int i = 0; i < 200; i++) {
            double d = this.O00000oo;
            if (d - 1.0E-4d <= 0.0d) {
                this.O0000oO.setColor(this.O0000oOO);
            } else {
                int i2 = this.O0000O0o;
                int i3 = this.O00000o;
                if (i2 <= i3) {
                    if (((double) (((((float) i) * 1.8f) * ((float) i3)) / 360.0f)) > d) {
                        this.O0000oO.setColor(this.O0000oOO);
                    } else {
                        this.O0000oO.setColor(this.O0000o);
                    }
                }
            }
            int i4 = this.O0000Ooo;
            int i5 = this.O0000o00;
            float f6 = this.f9174O000000o;
            float f7 = this.O00000Oo;
            float f8 = 5.0f * f5;
            float f9 = (float) i4;
            canvas.drawLine((float) i4, (((float) i5) - f6) + f7 + f8, f9, (((float) i5) - f6) + f7 + f8 + (18.0f * f5), this.O0000oO);
            canvas.rotate(1.8f, (float) this.O0000Ooo, (float) this.O0000o00);
        }
        canvas.restore();
        O000000o(canvas, this.O0000O0o);
    }

    public void setThumb(Drawable drawable) {
        this.O00000o0 = drawable;
        O00000oO();
    }

    public final void O00000Oo() {
        this.O00000oO = 1440;
        this.O0000O0o = 0;
        this.O00000o = 60;
        O00000o();
        postInvalidate();
    }

    public void setCircleColor(int i) {
        this.O0000o = i;
    }

    public void setLineColor(int i) {
        this.O0000oOO = i;
    }

    public void setCurrentValue(int i) {
        if (this.O00000oO != 0 && this.O00000o != 0) {
            O00000o0();
            double d = (double) i;
            int i2 = this.O00000o;
            double d2 = (double) i2;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = (double) i2;
            Double.isNaN(d3);
            double d4 = ((d % d2) / d3) * 360.0d;
            if (i <= 0) {
                this.O0000oo0 = 1;
                O00000o0();
            } else {
                int i3 = this.O00000oO;
                if (i >= i3) {
                    this.O0000oo0 = 3;
                    this.O0000O0o = i3;
                    this.O00000oo = (double) this.O0000O0o;
                    this.O0000Oo = (double) ((i3 / i2) * 360);
                    this.O0000OoO = 360.0d;
                    O00000oo();
                } else {
                    this.O0000oo0 = 2;
                    this.O0000Oo = d4;
                    this.O0000OoO = d4;
                    this.O0000O0o = i;
                    this.O00000oo = d;
                    O00000oo();
                }
            }
            O00000o();
            postInvalidate();
        }
    }

    public int getCurrentValue() {
        return this.O0000O0o;
    }

    public void setOnSeekArcChangeListener(O000000o o000000o) {
        this.O0000ooO = o000000o;
    }
}
