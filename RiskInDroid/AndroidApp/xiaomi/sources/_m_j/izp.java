package _m_j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public final class izp extends izo implements izm {
    public final Interpolator O00000oO = new DecelerateInterpolator(0.8f);
    public long O00000oo;
    public int O0000O0o = 250;
    public boolean O0000OOo = false;
    public int O0000Oo = 4;
    public int O0000Oo0 = 4;
    public int O0000OoO = 50;
    public final Runnable O0000Ooo = new Runnable() {
        /* class _m_j.izp.AnonymousClass1 */

        public final void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = uptimeMillis - izp.this.O00000oo;
            if (j < ((long) izp.this.O0000O0o)) {
                float interpolation = izp.this.O00000oO.getInterpolation(((float) j) / ((float) izp.this.O0000O0o));
                izp izp = izp.this;
                izp.scheduleSelf(izp.O0000Ooo, uptimeMillis + 16);
                izp.this.O000000o(interpolation);
                return;
            }
            izp izp2 = izp.this;
            izp2.unscheduleSelf(izp2.O0000Ooo);
            izp izp3 = izp.this;
            izp3.O0000OOo = false;
            izp3.O000000o(1.0f);
        }
    };
    private int O0000o;
    private Paint O0000o0;
    private Paint O0000o00 = new Paint(1);
    private RectF O0000o0O = new RectF();
    private int O0000o0o;
    private int O0000oO;
    private boolean O0000oO0;
    private float O0000oOO;
    private int O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private float O0000ooO = 0.0f;
    private float O0000ooo;

    public izp(ColorStateList colorStateList) {
        super(colorStateList);
        this.O0000o00.setStyle(Paint.Style.FILL);
        this.O0000o00.setAntiAlias(true);
        this.O0000o00.setDither(true);
        this.O0000o0 = new Paint();
        this.O0000o0.setStyle(Paint.Style.STROKE);
        this.O0000o0.setStrokeJoin(Paint.Join.ROUND);
        this.O0000o0.setStrokeCap(Paint.Cap.ROUND);
        this.O0000o0.setAntiAlias(true);
        this.O0000o0.setDither(true);
        this.O0000o0.setStrokeWidth((float) this.O0000Oo0);
        onStateChange(getState());
        O000000o(O000000o(), this.O00000Oo, this.O00000Oo);
        O00000Oo();
    }

    public final void O00000Oo(int i) {
        if (this.O0000Oo0 != i) {
            this.O0000Oo0 = i;
            this.O0000o0.setStrokeWidth((float) this.O0000Oo0);
            O00000Oo();
            invalidateSelf();
        }
    }

    public final void O00000o0(int i) {
        if (this.O0000Oo != i) {
            this.O0000Oo = i;
            O00000Oo();
            invalidateSelf();
        }
    }

    public final void O000000o(int i, boolean z) {
        if (this.O0000OoO != i || this.O0000oO0 != z) {
            this.O0000OoO = i;
            this.O0000oO0 = z;
            O00000Oo();
            invalidateSelf();
        }
    }

    private void O00000Oo() {
        if (!this.O0000oO0) {
            int i = (this.O0000Oo0 + this.O0000Oo) * 2;
            Rect bounds = getBounds();
            int width = bounds.width();
            int height = bounds.height();
            if (width <= 0 || height <= 0) {
                int max = Math.max(width, height);
                if (max > 0) {
                    this.O0000OoO = max;
                }
            } else {
                this.O0000OoO = Math.min(width, height);
            }
            this.O0000OoO = Math.max(this.O0000OoO, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, boolean z, boolean z2) {
        if (z != z2) {
            if (z2) {
                this.O0000oOo = i;
            } else {
                this.O0000oo = i;
            }
            start();
            return;
        }
        this.O0000oo = i;
        this.O0000oOo = i;
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (!this.O0000oO0) {
            O00000Oo();
        }
        if (!rect.isEmpty()) {
            this.O0000o0o = rect.centerX();
            this.O0000o = rect.centerY();
            int min = Math.min(rect.width(), rect.height()) >> 1;
            int i = min - ((this.O0000Oo0 + 1) >> 1);
            RectF rectF = this.O0000o0O;
            int i2 = this.O0000o0o;
            int i3 = this.O0000o;
            rectF.set((float) (i2 - i), (float) (i3 - i), (float) (i2 + i), (float) (i3 + i));
            this.O0000oO = (min - this.O0000Oo0) - this.O0000Oo;
        }
    }

    public final int getIntrinsicWidth() {
        return this.O0000OoO;
    }

    public final int getIntrinsicHeight() {
        return this.O0000OoO;
    }

    public final void start() {
        if (!this.O00000o) {
            unscheduleSelf(this.O0000Ooo);
            this.O0000OOo = true;
            this.O0000ooo = this.O0000ooO;
            this.O0000O0o = (int) ((this.O00000Oo ? 1.0f - this.O0000ooO : this.O0000ooO) * 250.0f);
            this.O00000oo = SystemClock.uptimeMillis();
            scheduleSelf(this.O0000Ooo, this.O00000oo + 16);
        }
    }

    public final void stop() {
        unscheduleSelf(this.O0000Ooo);
    }

    public final boolean isRunning() {
        return this.O0000OOo;
    }

    public final void draw(Canvas canvas) {
        int i;
        this.O0000o0.setColor(this.O0000oo);
        canvas.drawArc(this.O0000o0O, 0.0f, 360.0f, false, this.O0000o0);
        if (this.O0000oOO > 0.0f && (i = this.O0000oOo) != 0) {
            this.O0000o0.setColor(i);
            canvas.drawArc(this.O0000o0O, 0.0f, this.O0000oOO, false, this.O0000o0);
            this.O0000o00.setColor(this.O0000oOo);
            this.O0000o00.setAlpha(this.O0000oo0);
            canvas.drawCircle((float) this.O0000o0o, (float) this.O0000o, (float) this.O0000oO, this.O0000o00);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        boolean z;
        Paint paint = this.O0000o00;
        Paint paint2 = this.O0000o0;
        if (paint == null || paint.getColorFilter() == colorFilter) {
            z = false;
        } else {
            paint.setColorFilter(colorFilter);
            z = true;
        }
        if (!(paint2 == null || paint2.getColorFilter() == colorFilter)) {
            paint2.setColorFilter(colorFilter);
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    public final int getOpacity() {
        Paint paint = this.O0000o00;
        Paint paint2 = this.O0000o0;
        if (paint.getXfermode() != null || paint2.getXfermode() != null) {
            return -3;
        }
        int alpha = Color.alpha(O000000o());
        if (alpha == 0) {
            return -2;
        }
        return alpha == 255 ? -1 : -3;
    }

    public final void O000000o(float f) {
        float f2 = this.O0000ooo;
        this.O0000ooO = f2 + (((this.O00000Oo ? 1.0f : 0.0f) - f2) * f);
        float f3 = this.O0000ooO;
        this.O0000oOO = 360.0f * f3;
        this.O0000oo0 = izh.O000000o(Color.alpha(this.O0000oOo), (int) (f3 * 255.0f));
        invalidateSelf();
    }
}
