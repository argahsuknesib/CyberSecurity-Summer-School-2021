package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

public final class cci extends Drawable implements Animatable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Interpolator f13621O000000o = new O000000o((byte) 0);
    public static final Interpolator O00000Oo = new O00000o((byte) 0);
    private static final Interpolator O0000O0o = new LinearInterpolator();
    private static final Interpolator O0000OOo = new AccelerateDecelerateInterpolator();
    public View O00000o;
    public final O00000o0 O00000o0;
    public Animation O00000oO;
    public float O00000oo;
    private final ArrayList<Animation> O0000Oo = new ArrayList<>();
    private final int[] O0000Oo0 = {-3591113, -13149199, -536002, -13327536};
    private final Drawable.Callback O0000OoO = new Drawable.Callback() {
        /* class _m_j.cci.AnonymousClass1 */

        public final void invalidateDrawable(Drawable drawable) {
            cci.this.invalidateSelf();
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            cci.this.scheduleSelf(runnable, j);
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            cci.this.unscheduleSelf(runnable);
        }
    };
    private float O0000Ooo;
    private int O0000o;
    private double O0000o0;
    private Resources O0000o00;
    private double O0000o0O;
    private Animation O0000o0o;
    private ShapeDrawable O0000oO0;

    public final int getOpacity() {
        return -3;
    }

    public cci(Context context, View view) {
        double d;
        this.O00000o = view;
        this.O0000o00 = context.getResources();
        this.O00000o0 = new O00000o0(this.O0000OoO);
        this.O00000o0.O000000o(this.O0000Oo0);
        O00000o0 o00000o0 = this.O00000o0;
        float f = this.O0000o00.getDisplayMetrics().density;
        double d2 = (double) f;
        Double.isNaN(d2);
        double d3 = 40.0d * d2;
        this.O0000o0 = d3;
        this.O0000o0O = d3;
        float f2 = 2.5f * f;
        o00000o0.O0000OOo = f2;
        o00000o0.O00000Oo.setStrokeWidth(f2);
        o00000o0.O00000o();
        Double.isNaN(d2);
        o00000o0.O0000oO0 = d2 * 8.75d;
        o00000o0.O0000OoO = 0;
        o00000o0.O0000oO = (int) (10.0f * f);
        o00000o0.O0000oOO = (int) (f * 5.0f);
        float min = (float) Math.min((int) this.O0000o0, (int) this.O0000o0O);
        if (o00000o0.O0000oO0 <= 0.0d || min < 0.0f) {
            d = Math.ceil((double) (o00000o0.O0000OOo / 2.0f));
        } else {
            double d4 = (double) (min / 2.0f);
            double d5 = o00000o0.O0000oO0;
            Double.isNaN(d4);
            d = d4 - d5;
        }
        o00000o0.O0000Oo0 = (float) d;
        double d6 = this.O0000o0;
        int O000000o2 = cck.O000000o(1.75f);
        int O000000o3 = cck.O000000o(0.0f);
        int O000000o4 = cck.O000000o(3.5f);
        this.O0000oO0 = new ShapeDrawable(new O00000Oo(O000000o4, (int) d6));
        if (Build.VERSION.SDK_INT >= 11) {
            this.O00000o.setLayerType(1, this.O0000oO0.getPaint());
        }
        this.O0000oO0.getPaint().setShadowLayer((float) O000000o4, (float) O000000o3, (float) O000000o2, 503316480);
        final O00000o0 o00000o02 = this.O00000o0;
        AnonymousClass2 r9 = new Animation() {
            /* class _m_j.cci.AnonymousClass2 */

            public final void applyTransformation(float f, Transformation transformation) {
                float floor = (float) (Math.floor((double) (o00000o02.O0000o0 / 0.8f)) + 1.0d);
                o00000o02.O000000o(o00000o02.O0000Ooo + ((o00000o02.O0000o00 - o00000o02.O0000Ooo) * f));
                o00000o02.O00000o0(o00000o02.O0000o0 + ((floor - o00000o02.O0000o0) * f));
                o00000o02.O00000o(1.0f - f);
            }
        };
        r9.setInterpolator(O0000OOo);
        r9.setDuration(666);
        r9.setAnimationListener(new Animation.AnimationListener() {
            /* class _m_j.cci.AnonymousClass3 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                o00000o02.O000000o();
                o00000o02.O00000Oo();
                o00000o02.O000000o(false);
                cci.this.O00000o.startAnimation(cci.this.O00000oO);
            }
        });
        AnonymousClass4 r0 = new Animation() {
            /* class _m_j.cci.AnonymousClass4 */

            public final void applyTransformation(float f, Transformation transformation) {
                double d = (double) o00000o02.O0000OOo;
                Double.isNaN(d);
                float radians = (float) Math.toRadians(d / (o00000o02.O0000oO0 * 6.283185307179586d));
                float f2 = o00000o02.O0000o00;
                float f3 = o00000o02.O0000Ooo;
                float f4 = o00000o02.O0000o0;
                o00000o02.O00000Oo(f2 + ((0.8f - radians) * cci.O00000Oo.getInterpolation(f)));
                o00000o02.O000000o(f3 + (cci.f13621O000000o.getInterpolation(f) * 0.8f));
                o00000o02.O00000o0(f4 + (0.25f * f));
                cci.this.O000000o((f * 144.0f) + ((cci.this.O00000oo / 5.0f) * 720.0f));
            }
        };
        r0.setRepeatCount(-1);
        r0.setRepeatMode(1);
        r0.setInterpolator(O0000O0o);
        r0.setDuration(1333);
        r0.setAnimationListener(new Animation.AnimationListener() {
            /* class _m_j.cci.AnonymousClass5 */

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                cci.this.O00000oo = 0.0f;
            }

            public final void onAnimationRepeat(Animation animation) {
                o00000o02.O00000Oo();
                o00000o02.O000000o();
                O00000o0 o00000o0 = o00000o02;
                o00000o0.O000000o(o00000o0.O00000oo);
                cci cci = cci.this;
                cci.O00000oo = (cci.O00000oo + 1.0f) % 5.0f;
            }
        });
        this.O0000o0o = r9;
        this.O00000oO = r0;
    }

    public final void O000000o() {
        this.O0000o = -1;
        this.O00000o0.O0000oo0 = -1;
    }

    public final int getIntrinsicHeight() {
        return (int) this.O0000o0O;
    }

    public final int getIntrinsicWidth() {
        return (int) this.O0000o0;
    }

    public final void draw(Canvas canvas) {
        ShapeDrawable shapeDrawable = this.O0000oO0;
        if (shapeDrawable != null) {
            shapeDrawable.getPaint().setColor(this.O0000o);
            this.O0000oO0.draw(canvas);
        }
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.O0000Ooo, bounds.exactCenterX(), bounds.exactCenterY());
        O00000o0 o00000o0 = this.O00000o0;
        o00000o0.O00000o.setColor(o00000o0.O0000oo0);
        o00000o0.O00000o.setAlpha(o00000o0.O0000oOo);
        canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), o00000o0.O00000o);
        RectF rectF = o00000o0.f13628O000000o;
        rectF.set(bounds);
        rectF.inset(o00000o0.O0000Oo0, o00000o0.O0000Oo0);
        float f = (o00000o0.O00000oO + o00000o0.O0000O0o) * 360.0f;
        float f2 = ((o00000o0.O00000oo + o00000o0.O0000O0o) * 360.0f) - f;
        o00000o0.O00000Oo.setColor(o00000o0.O0000Oo[o00000o0.O0000OoO]);
        o00000o0.O00000Oo.setAlpha(o00000o0.O0000oOo);
        canvas.drawArc(rectF, f, f2, false, o00000o0.O00000Oo);
        if (o00000o0.O0000o0O) {
            if (o00000o0.O0000o0o == null) {
                o00000o0.O0000o0o = new Path();
                o00000o0.O0000o0o.setFillType(Path.FillType.EVEN_ODD);
            } else {
                o00000o0.O0000o0o.reset();
            }
            float f3 = ((float) (((int) o00000o0.O0000Oo0) / 2)) * o00000o0.O0000o;
            double cos = o00000o0.O0000oO0 * Math.cos(0.0d);
            double exactCenterX = (double) bounds.exactCenterX();
            Double.isNaN(exactCenterX);
            double sin = o00000o0.O0000oO0 * Math.sin(0.0d);
            double exactCenterY = (double) bounds.exactCenterY();
            Double.isNaN(exactCenterY);
            o00000o0.O0000o0o.moveTo(0.0f, 0.0f);
            o00000o0.O0000o0o.lineTo(((float) o00000o0.O0000oO) * o00000o0.O0000o, 0.0f);
            o00000o0.O0000o0o.lineTo((((float) o00000o0.O0000oO) * o00000o0.O0000o) / 2.0f, ((float) o00000o0.O0000oOO) * o00000o0.O0000o);
            o00000o0.O0000o0o.offset(((float) (cos + exactCenterX)) - f3, (float) (sin + exactCenterY));
            o00000o0.O0000o0o.close();
            o00000o0.O00000o0.setColor(o00000o0.O0000Oo[o00000o0.O0000OoO]);
            o00000o0.O00000o0.setAlpha(o00000o0.O0000oOo);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(o00000o0.O0000o0o, o00000o0.O00000o0);
        }
        canvas.restoreToCount(save);
    }

    public final int getAlpha() {
        return this.O00000o0.O0000oOo;
    }

    public final void setAlpha(int i) {
        this.O00000o0.O0000oOo = i;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        O00000o0 o00000o0 = this.O00000o0;
        o00000o0.O00000Oo.setColorFilter(colorFilter);
        o00000o0.O00000o();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(float f) {
        this.O0000Ooo = f;
        invalidateSelf();
    }

    public final boolean isRunning() {
        ArrayList<Animation> arrayList = this.O0000Oo;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        this.O00000oO.reset();
        this.O00000o0.O00000Oo();
        if (this.O00000o0.O00000oo != this.O00000o0.O00000oO) {
            this.O00000o.startAnimation(this.O0000o0o);
            return;
        }
        O00000o0 o00000o0 = this.O00000o0;
        o00000o0.O0000OoO = 0;
        o00000o0.O00000o0();
        this.O00000o.startAnimation(this.O00000oO);
    }

    public final void stop() {
        this.O00000o.clearAnimation();
        O000000o(0.0f);
        this.O00000o0.O000000o(false);
        O00000o0 o00000o0 = this.O00000o0;
        o00000o0.O0000OoO = 0;
        o00000o0.O00000o0();
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final RectF f13628O000000o = new RectF();
        final Paint O00000Oo = new Paint();
        final Paint O00000o = new Paint();
        final Paint O00000o0 = new Paint();
        float O00000oO = 0.0f;
        float O00000oo = 0.0f;
        float O0000O0o = 0.0f;
        float O0000OOo = 5.0f;
        int[] O0000Oo;
        float O0000Oo0 = 2.5f;
        public int O0000OoO;
        float O0000Ooo;
        float O0000o;
        float O0000o0;
        float O0000o00;
        boolean O0000o0O;
        Path O0000o0o;
        int O0000oO;
        double O0000oO0;
        int O0000oOO;
        int O0000oOo;
        private final Drawable.Callback O0000oo;
        int O0000oo0;

        public O00000o0(Drawable.Callback callback) {
            this.O0000oo = callback;
            this.O00000Oo.setStrokeCap(Paint.Cap.SQUARE);
            this.O00000Oo.setAntiAlias(true);
            this.O00000Oo.setStyle(Paint.Style.STROKE);
            this.O00000o0.setStyle(Paint.Style.FILL);
            this.O00000o0.setAntiAlias(true);
            this.O00000o.setAntiAlias(true);
        }

        public final void O000000o(int[] iArr) {
            this.O0000Oo = iArr;
            this.O0000OoO = 0;
        }

        public final void O000000o() {
            this.O0000OoO = (this.O0000OoO + 1) % this.O0000Oo.length;
        }

        public final void O000000o(float f) {
            this.O00000oO = f;
            O00000o();
        }

        public final void O00000Oo(float f) {
            this.O00000oo = f;
            O00000o();
        }

        public final void O00000o0(float f) {
            this.O0000O0o = f;
            O00000o();
        }

        public final void O000000o(boolean z) {
            if (this.O0000o0O != z) {
                this.O0000o0O = z;
                O00000o();
            }
        }

        public final void O00000o(float f) {
            if (f != this.O0000o) {
                this.O0000o = f;
                O00000o();
            }
        }

        public final void O00000Oo() {
            this.O0000Ooo = this.O00000oO;
            this.O0000o00 = this.O00000oo;
            this.O0000o0 = this.O0000O0o;
        }

        public final void O00000o0() {
            this.O0000Ooo = 0.0f;
            this.O0000o00 = 0.0f;
            this.O0000o0 = 0.0f;
            O000000o(0.0f);
            O00000Oo(0.0f);
            O00000o0(0.0f);
        }

        /* access modifiers changed from: package-private */
        public final void O00000o() {
            this.O0000oo.invalidateDrawable(null);
        }
    }

    static class O000000o extends AccelerateDecelerateInterpolator {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(long, long):long}
          ClspMth{java.lang.Math.max(float, float):float} */
        public final float getInterpolation(float f) {
            return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
        }
    }

    static class O00000o extends AccelerateDecelerateInterpolator {
        private O00000o() {
        }

        /* synthetic */ O00000o(byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(float, float):float} */
        public final float getInterpolation(float f) {
            return super.getInterpolation(Math.min(1.0f, f * 2.0f));
        }
    }

    class O00000Oo extends OvalShape {
        private RadialGradient O00000Oo;
        private Paint O00000o = new Paint();
        private int O00000o0;
        private int O00000oO;

        public O00000Oo(int i, int i2) {
            this.O00000o0 = i;
            this.O00000oO = i2;
            int i3 = this.O00000oO;
            this.O00000Oo = new RadialGradient((float) (i3 / 2), (float) (i3 / 2), (float) this.O00000o0, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.O00000o.setShader(this.O00000Oo);
        }

        public final void draw(Canvas canvas, Paint paint) {
            float width = (float) (cci.this.getBounds().width() / 2);
            float height = (float) (cci.this.getBounds().height() / 2);
            canvas.drawCircle(width, height, (float) ((this.O00000oO / 2) + this.O00000o0), this.O00000o);
            canvas.drawCircle(width, height, (float) (this.O00000oO / 2), paint);
        }
    }
}
