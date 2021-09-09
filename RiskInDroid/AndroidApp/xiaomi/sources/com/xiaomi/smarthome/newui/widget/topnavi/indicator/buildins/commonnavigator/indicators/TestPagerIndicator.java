package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.indicators;

import _m_j.hho;
import _m_j.hhw;
import _m_j.hhy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.List;

public class TestPagerIndicator extends View implements hhw {

    /* renamed from: O000000o  reason: collision with root package name */
    private Paint f10350O000000o = new Paint(1);
    private int O00000Oo;
    private RectF O00000o = new RectF();
    private int O00000o0;
    private RectF O00000oO = new RectF();
    private List<hhy> O00000oo;

    public TestPagerIndicator(Context context) {
        super(context);
        this.f10350O000000o.setStyle(Paint.Style.STROKE);
        this.O00000Oo = -65536;
        this.O00000o0 = -16711936;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f10350O000000o.setColor(this.O00000Oo);
        canvas.drawRect(this.O00000o, this.f10350O000000o);
        this.f10350O000000o.setColor(this.O00000o0);
        canvas.drawRect(this.O00000oO, this.f10350O000000o);
    }

    public final void O000000o(int i, float f) {
        List<hhy> list = this.O00000oo;
        if (list != null && !list.isEmpty()) {
            hhy O000000o2 = hho.O000000o(this.O00000oo, i);
            hhy O000000o3 = hho.O000000o(this.O00000oo, i + 1);
            this.O00000o.left = ((float) O000000o2.f18955O000000o) + (((float) (O000000o3.f18955O000000o - O000000o2.f18955O000000o)) * f);
            this.O00000o.top = ((float) O000000o2.O00000Oo) + (((float) (O000000o3.O00000Oo - O000000o2.O00000Oo)) * f);
            this.O00000o.right = ((float) O000000o2.O00000o0) + (((float) (O000000o3.O00000o0 - O000000o2.O00000o0)) * f);
            this.O00000o.bottom = ((float) O000000o2.O00000o) + (((float) (O000000o3.O00000o - O000000o2.O00000o)) * f);
            this.O00000oO.left = ((float) O000000o2.O00000oO) + (((float) (O000000o3.O00000oO - O000000o2.O00000oO)) * f);
            this.O00000oO.top = ((float) O000000o2.O00000oo) + (((float) (O000000o3.O00000oo - O000000o2.O00000oo)) * f);
            this.O00000oO.right = ((float) O000000o2.O0000O0o) + (((float) (O000000o3.O0000O0o - O000000o2.O0000O0o)) * f);
            this.O00000oO.bottom = ((float) O000000o2.O0000OOo) + (((float) (O000000o3.O0000OOo - O000000o2.O0000OOo)) * f);
            invalidate();
        }
    }

    public final void O000000o(List<hhy> list) {
        this.O00000oo = list;
    }

    public int getOutRectColor() {
        return this.O00000Oo;
    }

    public void setOutRectColor(int i) {
        this.O00000Oo = i;
    }

    public int getInnerRectColor() {
        return this.O00000o0;
    }

    public void setInnerRectColor(int i) {
        this.O00000o0 = i;
    }
}
