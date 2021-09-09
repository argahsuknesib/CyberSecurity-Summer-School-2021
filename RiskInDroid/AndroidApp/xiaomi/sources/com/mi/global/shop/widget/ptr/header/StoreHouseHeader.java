package com.mi.global.shop.widget.ptr.header;

import _m_j.ccf;
import _m_j.ccj;
import _m_j.cck;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import com.mi.global.shop.widget.ptr.PtrFrameLayout;
import java.util.ArrayList;

public class StoreHouseHeader extends View implements ccf {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<ccj> f5038O000000o = new ArrayList<>();
    public float O00000Oo = 1.0f;
    public int O00000o = 1000;
    public float O00000o0 = 0.4f;
    public int O00000oO = 1000;
    public int O00000oo = 400;
    private int O0000O0o = cck.O000000o(1.0f);
    private float O0000OOo = 1.0f;
    private float O0000Oo = 0.7f;
    private int O0000Oo0 = cck.O000000o(40.0f);
    private int O0000OoO = (cck.f13630O000000o / 2);
    private float O0000Ooo = 0.0f;
    private float O0000o = 0.4f;
    private int O0000o0 = 0;
    private int O0000o00 = 0;
    private int O0000o0O = 0;
    private int O0000o0o = 0;
    private boolean O0000oO = false;
    private Transformation O0000oO0 = new Transformation();
    private O000000o O0000oOO = new O000000o(this, (byte) 0);
    private int O0000oOo = -1;

    public final void O00000Oo(PtrFrameLayout ptrFrameLayout) {
    }

    public StoreHouseHeader(Context context) {
        super(context);
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void setProgress(float f) {
        this.O0000Ooo = f;
    }

    public int getLoadingAniDuration() {
        return this.O00000o;
    }

    public void setLoadingAniDuration(int i) {
        this.O00000o = i;
        this.O00000oO = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getTopOffset() + this.O0000o0 + getBottomOffset(), 1073741824));
        this.O0000o0O = (getMeasuredWidth() - this.O0000o00) / 2;
        this.O0000o0o = getTopOffset();
        this.O0000Oo0 = getTopOffset();
    }

    private int getTopOffset() {
        return getPaddingTop() + cck.O000000o(10.0f);
    }

    private int getBottomOffset() {
        return getPaddingBottom() + cck.O000000o(10.0f);
    }

    public float getScale() {
        return this.O0000OOo;
    }

    public void setScale(float f) {
        this.O0000OOo = f;
    }

    private void O000000o() {
        this.O0000oO = false;
        O000000o o000000o = this.O0000oOO;
        o000000o.O00000oO = false;
        StoreHouseHeader.this.removeCallbacks(o000000o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.O0000Ooo;
        int save = canvas.save();
        int size = this.f5038O000000o.size();
        for (int i = 0; i < size; i++) {
            canvas.save();
            ccj ccj = this.f5038O000000o.get(i);
            float f2 = ((float) this.O0000o0O) + ccj.f13629O000000o.x;
            float f3 = ((float) this.O0000o0o) + ccj.f13629O000000o.y;
            if (this.O0000oO) {
                ccj.getTransformation(getDrawingTime(), this.O0000oO0);
                canvas.translate(f2, f3);
            } else {
                float f4 = 0.0f;
                if (f == 0.0f) {
                    ccj.O000000o(this.O0000OoO);
                } else {
                    float f5 = this.O0000Oo;
                    float f6 = ((1.0f - f5) * ((float) i)) / ((float) size);
                    float f7 = (1.0f - f5) - f6;
                    if (f == 1.0f || f >= 1.0f - f7) {
                        canvas.translate(f2, f3);
                        ccj.O000000o(this.O0000o);
                    } else {
                        if (f > f6) {
                            f4 = Math.min(1.0f, (f - f6) / f5);
                        }
                        float f8 = 1.0f - f4;
                        float f9 = f2 + (ccj.O00000Oo * f8);
                        float f10 = f3 + (((float) (-this.O0000Oo0)) * f8);
                        Matrix matrix = new Matrix();
                        matrix.postRotate(360.0f * f4);
                        matrix.postScale(f4, f4);
                        matrix.postTranslate(f9, f10);
                        ccj.O000000o(this.O0000o * f4);
                        canvas.concat(matrix);
                    }
                }
            }
            canvas.drawLine(ccj.O00000o.x, ccj.O00000o.y, ccj.O00000oO.x, ccj.O00000oO.y, ccj.O00000o0);
            canvas.restore();
        }
        if (this.O0000oO) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    public final void O000000o(PtrFrameLayout ptrFrameLayout) {
        O000000o();
        for (int i = 0; i < this.f5038O000000o.size(); i++) {
            this.f5038O000000o.get(i).O000000o(this.O0000OoO);
        }
    }

    public final void O00000o(PtrFrameLayout ptrFrameLayout) {
        O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public final void O000000o(PtrFrameLayout ptrFrameLayout, boolean z, byte b, int i, int i2, float f, float f2) {
        setProgress(Math.min(1.0f, f2));
        invalidate();
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        int f5039O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        boolean O00000oO;

        private O000000o() {
            this.f5039O000000o = 0;
            this.O00000Oo = 0;
            this.O00000o0 = 0;
            this.O00000o = 0;
            this.O00000oO = true;
        }

        /* synthetic */ O000000o(StoreHouseHeader storeHouseHeader, byte b) {
            this();
        }

        public final void run() {
            int i = this.f5039O000000o % this.O00000Oo;
            for (int i2 = 0; i2 < this.O00000o0; i2++) {
                int i3 = (this.O00000Oo * i2) + i;
                if (i3 <= this.f5039O000000o) {
                    ccj ccj = StoreHouseHeader.this.f5038O000000o.get(i3 % StoreHouseHeader.this.f5038O000000o.size());
                    ccj.setFillAfter(false);
                    ccj.setFillEnabled(true);
                    ccj.setFillBefore(false);
                    ccj.setDuration((long) StoreHouseHeader.this.O00000oo);
                    ccj.O000000o(StoreHouseHeader.this.O00000Oo, StoreHouseHeader.this.O00000o0);
                }
            }
            this.f5039O000000o++;
            if (this.O00000oO) {
                StoreHouseHeader.this.postDelayed(this, (long) this.O00000o);
            }
        }
    }

    public final void O00000o0(PtrFrameLayout ptrFrameLayout) {
        this.O0000oO = true;
        O000000o o000000o = this.O0000oOO;
        o000000o.O00000oO = true;
        o000000o.f5039O000000o = 0;
        o000000o.O00000o = StoreHouseHeader.this.O00000o / StoreHouseHeader.this.f5038O000000o.size();
        o000000o.O00000Oo = StoreHouseHeader.this.O00000oO / o000000o.O00000o;
        o000000o.O00000o0 = (StoreHouseHeader.this.f5038O000000o.size() / o000000o.O00000Oo) + 1;
        o000000o.run();
        invalidate();
    }
}
