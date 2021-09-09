package com.tmall.wireless.vaf.virtualview.view.grid;

import _m_j.dox;
import _m_j.dpb;
import _m_j.dpc;
import _m_j.dpf;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class GridImp extends GridView implements dpb, dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dpf f5893O000000o;
    protected Paint O00000Oo;
    protected int O00000o0 = 0;

    public void attachViews() {
    }

    public View getHolderView() {
        return this;
    }

    public int getType() {
        return -1;
    }

    public GridImp(Context context) {
        super(context);
    }

    public void setBackgroundColor(int i) {
        this.O00000o0 = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000o0 != 0) {
            int O0000OoO = this.f5893O000000o.O0000OoO();
            if (this.O00000Oo == null) {
                this.O00000Oo = new Paint();
                this.O00000Oo.setColor(this.O00000o0);
            }
            float f = (float) O0000OoO;
            canvas.drawRect(f, f, (float) (this.f5893O000000o.getComMeasuredWidth() - O0000OoO), (float) (this.f5893O000000o.getComMeasuredHeight() - O0000OoO), this.O00000Oo);
        }
    }

    public void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }

    public void onComMeasure(int i, int i2) {
        onMeasure(i, i2);
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayout(z, i, i2, i3, i4);
    }

    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    public void setVirtualView(dpf dpf) {
        if (dpf != null) {
            this.f5893O000000o = dpf;
            this.f5893O000000o.O00000Oo((View) this);
            if (this.f5893O000000o.O000O0Oo()) {
                setWillNotDraw(false);
            }
            new dox(this);
        }
    }

    public dpf getVirtualView() {
        return this.f5893O000000o;
    }
}
