package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.indicators;

import _m_j.hho;
import _m_j.hhs;
import _m_j.hht;
import _m_j.hhw;
import _m_j.hhy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;

public class BezierPagerIndicator extends View implements hhw {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<hhy> f10348O000000o;
    private float O00000Oo;
    private float O00000o;
    private float O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private float O0000OOo;
    private Path O0000Oo = new Path();
    private Paint O0000Oo0 = new Paint(1);
    private List<Integer> O0000OoO;
    private Interpolator O0000Ooo = new AccelerateInterpolator();
    private Interpolator O0000o00 = new DecelerateInterpolator();

    public BezierPagerIndicator(Context context) {
        super(context);
        this.O0000Oo0.setStyle(Paint.Style.FILL);
        this.O0000O0o = (float) hht.O000000o(context, 3.5d);
        this.O0000OOo = (float) hht.O000000o(context, 2.0d);
        this.O00000oo = (float) hht.O000000o(context, 1.5d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.O00000o0, (((float) getHeight()) - this.O00000oo) - this.O0000O0o, this.O00000Oo, this.O0000Oo0);
        canvas.drawCircle(this.O00000oO, (((float) getHeight()) - this.O00000oo) - this.O0000O0o, this.O00000o, this.O0000Oo0);
        this.O0000Oo.reset();
        float height = (((float) getHeight()) - this.O00000oo) - this.O0000O0o;
        this.O0000Oo.moveTo(this.O00000oO, height);
        this.O0000Oo.lineTo(this.O00000oO, height - this.O00000o);
        Path path = this.O0000Oo;
        float f = this.O00000oO;
        float f2 = this.O00000o0;
        path.quadTo(f + ((f2 - f) / 2.0f), height, f2, height - this.O00000Oo);
        this.O0000Oo.lineTo(this.O00000o0, this.O00000Oo + height);
        Path path2 = this.O0000Oo;
        float f3 = this.O00000oO;
        path2.quadTo(((this.O00000o0 - f3) / 2.0f) + f3, height, f3, this.O00000o + height);
        this.O0000Oo.close();
        canvas.drawPath(this.O0000Oo, this.O0000Oo0);
    }

    public final void O000000o(int i, float f) {
        List<hhy> list = this.f10348O000000o;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.O0000OoO;
            if (list2 != null && list2.size() > 0) {
                this.O0000Oo0.setColor(hhs.O000000o(f, this.O0000OoO.get(Math.abs(i) % this.O0000OoO.size()).intValue(), this.O0000OoO.get(Math.abs(i + 1) % this.O0000OoO.size()).intValue()));
            }
            hhy O000000o2 = hho.O000000o(this.f10348O000000o, i);
            hhy O000000o3 = hho.O000000o(this.f10348O000000o, i + 1);
            float f2 = (float) (O000000o2.f18955O000000o + ((O000000o2.O00000o0 - O000000o2.f18955O000000o) / 2));
            float f3 = ((float) (O000000o3.f18955O000000o + ((O000000o3.O00000o0 - O000000o3.f18955O000000o) / 2))) - f2;
            this.O00000o0 = (this.O0000Ooo.getInterpolation(f) * f3) + f2;
            this.O00000oO = f2 + (f3 * this.O0000o00.getInterpolation(f));
            float f4 = this.O0000O0o;
            this.O00000Oo = f4 + ((this.O0000OOo - f4) * this.O0000o00.getInterpolation(f));
            float f5 = this.O0000OOo;
            this.O00000o = f5 + ((this.O0000O0o - f5) * this.O0000Ooo.getInterpolation(f));
            invalidate();
        }
    }

    public final void O000000o(List<hhy> list) {
        this.f10348O000000o = list;
    }

    public float getMaxCircleRadius() {
        return this.O0000O0o;
    }

    public void setMaxCircleRadius(float f) {
        this.O0000O0o = f;
    }

    public float getMinCircleRadius() {
        return this.O0000OOo;
    }

    public void setMinCircleRadius(float f) {
        this.O0000OOo = f;
    }

    public float getYOffset() {
        return this.O00000oo;
    }

    public void setYOffset(float f) {
        this.O00000oo = f;
    }

    public void setColors(Integer... numArr) {
        this.O0000OoO = Arrays.asList(numArr);
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.O0000Ooo = interpolator;
        if (this.O0000Ooo == null) {
            this.O0000Ooo = new AccelerateInterpolator();
        }
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.O0000o00 = interpolator;
        if (this.O0000o00 == null) {
            this.O0000o00 = new DecelerateInterpolator();
        }
    }
}
