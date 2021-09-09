package com.scwang.smartrefresh.header;

import _m_j.czk;
import _m_j.czl;
import _m_j.czu;
import _m_j.czw;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class StoreHouseHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<czk> f5531O000000o;
    protected int O00000Oo;
    protected int O00000o;
    protected float O00000o0;
    protected int O00000oO;
    protected float O00000oo;
    protected int O0000O0o;
    protected int O0000OOo;
    protected int O0000Oo;
    protected int O0000Oo0;
    protected int O0000OoO;
    protected int O0000Ooo;
    protected Matrix O0000o;
    protected int O0000o0;
    protected int O0000o00;
    protected boolean O0000o0O;
    protected boolean O0000o0o;
    protected O000000o O0000oO;
    protected czw O0000oO0;
    protected Transformation O0000oOO;

    public StoreHouseHeader(Context context) {
        this(context, null);
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5531O000000o = new ArrayList();
        this.O00000Oo = -1;
        this.O00000o0 = 1.0f;
        this.O00000o = -1;
        this.O00000oO = -1;
        this.O00000oo = 0.0f;
        this.O0000O0o = 0;
        this.O0000OOo = 0;
        this.O0000Oo0 = 0;
        this.O0000Oo = 0;
        this.O0000OoO = 1000;
        this.O0000Ooo = 1000;
        this.O0000o00 = -1;
        this.O0000o0 = 0;
        this.O0000o0O = false;
        this.O0000o0o = false;
        this.O0000o = new Matrix();
        this.O0000oO = new O000000o(this, (byte) 0);
        this.O0000oOO = new Transformation();
        dao dao = new dao();
        this.O00000Oo = dao.O00000Oo(1.0f);
        this.O00000o = dao.O00000Oo(40.0f);
        this.O00000oO = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        this.O0000o0 = -13421773;
        O000000o(-3355444);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.shhDropHeight, R.attr.shhEnableFadeAnimation, R.attr.shhLineWidth, R.attr.shhText});
        this.O00000Oo = obtainStyledAttributes.getDimensionPixelOffset(2, this.O00000Oo);
        this.O00000o = obtainStyledAttributes.getDimensionPixelOffset(0, this.O00000o);
        this.O0000o0o = obtainStyledAttributes.getBoolean(1, this.O0000o0o);
        if (obtainStyledAttributes.hasValue(3)) {
            O000000o(obtainStyledAttributes.getString(3));
        } else {
            O000000o("StoreHouse");
        }
        obtainStyledAttributes.recycle();
        setMinimumHeight(this.O0000OOo + dao.O000000o(40.0f));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), View.resolveSize(super.getSuggestedMinimumHeight(), i2));
        this.O0000Oo0 = (getMeasuredWidth() - this.O0000O0o) / 2;
        this.O0000Oo = (getMeasuredHeight() - this.O0000OOo) / 2;
        this.O00000o = getMeasuredHeight() / 2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        int size = this.f5531O000000o.size();
        float f = isInEditMode() ? 1.0f : this.O00000oo;
        for (int i = 0; i < size; i++) {
            canvas.save();
            czk czk = this.f5531O000000o.get(i);
            float f2 = ((float) this.O0000Oo0) + czk.f14409O000000o.x;
            float f3 = ((float) this.O0000Oo) + czk.f14409O000000o.y;
            if (this.O0000o0O) {
                czk.getTransformation(getDrawingTime(), this.O0000oOO);
                canvas.translate(f2, f3);
            } else {
                float f4 = 0.0f;
                if (f == 0.0f) {
                    czk.O00000Oo(this.O00000oO);
                } else {
                    float f5 = (((float) i) * 0.3f) / ((float) size);
                    float f6 = 0.3f - f5;
                    if (f == 1.0f || f >= 1.0f - f6) {
                        canvas.translate(f2, f3);
                        czk.O000000o(0.4f);
                    } else {
                        if (f > f5) {
                            f4 = Math.min(1.0f, (f - f5) / 0.7f);
                        }
                        float f7 = 1.0f - f4;
                        float f8 = f2 + (czk.O00000Oo * f7);
                        float f9 = f3 + (((float) (-this.O00000o)) * f7);
                        this.O0000o.reset();
                        this.O0000o.postRotate(360.0f * f4);
                        this.O0000o.postScale(f4, f4);
                        this.O0000o.postTranslate(f8, f9);
                        czk.O000000o(f4 * 0.4f);
                        canvas.concat(this.O0000o);
                    }
                }
            }
            czk.O000000o(canvas);
            canvas.restore();
        }
        if (this.O0000o0O) {
            invalidate();
        }
        canvas.restoreToCount(save);
        super.dispatchDraw(canvas);
    }

    private StoreHouseHeader O000000o(int i) {
        this.O0000o00 = i;
        for (int i2 = 0; i2 < this.f5531O000000o.size(); i2++) {
            this.f5531O000000o.get(i2).O000000o(i);
        }
        return this;
    }

    private StoreHouseHeader O000000o(String str) {
        O000000o(czl.O000000o(str, 0.25f));
        return this;
    }

    private StoreHouseHeader O000000o(List<float[]> list) {
        boolean z = this.f5531O000000o.size() > 0;
        this.f5531O000000o.clear();
        dao dao = new dao();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < list.size()) {
            float[] fArr = list.get(i);
            PointF pointF = new PointF(((float) dao.O00000Oo(fArr[0])) * this.O00000o0, ((float) dao.O00000Oo(fArr[1])) * this.O00000o0);
            PointF pointF2 = new PointF(((float) dao.O00000Oo(fArr[2])) * this.O00000o0, ((float) dao.O00000Oo(fArr[3])) * this.O00000o0);
            float max = Math.max(Math.max(f, pointF.x), pointF2.x);
            float max2 = Math.max(Math.max(f2, pointF.y), pointF2.y);
            czk czk = new czk(i, pointF, pointF2, this.O0000o00, this.O00000Oo);
            czk.O00000Oo(this.O00000oO);
            this.f5531O000000o.add(czk);
            i++;
            f = max;
            f2 = max2;
        }
        this.O0000O0o = (int) Math.ceil((double) f);
        this.O0000OOo = (int) Math.ceil((double) f2);
        if (z) {
            requestLayout();
        }
        return this;
    }

    public final void O000000o(czw czw, int i, int i2) {
        this.O0000oO0 = czw;
        this.O0000oO0.O000000o(this, this.O0000o0);
    }

    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        this.O00000oo = f * 0.8f;
        invalidate();
    }

    public final void O000000o(czx czx, int i, int i2) {
        this.O0000o0O = true;
        this.O0000oO.O000000o();
        invalidate();
    }

    public final int O000000o(czx czx, boolean z) {
        this.O0000o0O = false;
        O000000o o000000o = this.O0000oO;
        o000000o.O00000oO = false;
        StoreHouseHeader.this.removeCallbacks(o000000o);
        if (!z || !this.O0000o0o) {
            for (int i = 0; i < this.f5531O000000o.size(); i++) {
                this.f5531O000000o.get(i).O00000Oo(this.O00000oO);
            }
            return 0;
        }
        startAnimation(new Animation() {
            /* class com.scwang.smartrefresh.header.StoreHouseHeader.AnonymousClass1 */

            {
                super.setDuration(250);
                super.setInterpolator(new AccelerateInterpolator());
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f, Transformation transformation) {
                StoreHouseHeader storeHouseHeader = StoreHouseHeader.this;
                storeHouseHeader.O00000oo = 1.0f - f;
                storeHouseHeader.invalidate();
                if (f == 1.0f) {
                    for (int i = 0; i < StoreHouseHeader.this.f5531O000000o.size(); i++) {
                        StoreHouseHeader.this.f5531O000000o.get(i).O00000Oo(StoreHouseHeader.this.O00000oO);
                    }
                }
            }
        });
        return 250;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.O0000o0 = iArr[0];
            czw czw = this.O0000oO0;
            if (czw != null) {
                czw.O000000o(this, this.O0000o0);
            }
            if (iArr.length > 1) {
                O000000o(iArr[1]);
            }
        }
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        int f5533O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        boolean O00000oO;

        private O000000o() {
            this.f5533O000000o = 0;
            this.O00000Oo = 0;
            this.O00000o0 = 0;
            this.O00000o = 0;
            this.O00000oO = true;
        }

        /* synthetic */ O000000o(StoreHouseHeader storeHouseHeader, byte b) {
            this();
        }

        public final void O000000o() {
            this.O00000oO = true;
            this.f5533O000000o = 0;
            this.O00000o = StoreHouseHeader.this.O0000OoO / StoreHouseHeader.this.f5531O000000o.size();
            this.O00000Oo = StoreHouseHeader.this.O0000Ooo / this.O00000o;
            this.O00000o0 = (StoreHouseHeader.this.f5531O000000o.size() / this.O00000Oo) + 1;
            run();
        }

        public final void run() {
            int i = this.f5533O000000o % this.O00000Oo;
            for (int i2 = 0; i2 < this.O00000o0; i2++) {
                int i3 = (this.O00000Oo * i2) + i;
                if (i3 <= this.f5533O000000o) {
                    czk czk = StoreHouseHeader.this.f5531O000000o.get(i3 % StoreHouseHeader.this.f5531O000000o.size());
                    czk.setFillAfter(false);
                    czk.setFillEnabled(true);
                    czk.setFillBefore(false);
                    czk.setDuration(400);
                    czk.O000000o();
                }
            }
            this.f5533O000000o++;
            if (this.O00000oO && StoreHouseHeader.this.O0000oO0 != null) {
                StoreHouseHeader.this.O0000oO0.O000000o().getLayout().postDelayed(this, (long) this.O00000o);
            }
        }
    }
}
