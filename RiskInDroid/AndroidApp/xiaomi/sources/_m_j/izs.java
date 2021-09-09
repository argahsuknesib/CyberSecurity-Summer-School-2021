package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public final class izs extends izr {
    private float O0000O0o;
    private float O0000OOo;
    private float O0000Oo = 400.0f;
    private float O0000Oo0;
    private float O0000OoO;
    private float O0000Ooo;
    private float O0000o0 = 0.008f;
    private float O0000o00;
    private int O0000o0O = 1;

    public final int getIntrinsicWidth() {
        return 32767;
    }

    public final int getIntrinsicHeight() {
        return (int) Math.max(this.O00000Oo.getStrokeWidth(), this.f1674O000000o.getStrokeWidth());
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0) {
            this.O0000OOo = (float) rect.left;
            this.O0000Oo0 = (float) rect.right;
            this.O0000O0o = (float) rect.centerY();
            this.O0000Oo = (this.O0000Oo0 - this.O0000OOo) * 0.5f;
            if (this.O00000oo != 0.0f) {
                O000000o(this.O00000oo);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int O00000oO() {
        this.O0000o0O++;
        if (this.O0000o0O > 3) {
            this.O0000o0O = 1;
        }
        return super.O00000oO();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(float f) {
        float f2 = this.O0000OOo;
        this.O0000OoO = f2;
        this.O0000Ooo = f2 + ((this.O0000Oo0 - f2) * f);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        float f;
        this.O0000o00 += this.O0000o0;
        float f2 = this.O0000o00;
        if (f2 > 1.0f) {
            this.O0000o00 = f2 - 1.0f;
            O00000oO();
        }
        float f3 = this.O0000o00;
        float f4 = this.O0000Oo;
        float f5 = this.O0000Oo0;
        float f6 = this.O0000OOo;
        float f7 = (f5 - f6) * f3;
        float f8 = f6 + f7;
        int i = this.O0000o0O;
        if (i == 1) {
            f = f3 > 0.5f ? f4 * (1.0f - f3) : f4 * f3;
        } else if (i == 2) {
            f = (f4 * f3) / 2.0f;
            if (f8 + f > f5) {
                f = f5 - f8;
            }
        } else {
            if (f7 + f7 > f4) {
                f7 = f4 / 2.0f;
            }
            f = f7;
            float f9 = this.O0000Oo0;
            if (f8 + f > f9) {
                f = f9 - f8;
            }
        }
        this.O0000OoO = f8 - f;
        this.O0000Ooo = f8 + f;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Canvas canvas, Paint paint) {
        float f = this.O0000OOo;
        float f2 = this.O0000O0o;
        canvas.drawLine(f, f2, this.O0000Oo0, f2, paint);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(Canvas canvas, Paint paint) {
        float f = this.O0000OoO;
        float f2 = this.O0000O0o;
        canvas.drawLine(f, f2, this.O0000Ooo, f2, paint);
    }
}
