package _m_j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public final class izn extends izw implements izm {

    /* renamed from: O000000o  reason: collision with root package name */
    public Path f1670O000000o = new Path();
    RectF O00000Oo = new RectF();
    public Interpolator O00000o = new AccelerateDecelerateInterpolator();
    Matrix O00000o0 = new Matrix();
    public long O00000oO;
    public boolean O00000oo = false;
    public int O0000O0o = 250;
    public float O0000OOo = 0.0f;
    public O000000o O0000Oo;
    public int O0000Oo0;
    public final Runnable O0000OoO = new Runnable() {
        /* class _m_j.izn.AnonymousClass1 */

        public final void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = uptimeMillis - izn.this.O00000oO;
            if (j < ((long) izn.this.O0000O0o)) {
                float interpolation = izn.this.O00000o.getInterpolation(((float) j) / ((float) izn.this.O0000O0o));
                izn izn = izn.this;
                izn.scheduleSelf(izn.O0000OoO, uptimeMillis + 16);
                izn.this.O000000o(interpolation);
                return;
            }
            izn izn2 = izn.this;
            izn2.unscheduleSelf(izn2.O0000OoO);
            izn izn3 = izn.this;
            izn3.O00000oo = false;
            izn3.O000000o(1.0f);
            izn.this.O00000o0();
        }
    };
    private float O0000o;
    private float O0000o0O = 0.0f;
    private boolean O0000o0o = false;
    private int O0000oO;
    private int O0000oO0;
    private int O0000oOO;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    public final void start() {
    }

    public izn(ColorStateList colorStateList) {
        super(colorStateList);
        O00000o().setStyle(Paint.Style.FILL);
    }

    public final void O000000o(ColorStateList colorStateList) {
        super.O000000o(colorStateList);
        this.O0000oO = colorStateList.getDefaultColor();
        this.O0000oO0 = colorStateList.getColorForState(new int[]{16842919}, this.O0000oO);
    }

    public final void O000000o(Canvas canvas, Paint paint) {
        if (!this.f1670O000000o.isEmpty()) {
            paint.setColor(this.O0000oOO);
            canvas.drawPath(this.f1670O000000o, paint);
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        O000000o(rect);
    }

    private void O000000o(Rect rect) {
        float f = this.O0000o0O;
        Path path = this.f1670O000000o;
        RectF rectF = this.O00000Oo;
        Matrix matrix = this.O00000o0;
        path.reset();
        int min = Math.min(rect.width(), rect.height());
        float f2 = this.O0000OOo;
        float f3 = f2 + ((((float) min) - f2) * f);
        float f4 = f3 / 2.0f;
        float f5 = 1.0f - f;
        float f6 = f4 * f5;
        rectF.set((float) rect.left, (float) rect.top, ((float) rect.left) + f3, ((float) rect.top) + f3);
        path.addRoundRect(rectF, new float[]{f4, f4, f4, f4, f4, f4, f6, f6}, Path.Direction.CCW);
        matrix.reset();
        matrix.postRotate(-45.0f, ((float) rect.left) + f4, ((float) rect.top) + f4);
        matrix.postTranslate((((float) rect.width()) - f3) / 2.0f, 0.0f);
        matrix.postTranslate(0.0f, ((((float) rect.bottom) - f3) - ((float) this.O0000Oo0)) * f5);
        path.transform(matrix);
    }

    public final void O000000o(float f) {
        float f2 = this.O0000o;
        this.O0000o0O = f2 + (((this.O0000o0o ? 0.0f : 1.0f) - f2) * f);
        int i = this.O0000oO0;
        int i2 = this.O0000oO;
        float f3 = this.O0000o0O;
        float f4 = 1.0f - f3;
        this.O0000oOO = Color.argb((int) ((((float) Color.alpha(i)) * f3) + (((float) Color.alpha(i2)) * f4)), (int) ((((float) Color.red(i)) * f3) + (((float) Color.red(i2)) * f4)), (int) ((((float) Color.green(i)) * f3) + (((float) Color.green(i2)) * f4)), (int) ((((float) Color.blue(i)) * f3) + (((float) Color.blue(i2)) * f4)));
        O000000o(getBounds());
        invalidateSelf();
    }

    public final void O000000o() {
        unscheduleSelf(this.O0000OoO);
        this.O0000o0o = false;
        float f = this.O0000o0O;
        if (f < 1.0f) {
            this.O00000oo = true;
            this.O0000o = f;
            this.O0000O0o = (int) ((1.0f - f) * 250.0f);
            this.O00000oO = SystemClock.uptimeMillis();
            scheduleSelf(this.O0000OoO, this.O00000oO + 16);
            return;
        }
        O00000o0();
    }

    public final void O00000Oo() {
        this.O0000o0o = true;
        unscheduleSelf(this.O0000OoO);
        float f = this.O0000o0O;
        if (f > 0.0f) {
            this.O00000oo = true;
            this.O0000o = f;
            this.O0000O0o = 250 - ((int) ((1.0f - f) * 250.0f));
            this.O00000oO = SystemClock.uptimeMillis();
            scheduleSelf(this.O0000OoO, this.O00000oO + 16);
            return;
        }
        O00000o0();
    }

    public final void O00000o0() {
        O000000o o000000o = this.O0000Oo;
        if (o000000o == null) {
            return;
        }
        if (this.O0000o0o) {
            o000000o.O000000o();
        } else {
            o000000o.O00000Oo();
        }
    }

    public final void stop() {
        unscheduleSelf(this.O0000OoO);
    }

    public final boolean isRunning() {
        return this.O00000oo;
    }
}
