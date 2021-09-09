package com.scwang.smartrefresh.header;

import _m_j.czj;
import _m_j.czu;
import _m_j.czw;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import _m_j.q;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xiaomi.smarthome.R;

public class DropBoxHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static String[] f5515O000000o = {"M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z"};
    protected static int[] O00000Oo = {-1249039, -245496};
    protected static int[] O00000o = {-76695, -2773417};
    protected static String[] O00000o0 = {"M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z"};
    protected static String[] O00000oO = {"M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z"};
    protected static int[] O00000oo = {-6760607};
    protected Path O0000O0o;
    protected Paint O0000OOo;
    protected int O0000Oo;
    protected O000000o O0000Oo0;
    protected int O0000OoO;
    protected boolean O0000Ooo;
    protected float O0000o;
    protected Drawable O0000o0;
    protected Drawable O0000o00;
    protected Drawable O0000o0O;
    protected float O0000o0o;
    protected ValueAnimator O0000oO;
    protected ValueAnimator O0000oO0;
    protected RefreshState O0000oOO;

    public DropBoxHeader(Context context) {
        this(context, null);
    }

    public DropBoxHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropBoxHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000O0o = new Path();
        this.O0000OOo = new Paint();
        this.O0000Oo0 = new O000000o((byte) 0);
        this.O0000OOo.setAntiAlias(true);
        this.O0000Oo = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(dao.O000000o(150.0f));
        this.O000OoOo = SpinnerStyle.Scale;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.dhDrawable1, R.attr.dhDrawable2, R.attr.dhDrawable3});
        if (obtainStyledAttributes.hasValue(0)) {
            this.O0000o00 = obtainStyledAttributes.getDrawable(0);
        } else {
            czj czj = new czj();
            czj.O000000o(O00000Oo);
            if (!czj.O000000o(f5515O000000o)) {
                czj.O000000o(2, 1, 20, 22);
            }
            this.O0000o00 = czj;
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.O0000o0 = obtainStyledAttributes.getDrawable(1);
        } else {
            czj czj2 = new czj();
            czj2.O000000o(O00000o);
            if (!czj2.O000000o(O00000o0)) {
                czj2.O000000o(8, 3, 41, 53);
            }
            this.O0000o0 = czj2;
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.O0000o0O = obtainStyledAttributes.getDrawable(2);
        } else {
            czj czj3 = new czj();
            czj3.O000000o(O00000oo);
            if (!czj3.O000000o(O00000oO)) {
                czj3.O000000o(2, 0, 15, 16);
            }
            this.O0000o0O = czj3;
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.O0000oO0 = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.O0000oO0.setInterpolator(accelerateInterpolator);
        this.O0000oO0.setDuration(300L);
        this.O0000oO0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.scwang.smartrefresh.header.DropBoxHeader.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropBoxHeader dropBoxHeader = DropBoxHeader.this;
                dropBoxHeader.O0000o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dropBoxHeader.invalidate();
            }
        });
        this.O0000oO0.addListener(new AnimatorListenerAdapter() {
            /* class com.scwang.smartrefresh.header.DropBoxHeader.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                if (DropBoxHeader.this.O0000oOO != RefreshState.Refreshing) {
                    DropBoxHeader.this.O0000o0o = 0.0f;
                } else if (DropBoxHeader.this.O0000oO != null) {
                    DropBoxHeader.this.O0000oO.start();
                }
            }
        });
        this.O0000oO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.O0000oO.setInterpolator(accelerateInterpolator);
        this.O0000oO.setDuration(300L);
        this.O0000oO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.scwang.smartrefresh.header.DropBoxHeader.AnonymousClass3 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (DropBoxHeader.this.O0000o0o < 1.0f || DropBoxHeader.this.O0000o0o >= 3.0f) {
                    DropBoxHeader.this.O0000o0o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } else if (DropBoxHeader.this.O0000o0o < 2.0f) {
                    DropBoxHeader.this.O0000o0o = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
                } else if (DropBoxHeader.this.O0000o0o < 3.0f) {
                    DropBoxHeader.this.O0000o0o = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                    if (DropBoxHeader.this.O0000o0o == 3.0f) {
                        DropBoxHeader.this.O0000Ooo = true;
                    }
                }
                DropBoxHeader.this.invalidate();
            }
        });
        this.O0000oO.addListener(new AnimatorListenerAdapter() {
            /* class com.scwang.smartrefresh.header.DropBoxHeader.AnonymousClass4 */

            public final void onAnimationEnd(Animator animator) {
                if (DropBoxHeader.this.O0000oO0 != null) {
                    DropBoxHeader.this.O0000oO0.start();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.O0000oO0;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.O0000oO0.removeAllListeners();
            this.O0000oO0 = null;
        }
        ValueAnimator valueAnimator2 = this.O0000oO;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.O0000oO.removeAllListeners();
            this.O0000oO = null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = getWidth();
        int height = getHeight();
        int i = this.O0000OoO / 5;
        int i2 = i / 2;
        O000000o o000000o = this.O0000Oo0;
        o000000o.O0000Oo0 = i;
        int i3 = width / 2;
        o000000o.f5520O000000o = i3;
        o000000o.O00000o0 = height - i2;
        o000000o.O00000o = o000000o.O00000o0 - (i * 2);
        int i4 = o000000o.f5520O000000o;
        double d = (double) i;
        double sin = Math.sin(1.0471975511965976d);
        Double.isNaN(d);
        o000000o.O00000oO = i4 - ((int) (d * sin));
        o000000o.O00000oo = o000000o.O00000o + i2;
        o000000o.O0000O0o = o000000o.O00000o0 - i2;
        o000000o.O0000OOo = width - o000000o.O00000oO;
        o000000o.O00000Oo = o000000o.O00000o0 - i;
        this.O0000OOo.setColor(q.O00000Oo(this.O0000Oo, 150));
        this.O0000O0o.reset();
        this.O0000O0o.moveTo((float) o000000o.O00000oO, (float) o000000o.O0000O0o);
        this.O0000O0o.lineTo((float) o000000o.f5520O000000o, (float) o000000o.O00000o0);
        this.O0000O0o.lineTo((float) o000000o.O0000OOo, (float) o000000o.O0000O0o);
        this.O0000O0o.quadTo(((float) o000000o.O0000OOo) + (((float) (o000000o.O0000Oo0 / 2)) * this.O0000o), (float) o000000o.O00000Oo, (float) o000000o.O0000OOo, (float) o000000o.O00000oo);
        this.O0000O0o.lineTo((float) o000000o.f5520O000000o, (float) o000000o.O00000o);
        this.O0000O0o.lineTo((float) o000000o.O00000oO, (float) o000000o.O00000oo);
        this.O0000O0o.quadTo(((float) o000000o.O00000oO) - (((float) (o000000o.O0000Oo0 / 2)) * this.O0000o), (float) o000000o.O00000Oo, (float) o000000o.O00000oO, (float) o000000o.O0000O0o);
        this.O0000O0o.close();
        canvas2.drawPath(this.O0000O0o, this.O0000OOo);
        this.O0000OOo.setColor(this.O0000Oo);
        this.O0000O0o.reset();
        double d2 = (double) this.O0000o;
        Double.isNaN(d2);
        double d3 = d2 * 1.2566370614359172d;
        float f = (float) (((o000000o.f5520O000000o - o000000o.O00000oO) * 4) / 5);
        double d4 = 1.0471975511965976d - (d3 / 2.0d);
        float sin2 = ((float) Math.sin(d4)) * f;
        float cos = ((float) Math.cos(d4)) * f;
        this.O0000O0o.moveTo((float) o000000o.O00000oO, (float) o000000o.O00000oo);
        this.O0000O0o.lineTo((float) o000000o.f5520O000000o, (float) o000000o.O00000o);
        this.O0000O0o.lineTo(((float) o000000o.f5520O000000o) - sin2, ((float) o000000o.O00000o) - cos);
        this.O0000O0o.lineTo(((float) o000000o.O00000oO) - sin2, ((float) o000000o.O00000oo) - cos);
        this.O0000O0o.close();
        double d5 = d3 + 1.0471975511965976d;
        float sin3 = ((float) Math.sin(d5)) * f;
        float cos2 = ((float) Math.cos(d5)) * f;
        this.O0000O0o.moveTo((float) o000000o.O00000oO, (float) o000000o.O00000oo);
        this.O0000O0o.lineTo((float) o000000o.f5520O000000o, (float) ((o000000o.O00000o0 + o000000o.O00000o) / 2));
        this.O0000O0o.lineTo(((float) o000000o.f5520O000000o) - sin3, ((float) ((o000000o.O00000o0 + o000000o.O00000o) / 2)) + cos2);
        this.O0000O0o.lineTo(((float) o000000o.O00000oO) - sin3, ((float) o000000o.O00000oo) + cos2);
        this.O0000O0o.close();
        float sin4 = ((float) Math.sin(d4)) * f;
        float cos3 = ((float) Math.cos(d4)) * f;
        this.O0000O0o.moveTo((float) o000000o.O0000OOo, (float) o000000o.O00000oo);
        this.O0000O0o.lineTo((float) o000000o.f5520O000000o, (float) o000000o.O00000o);
        this.O0000O0o.lineTo(((float) o000000o.f5520O000000o) + sin4, ((float) o000000o.O00000o) - cos3);
        this.O0000O0o.lineTo(((float) o000000o.O0000OOo) + sin4, ((float) o000000o.O00000oo) - cos3);
        this.O0000O0o.close();
        float sin5 = ((float) Math.sin(d5)) * f;
        float cos4 = f * ((float) Math.cos(d5));
        this.O0000O0o.moveTo((float) o000000o.O0000OOo, (float) o000000o.O00000oo);
        this.O0000O0o.lineTo((float) o000000o.f5520O000000o, (float) ((o000000o.O00000o0 + o000000o.O00000o) / 2));
        this.O0000O0o.lineTo(((float) o000000o.f5520O000000o) + sin5, ((float) ((o000000o.O00000o0 + o000000o.O00000o) / 2)) + cos4);
        this.O0000O0o.lineTo(((float) o000000o.O0000OOo) + sin5, ((float) o000000o.O00000oo) + cos4);
        this.O0000O0o.close();
        canvas2.drawPath(this.O0000O0o, this.O0000OOo);
        if (isInEditMode()) {
            this.O0000o0o = 2.5f;
        }
        if (this.O0000o0o > 0.0f) {
            this.O0000O0o.reset();
            this.O0000O0o.lineTo(0.0f, (float) o000000o.O00000oo);
            this.O0000O0o.lineTo((float) o000000o.O00000oO, (float) o000000o.O00000oo);
            this.O0000O0o.lineTo((float) o000000o.f5520O000000o, (float) o000000o.O00000Oo);
            this.O0000O0o.lineTo((float) o000000o.O0000OOo, (float) o000000o.O00000oo);
            float f2 = (float) width;
            this.O0000O0o.lineTo(f2, (float) o000000o.O00000oo);
            this.O0000O0o.lineTo(f2, 0.0f);
            this.O0000O0o.close();
            canvas2.clipPath(this.O0000O0o);
            float min = Math.min(this.O0000o0o, 1.0f);
            Rect bounds = this.O0000o00.getBounds();
            bounds.offsetTo(i3 - (bounds.width() / 2), ((int) (((float) ((o000000o.O00000Oo - (bounds.height() / 2)) + bounds.height())) * min)) - bounds.height());
            this.O0000o00.draw(canvas2);
            float min2 = Math.min(Math.max(this.O0000o0o - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.O0000o0.getBounds();
            bounds2.offsetTo(i3 - (bounds2.width() / 2), ((int) (((float) ((o000000o.O00000Oo - (bounds2.height() / 2)) + bounds2.height())) * min2)) - bounds2.height());
            this.O0000o0.draw(canvas2);
            float min3 = Math.min(Math.max(this.O0000o0o - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.O0000o0O.getBounds();
            bounds3.offsetTo(i3 - (bounds3.width() / 2), ((int) (((float) ((o000000o.O00000Oo - (bounds3.height() / 2)) + bounds3.height())) * min3)) - bounds3.height());
            this.O0000o0O.draw(canvas2);
            if (this.O0000Ooo) {
                bounds.offsetTo(i3 - (bounds.width() / 2), o000000o.O00000Oo - (bounds.height() / 2));
                this.O0000o00.draw(canvas2);
                bounds2.offsetTo(i3 - (bounds2.width() / 2), o000000o.O00000Oo - (bounds2.height() / 2));
                this.O0000o0.draw(canvas2);
                bounds3.offsetTo(i3 - (bounds3.width() / 2), o000000o.O00000Oo - (bounds3.height() / 2));
                this.O0000o0O.draw(canvas2);
            }
        }
        super.dispatchDraw(canvas);
    }

    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (!z || this.O0000oOO != RefreshState.Refreshing) {
            this.O0000o = (((float) Math.max(0, i - i2)) * 1.0f) / ((float) i3);
        }
    }

    public final void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        this.O0000oOO = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.O0000Ooo = false;
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.O0000Oo = iArr[1];
            }
        }
    }

    public final void O000000o(czw czw, int i, int i2) {
        this.O0000OoO = i;
        int i3 = this.O0000OoO / 5;
        this.O0000o00.setBounds(0, 0, i3, i3);
        this.O0000o0.setBounds(0, 0, i3, i3);
        this.O0000o0O.setBounds(0, 0, i3, i3);
    }

    public final void O00000Oo(czx czx, int i, int i2) {
        ValueAnimator valueAnimator = this.O0000oO;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public final int O000000o(czx czx, boolean z) {
        this.O0000o0o = 0.0f;
        return 0;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f5520O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;
        int O00000oo;
        int O0000O0o;
        int O0000OOo;
        int O0000Oo0;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }
}
