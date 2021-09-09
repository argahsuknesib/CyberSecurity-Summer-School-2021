package _m_j;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public abstract class izr extends Drawable implements izm, Animatable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Paint f1674O000000o = new Paint(1);
    protected Paint O00000Oo = new Paint(1);
    public int[] O00000o = {-872415232, -100251, -8117352};
    public boolean O00000o0;
    public int O00000oO = 0;
    protected float O00000oo;
    private final Runnable O0000O0o = new Runnable() {
        /* class _m_j.izr.AnonymousClass1 */

        public final void run() {
            if (izr.this.O00000o0) {
                izr.this.O000000o();
                izr.this.invalidateSelf();
                return;
            }
            izr.this.unscheduleSelf(this);
        }
    };

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    /* access modifiers changed from: protected */
    public abstract void O000000o(float f);

    /* access modifiers changed from: protected */
    public abstract void O000000o(Canvas canvas, Paint paint);

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(Canvas canvas, Paint paint);

    public izr() {
        Paint paint = this.O00000Oo;
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeWidth(4.0f);
        paint.setColor(838860800);
        Paint paint2 = this.f1674O000000o;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStrokeWidth(4.0f);
        paint2.setColor(this.O00000o[0]);
    }

    public int getIntrinsicHeight() {
        return (int) (Math.max(this.O00000Oo.getStrokeWidth(), this.f1674O000000o.getStrokeWidth()) * 2.0f);
    }

    public int getIntrinsicWidth() {
        return (int) (Math.max(this.O00000Oo.getStrokeWidth(), this.f1674O000000o.getStrokeWidth()) * 2.0f);
    }

    public final void O00000Oo(float f) {
        this.O00000Oo.setStrokeWidth(f);
        onBoundsChange(getBounds());
    }

    public final void O00000o0(float f) {
        this.f1674O000000o.setStrokeWidth(f);
        onBoundsChange(getBounds());
    }

    public final float O00000Oo() {
        return this.O00000Oo.getStrokeWidth();
    }

    public final float O00000o0() {
        return this.f1674O000000o.getStrokeWidth();
    }

    public final void O000000o(int i) {
        this.O00000Oo.setColor(i);
    }

    public final int O00000o() {
        return this.O00000Oo.getColor();
    }

    public int O00000oO() {
        int[] iArr = this.O00000o;
        Paint paint = this.f1674O000000o;
        if (iArr.length > 1) {
            int i = this.O00000oO + 1;
            if (i >= iArr.length) {
                i = 0;
            }
            paint.setColor(iArr[i]);
            this.O00000oO = i;
        } else {
            paint.setColor(iArr[0]);
        }
        return paint.getColor();
    }

    public final float O00000oo() {
        return this.O00000oo;
    }

    public final void O00000o(float f) {
        if (f < 0.0f) {
            this.O00000oo = 0.0f;
        } else if (this.O00000oo > 1.0f) {
            this.O00000oo = 1.0f;
        } else {
            this.O00000oo = f;
        }
        stop();
        O000000o(this.O00000oo);
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.O00000o0;
    }

    public void start() {
        if (!this.O00000o0) {
            this.O00000o0 = true;
            scheduleSelf(this.O0000O0o, SystemClock.uptimeMillis() + 16);
        }
    }

    public void stop() {
        if (this.O00000o0) {
            this.O00000o0 = false;
            unscheduleSelf(this.O0000O0o);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        Paint paint = this.O00000Oo;
        if (paint.getColor() != 0 && paint.getStrokeWidth() > 0.0f) {
            O000000o(canvas, paint);
        }
        Paint paint2 = this.f1674O000000o;
        if (this.O00000o0) {
            if (paint2.getColor() != 0 && paint2.getStrokeWidth() > 0.0f) {
                O00000Oo(canvas, paint2);
            }
            scheduleSelf(this.O0000O0o, SystemClock.uptimeMillis() + 16);
        } else if (this.O00000oo > 0.0f && paint2.getColor() != 0 && paint2.getStrokeWidth() > 0.0f) {
            O00000Oo(canvas, paint2);
        }
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f1674O000000o.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        boolean z;
        Paint paint = this.O00000Oo;
        if (paint.getColorFilter() != colorFilter) {
            paint.setColorFilter(colorFilter);
            z = true;
        } else {
            z = false;
        }
        Paint paint2 = this.f1674O000000o;
        if (paint2.getColorFilter() != colorFilter) {
            paint2.setColorFilter(colorFilter);
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    public int getOpacity() {
        Paint paint = this.O00000Oo;
        Paint paint2 = this.f1674O000000o;
        if (paint.getXfermode() != null || paint2.getXfermode() != null) {
            return -3;
        }
        int alpha = Color.alpha(paint2.getColor());
        if (alpha == 0) {
            return -2;
        }
        return alpha == 255 ? -1 : -3;
    }
}
