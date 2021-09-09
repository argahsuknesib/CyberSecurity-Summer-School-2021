package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class CustomCircleProgressBar extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f9161O000000o = new O000000o();
    private Drawable O00000Oo = null;
    private int O00000o = 0;
    private int O00000o0 = 100;

    public CustomCircleProgressBar(Context context) {
        super(context);
    }

    public CustomCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inside_indent, R.attr.max, R.attr.mj_paint_color, R.attr.paint_width});
        this.O00000o0 = obtainStyledAttributes.getInteger(1, 100);
        O000000o o000000o = this.f9161O000000o;
        int i = obtainStyledAttributes.getInt(3, 10);
        o000000o.O00000o0 = i;
        float f = (float) i;
        o000000o.O00000oo.setStrokeWidth(f);
        o000000o.O0000O0o.setStrokeWidth(f);
        O000000o o000000o2 = this.f9161O000000o;
        int color = obtainStyledAttributes.getColor(2, -1);
        o000000o2.O00000o = color;
        o000000o2.O00000oo.setColor(color);
        this.f9161O000000o.O00000Oo = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.O00000Oo = getBackground();
        Drawable drawable = this.O00000Oo;
        if (drawable != null) {
            size = drawable.getMinimumWidth();
            size2 = this.O00000Oo.getMinimumHeight();
        }
        setMeasuredDimension(resolveSize(size, i), resolveSize(size2, i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        O000000o o000000o = this.f9161O000000o;
        if (o000000o.O00000Oo != 0) {
            o000000o.f9162O000000o.set((float) ((o000000o.O00000o0 / 2) + o000000o.O00000Oo), (float) ((o000000o.O00000o0 / 2) + o000000o.O00000Oo), (float) ((i - (o000000o.O00000o0 / 2)) - o000000o.O00000Oo), (float) ((i2 - (o000000o.O00000o0 / 2)) - o000000o.O00000Oo));
            return;
        }
        int paddingLeft = CustomCircleProgressBar.this.getPaddingLeft();
        int paddingRight = CustomCircleProgressBar.this.getPaddingRight();
        o000000o.f9162O000000o.set((float) (paddingLeft + (o000000o.O00000o0 / 2)), (float) (CustomCircleProgressBar.this.getPaddingTop() + (o000000o.O00000o0 / 2)), (float) ((i - paddingRight) - (o000000o.O00000o0 / 2)), (float) ((i2 - CustomCircleProgressBar.this.getPaddingBottom()) - (o000000o.O00000o0 / 2)));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000Oo == null) {
            canvas.drawArc(this.f9161O000000o.f9162O000000o, 0.0f, 360.0f, true, this.f9161O000000o.O0000O0o);
        }
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f9161O000000o.f9162O000000o, (float) this.f9161O000000o.O00000oO, (((float) this.O00000o) / ((float) this.O00000o0)) * 360.0f, false, this.f9161O000000o.O00000oo);
    }

    public synchronized void setMax(int i) {
        this.O00000o0 = i;
        if (this.O00000o0 < 0) {
            this.O00000o0 = 0;
        }
        if (this.O00000o0 < this.O00000o) {
            this.O00000o0 = this.O00000o;
        }
        invalidate();
    }

    public synchronized int getMax() {
        return this.O00000o0;
    }

    public synchronized void setProgress(int i) {
        this.O00000o = i;
        if (this.O00000o < 0) {
            this.O00000o = 0;
        }
        if (this.O00000o > this.O00000o0) {
            this.O00000o = this.O00000o0;
        }
        invalidate();
    }

    public synchronized int getProgress() {
        return this.O00000o;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public RectF f9162O000000o = new RectF();
        public int O00000Oo = 0;
        public int O00000o = -1;
        public int O00000o0 = 0;
        public int O00000oO = -90;
        public Paint O00000oo = new Paint();
        public Paint O0000O0o;

        public O000000o() {
            this.O00000oo.setAntiAlias(true);
            this.O00000oo.setStyle(Paint.Style.STROKE);
            this.O00000oo.setStrokeWidth((float) this.O00000o0);
            this.O00000oo.setColor(this.O00000o);
            this.O0000O0o = new Paint();
            this.O0000O0o.setAntiAlias(true);
            this.O0000O0o.setStyle(Paint.Style.STROKE);
            this.O0000O0o.setStrokeWidth((float) this.O00000o0);
            this.O0000O0o.setColor(-7829368);
        }
    }
}
