package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.indicators;

import _m_j.hho;
import _m_j.hht;
import _m_j.hhw;
import _m_j.hhy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;

public class TriangularPagerIndicator extends View implements hhw {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<hhy> f10351O000000o;
    private Paint O00000Oo = new Paint(1);
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private boolean O0000O0o;
    private float O0000OOo;
    private Interpolator O0000Oo = new LinearInterpolator();
    private Path O0000Oo0 = new Path();
    private float O0000OoO;

    public TriangularPagerIndicator(Context context) {
        super(context);
        this.O00000Oo.setStyle(Paint.Style.FILL);
        this.O00000o0 = hht.O000000o(context, 3.0d);
        this.O00000oo = hht.O000000o(context, 14.0d);
        this.O00000oO = hht.O000000o(context, 8.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.O00000Oo.setColor(this.O00000o);
        if (this.O0000O0o) {
            canvas.drawRect(0.0f, (((float) getHeight()) - this.O0000OOo) - ((float) this.O00000oO), (float) getWidth(), ((((float) getHeight()) - this.O0000OOo) - ((float) this.O00000oO)) + ((float) this.O00000o0), this.O00000Oo);
        } else {
            canvas.drawRect(0.0f, ((float) (getHeight() - this.O00000o0)) - this.O0000OOo, (float) getWidth(), ((float) getHeight()) - this.O0000OOo, this.O00000Oo);
        }
        this.O0000Oo0.reset();
        if (this.O0000O0o) {
            this.O0000Oo0.moveTo(this.O0000OoO - ((float) (this.O00000oo / 2)), (((float) getHeight()) - this.O0000OOo) - ((float) this.O00000oO));
            this.O0000Oo0.lineTo(this.O0000OoO, ((float) getHeight()) - this.O0000OOo);
            this.O0000Oo0.lineTo(this.O0000OoO + ((float) (this.O00000oo / 2)), (((float) getHeight()) - this.O0000OOo) - ((float) this.O00000oO));
        } else {
            this.O0000Oo0.moveTo(this.O0000OoO - ((float) (this.O00000oo / 2)), ((float) getHeight()) - this.O0000OOo);
            this.O0000Oo0.lineTo(this.O0000OoO, ((float) (getHeight() - this.O00000oO)) - this.O0000OOo);
            this.O0000Oo0.lineTo(this.O0000OoO + ((float) (this.O00000oo / 2)), ((float) getHeight()) - this.O0000OOo);
        }
        this.O0000Oo0.close();
        canvas.drawPath(this.O0000Oo0, this.O00000Oo);
    }

    public final void O000000o(int i, float f) {
        List<hhy> list = this.f10351O000000o;
        if (list != null && !list.isEmpty()) {
            hhy O000000o2 = hho.O000000o(this.f10351O000000o, i);
            hhy O000000o3 = hho.O000000o(this.f10351O000000o, i + 1);
            float f2 = (float) (O000000o2.f18955O000000o + ((O000000o2.O00000o0 - O000000o2.f18955O000000o) / 2));
            this.O0000OoO = f2 + ((((float) (O000000o3.f18955O000000o + ((O000000o3.O00000o0 - O000000o3.f18955O000000o) / 2))) - f2) * this.O0000Oo.getInterpolation(f));
            invalidate();
        }
    }

    public final void O000000o(List<hhy> list) {
        this.f10351O000000o = list;
    }

    public int getLineHeight() {
        return this.O00000o0;
    }

    public void setLineHeight(int i) {
        this.O00000o0 = i;
    }

    public int getLineColor() {
        return this.O00000o;
    }

    public void setLineColor(int i) {
        this.O00000o = i;
    }

    public int getTriangleHeight() {
        return this.O00000oO;
    }

    public void setTriangleHeight(int i) {
        this.O00000oO = i;
    }

    public int getTriangleWidth() {
        return this.O00000oo;
    }

    public void setTriangleWidth(int i) {
        this.O00000oo = i;
    }

    public Interpolator getStartInterpolator() {
        return this.O0000Oo;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.O0000Oo = interpolator;
        if (this.O0000Oo == null) {
            this.O0000Oo = new LinearInterpolator();
        }
    }

    public void setReverse(boolean z) {
        this.O0000O0o = z;
    }

    public float getYOffset() {
        return this.O0000OOo;
    }

    public void setYOffset(float f) {
        this.O0000OOo = f;
    }
}
