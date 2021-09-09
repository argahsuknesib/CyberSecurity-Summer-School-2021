package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.indicators;

import _m_j.hho;
import _m_j.hhs;
import _m_j.hht;
import _m_j.hhw;
import _m_j.hhy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;

public class LinePagerIndicator extends View implements hhw {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10349O000000o;
    private Interpolator O00000Oo = new LinearInterpolator();
    private float O00000o;
    private Interpolator O00000o0 = new LinearInterpolator();
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private float O0000OOo;
    private List<hhy> O0000Oo;
    private Paint O0000Oo0 = new Paint(1);
    private List<Integer> O0000OoO;
    private RectF O0000Ooo = new RectF();
    private O000000o O0000o00;

    public interface O000000o {
    }

    public LinePagerIndicator(Context context) {
        super(context);
        this.O0000Oo0.setPathEffect(new CornerPathEffect((float) hht.O000000o(context, 1.0d)));
        this.O0000Oo0.setStyle(Paint.Style.FILL);
        this.O00000oO = (float) hht.O000000o(context, 2.0d);
        this.O0000O0o = (float) hht.O000000o(context, 10.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.O0000Ooo;
        float f = this.O0000OOo;
        canvas.drawRoundRect(rectF, f, f, this.O0000Oo0);
    }

    public final void O000000o(int i, float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        List<hhy> list = this.O0000Oo;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.O0000OoO;
            if (list2 != null && list2.size() > 0) {
                this.O0000Oo0.setColor(hhs.O000000o(f, this.O0000OoO.get(Math.abs(i) % this.O0000OoO.size()).intValue(), this.O0000OoO.get(Math.abs(i + 1) % this.O0000OoO.size()).intValue()));
            }
            hhy O000000o2 = hho.O000000o(this.O0000Oo, i);
            hhy O000000o3 = hho.O000000o(this.O0000Oo, i + 1);
            int i2 = this.f10349O000000o;
            if (i2 == 0) {
                f4 = ((float) O000000o2.f18955O000000o) + this.O00000oo;
                f3 = ((float) O000000o3.f18955O000000o) + this.O00000oo;
                f5 = ((float) O000000o2.O00000o0) - this.O00000oo;
                f6 = (float) O000000o3.O00000o0;
                f7 = this.O00000oo;
            } else if (i2 == 1) {
                f4 = ((float) O000000o2.O00000oO) + this.O00000oo;
                f3 = ((float) O000000o3.O00000oO) + this.O00000oo;
                f5 = ((float) O000000o2.O0000O0o) - this.O00000oo;
                f6 = (float) O000000o3.O0000O0o;
                f7 = this.O00000oo;
            } else {
                f4 = ((float) O000000o2.f18955O000000o) + ((((float) O000000o2.O000000o()) - this.O0000O0o) / 2.0f);
                f3 = ((float) O000000o3.f18955O000000o) + ((((float) O000000o3.O000000o()) - this.O0000O0o) / 2.0f);
                f5 = ((((float) O000000o2.O000000o()) + this.O0000O0o) / 2.0f) + ((float) O000000o2.f18955O000000o);
                f2 = ((((float) O000000o3.O000000o()) + this.O0000O0o) / 2.0f) + ((float) O000000o3.f18955O000000o);
                this.O0000Ooo.left = f4 + ((f3 - f4) * this.O00000Oo.getInterpolation(f));
                this.O0000Ooo.right = f5 + ((f2 - f5) * this.O00000o0.getInterpolation(f));
                this.O0000Ooo.top = (((float) getHeight()) - this.O00000oO) - this.O00000o;
                this.O0000Ooo.bottom = ((float) getHeight()) - this.O00000o;
                invalidate();
            }
            f2 = f6 - f7;
            this.O0000Ooo.left = f4 + ((f3 - f4) * this.O00000Oo.getInterpolation(f));
            this.O0000Ooo.right = f5 + ((f2 - f5) * this.O00000o0.getInterpolation(f));
            this.O0000Ooo.top = (((float) getHeight()) - this.O00000oO) - this.O00000o;
            this.O0000Ooo.bottom = ((float) getHeight()) - this.O00000o;
            invalidate();
        }
    }

    public void setOnPageSelectedListener(O000000o o000000o) {
        this.O0000o00 = o000000o;
    }

    public final void O000000o(List<hhy> list) {
        this.O0000Oo = list;
    }

    public float getYOffset() {
        return this.O00000o;
    }

    public void setYOffset(float f) {
        this.O00000o = f;
    }

    public float getXOffset() {
        return this.O00000oo;
    }

    public void setXOffset(float f) {
        this.O00000oo = f;
    }

    public float getLineHeight() {
        return this.O00000oO;
    }

    public void setLineHeight(float f) {
        this.O00000oO = f;
    }

    public float getLineWidth() {
        return this.O0000O0o;
    }

    public void setLineWidth(float f) {
        this.O0000O0o = f;
    }

    public float getRoundRadius() {
        return this.O0000OOo;
    }

    public void setRoundRadius(float f) {
        this.O0000OOo = f;
    }

    public int getMode() {
        return this.f10349O000000o;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.f10349O000000o = i;
            return;
        }
        throw new IllegalArgumentException("mode " + i + " not supported.");
    }

    public Paint getPaint() {
        return this.O0000Oo0;
    }

    public List<Integer> getColors() {
        return this.O0000OoO;
    }

    public void setColors(Integer... numArr) {
        this.O0000OoO = Arrays.asList(numArr);
        this.O0000Oo0.setColor(numArr[0].intValue());
    }

    public Interpolator getStartInterpolator() {
        return this.O00000Oo;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.O00000Oo = interpolator;
        if (this.O00000Oo == null) {
            this.O00000Oo = new LinearInterpolator();
        }
    }

    public Interpolator getEndInterpolator() {
        return this.O00000o0;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.O00000o0 = interpolator;
        if (this.O00000o0 == null) {
            this.O00000o0 = new LinearInterpolator();
        }
    }
}
