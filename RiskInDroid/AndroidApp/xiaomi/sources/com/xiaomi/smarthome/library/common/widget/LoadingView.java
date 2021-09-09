package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class LoadingView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f9207O000000o = 3;
    private int O00000Oo = 5;
    private int O00000o = 419430400;
    private int O00000o0 = 1275068416;
    private int O00000oO = 300;
    private int O00000oo;
    private RectF O0000O0o = new RectF();
    private Paint O0000OOo = new Paint();
    private int O0000Oo;
    private int O0000Oo0 = 5;

    public LoadingView(Context context) {
        super(context);
        O000000o(null);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.color_end, R.attr.color_start, R.attr.dot_count, R.attr.dot_distance, R.attr.dot_size, R.attr.time_interval});
            this.O00000o0 = obtainStyledAttributes.getColor(1, this.O00000o0);
            this.O00000o = obtainStyledAttributes.getColor(0, this.O00000o);
            this.O00000Oo = obtainStyledAttributes.getDimensionPixelSize(3, this.O00000Oo);
            this.O0000Oo0 = obtainStyledAttributes.getDimensionPixelSize(4, this.O0000Oo0);
            this.f9207O000000o = obtainStyledAttributes.getInteger(2, this.f9207O000000o);
            this.O00000oO = obtainStyledAttributes.getInteger(5, this.O00000oO);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 1073741824) {
                int i3 = this.O00000Oo;
                int i4 = this.f9207O000000o;
                setDotSize(Math.min(size2, (size - (i3 * (i4 - 1))) / i4));
                setMeasuredDimension(size + getPaddingLeft() + getPaddingRight(), size2 + getPaddingTop() + getPaddingBottom());
                return;
            }
            int i5 = this.O00000Oo;
            int i6 = this.f9207O000000o;
            setDotSize((size - (i5 * (i6 - 1))) / i6);
            setMeasuredDimension(size + getPaddingLeft() + getPaddingRight(), this.O00000oo + getPaddingTop() + getPaddingBottom());
        } else if (mode2 == 1073741824) {
            setDotSize(size2);
            int i7 = this.O00000oo;
            int i8 = this.f9207O000000o;
            setMeasuredDimension((i7 * i8) + (this.O00000Oo * (i8 - 1)) + getPaddingLeft() + getPaddingRight(), size2 + getPaddingTop() + getPaddingBottom());
        } else {
            setDotSize(((int) getContext().getResources().getDisplayMetrics().density) * 5);
            int i9 = this.O00000oo;
            int i10 = this.f9207O000000o;
            setMeasuredDimension((i9 * i10) + (this.O00000Oo * (i10 - 1)) + getPaddingLeft() + getPaddingRight(), this.O00000oo + getPaddingTop() + getPaddingBottom());
        }
    }

    private void setDotSize(int i) {
        int i2 = this.O0000Oo0;
        if (i2 == 0) {
            this.O00000oo = i;
        } else {
            this.O00000oo = i2;
        }
    }

    public void setDotCount(int i) {
        this.f9207O000000o = i;
    }

    public void setDotDistance(int i) {
        this.O00000Oo = i;
    }

    public void setTimeInterval(int i) {
        this.O00000oO = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f9207O000000o != 0) {
            int alpha = Color.alpha(this.O00000o0);
            int red = Color.red(this.O00000o0);
            int green = Color.green(this.O00000o0);
            int blue = Color.blue(this.O00000o0);
            int alpha2 = Color.alpha(this.O00000o);
            int red2 = Color.red(this.O00000o);
            int green2 = Color.green(this.O00000o);
            int blue2 = Color.blue(this.O00000o);
            int i = this.f9207O000000o;
            float f = ((float) (alpha2 - alpha)) / ((float) i);
            float f2 = ((float) (red2 - red)) / ((float) i);
            float f3 = ((float) (green2 - green)) / ((float) i);
            float f4 = ((float) (blue2 - blue)) / ((float) i);
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int i2 = this.f9207O000000o;
            int paddingLeft = (((width - (this.O00000oo * i2)) - (this.O00000Oo * (i2 - 1))) / 2) + getPaddingLeft();
            int height = ((((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.O00000oo) / 2) + getPaddingTop();
            int i3 = this.O0000Oo;
            this.O0000Oo = i3 + 1;
            int i4 = 0;
            while (true) {
                int i5 = this.f9207O000000o;
                if (i4 < i5) {
                    RectF rectF = this.O0000O0o;
                    rectF.top = (float) height;
                    int i6 = height;
                    rectF.left = (float) ((((i3 + i4) % i5) * (this.O00000oo + this.O00000Oo)) + paddingLeft);
                    rectF.bottom = rectF.top + ((float) this.O00000oo);
                    RectF rectF2 = this.O0000O0o;
                    rectF2.right = rectF2.left + ((float) this.O00000oo);
                    float f5 = (float) i4;
                    this.O0000OOo.setColor(Color.argb(((int) (f * f5)) + alpha, ((int) (f2 * f5)) + red, ((int) (f3 * f5)) + green, ((int) (f5 * f4)) + blue));
                    canvas.drawOval(this.O0000O0o, this.O0000OOo);
                    i4++;
                    height = i6;
                } else {
                    postInvalidateDelayed((long) this.O00000oO);
                    return;
                }
            }
        }
    }
}
