package com.scwang.smartrefresh.header.waveswipe;

import _m_j.czn;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;

public class WaveView extends View implements ViewTreeObserver.OnPreDrawListener {
    protected static final float[][] O0000oOO = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};
    protected static final float[][] O0000oOo = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};
    protected static final float[][] O0000oo0 = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};

    /* renamed from: O000000o  reason: collision with root package name */
    protected float f5553O000000o = 100.0f;
    protected Paint O00000Oo;
    protected Path O00000o;
    protected Path O00000o0;
    protected Path O00000oO;
    protected Path O00000oo;
    protected RectF O0000O0o;
    protected int O0000OOo;
    protected int O0000Oo;
    protected float O0000Oo0;
    protected boolean O0000OoO = false;
    protected boolean O0000Ooo = false;
    protected ValueAnimator O0000o;
    protected ValueAnimator O0000o0;
    protected int O0000o00;
    protected ValueAnimator O0000o0O;
    protected ValueAnimator O0000o0o;
    protected ValueAnimator O0000oO;
    protected ValueAnimator O0000oO0;
    protected ValueAnimator.AnimatorUpdateListener O0000oo = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.scwang.smartrefresh.header.waveswipe.WaveView.AnonymousClass1 */

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    };

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
     arg types: [float, int, int, int]
     candidates:
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
    public WaveView(Context context) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        this.O00000Oo = new Paint();
        this.O00000Oo.setColor(-14575885);
        this.O00000Oo.setAntiAlias(true);
        this.O00000Oo.setStyle(Paint.Style.FILL);
        this.O00000Oo.setShadowLayer((float) ((int) ((f * 2.0f) + 0.5f)), 0.0f, 0.0f, -1728053248);
        this.O00000o0 = new Path();
        this.O00000o = new Path();
        this.O00000oO = new Path();
        this.O00000oo = new Path();
        O000000o();
        this.O0000O0o = new RectF();
        setLayerType(1, null);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.O0000OOo = i;
        this.f5553O000000o = ((float) i) / 14.4f;
        O000000o((int) Math.min((float) Math.min(i, i2), ((float) getHeight()) - this.f5553O000000o));
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (!this.O0000Ooo) {
            return false;
        }
        O000000o(this.O0000o00);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.O00000o0, this.O00000Oo);
        if (!isInEditMode()) {
            this.O00000o0.rewind();
            this.O00000o.rewind();
            this.O00000oO.rewind();
        }
        float floatValue = ((Float) this.O0000o.getAnimatedValue()).floatValue();
        float f = ((float) this.O0000OOo) / 2.0f;
        float floatValue2 = ((Float) this.O0000oO0.getAnimatedValue()).floatValue();
        float floatValue3 = ((Float) this.O0000o0O.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.O0000o0o.getAnimatedValue()).floatValue();
        RectF rectF = this.O0000O0o;
        float f2 = this.f5553O000000o;
        float f3 = floatValue3 + 1.0f;
        float f4 = 1.0f + floatValue4;
        rectF.set((f - ((f2 * f3) * floatValue2)) + ((f2 * floatValue4) / 2.0f), (((f2 * f4) * floatValue2) + floatValue) - ((f2 * floatValue3) / 2.0f), (((f3 * f2) * floatValue2) + f) - ((floatValue4 * f2) / 2.0f), (floatValue - ((f4 * f2) * floatValue2)) + ((f2 * floatValue3) / 2.0f));
        float floatValue5 = ((Float) this.O0000o0.getAnimatedValue()).floatValue();
        this.O00000o.moveTo(f, floatValue5);
        double pow = Math.pow((double) this.f5553O000000o, 2.0d);
        double d = (double) (floatValue * floatValue5);
        Double.isNaN(d);
        double d2 = pow + d;
        double d3 = (double) floatValue;
        double pow2 = d2 - Math.pow(d3, 2.0d);
        double d4 = (double) (floatValue5 - floatValue);
        Double.isNaN(d4);
        double d5 = pow2 / d4;
        double d6 = (double) this.O0000OOo;
        Double.isNaN(d6);
        double d7 = (d6 * -2.0d) / 2.0d;
        Double.isNaN(d3);
        double d8 = -d7;
        double pow3 = (d7 * d7) - (((Math.pow(d5 - d3, 2.0d) + Math.pow((double) f, 2.0d)) - Math.pow((double) this.f5553O000000o, 2.0d)) * 4.0d);
        float f5 = (float) d5;
        this.O00000o.lineTo((float) ((Math.sqrt(pow3) + d8) / 2.0d), f5);
        this.O00000o.lineTo((float) ((d8 - Math.sqrt(pow3)) / 2.0d), f5);
        this.O00000o.close();
        this.O00000oo.set(this.O00000o);
        this.O00000oo.addOval(this.O0000O0o, Path.Direction.CCW);
        this.O00000oO.addOval(this.O0000O0o, Path.Direction.CCW);
        canvas.drawPath(this.O00000o, this.O00000Oo);
        canvas.drawPath(this.O00000oO, this.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.O0000oO0;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.O0000oO0.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.O0000o;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.O0000o.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.O0000o0;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.O0000o0.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.O0000oO;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.O0000oO.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.O0000o0o;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.O0000o0o.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.O0000o0O;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.O0000o0O.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        this.O0000o0 = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.O0000o0O = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.O0000o0o = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.O0000o = ValueAnimator.ofFloat(-1000.0f, -1000.0f);
        this.O0000o.start();
        this.O0000oO0 = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.O0000oO0.setDuration(1L);
        this.O0000oO0.start();
    }

    private void O00000o() {
        ValueAnimator valueAnimator = this.O0000oO;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.O0000oO.cancel();
        }
    }

    private void O00000oO() {
        if (!this.O0000OoO) {
            this.O0000OoO = true;
            int i = this.O0000Oo;
            this.O0000o = ValueAnimator.ofFloat((float) i, (float) i);
            this.O0000o.start();
            int i2 = this.O0000Oo;
            float f = this.f5553O000000o;
            this.O0000o0 = ValueAnimator.ofFloat(((float) i2) - f, ((float) i2) - f);
            this.O0000o0.start();
            this.O0000Oo0 = (float) this.O0000Oo;
            postInvalidate();
        }
    }

    public final void O000000o(float f) {
        O00000o();
        this.O00000o0.moveTo(0.0f, 0.0f);
        Path path = this.O00000o0;
        int i = this.O0000OOo;
        float[][] fArr = O0000oOO;
        path.cubicTo(((float) i) * fArr[0][0], fArr[0][1], ((float) i) * fArr[1][0], ((float) i) * (fArr[1][1] + f), ((float) i) * fArr[2][0], ((float) i) * (fArr[2][1] + f));
        Path path2 = this.O00000o0;
        int i2 = this.O0000OOo;
        float[][] fArr2 = O0000oOO;
        path2.cubicTo(((float) i2) * fArr2[3][0], ((float) i2) * (fArr2[3][1] + f), ((float) i2) * fArr2[4][0], ((float) i2) * (fArr2[4][1] + f), ((float) i2) * fArr2[5][0], ((float) i2) * (fArr2[5][1] + f));
        Path path3 = this.O00000o0;
        int i3 = this.O0000OOo;
        float[][] fArr3 = O0000oOO;
        path3.cubicTo(((float) i3) - (((float) i3) * fArr3[4][0]), ((float) i3) * (fArr3[4][1] + f), ((float) i3) - (((float) i3) * fArr3[3][0]), ((float) i3) * (fArr3[3][1] + f), ((float) i3) - (((float) i3) * fArr3[2][0]), ((float) i3) * (fArr3[2][1] + f));
        Path path4 = this.O00000o0;
        int i4 = this.O0000OOo;
        float[][] fArr4 = O0000oOO;
        path4.cubicTo(((float) i4) - (((float) i4) * fArr4[1][0]), ((float) i4) * (fArr4[1][1] + f), ((float) i4) - (((float) i4) * fArr4[0][0]), fArr4[0][1], (float) i4, 0.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public final void O000000o(float f, float f2) {
        O00000o();
        this.O00000o0.moveTo(0.0f, 0.0f);
        Path path = this.O00000o0;
        int i = this.O0000OOo;
        float[][] fArr = O0000oOo;
        path.cubicTo(((float) i) * fArr[0][0], ((float) i) * fArr[0][1], ((float) i) * Math.min(O0000oOO[1][0] + f2, fArr[1][0]), ((float) this.O0000OOo) * Math.max((O0000oOO[1][1] + f) - f2, O0000oOo[1][1]), ((float) this.O0000OOo) * Math.max(O0000oOO[2][0] - f2, O0000oOo[2][0]), ((float) this.O0000OOo) * Math.max((O0000oOO[2][1] + f) - f2, O0000oOo[2][1]));
        Path path2 = this.O00000o0;
        float max = ((float) this.O0000OOo) * Math.max(O0000oOO[3][0] - f2, O0000oOo[3][0]);
        float min = ((float) this.O0000OOo) * Math.min(O0000oOO[3][1] + f + f2, O0000oOo[3][1]);
        float max2 = ((float) this.O0000OOo) * Math.max(O0000oOO[4][0] - f2, O0000oOo[4][0]);
        float min2 = ((float) this.O0000OOo) * Math.min(O0000oOO[4][1] + f + f2, O0000oOo[4][1]);
        int i2 = this.O0000OOo;
        float[][] fArr2 = O0000oOo;
        path2.cubicTo(max, min, max2, min2, ((float) i2) * fArr2[5][0], ((float) i2) * Math.min(O0000oOO[0][1] + f + f2, fArr2[5][1]));
        Path path3 = this.O00000o0;
        int i3 = this.O0000OOo;
        float max3 = ((float) i3) - (((float) i3) * Math.max(O0000oOO[4][0] - f2, O0000oOo[4][0]));
        float min3 = ((float) this.O0000OOo) * Math.min(O0000oOO[4][1] + f + f2, O0000oOo[4][1]);
        int i4 = this.O0000OOo;
        float max4 = ((float) i4) - (((float) i4) * Math.max(O0000oOO[3][0] - f2, O0000oOo[3][0]));
        float min4 = ((float) this.O0000OOo) * Math.min(O0000oOO[3][1] + f + f2, O0000oOo[3][1]);
        int i5 = this.O0000OOo;
        path3.cubicTo(max3, min3, max4, min4, ((float) i5) - (((float) i5) * Math.max(O0000oOO[2][0] - f2, O0000oOo[2][0])), ((float) this.O0000OOo) * Math.max((O0000oOO[2][1] + f) - f2, O0000oOo[2][1]));
        Path path4 = this.O00000o0;
        int i6 = this.O0000OOo;
        float min5 = ((float) i6) - (((float) i6) * Math.min(O0000oOO[1][0] + f2, O0000oOo[1][0]));
        float max5 = ((float) this.O0000OOo) * Math.max((O0000oOO[1][1] + f) - f2, O0000oOo[1][1]);
        int i7 = this.O0000OOo;
        float[][] fArr3 = O0000oOo;
        path4.cubicTo(min5, max5, ((float) i7) - (((float) i7) * fArr3[0][0]), ((float) i7) * fArr3[0][1], (float) i7, 0.0f);
        this.O0000Oo0 = (((float) this.O0000OOo) * Math.min(O0000oOO[3][1] + f + f2, O0000oOo[3][1])) + this.f5553O000000o;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public final void O000000o(float f, float f2, float f3) {
        O00000o();
        this.O00000o0.moveTo(0.0f, 0.0f);
        Path path = this.O00000o0;
        int i = this.O0000OOo;
        float[][] fArr = O0000oo0;
        path.cubicTo(((float) i) * fArr[0][0], ((float) i) * fArr[0][1], ((float) i) * Math.min(Math.min(O0000oOO[1][0] + f2, O0000oOo[1][0]) + f3, O0000oo0[1][0]), ((float) this.O0000OOo) * Math.max(Math.max((O0000oOO[1][1] + f) - f2, O0000oOo[1][1]) - f3, O0000oo0[1][1]), ((float) this.O0000OOo) * Math.max(O0000oOO[2][0] - f2, O0000oo0[2][0]), ((float) this.O0000OOo) * Math.min(Math.max((O0000oOO[2][1] + f) - f2, O0000oOo[2][1]) + f3, O0000oo0[2][1]));
        Path path2 = this.O00000o0;
        float min = ((float) this.O0000OOo) * Math.min(Math.max(O0000oOO[3][0] - f2, O0000oOo[3][0]) + f3, O0000oo0[3][0]);
        float min2 = ((float) this.O0000OOo) * Math.min(Math.min(O0000oOO[3][1] + f + f2, O0000oOo[3][1]) + f3, O0000oo0[3][1]);
        float max = ((float) this.O0000OOo) * Math.max(O0000oOO[4][0] - f2, O0000oo0[4][0]);
        float min3 = ((float) this.O0000OOo) * Math.min(Math.min(O0000oOO[4][1] + f + f2, O0000oOo[4][1]) + f3, O0000oo0[4][1]);
        int i2 = this.O0000OOo;
        path2.cubicTo(min, min2, max, min3, ((float) i2) * O0000oo0[5][0], ((float) i2) * Math.min(Math.min(O0000oOO[0][1] + f + f2, O0000oOo[5][1]) + f3, O0000oo0[5][1]));
        Path path3 = this.O00000o0;
        int i3 = this.O0000OOo;
        float max2 = ((float) i3) - (((float) i3) * Math.max(O0000oOO[4][0] - f2, O0000oo0[4][0]));
        float min4 = ((float) this.O0000OOo) * Math.min(Math.min(O0000oOO[4][1] + f + f2, O0000oOo[4][1]) + f3, O0000oo0[4][1]);
        int i4 = this.O0000OOo;
        float min5 = ((float) i4) - (((float) i4) * Math.min(Math.max(O0000oOO[3][0] - f2, O0000oOo[3][0]) + f3, O0000oo0[3][0]));
        float min6 = ((float) this.O0000OOo) * Math.min(Math.min(O0000oOO[3][1] + f + f2, O0000oOo[3][1]) + f3, O0000oo0[3][1]);
        int i5 = this.O0000OOo;
        path3.cubicTo(max2, min4, min5, min6, ((float) i5) - (((float) i5) * Math.max(O0000oOO[2][0] - f2, O0000oo0[2][0])), ((float) this.O0000OOo) * Math.min(Math.max((O0000oOO[2][1] + f) - f2, O0000oOo[2][1]) + f3, O0000oo0[2][1]));
        Path path4 = this.O00000o0;
        int i6 = this.O0000OOo;
        float min7 = ((float) i6) - (((float) i6) * Math.min(Math.min(O0000oOO[1][0] + f2, O0000oOo[1][0]) + f3, O0000oo0[1][0]));
        float max3 = ((float) this.O0000OOo) * Math.max(Math.max((O0000oOO[1][1] + f) - f2, O0000oOo[1][1]) - f3, O0000oo0[1][1]);
        int i7 = this.O0000OOo;
        float[][] fArr2 = O0000oo0;
        path4.cubicTo(min7, max3, ((float) i7) - (((float) i7) * fArr2[0][0]), ((float) i7) * fArr2[0][1], (float) i7, 0.0f);
        this.O0000Oo0 = (((float) this.O0000OOo) * Math.min(Math.min(O0000oOO[3][1] + f + f2, O0000oOo[3][1]) + f3, O0000oo0[3][1])) + this.f5553O000000o;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    private void O000000o(int i) {
        float f = (float) i;
        if ((((float) this.O0000OOo) / 1440.0f) * 500.0f <= f) {
            this.O0000Oo = (int) Math.min(f, ((float) getHeight()) - this.f5553O000000o);
            if (this.O0000OoO) {
                this.O0000OoO = false;
                O00000oO();
            }
        }
    }

    public final void O00000Oo() {
        this.O0000oO0 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.O0000oO0.addUpdateListener(this.O0000oo);
        this.O0000oO0.setDuration(200L);
        this.O0000oO0.addListener(new AnimatorListenerAdapter() {
            /* class com.scwang.smartrefresh.header.waveswipe.WaveView.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                WaveView.this.O000000o();
                WaveView.this.O0000OoO = false;
            }
        });
        this.O0000oO0.start();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public final void O00000Oo(float f) {
        this.O0000oO = ValueAnimator.ofFloat(Math.min(f, 0.2f) * ((float) this.O0000OOo), 0.0f);
        this.O0000oO.setDuration(1000L);
        this.O0000oO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.scwang.smartrefresh.header.waveswipe.WaveView.AnonymousClass4 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                WaveView.this.O00000o0.moveTo(0.0f, 0.0f);
                float f = floatValue * 0.5f;
                WaveView.this.O00000o0.quadTo(((float) WaveView.this.O0000OOo) * 0.25f, 0.0f, ((float) WaveView.this.O0000OOo) * 0.333f, f);
                WaveView.this.O00000o0.quadTo(((float) WaveView.this.O0000OOo) * 0.5f, floatValue * 1.4f, ((float) WaveView.this.O0000OOo) * 0.666f, f);
                WaveView.this.O00000o0.quadTo(((float) WaveView.this.O0000OOo) * 0.75f, 0.0f, (float) WaveView.this.O0000OOo, 0.0f);
                WaveView.this.postInvalidate();
            }
        });
        this.O0000oO.setInterpolator(new BounceInterpolator());
        this.O0000oO.start();
    }

    public final void O00000o0() {
        if (!this.O0000oO0.isRunning()) {
            this.O0000oO0 = ValueAnimator.ofFloat(1.0f, 1.0f);
            this.O0000oO0.setDuration(1L);
            this.O0000oO0.start();
            this.O0000o = ValueAnimator.ofFloat((((float) this.O0000OOo) / 1440.0f) * 500.0f, (float) this.O0000Oo);
            this.O0000o.setDuration(500L);
            this.O0000o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.scwang.smartrefresh.header.waveswipe.WaveView.AnonymousClass2 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WaveView.this.O0000Oo0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    WaveView waveView = WaveView.this;
                    if (Build.VERSION.SDK_INT >= 16) {
                        waveView.postInvalidateOnAnimation();
                    } else {
                        waveView.invalidate();
                    }
                }
            });
            this.O0000o.setInterpolator(new AccelerateDecelerateInterpolator());
            this.O0000o.start();
            this.O0000o0 = ValueAnimator.ofFloat(0.0f, ((float) this.O0000Oo) - this.f5553O000000o);
            this.O0000o0.setDuration(500L);
            this.O0000o0.addUpdateListener(this.O0000oo);
            this.O0000o0.start();
            this.O0000o0O = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.O0000o0O.setDuration(500L);
            this.O0000o0O.addUpdateListener(this.O0000oo);
            this.O0000o0O.setInterpolator(new czn());
            this.O0000o0O.setStartDelay(500);
            this.O0000o0O.start();
            this.O0000o0o = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.O0000o0o.setDuration(500L);
            this.O0000o0o.addUpdateListener(this.O0000oo);
            this.O0000o0o.setInterpolator(new czn());
            this.O0000o0o.setStartDelay(625);
            this.O0000o0o.start();
            O00000Oo(0.1f);
        }
    }

    public float getCurrentCircleCenterY() {
        return this.O0000Oo0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
     arg types: [float, int, int, int]
     candidates:
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
    public final void O000000o(int i, int i2) {
        this.O00000Oo.setShadowLayer((float) i, 0.0f, 0.0f, i2);
    }

    public void setWaveColor(int i) {
        this.O00000Oo.setColor(i);
        invalidate();
    }
}
