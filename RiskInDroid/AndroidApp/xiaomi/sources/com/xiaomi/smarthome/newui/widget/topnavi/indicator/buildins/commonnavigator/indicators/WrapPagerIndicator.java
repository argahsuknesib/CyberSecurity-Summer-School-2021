package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.indicators;

import _m_j.hho;
import _m_j.hht;
import _m_j.hhw;
import _m_j.hhy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;

public class WrapPagerIndicator extends View implements hhw {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10352O000000o;
    private int O00000Oo;
    private float O00000o;
    private int O00000o0;
    private Interpolator O00000oO = new LinearInterpolator();
    private Interpolator O00000oo = new LinearInterpolator();
    private List<hhy> O0000O0o;
    private Paint O0000OOo = new Paint(1);
    private boolean O0000Oo;
    private RectF O0000Oo0 = new RectF();

    public WrapPagerIndicator(Context context) {
        super(context);
        this.O0000OOo.setStyle(Paint.Style.FILL);
        this.f10352O000000o = hht.O000000o(context, 6.0d);
        this.O00000Oo = hht.O000000o(context, 10.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.O0000OOo.setColor(this.O00000o0);
        RectF rectF = this.O0000Oo0;
        float f = this.O00000o;
        canvas.drawRoundRect(rectF, f, f, this.O0000OOo);
    }

    public final void O000000o(int i, float f) {
        List<hhy> list = this.O0000O0o;
        if (list != null && !list.isEmpty()) {
            hhy O000000o2 = hho.O000000o(this.O0000O0o, i);
            hhy O000000o3 = hho.O000000o(this.O0000O0o, i + 1);
            this.O0000Oo0.left = ((float) (O000000o2.O00000oO - this.O00000Oo)) + (((float) (O000000o3.O00000oO - O000000o2.O00000oO)) * this.O00000oo.getInterpolation(f));
            this.O0000Oo0.top = (float) (O000000o2.O00000oo - this.f10352O000000o);
            this.O0000Oo0.right = ((float) (O000000o2.O0000O0o + this.O00000Oo)) + (((float) (O000000o3.O0000O0o - O000000o2.O0000O0o)) * this.O00000oO.getInterpolation(f));
            this.O0000Oo0.bottom = (float) (O000000o2.O0000OOo + this.f10352O000000o);
            if (!this.O0000Oo) {
                this.O00000o = this.O0000Oo0.height() / 2.0f;
            }
            invalidate();
        }
    }

    public final void O000000o(List<hhy> list) {
        this.O0000O0o = list;
    }

    public Paint getPaint() {
        return this.O0000OOo;
    }

    public int getVerticalPadding() {
        return this.f10352O000000o;
    }

    public void setVerticalPadding(int i) {
        this.f10352O000000o = i;
    }

    public int getHorizontalPadding() {
        return this.O00000Oo;
    }

    public void setHorizontalPadding(int i) {
        this.O00000Oo = i;
    }

    public int getFillColor() {
        return this.O00000o0;
    }

    public void setFillColor(int i) {
        this.O00000o0 = i;
    }

    public float getRoundRadius() {
        return this.O00000o;
    }

    public void setRoundRadius(float f) {
        this.O00000o = f;
        this.O0000Oo = true;
    }

    public Interpolator getStartInterpolator() {
        return this.O00000oO;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.O00000oO = interpolator;
        if (this.O00000oO == null) {
            this.O00000oO = new LinearInterpolator();
        }
    }

    public Interpolator getEndInterpolator() {
        return this.O00000oo;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.O00000oo = interpolator;
        if (this.O00000oo == null) {
            this.O00000oo = new LinearInterpolator();
        }
    }
}
