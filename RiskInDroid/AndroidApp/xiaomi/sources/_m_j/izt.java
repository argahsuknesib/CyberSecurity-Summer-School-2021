package _m_j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;

public final class izt extends izu implements Animatable {

    /* renamed from: O000000o  reason: collision with root package name */
    public Point f1676O000000o = new Point();
    public float O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public boolean O0000OOo;
    public boolean O0000Oo;
    public boolean O0000Oo0;
    public Runnable O0000OoO = new Runnable() {
        /* class _m_j.izt.AnonymousClass1 */

        public final void run() {
            izt izt = izt.this;
            izt.O0000Oo0 = true;
            izt.invalidateSelf();
            izt.this.O0000Oo = false;
        }
    };
    private int O0000o;
    private int O0000o0O;
    private float O0000o0o;

    public final void start() {
    }

    public izt(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3) {
        super(colorStateList, colorStateList2, colorStateList3);
    }

    public final void O000000o(int i) {
        this.O0000o = i;
        this.O0000o0o = ((float) this.O0000o0O) / ((float) i);
    }

    public final void O00000Oo(int i) {
        if (i < 0) {
            i = 0;
        }
        this.O00000o = i;
    }

    public final void O00000o0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.O00000o0 = i;
    }

    public final void O000000o(float f) {
        int i;
        this.O00000Oo = f;
        int O00000Oo2 = O00000Oo();
        Rect bounds = getBounds();
        if (this.O0000OOo) {
            i = (bounds.right - this.O0000O0o) - O00000Oo2;
        } else {
            i = bounds.left + this.O0000O0o + O00000Oo2;
        }
        this.f1676O000000o.set(i, bounds.centerY());
    }

    public final void O000000o(Rect rect) {
        int i;
        Rect bounds = getBounds();
        int O00000Oo2 = O00000Oo();
        if (this.O0000OOo) {
            i = (bounds.right - this.O0000O0o) - O00000Oo2;
        } else {
            i = bounds.left + this.O0000O0o + O00000Oo2;
        }
        rect.set(i - this.O0000O0o, bounds.top, i + this.O0000O0o, bounds.bottom);
    }

    public final void O000000o() {
        this.O0000Oo0 = false;
        this.O0000Oo = false;
        unscheduleSelf(this.O0000OoO);
        invalidateSelf();
    }

    public final void stop() {
        O000000o();
    }

    public final boolean isRunning() {
        return this.O0000Oo;
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        int i = rect.right - rect.left;
        int i2 = this.O0000O0o;
        this.O0000o0O = (i - i2) - i2;
        this.O0000o0o = ((float) this.O0000o0O) / ((float) this.O0000o);
        O000000o(this.O00000Oo);
    }

    public final int getIntrinsicHeight() {
        return Math.max(Math.max(Math.max(Math.max(this.O00000o0, this.O00000o), this.O00000oO * 2), this.O00000oo * 2), this.O0000O0o * 2);
    }

    private int O00000Oo() {
        return (int) (((float) this.O0000o0O) * this.O00000Oo);
    }

    public final void O000000o(Canvas canvas, Paint paint, int i, int i2, int i3) {
        float f = (float) (this.O00000o0 >> 1);
        float f2 = (float) (this.O00000o >> 1);
        if (this.O0000OOo) {
            O000000o(canvas, paint, i3, i, i2, f, f2);
        } else {
            O000000o(canvas, paint, i3, i2, i, f2, f);
        }
    }

    private void O000000o(Canvas canvas, Paint paint, int i, int i2, int i3, float f, float f2) {
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        int i4 = i2;
        Rect bounds = getBounds();
        int i5 = this.f1676O000000o.x;
        int i6 = this.f1676O000000o.y;
        int i7 = bounds.left + this.O0000O0o;
        int i8 = bounds.right - this.O0000O0o;
        if (f > 0.0f) {
            paint2.setColor(i4);
            float f3 = (float) i6;
            float f4 = f3 + f;
            canvas.drawRect((float) i7, f3 - f, (float) i5, f4, paint);
        }
        if (f2 > 0.0f) {
            paint2.setColor(i3);
            float f5 = (float) i6;
            float f6 = f5 + f2;
            canvas.drawRect((float) i5, f5 - f2, (float) i8, f6, paint);
        }
        if (((float) this.O00000oo) > f2) {
            for (int i9 = 0; i9 <= this.O0000o; i9++) {
                float f7 = ((float) i8) - (((float) i9) * this.O0000o0o);
                if (f7 <= ((float) i5)) {
                    break;
                }
                canvas2.drawCircle(f7, (float) i6, (float) this.O00000oo, paint2);
            }
        }
        if (((float) this.O00000oo) > f) {
            paint2.setColor(i4);
            for (int i10 = 0; i10 <= this.O0000o; i10++) {
                float f8 = (((float) i10) * this.O0000o0o) + ((float) i7);
                if (f8 > ((float) i5)) {
                    break;
                }
                canvas2.drawCircle(f8, (float) i6, (float) this.O00000oo, paint2);
            }
        }
        if (!this.O0000Oo0 && this.O00000oO > 0) {
            paint.setColor(i);
            canvas2.drawCircle((float) i5, (float) i6, (float) this.O00000oO, paint2);
        }
    }
}
