package _m_j;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;
import java.util.List;

public final class czh extends Drawable implements Animatable {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Interpolator f14402O000000o = new eo();
    private static final Interpolator O00000o = new LinearInterpolator();
    private static final int[] O00000oO = {-16777216};
    float O00000Oo;
    boolean O00000o0;
    private final List<Animation> O00000oo = new ArrayList();
    private final O000000o O0000O0o = new O000000o();
    private float O0000OOo;
    private Animation O0000Oo;
    private View O0000Oo0;
    private float O0000OoO;
    private float O0000Ooo;

    public final int getOpacity() {
        return -3;
    }

    public czh(View view) {
        this.O0000Oo0 = view;
        O000000o(O00000oO);
        O000000o(1);
        final O000000o o000000o = this.O0000O0o;
        AnonymousClass1 r1 = new Animation() {
            /* class _m_j.czh.AnonymousClass1 */

            public final void applyTransformation(float f, Transformation transformation) {
                if (czh.this.O00000o0) {
                    czh czh = czh.this;
                    O000000o o000000o = o000000o;
                    czh.O000000o(f, o000000o);
                    float floor = (float) (Math.floor((double) (o000000o.O0000o00 / 0.8f)) + 1.0d);
                    czh.O000000o(o000000o.O0000OoO + (((o000000o.O0000Ooo - czh.O000000o(o000000o)) - o000000o.O0000OoO) * f), o000000o.O0000Ooo);
                    czh.O00000Oo(o000000o.O0000o00 + ((floor - o000000o.O0000o00) * f));
                    return;
                }
                float O000000o2 = czh.O000000o(o000000o);
                float f2 = o000000o.O0000Ooo;
                float f3 = o000000o.O0000OoO;
                float f4 = o000000o.O0000o00;
                czh.O000000o(f, o000000o);
                if (f <= 0.5f) {
                    o000000o.O00000o = f3 + ((0.8f - O000000o2) * czh.f14402O000000o.getInterpolation(f / 0.5f));
                }
                if (f > 0.5f) {
                    o000000o.O00000oO = f2 + ((0.8f - O000000o2) * czh.f14402O000000o.getInterpolation((f - 0.5f) / 0.5f));
                }
                czh.this.O00000Oo(f4 + (0.25f * f));
                czh.this.O00000o0((f * 216.0f) + ((czh.this.O00000Oo / 5.0f) * 1080.0f));
            }
        };
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(O00000o);
        r1.setAnimationListener(new Animation.AnimationListener() {
            /* class _m_j.czh.AnonymousClass2 */

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                czh.this.O00000Oo = 0.0f;
            }

            public final void onAnimationRepeat(Animation animation) {
                o000000o.O00000Oo();
                O000000o o000000o = o000000o;
                o000000o.O000000o(o000000o.O000000o());
                O000000o o000000o2 = o000000o;
                o000000o2.O00000o = o000000o2.O00000oO;
                if (czh.this.O00000o0) {
                    czh.this.O00000o0 = false;
                    animation.setDuration(1332);
                    czh.this.O000000o(false);
                    return;
                }
                czh czh = czh.this;
                czh.O00000Oo = (czh.O00000Oo + 1.0f) % 5.0f;
            }
        });
        this.O0000Oo = r1;
    }

    private void O000000o(int i, int i2, float f, float f2, float f3, float f4) {
        double d;
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        this.O0000OoO = ((float) i) * f5;
        this.O0000Ooo = ((float) i2) * f5;
        this.O0000O0o.O000000o(0);
        float f6 = f2 * f5;
        this.O0000O0o.O00000Oo.setStrokeWidth(f6);
        O000000o o000000o = this.O0000O0o;
        o000000o.O0000O0o = f6;
        o000000o.O0000o = (double) (f * f5);
        o000000o.O0000oO0 = (int) (f3 * f5);
        o000000o.O0000oO = (int) (f4 * f5);
        float min = (float) Math.min((int) this.O0000OoO, (int) this.O0000Ooo);
        if (o000000o.O0000o <= 0.0d || min < 0.0f) {
            d = Math.ceil((double) (o000000o.O0000O0o / 2.0f));
        } else {
            double d2 = (double) (min / 2.0f);
            double d3 = o000000o.O0000o;
            Double.isNaN(d2);
            d = d2 - d3;
        }
        o000000o.O0000OOo = (float) d;
        invalidateSelf();
    }

    public final void O000000o(int i) {
        if (i == 0) {
            O000000o(56, 56, 12.5f, 3.0f, 12.0f, 6.0f);
        } else {
            O000000o(40, 40, 8.75f, 2.5f, 10.0f, 5.0f);
        }
    }

    public final void O000000o(boolean z) {
        if (this.O0000O0o.O0000o0 != z) {
            this.O0000O0o.O0000o0 = z;
            invalidateSelf();
        }
    }

    public final void O000000o(float f) {
        if (this.O0000O0o.O0000o0o != f) {
            this.O0000O0o.O0000o0o = f;
            invalidateSelf();
        }
    }

    public final void O000000o(float f, float f2) {
        O000000o o000000o = this.O0000O0o;
        o000000o.O00000o = f;
        o000000o.O00000oO = f2;
        invalidateSelf();
    }

    public final void O00000Oo(float f) {
        this.O0000O0o.O00000oo = f;
        invalidateSelf();
    }

    public final void O00000Oo(int i) {
        this.O0000O0o.O0000oo0 = i;
    }

    public final void O000000o(int... iArr) {
        O000000o o000000o = this.O0000O0o;
        o000000o.O0000Oo0 = iArr;
        o000000o.O000000o(0);
    }

    public final int getIntrinsicHeight() {
        return (int) this.O0000Ooo;
    }

    public final int getIntrinsicWidth() {
        return (int) this.O0000OoO;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.O0000OOo, bounds.exactCenterX(), bounds.exactCenterY());
        O000000o o000000o = this.O0000O0o;
        RectF rectF = o000000o.f14405O000000o;
        rectF.set(bounds);
        rectF.inset(o000000o.O0000OOo, o000000o.O0000OOo);
        float f = (o000000o.O00000o + o000000o.O00000oo) * 360.0f;
        float f2 = ((o000000o.O00000oO + o000000o.O00000oo) * 360.0f) - f;
        if (f2 != 0.0f) {
            o000000o.O00000Oo.setColor(o000000o.O0000oo);
            canvas.drawArc(rectF, f, f2, false, o000000o.O00000Oo);
        }
        if (o000000o.O0000o0) {
            if (o000000o.O0000o0O == null) {
                o000000o.O0000o0O = new Path();
                o000000o.O0000o0O.setFillType(Path.FillType.EVEN_ODD);
            } else {
                o000000o.O0000o0O.reset();
            }
            float f3 = ((float) (((int) o000000o.O0000OOo) / 2)) * o000000o.O0000o0o;
            double cos = o000000o.O0000o * Math.cos(0.0d);
            double exactCenterX = (double) bounds.exactCenterX();
            Double.isNaN(exactCenterX);
            double sin = o000000o.O0000o * Math.sin(0.0d);
            double exactCenterY = (double) bounds.exactCenterY();
            Double.isNaN(exactCenterY);
            o000000o.O0000o0O.moveTo(0.0f, 0.0f);
            o000000o.O0000o0O.lineTo(((float) o000000o.O0000oO0) * o000000o.O0000o0o, 0.0f);
            o000000o.O0000o0O.lineTo((((float) o000000o.O0000oO0) * o000000o.O0000o0o) / 2.0f, ((float) o000000o.O0000oO) * o000000o.O0000o0o);
            o000000o.O0000o0O.offset(((float) (cos + exactCenterX)) - f3, (float) (sin + exactCenterY));
            o000000o.O0000o0O.close();
            o000000o.O00000o0.setColor(o000000o.O0000oo);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(o000000o.O0000o0O, o000000o.O00000o0);
        }
        if (o000000o.O0000oOO < 255) {
            o000000o.O0000oOo.setColor(o000000o.O0000oo0);
            o000000o.O0000oOo.setAlpha(255 - o000000o.O0000oOO);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), o000000o.O0000oOo);
        }
        canvas.restoreToCount(save);
    }

    public final void setAlpha(int i) {
        this.O0000O0o.O0000oOO = i;
    }

    public final int getAlpha() {
        return this.O0000O0o.O0000oOO;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.O0000O0o.O00000Oo.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(float f) {
        this.O0000OOo = f;
        invalidateSelf();
    }

    public final boolean isRunning() {
        List<Animation> list = this.O00000oo;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animation animation = list.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        this.O0000Oo.reset();
        this.O0000O0o.O00000Oo();
        if (this.O0000O0o.O00000oO != this.O0000O0o.O00000o) {
            this.O00000o0 = true;
            this.O0000Oo.setDuration(666);
            this.O0000Oo0.startAnimation(this.O0000Oo);
            return;
        }
        this.O0000O0o.O000000o(0);
        this.O0000O0o.O00000o0();
        this.O0000Oo.setDuration(1332);
        this.O0000Oo0.startAnimation(this.O0000Oo);
    }

    public final void stop() {
        this.O0000Oo0.clearAnimation();
        this.O0000O0o.O000000o(0);
        this.O0000O0o.O00000o0();
        O000000o(false);
        O00000o0(0.0f);
    }

    static float O000000o(O000000o o000000o) {
        double d = (double) o000000o.O0000O0o;
        Double.isNaN(d);
        return (float) Math.toRadians(d / (o000000o.O0000o * 6.283185307179586d));
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final RectF f14405O000000o = new RectF();
        final Paint O00000Oo = new Paint();
        float O00000o = 0.0f;
        final Paint O00000o0 = new Paint();
        float O00000oO = 0.0f;
        float O00000oo = 0.0f;
        float O0000O0o = 5.0f;
        float O0000OOo = 2.5f;
        int O0000Oo;
        int[] O0000Oo0;
        float O0000OoO;
        float O0000Ooo;
        double O0000o;
        boolean O0000o0;
        float O0000o00;
        Path O0000o0O;
        float O0000o0o;
        int O0000oO;
        int O0000oO0;
        int O0000oOO;
        final Paint O0000oOo = new Paint(1);
        int O0000oo;
        int O0000oo0;

        O000000o() {
            this.O00000Oo.setStrokeCap(Paint.Cap.SQUARE);
            this.O00000Oo.setAntiAlias(true);
            this.O00000Oo.setStyle(Paint.Style.STROKE);
            this.O00000o0.setStyle(Paint.Style.FILL);
            this.O00000o0.setAntiAlias(true);
        }

        public final void O000000o(int i) {
            this.O0000Oo = i;
            this.O0000oo = this.O0000Oo0[this.O0000Oo];
        }

        /* access modifiers changed from: package-private */
        public final int O000000o() {
            return (this.O0000Oo + 1) % this.O0000Oo0.length;
        }

        public final void O00000Oo() {
            this.O0000OoO = this.O00000o;
            this.O0000Ooo = this.O00000oO;
            this.O0000o00 = this.O00000oo;
        }

        public final void O00000o0() {
            this.O0000OoO = 0.0f;
            this.O0000Ooo = 0.0f;
            this.O0000o00 = 0.0f;
            this.O00000o = 0.0f;
            this.O00000oO = 0.0f;
            this.O00000oo = 0.0f;
        }
    }

    static void O000000o(float f, O000000o o000000o) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int i = o000000o.O0000Oo0[o000000o.O0000Oo];
            int i2 = o000000o.O0000Oo0[o000000o.O000000o()];
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            int i6 = i & 255;
            o000000o.O0000oo = ((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f2))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f2))) << 16) | ((i5 + ((int) (((float) (((i2 >> 8) & 255) - i5)) * f2))) << 8) | (i6 + ((int) (f2 * ((float) ((i2 & 255) - i6)))));
        }
    }
}
