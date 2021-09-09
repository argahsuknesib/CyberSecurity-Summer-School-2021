package com.scwang.smartrefresh.layout.header;

import _m_j.czu;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xiaomi.smarthome.R;

public class BezierRadarHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f5579O000000o;
    protected int O00000Oo;
    protected boolean O00000o;
    protected boolean O00000o0;
    protected boolean O00000oO;
    protected boolean O00000oo;
    protected Path O0000O0o;
    protected Paint O0000OOo;
    protected int O0000Oo;
    protected int O0000Oo0;
    protected int O0000OoO;
    protected float O0000Ooo;
    protected float O0000o;
    protected float O0000o0;
    protected float O0000o00;
    protected float O0000o0O;
    protected int O0000o0o;
    protected float O0000oO;
    protected float O0000oO0;
    protected Animator O0000oOO;
    protected RectF O0000oOo;

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oo = false;
        this.O0000OoO = -1;
        this.O0000o0o = 0;
        this.O0000o = 0.0f;
        this.O0000oO0 = 0.0f;
        this.O0000oO = 0.0f;
        this.O0000oOo = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.O000OoOo = SpinnerStyle.Scale;
        dao dao = new dao();
        this.O0000O0o = new Path();
        this.O0000OOo = new Paint();
        this.O0000OOo.setAntiAlias(true);
        this.O0000o0 = (float) dao.O00000Oo(7.0f);
        this.O0000o = (float) dao.O00000Oo(20.0f);
        this.O0000oO0 = (float) dao.O00000Oo(7.0f);
        this.O0000OOo.setStrokeWidth((float) dao.O00000Oo(3.0f));
        setMinimumHeight(dao.O00000Oo(100.0f));
        if (isInEditMode()) {
            this.O0000Oo0 = 1000;
            this.O0000oO = 1.0f;
            this.O0000o0o = 270;
        } else {
            this.O0000oO = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.srlAccentColor, R.attr.srlEnableHorizontalDrag, R.attr.srlPrimaryColor});
        this.O00000oo = obtainStyledAttributes.getBoolean(1, this.O00000oo);
        O00000Oo(obtainStyledAttributes.getColor(0, -1));
        O000000o(obtainStyledAttributes.getColor(2, -14540254));
        this.O00000o = obtainStyledAttributes.hasValue(0);
        this.O00000o0 = obtainStyledAttributes.hasValue(2);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.O0000oOO;
        if (animator != null) {
            animator.removeAllListeners();
            this.O0000oOO.end();
            this.O0000oOO = null;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        Canvas canvas3 = canvas;
        int width = getWidth();
        int height = getHeight();
        this.O0000O0o.reset();
        this.O0000O0o.lineTo(0.0f, (float) this.O0000Oo0);
        Path path = this.O0000O0o;
        int i = this.O0000OoO;
        if (i < 0) {
            i = width / 2;
        }
        int i2 = this.O0000Oo0;
        float f = (float) width;
        path.quadTo((float) i, (float) (this.O0000Oo + i2), f, (float) i2);
        this.O0000O0o.lineTo(f, 0.0f);
        this.O0000OOo.setColor(this.O00000Oo);
        canvas3.drawPath(this.O0000O0o, this.O0000OOo);
        if (this.O0000Ooo > 0.0f) {
            this.O0000OOo.setColor(this.f5579O000000o);
            float O000000o2 = dao.O000000o(height);
            float f2 = (float) (width / 7);
            float f3 = this.O0000o00;
            float f4 = (f2 * f3) - (f3 > 1.0f ? ((f3 - 1.0f) * f2) / f3 : 0.0f);
            float f5 = (float) height;
            float f6 = this.O0000o00;
            float f7 = 2.0f;
            float f8 = f5 - (f6 > 1.0f ? (((f6 - 1.0f) * f5) / 2.0f) / f6 : 0.0f);
            int i3 = 0;
            while (i3 < 7) {
                float f9 = (((float) i3) + 1.0f) - 4.0f;
                Paint paint = this.O0000OOo;
                double abs = (double) (this.O0000Ooo * (1.0f - ((Math.abs(f9) / 7.0f) * f7)) * 255.0f);
                double d = (double) O000000o2;
                Double.isNaN(d);
                Double.isNaN(abs);
                paint.setAlpha((int) (abs * (1.0d - (1.0d / Math.pow((d / 800.0d) + 1.0d, 15.0d)))));
                float f10 = this.O0000o0 * (1.0f - (1.0f / ((O000000o2 / 10.0f) + 1.0f)));
                Canvas canvas4 = canvas;
                canvas4.drawCircle((((float) (width / 2)) - (f10 / 2.0f)) + (f4 * f9), f8 / 2.0f, f10, this.O0000OOo);
                i3++;
                canvas3 = canvas4;
                f7 = 2.0f;
            }
            canvas2 = canvas3;
            this.O0000OOo.setAlpha(255);
        } else {
            canvas2 = canvas3;
        }
        if (this.O0000oOO != null || isInEditMode()) {
            float f11 = this.O0000o;
            float f12 = this.O0000oO;
            float f13 = f11 * f12;
            float f14 = this.O0000oO0 * f12;
            this.O0000OOo.setColor(this.f5579O000000o);
            this.O0000OOo.setStyle(Paint.Style.FILL);
            float f15 = (float) (width / 2);
            float f16 = (float) (height / 2);
            canvas2.drawCircle(f15, f16, f13, this.O0000OOo);
            this.O0000OOo.setStyle(Paint.Style.STROKE);
            float f17 = f13 + f14;
            canvas2.drawCircle(f15, f16, f17, this.O0000OOo);
            this.O0000OOo.setColor((this.O00000Oo & 16777215) | 1426063360);
            this.O0000OOo.setStyle(Paint.Style.FILL);
            this.O0000oOo.set(f15 - f13, f16 - f13, f15 + f13, f13 + f16);
            canvas.drawArc(this.O0000oOo, 270.0f, (float) this.O0000o0o, true, this.O0000OOo);
            this.O0000OOo.setStyle(Paint.Style.STROKE);
            this.O0000oOo.set(f15 - f17, f16 - f17, f15 + f17, f16 + f17);
            canvas.drawArc(this.O0000oOo, 270.0f, (float) this.O0000o0o, false, this.O0000OOo);
            this.O0000OOo.setStyle(Paint.Style.FILL);
        }
        if (this.O0000o0O > 0.0f) {
            this.O0000OOo.setColor(this.f5579O000000o);
            canvas2.drawCircle((float) (width / 2), (float) (height / 2), this.O0000o0O, this.O0000OOo);
        }
        super.dispatchDraw(canvas);
    }

    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (z || this.O00000oO) {
            this.O00000oO = true;
            this.O0000Oo0 = Math.min(i2, i);
            this.O0000Oo = (int) (((float) Math.max(0, i - i2)) * 1.9f);
            this.O0000o00 = f;
        }
    }

    public final void O000000o(czx czx, int i, int i2) {
        this.O0000Oo0 = i;
        this.O00000oO = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        ofInt.setDuration(720L);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new O000000o((byte) 4));
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.addUpdateListener(new O000000o((byte) 2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat2.addUpdateListener(new O000000o((byte) 0));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofInt);
        animatorSet.start();
        int i3 = this.O0000Oo;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i3, 0, -((int) (((float) i3) * 0.8f)), 0, -((int) (((float) i3) * 0.4f)), 0);
        ofInt2.addUpdateListener(new O000000o((byte) 1));
        ofInt2.setInterpolator(decelerateInterpolator);
        ofInt2.setDuration(800L);
        ofInt2.start();
        this.O0000oOO = animatorSet;
    }

    public final int O000000o(czx czx, boolean z) {
        Animator animator = this.O0000oOO;
        if (animator != null) {
            animator.removeAllListeners();
            this.O0000oOO.end();
            this.O0000oOO = null;
        }
        int width = getWidth();
        int height = getHeight();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (float) Math.sqrt((double) ((width * width) + (height * height))));
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new O000000o((byte) 3));
        ofFloat.start();
        return 400;
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5580O000000o = new int[RefreshState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f5580O000000o[RefreshState.None.ordinal()] = 1;
            f5580O000000o[RefreshState.PullDownToRefresh.ordinal()] = 2;
        }
    }

    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.f5580O000000o[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.O0000Ooo = 1.0f;
            this.O0000oO = 0.0f;
            this.O0000o0O = 0.0f;
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.O00000o0) {
            O000000o(iArr[0]);
            this.O00000o0 = false;
        }
        if (iArr.length > 1 && !this.O00000o) {
            O00000Oo(iArr[1]);
            this.O00000o = false;
        }
    }

    public final boolean O00000Oo() {
        return this.O00000oo;
    }

    public final void O000000o(float f, int i, int i2) {
        this.O0000OoO = i;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    private BezierRadarHeader O000000o(int i) {
        this.O00000Oo = i;
        this.O00000o0 = true;
        return this;
    }

    private BezierRadarHeader O00000Oo(int i) {
        this.f5579O000000o = i;
        this.O00000o = true;
        return this;
    }

    public class O000000o implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: O000000o  reason: collision with root package name */
        byte f5581O000000o;

        O000000o(byte b) {
            this.f5581O000000o = b;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b = this.f5581O000000o;
            if (b == 0) {
                BezierRadarHeader.this.O0000oO = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b) {
                if (BezierRadarHeader.this.O00000oO) {
                    valueAnimator.cancel();
                    return;
                } else {
                    BezierRadarHeader.this.O0000Oo = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
                }
            } else if (2 == b) {
                BezierRadarHeader.this.O0000Ooo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b) {
                BezierRadarHeader.this.O0000o0O = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b) {
                BezierRadarHeader.this.O0000o0o = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }
}
