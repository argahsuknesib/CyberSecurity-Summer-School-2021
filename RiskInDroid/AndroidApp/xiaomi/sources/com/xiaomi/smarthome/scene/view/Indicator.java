package com.xiaomi.smarthome.scene.view;

import _m_j.gsy;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class Indicator extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private Paint f11314O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO = 9;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;

    public Indicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundColor(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.indicator_color}, 0, 0);
        this.O00000oo = obtainStyledAttributes.getColor(0, 255);
        obtainStyledAttributes.recycle();
        this.f11314O000000o = new Paint();
        this.f11314O000000o.setColor(this.O00000oo);
        this.f11314O000000o.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.O00000Oo = getMeasuredHeight();
        this.O0000O0o = getPaddingTop();
        this.O0000OOo = getPaddingBottom();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight() + this.O00000oO + this.O0000OOo + this.O0000O0o;
        gsy.O00000Oo("Indicator", "height" + measuredHeight + "mHeight" + this.O00000oO + " mTop" + this.O00000Oo + "paddingTop " + this.O0000O0o + "  paddingBottom" + this.O0000OOo + "   width" + measuredWidth);
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.O00000o0;
        int i2 = this.O00000Oo;
        int i3 = this.O0000O0o;
        canvas.drawRect(new Rect(i, i2 + i3, this.O00000o + i, i2 + i3 + this.O00000oO), this.f11314O000000o);
        super.onDraw(canvas);
    }
}
