package com.xiaomi.smarthome.newui.widget;

import _m_j.hhf;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

public class RoundedGradientSeekBar extends BaseSeekBar {

    /* renamed from: O000000o  reason: collision with root package name */
    private hhf f10325O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo0;

    public RoundedGradientSeekBar(Context context) {
        this(context, null);
    }

    public RoundedGradientSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedGradientSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setProgressDrawable(null);
        this.f10325O000000o = new hhf();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.color_from, R.attr.color_to, R.attr.thumb_max_cirlce_color, R.attr.thumb_max_radius, R.attr.thumb_min_cirlce_color, R.attr.thumb_min_radius}, i, 0);
        this.O00000Oo = obtainStyledAttributes.getResourceId(0, R.color.mj_color_gradient_yellow_start);
        this.O00000o0 = obtainStyledAttributes.getResourceId(1, R.color.mj_color_gray_lightest);
        this.O00000o = R.color.mj_color_gray_lighter;
        this.O00000oO = R.color.mj_color_gray_lightest;
        this.f10325O000000o.setColors(new int[]{getResources().getColor(this.O00000Oo), getResources().getColor(this.O00000o0)});
        this.O00000oo = obtainStyledAttributes.getResourceId(2, this.O00000o0);
        this.O0000O0o = obtainStyledAttributes.getResourceId(4, this.O00000Oo);
        this.O0000OOo = this.O00000o0;
        this.O0000Oo0 = this.O00000o;
        this.f10325O000000o.O000000o(getResources().getColor(this.O00000oo), getResources().getColor(this.O0000O0o));
        hhf hhf = this.f10325O000000o;
        hhf.O00000oO = (int) obtainStyledAttributes.getDimension(3, 0.0f);
        hhf.O00000o = (int) obtainStyledAttributes.getDimension(3, 10.0f);
        int max = getMax();
        hhf.f18938O000000o = 0;
        hhf.O00000Oo = max;
        obtainStyledAttributes.recycle();
        setLayerType(1, null);
    }

    public void setColorFrom(int i) {
        this.O00000Oo = i;
        this.f10325O000000o.setColors(new int[]{getResources().getColor(this.O00000Oo), getResources().getColor(this.O00000o0)});
    }

    public void setColorTo(int i) {
        this.O00000o0 = i;
        this.f10325O000000o.setColors(new int[]{getResources().getColor(this.O00000Oo), getResources().getColor(this.O00000o0)});
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.save();
        this.f10325O000000o.O00000o0 = getProgress();
        this.f10325O000000o.draw(canvas);
        canvas.restore();
    }

    public synchronized int getProgress() {
        int progress = super.getProgress();
        int height = getHeight() / 2;
        int width = getWidth();
        if (width == 0) {
            return 0;
        }
        return progress - ((int) (((float) (height / width)) / ((float) getMax())));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f10325O000000o.setBounds(new Rect(0, 0, i, i2));
    }

    public final void O000000o(boolean z) {
        if (z) {
            this.f10325O000000o.setColors(new int[]{getResources().getColor(this.O00000Oo), getResources().getColor(this.O00000o0)});
            this.f10325O000000o.O000000o(getResources().getColor(this.O00000oo), getResources().getColor(this.O0000O0o));
        } else {
            this.f10325O000000o.setColors(new int[]{getResources().getColor(this.O00000o), getResources().getColor(this.O00000oO)});
            this.f10325O000000o.O000000o(getResources().getColor(this.O0000OOo), getResources().getColor(this.O0000Oo0));
        }
        invalidate();
    }
}
