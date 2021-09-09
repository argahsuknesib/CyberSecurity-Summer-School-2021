package _m_j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public final class izl extends izw implements izm {

    /* renamed from: O000000o  reason: collision with root package name */
    public Interpolator f1668O000000o = new AccelerateDecelerateInterpolator();
    public long O00000Oo;
    public int O00000o = 250;
    public boolean O00000o0 = false;
    public final Runnable O00000oO = new Runnable() {
        /* class _m_j.izl.AnonymousClass1 */

        public final void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = uptimeMillis - izl.this.O00000Oo;
            if (j < ((long) izl.this.O00000o)) {
                float interpolation = izl.this.f1668O000000o.getInterpolation(((float) j) / ((float) izl.this.O00000o));
                izl izl = izl.this;
                izl.scheduleSelf(izl.O00000oO, uptimeMillis + 16);
                izl.this.O000000o(interpolation);
                return;
            }
            izl izl2 = izl.this;
            izl2.unscheduleSelf(izl2.O00000oO);
            izl izl3 = izl.this;
            izl3.O00000o0 = false;
            izl3.O000000o(1.0f);
        }
    };
    private float O00000oo = 0.0f;
    private boolean O0000O0o = false;
    private float O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;

    public final void start() {
    }

    public izl(ColorStateList colorStateList) {
        super(colorStateList);
    }

    public final void O000000o(Canvas canvas, Paint paint) {
        int i;
        float f = this.O00000oo;
        if (f > 0.0f) {
            Rect bounds = getBounds();
            float min = ((float) Math.min(bounds.width(), bounds.height())) / 2.0f;
            float centerX = (float) bounds.centerX();
            float centerY = (float) bounds.centerY();
            if (f != 1.0f && (i = this.O0000Oo0) > 0) {
                paint.setAlpha(i);
                canvas.drawCircle(centerX, centerY, min, paint);
            }
            int i2 = this.O0000Oo;
            if (i2 > 0) {
                paint.setAlpha(i2);
                canvas.drawCircle(centerX, centerY, min * f, paint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) {
        super.O000000o(i);
        int alpha = Color.alpha(i);
        this.O0000Oo0 = izh.O000000o(alpha, (int) NotificationCompat.FLAG_HIGH_PRIORITY);
        if (alpha < 255) {
            int i2 = this.O0000Oo0;
            this.O0000Oo = i2 > alpha ? 0 : ((alpha - i2) * 255) / (255 - i2);
            return;
        }
        this.O0000Oo = alpha;
    }

    public final boolean setState(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        boolean z = false;
        for (int i : getState()) {
            if (i == 16842919) {
                z = true;
            }
        }
        boolean state = super.setState(iArr);
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 : iArr) {
            if (i2 == 16842908) {
                z3 = true;
            } else if (i2 == 16842919) {
                z2 = true;
            }
        }
        if (z2) {
            unscheduleSelf(this.O00000oO);
            float f = this.O00000oo;
            if (f < 1.0f) {
                this.O0000O0o = false;
                this.O00000o0 = true;
                this.O0000OOo = f;
                this.O00000o = (int) ((1.0f - this.O0000OOo) * 250.0f);
                this.O00000Oo = SystemClock.uptimeMillis();
                scheduleSelf(this.O00000oO, this.O00000Oo + 16);
            }
        } else if (z) {
            unscheduleSelf(this.O00000oO);
            float f2 = this.O00000oo;
            if (f2 > 0.0f) {
                this.O0000O0o = true;
                this.O00000o0 = true;
                this.O0000OOo = f2;
                this.O00000o = (int) (this.O0000OOo * 250.0f);
                this.O00000Oo = SystemClock.uptimeMillis();
                scheduleSelf(this.O00000oO, this.O00000Oo + 16);
            }
        } else if (z3) {
            this.O00000oo = 1.0f;
            invalidateSelf();
        } else {
            this.O00000oo = 0.0f;
            invalidateSelf();
        }
        return state;
    }

    public final void O000000o(float f) {
        float f2 = this.O0000OOo;
        this.O00000oo = f2 + (((this.O0000O0o ? 0.0f : 1.0f) - f2) * f);
        invalidateSelf();
    }

    public final void stop() {
        unscheduleSelf(this.O00000oO);
    }

    public final boolean isRunning() {
        return this.O00000o0;
    }
}
