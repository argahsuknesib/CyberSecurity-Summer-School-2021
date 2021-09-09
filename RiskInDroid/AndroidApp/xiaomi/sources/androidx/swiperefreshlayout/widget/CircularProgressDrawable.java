package androidx.swiperefreshlayout.widget;

import _m_j.bf;
import _m_j.eo;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator O00000o = new LinearInterpolator();
    private static final Interpolator O00000oO = new eo();
    private static final int[] O00000oo = {-16777216};

    /* renamed from: O000000o  reason: collision with root package name */
    final O000000o f2981O000000o = new O000000o();
    float O00000Oo;
    boolean O00000o0;
    private float O0000O0o;
    private Resources O0000OOo;
    private Animator O0000Oo0;

    public int getOpacity() {
        return -3;
    }

    public CircularProgressDrawable(Context context) {
        this.O0000OOo = ((Context) bf.O000000o(context)).getResources();
        this.f2981O000000o.O000000o(O00000oo);
        this.f2981O000000o.O000000o(2.5f);
        invalidateSelf();
        final O000000o o000000o = this.f2981O000000o;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class androidx.swiperefreshlayout.widget.CircularProgressDrawable.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.O000000o(floatValue, o000000o);
                CircularProgressDrawable.this.O000000o(floatValue, o000000o, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(O00000o);
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class androidx.swiperefreshlayout.widget.CircularProgressDrawable.AnonymousClass2 */

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.O00000Oo = 0.0f;
            }

            public final void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.O000000o(1.0f, o000000o, true);
                o000000o.O00000o0();
                O000000o o000000o = o000000o;
                o000000o.O000000o(o000000o.O000000o());
                if (CircularProgressDrawable.this.O00000o0) {
                    CircularProgressDrawable.this.O00000o0 = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    o000000o.O000000o(false);
                    return;
                }
                CircularProgressDrawable.this.O00000Oo += 1.0f;
            }
        });
        this.O0000Oo0 = ofFloat;
    }

    private void O000000o(float f, float f2, float f3, float f4) {
        O000000o o000000o = this.f2981O000000o;
        float f5 = this.O0000OOo.getDisplayMetrics().density;
        o000000o.O000000o(f2 * f5);
        o000000o.O0000o = f * f5;
        o000000o.O000000o(0);
        o000000o.O0000oO0 = (int) (f3 * f5);
        o000000o.O0000oO = (int) (f4 * f5);
    }

    public final void O000000o(int i) {
        if (i == 0) {
            O000000o(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            O000000o(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void O000000o(boolean z) {
        this.f2981O000000o.O000000o(z);
        invalidateSelf();
    }

    public final void O000000o(float f) {
        O000000o o000000o = this.f2981O000000o;
        if (f != o000000o.O0000o0o) {
            o000000o.O0000o0o = f;
        }
        invalidateSelf();
    }

    public final void O00000Oo(float f) {
        O000000o o000000o = this.f2981O000000o;
        o000000o.O00000oO = 0.0f;
        o000000o.O00000oo = f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.O0000O0o, bounds.exactCenterX(), bounds.exactCenterY());
        O000000o o000000o = this.f2981O000000o;
        RectF rectF = o000000o.f2984O000000o;
        float f = o000000o.O0000o + (o000000o.O0000OOo / 2.0f);
        if (o000000o.O0000o <= 0.0f) {
            f = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) o000000o.O0000oO0) * o000000o.O0000o0o) / 2.0f, o000000o.O0000OOo / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f, ((float) bounds.centerY()) - f, ((float) bounds.centerX()) + f, ((float) bounds.centerY()) + f);
        float f2 = (o000000o.O00000oO + o000000o.O0000O0o) * 360.0f;
        float f3 = ((o000000o.O00000oo + o000000o.O0000O0o) * 360.0f) - f2;
        o000000o.O00000Oo.setColor(o000000o.O0000oOo);
        o000000o.O00000Oo.setAlpha(o000000o.O0000oOO);
        float f4 = o000000o.O0000OOo / 2.0f;
        rectF.inset(f4, f4);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, o000000o.O00000o);
        float f5 = -f4;
        rectF.inset(f5, f5);
        canvas.drawArc(rectF, f2, f3, false, o000000o.O00000Oo);
        if (o000000o.O0000o0) {
            if (o000000o.O0000o0O == null) {
                o000000o.O0000o0O = new Path();
                o000000o.O0000o0O.setFillType(Path.FillType.EVEN_ODD);
            } else {
                o000000o.O0000o0O.reset();
            }
            o000000o.O0000o0O.moveTo(0.0f, 0.0f);
            o000000o.O0000o0O.lineTo(((float) o000000o.O0000oO0) * o000000o.O0000o0o, 0.0f);
            o000000o.O0000o0O.lineTo((((float) o000000o.O0000oO0) * o000000o.O0000o0o) / 2.0f, ((float) o000000o.O0000oO) * o000000o.O0000o0o);
            o000000o.O0000o0O.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) o000000o.O0000oO0) * o000000o.O0000o0o) / 2.0f), rectF.centerY() + (o000000o.O0000OOo / 2.0f));
            o000000o.O0000o0O.close();
            o000000o.O00000o0.setColor(o000000o.O0000oOo);
            o000000o.O00000o0.setAlpha(o000000o.O0000oOO);
            canvas.save();
            canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
            canvas.drawPath(o000000o.O0000o0O, o000000o.O00000o0);
            canvas.restore();
        }
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.f2981O000000o.O0000oOO = i;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f2981O000000o.O0000oOO;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2981O000000o.O00000Oo.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.O0000Oo0.isRunning();
    }

    public void start() {
        this.O0000Oo0.cancel();
        this.f2981O000000o.O00000o0();
        if (this.f2981O000000o.O00000oo != this.f2981O000000o.O00000oO) {
            this.O00000o0 = true;
            this.O0000Oo0.setDuration(666);
            this.O0000Oo0.start();
            return;
        }
        this.f2981O000000o.O000000o(0);
        this.f2981O000000o.O00000o();
        this.O0000Oo0.setDuration(1332);
        this.O0000Oo0.start();
    }

    public void stop() {
        this.O0000Oo0.cancel();
        this.O0000O0o = 0.0f;
        this.f2981O000000o.O000000o(false);
        this.f2981O000000o.O000000o(0);
        this.f2981O000000o.O00000o();
        invalidateSelf();
    }

    static void O000000o(float f, O000000o o000000o) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int O00000Oo2 = o000000o.O00000Oo();
            int i = o000000o.O0000Oo0[o000000o.O000000o()];
            int i2 = (O00000Oo2 >> 24) & 255;
            int i3 = (O00000Oo2 >> 16) & 255;
            int i4 = (O00000Oo2 >> 8) & 255;
            int i5 = O00000Oo2 & 255;
            o000000o.O0000oOo = ((i2 + ((int) (((float) (((i >> 24) & 255) - i2)) * f2))) << 24) | ((i3 + ((int) (((float) (((i >> 16) & 255) - i3)) * f2))) << 16) | ((i4 + ((int) (((float) (((i >> 8) & 255) - i4)) * f2))) << 8) | (i5 + ((int) (f2 * ((float) ((i & 255) - i5)))));
            return;
        }
        o000000o.O0000oOo = o000000o.O00000Oo();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(float f, O000000o o000000o, boolean z) {
        float f2;
        float f3;
        if (this.O00000o0) {
            O000000o(f, o000000o);
            float floor = (float) (Math.floor((double) (o000000o.O0000o00 / 0.8f)) + 1.0d);
            o000000o.O00000oO = o000000o.O0000OoO + (((o000000o.O0000Ooo - 0.01f) - o000000o.O0000OoO) * f);
            o000000o.O00000oo = o000000o.O0000Ooo;
            o000000o.O0000O0o = o000000o.O0000o00 + ((floor - o000000o.O0000o00) * f);
        } else if (f != 1.0f || z) {
            float f4 = o000000o.O0000o00;
            if (f < 0.5f) {
                float f5 = o000000o.O0000OoO;
                float f6 = f5;
                f2 = (O00000oO.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + f5;
                f3 = f6;
            } else {
                f2 = o000000o.O0000OoO + 0.79f;
                f3 = f2 - (((1.0f - O00000oO.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            o000000o.O00000oO = f3;
            o000000o.O00000oo = f2;
            o000000o.O0000O0o = f4 + (0.20999998f * f);
            this.O0000O0o = (f + this.O00000Oo) * 216.0f;
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final RectF f2984O000000o = new RectF();
        final Paint O00000Oo = new Paint();
        final Paint O00000o = new Paint();
        final Paint O00000o0 = new Paint();
        float O00000oO = 0.0f;
        float O00000oo = 0.0f;
        float O0000O0o = 0.0f;
        float O0000OOo = 5.0f;
        int O0000Oo;
        int[] O0000Oo0;
        float O0000OoO;
        float O0000Ooo;
        float O0000o;
        boolean O0000o0;
        float O0000o00;
        Path O0000o0O;
        float O0000o0o = 1.0f;
        int O0000oO;
        int O0000oO0;
        int O0000oOO = 255;
        int O0000oOo;

        O000000o() {
            this.O00000Oo.setStrokeCap(Paint.Cap.SQUARE);
            this.O00000Oo.setAntiAlias(true);
            this.O00000Oo.setStyle(Paint.Style.STROKE);
            this.O00000o0.setStyle(Paint.Style.FILL);
            this.O00000o0.setAntiAlias(true);
            this.O00000o.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int[] iArr) {
            this.O0000Oo0 = iArr;
            O000000o(0);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i) {
            this.O0000Oo = i;
            this.O0000oOo = this.O0000Oo0[this.O0000Oo];
        }

        /* access modifiers changed from: package-private */
        public final int O000000o() {
            return (this.O0000Oo + 1) % this.O0000Oo0.length;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(float f) {
            this.O0000OOo = f;
            this.O00000Oo.setStrokeWidth(f);
        }

        /* access modifiers changed from: package-private */
        public final int O00000Oo() {
            return this.O0000Oo0[this.O0000Oo];
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(boolean z) {
            if (this.O0000o0 != z) {
                this.O0000o0 = z;
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000o0() {
            this.O0000OoO = this.O00000oO;
            this.O0000Ooo = this.O00000oo;
            this.O0000o00 = this.O0000O0o;
        }

        /* access modifiers changed from: package-private */
        public final void O00000o() {
            this.O0000OoO = 0.0f;
            this.O0000Ooo = 0.0f;
            this.O0000o00 = 0.0f;
            this.O00000oO = 0.0f;
            this.O00000oo = 0.0f;
            this.O0000O0o = 0.0f;
        }
    }
}
