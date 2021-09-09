package com.scwang.smartrefresh.header;

import _m_j.czj;
import _m_j.czu;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class TaurusHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static String[] f5534O000000o = {"m23.01,81.48c-0.21,-0.3 -0.38,-0.83 -0.38,-1.19 0,-0.55 0.24,-0.78 1.5,-1.48 1.78,-0.97 2.62,-1.94 2.24,-2.57 -0.57,-0.93 -1.97,-1.24 -11.64,-2.59 -5.35,-0.74 -10.21,-1.44 -10.82,-1.54l-1.09,-0.18 1.19,-0.91c0.99,-0.76 1.38,-0.91 2.35,-0.91 0.64,0 6.39,0.33 12.79,0.74 6.39,0.41 12.09,0.71 12.65,0.67l1.03,-0.07 -1.24,-2.19C30.18,66.77 15.91,42 15.13,40.68l-0.51,-0.87 4.19,-1.26c2.3,-0.69 4.27,-1.26 4.37,-1.26 0.1,0 5.95,3.85 13,8.55 14.69,9.81 17.1,11.31 19.7,12.31 4.63,1.78 6.45,1.69 12.94,-0.64 13.18,-4.73 25.22,-9.13 25.75,-9.4 0.69,-0.36 3.6,1.33 -24.38,-14.22L50.73,23.07 46.74,16.42 42.75,9.77 43.63,8.89c0.83,-0.83 0.91,-0.86 1.46,-0.52 0.32,0.2 3.72,3.09 7.55,6.44 3.83,3.34 7.21,6.16 7.5,6.27 0.29,0.11 13.6,2.82 29.58,6.03 15.98,3.21 31.86,6.4 35.3,7.1l6.26,1.26 3.22,-1.13c41.63,-14.63 67.88,-23.23 85.38,-28 14.83,-4.04 23.75,-4.75 32.07,-2.57 7.04,1.84 9.87,4.88 7.71,8.27 -1.6,2.5 -4.6,4.63 -10.61,7.54 -5.94,2.88 -10.22,4.46 -25.4,9.41 -8.15,2.66 -16.66,5.72 -39.01,14.02 -66.79,24.82 -88.49,31.25 -121.66,36.07 -14.56,2.11 -24.17,2.95 -34.08,2.95 -5.43,0 -5.52,-0.01 -5.89,-0.54z"};
    protected static int[] O00000Oo = {-1};
    protected static int[] O00000o = {-1429742351, -571935747, -131587};
    protected static String[] O00000o0 = {"M551.81,1.01A65.42,65.42 0,0 0,504.38 21.5A50.65,50.65 0,0 0,492.4 20A50.65,50.65 0,0 0,441.75 70.65A50.65,50.65 0,0 0,492.4 121.3A50.65,50.65 0,0 0,511.22 117.64A65.42,65.42 0,0 0,517.45 122L586.25,122A65.42,65.42 0,0 0,599.79 110.78A59.79,59.79 0,0 0,607.81 122L696.34,122A59.79,59.79 0,0 0,711.87 81.9A59.79,59.79 0,0 0,652.07 22.11A59.79,59.79 0,0 0,610.93 38.57A65.42,65.42 0,0 0,551.81 1.01zM246.2,1.71A54.87,54.87 0,0 0,195.14 36.64A46.78,46.78 0,0 0,167.77 27.74A46.78,46.78 0,0 0,120.99 74.52A46.78,46.78 0,0 0,167.77 121.3A46.78,46.78 0,0 0,208.92 96.74A54.87,54.87 0,0 0,246.2 111.45A54.87,54.87 0,0 0,268.71 106.54A39.04,39.04 0,0 0,281.09 122L327.6,122A39.04,39.04 0,0 0,343.38 90.7A39.04,39.04 0,0 0,304.34 51.66A39.04,39.04 0,0 0,300.82 51.85A54.87,54.87 0,0 0,246.2 1.71z", "m506.71,31.37a53.11,53.11 0,0 0,-53.11 53.11,53.11 53.11,0 0,0 15.55,37.5h75.12a53.11,53.11 0,0 0,1.88 -2.01,28.49 28.49,0 0,0 0.81,2.01h212.96a96.72,96.72 0,0 0,-87.09 -54.85,96.72 96.72,0 0,0 -73.14,33.52 28.49,28.49 0,0 0,-26.74 -18.74,28.49 28.49,0 0,0 -13.16,3.23 53.11,53.11 0,0 0,0.03 -0.66,53.11 53.11,0 0,0 -53.11,-53.11zM206.23,31.81a53.81,53.81 0,0 0,-49.99 34.03,74.91 74.91,0 0,0 -47.45,-17 74.91,74.91 0,0 0,-73.54 60.82,31.3 31.3,0 0,0 -10.17,-1.73 31.3,31.3 0,0 0,-26.09 14.05L300.86,121.98a37.63,37.63 0,0 0,0.2 -3.85,37.63 37.63,0 0,0 -37.63,-37.63 37.63,37.63 0,0 0,-3.65 0.21,53.81 53.81,0 0,0 -53.54,-48.9z", "m424.05,36.88a53.46,53.46 0,0 0,-40.89 19.02,53.46 53.46,0 0,0 -1.34,1.76 62.6,62.6 0,0 0,-5.39 -0.27,62.6 62.6,0 0,0 -61.36,50.17 62.6,62.6 0,0 0,-0.53 3.51,15.83 15.83,0 0,0 -10.33,-3.84 15.83,15.83 0,0 0,-8.06 2.23,21.1 21.1,0 0,0 -18.31,-10.67 21.1,21.1 0,0 0,-19.47 12.97,21.81 21.81,0 0,0 -6.56,-1.01 21.81,21.81 0,0 0,-19.09 11.32L522.84,122.07a43.61,43.61 0,0 0,-43.11 -37.35,43.61 43.61,0 0,0 -2.57,0.09 53.46,53.46 0,0 0,-53.11 -47.93zM129.08,38.4a50.29,50.29 0,0 0,-50.29 50.29,50.29 50.29,0 0,0 2.37,15.06 15.48,15.83 0,0 0,-5.87 1.68,15.48 15.83,0 0,0 -0.98,0.58 16.53,16.18 0,0 0,-0.19 -0.21,16.53 16.18,0 0,0 -11.86,-4.91 16.53,16.18 0,0 0,-16.38 14.13,20.05 16.18,0 0,0 -14.97,7.04L223.95,122.07a42.56,42.56 0,0 0,1.14 -9.56,42.56 42.56,0 0,0 -42.56,-42.56 42.56,42.56 0,0 0,-6.58 0.54,50.29 50.29,0 0,0 -0,-0.01 50.29,50.29 0,0 0,-46.88 -32.07zM631.67,82.61a64.01,64.01 0,0 0,-44.9 18.42,26.73 26.73,0 0,0 -10.67,-2.24 26.73,26.73 0,0 0,-22.72 12.71,16.88 16.88,0 0,0 -0.25,-0.12 16.88,16.88 0,0 0,-6.57 -1.33,16.88 16.88,0 0,0 -16.15,12.03h160.36a64.01,64.01 0,0 0,-59.1 -39.46z"};
    protected static final Interpolator O00000oO = new AccelerateDecelerateInterpolator();
    protected Drawable O00000oo;
    protected Drawable O0000O0o;
    protected Matrix O0000OOo;
    protected int O0000Oo;
    protected float O0000Oo0;
    protected Animation O0000OoO;
    protected boolean O0000Ooo;
    protected Paint O0000o;
    protected float O0000o0;
    protected float O0000o00;
    protected Random O0000o0O;
    protected Map<Float, Float> O0000o0o;
    protected boolean O0000oO;
    protected float O0000oO0;
    protected boolean O0000oOO;
    protected float O0000oOo;

    public enum AnimationPart {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public TaurusHeader(Context context) {
        this(context, null);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Ooo = false;
        dao dao = new dao();
        setMinimumHeight(dao.O00000Oo(100.0f));
        this.O0000OOo = new Matrix();
        this.O0000o0o = new HashMap();
        this.O0000o0O = new Random();
        this.O0000o = new Paint();
        this.O0000o.setColor(-1);
        this.O0000o.setStrokeWidth((float) dao.O00000Oo(3.0f));
        this.O0000o.setAlpha(50);
        this.O000OoOo = SpinnerStyle.Scale;
        this.O0000OoO = new Animation() {
            /* class com.scwang.smartrefresh.header.TaurusHeader.AnonymousClass1 */

            public final void applyTransformation(float f, Transformation transformation) {
                TaurusHeader.this.O0000o00 = (f / 6.0f) * 80.0f;
                this.invalidate();
            }
        };
        this.O0000OoO.setRepeatCount(-1);
        this.O0000OoO.setRepeatMode(2);
        this.O0000OoO.setInterpolator(O00000oO);
        this.O0000OoO.setDuration(1000);
        czj czj = new czj();
        if (!czj.O000000o(f5534O000000o)) {
            czj.O000000o(3, 3, 257, 79);
        }
        czj.O000000o(O00000Oo);
        czj czj2 = new czj();
        if (!czj2.O000000o(O00000o0)) {
            czj2.O000000o(-1, 1, 761, 121);
        }
        czj2.O000000o(O00000o);
        this.O00000oo = czj;
        this.O0000O0o = czj2;
        this.O00000oo.setBounds(0, 0, dao.O00000Oo(65.0f), dao.O00000Oo(20.0f));
        this.O0000O0o.setBounds(0, 0, dao.O00000Oo(260.0f), dao.O00000Oo(45.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.thPrimaryColor});
        int color = obtainStyledAttributes.getColor(0, 0);
        if (color != 0) {
            setBackgroundColor(color);
        } else {
            setBackgroundColor(-15614977);
        }
        obtainStyledAttributes.recycle();
    }

    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        this.O0000Oo0 = f;
        this.O0000Oo = i2;
        if (z) {
            this.O0000oOo = 0.0f;
        }
    }

    public final void O00000Oo(czx czx, int i, int i2) {
        this.O0000Ooo = true;
        this.O0000oOo = 0.0f;
        startAnimation(this.O0000OoO);
    }

    public final int O000000o(czx czx, boolean z) {
        clearAnimation();
        if (z) {
            startAnimation(new Animation() {
                /* class com.scwang.smartrefresh.header.TaurusHeader.AnonymousClass2 */

                {
                    super.setDuration(100);
                    super.setInterpolator(new AccelerateInterpolator());
                }

                /* access modifiers changed from: protected */
                public final void applyTransformation(float f, Transformation transformation) {
                    if (f == 1.0f) {
                        TaurusHeader.this.O0000Ooo = false;
                    }
                    TaurusHeader.this.O0000oOo = f;
                    this.invalidate();
                }
            });
            return 200;
        }
        this.O0000Ooo = false;
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        setBackgroundColor(iArr[0]);
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
        float f;
        float f2;
        boolean z;
        boolean z2;
        float f3;
        float O000000o2;
        float f4;
        float O000000o3;
        float O000000o4;
        float O000000o5;
        float O000000o6;
        float O000000o7;
        Canvas canvas2 = canvas;
        int width = getWidth();
        int height = getHeight();
        if (this.O0000Ooo) {
            while (this.O0000o0o.size() < 10) {
                double d = (double) this.O0000Oo;
                Double.isNaN(d);
                float random = (float) (d / (Math.random() * 5.0d));
                float O000000o8 = O000000o(1000, 2000);
                if (this.O0000o0o.size() <= 1) {
                    this.O0000o0o.put(Float.valueOf(random), Float.valueOf(O000000o8));
                    O000000o(canvas2, random, O000000o8, width);
                }
                while (true) {
                    random = 0.0f;
                    while (true) {
                        if (random != 0.0f) {
                            break;
                        }
                        double d2 = (double) this.O0000Oo;
                        Double.isNaN(d2);
                        float random2 = (float) (d2 / (Math.random() * 5.0d));
                        Iterator<Map.Entry<Float, Float>> it = this.O0000o0o.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (Math.abs(((Float) it.next().getKey()).floatValue() - random2) > ((float) (this.O0000Oo / 5))) {
                                    random = random2;
                                }
                            }
                        }
                    }
                }
                this.O0000o0o.put(Float.valueOf(random), Float.valueOf(O000000o8));
                O000000o(canvas2, random, O000000o8, width);
            }
            if (this.O0000o0o.size() >= 10) {
                for (Map.Entry next : this.O0000o0o.entrySet()) {
                    O000000o(canvas2, ((Float) next.getKey()).floatValue(), ((Float) next.getValue()).floatValue(), width);
                }
            }
            if (this.O0000oOO && this.O0000oO) {
                this.O0000o0o.clear();
                this.O0000oO = false;
                this.O0000oO0 = O000000o(50, 300);
            }
            this.O0000o0 = this.O0000o00;
        }
        Matrix matrix = this.O0000OOo;
        matrix.reset();
        float f5 = this.O0000Oo0;
        if (isInEditMode()) {
            this.O0000Oo = height;
            f5 = 1.0f;
        }
        if (f5 > 1.0f) {
            f = ((float) (1.0d - Math.pow(100.0d, (double) ((-(f5 - 1.0f)) / 2.0f)))) * 20.0f;
            f5 = 1.0f;
        } else {
            f = 0.0f;
        }
        float width2 = ((((float) width) * f5) / 2.0f) - ((float) (this.O00000oo.getBounds().width() / 2));
        float height2 = (((float) this.O0000Oo) * (1.0f - (f5 / 2.0f))) - ((float) (this.O00000oo.getBounds().height() / 2));
        float f6 = this.O0000oOo;
        if (f6 > 0.0f) {
            height2 += (0.0f - height2) * f6;
            width2 += (((float) (this.O00000oo.getBounds().width() + width)) - width2) * this.O0000oOo;
        }
        if (this.O0000Ooo) {
            if (O00000Oo(AnimationPart.FIRST)) {
                O000000o7 = O000000o(AnimationPart.FIRST);
            } else if (O00000Oo(AnimationPart.SECOND)) {
                O000000o7 = O000000o(AnimationPart.SECOND);
            } else {
                if (O00000Oo(AnimationPart.THIRD)) {
                    O000000o6 = O000000o(AnimationPart.THIRD);
                } else if (O00000Oo(AnimationPart.FOURTH)) {
                    O000000o6 = O000000o(AnimationPart.FOURTH);
                }
                height2 += O000000o6;
            }
            height2 -= O000000o7;
        }
        if (f > 0.0f) {
            matrix.postRotate(f, (float) (this.O00000oo.getBounds().width() / 2), (float) (this.O00000oo.getBounds().height() / 2));
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas2.translate(width2, height2);
        canvas2.concat(matrix);
        this.O00000oo.draw(canvas2);
        canvas2.restoreToCount(saveCount);
        Matrix matrix2 = this.O0000OOo;
        matrix2.reset();
        Drawable drawable = this.O0000O0o;
        float min = Math.min(1.0f, Math.abs(this.O0000Oo0));
        if (isInEditMode()) {
            this.O0000Oo = height;
            min = 1.0f;
        }
        float f7 = min - 0.5f;
        float f8 = 0.6f;
        if (f7 > 0.0f) {
            f8 = 0.6f + ((f7 / 0.5f) * 0.39999998f);
        }
        float f9 = ((float) this.O0000Oo) * (1.0f - min);
        float width3 = (float) (0 - (drawable.getBounds().width() / 2));
        float width4 = (float) (width - (drawable.getBounds().width() / 2));
        if (this.O0000Ooo) {
            if (O00000Oo(AnimationPart.FIRST)) {
                width3 -= (O000000o(AnimationPart.FIRST) * 2.0f) / 4.0f;
                O000000o5 = O000000o(AnimationPart.FIRST);
            } else if (O00000Oo(AnimationPart.SECOND)) {
                width3 -= (O000000o(AnimationPart.SECOND) * 2.0f) / 4.0f;
                O000000o5 = O000000o(AnimationPart.SECOND);
            } else if (O00000Oo(AnimationPart.THIRD)) {
                width3 -= O000000o(AnimationPart.THIRD) / 4.0f;
                O000000o5 = O000000o(AnimationPart.THIRD) * 2.0f;
            } else if (O00000Oo(AnimationPart.FOURTH)) {
                width3 -= O000000o(AnimationPart.FOURTH) / 2.0f;
                O000000o4 = (O000000o(AnimationPart.FOURTH) * 2.0f) / 4.0f;
                width4 += O000000o4;
            }
            O000000o4 = O000000o5 / 2.0f;
            width4 += O000000o4;
        }
        float f10 = (float) (height + 2);
        float height3 = (((float) drawable.getBounds().height()) * f8) + f9 < f10 ? f10 - (((float) drawable.getBounds().height()) * f8) : f9;
        if ((((float) drawable.getBounds().height()) * f8) + f9 < f10) {
            f9 = f10 - (((float) drawable.getBounds().height()) * f8);
        }
        int saveCount2 = canvas.getSaveCount();
        canvas.save();
        canvas2.translate(width3, height3);
        matrix2.postScale(f8, f8, (float) ((drawable.getBounds().width() * 3) / 4), (float) drawable.getBounds().height());
        canvas2.concat(matrix2);
        drawable.setAlpha(100);
        drawable.draw(canvas2);
        drawable.setAlpha(255);
        canvas2.restoreToCount(saveCount2);
        canvas.save();
        canvas2.translate(width4, f9);
        matrix2.postScale(f8, f8, 0.0f, (float) drawable.getBounds().height());
        canvas2.concat(matrix2);
        drawable.setAlpha(100);
        drawable.draw(canvas2);
        drawable.setAlpha(255);
        canvas2.restoreToCount(saveCount2);
        Matrix matrix3 = this.O0000OOo;
        matrix3.reset();
        float min2 = Math.min(1.0f, Math.abs(this.O0000Oo0));
        if (isInEditMode()) {
            this.O0000Oo = height;
            min2 = 1.0f;
        }
        float f11 = this.O0000Oo0;
        if (f11 > 1.0f) {
            f2 = Math.abs(1.0f - f11);
            z = true;
        } else {
            z = false;
            f2 = 0.0f;
        }
        float f12 = min2 - 0.5f;
        float f13 = 0.8f;
        if (f12 > 0.0f) {
            f13 = 0.8f + ((f12 / 0.5f) * 0.19999999f);
        }
        int i = this.O0000Oo;
        float f14 = ((float) i) * min2;
        float height4 = (float) (i - (this.O0000O0o.getBounds().height() / 2));
        if (f14 > height4) {
            f3 = f14 - height4;
            z2 = true;
        } else {
            f3 = 0.0f;
            z2 = false;
        }
        float width5 = (float) ((width / 2) - (this.O0000O0o.getBounds().width() / 2));
        float height5 = f14 - (z2 ? ((float) (this.O0000O0o.getBounds().height() / 2)) + f3 : (float) (this.O0000O0o.getBounds().height() / 2));
        float f15 = z ? (f2 / 4.0f) + f13 : f13;
        float f16 = z ? (f2 / 2.0f) + f13 : f13;
        if (this.O0000Ooo && !z) {
            if (O00000Oo(AnimationPart.FIRST)) {
                O000000o3 = O000000o(AnimationPart.FIRST);
            } else if (O00000Oo(AnimationPart.SECOND)) {
                O000000o3 = O000000o(AnimationPart.SECOND);
            } else {
                if (O00000Oo(AnimationPart.THIRD)) {
                    O000000o2 = O000000o(AnimationPart.THIRD);
                } else {
                    if (O00000Oo(AnimationPart.FOURTH)) {
                        O000000o2 = O000000o(AnimationPart.FOURTH);
                    }
                    f16 = f15;
                }
                f4 = f13 + ((O000000o2 / 80.0f) / 6.0f);
                f15 = f4;
                f16 = f15;
            }
            f4 = f13 - ((O000000o3 / 80.0f) / 8.0f);
            f15 = f4;
            f16 = f15;
        }
        matrix3.postScale(f15, f16, (float) (this.O0000O0o.getBounds().width() / 2), 0.0f);
        if ((((float) this.O0000O0o.getBounds().height()) * f16) + height5 < f10) {
            height5 = f10 - (f16 * ((float) this.O0000O0o.getBounds().height()));
        }
        int saveCount3 = canvas.getSaveCount();
        canvas.save();
        canvas2.translate(width5, height5);
        canvas2.concat(matrix3);
        this.O0000O0o.draw(canvas2);
        canvas2.restoreToCount(saveCount3);
        super.dispatchDraw(canvas);
    }

    private void O000000o(Canvas canvas, float f, float f2, int i) {
        float f3 = (float) i;
        float f4 = (f3 + f2) / 13.0f;
        float f5 = this.O0000o00;
        if (this.O0000o0 - f5 > 0.0f) {
            this.O0000oOO = true;
            f5 = 13.0f - f5;
        } else {
            this.O0000oO = true;
            this.O0000oOO = false;
        }
        float f6 = (f3 - (f5 * f4)) + f2;
        float f7 = this.O0000oO0;
        float f8 = f6 - f7;
        canvas.drawLine(f8, f, f8 + f7, f, this.O0000o);
    }

    private float O000000o(int i, int i2) {
        return (float) (this.O0000o0O.nextInt((i2 - i) + 1) + i);
    }

    /* renamed from: com.scwang.smartrefresh.header.TaurusHeader$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5537O000000o = new int[AnimationPart.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f5537O000000o[AnimationPart.FIRST.ordinal()] = 1;
            f5537O000000o[AnimationPart.SECOND.ordinal()] = 2;
            f5537O000000o[AnimationPart.THIRD.ordinal()] = 3;
            try {
                f5537O000000o[AnimationPart.FOURTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private float O000000o(AnimationPart animationPart) {
        float O00000o02;
        float f;
        int O00000o03;
        float f2;
        int i = AnonymousClass3.f5537O000000o[animationPart.ordinal()];
        if (i == 1) {
            return this.O0000o00;
        }
        if (i == 2) {
            O00000o02 = (float) O00000o0(AnimationPart.FOURTH);
            f = this.O0000o00;
            O00000o03 = O00000o0(AnimationPart.FOURTH);
        } else if (i == 3) {
            O00000o02 = this.O0000o00;
            f2 = (float) O00000o0(AnimationPart.SECOND);
            return O00000o02 - f2;
        } else if (i != 4) {
            return 0.0f;
        } else {
            O00000o02 = (float) O00000o0(AnimationPart.THIRD);
            f = this.O0000o00;
            O00000o03 = O00000o0(AnimationPart.FOURTH);
        }
        f2 = f - ((float) O00000o03);
        return O00000o02 - f2;
    }

    private boolean O00000Oo(AnimationPart animationPart) {
        int i = AnonymousClass3.f5537O000000o[animationPart.ordinal()];
        return i != 1 ? (i == 2 || i == 3) ? this.O0000o00 < ((float) O00000o0(animationPart)) : i == 4 && this.O0000o00 > ((float) O00000o0(AnimationPart.THIRD)) : this.O0000o00 < ((float) O00000o0(AnimationPart.FOURTH));
    }

    private int O00000o0(AnimationPart animationPart) {
        int i = AnonymousClass3.f5537O000000o[animationPart.ordinal()];
        if (i == 2) {
            return 40;
        }
        if (i != 3) {
            return i != 4 ? 0 : 20;
        }
        return O00000o0(AnimationPart.FOURTH) * 3;
    }
}
